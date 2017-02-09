package project.derivatives.busObjImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.derivatives.busObj.UserBo;
import project.derivatives.dao.UserDao;
import project.derivatives.model.User;

public class UserBoImpl  implements UserBo{
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean create(User user) {
		try{
		userDao.create(user);
		return false;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try{
			userDao.update(user);
			return false;
			}catch(Exception ex){
				return false;
			}
	}

	@Override
	public User edit(Long userId) {
		
		return userDao.edit(userId);
	}

	@Override
	public boolean delete(Long userId) {
		
		try{
			userDao.delete(userId);
			return false;
			}catch(Exception ex){
				return false;
			}
	}

	@Override
	public User findUser(Long userId) {
		
		return userDao.findUser(userId);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

}
