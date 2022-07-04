<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css">
</head>
<body class="container mt-3">
	<form:form action="/AssignmentJava5/admin/orderdetails/store" method="post"
		modelAttribute="item" enctype="multipart/form-data">
		<div class="form-group">
			<label>OrderID</label>
			<form:select path="order" class="form-select">
				<c:forEach items="${ listOrder }" var="order">
					<form:option value="${ order.id }">
					${ order.id }
				</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="order" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Sản phẩm</label>
			<form:select path="product" class="form-select">
				<c:forEach items="${ listPro }" var="product">
					<form:option value="${ product.id }">
					${ product.name }
				</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="product" class="text-danger" />
		</div>
		<div class="form-group mt-4">
			<label>Số lượng</label>
			<form:input path="quantity" class="form-control" />
			<form:errors path="quantity" class="text-danger" />
		</div>
		<div class="form-group mt-4">
			<label>Giá</label>
			<form:input path="price" class="form-control" />
			<form:errors path="price" class="text-danger" />
		</div>
		<hr>
		<button>Create</button>
		<a class="btn btn-primary" href="/AssignmentJava5/admin/orderdetails/index">Reset</a>
	</form:form>
	
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>