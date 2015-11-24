<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New A/C</title>

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
			action="${pageContext.request.contextPath}/doCreateAcc" method="post"
			commandName="account">
			<fieldset>

				<!-- Form Name -->
				<legend>Create Account</legend>

				<%-- 	<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="account_No">Account
					No:</label>
				<div class="col-md-4">
					<sf:input id="account_No" path="account_No" name="account_No" placeholder=""
						class="form-control input-md" type="text"/>
<sf:errors path="account_No" cssClass="alert-danger"></sf:errors>
				</div>
			</div> --%>

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

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="address">Address:</label>
					<div class="col-md-4">
						<sf:textarea class="form-control" path="address" id="address"
							name="address"></sf:textarea>
						<sf:errors path="address" cssClass="alert-danger"></sf:errors>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Pphone">Phone:</label>
					<div class="col-md-4">
						<sf:input id="phone" path="phone" name="phone" placeholder=""
							class="form-control input-md" type="text" />
						<sf:errors path="phone" cssClass="alert-danger"></sf:errors>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">
						<button id="submit" name="submit" class="btn btn-primary">Create
							Account</button>
					</div>
				</div>

			</fieldset>
		</sf:form>

	</div>

</body>
</html>