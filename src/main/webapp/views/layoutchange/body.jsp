<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2 Hand</title>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css" />
</head>
<body class="container" style="margin-left: auto; margin-right: auto; display: block;">
	
		<img alt="" src="/AssignmentJava5/images/danhMuc.png" width="100%" style="margin-left: auto; margin-right: auto; display: block; margin-bottom: 10px"
			height="300px">
	<div class="row">
		<div class="col-10">
			<h2>FLASH SALE</h2>
		</div>
		<div class="col-2">
			<a href="/AssignmentJava5/home/list"><b>Xem tất cả</b></a>
		</div>
	</div>
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-5 g-3">
		<c:forEach var="item" items="${page.content}">
			<div class="col">
				<div class="card shadow-sm">
					<img class="bd-placeholder-img card-img-top" width="100%"
						height="225" alt="" role="img"
						src="/AssignmentJava5/images/${item.image}">
					<div class="card-body align-items-center text-center">
						<h5 class="card-title">${ item.name } <b style="color: red;">${item.status == 0 ? "" : "Hết hàng"}</b></h5>
						<p class="card-text">
							<strike>${ item.price } VND</strike> <br> <strong>${ item.price*0.1 }
								VND</strong>
						</p>
						<a 
							class="btn btn-primary" data-bs-toggle="modal"
							data-bs-target="#exampleModal${item.id }">Xem chi tiết</a>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal${item.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thông tin
											sản phẩm</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<div class="card shadow-sm">
											<img class="bd-placeholder-img card-img-top" width="100%"
												height="225" alt="" role="img"
												src="/AssignmentJava5/images/${item.image}">
											<div class="card-body align-items-center text-center">
												<h5 class="card-title">${ item.name }</h5>
												<p class="card-text">
													<strike>${ item.price } VND</strike> <br> <strong>${ item.price*0.1 }
														VND</strong>
												</p>

											</div>
										</div>
										<div class="modal-footer">
											<a type="button" class="btn btn-secondary"
												data-bs-dismiss="modal" href="/AssignmentJava5/shoppingcart/index">Close</a>
											<c:choose>
											<c:when test="${item.status == 0}">
											<a href="/AssignmentJava5/shoppingcart/add/${item.id}" type="button" class="btn btn-primary" >Thêm
												vào giỏ hàng</a>
											</c:when>
											<c:when test="${item.status == 1}">
											<a href="#" type="button" class="btn btn-secondary" >Thêm
												vào giỏ hàng</a>
											</c:when>
											</c:choose>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.bundle.min.js"></script>
</body>
</html>