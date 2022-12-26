package com.example.sokdak.board.service;


import com.example.sokdak.board.dto.BoardRequestDto;
import com.example.sokdak.board.dto.BoardResponseDto;
import com.example.sokdak.board.entity.Board;
import com.example.sokdak.board.entity.BoardLike;
import com.example.sokdak.board.entity.InterestTag;
import com.example.sokdak.board.repository.BoardRepository;
import com.example.sokdak.board.repository.LikeRepository;
import com.example.sokdak.comment.dto.CommentResponseDto;
import com.example.sokdak.comment.entity.Comment;
import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.exception.CustomException;
import com.example.sokdak.global.exception.ErrorCode;
import com.example.sokdak.global.exception.S3.S3Uploader;
import com.example.sokdak.global.exception.SuccessCode;
import com.example.sokdak.user.entity.User;
import com.example.sokdak.user.entity.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final LikeRepository likeRepository;
    private final S3Uploader s3Uploader;


    //게시글 생성
    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto requestDto, User user, MultipartFile multipartFile) throws IOException {
        String image = null;
        if (!multipartFile.isEmpty()) {
            image=s3Uploader.upload( multipartFile, "static");
        }
        Board board = boardRepository.save(new Board(requestDto, user,image));

        return new BoardResponseDto(board, image);
    }

    //게시글 전체 출력
    @Transactional(readOnly = true)
    public List<BoardResponseDto> getListBoards() {
        List<Board> boardList = boardRepository.findAllByOrderByCreatedAtDesc();
        List<BoardResponseDto> boardResponseDto = new ArrayList<>();

        for (Board board : boardList) {
            String image = board.getImage();
            List<CommentResponseDto> commentList = new ArrayList<>();
            for (Comment comment : board.getCommentList()) {
                commentList.add(new CommentResponseDto(comment));
            }

            boardResponseDto.add(new BoardResponseDto(board, commentList, image));
        }
        return boardResponseDto;
    }
    //카테고리 별 게시글 출력
    public List<BoardResponseDto> getCategoryBoards(int interestTag) {
        if (InterestTag.valueOfInterestTag(interestTag) == null) {
            throw new CustomException(ErrorCode.NO_EXIST_LOCAL);
        }
        List<Board> boardList = new ArrayList<>();
        Board board = boardRepository.findByCategory(interestTag);
        boardList.add(board);

        List<BoardResponseDto> boardResponseDto = new ArrayList<>();
        for (Board boards : boardList) {
            String image = boards.getImage();
            List<CommentResponseDto> commentList = new ArrayList<>();
            for (Comment comment : boards.getCommentList()) {
                commentList.add(new CommentResponseDto(comment));
            }
            boardResponseDto.add(new BoardResponseDto(boards, commentList, image));
        }
        return boardResponseDto;
    }
    //게시글 상세 페이지
    @Transactional(readOnly = true)
    public BoardResponseDto getBoard(Long id, User user) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NO_BOARD_FOUND)
        );
        String image = board.getImage();
        List<CommentResponseDto> commentList = new ArrayList<>();
        for (Comment comment : board.getCommentList()) {
            commentList.add(new CommentResponseDto(comment));
        }
        return new BoardResponseDto(board, commentList,image);
    }
    //게시글 업데이트 /*이미지 수정 필요*/
    @Transactional
    public BoardResponseDto updateBoard(User user, Long id, BoardRequestDto requestDto,MultipartFile multipartFile) throws IOException {
        Board board;
        if (user.getRole().equals(UserRoleEnum.ADMIN)) {
            board = boardRepository.findById(id).orElseThrow(
                    () -> new CustomException(ErrorCode.NO_BOARD_FOUND)
            );
        } else {
            board = boardRepository.findByIdAndNickname(id, user.getNickname()).orElseThrow(
                    () -> new CustomException(ErrorCode.NO_BOARD_FOUND)
            );
        }
        board.update(requestDto);

        List<CommentResponseDto> commentList = new ArrayList<>();
        for (Comment comment : board.getCommentList()) {
            commentList.add(new CommentResponseDto(comment));
        }
        if (InterestTag.valueOfInterestTag(requestDto.getCategory()) == null) {
            throw new CustomException(ErrorCode.NO_EXIST_LOCAL);
        }


        String image = null;
            if (!multipartFile.isEmpty()) { // 사진이 수정된 경우
                image=(s3Uploader.upload(multipartFile, "static")); // 새로들어온 이미지 s3 저장

                Board board1 = boardRepository.findById(id).orElseThrow();

                s3Uploader.delete(board1.getImage(), "static");

                board1.update(image);

        }
        return new BoardResponseDto(board, commentList, image);
    }
    //게시글 삭제 /*이미지 부분 수정 필요*/
    @Transactional
    public void deleteBoard(Long id, User user) {
        Board board;
        if (user.getRole().equals(UserRoleEnum.ADMIN)) {
            board = boardRepository.findById(id).orElseThrow(
                    () -> new CustomException(ErrorCode.NO_BOARD_FOUND)
            );
        } else {
            board = boardRepository.findByIdAndNickname(id, user.getNickname()).orElseThrow(
                    () -> new CustomException(ErrorCode.NO_BOARD_FOUND)
            );
        }
        Board board1 = boardRepository.findById(id).orElseThrow();

        s3Uploader.delete(board1.getImage(), "static");

        boardRepository.delete(board);
    }

    @Transactional(readOnly = true)
    public boolean checkBoardLike(Long boardId, User user) {
        Optional<BoardLike> Like = likeRepository.findByBoardIdAndUserId(boardId, user.getId());
        return Like.isPresent();
    }

    @Transactional
    public MsgResponseDto saveBoardLike(Long boardId, User user) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new CustomException(ErrorCode.NO_BOARD_FOUND)
        );
        if (checkBoardLike(boardId, user)) {
            throw new CustomException(ErrorCode.ALREADY_CLICKED_LIKE);
        }
        likeRepository.saveAndFlush(new BoardLike(board, user));
        return new MsgResponseDto(SuccessCode.LIKE);
    }

    @Transactional
    public MsgResponseDto cancelBoardLike(Long boardId, User user) {
        boardRepository.findById(boardId).orElseThrow(
                () -> new CustomException(ErrorCode.NO_BOARD_FOUND)
        );
        if (!checkBoardLike(boardId, user)) {
            throw new CustomException(ErrorCode.ALERADY_CANCEL_LIKE);
        }
        likeRepository.deleteByBoardIdAndUserId(boardId, user.getId());
        return new MsgResponseDto(SuccessCode.CANCEL_LIKE);
    }
}
