package org.kh.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.Search;

public interface MemberDao {
	public ArrayList<Member> selectAllMember(SqlSession session);
	public Member memberLogin(SqlSession session , Member m );
	public int memberJoin(SqlSession session, Member m);
	public int memberLogOut(SqlSession session, Member m);
	public int memberDelete(SqlSession session, String memberId);
	public int memberInfoEdit(SqlSession session, Member m );
	public ArrayList<Member> searchChooseList(SqlSession session, Search search);
	public ArrayList<Member> searchCheck1List(SqlSession session, Check check);
}
