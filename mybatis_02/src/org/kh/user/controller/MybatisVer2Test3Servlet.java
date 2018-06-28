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
 * Servlet implementation class MybatisVer2Test3Servlet
 */
@WebServlet(name = "MybatisVer2Test3", urlPatterns = { "/mybatisVer2Test3" })
public class MybatisVer2Test3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisVer2Test3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User u = new User();
		u.setUserId(request.getParameter("userId"));
		u.setUserPw(request.getParameter("userPw"));
		u.setUserNick(request.getParameter("userNick"));
		u.setUserTel(request.getParameter("userTel"));
		
		int result = new UserServiceImpl().insertUser(u);
		response.setContentType("text/html; charset=utf-8"); 
		if(result>0)
		{
			response.getWriter().println("아이디 생성 완료");
		}
		else
		{
			response.getWriter().println("아이디 생성 실패");
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
