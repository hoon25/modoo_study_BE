package com.modoostudy.OAuth2.dto.signup;

import lombok.Builder;
import lombok.Data;

@Data
public class SignupUserDto {

    private Long userID;
    private String password;
    private String nickname;
    private String region;
    private String GEmail;
    private int authorities;

    @Builder
    public SignupUserDto(Long userID, String password, String nickname, String region, String GEmail, int authorities) {
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
        this.region = region;
        this.GEmail = GEmail;
        this.authorities = authorities;
    }

}

