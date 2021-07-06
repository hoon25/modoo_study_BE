package com.modoostudy.OAuth2.security;

import com.modoostudy.OAuth2.dto.LoginUser;
import com.modoostudy.OAuth2.model.User;
import com.modoostudy.OAuth2.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;


/**
 * jwt 토큰을 튜닝해서 유저 정보를 넣어줌
 */
@Configuration
public class JWTTokenEnhancer implements TokenEnhancer {

    private UserRepository userRepository;

    private LoginUser getUserId(String userName){

        User userInfo = userRepository.findByGEmail(userName);
        return LoginUser.builder()
                .userID(userInfo.getUserID())
                .nickname(userInfo.getNickname())
                .GEmail(userInfo.getNickname())
                .build();
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
//        String userId = getUserId(authentication.getName());

        LoginUser loginUser = getUserId(authentication.getName());

        additionalInfo.put("loginUser",loginUser);

        // 모든 추가 속성은 HashMap에 추가하고, 메서드에 전달된 accessToken 변수에 추가
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
