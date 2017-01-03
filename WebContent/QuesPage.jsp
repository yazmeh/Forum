<%@page import="pack21.QueriesQ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="ex" uri="WEB-INF/dbtag.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="validate.js"></script>
</head>
<body>
<%	
	HttpSession session2 = request.getSession();
	int x=(int)session2.getAttribute("cq");
	
%>
<div id="sidebar">
	<form action="CServlet" name="search" onsubmit="return validateSearch()">
		<table id="insb">
			<tr>
				<td>Keyword</td><td><input name="key" type="text"></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" name="job" value="search">
				<a href="index.jsp"><input type="button" value="Home"></a></td>
			</tr>
		</table>
	</form>
</div>

<div id="main">
	<div id="ques">
		<ex:Display qor="ques" qid="<%=x%>"/>
	</div>
	<div id="ans">
		<ex:Display qor="ans" qid="<%=x%>"/>
	</div>
	<div id="addans">
		<form action="CServlet" id="aa" name="myForm" onsubmit="return validateForm2()">
			<table>
				<tr>
					<td>Name:</td><td><input type="text" id="auth" name="auth" placeholder="Author"></td>
				</tr>
				<tr>
					<td>Answer:</td><td><textarea rows="4" cols="50" placeholder="Answer" name="ans" form="aa" ></textarea></td>
				</tr>
				<tr>	
					<td></td><td><input type="submit" name="job" value="comment"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="mf">
		<form action="CServlet">
			<%if(x!=1){ %>
				<a href="CServlet?job=1"><input type="button" name="job" value="First Question"></a>
				<a href="CServlet?job=<%=x-1%>"><input type="button" name="job" value="Previous Question"></a>
			<%} 
			if (x!=(QueriesQ.lid))
			{%>
				
				<a href="CServlet?job=<%=x+1%>"><input type="button" name="job" value="Next Question"></a>
				<a href="CServlet?job=<%=QueriesQ.lid%>"><input type="button" name="job" value="Last Question"></a>
			<%} %>

	</form>
	</div>	
</div>


</body>
</html>