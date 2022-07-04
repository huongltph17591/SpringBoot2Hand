<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<link style="stylesheet"
	href="/AssignmentJava5/css/bootstrap.min.css">
</head>
<body class="container mt-3">
	<form:form
		method="POST"
		action="/AssignmentJava5/admin/accounts/update/${account.id }"
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
			<label>Photo</label>
			
			<form:input type="file" path="photo" class="form-control"/>
		</div>
		<div class="form-group mt-4">
			<label>Admin</label>
			<form:select path="admin" class="form-select" itemValue="${ account.admin }">
				<form:option value="0">Member</form:option>
				<form:option value="1">Admin</form:option>
			</form:select>
		</div>
		<button>Update</button>
		
		<a class="btn btn-danger"
			 data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</a>
			<!-- Button trigger modal -->

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Cảnh báo</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        Bạn chắc chắn muốn xóa?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"  formaction="/AssignmentJava5/admin/accounts/index">Close</button>
		        <a type="button" class="btn btn-primary" href="/AssignmentJava5/admin/accounts/delete/${account.id}" >OK</a>
		      </div>
		    </div>
		  </div>
		</div>
			
		<a class="btn btn-primary" href="/AssignmentJava5/admin/accounts/index">Reset</a>
	</form:form>
	
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>