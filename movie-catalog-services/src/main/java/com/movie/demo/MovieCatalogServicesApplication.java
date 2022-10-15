package com.movie.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableCircuitBreaker
public class MovieCatalogServicesApplication {

	@Bean
	@LoadBalanced // if we have mulitple instances of the same service registered on the eureka,
					// then it
	// will do the load balancing.

	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// use to make call using web client.

	@Bean
	public WebClient.Builder getBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServicesApplication.class, args);
	}

}
