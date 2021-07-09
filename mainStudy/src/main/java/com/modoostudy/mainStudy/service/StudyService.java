package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.dto.LoginUserDto;
import com.modoostudy.mainStudy.dto.StudyFormDto;
import com.modoostudy.mainStudy.entity.User;
import com.modoostudy.mainStudy.mapper.InterestMapper;
import com.modoostudy.mainStudy.mapper.RegionMapper;
import com.modoostudy.mainStudy.repository.InterestRepository;
import com.modoostudy.mainStudy.repository.RegionRepository;
import com.modoostudy.mainStudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudyService {

    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final RegionRepository regionRepository;


    /**
     * JWT 토큰으로부터 로그인 유저 정보 가져오기
     */
    public LoginUserDto getUserFromJWT(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByGEmail(authentication.getName());

        return LoginUserDto.builder()
                .userID(user.getUserID())
                .GEmail(user.getGEmail())
                .nickName(user.getNickname())
                .build();
    }


    /**
     * 스터디생성 폼 가져오기
     */

    public StudyFormDto getStudyForm() {



        return StudyFormDto.builder()
                .loginUserDto(getUserFromJWT())
                .interestDto(InterestMapper.INSTANCE.toDto(interestRepository.findAll()))
                .regionDto(RegionMapper.INSTANCE.toDto(regionRepository.findAll()))
                .build();
    }






}
