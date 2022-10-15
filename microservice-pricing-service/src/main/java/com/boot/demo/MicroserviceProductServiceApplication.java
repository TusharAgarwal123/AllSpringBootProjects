package com.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviceProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductServiceApplication.class, args);
	}

	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}

}
