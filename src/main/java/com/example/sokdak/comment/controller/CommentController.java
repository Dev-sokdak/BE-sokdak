package com.example.sokdak.comment.controller;


import com.example.sokdak.comment.dto.CommentRequestDto;
import com.example.sokdak.comment.dto.CommentResponseDto;
import com.example.sokdak.comment.service.CommentService;
import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class CommentController {
    public final CommentService commentService;

    // 댓글 생성
    @PostMapping("/{boardId}/comment")
    public CommentResponseDto saveComment(@PathVariable Long boardId, @RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return commentService.saveComment(boardId, commentRequestDto, userDetailsImpl.getUser());
    }

    // 댓글 삭제 (관리자는 모든 댓글 삭제 가능. 일반회원은 본인글만 삭제 가능)
    @DeleteMapping("/{boardId}/comment/{commentId}")
    public MsgResponseDto deleteComment(@PathVariable Long boardId, @PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return commentService.deleteComment(boardId, commentId, userDetailsImpl.getUser());
    }
}
