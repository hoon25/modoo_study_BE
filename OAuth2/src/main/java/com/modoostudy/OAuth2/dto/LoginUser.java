package com.modoostudy.OAuth2.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUser {

    private Long userID;
    private String nickname;
    private String GEmail;


}
