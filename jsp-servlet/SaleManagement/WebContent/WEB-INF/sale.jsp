<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale Management</title>
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <div class="header-title">Sale Management System</div>
        <div style="display: inline-block; float: right">
            <div class="header-btn-group">
            	<a href="<%=request.getContextPath()%>\category">Category</a>
            	<a href="<%=request.getContextPath()%>\product">Product</a>
                <a href="<%=request.getContextPath()%>\profile">Profile</a>
                <a href="<%=request.getContextPath()%>\logout">Logout</a>
            </div>
            <div class="header-btn-group">
                <img src="<%=request.getContextPath() %>/profile/image" alt="Avatar" width="40" height="40">
            </div>
        </div>
    </header>
    
    <section>
        <h1>Sale page</h1>
    </section>
    
    <footer>
        <div style="display: inline-block; float: left;">Copyright GITACADEMY All Rights Reserved</div>
        <div style="display: inline-block; float: right;">Insert your name here</div>
    </footer>
</body>
</html>