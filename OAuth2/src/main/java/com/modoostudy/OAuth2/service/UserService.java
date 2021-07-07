package com.modoostudy.OAuth2.service;

import com.modoostudy.OAuth2.dto.SignupDto;
import com.modoostudy.OAuth2.dto.SignupFormDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserInterestDto;
import com.modoostudy.OAuth2.mapper.InterestMapper;
import com.modoostudy.OAuth2.mapper.RegionMapper;
import com.modoostudy.OAuth2.mapper.SignupUserMapper;
import com.modoostudy.OAuth2.entity.MappingUserInterest;
import com.modoostudy.OAuth2.entity.User;
import com.modoostudy.OAuth2.repository.InterestRepository;

import com.modoostudy.OAuth2.repository.MappingUserInterestRepository;
import com.modoostudy.OAuth2.repository.RegionRepository;
import com.modoostudy.OAuth2.repository.UserRepository;
import com.modoostudy.OAuth2.responseCode.error.exception.DuplicateEmailException;
import com.modoostudy.OAuth2.responseCode.error.exception.DuplicateNickNameException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final RegionRepository regionRepository;
    private final MappingUserInterestRepository mappingUserInterestRepository;
    private final PasswordEncoder passwordEncoder;


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
    public void signup(SignupDto signupDto ){
        System.out.println(signupDto);

        //닉네임 이메일 검증
        signUpValidation(signupDto.getSignupUserDto().getGEmail(), signupDto.getSignupUserDto().getNickname());


        /*
        userTB 입력
         */
        User signupUserEntity =  SignupUserMapper.INSTANCE.toEntity(
                SignupUserDto.builder()
//                .userID(Long.valueOf(String.valueOf(signupUser.get("userID"))))  // ID 자동생성 auto_increament
                        .password(passwordEncoder.encode(signupDto.getSignupUserDto().getPassword()))
                        .GEmail(signupDto.getSignupUserDto().getGEmail())
                        .nickname(signupDto.getSignupUserDto().getNickname())
                        .region(signupDto.getSignupUserDto().getRegion())
                        .authorities(1)
                        .build());

        userRepository.save(signupUserEntity);

        System.out.println(signupUserEntity.getUserID());


        /*
        mappingUserInterestTB 입력
         */
        Long signupUserID = signupUserEntity.getUserID(); // 유저테이블 insert시 사용된 userID 호출


        for(SignupUserInterestDto interest : signupDto.getSignupInterestDtoList())
        {
            mappingUserInterestRepository.save(
                    MappingUserInterest.builder()
                            .userID(signupUserID)
                            .interestID(interest.getInterestID())
                            .build());
        }
    }


    // 회원가입 유효성 검증 함수
    public void signUpValidation(String gEmail, String nickName) {
        if (userRepository.findByGEmail(gEmail) != null) {
            throw new DuplicateEmailException("이메일이 중복됩니다.");
        }
        if (userRepository.findByNickname(nickName) != null) {
            throw new DuplicateNickNameException("닉네임이 중복됩니다.");
        }

    }




}
