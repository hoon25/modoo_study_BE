package com.modoostudy.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmblemDto {
    private Long emblemID;
    private String emblemName;
    private Integer emblemUsed;
    private Integer emblemOwn;
}
