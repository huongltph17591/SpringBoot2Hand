<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2 Hand</title>
<link rel="stylesheet"
	href="/AssignmentJava5/css/bootstrap.min.css" />
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
				<input type="text" placeholder="Tìm kiếm" class="col-8"
					style="height: 40px; margin-top: 10px;">
				<button class="col-4"
					style="width: 40px; height: 40px; margin-top: 10px;">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  					<path
							d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" /></svg>
				</button>
			</div>
		</div>

		<nav class="p-3 mb-3 border-bottom border-top">
			<div class="container-fluid d-grid gap-3 align-items-center" style="grid-template-columns: 1fr 2fr;">
      <div class="dropdown">
        <a href="#" class="d-flex align-items-center col-lg-4 mb-2 mb-lg-0 link-dark text-decoration-none dropdown-toggle" id="dropdownNavLink" data-bs-toggle="dropdown" aria-expanded="false">
          <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
        </a>
        <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownNavLink">
          <li><a class="dropdown-item active" href="#" aria-current="page">Overview</a></li>
          <li><a class="dropdown-item" href="#">Inventory</a></li>
          <li><a class="dropdown-item" href="#">Customers</a></li>
          <li><a class="dropdown-item" href="#">Products</a></li>
          <li><hr class="dropdown-divider"></li>
          <li><a class="dropdown-item" href="#">Reports</a></li>
          <li><a class="dropdown-item" href="#">Analytics</a></li>
        </ul>
      </div>

      <div class="d-flex align-items-center">
        <form class="w-100 me-3" role="search">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>

        <div class="flex-shrink-0 dropdown">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
            <li><a class="dropdown-item" href="#">New project...</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sign out</a></li>
          </ul>
        </div>
      </div>
    </div>
	</nav>
	<script src="/AssignmentJava5/js/bootstrap.bundle.min.js"></script>
	<script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
	
</body>
</html>