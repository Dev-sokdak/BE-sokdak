package com.example.devsokdak.comment.entity;

import com.example.devsokdak.board.entity.Board;
import com.example.devsokdak.comment.dto.CommentRequestDto;
import com.example.devsokdak.global.entity.TimeStamped;
import com.example.devsokdak.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Comments")
@Getter
@NoArgsConstructor
public class Comment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userId;                                             // 댓글 작성자

    @Column(nullable = false)
    private String content;                                             // 댓글 내용

    @ManyToOne
    @JoinColumn(name = "Board_Id", nullable = false)
    private Board board;                                                // 게시글 Id

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Comment(CommentRequestDto commentRequestDto, Board board, User user){
        this.content = commentRequestDto.getComment();
        this.userId = user.getUserId();
        this.board = board;
        this.user = user;
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.content = commentRequestDto.getComment();
    }
}
