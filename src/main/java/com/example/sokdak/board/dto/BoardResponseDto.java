package com.example.sokdak.board.dto;


import com.example.sokdak.board.entity.Board;
import com.example.sokdak.board.entity.InterestTag;
import com.example.sokdak.comment.dto.CommentResponseDto;
import com.example.sokdak.user.entity.CareerTag;
import com.example.sokdak.user.entity.JobTag;
import com.example.sokdak.user.entity.User;
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
    private boolean commentIncluding;
    private String image;
    private int category;
    private Long likeCnt;
    private int userCareerTag;
    private int userJobTag;
    private String profileImage;
    private List<CommentResponseDto> commentList = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;



    //생성자
    public BoardResponseDto(Board board, String image) { // 게시글 생성
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.userCareerTag = CareerTag.valueOfCareerTag(board.getUser().getCareerTag()).getCareerTag();
        this.userJobTag = JobTag.valueOfJobTag(board.getUser().getJobTag()).getJobTag();
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getInterestTag();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardResponseDto(Board board, List<CommentResponseDto> commentList, String image) { // 게시글 업데이트
        this.id = board.getId();            //this.id: (위에서 선언된) 필드, Board 객체의 board 매개변수로 들어온 데이터를 getId() 에 담는다(Client 에게로 보내기 위해)
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getInterestTag();
        this.commentList = commentList;
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardResponseDto(Board board, List<CommentResponseDto> commentList, String image, Long likeCnt) { // 게시글 전체 , 카테고리별 출력
        this.id = board.getId();            //this.id: (위에서 선언된) 필드, Board 객체의 board 매개변수로 들어온 데이터를 getId() 에 담는다(Client 에게로 보내기 위해)
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getInterestTag();
        this.likeCnt = likeCnt;
        this.userCareerTag = CareerTag.valueOfCareerTag(board.getUser().getCareerTag()).getCareerTag();
        this.userJobTag = JobTag.valueOfJobTag(board.getUser().getJobTag()).getJobTag();
        this.profileImage = board.getUser().getProfileImage();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
        this.commentList = commentList;
    }

    public BoardResponseDto(Board board, List<CommentResponseDto> commentList, String image, Long likeCnt,boolean boardlike, boolean commentIncluding) { //게시글 상세 페이지
        this.id = board.getId();            //this.id: (위에서 선언된) 필드, Board 객체의 board 매개변수로 들어온 데이터를 getId() 에 담는다(Client 에게로 보내기 위해)
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getNickname();
        this.image = image;
        this.category = InterestTag.valueOfInterestTag(board.getCategory()).getInterestTag();
        this.likeCnt = likeCnt;
        this.boardLikeUserId=boardlike;
        this.commentIncluding=commentIncluding;
        this.userCareerTag = CareerTag.valueOfCareerTag(board.getUser().getCareerTag()).getCareerTag();
        this.userJobTag = JobTag.valueOfJobTag(board.getUser().getJobTag()).getJobTag();
        this.profileImage = board.getUser().getProfileImage();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
        this.commentList = commentList;
    }
}