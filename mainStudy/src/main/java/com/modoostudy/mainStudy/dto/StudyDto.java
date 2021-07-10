package com.modoostudy.mainStudy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private String onoffline;
    private String details;

    @Getter
    @NoArgsConstructor
    public static class RegistStudy {
        private String title;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodStart;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodEnd;
        private String goal;
        private String need;
        private String onoffline;
        private String details;
    }

    @Data
    @Builder
    public static class ReadStudyDetail {
        private String title;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodStart;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodEnd;
        private String goal;
        private String need;
        private String onoffline;
        private String details;
    }







}
