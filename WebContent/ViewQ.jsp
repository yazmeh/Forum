<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="ex" uri="WEB-INF/dbtag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="validate.js"></script>
</head>
<body>
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
		<form action="CServlet">
		<%String k=request.getParameter("key");
		if(k==null){ %>
			<ex:View limit="false" specific="false"/>
		<%}
		else
		{%>
			<ex:View limit="false" specific="true" detail="<%=k%>"/>
		<%} %>	
		</form>	
	</div>
</div>	

</body>
</html>