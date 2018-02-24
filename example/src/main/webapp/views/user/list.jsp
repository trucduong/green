<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading"><span class="lead">List of Users </span></div>
		<table class="table table-hover">
			<thead>
			<tr>
				<th>name</th>
				<th>Email</th>
				<th>LoginName</th>
				<sec:authorize access="hasRole('ADMIN')">
					<th width="100"></th>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')">
					<th width="100"></th>
				</sec:authorize>

			</tr>
			</thead>
			<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.fullName}</td>
					<td>${user.email}</td>
					<td>${user.userName}</td>
					<sec:authorize access="hasRole('ADMIN')">
						<td><a href="<c:url value='/user/edit-user-${user.userName}' />" class="btn btn-success custom-width">edit</a></td>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN')">
						<td><a href="<c:url value='/user/delete-user-${user.userName}' />" class="btn btn-danger custom-width">delete</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<sec:authorize access="hasRole('ADMIN')">
		<div class="well">
			<a href="<c:url value='/user/newuser' />">Add New User</a>
		</div>
	</sec:authorize>
</div>
</body>

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/js/app.js" />"></script>

</html>