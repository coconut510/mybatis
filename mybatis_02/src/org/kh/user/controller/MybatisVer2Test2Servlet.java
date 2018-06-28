package org.kh.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.user.model.service.UserServiceImpl;
import org.kh.user.model.vo.User;

/**
 * Servlet implementation class MybatisVer2Test2Servlet
 */
@WebServlet(name = "MybatisVer2Test2", urlPatterns = { "/mybatisVer2Test2" })
public class MybatisVer2Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisVer2Test2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setUserPw(request.getParameter("userPw"));
		
		User resultUser = new UserServiceImpl().selectuser(user);
		response.setContentType("text/html; charset=utf-8");
		if(resultUser!=null)
		{
			RequestDispatcher view = request.getRequestDispatcher("/views/user/userOne.jsp");
			request.setAttribute("user", resultUser);
			view.forward(request, response);
		}
		else
		{
			response.getWriter().println("존재하지 않는 사용자 입니다.");
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
