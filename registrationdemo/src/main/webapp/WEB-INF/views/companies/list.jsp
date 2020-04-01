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
		<h1>All Company</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Address</th>
				</tr>
			</thead>
			<c:forEach var="company" items="${companies}">
				<tr>
					<td>${company.code}</td>
					<td>${company.name}</td>
					<td>${company.address}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>