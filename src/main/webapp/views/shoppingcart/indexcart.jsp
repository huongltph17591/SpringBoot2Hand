<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css" />
</head>
<body>
	<div class="page-heading about-heading header-text">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="text-content">
						<h4>Giỏ hàng</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<c:if test="${!empty ord }">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th></th>
									<th>Product</th>
									<th>Image</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>TotalProduct</th>
									<th>Thao tác</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${!empty ord }">
									<c:set var="no" value="1"></c:set>
									<c:forEach var="item" items="${ord.orderDetails }">
										<tr>
											<td>${no}</td>
											<td><a
												href="/AssignmentJava5/product/add/${item.product.id }"></a></td>
											<td><img style="width: 100px; height: 60px"
												src="/AssignmentJava5/images/${item.product.image }""></td>
											<td>
												<form
													action="/AssignmentJava5/shoppingcart/update/${item.product.id }"
													method="post">
													<input type="number" value="${item.quantity }"
														name="quantity">
													<button type="submit">update</button>
												</form>
											</td>
											<td>${item.price}</td>
											<td>${o.total}</td>
											<td><a class="btn"
												href="/AssignmentJava5/shoppingcart/remove/${item.product.id }">Xóa</a></td>
										</tr>
									</c:forEach>

								</c:if>
							</tbody>
						</table>
					</div>
					<h5>$ ${ord.total }</h5>
				</c:if>
			</div>



			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						<a class="btn btn-block btn-light"
							href="/AssignmentJava5/home/views">Continue Shopping</a>
					</div>
					<div class="col-sm-12 col-md-6 text-right">
						<a data-bs-toggle="modal"
							data-bs-target="#exampleModal${item.id }"
							class="btn btn-lg btn-block btn-success text-uppercase" href="">Thanh
							toán</a>
						<!-- Modal -->
						<div class="modal fade" id="exampleModal${item.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Xác thực
											thông tin đặt hàng</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">

										<div class="card shadow-sm">
											<div class="card-body align-items-center text-center">
												<c:if test="${!empty account }">
													<p>Tên người nhận hàng: ${account==null? "  Tài khoản  ":account.fullname}</p>
												</c:if>
												<label>Danh sách sản phẩm:</label>
												<table class="table table-striped">
													<thead>
														<tr>
															<th></th>
															<th>Sản phẩm</th>
															<th>Quantity</th>
															<th>Price</th>
														</tr>
													</thead>
													<tbody>
														<c:set var="no" value="1"></c:set>
														<c:forEach var="item" items="${ord.orderDetails }">
															<tr>
																<td>${no}</td>
																<td>${item.product.name}</td>
																<td>${item.quantity}</td>
																<td>${item.price}</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
												<h5>$ ${ord.total }</h5>
											</div>
										</div>
										<form method="POST"
											action="/AssignmentJava5/shoppingcart/save"> <label>Địa
											chỉ nhận hàng:</label> <input type="text" name="address" /> 
										<div class="modal-footer">
											<button class="btn btn-secondary">
												Đặt hàng
												</buton>
										</div>
										</form>
									</div>
									<a type="button" class="btn btn-secondary"
										data-bs-dismiss="modal"
										href="/AssignmentJava5/shoppingcart/index">Close</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.bundle.min.js"></script>
</body>
</html>