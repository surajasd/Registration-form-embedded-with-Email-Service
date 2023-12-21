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
	<form action="updateReg" method ="post">
		<pre>
			<input type="hidden" name="id" value="${regd.id}"/>
			First Name<input type="text" name="firstname" value="${regd.firstname}"/> <br> <br>
			Last Name<input type="text" name = "lastname" value="${regd.lastname}"/> <br> <br>
			Email<input type="text" name = "email" value="${regd.email}"/> <br> <br>
			mobile<input type="text" name = "mobile" value = "${regd.mobile}"/> <br> <br>
			<input type="submit" value = "Update"/>
		</pre>
	</form>
	${msg}
</body>
</html>