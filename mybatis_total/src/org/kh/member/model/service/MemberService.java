package org.kh.member.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.Search;

public interface MemberService {
	public Member memberLogin(Member m );
	public ArrayList<Member> selectAllMember();
	public int memberJoin( Member m);
	public int memberLogOut( Member m);
	public int memberDelete( String memberId);
	public int memberInfoEdit( Member m );
	public ArrayList<Member> searchChooseList(Search search);
	public ArrayList<Member> searchCheck1List(Check check);
	public ArrayList<Member> searchCheck2List(String[] addr);
}
