<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP - Servlet Example</title>
</head>
<body>
<h1>Home page</h1>

<p>Welcome <%=request.getSession().getAttribute("authUser")%>!</p>
<a href="<%=request.getContextPath()%>/logout">Logout</a>

<script src="resources/js/app.js"></script>
</body>
</html>