<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>2 Hand</title>
<link rel="stylesheet"
	href="/AssignmentJava5/css/bootstrap.min.css" />

</head>
<body>
	<form>
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			<c:forEach items="${ items }" var="item">
				<div class="col">
					<div class="card shadow-sm">
						<img class="bd-placeholder-img card-img-top" width="100%"
							height="225" alt="" role="img"
							src="/AssignmentJava5/images/${item.image}">
						<div class="card-body align-items-center text-center">
							<h5 class="card-title">${ item.name }</h5>
							<p class="card-text">${ item.price }</p>
							<a href="/AssignmentJava5/shoppingcart/add" class="btn btn-primary">Xem chi tiết</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</form>

	<script src="/AssignmentJava4PH17591/js/jquery.min.js"></script>
	<script src="/AssignmentJava4PH17591/js/popper.min.js"></script>
	<script src="/AssignmentJava4PH17591/js/bootstrap.min.js"></script>
</body>
</html>