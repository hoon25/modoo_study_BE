package com.modoostudy.OAuth2.dto;


import lombok.Builder;
import lombok.Data;


/**
 * 로그인 이후 jwt 토큰에 담긴 유저 정보 모음
 */
@Data
@Builder
public class LoginUser {

    private Long userID;
    private String nickname;
    private String GEmail;


}
