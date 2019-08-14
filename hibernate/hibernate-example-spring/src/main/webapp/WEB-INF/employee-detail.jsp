<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hibernate Example</title>
</head>
<body>
	<h1>Employee Detail</h1>
	<form action="<%=request.getContextPath()%>/employee/detail" method="post">
		<input type="hidden" name="action" value="${action}">
		<input type="hidden" name="id" value="${_employee.id}">
		<table>
			<%
				if ("update".equals(request.getAttribute("action"))) {
			%>
			<tr>
				<td>Id</td>
				<td><input value="${_employee.id}" disabled="disabled">
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td>First Name</td>
				<td><input name="name" value="${_employee.firstName}"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input name="name" value="${_employee.lastName}"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input name="description" type="number" value="${_employee.salary}">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form>
	<div>
		<a href="<%=request.getContextPath()%>/employee">Back to List</a>
	</div>
</body>
</html>