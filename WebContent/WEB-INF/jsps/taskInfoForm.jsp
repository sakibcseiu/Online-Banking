<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<sf:form class="form-horizontal"
			action="${pageContext.request.contextPath}/showTask" method="post"
			commandName="myTask">
			<fieldset>

				<!-- Form Name -->
				<legend>View Report</legend>

<h4 class="text-danger">
			<c:if test="${not empty error}">
  					${error}
				</c:if>
				</h4>
					<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="account_No">Account
					No:</label>
				<div class="col-md-4">
					<sf:input id="account_No" path="account_No" name="account_No" placeholder=""
						class="form-control input-md" type="text"/>
				<sf:errors path="account_No" cssClass="alert-danger"></sf:errors>
				</div>
			</div>

				
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">View</button>
					</div>
				</div>

			</fieldset>
		</sf:form>

	</div>

</body>
</html>