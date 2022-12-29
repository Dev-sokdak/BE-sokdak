package com.example.sokdak.mypage.controller;

import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.security.UserDetailsImpl;
import com.example.sokdak.mypage.dto.MypageResponseDto;
import com.example.sokdak.mypage.dto.MypageUpdateJobTagRequestDto;
import com.example.sokdak.mypage.dto.MypageUpdateNicknameRequestDto;
import com.example.sokdak.mypage.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MypageController {

    private final MypageService mypageService;

    @GetMapping("/mypage")
    public MypageResponseDto getMypage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mypageService.getMypage(userDetails.getUser());
    }

    @PatchMapping(value = "/mypage/profile", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public MsgResponseDto updateProfile(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                        @RequestPart("image") MultipartFile multipartFile) throws IOException {
        return mypageService.updateProfile(userDetails.getUser(), multipartFile);
    }

    @PatchMapping(value = "/mypage/jobTag")
    public MsgResponseDto updateJobTag(@RequestBody MypageUpdateJobTagRequestDto mypageUpdateJobTagRequestDto,
                                       @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mypageService.updateJobCareerTag(mypageUpdateJobTagRequestDto, userDetails.getUser());
    }

    @PatchMapping(value = "/mypage/nickname")
    public MsgResponseDto updateNickname(@RequestBody MypageUpdateNicknameRequestDto mypageUpdateNicknameRequestDto,
                                       @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return mypageService.updateNickname(mypageUpdateNicknameRequestDto, userDetails.getUser());
    }



}
