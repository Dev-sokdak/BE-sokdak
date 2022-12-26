package com.example.sokdak.comment.service;


import com.example.sokdak.board.entity.Board;
import com.example.sokdak.board.repository.BoardRepository;
import com.example.sokdak.comment.dto.CommentRequestDto;
import com.example.sokdak.comment.dto.CommentResponseDto;
import com.example.sokdak.comment.entity.Comment;
import com.example.sokdak.comment.repositroy.CommentRepository;
import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.exception.CustomException;
import com.example.sokdak.global.exception.ErrorCode;
import com.example.sokdak.global.exception.SuccessCode;
import com.example.sokdak.user.entity.User;
import com.example.sokdak.user.entity.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public CommentResponseDto saveComment(Long id, CommentRequestDto commentRequestDto, User user) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NO_BOARD_FOUND)
        );

        Comment comment = new Comment(commentRequestDto, board, user);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    public CommentResponseDto updateComment(Long id, Long commentId, CommentRequestDto commentRequestDto, User user) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NO_BOARD_FOUND));

        Comment comment;
        if (user.getRole().equals(UserRoleEnum.ADMIN)) {
            // ADMIN 권한일 때
            comment = commentRepository.findById(commentId).orElseThrow(() -> new CustomException(ErrorCode.NO_EXIST_COMMENT));
        } else {
            // User 권한일 때
            comment = commentRepository.findByIdAndUserId(commentId, user.getId()).orElseThrow(() -> new CustomException(ErrorCode.NO_MODIFY_COMMENT));

        }
        comment.update(commentRequestDto);
        return new CommentResponseDto(comment);
    }

    public MsgResponseDto deleteComment(Long id, Long commentId, User user) {
        boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NO_BOARD_FOUND));

        Comment comment;
        if (user.getRole().equals(UserRoleEnum.ADMIN)) {
            // ADMIN 권한일 때
            comment = commentRepository.findById(commentId).orElseThrow(() -> new CustomException(ErrorCode.NO_EXIST_COMMENT));
        } else {
            // User 권한일 때
            comment = commentRepository.findByIdAndUserId(commentId, user.getId()).orElseThrow(() -> new CustomException(ErrorCode.NO_DELETE_COMMENT));
        }

        commentRepository.delete(comment);
        return new MsgResponseDto(SuccessCode.DELETE_COMMENT);
    }
}
