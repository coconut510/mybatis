package org.kh.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.user.model.service.UserServiceImpl;
import org.kh.user.model.vo.User;

/**
 * Servlet implementation class MybatisVer2Test1Servlet
 */
@WebServlet(name = "MybatisVer2Test1", urlPatterns = { "/mybatisVer2Test1" })
public class MybatisVer2Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisVer2Test1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		User user = new UserServiceImpl().idCheck(userId);
		response.setContentType("text/html; charset=utf-8");
		if(user==null)
		{
			response.getWriter().println("생성할수 있는 아이디 입니다.");
		}
		else
		{
			response.getWriter().println("이미 존재하는 아이디 입니다.");
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
