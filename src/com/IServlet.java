package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack21.QueriesQ;

/**
 * Servlet implementation class IServlet
 */
@WebServlet("/IServlet")
public class IServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueriesQ qq = new QueriesQ();
		String ques=request.getParameter("ques");
		String auth=request.getParameter("auth");
		try {
			System.out.println("in");
			request.setAttribute("sus", false);
			boolean x=qq.insert(ques, auth);
			request.setAttribute("sus", x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
