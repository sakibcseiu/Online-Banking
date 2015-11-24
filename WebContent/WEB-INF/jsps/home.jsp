<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/style.css"
	rel="stylesheet" type="text/css" />
<%-- <link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/footer.css"
	rel="stylesheet" type="text/css" /> --%>
</head>
<body>

	<div>
		<%@ include file="header.jsp"%>
	</div>
	<div class="col-md-6 col-md-offset-3">
<h1>Welcome to Online Bank</h1>
		<h3>
		The Web Application is aimed at developing an Online Banking for
			customer. Through this web application, bank customer can transfer
			money, withdraw money, deposit money, create account, and check
			balance, close account. Using the constructs of MySQL database and
			the entire user interfaces have been designed using the JAVA,Servlet , JSP and
			Spring MVC , run through Apache Tomcat Server 8 in Eclipse Or Spring
			Tools Suite(STS).One can view her/his activity time to time.At all proper levels high care was taken to check
			that the system manages the data consistency with proper business
			rules or validations.
			</h3>
	</div>
	<%-- <div>
<%@ include file="footer.jsp" %>
</div> --%>
</body>
</html>