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
<%
List<Category> categoryList = (List<Category>) request.getAttribute("_categoryList");
%>

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
            <h2>Category List</h2>
        </div>
        <div>
            <form action="<%=request.getContextPath() %>/category/detail" method="get">
                <button name="action" value="create">Create</button>
            </form>
        </div>
        <div>
            <table>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                <%
                for(Category category : categoryList) {
                %>
                <tr>
                    <td><%=category.getCode() %></td>
                    <td><%=category.getName() %></td>
                    <td><%=category.getDescription() %></td>
                    <td>
                    <form action="<%=request.getContextPath() %>/category/detail" method="get">
                        <input type="hidden" name="code" value="<%=category.getCode()%>">
                        <button name="action" value="update">Update</button>
                    </form>
                    <form action="<%=request.getContextPath() %>/category/detail" method="post">
                        <input type="hidden" name="code" value="<%=category.getCode()%>">
                        <button name="action" value="delete">Delete</button>
                    </form>
                    </td>
                </tr>
                <%
                }
                %>
            </table>
        </div>
    </section>
    
    <footer>
        <div style="display: inline-block; float: left;">Copyright GITACADEMY All Rights Reserved</div>
        <div style="display: inline-block; float: right;">Insert your name here</div>
    </footer>
</body>
</html>