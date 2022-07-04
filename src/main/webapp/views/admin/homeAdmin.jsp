<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Admin</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<link rel="stylesheet" href="/AssignmentJava5/css/bootstrap.min.css" ></link>
</head>
<body>
<div class="row">
<div class="col-4">
<div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
      <svg class="bi pe-none me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
      <span class="fs-4">Quản lý</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="/homeAdmin/views" class="nav-link active" aria-current="page">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"/></svg>
          Home
        </a>
      </li>
      <li>
        <a href="/AssignmentJava5/admin/accounts/index" class="nav-link link-dark">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
          Accounts
        </a>
      </li>
      <li>
        <a href="/AssignmentJava5/categorys/homeAdmin" class="nav-link link-dark">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#table"/></svg>
          Categorys
        </a>
      </li>
      <li>
        <a href="/AssignmentJava5/admin/product/index" class="nav-link link-dark">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
          Products
        </a>
      </li>
      <li>
        <a href="AssignmentJava5/admin/orders/index" class="nav-link link-dark">
          <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
          Order
        </a>
      </li>
    </ul>
  </div>

</div>
<div class="col-8">
<jsp:include page="${viewsAdmin}"></jsp:include>
</div>
</div>
  
  <script src="/AssignmentJava5/js/jquery.min.js"></script>
	<script src="/AssignmentJava5/js/popper.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.min.js"></script>
	<script src="/AssignmentJava5/js/bootstrap.bundle.min.js"></script>
</body>
</html>