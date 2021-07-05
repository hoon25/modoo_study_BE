package com.modoostudy.mainStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.Collections;
import java.util.List;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer

public class MainStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainStudyApplication.class, args);
	}

}
