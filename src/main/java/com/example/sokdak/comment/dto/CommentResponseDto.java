package com.example.sokdak.comment.dto;


import com.example.sokdak.comment.entity.Comment;
import com.example.sokdak.user.entity.CareerTag;
import com.example.sokdak.user.entity.JobTag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long commentId;
    private Long boardId;
    private String nickname;
    private String comment;
    private int userCareerTag;
    private int userJobTag;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;
    private Boolean commentIscorrect;

    //생성자
    public CommentResponseDto(Comment comment) {
        this.boardId = comment.getBoard().getId();
        this.commentId = comment.getId();
        this.nickname = comment.getUser().getNickname();
        this.userCareerTag = CareerTag.valueOfCareerTag(comment.getUser().getCareerTag()).getCareerTag();
        this.userJobTag = JobTag.valueOfJobTag(comment.getUser().getJobTag()).getJobTag();
        this.comment = comment.getContent();
        this.modifiedAt = comment.getModifiedAt();
        this.createdAt = comment.getModifiedAt();
    }

    public CommentResponseDto(Comment comment, Boolean commentIscorrect) {
        this.boardId = comment.getBoard().getId();
        this.commentId = comment.getId();
        this.nickname = comment.getUser().getNickname();
        this.userCareerTag = CareerTag.valueOfCareerTag(comment.getUser().getCareerTag()).getCareerTag();
        this.userJobTag = JobTag.valueOfJobTag(comment.getUser().getJobTag()).getJobTag();
        this.comment = comment.getContent();
        this.modifiedAt = comment.getModifiedAt();
        this.createdAt = comment.getModifiedAt();
        this.commentIscorrect = commentIscorrect;
    }
}
