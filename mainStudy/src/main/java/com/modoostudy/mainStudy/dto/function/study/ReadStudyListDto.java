package com.modoostudy.mainStudy.dto.function.study;

import com.modoostudy.mainStudy.dto.StudyDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReadStudyListDto {


    private LoginUserDto loginUserDto;
    private List<StudyDto.ReadStudyList> readStudyListDto;






}
