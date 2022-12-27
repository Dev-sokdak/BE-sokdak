package com.example.sokdak.board.entity;


import com.example.sokdak.board.dto.BoardRequestDto;
import com.example.sokdak.comment.entity.Comment;
import com.example.sokdak.global.entity.TimeStamped;
import com.example.sokdak.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity(name = "boards")
@Getter
@NoArgsConstructor
public class Board extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;                                    // 글 제목
    @Column(nullable = false)
    private String content;                                  // 글 내용
    @Column
    private String nickname;                                 // 작성자 닉네임
    @Column(nullable = false)                               // 게시판 이미지는 0개 이상, 1개 이하로 Null 값 허용
    private String image;                                   // s3 Upload Url
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)// Board(1) <-> reply(n) 양방향 관계
    private List<Comment> commentList;

    private int category;
    public Board(BoardRequestDto requestDto, User user, String image) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.nickname = user.getNickname();
        this.image = image;
        this.category = requestDto.getCategory();
    }

    public void update(BoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.category = requestDto.getCategory();
    }

    public void update(String image){
        this.image = image;
    }
}
