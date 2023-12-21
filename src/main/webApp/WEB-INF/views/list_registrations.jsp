<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All registrations</title>
</head>
<body>
	<table border="10" align ="center">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>update</th>
			
		</tr>
		<c:forEach var="reg" items="${registrations}">
			<tr>
				<td>${reg.firstname}</td>
				<td>${reg.lastname}</td>
				<td>${reg.email}</td>
				<td>${reg.mobile}</td>
				<td><a href="delete?id=${reg.id}">Delete</a></td>
				<td><a href="getById?id=${reg.id}">update</a></td>
				
			</tr>
			
		</c:forEach>
		
	</table>

</body>
</html>