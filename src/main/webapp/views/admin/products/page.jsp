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
<body class="container mt-2">
	<h3>PAGINATION</h3>
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Date</th>
		</tr>
		<c:forEach var="item" items="${page.content}">
			<tr>
				<td class="text-dark">${item.id}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.createDate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/AssignmentJava5/product/page?p=0">First</a>
	<a href="/AssignmentJava5/product/page?p=${page.number-1}">Previous</a>
	<a href="/AssignmentJava5/product/page?p=${page.number+1}">Next</a>
	<a href="/AssignmentJava5/product/page?p=${page.totalPages-1}">Last</a>
	<ul>
	<li>Số thực thể hiện tại: ${page.numberOfElements}</li>
	<li>Trang số: ${page.number}</li>
	<li>Kích thước trang: ${page.size}</li>
	<li>Tổng số thực thể: ${page.totalElements}</li>
	<li>Tổng số trang: ${page.totalPages}</li>
	</ul>
	
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>