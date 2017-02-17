package project.derivatives.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.derivatives.dao.UserDao;
import project.derivatives.model.User;

@Repository("userDao")
public class UserDaoImpl  implements UserDao{
      
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void create(User user) {
		
		currentSession().save(user);
		
	}

	@Override
	public void update(User user) {
		
			currentSession().update(user);
			
	}

	@Override
	public User edit(Long userId) {
		
		return findUser(userId);
	}

	@Override
	public void delete(Long userId) {
		
		
			currentSession().delete(userId);
			
	}

	@Override
	public User findUser(Long userId) {
		
		return (User)currentSession().get(User.class, userId);
	}
	@Override
	public User findUser(String user, String password){
		
		User u;
		u=(User)currentSession().get(User.class, user);
		if(u.getPass1().equals(password)){
			return u;
		}else{return null;}	
	}

	@Override
	public List<User> getAll() {
		
		return currentSession().createCriteria(User.class).list();
	}

}
