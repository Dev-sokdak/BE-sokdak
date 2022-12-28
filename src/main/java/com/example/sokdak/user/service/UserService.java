package com.example.sokdak.user.service;


import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.exception.CustomException;
import com.example.sokdak.global.exception.ErrorCode;
import com.example.sokdak.global.exception.SuccessCode;
import com.example.sokdak.global.jwt.JwtUtil;
import com.example.sokdak.user.dto.LoginRequestDto;
import com.example.sokdak.user.dto.SignupRequestDto;
import com.example.sokdak.user.entity.CareerTag;
import com.example.sokdak.user.entity.JobTag;
import com.example.sokdak.user.entity.User;
import com.example.sokdak.user.entity.UserRoleEnum;
import com.example.sokdak.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class  UserService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;


    private static final String ADMIN_TOKEN = "HangHae99NoHangHae130Yes";

    private static int signUpType = 0;

    // 회원가입
    @Transactional
    public MsgResponseDto signup(SignupRequestDto signupRequestDto) {

        String nickname = RandomStringUtils.random(15, true, true);                         // 닉네임 랜덤 생성
        String userId = signupRequestDto.getUserId();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        String jobTag = JobTag.valueOfJobTag(signupRequestDto.getJobTag()).getTagMsg();                         // jobTag Enum에서 입력받은 int value와  일치하는 String 값 반환
        String careerTag = CareerTag.valueOfCareerTag(signupRequestDto.getCareerTag()).getTagMsg();             // careerTag Enum에서 입력받은 int value와  일치하는 String 값 반환

        // 중복 닉네임
        Optional<User> found = userRepository.findByUserId(userId);
        if (found.isPresent()) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_USERNAME);
        }
        UserRoleEnum role = UserRoleEnum.USER;

        // 권한 토큰키 검증
        if (signupRequestDto.isAdmin()) {
            if (!signupRequestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new CustomException(ErrorCode.DISMATCH_ADMIN_TOKEN);
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(userId, password, nickname, jobTag, careerTag, signUpType, role);
        userRepository.save(user);
        return new MsgResponseDto(SuccessCode.SIGN_UP);
    }

    // 로그인
    @Transactional(readOnly = true)
    public MsgResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String userId = loginRequestDto.getUserId();
        String password = loginRequestDto.getPassword();

        // 사용자 확인
        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new CustomException(ErrorCode.NO_EXIST_USER));

        // signUpType 확인
        if(user.getSignUpType() != signUpType){
            throw new CustomException(ErrorCode.NO_LOCAL_USER);
        }

        // 비밀번호 확인
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new CustomException(ErrorCode.DISMATCH_PASSWORD);
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUserId(), user.getRole()));
        //add header로 헤더에 값 넣어주기 (키, 토큰)
        return new MsgResponseDto(SuccessCode.LOG_IN);
    }

    // 중복 아이디 체크
    public boolean checkUserIdDuplicate(String userId){
        return userRepository.existsByUserId(userId);               // Username이 중복되는 경우 true, 중복되지 않은 경우 False
    }
}
