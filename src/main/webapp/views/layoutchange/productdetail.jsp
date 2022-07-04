<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/AssignmentJava5/css/bootstrap.min.css" />
</head>
<body>
	<div class="products">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="filters">
						<form class="form-inline my-2 my-lg-0 " action="/product/search"
							method="post">
							<input type="search" class="form-control" value="${keywords}"
								name="keywords" placeholder="Name Product"
								aria-label="Recipient's username"
								aria-describedby="button-addon2">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="submit"
									id="button-addon2">Seach</button>
							</div>
							<ul>
								<c:forEach var="cate" items="${categories}">
									<li><a href="/Product/add/${cate.id}">${cate.name}</a></li>
								</c:forEach>
								<li><a href="/Home/product/sort?field=price"
									style="color: #f33f3f"> Low to high</a></li>
								<li><a href="/Home/product/sortdesc?field=price"
									style="color: #f33f3f"> High to low</a></li>
							</ul>
							<ul>
								<li><a href="/product/price/between0_50"
									style="color: #f33f3f"> 0-50$</a></li>
								<li><a href="/product/price/between50_100"
									style="color: #f33f3f"> 50-100$</a></li>
								<li><a href="/product/price/between100_150"
									style="color: #f33f3f"> 100-150$</a></li>
								<li><a href="/product/price/between150_200"
									style="color: #f33f3f"> 200-250$</a></li>
								<li><a href="/product/price/between200"
									style="color: #f33f3f"> 250$ +</a></li>
							</ul>
						</form>
					</div>
				</div>
				<c:forEach var="item" items="${page.content}">
					<div class="col-3">
						<div class="product-item">
							<a href="#"><img src="/static/upload/${item.image}" alt=""></a>
							<div class="down-content">
								<a href="#"><h4>${item.name}</h4></a> <a> $${item.price}</a> <br>
								<h7>Reduced : $${item.price*(100-item.discount)*0.01}</h7>

								<p>The product from Chelsea Football Club</p>
								<ul class="stars">
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i></li>
								</ul>
								</br> <a class="filled-button" href="/Home/product/about/${item.id}">Buy</a>
							</div>

						</div>
					</div>
				</c:forEach>
				<div class="col-md-12">
					<ul class="pages">
						<li><a href="/Home/product?p=0">1</a></li>
						<li><a href="/Home/product?p=1">2</a></li>
						<li><a href="/Home/product?p=2">3</a></li>
						<li><a href="/Home/product?p=3">4</a></li>
						<li><a href="#"><i class="fa fa-angle-double-right"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<script src="/AssignmentJava4PH17591/js/jquery.min.js"></script>
	<script src="/AssignmentJava4PH17591/js/popper.min.js"></script>
	<script src="/AssignmentJava4PH17591/js/bootstrap.min.js"></script>
</body>
</html>