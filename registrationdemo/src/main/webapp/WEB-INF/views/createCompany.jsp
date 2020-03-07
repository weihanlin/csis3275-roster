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



	<form:form action="createCompany" modelAttribute="company">

		<div>
			<label for="code">Code</label>
			<div>
				<form:input path="code" />
			</div>
		</div>
		<div>
			<label for="name">Name</label>
			<div>
				<form:input path="name" />
			</div>
		</div>
		<div>
			<label for="address">Address</label>
			<div>
				<form:input path="address" />
			</div>
		</div>

		<div>

			<div>
				<input type="submit" value="Submit" />
			</div>
		</div>

	</form:form>

</body>
</html>