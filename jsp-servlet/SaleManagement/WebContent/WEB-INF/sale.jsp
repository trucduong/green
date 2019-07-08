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
        <div style="display: inline-block;">Sale Management System</div>
        <div style="display: inline-block; float: right">
            <form action="<%=request.getContextPath()%>\profile" action="get">
                <button type="submit">Profile</button>
            </form>
            <form action="<%=request.getContextPath()%>\profile" action="get">
                <button>Logout</button>
            </form>
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