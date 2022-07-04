<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css">
</head>
<body class="container mt-3">
	<h3>SORTING BY ${feild} </h3>
	<table class="table">
		<tr>
			<th>
				<a href="/AssignmentJava5/product/sort?feild=id">Id</a>
			</th>
			<th>
				<a href="/AssignmentJava5/product/sort?feild=name">Name</a>
			</th>
			<th>
				<a href="/AssignmentJava5/product/sort?feild=price">Price</a>
			</th>
			<th>
				<a href="/AssignmentJava5/product/sort?feild=createDate">Date</a>
			</th>
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