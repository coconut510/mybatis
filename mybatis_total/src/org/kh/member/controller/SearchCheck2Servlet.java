package org.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class SearchCheck2Servlet
 */
@WebServlet(name = "SearchCheck2", urlPatterns = { "/searchCheck2" })
public class SearchCheck2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCheck2Servlet() {
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
			// 2. 값 저장
			String[] addr = request.getParameterValues("addr");
			
			// 3.비즈니스 로직 처리
			ArrayList<Member> list = new MemberServiceImpl().searchCheck2List(addr);
			
			
			// 4. 결과 리턴
			response.setContentType("text/html; charset=utf-8");
			if(!list.isEmpty())
			{
				request.setAttribute("list", list);
				request.getRequestDispatcher("/views/admin/memberSearchList.jsp").forward(request, response);
			}
			else
			{
				response.getWriter().println("읽어오기 실패하였습니다.");
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
