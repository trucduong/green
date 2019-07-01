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
		String mode = (String) session.getAttribute("MODE");
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
				if (mode.equals("CREATE")) {
			%>
			<form method="post">
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
			<form method="post">
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
							<button name="btnAction" value="update" type="submit">Update</button>
							<button name="btnAction" value="delete" type="submit">Delete</button>
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