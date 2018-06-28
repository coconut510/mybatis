package org.kh.user.model.service;

import java.util.ArrayList;

import org.kh.user.model.vo.User;

public interface UserService {
	public User idCheck(String id);
	public User selectuser(User user);
	public int insertUser(User user);
	public int editUser(User user);
	public int exitUser(User user);
	public ArrayList<User> selectAllList();
	
}
