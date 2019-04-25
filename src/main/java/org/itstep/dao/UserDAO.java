package org.itstep.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	@Autowired
	HibernateFactory hibernateFactory;
	
	private final SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
	  
	  public void saveOrUpdate(User user){
	    Session session = sessionFactory.openSession();
	        session.getTransaction().begin();
	        session.saveOrUpdate(user);
	        session.getTransaction().commit();
	        session.close();    
	  }
	  
	  public User findOne(Integer id){
	    Session session = sessionFactory.openSession();
	        session.getTransaction().begin();
	        User userFromDB = (User)session.find(User.class, id);
	        session.getTransaction().commit();
	        session.close();
	        return userFromDB;
	  }

	  public List<User> findAll(){
	    Session session = sessionFactory.openSession();
	        session.getTransaction().begin();
	        
	        String sql = "SELECT * FROM users";
	              
	        List<User> result = session.createNativeQuery(sql).getResultList();
	        session.close();
	        return result;
	  }
	  
	  public void delete(User user) {
	    Session session = sessionFactory.openSession();
	        session.getTransaction().begin();
	        session.delete(user);
	        session.getTransaction().commit();
	        session.close();
	  }

}
