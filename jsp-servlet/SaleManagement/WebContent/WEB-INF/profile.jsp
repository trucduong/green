<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <div class="header-title">Sale Management System</div>
        <div style="display: inline-block; float: right">
            <div class="header-btn-group">
            <a href="<%=request.getContextPath()%>\logout">Logout</a>
                <a href="<%=request.getContextPath()%>\logout">Logout</a>
            </div>
            <div class="header-btn-group">
                <img src="<%=request.getContextPath() %>/profile/image" alt="Avatar" width="40" height="40">
            </div>
        </div>
    </header>

    <section>
        <div>
            <h2 class="section-header">Hình đại diện</h2>
            <div>
                <img src="<%=request.getContextPath() %>/profile/image" alt="Avatar" width="100" height="100">
            </div>
            <div>
				<form action="<%=request.getContextPath() %>/profile/image" method="post" enctype="multipart/form-data">
					<input type="file" name="file" />
					<button type="submit">Upload</button>
				</form>
			</div>
        </div>
        <div>
            <h2 class="section-header">Thông tin cá nhân</h2>
            <div>
                <form action="<%=request.getContextPath() %>/profile" method="post" >
                   <table>
                   <tr>
                       <td>Email</td>
                       <td><input name="email" value="${_account.email}" type="text" ></td>
                   </tr>
                   <tr>
                       <td>Your Name</td>
                       <td><input name="fullName" value="${_account.fullName}" type="text" ></td>
                   </tr>
                   <tr>
                       <td>Birth Date</td>
                       <td><input name="birthDate" value="${_account.birthDate}" type="date" ></td>
                   </tr>
                   <tr>
                       <td>Gender</td>
                       <td>
                        <select name="gender">
                            <option value="M" selected="${_account.gender eq 'M'}">Male</option>
                            <option value="F" selected="${_account.gender eq 'F'}">FeMale</option>
                        </select>
                       </td>
                   </tr>
                   <tr>
                       <td>Address</td>
                       <td><textarea name="address" rows="3">${_account.address}</textarea></td>
                   </tr>
                   </table>
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>
        <a href="<%=request.getContextPath()%>/sale">Back to Sale page</a>
    </section>

    <footer>
        <div style="display: inline-block; float: left;">Copyright GITACADEMY All Rights Reserved</div>
        <div style="display: inline-block; float: right;">Insert your name here</div>
    </footer>
</body>
</html>