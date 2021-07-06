package com.modoostudy.OAuth2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JWTTokenEnhancer implements TokenEnhancer {


    private String getUserId(String userName){
        System.out.println(userName);
        // DB로 유저 아이디 조회
        return userName;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        String userId = getUserId(authentication.getName());

        additionalInfo.put("userId",userId);

        // 모든 추가 속성은 HashMap에 추가하고, 메서드에 전달된 accessToken 변수에 추가
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
