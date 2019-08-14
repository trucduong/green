<%@page import="com.green.entity.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
	<form action="logout" method="get">
		<button>Logout</button>
	</form>
	<h1>User List</h1>
	
<%
List<Account> accountList = (List<Account>) request.getAttribute("account_list");
%>
	
	<table border="1" cellspacing="0">
		<tr>
			<th>User Name</th>
			<th>Full Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
	<%
	for(Account account:accountList) {
	%>
		<tr>
			<td><%=account.getUsername() %></td>
			<td><%=account.getFullName() %></td>
			<td><%=account.getEmail() %></td>
			<td>
				<form action="<%=request.getContextPath()%>/detail" method="get">
					<input type="hidden" name="username" value="<%=account.getUsername()%>">
					<input type="hidden" name="action" value="UPDATE">
					<button type="submit">Update</button>
				</form>
				<form action="<%=request.getContextPath()%>/detail" method="post">
					<input type="hidden" name="username" value="<%=account.getUsername()%>">
					<input type="hidden" name="action" value="DELETE">
					<button type="submit">Delete</button>
				</form>
			</td>
		</tr>
	<%
	}
	%>
	</table>
	<div style="margin-top: 20px">
		<a href="<%=request.getContextPath()%>/detail">Create new User</a>
	</div>
</body>
</html>