package com.springSecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() { // leave it as it is.

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { DemoAppConfig.class }; // return name of configuration file

	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" }; // this is for url mapping
	}

}
