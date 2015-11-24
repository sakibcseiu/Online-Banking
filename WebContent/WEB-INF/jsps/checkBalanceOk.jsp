<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance</title>
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
	<h4>Your Current Account Balance</h4>
		<table class="table table-striped">
			<tr>
				
				<th>Balance</th>
			</tr>
			
				<tr>

					<td><c:out value="${balance}"></c:out></td>
					
				</tr>


			
		</table>
	</div>
</body>
</html>