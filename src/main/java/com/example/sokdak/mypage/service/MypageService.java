package com.example.sokdak.mypage.service;

import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.exception.S3.S3Uploader;
import com.example.sokdak.global.exception.SuccessCode;
import com.example.sokdak.mypage.dto.MypageResponseDto;
import com.example.sokdak.mypage.dto.MypageUpdateJobTagRequestDto;
import com.example.sokdak.user.entity.CareerTag;
import com.example.sokdak.user.entity.JobTag;
import com.example.sokdak.user.entity.User;
import com.example.sokdak.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final S3Uploader s3Uploader;
    private final UserRepository userRepository;

    @Transactional
    public MypageResponseDto getMypage(User user) {
        User user1 = userRepository.findByUserId(user.getUserId()).orElseThrow();
        int jobTag = JobTag.valueOfJobTag(user.getJobTag()).getJobTag();
        int careerTag = CareerTag.valueOfCareerTag(user.getCareerTag()).getCareerTag();
        return new MypageResponseDto(user1, jobTag, careerTag);
    }

    // 프로필 사진 수정
    @Transactional
    public MsgResponseDto updateProfile(User user, MultipartFile multipartFile) throws IOException {
        String image = null;
        if (!multipartFile.isEmpty()) {
            image=s3Uploader.upload( multipartFile, "profile");
        }

        User user1 = userRepository.findByUserId(user.getUserId()).orElseThrow();
        user1.updateProfile(image);

        return new MsgResponseDto(SuccessCode.UPLOAD_PROFILE);
    }

    // Job Tag&Career Tag 수정
    @Transactional
    public MsgResponseDto updateJobCareerTag(MypageUpdateJobTagRequestDto mypageUpdateJobTagRequestDto, User user) {

        User user1 = userRepository.findByUserId(user.getUserId()).orElseThrow();
        String jobTag = JobTag.valueOfJobTag(mypageUpdateJobTagRequestDto.getJobTag()).getTagMsg();
        String careerTag = CareerTag.valueOfCareerTag(mypageUpdateJobTagRequestDto.getCareerTag()).getTagMsg();

        user1.updateJobCareerTag(jobTag,careerTag);

        return new MsgResponseDto(SuccessCode.UPLOAD_JOBANDCAREER);
    }


}
