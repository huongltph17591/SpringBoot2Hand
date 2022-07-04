<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Price</title>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css">
</head>
<body class="container mt-3">
	<form action="/AssignmentJava5/product/search" method="post">
		
		<div class="form-group">
			<label>Min price:</label>
			<input class="form-control" name="min" value="${param.min }">
		</div>
		<div class="form-group">
			<label>Max price:</label>
			<input class="form-control" name="max" value="${param.max}">
		</div>
		<button class="btn btn-primary mt-2">Save</button>
	</form>
	<table class="table">
			<tr class="text-danger">
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Date</th>
			</tr>
		<c:forEach var="item" items="${items}">
			
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.createDate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>