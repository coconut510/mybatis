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
import org.kh.member.model.vo.Search;

/**
 * Servlet implementation class SearchChooseServlet
 */
@WebServlet(name = "SearchChoose", urlPatterns = { "/searchChoose" })
public class SearchChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchChooseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("member")!=null && ((Member)session.getAttribute("member")).getMemberId().equals("admin")) {
			String select = request.getParameter("select");
			String keyword = request.getParameter("keyword");

			Search search = new Search(select, keyword);

			ArrayList<Member> list = new MemberServiceImpl().searchChooseList(search);
			response.setContentType("text/html; charset=utf-8");
			if(!list.isEmpty()) {
				RequestDispatcher view = request.getRequestDispatcher("/views/admin/memberSearchList.jsp");
				request.setAttribute("list", list);
				view.forward(request, response);
			}
			else
			{
				response.getWriter().println("불러올 정보가 없습니다.");
			}
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
