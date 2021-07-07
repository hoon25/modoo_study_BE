package com.modoostudy.OAuth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * 모든 접근 규칙을 재정의한 configure()
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 매서드로 전달된 HttpSecurity 객체로 모든 접근 규칙 구성

        // 회원 서비스의 모든 URL 에 대해 인증된 사용자만 접근하도록 제한
        http.authorizeRequests()
//                .antMatchers("/free").permitAll()
                .anyRequest().permitAll();
//        .and()
//        .oauth2Login().loginPage("/login");

    }
}
