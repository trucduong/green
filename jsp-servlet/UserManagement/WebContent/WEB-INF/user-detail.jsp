<%@page import="com.green.entity.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/main.css"
	rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
	<%
		String action = (String) request.getAttribute("action");
	%>

	<div class="container">
		<div class="center">
			<h1>User Detail</h1>

			<%
				String errorMessage = (String) request.getAttribute("ERROR");
				if (errorMessage != null) {
			%>
			<span class="err-msg"><%=errorMessage%></span>
			<%
				}
			%>

			<%
				if (action.equals("CREATE")) {
			%>
			<form action="<%=request.getContextPath() %>/detail" method="post">
				<input type="hidden" name="action" value="CREATE" >
				<table>
					<tr>
						<td>User Name</td>
						<td><input name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>Full Name</td>
						<td><input type="text" name="fullName"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit">Create</button>
						</td>
					</tr>
				</table>
			</form>
			<%
				} else {
				Account account = (Account) request.getAttribute("ACCOUNT");
			%>
			<form action="<%=request.getContextPath() %>/detail" method="post">
				<input type="hidden" name="username" value="<%=account.getUsername() %>">
				<table>
					<tr>
						<td>User Name</td>
						<td><input disabled value="<%=account.getUsername() %>"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" value="<%=account.getPassword() %>" name="password"></td>
					</tr>
					<tr>
						<td>Full Name</td>
						<td><input type="text" value="<%=account.getFullName() %>" name="fullName"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" value="<%=account.getEmail() %>" name="email"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button name="action" value="UPDATE" type="submit">Update</button>
							<button name="action" value="DELETE" type="submit">Delete</button>
						</td>
					</tr>
				</table>
			</form>
			<%
				}
			%>



		</div>
		<a href="<%=request.getContextPath()%>">Back to list</a>
	</div>
</body>
</html>