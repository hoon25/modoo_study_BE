package com.modoostudy.mainStudy.dto.functionDto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ReadStudyDto {

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
