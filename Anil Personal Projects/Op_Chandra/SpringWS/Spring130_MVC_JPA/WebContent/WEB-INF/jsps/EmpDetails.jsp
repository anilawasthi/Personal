<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee Details</title>
	</head>
	<body>
		<jsp:include page="Head01.jsp" />
		<jsp:include page="Head02.jsp" />
		
		<table border="1">
			<tr>
				<th>Employee Id </th>
				<th>Name</th>
				<th>Salary</th>
				<th>Department No.</th>
				<th>Department Name</th>
				<!-- <th>ProjectId</th> -->
				<th>Project Details</th>
				
			</tr>
			<tr>
				<td>${ requestScope.empDetails.empNo }</td>
				<td>${ requestScope.empDetails.empNm }</td>
				<td>${ requestScope.empDetails.empSal }</td>
				<td>${ requestScope.empDetails.dept.deptNo }</td>
				<td>${ requestScope.empDetails.dept.deptNm }</td>
				<td>${ requestScope.empDetails.projects[0].projectId }</td>
				
				<table border="1">
			<tr>
				<th>DeptNo</th>
				<th>Name</th>
			</tr>
			<c:forEach items="${ requestScope.empDetails.projects}" var="projects">
				<tr>
					<td>${ project.projectId }</td>
					<td>${ project.title }</td>
				</tr>
			</c:forEach>
			</table>	
			</tr>
		</table>
		<a href="getEmpList.hr">Go back to list</a>
	</body>
</html>