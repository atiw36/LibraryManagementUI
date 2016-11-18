<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.beans.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>User Logged Successfully</title>
</head>
<body>
	<h1>
		<center>
			<!-- part of view -->
			<%
				UserBean currentUser = (UserBean) (session
						.getAttribute("currentSessionUser"));
			%>
			Book Details are
			
			
	<table border="2">
		

		<tr>
			<td>Book Id is</td>
			<td><%=currentUser.getBookId()%></td>
			</tr>
			<tr>
			<td>Author name is</td>
			<td><%=currentUser. getAuthorName()%></td>
			</tr>
			<tr>
			<td>Book Price is</td>
			<td><%= currentUser.getPrice()%></td>
		
			
		</tr>
		</table>
		
		<Font color="red" size="10"> For searching Other books <br> <br>
		
		 <a href="userLogged.jsp">click here </a>
		</Font>
			
</center>
	</h1>
</body>
</html>
