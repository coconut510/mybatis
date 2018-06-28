package org.kh.users.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.users.model.service.UsersService;
import org.kh.users.model.vo.Check;
import org.kh.users.model.vo.User;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "MemberList", urlPatterns = { "/memberList" })
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		System.out.println(request.getParameter("chId"));
		System.out.println(request.getParameter("chPw"));
		System.out.println(request.getParameter("chName"));
		System.out.println(request.getParameter("chAddr"));
		
		String [] result = request.getParameterValues("check");
		for(int i = 0; i<result.length;i++)
		{
			System.out.println(result[i]);			
		}
		*/
		// 1.인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 값 가져오기
		
		Check check = new Check(
					request.getParameter("chId"),
					request.getParameter("chPw"),
					request.getParameter("chName"),
					request.getParameter("chAddr")
				);
		// 3. 비즈니스 로직
		ArrayList<User> list = new UsersService().checkUserList(check);
		
		// 4. 결과 리턴
		response.setContentType("text/html; charset=utf-8");
		if(!list.isEmpty())
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/users/checkList.jsp").forward(request, response);
		}
		else
		{
			response.getWriter().println("읽어오기 실패하였습니다.");
		}
	}

}
