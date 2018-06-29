package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(name = "MemberLogin", urlPatterns = { "/memberLogin" })
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();	
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		
		Member resultM = new MemberServiceImpl().memberLogin(m);
		
		response.setContentType("text/html; charset=utf-8"); 
		if(resultM!=null)
		{
			if(session.getAttribute("member")!=null) 	session.invalidate();
			else session.setAttribute("member", resultM);
			
			response.getWriter().println("로그인 성공");
			response.getWriter().println("<a href='/index.jsp'>메인 페이지로 이동</a>");
			/*RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("member", resultM);
			view.forward(request, response);*/
		}
		else
		{
			response.getWriter().println("로그인 실패");
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
