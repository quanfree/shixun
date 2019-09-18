package com.dfrz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfrz.beans.User;
import com.dfrz.dao.UserDao;
import com.dfrz.dao.UserDaoImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hello java Servlet.....");
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		System.out.println("uname="+uname+",upass="+upass);
		UserDao userdao=(UserDao) new UserDaoImpl();
		boolean result=userdao.login(new User(uname,upass));
		if(result) {
			
			request.getRequestDispatcher("login.html").forward(request,response);
		}
		else {
			
			response.sendRedirect("qgp.html");
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
