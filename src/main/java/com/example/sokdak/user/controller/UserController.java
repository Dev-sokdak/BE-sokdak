package com.example.sokdak.user.controller;


import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.exception.SuccessCode;
import com.example.sokdak.global.jwt.JwtUtil;
import com.example.sokdak.user.dto.LoginRequestDto;
import com.example.sokdak.user.dto.SignupRequestDto;
import com.example.sokdak.user.service.UserKakaoService;
import com.example.sokdak.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final UserKakaoService userKakaoService;

    @PostMapping("/signup")
    public MsgResponseDto signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);

        return new MsgResponseDto(SuccessCode.SIGN_UP);
    }


    @PostMapping("/login")
    public MsgResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        //클라이언트에 반환하기 위해 response 객체
        userService.login(loginRequestDto, response);

        return new MsgResponseDto(SuccessCode.LOG_IN);
    }

    @PostMapping("/loginKakao")
    public MsgResponseDto kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        // code: 카카오 서버로부터 받은 인가 코드
        String createToken = userKakaoService.kakaoLogin(code, response);

        // Cookie 생성 및 직접 브라우저에 Set
        Cookie cookie = new Cookie(JwtUtil.AUTHORIZATION_HEADER, createToken.substring(7));
        cookie.setPath("/");
        response.addCookie(cookie);
        return new MsgResponseDto(SuccessCode.LOG_IN);
    }

    // 이메일 중복 확인
    @GetMapping("/signup/checkId/")
    public ResponseEntity<Boolean> checkUserNameDuplicate (@RequestParam String userId){
        return ResponseEntity.ok(userService.checkUserIdDuplicate(userId));
    }
}
