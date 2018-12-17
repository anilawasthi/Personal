<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<style>
body {
	border: 1px solid black;
}
</style>
</head>
<body>
	<jsp:include page="Head01.jsp"></jsp:include>
	<jsp:include page="Head02.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>Department ID</th>
			<th>Department Name</th>
		</tr>

		<tr>
			<td>${requestScope.deptDetails.deptNo}</td>
			<td>${requestScope.deptDetails.deptNm}</td>
			
		</tr>


	</table>
	
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>

		</tr>

		<c:forEach items="${requestScope.deptDetails.empList}" var="emp">
			<tr>
				<td>${emp.empNo}</td>
				<!-- this is property name from getter setter method and internally it will call getEmpId() -->
				<td>${emp.empNm}</td>
			</tr>
		</c:forEach>

	</table>

	<a href="getDeptList.hr">Go back to List</a>
</body>
</html>