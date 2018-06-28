package org.kh.user.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.user.model.vo.User;

public interface UserDAO {
	public User idCheck(SqlSession session, String id);
	public User selectUser(SqlSession session, User user);
	public int insertuser(SqlSession session, User user);
	public int editUser(SqlSession session, User user);
	public int exitUser(SqlSession session, User user);
	public ArrayList<User> selectAllList(SqlSession session);
}
