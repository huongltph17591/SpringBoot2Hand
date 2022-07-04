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
	<form:form action="/AssignmentJava5/admin/product/store" method="post"
		modelAttribute="item" enctype="multipart/form-data">
		<div class="form-group mt-4">
			<label>Tên sản phẩm</label>
			<form:input path="name" class="form-control" />
			<form:errors path="name" class="text-danger" />
		</div>
		<div class="from-group">
			<label>Ảnh</label>
			<form:input type="file"  path="image"
				class="form-control" />
		</div>
		<div class="form-group ">
			<label>Giá</label>
			<form:input path="price" class="form-control" />
			<form:errors path="price" class="text-danger" />
		</div>
		
		<div class="form-group mt-3">
			<label>Số lượng</label>
			<form:input path="quantity" class="form-control"/>
			<form:errors path="quantity" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Danh mục:</label>
			<form:select path="category" class="form-select">
				<c:forEach items="${ listCate }" var="cate">
					<form:option value="${ cate.id }">
					${ cate.name }
				</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="category" class="text-danger" />
		</div>

		<hr>
		<button>Create</button>
		<button class="btn btn-success"
			formaction="/AssignmentJava5/admin/product/update/${item.id}">Update</button>
		<a class="btn btn-danger"
			href="/AssignmentJava5/admin/product/delete/${item.id}">Delete</a>
		<a class="btn btn-primary" href="/AssignmentJava5/admin/product/index">Reset</a>
	</form:form>
	
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>