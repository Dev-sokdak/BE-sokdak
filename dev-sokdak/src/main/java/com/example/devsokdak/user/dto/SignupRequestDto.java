package com.example.devsokdak.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {

    @NotBlank(message = "아이디에 공백이 있거나 값을 입력하지 않았습니다.")
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "아이디는 최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)이어야 합니다.")
    private String userId;

    @NotBlank(message = "비밀번호에 공백이 있거나 값을 입력하지 않았습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,15}$", message = "비밀번호는 최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9)이어야 합니다.")
    private String password;

    @NotBlank(message = "이메일에 공백이 있거나 값을 입력하지 않았습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\\\.[a-z]+$")
    private String email;

    private boolean admin = false;

    private String adminToken = "";
}