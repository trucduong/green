<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">

<link rel="stylesheet"
	href="<c:url value="/resources/css/app.css" />">
</head>
<body>
<div class="generic-container">
	<jsp:include page="../templates/header.jsp"></jsp:include>

	<div class="alert alert-success lead">
		${success}
	</div>

	<span class="well floatRight">
            Go to <a href="<c:url value='/user/list' />">Users List</a>
        </span>
</div>
</body>

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/js/app.js" />"></script>

</html>