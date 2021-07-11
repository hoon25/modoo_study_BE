package com.modoostudy.mainStudy.dto.function.study;

import com.modoostudy.mainStudy.dto.StudyDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReadStudyDetailDto {

    private LoginUserDto loginUserDto;
    private StudyDto.ReadStudyDetail readStudyDetail;
    private List<StudyDto.ReadStudyDetailMember> readStudyDetailMembers;

}
