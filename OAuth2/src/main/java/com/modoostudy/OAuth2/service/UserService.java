package com.modoostudy.OAuth2.service;

import com.modoostudy.OAuth2.dto.SignupDto;
import com.modoostudy.OAuth2.dto.SignupFormDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserDto;
import com.modoostudy.OAuth2.dto.signupForm.InterestDto;
import com.modoostudy.OAuth2.mapper.InterestMapper;
import com.modoostudy.OAuth2.mapper.RegionMapper;
import com.modoostudy.OAuth2.mapper.SignupUserMapper;
import com.modoostudy.OAuth2.model.Interest;
import com.modoostudy.OAuth2.repository.InterestRepository;
import com.modoostudy.OAuth2.repository.RegionRepository;
import com.modoostudy.OAuth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private InterestRepository interestRepository;
    private RegionRepository regionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입 양식제공 서비스
    public SignupFormDto getSignupForm(){

        return SignupFormDto.builder()
                .interestDto(InterestMapper.INSTANCE.toDto(interestRepository.findAll()))
                .regionDto(RegionMapper.INSTANCE.toDto(regionRepository.findAll()))
                .build();
    }

    // 회원가입
    public void signup(Map<String, Object> signupUser){
        System.out.println(signupUser);
        System.out.println(SignupUserMapper.INSTANCE.toEntity(
                SignupUserDto.builder()
                        .userID(Long.valueOf(String.valueOf(signupUser.get("userID"))))
                        .password(passwordEncoder.encode(String.valueOf(signupUser.get("password"))))
                        .GEmail(String.valueOf(signupUser.get("GEmail")))
                        .nickname(String.valueOf(signupUser.get("nickname")))
                        .region(String.valueOf(signupUser.get("region")))
                        .authorities(1)
                        .build()));

        userRepository.save(SignupUserMapper.INSTANCE.toEntity(
                SignupUserDto.builder()
                .userID(Long.valueOf(String.valueOf(signupUser.get("userID"))))
                .password(passwordEncoder.encode(String.valueOf(signupUser.get("password"))))
                .GEmail(String.valueOf(signupUser.get("GEmail")))
                .nickname(String.valueOf(signupUser.get("nickname")))
                .region(String.valueOf(signupUser.get("region")))
                .authorities(1)
                .build())
        );


    }

}
