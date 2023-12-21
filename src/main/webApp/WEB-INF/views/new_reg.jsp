<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration here...</h1>
	<form action="SaveReg" method ="post">
		<pre>
			First Name<input type="text" name="firstname"/> <br> <br>
			Last Name<input type="text" name = "lastname"/> <br> <br>
			Email<input type="text" name = "email"/> <br> <br>
			mobile<input type="text" name = "mobile"/> <br> <br>
			<input type="submit" value = "save"/>
		</pre>
	</form>
	${msg}
</body>
</html>