package com.example.sokdak.board.dto;


import com.example.sokdak.board.entity.Board;
import com.example.sokdak.board.entity.InterestTag;
import com.example.sokdak.comment.dto.CommentResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private boolean boardLikeUserId;
    private String image;
    private String category;
    private Long likeCnt;
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
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getTagMsg();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardResponseDto(Board board, List<CommentResponseDto> commentList, String image) {
        this.id = board.getId();            //this.id: (위에서 선언된) 필드, Board 객체의 board 매개변수로 들어온 데이터를 getId() 에 담는다(Client 에게로 보내기 위해)
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getTagMsg();
        this.commentList = commentList;
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardResponseDto(Board board, List<CommentResponseDto> commentList, String image, Long likeCnt) {
        this.id = board.getId();            //this.id: (위에서 선언된) 필드, Board 객체의 board 매개변수로 들어온 데이터를 getId() 에 담는다(Client 에게로 보내기 위해)
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getTagMsg();
        this.commentList = commentList;
        this.likeCnt = likeCnt;
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
    public BoardResponseDto(Board board, List<CommentResponseDto> commentList, String image, Long likeCnt,boolean boardlike) {
        this.id = board.getId();            //this.id: (위에서 선언된) 필드, Board 객체의 board 매개변수로 들어온 데이터를 getId() 에 담는다(Client 에게로 보내기 위해)
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getTagMsg();
        this.commentList = commentList;
        this.likeCnt = likeCnt;
        this.boardLikeUserId=boardlike;
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}