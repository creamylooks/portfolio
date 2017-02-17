package project.derivatives.busObjImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.derivatives.busObj.UserBo;
import project.derivatives.dao.UserDao;
import project.derivatives.model.User;

@Service("userBo")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserBoImpl  implements UserBo{
	
	@Autowired
	UserDao userDao;

	@Override
	public void create(User user) {
		
		userDao.create(user);
	}

	@Override
	public void update(User user) {
		
			userDao.update(user);
			
	}

	@Override
	public User edit(Long userId) {
		
		return userDao.edit(userId);
	}

	@Override
	public void delete(Long userId) {
		
		
			userDao.delete(userId);
			
	}

	@Override
	public User findUser(Long userId) {
		
		return userDao.findUser(userId);
	}
	@Override 
	public User findUser(String user, String password){
		return userDao.findUser(user, password);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

}
