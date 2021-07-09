package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.dto.LoginUserDto;
import com.modoostudy.mainStudy.entity.User;
import com.modoostudy.mainStudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudyService {

    private final UserRepository userRepository;


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
     * 스터디 전체 리스트 가져오기
     */





    }


}
