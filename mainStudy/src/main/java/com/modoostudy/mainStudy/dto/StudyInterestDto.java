package com.modoostudy.mainStudy.dto;

import lombok.*;

@Data
@Builder
public class StudyInterestDto {

    Long msiID;
    Long interestID;
    Long studyID;

    @Getter
    @AllArgsConstructor
    public static class registStudyInterest{
        private Long interestID;

    }

}


