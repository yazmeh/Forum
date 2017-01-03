<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="WEB-INF/dbtag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="validate.js"></script>
</head>
<body>
<div id="im">
	<img alt="hitman" src="img/headerfact.gif">
</div>
<div id="sidebar">
	<form action="CServlet">
		<ex:View limit="true" specific="true"/>
		<input id="va" type="submit" name="job" value="ViewAll">
	</form>
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
<div id="mainq">
<form action="CServlet" name ="myForm" onsubmit="return validateForm1()">
	<h3>Ask Question</h3>
	<table>
		<tr>
			<td>Question</td><td><input type="text" name="ques" placeholder="Question"></td>
		</tr>
		<tr>
			<td>Author</td><td><input type="text" name="auth" placeholder="Author"></td>
		</tr>
		<tr>
			<td></td><td><input type="submit" name="job"value="Ask"></td>
		</tr>
	</table>
</form>
</div>
</div>
</body>
</html>