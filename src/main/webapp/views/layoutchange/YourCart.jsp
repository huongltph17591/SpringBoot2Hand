<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css" />
</head>
<body>
	<div class="latest-products mt-5">
		<div class="container">

			<div class="content">
				<div class="row">
					<div class="col-md-4">
						<div class="card card-user">
							<div class="image"></div>
							<div class="card-body">
								<div class="author">
									<a href="#"> <img class="avatar border-gray"
										src="/AssignmentJava5/images/${account.photo}"
										style="width: 150px; height: 150px;">
										<h5 class="title">${account.username}</h5>
									</a>
									<p class="description">@chetfaker</p>
								</div>
								<p class="description text-center">
									"I like the way you work it <br> No diggity <br> I
									wanna bag it up"
								</p>
							</div>
							<div class="card-footer">
								<hr>
								<div class="button-container">
									<div class="row">
										<div class="col-lg-3 col-md-6 col-6 ml-auto">
											<h5>
												12<br>
												<small>Files</small>
											</h5>
										</div>
										<div class="col-lg-4 col-md-6 col-6 ml-auto mr-auto">
											<h5>
												2GB<br>
												<small>Used</small>
											</h5>
										</div>
										<div class="col-lg-3 mr-auto">
											<h5>
												24,6$<br>
												<small>Spent</small>
											</h5>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-8">
						<div class="card card-user">
							<div class="card-header">
								<h5 class="card-title">Your Order</h5>
							</div>
							<div class="card-body">

								<table class="table table-bordered">
									<thead>
										<tr>
											<th scope="col">Username</th>
											<th scope="col">CreateDate</th>
											<th scope="col">Address</th>
											<th scope="col">Available</th>
											<th scope="col">Confirm</th>
											<th scope="col">Details</th>
											<th scope="col">Price</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${items}">
											<tr>
												<td>${item.username}</td>
												<td>${item.createDate}</td>
												<td>${item.address}</td>
												<td>${item.available?"Ordered":"Cancel"}</td>
												<td>${item.confirm?"Confirmed":"Cancel"}</td>
												<td>${item.price}</td>
												<td><a href="/home/YourCart/Details/${item.id}">Detail</a>
													<a href="/home/YourCart/Cancel/${item.id}">Cancel</a></td>

											</tr>
										</c:forEach>
										<h4>${message}</h4>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/AssignmentJava4PH17591/js/jquery.min.js"></script>
	<script src="/AssignmentJava4PH17591/js/popper.min.js"></script>
	<script src="/AssignmentJava4PH17591/js/bootstrap.min.js"></script>
</body>
</html>
