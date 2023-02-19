

![Group 19 (1)](https://user-images.githubusercontent.com/117708164/209903512-794cdc8a-8001-4a05-bd97-b4af66a32abc.png)
###  CloneProject Team 4
# 🌀 Dev Sokdak 

- 개발자들의 커뮤니티 Sokdak 💬
- 커리어와 라이프스타일에 대해 자유롭게 이야기 할 수 있어요 🙋🏻   

#

## 🧩 Index

1. [프로젝트 소개](#1-프로젝트-소개-)
2. [기술 스택](#2-기술-스택-)
3. [아키텍처](#3-아키-텍처-)
4. [기능 명세](#4-기능-명세-)
5. [시연영상](#5-시연영상)
6. [ERD](#6-erd-)
7. [API 명세서 (with. swagger)](#7-api-명세서-)
8. [트러블 슈팅](#8-트러블-슈팅-)
9. [TEAM NOTION](#9-notion-)
10. [GITHUB](#10-github-)

#

## 1. 프로젝트 소개 🗓
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

## 2. 기술 스택 🔨
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

## 3. 아키 텍처 🗂
![image](https://user-images.githubusercontent.com/117730606/219923447-2ad05fcf-acb2-42a4-9fb6-d66c1f804911.png)


#

## 4. 기능 명세 🗂

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

## 5. 시연영상 

![Untitled](https://user-images.githubusercontent.com/57736547/209971792-69239f26-31df-4298-9593-ceb1365aecc6.gif)

![Untitled](https://user-images.githubusercontent.com/57736547/209971801-64687d18-9469-4b65-8220-67c0e8039939.gif)

![Untitled](https://user-images.githubusercontent.com/57736547/209971796-39a73aa0-c2d7-4a8a-9a03-bc864b001047.gif)


## 6. ERD 🧑🏻‍💻

![Untitled](https://user-images.githubusercontent.com/117730606/209832258-2118cc8d-f543-4413-854f-6e6d7761e0ed.png)

#

## 7. API 명세서 🖊
- swagger : https://devsokdak.shop/swagger-ui.html

#

## 8. 트러블 슈팅 👾

|   | 트러블 슈팅 |
|--|--|
| [Frontend] | 게시글 수정하기를 할 때 원래 게시글의 데이터를 가지고 가면서 작성하기 페이지를 재사용하도록 기획하였는데, 수정할 때 작성하기와는 다르게 이미지 데이터가 이미지 url값을 가지고 있어서 어떻게 formData 형태로 다시 가공해야하는지 매우 어려웠음. (미해결)<br>: 유저 정보를 redux를 이용해서 store에 저장하고 관리하면서 비로그인과 로그인 상태를 구별하여 다른 화면을 보여줄 수 있도록 하고 있는데, 유저정보가 제대로 리프레쉬되지 않는 트러블이 발생함.  |
| [Frontend] | image를 form data로 보낼 때 file 자체로 보내야 하는지 string 형식으로 보내야 하는지 어려웠는데 각각 request 형식에 맞게 보내는 방법을 알 수 있었음<br>: 상세 페이지 컴포넌트 구조가 복잡해서 props drilling이 생겼었다. 자식 컴포넌트에게 props 를 주고 상태값을 변경하는 방법으로 해결했지만 유지보수가 매우 힘들어 시간이 오래 걸렸음.<br>: 초반에는 파일들을 한 번에 커밋하거나 커밋메시지를 잘 적는데 어려움이 있었으나 깃 플로우에 따라 협업하는 방법을 배웠음. |
| [backend] | 기존의 코드(게시물)에 @builder 패턴을 적용시키려 개념학습 후, 기존 코드 리펙터링을 했다. 그러나 초기 설계의 차이와 시간 부족으로 결국 실패했다. 그러나 시간이 충분했다면 해낼 수 있었을 것 같다.  |
| [backend] | 게시글 전체 조회, 카테고리별 조회 등 데이터를 조회 할 때 모든 데이터를 한번에 가져오지 않고 나누어 가져와야됨 > 페이징 처리> 페이지를 동적으로 변경하는 방법을 찾아봄 <br> (1) PathVariable이나 RequestParam으로 값을 동적으로 받은 뒤 처리를 해봄 > 실패<br> (2) Pageable 자체에서 지원하는 Param으로 프론트에서 적용할 수 있음 >  성공 |
| [backend] | AWS EC2 서버에 도메인 연결 및 SSL 인증서 적용 시 도메인 매핑 오류<br>- 적용 후 도메인으로 접속이 안되는 문제가 발생 <br>- 보안그룹이 기본값으로 되어있어서 ALB에 적용시켰을때 모두 차단되어서 문제가 발생<br>- 80/443 포트만 허용 후 성공 !<br><br>: Oauth2 연동 프론트 연결 후 접속 오류 <br>- Redirect Uri를 프론트 테스트 URI로 변경하고, CORS 설정 변경 후 성공 ! |

#

## 9. Notion 📔
https://www.notion.so/synuns/Sokdak-c016b8cb325d4460a0f1a92807082d59

#

## 10. Github 🐱
- Forntend : https://github.com/Dev-sokdak/FE-sokdak
- Backend : https://github.com/Dev-sokdak/BE-sokdak

#
