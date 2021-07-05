package com.modoostudy.OAuth2.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class CustomConfig {

    @Value("${signing.key}")
    private String jwtSigningKey = "";

    public String getJwtSigningKey(){
        System.out.println(jwtSigningKey);
        return jwtSigningKey;
    }
}
