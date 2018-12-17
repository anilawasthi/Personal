<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Department No.</th>
			<th>Department Name</th>

		</tr>

		<tr>
			<td>${empDetails.empNo}</td>
			<td>${empDetails.empNm}</td>
			<td>${empDetails.empSal}</td>
			<td>${empDetails.dept.deptNo}</td>
			<td>${empDetails.dept.deptNm}</td>
		</tr>


	</table>

	<a href="getEmpList.hr">Go back to List</a>
</body>
</html>