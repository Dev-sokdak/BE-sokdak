package com.example.sokdak.mypage.dto;

import com.example.sokdak.board.entity.Board;
import com.example.sokdak.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MypageResponseDto {

    private String nickname;

    private String profileImage;

    private int jobTag;

    private int careerTag;

    public MypageResponseDto(User user, int jobTag, int careerTag ){
        this.nickname = user.getNickname();
        this.profileImage = user.getProfileImage();
        this.jobTag = jobTag;
        this.careerTag = careerTag;
    }

}
