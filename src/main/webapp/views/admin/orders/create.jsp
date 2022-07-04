<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css">
</head>
<body class="container mt-3">
	<form:form action="/AssignmentJava5/admin/orders/store" method="post"
		modelAttribute="item" enctype="multipart/form-data">
		<div class="form-group mt-4">
			<label>Địa chỉ</label>
			<form:input path="address" class="form-control" />
			<form:errors path="address" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Người dùng</label>
			<form:select path="account" class="form-select">
				<c:forEach items="${ listUser }" var="account">
					<form:option value="${ account.id }">
					${ account.fullname }
				</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="account" class="text-danger" />
		</div>

		<hr>
		<button>Create</button>
		<a class="btn btn-primary" href="/AssignmentJava5/admin/orders/index">Reset</a>
	</form:form>
	
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>