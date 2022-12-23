package com.example.devsokdak.board.entity;

import com.example.devsokdak.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "likes")
@Getter
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)                   // category(n) <-> User(1) 단방향 관계
    private User user;                                                // 좋아요 사용자 Id

    @ManyToOne
    @JoinColumn(name = "Board_Id", nullable = false)                  // category(n) <-> Board(1) 단방향 관계
    private Board board;                                              // 좋아요 게시물 Id

    public Like(Board board, User user) {
        this.board = board;
        this.user = user;
    }
}
