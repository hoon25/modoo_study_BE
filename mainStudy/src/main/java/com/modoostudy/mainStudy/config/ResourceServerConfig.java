package com.modoostudy.mainStudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 접근 제어 규칙 정의
 *      인증된 사용자는 모든 서비스에 접근 가능하거나,
 *      특정 역할을 가진 애플리케이션만 PUT URL 로 접근하는 등 세밀하기 정의 가능
 */
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
        http.authorizeRequests().anyRequest().authenticated();
    }
}
