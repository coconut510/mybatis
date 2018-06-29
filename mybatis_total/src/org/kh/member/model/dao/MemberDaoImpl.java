package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.Search;

public class MemberDaoImpl implements MemberDao{

	@Override
	public ArrayList<Member> selectAllMember(SqlSession session) {
		List list = session.selectList("members.memberAllList");
		return (ArrayList<Member>)list;
	}

	@Override
	public int memberJoin(SqlSession session, Member m) {
		int result = session.insert("members.memberJoin", m);
		return result;
	}

	@Override
	public int memberLogOut(SqlSession session, Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(SqlSession session, String memberId) {
		System.out.println(memberId);
		int result = session.delete("members.memberDelete", memberId);
		return result;
	}

	@Override
	public int memberInfoEdit(SqlSession session, Member m) {
		int result = session.update("members.memberInfoEdit", m);
		return result;
	}

	@Override
	public Member memberLogin(SqlSession session, Member m) {
		Member result = session.selectOne("members.memberLogin", m);
		return result;
	}

	public ArrayList<Member> searchChooseList(SqlSession session, Search search) {
		List list = session.selectList("members.memberChooseList", search);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> searchCheck1List(SqlSession session, Check check) {
		List list = session.selectList("members.memberSearchCheck1", check);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> searchCheck2List(SqlSession session, String[] addr) {
		List list = session.selectList("members.memberSearchCheck2", addr);
		return (ArrayList<Member>)list;
	}

}
