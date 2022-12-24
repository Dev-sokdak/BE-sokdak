package com.example.devsokdak.comment.service;

import com.example.devsokdak.board.entity.Board;
import com.example.devsokdak.board.repository.BoardRepository;
import com.example.devsokdak.comment.dto.CommentRequestDto;
import com.example.devsokdak.comment.dto.CommentResponseDto;
import com.example.devsokdak.comment.entity.Comment;
import com.example.devsokdak.comment.repository.CommentRepository;
import com.example.devsokdak.global.MsgResponseDto;
import com.example.devsokdak.global.exception.CustomException;
import com.example.devsokdak.global.exception.ErrorCode;
import com.example.devsokdak.global.exception.SuccessCode;
import com.example.devsokdak.user.entity.User;
import com.example.devsokdak.user.entity.UserRoleEnum;
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
