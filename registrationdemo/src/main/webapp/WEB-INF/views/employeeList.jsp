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
<script src="<c:url value="/resources/js/actionpost.js" />"></script>
</head>
<body>


<div class="container">
	<spring:url value="/companies/${code}/addEmp" var="addEmpUrl" />
	<button class="btn btn-primary" onclick="this.disabled=true;post('${addEmpUrl}')">Add New</button>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.first_name}</td>
					<td>${employee.last_name}</td>
					<td>${employee.email}</td>
					<td>
						<spring:url value="/employees/${employee.id}/query" var="queryUrl" /> 
						<spring:url value="/employees/${employee.id}/delete/${code}" var="deleteUrl" />
						<button class="btn btn-info"
							onclick="location.href='${queryUrl}'">Manage</button>
						<button class="btn btn-danger"
							onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<button class="btn btn-secondary" onclick="location.href='/companies'">BACK</button>
		</div>
		
</body>
</html>