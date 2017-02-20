package project.derivatives.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import project.derivatives.dao.UserDao;
import project.derivatives.model.User;

@Repository("userDao")
public class UserDaoImpl  implements UserDao{
      
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	
	//protected Session currentSession(){
	//	return sessionFactory.getCurrentSession();
	//}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Override
	public void create(User user) {
		 session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		if(user !=null){
		
			try{
				session.save(user);
	            tx.commit();
		        session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		}
		
	}

	@Override
	public void update(User user) {
		session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		try{
			session.update(user);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
	}

	@Override
	public User edit(Long userId) {
		
		return findUser(userId);
	}

	@Override
	public void delete(Long userId) {
		session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		try{
			session.delete(userId);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
			
	}

	@Override
	public User findUser(Long userId) {
		session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		User u = new User();
		try{
		
		 u=(User) session.get(User.class, userId);
		tx.commit();
		session.close();
		
	}catch(Exception e){
		tx.rollback();
		session.close();
		e.printStackTrace();
		
	}
		return u;
		
	}
	@Override
	public User findUser(String user, String password){
		
		User u=null;
		/*
		u=(User)currentSession().get(User.class, user);
		if(u.getPass1().equals(password)){
			return u;
		}else {return null;}
		*/
		
	//	 boolean userFound = false;
	        String hql = "from users where user =? and pass1=?";
	     //   logger.info(sessionFactory.getCurrentSession().createQuery(hql));
	        session = sessionFactory.openSession();
	        Transaction tx= session.beginTransaction();
	       try{ 
	        Query query = session.createQuery(hql);
	        query.setParameter(0, user);
	        query.setParameter(1, password);
	       u= (User) query.uniqueResult();
	        //List userList = query.list();
	        
	        //if ((userList != null) && (userList.size()== 0)){
	        	tx.commit();
	    		session.close();
	    		// return (User) userList.get(0);
	    		
	        }
	        catch (Exception e){
	        	tx.rollback();
	    		session.close();
	    		e.printStackTrace();
	    		
	        }
	       
	       return u;
	    }
	

	@Override
	public List<User> getAll() {
		
		return session.createCriteria(User.class).list();
	}

}
