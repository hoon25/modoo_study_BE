package com.modoostudy.OAuth2.dto.signup;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupUserDto {

    private Long userID;
    private String password;
    private String nickname;
    private String region;
    private String GEmail;
    private int authorities;

}

