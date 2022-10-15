package com.photoApi.account.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // it is optional annotation use to tell that this is eureka client serivce.
public class PhotoAppApiAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccountApplication.class, args);
	}

}
