<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer</title>

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
			action="${pageContext.request.contextPath}/oktransfer" method="post"
			commandName="transferMoney">

			<fieldset>
				
				<!-- Form Name -->
				<legend>Transfer money from one account to another account</legend>
<h4 class="text-danger">
			<c:if test="${not empty error}">
  					${error}
				</c:if>
				</h4>
				<!-- Text input-->
				<div class="form-group">
			
					<label class="col-md-4 control-label" for="faccount_No">From
						Account No:</label>
					<div class="col-md-4">
						<sf:input id="faccount_No" path="faccount_No" name="faccount_No"
							placeholder="" class="form-control input-md" type="text" />
						<sf:errors path="faccount_No" cssClass="alert-danger"></sf:errors>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="userName">User
						Name:</label>
					<div class="col-md-4">
						<sf:input id="userName" path="userName" name="userName"
							placeholder="" class="form-control input-md" type="text" />
						<sf:errors path="userName" cssClass="alert-danger"></sf:errors>
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password:</label>
					<div class="col-md-4">
						<sf:input id="password" path="password" name="password"
							placeholder="" class="form-control input-md" type="password" />
						<sf:errors path="password" cssClass="alert-danger"></sf:errors>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Amount">Amount:</label>
					<div class="col-md-4">
						<sf:input id="amount" path="amount" name="amount" placeholder=""
							class="form-control input-md" type="text" />
						<sf:errors path="amount" cssClass="alert-danger"></sf:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="taccount_No">To
						Account No:</label>
					<div class="col-md-4">
						<sf:input id="taccount_No" path="taccount_No" name="taccount_No"
							placeholder="" class="form-control input-md" type="text" />
						<sf:errors path="taccount_No" cssClass="alert-danger"></sf:errors>
					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">Transfer</button>
					</div>
				</div>

			</fieldset>
		</sf:form>

	</div>

</body>
</html>