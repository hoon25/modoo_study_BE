package com.modoostudy.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmblemListDto {
    List<EmblemDto> emblemListDto;
}
