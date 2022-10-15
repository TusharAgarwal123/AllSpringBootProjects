package com.luv2code.springboot.cruddemo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public org.springframework.web.servlet.LocaleResolver getLocaleResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {

		// there is a bug that we have to give the method name only messageSource.

		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasename("messages");
		return rb;

	}

}
