<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
	<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/style.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
<div>
<%@ include file="header.jsp" %>
 </div>
	<div class="col-md-6 col-md-offset-3">
	<h4>You Are Successfully Withdraw Money From Account</h4>
		<table class="table table-striped">
			<tr>
				<th>Account_No</th>
				<th>UserName</th>
				<th>Password</th>
				<th>Amonut</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Date and Time</th>
			</tr>
			
				<tr>
			
					<td><c:out value="${myaccount.account_No}"></c:out></td>
					<td><c:out value="${myaccount.userName}"></c:out></td>
					<td><c:out value="${myaccount.password}"></c:out></td>
					<td><c:out value="${myaccount.amount}"></c:out></td>
					<td><c:out value="${myaccount.address}"></c:out></td>
					<td><c:out value="${myaccount.phone}"></c:out></td>
					<td><c:out value="${myaccount.date}"></c:out></td>
				</tr>


			
		</table>
	</div>
</body>
</html>