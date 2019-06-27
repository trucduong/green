<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/resources/css/main.css" 
		rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="center">
			<h1>Login</h1>
			<form action="login" method="post">
			 	<table>
			 		<%
			 		String errorMessage = (String) request.getAttribute("error");
			 		if (errorMessage != null) { 
			 		%>
			 		<tr>
			 			<td colspan="2"><span class="err-msg"><%=errorMessage %></span></td>
			 		</tr>
			 		<%
			 		}
			 		%>
			 		<tr>
			 			<td>User Name</td>
			 			<td><input name="username" ></td>
			 		</tr>
			 		<tr>
			 			<td>Password</td>
			 			<td><input name="password" ></td>
			 		</tr>
			 		<tr>
			 			<td colspan="2">
			 				<button>Submit</button>
			 			</td>
			 		</tr>
			 	</table>
			</form>
		</div>
	</div>
</body>
</html>