package com.modoostudy.mainStudy.dto.function;

import com.modoostudy.mainStudy.dto.StudyDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Builder
public class ReadStudyListDto {


    private LoginUserDto loginUserDto;
    private List<StudyDto.ReadStudyList> readStudyListDto;






}
