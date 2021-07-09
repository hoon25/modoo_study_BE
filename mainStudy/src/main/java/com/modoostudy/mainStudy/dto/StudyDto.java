package com.modoostudy.mainStudy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class StudyDto {

//    private Long studyID;
    private Long hostID;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate periodStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate periodEnd;
    private String goal;
    private String need;
    private Long onoffline;
    private String details;

    @Getter
    public static class RegistStudy {
        private String title;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodStart;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodEnd;
        private String goal;
        private String need;
        private Long onoffline;
        private String details;
    }





}
