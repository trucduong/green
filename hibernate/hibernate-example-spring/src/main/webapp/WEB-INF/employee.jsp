<%@page import="com.green.hibernate.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hibernate Example</title>
<style type="text/css">

	form {
		display: inline-block;;
	}

</style>
</head>
<body>
<h1>Employee List</h1>

<%
	List<Employee> employeeList = (List<Employee>) request.getAttribute("_employee_list");
%>
<div>
	<form action="<%=request.getContextPath() %>/employee/detail" method="get">
	    <button name="action" value="create">Create</button>
	</form>
	</div>
<table>
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Salary</th>
		<th>Actions</th>
	</tr>
	<%
	for(Employee employee : employeeList) {
	%>
	<tr>
		<td><%=employee.getId() %></td>
		<td><%=employee.getFirstName() %></td>
		<td><%=employee.getLastName() %></td>
		<td><%=employee.getSalary() %></td>
		<td>
			<form action="<%=request.getContextPath() %>/employee/detail" method="get">
                <input type="hidden" name="id" value="<%=employee.getId() %>">
                <button name="action" value="update">Update</button>
            </form>
            <form action="<%=request.getContextPath() %>/employee/detail" method="post">
                <input type="hidden" name="id" value="<%=employee.getId() %>">
                <button name="action" value="delete">Delete</button>
            </form>
		</td>
	</tr>
	<%
	}
	%>
</table>
<p>Totals: <span><%=employeeList.size() %></span></p>
</body>
</html>