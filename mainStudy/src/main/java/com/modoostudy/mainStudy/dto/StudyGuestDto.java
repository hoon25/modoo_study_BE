package com.modoostudy.mainStudy.dto;

import com.modoostudy.mainStudy.entity.Study;
import com.modoostudy.mainStudy.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class StudyGuestDto {

//    private Long guestID;
//    private Long studyID;
    private User user;
    private Study study;
    private String status;

    @Data
    @NoArgsConstructor
    public static class RegistStudyGuest{
        private User user;
        private Study study;
        private String status;
    }






}
