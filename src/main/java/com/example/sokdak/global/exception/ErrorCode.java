package com.example.sokdak.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    //BAD_REQUEST
    DISMATCH_ADMIN_TOKEN(HttpStatus.BAD_REQUEST, "관리자 암호가 틀려 등록이 불가능합니다."),
    ALREADY_EXIST_USERNAME(HttpStatus.CONFLICT, "중복된 사용자가 존재합니다."),
    DISMATCH_PASSWORD(HttpStatus.BAD_REQUEST,"비밀번호가 일치하지 않습니다."),

    // NOT_FOUND
    NO_BOARD_FOUND(HttpStatus.NOT_FOUND, "게시글이 존재하지 않습니다."),
    NO_EXIST_USER(HttpStatus.NOT_FOUND, "등록된 사용자가 없습니다."),

    NO_LOCAL_USER(HttpStatus.NOT_FOUND, "허용된 로그인 방식이 아닙니다."),
    NO_EXIST_COMMENT(HttpStatus.NOT_FOUND, "댓글이 존재하지 않습니다."),
    NO_EXIST_LOCAL(HttpStatus.NOT_FOUND,"카테고리를 찾을 수 없습니다."),

    // UNAUTHORIZED
    NO_MODIFY_BOARD(HttpStatus.UNAUTHORIZED,"게시글 수정 권한이 없습니다."),
    NO_MODIFY_COMMENT(HttpStatus.UNAUTHORIZED,"댓글 수정 권한이 없습니다."),
    NO_DELETE_BOARD(HttpStatus.UNAUTHORIZED,"게시글 삭제 권한이 없습니다."),
    NO_DELETE_COMMENT(HttpStatus.UNAUTHORIZED,"댓글 삭제 권한이 없습니다."),

    // CONFLICT
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다"),
    ALREADY_CLICKED_LIKE(HttpStatus.CONFLICT, "이미 좋아요를 눌렀습니다"),
    ALERADY_CANCEL_LIKE(HttpStatus.CONFLICT, "이미 좋아요 취소를 눌렀습니다")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
