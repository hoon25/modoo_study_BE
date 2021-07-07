package com.modoostudy.OAuth2.dto.signup;

import lombok.*;

import java.util.List;

@Data
@Builder
public class SignupUserDto {

    private String password;
    private String nickname;
    private String region;
    private String GEmail;
    private int authorities;


}

