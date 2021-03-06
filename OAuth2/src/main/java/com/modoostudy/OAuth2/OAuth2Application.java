package com.modoostudy.OAuth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableResourceServer
@EnableAuthorizationServer
public class OAuth2Application {

	/**
	 * 토큰 검증해주는 콜백 url "http://localhost:8095/check"
	 * @param user
	 * @return
	 */

	@RequestMapping(value="/check")
	public Map<String,Object> user(OAuth2Authentication user) {
		Map<String,Object> userInfo = new HashMap<>();
		userInfo.put("user",user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		System.out.println(userInfo);
		return userInfo;
	}


	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
	}

}

