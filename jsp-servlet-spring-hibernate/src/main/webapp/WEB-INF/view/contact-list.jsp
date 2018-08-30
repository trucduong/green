<%@page import="utils.Utils"%>
<%@page import="com.green.example.entity.Contact"%>
<%@page import="com.green.example.model.HomeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Management</title>
</head>
<%
	HomeModel model = (HomeModel) request.getAttribute("model");
%>
<body>
	<h1>Contact List</h1>
	<div class="action">
		<button type="button" onclick="window.location.href='<%=Utils.getUrl(request, "/contact/create") %>'" >Add</button>
		<button type="button" onclick="window.location.href='<%=Utils.getUrl(request, "/call-history") %>'" >Call History</button>
	</div>
	<table class="tbl-border">
		<tr>
			<th>Full Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Phone</th>
			<th colspan="2">Actions</th>
		<tr>
		<%
			if (!model.isEmpty()) {
				for (Contact contact : model.getContacts()) {
		%>
		<tr>
			<td><%=contact.getName() %></td>
			<td><%=contact.getGender().toString() %></td>
			<td><a href="<%=Utils.getUrl(request, "/contact-email?contactId=" + contact.getId())%>">View</a></td>
			<td><a href="<%=Utils.getUrl(request, "/contact-phone?contactId=" + contact.getId())%>">View</a></td>
			<td>
				<form action="<%=Utils.getUrl(request, "/contact/update") %>" method="get">
					<input type="hidden" name="contactId" value="<%=contact.getId() %>"/>
					<button type="submit" >Edit</button>
				</form>
			</td>
			<td>
				<form action="<%=Utils.getUrl(request, "/contact/delete") %>" method="post">
					<input type="hidden" name="contactId" value="<%=contact.getId() %>"/>
					<button type="submit" >Delete</button>
				</form>
			</td>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="6" >Empty!</td>
		</tr>
		<% } %>
	</table>

	<script src="resources/js/app.js"></script>
</body>
</html>