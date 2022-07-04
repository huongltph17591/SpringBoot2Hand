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
	<form:form
		method="POST"
		action="/AssignmentJava5/admin/accounts/store"
		modelAttribute="account" enctype="multipart/form-data">
		
		<div class="form-group mt-4">
			<label>Username</label>
			<form:input path="username" class="form-control"/>
		</div>
		<div class="form-group mt-4">
			<label>Fullname</label>
			<form:input path="fullname" class="form-control"/>
		</div>
		<div class="form-group mt-4">
			<label>Email</label>
			<form:input path="email" type="email" class="form-control"/>
		</div>
		<div class="form-group mt-4">
			<label>Phone</label>
			<form:input path="sdt" class="form-control"/>
		</div>
		<div class="form-group mt-4">
			<label>Password</label>
			<form:password path="password" class="form-control"/>
		</div>
		<div class="form-group mt-4">
			<label>Image</label>
			<form:input type="file" path="photo" class="form-control"/>
		</div>
		<div class="form-group mt-4">
			<label>Admin</label>
			<form:select path="admin" class="form-select">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		<br>
		<button>Save</button>
	</form:form>
	
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>