package org.kh.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.student.model.service.StudentServiceImpl;
import org.kh.student.model.vo.Student;

/**
 * Servlet implementation class MybatisTest6Servlet
 */
@WebServlet(name = "MybatisTest6", urlPatterns = { "/mybatisTest6" })
public class MybatisTest6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest6Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		
		Student vo = new StudentServiceImpl().selectOneStudent(studentNo);
		System.out.println("스튜던트  " + vo.getStudentAddr());
		response.setContentType("text/html; charset=utf-8");
		if(vo!=null)
		{
			RequestDispatcher view = request.getRequestDispatcher("/views/student/studentInfo.jsp");
			request.setAttribute("student", vo);
			view.forward(request, response);
		}
		else
		{
			response.getWriter().println("검색 실패");
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
