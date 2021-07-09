package com.modoostudy.mainStudy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class StudyInterestDto {

    Long interestID;

    @Getter
    public class registStudyInterest{
        private Long interestID;
    }

}


