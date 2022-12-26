package com.example.devsokdak.board.dto;


import com.example.devsokdak.board.entity.Board;
import com.example.devsokdak.board.entity.Category;
import com.example.devsokdak.comment.dto.CommentResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardResponseDto {

    //필드
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private int boardLike;
    private String image;
    private int category;
    private List<CommentResponseDto> commentList = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    //생성자
    public BoardResponseDto(Board board, String image) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = board.getCategory();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardResponseDto(Board board, List<CommentResponseDto> commentList, String image) {
        this.id = board.getId();            //this.id: (위에서 선언된) 필드, Board 객체의 board 매개변수로 들어온 데이터를 getId() 에 담는다(Client 에게로 보내기 위해)
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = board.getCategory();
        this.commentList = commentList;
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}