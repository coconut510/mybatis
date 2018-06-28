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
 * Servlet implementation class EditUserInfoServlet
 */
@WebServlet(name = "EditUserInfo", urlPatterns = { "/editUserInfo" })
public class EditUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserInfoServlet() {
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
		user.setUserNick(request.getParameter("userNick"));
		user.setUserTel(request.getParameter("userTel"));
		
		int result = new UserServiceImpl().editUser(user);
		response.setContentType("text/html; charset=utf-8");
		if(result>0)
		{
			response.getWriter().println("유저 정보를 수정했습니다.");
		}
		else
		{
			response.getWriter().println("유저 정보를 수정할수 없습니다.");
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
