package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import pack21.QueriesA;
import pack21.QueriesQ;

public class QuesAns extends SimpleTagSupport {
	int qid;
	String qor;
	public void setQid(int qid) {
		this.qid = qid;
	}
	public void setQor(String qor) {
		this.qor = qor;
	}
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if(qor.equals("ques"))
		{
			
			try {
				QueriesQ qq =new QueriesQ();
				String[] dat=qq.search(qid);
				if(dat!=null)
				{
					out.println("<h2>Q"+dat[0]+". "+dat[1] +"<h2>");
					out.println("<h5>By "+dat[2]+"<h5>");
				}
				else
				{
					out.println("<h2>No result<h2>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(qor.equals("ans"))
		{
			QueriesA qa = new QueriesA();
			try {
				String[][] dat = qa.viewAll(qid);
				if(dat!=null)
				{
					for(int i=0;i<dat.length;i++)
					{	
						out.println("<div class=ans>");
						out.println("<h3> A."+(i+1)+" "+dat[i][1]+"</h3>");
						out.println("<h5>By "+dat[i][2]+"</h5>");
						out.println("</div>");
					}	
				}
				else
				{
					out.println("<h3>No Result</h3>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{	
			out.println("<h2>No result<h2>");
		}	
	}

}
