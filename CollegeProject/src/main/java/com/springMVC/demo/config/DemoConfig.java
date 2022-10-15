package com.springMVC.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.springMVC.demo")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class DemoConfig {

	@Autowired
	private Environment env;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}

	public DataSource securityDataSource() {
		ComboPooledDataSource cd = new ComboPooledDataSource();

		try {
			cd.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		cd.setJdbcUrl(env.getProperty("jdbc.url"));
		cd.setUser(env.getProperty("jdbc.user"));
		cd.setPassword(env.getProperty("jdbc.password"));

		// set the connection pool property.
		cd.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		cd.setMinPoolSize(helper("connection.pool.minPoolSize"));
		cd.setMaxPoolSize(helper("connection.pool.maxPoolSize"));
		cd.setMaxIdleTime(helper("connection.pool.maxIdleTime"));

		return cd;
	}

	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

		return props;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		// set the properties
		sessionFactory.setDataSource(securityDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hiberante.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;

	}

	private int helper(String str) {
		String ans = env.getProperty(str);
		return Integer.parseInt(ans);
	}

}
