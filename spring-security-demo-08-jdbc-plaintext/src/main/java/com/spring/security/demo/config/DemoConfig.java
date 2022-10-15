package com.spring.security.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.security.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoConfig {

	private Logger ll = Logger.getLogger(getClass().getName());

	@Autowired
	private Environment env; // spring class that will hold data read from mysql.properties file.

	@Bean
	public DataSource securityDataSource() {

		ComboPooledDataSource ss = new ComboPooledDataSource();

		try {
			ss.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		// for security stake let's log user and url just to make sure we are reading
		// the data.

		ll.info(">>jdbc.url=" + env.getProperty("jdbc.url"));
		ll.info(">>jdbc.user=" + env.getProperty("jdbc.user"));

		// set the connection property.

		ss.setJdbcUrl(env.getProperty("jdbc.url"));
		ss.setUser(env.getProperty("jdbc.user"));
		ss.setPassword(env.getProperty("jdbc.password"));

		// set the connection pool property.
		ss.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		ss.setMinPoolSize(helper("connection.pool.minPoolSize"));
		ss.setMaxPoolSize(helper("connection.pool.maxPoolSize"));
		ss.setMaxIdleTime(helper("connection.pool.maxIdleTime"));

		return ss;

	}

	// helper method
	// read environment method and convert to int.

	private int helper(String str) {
		String ans = env.getProperty(str);
		return Integer.parseInt(ans);
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
