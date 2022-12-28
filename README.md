# 4조 클론 프로젝트 [개발자 커뮤니티 sokdak] #
![image](https://user-images.githubusercontent.com/117730606/209823456-57bbc991-d430-4f31-8ade-6b5ad2114bd0.png)




1. [프로젝트 소개](#1-프로젝트-소개)
2. [기능 명세](#2-기능-명세)
3. [기술 스택](#4-기술-스택)
4. [트러블 슈팅](#5-트러블-슈팅)
5. [팀 노션](#6-팀-노션)
6. [깃 허브](#7-깃-허브)
7. [팀원 정보](#8-팀원-정보)



## 1. 프로젝트 소개

### 프로젝트 이름 : **개발자 커뮤니티** - SokDak-!
- 프로젝트 설명 : 원티드 커뮤니티 클론 코딩

## 2. 기능 명세

1. 회원
- Id(email 형식), password, jobTag(직종), carrerTag(경력)를 입력하여 회원가입
- Id와  중복 확인 검사
- nickname은 랜덤 생성
- Id는 email 형식 포함
- 게시글 등록, 댓글 등록은 회원만 가능
- 비회원은 게시글 조회만 가능
- 프로필 사진 업로드

2. 게시글

- 게시글을 등록할 때 카테고리 태그를 선택하여 게시글을 등록
- title, image, content, categoryTag,createAt, modifiedAt,admin(관리자 테스트 용)으로 게시글 작성
- 게시글 작성 시, 이미지 파일 한개를 첨부 가능
- 이미지는 aws S3에 저장
- 메인 페이지에서는 title, categoryTag, image, nickname, likecount, userCarrerTag,userJobTag,profileImage,createAt,modifiedAt 출력
- 카테고리별 출력 기능
- 전체 출력, 카테고리별 출력은 페이징 처리
- 게시글은 작성자에 한해 수정 가능
- 상세 조회 페이지에서는 모든 필드 조회

3. 댓글
- content로 댓글 작성



## 3. 기술 스택
- Frontend : react, vite, AWS S3
- Backend  : Java, Spring Boot, Jpa, Mysql , AWS EC2, RDS, S3

## 4.트러블 슈팅

💪 어려웠지만, 극복 해냄!


  |   | 트러블 슈팅 |
|--|--|
| [Frontend] | ![image](https://user-images.githubusercontent.com/117730606/209359166-dbd1631b-f690-4e98-b963-722e74ef5e19.png) |
| [Frontend] | ![image](https://user-images.githubusercontent.com/117730606/209359236-ac066a00-7794-4ce5-b0ef-4a93fcf2700c.png) |
| [backend] | ![image](https://user-images.githubusercontent.com/117730606/209359434-4820d2c2-2054-4ab7-8a4c-a26af42a30fc.png) |
| [backend] | ![image](https://user-images.githubusercontent.com/117730606/209359503-0296a166-d9e5-45f6-8c18-ed2ede3482f4.png) |
| [backend] | ![image](https://user-images.githubusercontent.com/117730606/209359566-bfea7d54-291a-418b-b67c-945a76a93469.png) |
| [backend] | ![image](https://user-images.githubusercontent.com/117730606/209359601-419d501b-dc06-4b17-8e84-2d68bca06bbf.png) |


## 5. 팀 노션
https://www.notion.so/synuns/Sokdak-c016b8cb325d4460a0f1a92807082d59

## 6. 깃 허브
- Forntend : https://github.com/Dev-sokdak/FE-sokdak
- Backend : https://github.com/Dev-sokdak/BE-sokdak


## 7. 팀원 정보
| 이름 | 깃 허브 |
|--|--|
| 김인광 | https://github.com/ingwang-kim |
| 김규리 |  |
| 신승호 |  |
| 장신원 |  |
| 최수빈 |  |




