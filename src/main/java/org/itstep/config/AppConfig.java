package org.itstep.config;

import org.itstep.dao.HibernateFactory;
import org.itstep.dao.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {

	@Bean
	public HibernateFactory hibernateFactory() {
		return new HibernateFactory();
	}
	
	@Bean
	public UserDAO userDAO() {
		return new UserDAO();
	}
}
