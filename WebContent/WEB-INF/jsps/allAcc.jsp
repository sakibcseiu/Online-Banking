<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ALL A/C</title>

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
			<c:forEach var="account" items="${accounts}">
				<tr>
			
					<td><c:out value="${account.account_No}"></c:out></td>
					<td><c:out value="${account.userName}"></c:out></td>
					<td><c:out value="${account.password}"></c:out></td>
					<td><c:out value="${account.amount}"></c:out></td>
					<td><c:out value="${account.address}"></c:out></td>
					<td><c:out value="${account.phone}"></c:out></td>
					<td><c:out value="${account.date}"></c:out></td>
				</tr>


			</c:forEach>
		</table>
	</div>
</body>
</html>
