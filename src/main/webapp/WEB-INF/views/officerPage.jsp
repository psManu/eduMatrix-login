<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Officer Dashboard</title>
<style>
tr, td {border:2px solid black;}
</style>
</head>
<body>
	<h3>Hi, This is Home page for officers</h3>
	<table>
		<tr>
			<td><label>Name:</label></td><td><c:out value="${sessionScope.user.name}" /><br></td>
		</tr>
		<tr>
			<td><label>Institute-ID:</label></td><td><c:out value="${sessionScope.user.instId}" /><br></td>
		</tr>
		<tr>
			<td><label>Username:</label></td><td><c:out value="${sessionScope.user.userName}" /><br></td>
		</tr>
		<tr>
			<td><label>User-ID:</label></td><td><c:out value="${sessionScope.user.userId}" /><br></td>
		</tr>
		<tr>
			<td><label>DB Schema name:</label></td><td><c:out value="${sessionScope.user.schemaName}" /><br></td>
		</tr>
		<tr>
			<td><label>Auth-Level:</label></td><td><c:out value="${sessionScope.user.authLevel}" /><br></td>
		</tr>
	</table>
	<br><br><br>
	<a href='<spring:url value="/logout"></spring:url>'>Log out</a>
</body>
</html>