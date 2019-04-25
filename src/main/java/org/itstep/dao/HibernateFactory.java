package org.itstep.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.itstep.entity.Cart;
import org.itstep.entity.Item;
import org.itstep.entity.Order;
import org.itstep.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HibernateFactory {

	private SessionFactory sessionFactory;

	  public SessionFactory getSessionFactory() {
	    if (sessionFactory == null) {
	            try {
	              Configuration configuration = new Configuration();

	            Properties properties = new Properties();

	            properties.setProperty("hibernate.connection.driverClassName", "org.h2.Driver");
	            properties.setProperty("hibernate.connection.url", "jdbc:h2:~/e_store2");
	            properties.setProperty("hibernate.connection.username", "anelia");
	            properties.setProperty("hibernate.connection.password", "pass");
	            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	            properties.setProperty("hibernate.hbm2ddl.auto", "update");
	            properties.setProperty("hibernate.show_sql", "true");
	            properties.setProperty("hibernate.format_sql", "true");

	            configuration.addProperties(properties);

	            configuration.addAnnotatedClass(Item.class);
	            configuration.addAnnotatedClass(User.class);
	            configuration.addAnnotatedClass(Order.class);
	            configuration.addAnnotatedClass(Cart.class);
	            
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties()).build();
	            
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            }
	            catch (Exception e) {
	              e.printStackTrace();
	            }
	    }
	    return sessionFactory;
	  }

}
