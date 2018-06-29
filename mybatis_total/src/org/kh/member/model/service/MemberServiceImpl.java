package org.kh.member.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.common.SqlTemplate;
import org.kh.member.model.dao.MemberDaoImpl;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.Search;

public class MemberServiceImpl implements MemberService{

	@Override
	public ArrayList<Member> selectAllMember() {
		SqlSession session = SqlTemplate.getSqlSession();
		ArrayList<Member> list = new MemberDaoImpl().selectAllMember(session);
		return list;
	}

	@Override
	public int memberJoin(Member m) {
		SqlSession session = SqlTemplate.getSqlSession();
		int result = new MemberDaoImpl().memberJoin(session, m);
		if(result>0) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public int memberLogOut(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(String memberId) {
		SqlSession session =  SqlTemplate.getSqlSession();
		int result = new MemberDaoImpl().memberDelete(session, memberId);
		if(result>0) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public int memberInfoEdit(Member m) {
		SqlSession session = SqlTemplate.getSqlSession();
		int result = new MemberDaoImpl().memberInfoEdit(session, m);
		if(result>0) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public Member memberLogin(Member m) {
		SqlSession session = SqlTemplate.getSqlSession();
		Member result = new MemberDaoImpl().memberLogin(session, m);
		return result;
	}

	public ArrayList<Member> searchChooseList(Search search) {
		SqlSession session = SqlTemplate.getSqlSession();
		ArrayList<Member> list = new MemberDaoImpl().searchChooseList(session, search);
		return list;
	}

	public ArrayList<Member> searchCheck1List(Check check) {
		SqlSession session = SqlTemplate.getSqlSession();
		ArrayList<Member> list = new MemberDaoImpl().searchCheck1List(session, check);
		return list;
	}

	public ArrayList<Member> searchCheck2List(String[] addr) {
		SqlSession session = SqlTemplate.getSqlSession();
		ArrayList<Member> list = new MemberDaoImpl().searchCheck2List(session, addr);
		return list;
	}

}
