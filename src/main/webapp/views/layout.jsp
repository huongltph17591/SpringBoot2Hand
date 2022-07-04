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
<script src="/AssignmentJava5/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row align-items-center"
			style="background: #2b2a29; text-align: center; margin-bottom: 5px;">
			<div class="col-4">
				<img alt="" src="/AssignmentJava5/images/2hand.png">
			</div>
			<div class="col-4 text-white" style="font-size: 20px;">
				<b>HOTLINE: 0364443842</b> <br> <b>FREESHIP TOÀN QUỐC</b>
			</div>
			<div class="col-4">
				<input type="search" placeholder="Tìm kiếm" value="${keywords}"
					name="keywords" class="col-6"
					style="height: 40px; margin-top: 10px;">
				<button class="col-3" type="submit"
					style="width: 40px; height: 40px; margin-top: 10px;">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  					<path
							d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" /></svg>
				</button>
				<button class="col-3"
					style="width: 40px; height: 40px; margin-top: 10px;">
					<a href="/AssignmentJava5/shoppingcart/indexcart"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-cart3" viewBox="0 0 16 16">
  <path
							d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
</svg></a>
				</button>
			</div>
		</div>

		<nav class="p-3 mb-3 border-bottom border-top">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"
					style="font-weight: bold; font-size: 20px;">
					<li><a href="#" class="nav-link px-2 link-dark">Trang chủ</a></li>
					<li><a href="#" class="nav-link px-2 link-dark">Sản phẩm</a></li>
					<li><a href="#" class="nav-link px-2 link-dark">Tin tức</a></li>
					<li><a href="#" class="nav-link px-2 link-dark">Khuyến mãi</a></li>
				</ul>

				<div class="dropdown text-end">

					<c:if test="${!empty account }">
						<a href="#"
							class="d-block link-dark text-decoration-none dropdown-toggle"
							id="dropdownUser1" data-bs-toggle="dropdown"
							aria-expanded="false"> <img
							src="/AssignmentJava5/images/${account.photo}"
							alt="account.photo" width="32" height="32" class="rounded-circle">
							${account==null? "  Tài khoản  ":account.fullname}
						</a>
					</c:if>


					<ul class="dropdown-menu text-small"
						aria-labelledby="dropdownUser1">
						<c:if test="${empty account }">
							<li><a class="dropdown-item" href="">Đăng nhập</a></li>
							<li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
							<li><a class="dropdown-item" href="#">Đăng kí</a></li>
						</c:if>
						<c:if test="${!empty account }">
							<li><a class="dropdown-item" href="/AssignmentJava5/logout">Đăng
									xuất</a></li>
							<li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>

		<div id="carouselExampleIndicators" class="carousel slide"
			data-bs-ride="carousel" style="margin: 0px">
			<div class="carousel-indicators">
				<a type="a" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></a> <a type="a"
					data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
					aria-label="Slide 2"></a> <a type="a"
					data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
					aria-label="Slide 3"></a>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active" data-bs-interval="5000">
					<img src="/AssignmentJava5/images/1.jpg" class="d-block w-100"
						alt="..." width="100%" height="450px">
				</div>
				<div class="carousel-item" data-bs-interval="3000">
					<img src="/AssignmentJava5/images/2.jpg" class="d-block w-100"
						alt="..." width="100%" height="450px">
				</div>
				<div class="carousel-item" data-bs-interval="3000">
					<img src="/AssignmentJava5/images/3.jpg" class="d-block w-100"
						alt="..." width="100%" height="450px">
				</div>
			</div>
			<a class="carousel-control-prev" type="a"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</a> <a class="carousel-control-next" type="a"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</a>
		</div>

		<div class="row mt-3">
			<jsp:include page="${homeviews}"></jsp:include>
		</div>

		<footer
			class="align-items-center text-white col-12 text-center fw-bold"
			style="background: #2b2a29; margin-top: 20px">Huong225</footer>
	</div>
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.bundle.min.js"></script>
</body>
</html>