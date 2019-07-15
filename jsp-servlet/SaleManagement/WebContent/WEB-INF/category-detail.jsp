<%@page import="com.green.sale.entity.Category"%>
<%@page import="java.util.List"%>
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
                <a href="<%=request.getContextPath()%>\profile">Profile</a>
                <a href="<%=request.getContextPath()%>\logout">Logout</a>
            </div>
            <div class="header-btn-group">
                <img src="<%=request.getContextPath() %>/profile/image" alt="Avatar" width="40" height="40">
            </div>
        </div>
    </header>
    
    <section>
        <div class="section-header">
            <h2>Category Detail</h2>
        </div>
        <div>
            <form action="<%=request.getContextPath()%>/category/detail" method="post">
                <input type="hidden" name="action" value="${action}">
                <input type="hidden" name="code" value="${_category.code}">
                <table>
                    <%
                    if ("update".equals(request.getAttribute("action"))) {
                    %>
                    <tr>
                        <td>Code</td>
                        <td>
                            <input value="${_category.code}" disabled="disabled">
                        </td>
                    </tr>
                    <%
                    }
                    %>
                    <tr>
                        <td>Name</td>
                        <td>
                            <input name="name" value="${_category.name}">
                        </td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
                            <input name="description" value="${_category.description}">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit">Submit</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </section>
    
    <footer>
        <div style="display: inline-block; float: left;">Copyright GITACADEMY All Rights Reserved</div>
        <div style="display: inline-block; float: right;">Insert your name here</div>
    </footer>
</body>
</html>