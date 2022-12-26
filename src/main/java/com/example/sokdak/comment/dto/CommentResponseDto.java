package com.example.sokdak.comment.dto;


import com.example.sokdak.comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long commentId;
    private Long boardId;
    private String userId;
    private String comment;
    private LocalDateTime modifiedat;
    private LocalDateTime createdat;

    //생성자
    public CommentResponseDto(Comment comment) {
        this.boardId = comment.getBoard().getId();
        this.commentId = comment.getId();
        this.userId = comment.getUserId();
        this.comment = comment.getContent();
        this.modifiedat = comment.getModifiedAt();
        this.createdat = comment.getModifiedAt();
    }
}
