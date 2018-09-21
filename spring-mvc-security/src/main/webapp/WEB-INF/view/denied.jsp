<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Management</title>
</head>
<body>
	<div style="float:right"><a href="<c:url value="/logout" />">Logout</a></div>
	<div>Dear <strong>${loggedinuser}</strong>, You are not authorized to access this page.</div>
	<p><a href="<c:url value="/" />">Home</a></p>
</body>
</html>