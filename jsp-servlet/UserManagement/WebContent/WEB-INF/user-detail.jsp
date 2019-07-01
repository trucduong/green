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
			<h1>User Detail</h1>
			<form action="detail" method="post">
			 	<table>
			 		<tr>
			 			<td>User Name</td>
			 			<td><input name="username" ></td>
			 		</tr>
			 		<tr>
			 			<td>Password</td>
			 			<td><input type="password" name="password" ></td>
			 		</tr>
			 		<tr>
			 			<td>Full Name</td>
			 			<td><input type="text" name="fullName" ></td>
			 		</tr>
			 		<tr>
			 			<td colspan="2">
			 				<button>Create</button>
			 			</td>
			 		</tr>
			 	</table>
			</form>
		</div>
	</div>
</body>
</html>