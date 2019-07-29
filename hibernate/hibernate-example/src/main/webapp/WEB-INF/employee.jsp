<%@page import="com.green.hibernate.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>

<%
	List<Employee> employeeList = (List<Employee>) request.getAttribute("_employee_list");
%>
<button>Create</button>
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
			<button>Update</button>
			<button>Delete</button>
		</td>
	</tr>
	<%
	}
	%>
</table>
<p>Totals: <span><%=employeeList.size() %></span></p>
</body>
</html>