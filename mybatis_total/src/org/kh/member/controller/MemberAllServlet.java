package org.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class MemberAllServlet
 */
@WebServlet(name = "MemberAll", urlPatterns = { "/memberAll" })
public class MemberAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=utf-8"); 
		if(session.getAttribute("member")!=null && ((Member)session.getAttribute("member")).getMemberId().equals("admin")) {
			ArrayList<Member> list = new MemberServiceImpl().selectAllMember();
			if(list.size()>0)
			{
				RequestDispatcher view = request.getRequestDispatcher("/views/admin/selectAllList.jsp");
				request.setAttribute("list", list);
				view.forward(request, response);
			}
			else
			{
				response.getWriter().println("불러올 멤버가 없습니다.");
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
