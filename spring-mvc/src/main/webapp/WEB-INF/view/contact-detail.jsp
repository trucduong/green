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
	<h1>Contact Detail</h1>
	<form:form modelAttribute="contact" enctype="multipart/form-data" >
		<form:errors path="*" cssClass="error-box"/>
		<div class="input-group">
			<label>Id</label>
			<form:input path="id" disabled="true"/>
		</div>
		<c:if test="${not empty contact.avatar}">
			<img width="100px" alt="Avatar" src="<spring:url value='/contact/avatar/${contact.id}'/>">
		</c:if>
		<form:input type="file" path="avatarFile" />
		<div class="input-group">
			<label>Full Name</label>
			<form:input path="name"/>
		</div>
		<div class="input-group">
			<label>Gender</label>
			<form:select path="gender" >
				<form:option value="Male">Male</form:option>
				<form:option value="Female">FeMale</form:option>
				<form:option value="Other">...</form:option>
			</form:select>
		</div>
		<div class="input-group">
			<label>Birth Date</label>
			<form:input path="birthDate" type="date" />
		</div>
		<div class="input-group">
			<label>Address</label>
			<form:textarea path="address" rows="2"/>
		</div>
		<div class="input-group">
			<label>Note</label>
			<form:textarea path="note" rows="3"/>
		</div>
		<form:button name="action" value="save">Save</form:button>
		<button type="button" onclick="window.location.href='<spring:url value="/contact" />'">Cancel</button>
	</form:form>
	
	
	<script src="<spring:url value='/resources/js/app.js' />" ></script>
</body>
</html>