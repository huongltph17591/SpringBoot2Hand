<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link style="stylesheet"
	href="/AssignmentJava5/css/bootstrap.min.css">
</head>
<body>
	<div class="row">
	
	
	<table class="table"  style="width:100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Fullname</th>
				<th>Username</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Photo</th>
				<th>Activated</th>
				<th>Role</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ data.content }" var="acc">
			<tr>
				<td>${ acc.id }</td>
				<td>${ acc.fullname }</td>
				<td>${ acc.username }</td>
				<td>${ acc.email }</td>
				<td>${ acc.sdt }</td>
				<td>
					<img src="/AssignmentJava5/images/${acc.photo}" alt="${ acc.username }" width="50px" height="50px"/>
				</td>
				<td>${ acc.activated == 0 ? "Active" : "Not active" }</td>
				<td>${ acc.admin == 0 ? "User" : "Admin" }</td>
				<td>
					<a class="btn btn-primary" href="/AssignmentJava5/admin/accounts/edit/${ acc.id }">
						Edit
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="row">
							<ul class="pagination justify-content-center">
								<c:forEach var="index" begin="0" end="${ data.totalPages - 1 }">
									<li class="page-item mx-1"><a
										class="page-link ${ index==page?'bg-black text-white':'' }"
										href="/AssignmentJava5/admin/accounts/index?page=${ index }">${ index + 1 }</a>
									</li>
								</c:forEach>
							</ul>
						</div>
	</div>
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
</body>
</html>