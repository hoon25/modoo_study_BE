package com.modoostudy.mainStudy.dto;

import com.modoostudy.mainStudy.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class StudyDto {

//    private Long studyID;
//    private Long hostID;
    private User user;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate periodStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate periodEnd;
    private String goal;
    private String need;
    private String onoffline;
    private Long needPeople;
    private String details;
    private String studyStatus;

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
        private Long needPeople;
        private String details;
        private String studyStatus;
    }

    @Data
    @Builder
    public static class ReadStudyDetail {
        private String title;
        private String hostNickName;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodStart;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodEnd;
        private String goal;
        private String need;
        private String onoffline;
        private Long approvePeople;
        private Long needPeople;
        private String details;
        private List<String> interestName;
    }

    @Data
    @Builder
    public static class ReadStudyDetailMember {
        private String nickname;
        private String status;
    }

    @Data
    @Builder
    public static class ReadStudyList {
        private String category;
        private String title;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodStart;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate periodEnd;
        private String onoffline;
        private Long needPeople;
        private List<String> interestName;
    }

    @Data
    @Builder
    public static class MainMyStudy {
        private String title;
        private Boolean hostBoolean;
    }







}
