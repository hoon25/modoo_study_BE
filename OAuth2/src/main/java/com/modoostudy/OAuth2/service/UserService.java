package com.modoostudy.OAuth2.service;

import com.modoostudy.OAuth2.dto.SignupFormDto;
import com.modoostudy.OAuth2.dto.signupForm.InterestDto;
import com.modoostudy.OAuth2.mapper.InterestMapper;
import com.modoostudy.OAuth2.mapper.RegionMapper;
import com.modoostudy.OAuth2.model.Interest;
import com.modoostudy.OAuth2.repository.InterestRepository;
import com.modoostudy.OAuth2.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private RegionRepository regionRepository;

    // 회원가입 양식제공 서비스
    public SignupFormDto getSignupForm(){

        return SignupFormDto.builder()
                .interestDto(InterestMapper.INSTANCE.toDto(interestRepository.findAll()))
                .regionDto(RegionMapper.INSTANCE.toDto(regionRepository.findAll()))
                .build();
    }

}
