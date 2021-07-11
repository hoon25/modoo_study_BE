package com.modoostudy.mainStudy.dto.function.study;

import com.modoostudy.mainStudy.dto.StudyDto;
import com.modoostudy.mainStudy.dto.StudyInterestDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateStudyDto {

    private StudyDto.RegistStudy registStudy;
    private List<StudyInterestDto.registStudyInterest> registStudyInterestList;


}
