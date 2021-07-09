package com.modoostudy.mainStudy.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestDto {

    private Long interestID;
    private String interestName;
    private String interestClassification;


}
