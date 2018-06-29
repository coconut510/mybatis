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
import org.kh.member.model.vo.*;

/**
 * Servlet implementation class MyInfoEditServlet
 */
@WebServlet(name = "MyInfoEdit", urlPatterns = { "/myInfoEdit" })
public class MyInfoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		if(m!=null) {
			m.setMemberPw(request.getParameter("memberPw"));
			
			int result = new MemberServiceImpl().memberInfoEdit(m);
			response.setContentType("text/html; charset=utf-8"); 
			if(result>0)
			{
				RequestDispatcher view = request.getRequestDispatcher("/views/member/memberEditSuccess.jsp");
				session.setAttribute("member", m);
				view.forward(request, response);
			}
			else
			{
				response.getWriter().println("변경실패");
			}
		}
		else
		{
			response.getWriter().println("잘못된 접근입니다.");
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
