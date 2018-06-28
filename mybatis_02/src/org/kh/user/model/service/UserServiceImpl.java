package org.kh.user.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.common.SqlTemplate;
import org.kh.user.model.dao.UserDAOImpl;
import org.kh.user.model.vo.User;

public class UserServiceImpl implements UserService{

	@Override
	public User idCheck(String id) {
		SqlSession session = SqlTemplate.getSqlSession();
		User user = new UserDAOImpl().idCheck(session, id);
		return user;
	}

	@Override
	public User selectuser(User user) {
		SqlSession session = SqlTemplate.getSqlSession();
		User userResult = new UserDAOImpl().selectUser(session, user);
		return userResult;
	}

	@Override
	public int insertUser(User user) {
		SqlSession session = SqlTemplate.getSqlSession();
		int result = new UserDAOImpl().insertuser(session, user);
		if(result>0) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public int editUser(User user) {
		SqlSession session = SqlTemplate.getSqlSession();
		int result = new UserDAOImpl().editUser(session, user);
		if(result>0) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public int exitUser(User user) {
		SqlSession session = SqlTemplate.getSqlSession();
		int result = new UserDAOImpl().exitUser(session, user);
		if(result>0) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public ArrayList<User> selectAllList() {
		SqlSession session = SqlTemplate.getSqlSession();
		ArrayList<User> list = new UserDAOImpl().selectAllList(session);
		return list;
	}

	

}
