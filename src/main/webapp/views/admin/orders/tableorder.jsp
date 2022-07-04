<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table"  style="width:100%">
		<tr>
			<th>Id</th>
			<th>Người dùng</th>
			<th>Ngày tạo</th>
			<th>Địa chỉ</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${items}">
		<tr>
			<td>${item.id}</td>
			<td>${item.account.fullname}</td>
			<td>${item.createDate}</td>
			<td>${item.address}</td>
			<td><a class="btn btn-primary" href="/AssignmentJava5/admin/orders/edit/${item.id}">Edit</a></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>