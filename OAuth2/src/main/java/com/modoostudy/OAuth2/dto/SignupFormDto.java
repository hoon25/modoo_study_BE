package com.modoostudy.OAuth2.dto;

import com.modoostudy.OAuth2.dto.signupForm.InterestDto;
import com.modoostudy.OAuth2.dto.signupForm.RegionDto;
import com.modoostudy.OAuth2.model.Interest;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
public class SignupFormDto {

    private List<InterestDto> interestDto;
    private List<RegionDto> regionDto;


}
