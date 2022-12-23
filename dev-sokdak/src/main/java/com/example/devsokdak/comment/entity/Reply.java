package com.example.devsokdak.comment.entity;

import com.example.devsokdak.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Replies")
@Getter
@NoArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String comment;                                             // 댓글 내용

    @ManyToOne
    @JoinColumn(name = "Board_Id", nullable = false)
    private Board board;                                                // 게시글 Id

    public Reply(String comment, Board board){
        this.comment = comment;
        this.board = board;
    }
}
