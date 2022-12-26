package com.example.sokdak.board.entity;


import com.example.sokdak.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "BoardLike")
@Getter
@NoArgsConstructor
public class BoardLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)                   // category(n) <-> User(1) 단방향 관계
    private User user;                                                // 좋아요 사용자 Id

    @ManyToOne
    @JoinColumn(name = "Board_Id", nullable = false)                  // category(n) <-> Board(1) 단방향 관계
    private Board board;                                              // 좋아요 게시물 Id

    public BoardLike(Board board, User user) {
        this.board = board;
        this.user = user;
    }
}