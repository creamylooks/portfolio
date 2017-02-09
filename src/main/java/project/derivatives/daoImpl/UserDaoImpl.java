package project.derivatives.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public boolean create(User user) {
		try{
		currentSession().save(user);
		return true;
		}catch (Exception ex){
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try{
			currentSession().update(user);
			return true;
			}catch (Exception ex){
				return false;
			}
	}

	@Override
	public User edit(Long userId) {
		
		return findUser(userId);
	}

	@Override
	public boolean delete(Long userId) {
		
		try{
			currentSession().delete(userId);
			return true;
			}catch (Exception ex){
				return false;
			}
	}

	@Override
	public User findUser(Long userId) {
		
		return (User)currentSession().get(User.class, userId);
	}

	@Override
	public List<User> getAll() {
		
		return currentSession().createCriteria(User.class).list();
	}

}
