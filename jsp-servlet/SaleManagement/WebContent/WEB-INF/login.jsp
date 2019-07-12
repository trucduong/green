<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <div class="header-title">Sale Management System</div>
    </header>

    <section>
        <div>
	        <p>Đăng nhập<p>
	        <p>Vui lòng nhập tài khoản của bạn</p>
	        <form action="<%=request.getContextPath() %>/login" method="post" >
	           <table>
	           <tr>
	               <td>Email</td>
	               <td><input name="email" type="text" ></td>
	           </tr>
	           <tr>
                   <td>Password</td>
                   <td><input name="password" type="password" ></td>
               </tr>
	           </table>
	            <button type="submit">Submit</button>
	        </form>
	    </div>
        <a href="<%=request.getContextPath()%>">Back to Home page</a>
    </section>

    <footer>
        <div style="display: inline-block; float: left;">Copyright GITACADEMY All Rights Reserved</div>
        <div style="display: inline-block; float: right;">Insert your name here</div>
    </footer>
</body>
</html>