package org.kh.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.student.model.service.StudentServiceImpl;
import org.kh.student.model.vo.Student;

/**
 * Servlet implementation class MybatisTest7Servlet
 */
@WebServlet(name = "MybatisTest7", urlPatterns = { "/mybatisTest7" })
public class MybatisTest7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest7Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> list = new StudentServiceImpl().selectAllStudent();
		
		response.setContentType("text/html; charset=utf-8");
		if(list.size()>0)
		{
			RequestDispatcher view = request.getRequestDispatcher("/views/student/studentAll.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}
		else
		{
			response.getWriter().println("실패");
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
