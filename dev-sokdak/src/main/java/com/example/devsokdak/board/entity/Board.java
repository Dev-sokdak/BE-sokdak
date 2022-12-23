package com.example.devsokdak.board.entity;

import com.example.devsokdak.comment.entity.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity(name = "boards")
@Getter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;                                    // 글 제목

    @Column(nullable = false)
    private String content;                                  // 글 내용

    @Column(nullable = false)
    private String nickname;                                 // 작성자 닉네임

    @Column(nullable = false)                               // 게시판 이미지는 0개 이상, 1개 이하로 Null 값 허용
    private String image;                                   // s3 Upload Url

    @OneToMany(mappedBy = "board")                          // Board(1) <-> reply(n) 양방향 관계
    private List<Reply> replyList;

    @OneToMany(mappedBy = "board")                          // Board(1) <-> category(n) 양방향 관계
    private List<Category> categoryList;

    public Board(String title, String content, String nickname, String image, List<Reply> replyList, List<Category> categoryList) {
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.image = image;
        this.replyList = replyList;
        this.categoryList = categoryList;
    }
}
