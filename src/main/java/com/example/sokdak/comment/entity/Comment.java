package com.example.sokdak.comment.entity;


import com.example.sokdak.board.entity.Board;
import com.example.sokdak.comment.dto.CommentRequestDto;
import com.example.sokdak.global.entity.TimeStamped;
import com.example.sokdak.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Comments")
@Getter
@NoArgsConstructor
public class Comment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;                                             // 댓글 작성자

    @Column(nullable = false)
    private String content;                                             // 댓글 내용

    @ManyToOne
    @JoinColumn(name = "Board_Id", nullable = false)
    private Board board;                                                // 게시글 Id

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private User user;

    public Comment(CommentRequestDto commentRequestDto, Board board, User user){
        this.content = commentRequestDto.getComment();
        this.userId = user.getUserId();
        this.board = board;
        this.user = user;
    }

}