<%@page import="utils.Constants"%>
<%@page import="utils.Utils"%>
<%@page import="com.green.example.model.ContactDetailModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Management</title>
</head>
<body>
	<%
		ContactDetailModel model = (ContactDetailModel) request.getAttribute("model");
	%>

	<h1><%=model.isUpdating() ? "Update Contact" : "Create Contact"%></h1>
	
	<form action="<%=Utils.getUrl(request, "/contact-detail") %>" method="post">
		<input type="hidden" name="id" value="<%=model.getId() %>" />
		<input type="hidden" name="action" value="<%=model.isUpdating() ? Constants.UPDATE : Constants.CREATE %>" />
		
		<table class="tbl-border">
			<%
				if (model.isUpdating()) {
			%>
			<tr>
				<td>ID</td>
				<td><%=model.getId() %></td>
			<tr>
			<%
				}
			%>
			<tr>
				<td>Full Name</td>
				<td><%=model.getName() %></td>
			<tr>
			<tr>
				<td>Address</td>
				<td><%=model.getAddress() %></td>
			<tr>
		</table>

		<div class="action">
			<button type="submit">Submit</button>
			<button type="button"
				onclick="window.location.href='<%=Utils.getUrl(request, "/home")%>'">Cancel</button>
		</div>

	</form>
	<script src="resources/js/app.js"></script>
</body>
</html>