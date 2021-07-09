package com.modoostudy.mainStudy.dto.function;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserDto {

    private Long userID;
    private String nickName;
    private String GEmail;

}
