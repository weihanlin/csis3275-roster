<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>


	<div class="container">
		<form:form class="form-horizontal" action="addEmployee" modelAttribute="employee">
			<div class="form-group row">
				<label class="col-sm-2 col-form-label-lg text-right">First Name:</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="first_name" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label-lg text-right">Last Name:</label>
				<div class="col-sm-10">
					<form:input path="last_name" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label-lg text-right">Email:</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label-lg text-right">Account:</label>
				<div class="col-sm-10">
					<form:input path="login_id" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label-lg text-right">Password:</label>
				<div class="col-sm-10">
					<form:input path="password" class="form-control" type="password"/>
				</div>
			</div>


			<spring:bind path="availability">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label-lg text-right">Availability:</label>
					<div class="form-check">
						<form:checkboxes path="availability" items="${availableList}"
							element="label class='form-check-label col-sm-2 col-form-label-lg'" />
							
					</div>
				</div>
			</spring:bind>

			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn-lg btn-primary pull-right" value="Submit" />
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>