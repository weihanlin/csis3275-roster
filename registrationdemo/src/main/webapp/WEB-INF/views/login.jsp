<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">${message}</h2>
			<div class="panel panel-info">
				<div class="panel-body">
					<form:form action="login" class="form-horizontal" method="post"
						modelAttribute="loginInfo">

						<div class="form-group row">
							<label for="userid" class="col-md-3 control-label">User
								ID</label>
							<div class="col-md-9">
								<form:input path="userid" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<form:password path="password" class="form-control" />
							</div>
						</div>

						<div class="form-group row">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button class="btn btn-primary">Submit</form:button>
							</div>

						</div>

					</form:form>
					<div>
						<button class="btn btn-info"
							onclick="location.href='/showSignUpForm'">Sign Up</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>