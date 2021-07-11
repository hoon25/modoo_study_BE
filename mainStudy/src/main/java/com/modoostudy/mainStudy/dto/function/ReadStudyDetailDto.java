package com.modoostudy.mainStudy.dto.function;

import com.modoostudy.mainStudy.dto.StudyDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ReadStudyDetailDto {

    private StudyDto.ReadStudyDetail readStudyDetail;
    private List<StudyDto.ReadStudyDetailMember> readStudyDetailMembers;

}
