<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Item Details</title>
	</head>
	<body>
	<jsp:include page="Head01.jsp"/>
	<jsp:include page="Head02.jsp"/>

		<table border="1">
			<tr>
				<th>Item Id</th>
				<th>Item Name</th>
				<th>Item Category</th>
				<th>Item Price</th>
				<th>Item InStock(Availability)</th>
			</tr>
			<tr>
				<td>${ requestScope.itemDetails.itemId }</td>
				<td>${ requestScope.itemDetails.itemName }</td>
				<td>${ requestScope.itemDetails.itemCategory }</td>
				<td>${ requestScope.itemDetails.itemPrice }</td>
			</tr>
		</table>
		<a href="itemList.do">Go back to list</a>
	</body>
</html>