package com.modoostudy.OAuth2.service;

import com.modoostudy.OAuth2.dto.SignupDto;
import com.modoostudy.OAuth2.dto.SignupFormDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserInterestDto;
import com.modoostudy.OAuth2.dto.signupForm.InterestDto;
import com.modoostudy.OAuth2.mapper.InterestMapper;
import com.modoostudy.OAuth2.mapper.RegionMapper;
import com.modoostudy.OAuth2.mapper.SignupUserInterestMapper;
import com.modoostudy.OAuth2.mapper.SignupUserMapper;
import com.modoostudy.OAuth2.model.Interest;
import com.modoostudy.OAuth2.model.MappingUserInterest;
import com.modoostudy.OAuth2.model.User;
import com.modoostudy.OAuth2.repository.InterestRepository;

import com.modoostudy.OAuth2.repository.MappingUserInterestRepository;
import com.modoostudy.OAuth2.repository.RegionRepository;
import com.modoostudy.OAuth2.repository.UserRepository;
import com.modoostudy.OAuth2.security.JWTTokenEnhancer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MappingUserInterestRepository mappingUserInterestRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /** 회원가입 양식제공 서비스
     *
     */
    public SignupFormDto getSignupForm(){

        return SignupFormDto.builder()
                .interestDto(InterestMapper.INSTANCE.toDto(interestRepository.findAll()))
                .regionDto(RegionMapper.INSTANCE.toDto(regionRepository.findAll()))
                .build();
    }


    /** 회원가입
     *
     */
    public void signup(Map<String, Object> signupUser){
        System.out.println(signupUser);

        /*
        userTB 입력
         */
        User signupUserEntity =  SignupUserMapper.INSTANCE.toEntity(
                SignupUserDto.builder()
//                .userID(Long.valueOf(String.valueOf(signupUser.get("userID"))))  // ID 자동생성 auto_increament
                        .password(passwordEncoder.encode(String.valueOf(signupUser.get("password"))))
                        .GEmail(String.valueOf(signupUser.get("GEmail")))
                        .nickname(String.valueOf(signupUser.get("nickname")))
                        .region(String.valueOf(signupUser.get("region")))
                        .authorities(1)
                        .build());

        userRepository.save(signupUserEntity);

        System.out.println(signupUserEntity.getUserID());


        /*
        mappingUserInterestTB 입력
         */
        // 유저테이블 insert시 사용된 userID 호출
        Long signupUserID = signupUserEntity.getUserID();

        System.out.println(signupUser.get("interest"));
        System.out.println(signupUser.get("interest").getClass());
        System.out.println("//////");




//        System.out.println((signupUser.get("interest").get(0)));


        List<Object> interestLists = Arrays.asList(signupUser.get("interest"));

        System.out.println(interestLists);
        System.out.println(interestLists.getClass().getName());
        System.out.println(interestLists.get(0).getClass().getName());
        System.out.println(interestLists.get(0).toString());

        for(Object interest : interestLists)
        {
            System.out.println(interest);
            System.out.println(interest.getClass().getName());

//            mappingUserInterestRepository.save(SignupUserInterestMapper.INSTANCE.toEntity(
//                            SignupUserInterestDto.builder()
//                                    .userId(signupUserID)
//                                    .interestId(Long.valueOf(String.valueOf(interest)))
//                                    .build() ) );
            mappingUserInterestRepository.save(
                    MappingUserInterest.builder()
                            .userID(signupUserID)
                            .interestID(Long.valueOf(String.valueOf(interest)))
                            .build());
        }


//        mappingUserInterestRepository.save(MappingUserInterest.)

    }




}
