<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP - Servlet Example</title>
</head>
<body>
	<h1>Login</h1>
	<form method="post">
		<c:if test = "${error != null}">
        		<p class="error"><c:out value = "${error}"/></p>
      	</c:if>
		Enter username : <input type="text" name="username"> <BR>
		Enter password : <input type="password" name="password"> <BR>
		<input type="submit" />
	</form>

	<script src="resources/js/app.js"></script>
</body>
</html>