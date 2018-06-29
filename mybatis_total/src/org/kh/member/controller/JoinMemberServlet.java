package org.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class JoinMemberServlet
 */
@WebServlet(name = "JoinMember", urlPatterns = { "/joinMember" })
public class JoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		response.setContentType("text/html; charset=utf-8"); 
		if(request.getParameter("memberPw").equals(request.getParameter("memberPwRe"))) 
		{
			Member m = new Member();
			m.setMemberId(request.getParameter("memberId"));
			m.setMemberPw(request.getParameter("memberPw"));
			m.setMemberName(request.getParameter("memberName"));
			m.setMemberAddr(request.getParameter("addr"));
			m.setGender(request.getParameter("gender"));
			String[] hobbyArr = request.getParameterValues("hobby");
			String hobby = "";
			if(hobbyArr!=null) {
				for(int i =0; i<hobbyArr.length;i++)
				{
					hobby += hobbyArr[i];
					if(i<hobbyArr.length-1) hobby +=",";
				}
			}
			else hobby="없음";
			m.setHobby(hobby);
			
			int result = new MemberServiceImpl().memberJoin(m);
			if(result>0)
			{
				response.getWriter().println("회원가입을 완료했습니다.");
			}
			else
			{
				response.getWriter().println("회원가입을 실패했습니다.");
			}
		}
		else
		{
			response.getWriter().println("비밀번호가 일치하지 않습니다.");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
