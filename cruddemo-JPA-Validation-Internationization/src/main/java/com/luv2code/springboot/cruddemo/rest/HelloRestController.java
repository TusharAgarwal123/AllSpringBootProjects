package com.luv2code.springboot.cruddemo.rest;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRestController {

	@Autowired
	private MessageSource ms; // it is for internationalization.

	@GetMapping("/hello")
	public String sayHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		// return "GoodMorning"; rather that returning like that use message resource.
		return ms.getMessage("good.morning.message", null, locale);
	}

	// locale came in header that's why we have used the @RequestHeader.

	@GetMapping("/goodMorning")
	public String sayGoodMorning() {

		return ms.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		// now we need not to pass locale in header.
		// but for this you have to use AcceptHeaderLocaleResolver as bean.
	}

}
