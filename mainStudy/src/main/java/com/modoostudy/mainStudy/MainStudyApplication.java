package com.modoostudy.mainStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainStudyApplication.class, args);
	}

}
