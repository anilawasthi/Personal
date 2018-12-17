<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.jp.hr.entities.Emp, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- prefix is the nick name for uri -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<style>
body {
	border: 1px solid black;
}
</style>
</head>
<body>
	<jsp:include page="Head01.jsp"></jsp:include>
	<jsp:include page="Head02.jsp"></jsp:include>

	<%--  ${requestScope.EmployeeList} --%>

	<!-- WITHOUT TAGLIB -->
	<%-- <table border="1">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<% for(Employee emp: (ArrayList<Employee>)request.getAttribute("EmployeeList")){
			
		%>
		<tr>
		<td><%= emp.getEmpId() %></td>
		<td><%= emp.getFirstName() %></td>
		<td><%= emp.getLastName() %></td>
		</tr>
	<%}%>
	</table> --%>


	<!-- WITH TAGLIB -->
	<%-- 	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		
		<c:forEach items="${requestScope.EmployeeList}" var="emp">
			<tr>
			<td>${emp.empId}</td> <!-- this is property name from getter setter method and internally it will call getEmpId() -->
			<td>${emp.firstName}</td>
			<td>${emp.lastName}</td>
			</tr>
		</c:forEach>
		
	</table>
	 --%>


	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>View Details</th>

		</tr>

		<c:forEach items="${requestScope.deptDetails.empList}" var="emp">
			<tr>
				<td>${emp.empNo}</td>
				<td>${emp.empNm}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="homePage.hr">Return to Home Page</a>

</body>
</html>