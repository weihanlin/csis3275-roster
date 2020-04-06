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
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>


	<div class="container">
		<form:form action="addEmployee" modelAttribute="employee">
			<div>
				<label>First Name:</label>
				<div>
					<form:input path="first_name" />
				</div>
			</div>
			<div>
				<label>Last Name:</label>
				<div>
					<form:input path="last_name" />
				</div>
			</div>
			<div>
				<label>Email:</label>
				<div>
					<form:input path="email" />
				</div>
			</div>
			<div>
				<label>Account:</label>
				<div>
					<form:input path="login_id" />
				</div>
			</div>
			<div>
				<label>Password:</label>
				<div>
					<form:input path="password" />
				</div>
			</div>
<%-- 			<div>
				<label>position:</label>
				<div>
					<form:input path="job_id" />
				</div>
			</div> --%>
<%-- 			<div>
				<label>availiability:</label>
				<div>
					<form:input path="availiability" />
				</div>
			</div> --%>
			
		<spring:bind path="availability">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Availability:</label>
			<div class="col-sm-10">
				<form:checkboxes path="availability" items="${availableList}" 
                                 element="label class='checkbox-inline'" />
				<br />
				<form:errors path="availability" class="control-label" />
			</div>
		  </div>
		</spring:bind>

			<div>
				<div>
					<input type="submit" value="Submit" />
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>