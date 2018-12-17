<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.jp.products.entities.Products, java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Product List Page</title>
	</head>
<body>
	<%-- ${ requestScope.productList } --%>
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Product Details</th>	
		</tr>
		<c:forEach items = "${ requestScope.productList }" var="prd">
		<tr>
			<td>${ prd.productId }</td>
			<td><a href="productDetails.do?prodId=${ prd.productId }">View Details</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="mainMenu.do">Go back to Main Menu</a>
</body>
</html>