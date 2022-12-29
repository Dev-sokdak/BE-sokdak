# 4조 클론 프로젝트 [개발자 커뮤니티 sokdak] #
![image](https://user-images.githubusercontent.com/117730606/209823456-57bbc991-d430-4f31-8ade-6b5ad2114bd0.png)




1. [프로젝트 소개](#1-프로젝트-소개)
2. [기능 명세](#2-기능-명세)
3. [ERD](#3-ERD)
4. [API 명세서(swagger)](#4-API-명세서)
5. [기술 스택](#5-기술-스택)
6. [트러블 슈팅](#6-트러블-슈팅)
7. [팀 노션](#7-팀-노션)
8. [깃 허브](#8-깃-허브)
9. [팀원 정보](#9-팀원-정보)



## 1. 프로젝트 소개

### 프로젝트 이름 : **개발자 커뮤니티** - SokDak-!
- 프로젝트 설명 : 원티드 커뮤니티 클론 코딩

## 2. 기능 명세

<details>
<summary>🏁  최초 설계 내역</summary>
<div markdown="1">       

    **📍 회원가입/로그인**
    
    - 일반 이메일 회원가입 / 로그인
    - 아이디 중복 확인
    - 아이디 / 패스워드 정규식 확인
    - 랜덤 난수 닉네임 생성
    - OAuth2(카카오) 회원가입 / 로그인
    - 회원가입 Type 식별 👉 일반 로그인 불가
     (* 일반회원이 카카오로 로그인 시도시  일치하는 ID가 있을 경우 SignUpType 변경 0 → 1)
    - 랜덤 난수 닉네임 생성
    - 로그인/ 로그아웃 인증
    - JWT Token
    
    **📍 커뮤니티**
    
    - 커뮤니티 내용 등록
    - Category 선택 [ 커리어고민, 취업/이직, 회사생활 , … ,  UI/UX]
    - 사진 업로드 (AWS S3)
    - 제목 / 내용 
    - 글 작성시 닉네임으로 출력되도록
    
    - 커뮤니티 내용 조회
    - 전체 조회 
    - 카테고리별 조회 
    - 선택 조회
    
    - 커뮤니티 내용 수정
    - 수정시 사진 삭제
    
    - 커뮤니티 내용 삭제
    - 게시물 삭제시 연관 내용 전체 삭제
    
    - 커뮤니티 글 좋아요 기능
    
    - 커뮤니티 댓글 등록/삭제
    
    **📍 마이페이지**
    
    - 내 정보 조회
    - 프로필 사진 업로드
    - 직무, 경력 정보 등록 & 수정

</div>
</details>
<details>
<summary>✊🏻 추가 스코프 내역</summary>
<div markdown="1">       

    **📍 BE**
    
    - http → https 프로토콜 변경
    - 페이징(Slice)
    - Swagger
    - Access Log Logging 처리
    - 마이페이지 닉네임 수정 기능
    
    **📍 FE**
    
    - 마이페이지
    - Infinity Scroll
    - 디테일 페이지 비로그인 방식 변경

</div>
</details>

## 3. ERD

<details>
<summary>ERD</summary>
<div markdown="1">       

![Untitled](https://user-images.githubusercontent.com/117730606/209832258-2118cc8d-f543-4413-854f-6e6d7761e0ed.png)

</div>
</details>

## 4. API 명세서
-(swagger) : https://devsokdak.shop/swagger-ui.html

## 5. 기술 스택
- Frontend : react, vite, AWS S3
- Backend  : Java, Spring Boot, Jpa, Mysql , AWS EC2, RDS, S3

## 6. 트러블 슈팅


  |   | 트러블 슈팅 |
|--|--|
| [Frontend] |  |
| [Frontend] |  |
| [backend] |  |
| [backend] |  |
| [backend] |  |


## 7. 팀 노션
https://www.notion.so/synuns/Sokdak-c016b8cb325d4460a0f1a92807082d59

## 8. 깃 허브
- Forntend : https://github.com/Dev-sokdak/FE-sokdak
- Backend : https://github.com/Dev-sokdak/BE-sokdak


## 9. 팀원 정보
| 이름 | 깃 허브 |
|--|--|
| 김인광(BE) | https://github.com/ingwang-kim |
| 김규리(BE) | https://github.com/kyuung09 |
| 신승호(BE) | https://github.com/hongdangmoo49 |
| 장신원(FE) | https://github.com/synuns |
| 최수빈(FE) | https://github.com/123456soobin-choi |




