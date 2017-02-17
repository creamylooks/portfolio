package project.derivatives.busObj;

import java.util.List;

import project.derivatives.model.User;

public interface UserBo {
	public void create(User user);
	public void update(User user);
	public User edit (Long userId);
	public void delete (Long userId);
	public User findUser(Long userId);
	public User findUser(String username, String password);
	public List<User> getAll();


}
