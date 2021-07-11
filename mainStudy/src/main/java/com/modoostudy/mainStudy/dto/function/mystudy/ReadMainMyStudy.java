package com.modoostudy.mainStudy.dto.function.mystudy;

import com.modoostudy.mainStudy.dto.StudyDto;
import com.modoostudy.mainStudy.dto.function.study.LoginUserDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReadMainMyStudy {

    private LoginUserDto loginUserDto;
    private List<StudyDto.MainMyStudy> progressStudyList;
    private List<StudyDto.MainMyStudy> endStudyList;



}
