package project.derivatives.busObj;

import java.util.List;

import project.derivatives.model.User;

public interface UserBo {
	public boolean create(User user);
	public boolean update(User user);
	public User edit (Long userId);
	public boolean delete (Long userId);
	public User findUser(Long userId);
	public List<User> getAll();


}
