<%@page import="com.green.sale.entity.Product"%>
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
Product product = (Product) request.getAttribute("_product");
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
            <h2>Product Detail</h2>
        </div>
        <div>
            <div style="display: inline-block;">
                <img alt="Product Image" src="<%=request.getContextPath()%>/product/image?code=${_product.code}">
            </div>
            <form action="<%=request.getContextPath()%>/product/detail" method="post">
                <input type="hidden" name="action" value="${action}">
                <input type="hidden" name="code" value="${_product.code}">
                <table>
                    <%
                    if ("update".equals(request.getAttribute("action"))) {
                    %>
                    <tr>
                        <td>Code</td>
                        <td>
                            <input value="${_product.code}" disabled="disabled">
                        </td>
                    </tr>
                    <%
                    }
                    %>
                    <tr>
                        <td>Name</td>
                        <td>
                            <input name="name" value="${_product.name}">
                        </td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>
                            <select name="status">
                                <option value="true" selected="${_product.status}">ACTIVE</option>
                                <option value="false" selected="${not _product.status}">IN-ACTIVE</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td>
                            <input name="price" value="${_product.price}">
                        </td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td>
                            <select name="categoryCode">
                            <%
                            for(Category category : categoryList) {
                            %>
                              <option value="<%=category.getCode() %>" selected="<%=(product.getCategoryCode() == category.getCode()) %>"><%=category.getName() %></option>
                            <%
                            }
                            %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
                            <textarea name="description" rows="3">${_product.description}</textarea>
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