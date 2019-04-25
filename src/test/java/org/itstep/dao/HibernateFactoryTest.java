package org.itstep.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateFactoryTest {

	@Autowired
	HibernateFactory hibernateFactory;
	
	@Test
	public void testGetSessionFactory() {
		SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
		assertNotNull(sessionFactory);
		
		Session session = sessionFactory.openSession();
		assertNotNull(session);
		
		session.close();
	}

}
