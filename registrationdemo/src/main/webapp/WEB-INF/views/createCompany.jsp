<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1>Add Company</h1>
	<form:form class="form-horizontal" action="createCompany" modelAttribute="company">

		<div class="form-group">
			<label class="control-label col-sm-2" for="code">Code</label>
			<div class="col-sm-3">
				<form:input class="form-control" path="code" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name</label>
			<div class="col-sm-3">
				<form:input class="form-control" path="name" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="address">Address</label>
			<div class="col-sm-3">
				<form:input class="form-control" path="address" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<button class="btn btn-primary" type="submit">Submit</button> 
			</div>
		</div>

	</form:form>
</div>

</body>
</html>