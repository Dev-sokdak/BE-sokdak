package com.example.devsokdak.user.controller;

import com.example.devsokdak.global.MsgResponseDto;
import com.example.devsokdak.global.exception.SuccessCode;
import com.example.devsokdak.user.dto.LoginRequestDto;
import com.example.devsokdak.user.dto.SignupRequestDto;
import com.example.devsokdak.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

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
}
