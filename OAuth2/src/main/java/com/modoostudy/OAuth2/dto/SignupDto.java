package com.modoostudy.OAuth2.dto;

import com.modoostudy.OAuth2.dto.signup.SignupUserInterestDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SignupDto {

    private SignupUserDto signupUserDto;
    private List<SignupUserInterestDto> signupInterestDtoList;
}

