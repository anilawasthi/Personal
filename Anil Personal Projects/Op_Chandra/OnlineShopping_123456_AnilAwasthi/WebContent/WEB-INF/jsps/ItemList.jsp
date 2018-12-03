<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.jp.shopping.entities.Item, java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
<body>
	<jsp:include page="Head01.jsp"/> 
	<jsp:include page="Head02.jsp"/>

	<table border="1">
		<tr>
			<th>Item Id</th>
			<th>View Details</th>
		</tr>
		<c:forEach items="${ requestScope.itemList }" var="item">  <!-- this will bring details of the first emp -->
		<tr>
			<td>${ item.itemId }</td> 
			<td><a href="itemList.do?id=${ item.itemDetails }">View</a></td>
		</tr>
		
		</c:forEach>
		
		
	</table>
	<a href="mainMenu.do">Go back to Main Menu</a>
</body>
</html>