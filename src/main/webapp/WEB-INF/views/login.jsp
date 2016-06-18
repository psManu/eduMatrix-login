<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edu-Matrix | Login</title>
	<link rel="stylesheet" href='<spring:url value="/resources/css/login.css"></spring:url>' type="text/css" />
	<link rel="stylesheet" href='<spring:url value="/resources/css/w3.css"></spring:url>' type="text/css" />
	<link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>' type="text/css" />
	<script type="text/javascript" src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"></spring:url>'></script>
	
</head>
<body>
		
		<div id="loginBoxContainer">
				<div id="formdiv">
					
					<c:choose>
						<c:when test="${empty login_status}">
							<h5 style="text-align:center;">Please Login</h5>
						</c:when>
						<c:otherwise>
							<h6 style="color:red;text-align:center;">Invalid Credentials, please try again.</h6>
						</c:otherwise>
					</c:choose>
					
					<form action='<spring:url value="/login/"></spring:url>' method="POST">
						
						<c:choose>
							<c:when test="${empty saved_inst_title}">
								<select style="text-align:center;" id="instDropDown" name="inst_id">
									  <option value="" disabled selected hidden>Please Select your Institute</option>
									  <c:forEach items="${inst_list}" var="inst">
									  	<option value="${inst.instId}">${inst.instName} -- ${inst.instCity}</option>
									  </c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<h3 style="text-align:center;color:#333300;"><strong>${saved_inst_title}</strong><small>&nbsp;&nbsp;${saved_inst_city}</small></h3>
								
								<input type="hidden" name="inst_id" value="${saved_inst_id}">
							</c:otherwise>
						</c:choose>
						
						
						<input type="text" id="username" name="username" placeholder="Username">

						<input type="password" id="password" name="password" placeholder="Password">
						<input type="submit" value="Login">
					</form>
					<div>
						<a href="/Edu-Matrix/freshLogin" style="text-decoration:none;float:left;font-size:80%;">Not your institute?</a>
						<a href="#" style="display:inline;text-decoration:none;float:right;font-size:80%;">Forgot your password?</a>
					</div>
				</div>
		</div>
	
</body>
</html>