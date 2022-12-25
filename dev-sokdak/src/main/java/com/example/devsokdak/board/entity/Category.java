package com.example.devsokdak.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "categories")
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Board_Id", nullable = false)                    // board(1) <-> category(n) 양방향 관계
    private Board board;                                                // 게시글 Id

    @Column(nullable = false)
    private int interestTag;                                            // 카테고리 태그

    public Category(Board board, int interestTag){
        this.board = board;
        this.interestTag = interestTag;
    }
}
