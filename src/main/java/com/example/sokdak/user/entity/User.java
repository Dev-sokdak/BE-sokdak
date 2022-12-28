package com.example.sokdak.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "users")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String userId;                                  // 사용자 Id
    @Column(nullable = false)
    private String password;                                // 사용자 Password

    @Column(nullable = true)
    private String nickname;                                // 사용자 닉네임 (랜덤 난수로 닉네임 생성하여 저장)

    @Column(nullable = false)
    private int signUpType;                                 // 회원가입 타입 (카카오 Or 이메일 로그인)

    @Column(nullable = false)
    private int isDelete = 0;                               // 회원 삭제 유무 (0: 정상, 1: 삭제된 회원)

    @Column(nullable = true)
    private String profileImage;                            // 프로필 사진 Url (S3 Path)

    @Column(nullable = true)
    private String jobTag;                                  // 직업 태그 ( 0 : 웹개발자, 1 : 서버 개발자, 2: 프론트앤드 개발자, 3: QA 테스트엔지니어, 4: DevOps/시스템관리자)

    @Column(nullable = true)
    private String careerTag;                               // 경력 태그 ( 0 : 신입, 1: 1년 이상 , ... , 10 : 10년 이상)

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    // 카카오 User용 생성자
    public User(String userId, String password, String nickname, int signUpType, UserRoleEnum role) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.signUpType = signUpType;
        this.role = role;
    }

    // 일반 User용 생성자
    public User(String userId, String password, String nickname, String jobTag, String careerTag, int signUpType, UserRoleEnum role) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.jobTag = jobTag;
        this.careerTag = careerTag;
        this.signUpType = signUpType;
        this.role = role;
    }

    public void update(int signUpType){
        this.signUpType = signUpType;
    }

    public void updateProfile(String profileImage){
        this.profileImage = profileImage;
    }

    public void updateJobCareerTag(String jobTag,String careerTag){
        this.jobTag = jobTag;
        this.careerTag = careerTag;
    }

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
}
