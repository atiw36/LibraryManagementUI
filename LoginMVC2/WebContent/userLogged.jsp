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
			Welcome
			<%=currentUser.getFirstName() + " "
					+ currentUser.getLastName()%>
					
					<form action="LoginServlet1">

		<fieldset>
			<legend>Katta ki library</legend>
			Please search your book <input type="text" name="book"
				placeholder="Enter book name" required /> <br> <br>
			
			<br> <input type="submit" value="submit">
		</fieldset>
		
	</form>
					
		</center>
	</h1>
</body>
</html>
