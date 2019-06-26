<%@page import="utils.Utils"%>
<%@page import="com.green.example.model.ContactDetailModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Management</title>
</head>
<body>
	<%
		ContactDetailModel model = (ContactDetailModel) request.getAttribute("model");
	%>
	
	<h1><%=model.isUpdating()?"Update Contact":"Create Contact" %></h1>
	
	<% if (model.isErrContactNotFound()) { %>
		<p class="error">Contact not found!</p>
	<% } else { %>
	
		<% if (model.isUpdating()) { %>
			<div class="action">
				<form action="<%=Utils.getUrl(request, "/contact/delete") %>" method="post">
					<input type="hidden" name="contactId" value="<%=model.getId() %>"/>
					<button type="submit" >Delete</button>
				</form>
			</div>
		<% } %>
	
		<form method="post">
			<input type="hidden" name="id" value="<%=model.getId() %>" />
			
			<table class="tbl-border">
				<% if (model.isUpdating()) { %>
				<tr>
					<td>ID</td>
					<td><%=model.getId() %></td>
				<tr>
				<% } %>
				<tr>
					<td>Full Name</td>
					<td><input name="name" value="<%=model.getName() %>" /></td>
				<tr>
				<tr>
					<td>Gender</td>
					<td>
						<select name="gender" >
							<option value="Male" label="Male" <%=model.isGender("Male") ? "selected" : "" %> />
							<option value="Female" label="Female" <%=model.isGender("Female") ? "selected" : "" %> />
							<option value="Other" label="Other" <%=model.isGender("Other") ? "selected" : "" %> />
						</select>
					</td>
				<tr>
				<tr>
					<td>Birth Date</td>
					<td><input type="date" name="birthDate" value="<%=model.getBirthDate() %>" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><textarea rows="2" name="address"><%=model.getAddress() %></textarea></td>
				<tr>
				<tr>
					<td>Note</td>
					<td><textarea rows="4" name="note"><%=model.getNote() %></textarea></td>
				<tr>
			</table>
	
			<div class="action">
				<button type="submit">Submit</button>
				<button type="button"
					onclick="window.location.href='<%=Utils.getUrl(request, "/contact")%>'">Cancel</button>
			</div>
	
		</form>
		
	<% } %>

	<script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
</body>
</html>