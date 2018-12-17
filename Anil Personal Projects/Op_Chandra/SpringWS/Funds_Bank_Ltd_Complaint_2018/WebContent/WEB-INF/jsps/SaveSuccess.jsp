<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Complaint Success</title>
</head>
	<body>
		<h3>
		    Complaint id for this request is XXXX. <br>
		    Thanks for raising a complaint.
		</h3>
	 
		<strong>Account ID:			${command.accountId}</strong><br>
		<strong>Branch Code:		${command.branchCode}</strong><br>
		<strong>Email ID: 			${command.emialId}</strong><br>
		<strong>Complain Category:	${command.category}</strong><br>
		<strong>Description:		${command.description}</strong><br>
	<table>
		<tr>
		 	<a href="homePage.hr">Check Status</a> <a href="homePage.hr">Raise Complaint</a>
		<tr>
	</table> 
	</body>
</html>
