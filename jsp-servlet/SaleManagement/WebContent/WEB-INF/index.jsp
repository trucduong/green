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
        <div>Sale Management System</div>
    </header>
    
    <section>
        <p>Welcome to Sale Management System<p>
        <p>Please sign in to continue.</p>
        <form action="<%=request.getContextPath() %>/login" method="get" >
            <button>Sign In</button>
        </form>
        <form action="<%=request.getContextPath() %>/regis" method="get">
            <button>Sign Up</button>
        </form>
    </section>
    
    <footer>
        <div style="display: inline-block; float: left;">Copyright GITACADEMY All Rights Reserved</div>
        <div style="display: inline-block; float: right;">Insert your name here</div>
    </footer>
</body>
</html>