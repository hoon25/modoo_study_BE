package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.dto.function.study.LoginUserDto;
import com.modoostudy.mainStudy.entity.User;
import com.modoostudy.mainStudy.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyStudyService {

    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final RegionRepository regionRepository;
    private final StudyRepository studyRepository;
    private final MappingStudyInterestRepository mappingStudyInterestRepository;
    private final MappingStudyGuestRepository mappingStudyGuestRepository;
    private final MappingUserInterestRepository mappingUserInterestRepository;

    /**
     * JWT 토큰으로부터 로그인 유저 정보 가져오기
     */
    public LoginUserDto getUserFromJWT() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        User user = userRepository.findByGEmail(authentication.getName());

        return LoginUserDto.builder()
                .userID(user.getUserID())
                .GEmail(user.getGEmail())
                .nickName(user.getNickname())
                .build();
    }

    /**
     * Mystudy 메인페이지 서비스
     */

    public void getMystudyPage(){


    }







}
