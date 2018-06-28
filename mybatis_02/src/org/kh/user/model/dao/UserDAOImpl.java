package org.kh.user.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.user.model.vo.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public User idCheck(SqlSession session, String userId) {
		User user = session.selectOne("users.checkId",userId);
		return user;
	}

	@Override
	public User selectUser(SqlSession session, User user) {
		User resultUser = session.selectOne("users.selecUser", user);
		return resultUser;
	}

	@Override
	public int insertuser(SqlSession session, User user) {
		int result = session.insert("users.insertUser",user);
		return result;
	}

	@Override
	public int editUser(SqlSession session, User user) {
		int result = session.update("users.editUser", user);
		return result;
	}

	@Override
	public int exitUser(SqlSession session, User user) {
		int result = session.delete("users.deleteUser", user);
		return result;
	}

	@Override
	public ArrayList<User> selectAllList(SqlSession session) {
		List list = session.selectList("users.selectList");
		return (ArrayList<User>) list;
	}


}
