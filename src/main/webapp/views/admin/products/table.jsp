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
<div class="row">
	<table class="table"  style="width:100%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Image</th>
			<th>Price</th>
			<th>Ngày tạo</th>
			<th>Số lượng</th>
			<th>Trạng thái</th>
			<th>Danh mục</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${data.content}">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td><img src="/AssignmentJava5/images/${item.image}" alt="${item.name}" width="50px" height="50px"></td>
			<td>${item.price}</td>
			<td>${item.createDate}</td>
			<td>${item.quantity}</td>
			<td>${item.status == 0 ? "Active" : "Not active"}</td>
			<td>${item.category.name}</td>
			<td><a class="btn btn-primary" href="/AssignmentJava5/admin/product/edit/${item.id}">Edit</a></td>
		</tr>
		</c:forEach>
	</table>
	<div class="row">
							<ul class="pagination justify-content-center">
								<c:forEach var="index" begin="0" end="${ data.totalPages - 1 }">
									<li class="page-item mx-1"><a
										class="page-link ${ index==page?'bg-black text-white':'' }"
										href="/AssignmentJava5/admin/product/index?page=${ index }">${ index + 1 }</a>
									</li>
								</c:forEach>
							</ul>
						</div>
</div>	
</body>
</html>