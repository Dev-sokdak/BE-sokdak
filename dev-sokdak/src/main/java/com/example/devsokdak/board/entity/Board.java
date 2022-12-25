package com.example.devsokdak.board.entity;

import com.example.devsokdak.board.dto.BoardRequestDto;
import com.example.devsokdak.comment.entity.Reply;
import com.example.devsokdak.global.entity.TimeStamped;
import com.example.devsokdak.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;
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
    @Column(nullable = false)
    private String nickname;                                 // 작성자 닉네임
    @Column(nullable = false)                               // 게시판 이미지는 0개 이상, 1개 이하로 Null 값 허용
    private String image;                                   // s3 Upload Url
    @OneToMany(mappedBy = "board")                          // Board(1) <-> reply(n) 양방향 관계
    private List<Reply> replyList;
    @OneToMany(mappedBy = "board")                          // Board(1) <-> category(n) 양방향 관계
    private List<Category> categoryList;
    public Board(BoardRequestDto requestDto, User user, String image) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.nickname = user.getNickname();
        this.image = image;
        this.categoryList = categoryList;
    }
    public Board(BoardRequestDto requestDto, User user, String image, List<Reply> replyList) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.nickname = user.getNickname();
        this.image = image;
        this.replyList = replyList;
        this.categoryList = categoryList;
    }

    public void update(BoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.categoryList = categoryList;
    }
}
