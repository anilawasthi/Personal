<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="submitProduct.do" method="POST">
	${ message }
		<table>
			<tr><th>ProdId</th>
			<td><input type="text" name="prodId"></td>
			</tr>
			<tr>
			<th>Product Name</th>
				<td><input type="text" name="prodNm"></td>
			</tr>
			<tr>
			<th>Product Category</th>
				<td><input type="text" name="prodCat"></td>
			</tr>
			<tr>
			<tr>
			<th>Product Price</th>
				<td><input type="text" name="prodPrc"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="GO"/></td>
			</tr>
		</table>
		<a href="mainMenu.do">Go back to Main Menu</a>
		</form>
	</body>
</html>