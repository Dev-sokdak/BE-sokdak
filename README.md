

![Group 19 (1)](https://user-images.githubusercontent.com/117708164/209903512-794cdc8a-8001-4a05-bd97-b4af66a32abc.png)
###  CloneProject Team 4
# 🌀 Dev Sokdak 

- 개발자들의 커뮤니티 Sokdak 💬
- 커리어와 라이프스타일에 대해 자유롭게 이야기 할 수 있어요 🙋🏻   

## 🧩 Index

1. [프로젝트 소개](#1-프로젝트-소개)
2. [기술 스택](#2-기술-스택)
3. [기능 명세](#3-기능-명세)
4. [ERD](#4-erd)
5. [API 명세서 (with. swagger)](#5-api-명세서)
6. [트러블 슈팅](#6-트러블-슈팅)
7. [TEAM NOTION](#7-notion)
8. [GITHUB](#8-github)

#

## 1. 프로젝트 소개🗓
- 설명 : Wanted 커뮤니티 클론 코딩
- 기간 : 2022.12.23 ~ 2022.12.29
- 팀원 : <br> 

| - | NAME | GITHUB |
|--|--|--|
| BE | 김인광 | https://github.com/ingwang-kim |
| BE | 김규리 | https://github.com/kyuung09 |
| BE | 신승호 | https://github.com/hongdangmoo49 |
| FE | 장신원 | https://github.com/synuns |
| FE | 최수빈 | https://github.com/123456soobin-choi |

#

## 2. 기술 스택🔨
<div align=center> 
<img src="https://img.shields.io/badge/java-02569B?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
<img src="https://img.shields.io/badge/jpa-181717?style=for-the-badge&logo=jpa&logoColor=white">
<img src="https://img.shields.io/badge/amazon aws-F8DC75?style=for-the-badge&logo=amazonaws&logoColor=white">
<img src="https://img.shields.io/badge/amazon rds-61DAFB?style=for-the-badge&logo=amazonrds&logoColor=white"> 
<img src="https://img.shields.io/badge/amazon s3-E34F26?style=for-the-badge&logo=amazons3&logoColor=white"> 
<br>

<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
<img src="https://img.shields.io/badge/redux-E34F26?style=for-the-badge&logo=redux&logoColor=white"> 
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/amazon s3-E34F26?style=for-the-badge&logo=amazons3&logoColor=white"> 
<img src="https://img.shields.io/badge/vite-DD0031?style=for-the-badge&logo=vite&logoColor=white">
<img src="https://img.shields.io/badge/reduxjs/toolkit-1572B6?style=for-the-badge&logo=reduxjs&logoColor=white"> 
<img src="https://img.shields.io/badge/axios-FCC624?style=for-the-badge&logo=axios&logoColor=black"> 
<br>
</div>

#

## 3. 기능 명세

<details>
<summary>🏁  최초 설계 내역</summary>
<div markdown="1">       

    📍 회원가입/로그인
    
    (1) 일반 이메일 회원가입 / 로그인
        - 아이디 중복 확인
        - 아이디 / 패스워드 정규식 확인
        - 랜덤 난수 닉네임 생성
    
    (2) OAuth2(카카오) 회원가입 / 로그인
        - 회원가입 Type 식별 👉 일반 로그인 불가
          (* 일반회원이 카카오로 로그인 시도시  일치하는 ID가 있을 경우 SignUpType 변경 0 → 1)
        - 랜덤 난수 닉네임 생성
    
    (3) 로그인/ 로그아웃 인증
        - JWT Token
    
    📍 커뮤니티
    
    (1) 커뮤니티 내용 등록
        - Category 선택 [ 커리어고민, 취업/이직, 회사생활 , … ,  UI/UX]
        - 사진 업로드 (AWS S3)
        - 제목 / 내용 
        - 글 작성시 닉네임으로 출력되도록
    
    (2) 커뮤니티 내용 조회
        - 전체 조회 
        - 카테고리별 조회 
        - 선택 조회
    
    (3) 커뮤니티 내용 수정
        - 수정시 사진 삭제
    
    (4) 커뮤니티 내용 삭제
        - 게시물 삭제시 연관 내용 전체 삭제
    
    (5) 커뮤니티 글 좋아요 기능
    
    (6) 커뮤니티 댓글 등록/삭제
    
    
    📍 마이페이지
    
    (1) 내 정보 조회
        - 프로필 사진 업로드
        - 직무, 경력 정보 등록 & 수정

</div>
</details>
<details>
<summary>✊🏻 추가 스코프 내역</summary>
<div markdown="1">       

    📍 BE
    
    - http → https 프로토콜 변경
    - 페이징(Slice)
    - Swagger
    - Access Log Logging 처리
    - 마이페이지 닉네임 수정 기능
    
    📍 FE
    
    - 마이페이지
    - Infinity Scroll
    - 디테일 페이지 비로그인 방식 변경

</div>
</details>

#

## 4. ERD

![Untitled](https://user-images.githubusercontent.com/117730606/209832258-2118cc8d-f543-4413-854f-6e6d7761e0ed.png)

#

## 5. API 명세서
- swagger : https://devsokdak.shop/swagger-ui.html

#

## 6. 트러블 슈팅

|   | 트러블 슈팅 |
|--|--|
| [Frontend] |  |
| [Frontend] |  |
| [backend] |  |
| [backend] |  |
| [backend] |  |

#

## 7. Notion
https://www.notion.so/synuns/Sokdak-c016b8cb325d4460a0f1a92807082d59

#

## 8. Github
- Forntend : https://github.com/Dev-sokdak/FE-sokdak
- Backend : https://github.com/Dev-sokdak/BE-sokdak

#
