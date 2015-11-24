<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report</title>

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
				<th>Operation</th>
				<th>Amount</th>
				<th>Balance</th>
				<th>Date and Time</th>
			</tr>
			<c:forEach var="task" items="${tasks}">
				<tr>
			
					<td><c:out value="${task.account_No}"></c:out></td>
					<td><c:out value="${task.operation}"></c:out></td>
					<td><c:out value="${task.amount}"></c:out></td>
					<td><c:out value="${task.balance}"></c:out></td>
					<td><c:out value="${task.date}"></c:out></td>
				</tr>


			</c:forEach>
		</table>
	</div>
</body>
</html>
