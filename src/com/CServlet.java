package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static pack21.QueriesQ.lid;
/**
 * Servlet implementation class CServlet
 */
@WebServlet("/CServlet")
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private boolean isNumber(String x)
       {
    	   try
    	   {
    		   int n = Integer.parseInt(x);
    		   return true;
    	   }
    	   catch(NumberFormatException E)
    	   {
    		   return false;
    	   }
       }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ch = request.getParameter("job");
		HttpSession session = request.getSession();
		if(!isNumber(ch))
		{	
			if(ch==null)
			{
				System.out.println("Err");
			}
			else if(ch.equals("Ask"))
			{
				request.getRequestDispatcher("IServlet").forward(request, response);
			}
			else if (ch.equals("comment")) 
			{
				request.getRequestDispatcher("AServlet").forward(request, response);
			}
			else if(ch.equals("ViewAll"))
			{
				request.getRequestDispatcher("ViewQ.jsp").forward(request, response);
			}
			else if (ch.equals("search")) {
				request.getRequestDispatcher("ViewQ.jsp").forward(request, response);
			}
			else if (ch.equals("Previous Question")) 
			{
				int x=(int)session.getAttribute("cq");
				if(x!=1)
					session.setAttribute("cq",x-1);
				request.getRequestDispatcher("QuesPage.jsp").forward(request, response);
			}
			else if (ch.equals("Next Question")) 
			{
			
				int x=(int)session.getAttribute("cq");
				if(x!=lid)
					session.setAttribute("cq",x+1);
				
				request.getRequestDispatcher("QuesPage.jsp").forward(request, response);
			}
			else if (ch.equals("Last Question")) 
			{
				session.setAttribute("cq",lid);
				request.getRequestDispatcher("QuesPage.jsp").forward(request, response);
			}
			else if (ch.equals("First Question")) 
			{
				
				session.setAttribute("cq",1);
				request.getRequestDispatcher("QuesPage.jsp").forward(request, response);
			}
			
		}
		else
		{
			int x=Integer.parseInt(ch);
			
			session.setAttribute("cq",x);
			request.getRequestDispatcher("QuesPage.jsp").forward(request, response);
		}
	}


}
