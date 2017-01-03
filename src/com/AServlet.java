package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pack21.QueriesA;

/**
 * Servlet implementation class AServlet
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int qid=(int)session.getAttribute("cq");
		String auth=request.getParameter("auth");
		String ans =request.getParameter("ans");
		QueriesA qa=new QueriesA();
		try {
			if(qa.insert(qid, ans, auth))
			{
			  request.getRequestDispatcher("QuesPage.jsp").forward(request, response);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
