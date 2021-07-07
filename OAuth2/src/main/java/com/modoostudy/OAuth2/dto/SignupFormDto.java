package com.modoostudy.OAuth2.dto;

import com.modoostudy.OAuth2.dto.signupForm.InterestDto;
import com.modoostudy.OAuth2.dto.signupForm.RegionDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class SignupFormDto {

    private List<InterestDto> interestDto;
    private List<RegionDto> regionDto;


}
