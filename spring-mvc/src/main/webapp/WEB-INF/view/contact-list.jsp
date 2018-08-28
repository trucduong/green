<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<spring:url value='/resources/css/app.css'/>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Management</title>
</head>
<body>
	<h1>Contact List</h1>
	<div class="action">
		<button type="button" onclick="window.location.href='<spring:url value="/contact/create" />'">Add</button>
		<button type="button" onclick="window.location.href='<spring:url value="/call-history" />'">Call History</button>
	</div>
	<table class="tbl-border">
		<tr>
			<th>Full Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Phone</th>
			<th colspan="2">Actions</th>
		<tr>
			<c:if test="${empty contacts}">
				<tr>
					<td colspan="6">Empty!</td>
				</tr>
			</c:if>
			<c:if test="${not empty contacts}">
				<c:forEach var="contact" items="${contacts}">
					<tr>
						<td>${contact.name}</td>
						<td>${contact.gender}</td>
						<td><a href='<spring:url value="/contact-email?contactId=${contact.id}" />'>View</a>
						<td><a href='<spring:url value="/contact-phone?contactId=${contact.id}" />'>View</a>
						<td>
							<button type="button" onclick="window.location.href='<spring:url value="/contact/update?contactId=${contact.id}" />'">Edit</button>
						</td>
						<td>
							<form:form action="/contact?contactId=${contact.id}" method="delete">
								<button type="submit">Delete</button>
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</c:if>
	</table>

	<script src="<spring:url value='/resources/js/app.js' />" ></script>
</body>
</html>