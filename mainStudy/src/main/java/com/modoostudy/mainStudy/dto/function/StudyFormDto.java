package com.modoostudy.mainStudy.dto.function;

import com.modoostudy.mainStudy.dto.InterestDto;
import com.modoostudy.mainStudy.dto.RegionDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class StudyFormDto {

    private LoginUserDto loginUserDto;
    private List<InterestDto> interestDto;
    private List<RegionDto> regionDto;



}
