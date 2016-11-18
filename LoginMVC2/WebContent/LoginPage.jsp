<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
function myFunction() {
	
	
		window.location.href = "SignUp.jsp";
	}

	</script> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC Example..</title>
</head>
<body>
	<!-- Part of view -->
	<form action="LoginServlet">
	<center>
		<fieldset>
			<legend>Login Info</legend>
			Please enter your username <input type="text" name="un"
				placeholder="Enter your Nane" required /> <br> <br>
			<br> Please enter your password <input type="password" name="pw"
				placeholder="Enter your Password" required /> <br> <br>
			<br> <input type="submit" value="submit">
			<button onclick="myFunction()">Sign up</button>		
			</fieldset>
		</center>
	</form>
</body>
</html>
