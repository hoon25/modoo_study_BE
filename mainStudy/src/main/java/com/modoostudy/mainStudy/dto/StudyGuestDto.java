package com.modoostudy.mainStudy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class StudyGuestDto {

    private Long msgID;
    private Long guestID;
    private Long studyID;
    private String status;

    @Data
    @NoArgsConstructor
    public static class RegistStudyGuest{
        private Long msgID;
        private Long guestID;
        private Long studyID;
        private String status;
    }





}
