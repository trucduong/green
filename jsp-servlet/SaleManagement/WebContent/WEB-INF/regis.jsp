<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <div>Sale Management System</div>
    </header>

    <section>
        <div>
	        <p>Đăng ký tài khoản<p>
	        <p>Vui lòng nhập các thông tin bên dưới</p>
	        <form action="<%=request.getContextPath() %>/regis" method="post" >
	           <table>
	           <tr>
	               <td>Email</td>
	               <td><input name="email" type="text" ></td>
	           </tr>
	           <tr>
                   <td>Your Name</td>
                   <td><input name="fullName" type="text" ></td>
               </tr>
               <tr>
                   <td>Birth Date</td>
                   <td><input name="birthDate" type="date" ></td>
               </tr>
               <tr>
                   <td>Gender</td>
                   <td>
                    <select name="gender">
                        <option value="M">Male</option>
                        <option value="F">FeMale</option>
                    </select>
                   </td>
               </tr>
               <tr>
                   <td>Address</td>
                   <td><textarea name="address" rows="3"></textarea></td>
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