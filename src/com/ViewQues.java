package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import pack2.Connector;
import pack21.QueriesQ;

public class ViewQues extends SimpleTagSupport {
 
 boolean limit;
 boolean specific;
 String detail;
 public void setLimit(boolean limit) {
		this.limit = limit;
	}

	public void setSpecific(boolean specific) {
		this.specific = specific;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
 @Override
public void doTag() throws JspException, IOException {
	new Connector();
	
	
	JspWriter out = getJspContext().getOut();
	try {
			QueriesQ q = new QueriesQ();
		if(limit)
		{	
			String[][] dat= q.viewAll();
			out.println("<table id=\"result\"><tr><th>View</th><th>Question</th><th>Author</th><th>Status</th></tr>");
			for(int i=0;i<5&&i<dat.length;i++)
			{
				out.println("<tr>");
				out.println("<td><input type=\"Submit\"  name=\"job\" value=\""+dat[i][0]+"\" /></td>");
				out.println("<td>"+dat[i][1]+"</td>");
				out.println("<td>"+dat[i][2]+"</td>");
				out.println("<td>"+dat[i][3]+"</td>");
				out.println("</	tr>");
				
			}
			out.println("</table>");
		}
		else
		{
			if(!specific)
			{
				String[][] dat= q.viewAll();
				out.println("<table id=\"resultV\"><tr><th>View</th><th>Question</th><th>Author</th><th>Status</th></tr>");
				for(int i=0;i<dat.length;i++)
				{
					out.println("<tr>");
					out.println("<td><input type=\"Submit\"  name=\"job\" value=\""+dat[i][0]+"\" /></td>");
					out.println("<td>"+dat[i][1]+"</td>");
					out.println("<td>"+dat[i][2]+"</td>");
					out.println("<td>"+dat[i][3]+"</td>");
					out.println("</	tr>");
					
				}
				out.println("</table>");
			}
			else
			{
				String[][] dat= q.search(detail);
				if(dat!=null)
				{	
					out.println("<table id=\"resultV\"><tr><th>View</th><th>Question</th><th>Author</th><th>Status</th></tr>");
					for(int i=0;i<dat.length;i++)
					{
						out.println("<tr>");
						out.println("<td><input type=\"Submit\"  name=\"job\" value=\""+dat[i][0]+"\" /></td>");
						out.println("<td>"+dat[i][1]+"</td>");
						out.println("<td>"+dat[i][2]+"</td>");
						out.println("<td>"+dat[i][3]+"</td>");
						out.println("</	tr>");
					
					}
					out.println("</table>");
				}
				else
				{
					out.println("<h2>No Results!!</h2>");
				}
			}
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }


}
