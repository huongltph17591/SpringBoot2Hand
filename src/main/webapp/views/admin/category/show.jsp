<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body class="container mt-3">
	<form:form action="/AssignmentJava5/admin/admin/category/index" modelAttribute="item" >
		
		<div class="from-group mt-3">
			<form:input path="name" class="form-control"  placeholder="Category Name?"/>
		</div>
		
		<hr>
		<button class="btn btn-primary" formaction="/AssignmentJava5/admin/category/create">Create</button>
		<button class="btn btn-success" formaction="/AssignmentJava5/admin/category/update/${item.id}">Update</button>
		
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
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"  formaction="/AssignmentJava5/admin/category/index">Close</button>
		        <a type="button" class="btn btn-primary" href="/AssignmentJava5/admin/category/delete/${item.id}" >OK</a>
		      </div>
		    </div>
		  </div>
		</div>
		<a class="btn btn-primary"  href="/AssignmentJava5/admin/category/index">Reset</a>
	</form:form>
	
</body>
</html>