<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/actionpost.js" />"></script>
</head>
<body>

	<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-${msg} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>


		<h1>All Company</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="company" items="${companies}">
				<tr>
					<td>${company.code}</td>
					<td>${company.name}</td>
					<td>${company.address}</td>
					<td>
						<spring:url value="/companies/${company.code}" var="manageUrl" /> 
						<spring:url value="/companies/${company.code}/delete" var="deleteUrl" />
						<button class="btn btn-info"
							onclick="location.href='${manageUrl}'">Manage</button>
						<button class="btn btn-danger"
							onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>