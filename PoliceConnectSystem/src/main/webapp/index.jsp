<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Police Connect</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: linear-gradient(to right, #141e30, #243b55);
	color: white;
	text-align: center;
}

.card-box {
	padding: 30px;
	border-radius: 15px;
	transition: 0.3s;
}

.card-box:hover {
	transform: scale(1.05);
}

.user {
	background: #0d6efd;
}

.admin {
	background: #dc3545;
}

.police {
	background: #198754;
}
</style>
</head>

<body>

	<h1 class="mt-5">🚓 Police Connect System</h1>
	<p>Smart Complaint Management Platform</p>

	<div class="container mt-5">
		<div class="row justify-content-center">

			<div class="col-md-3 m-3 card-box user">
				<h3>👤 User</h3>
				<a href="<%=request.getContextPath()%>/user/login.jsp"
					class="btn btn-light w-100">Go</a>
			</div>

			<div class="col-md-3 m-3 card-box admin">
				<h3>👑 Admin</h3>
				<a href="<%=request.getContextPath()%>/admin/login.jsp"
					class="btn btn-light w-100">Go</a>
			</div>

			<div class="col-md-3 m-3 card-box police">
				<h3>👮 Police</h3>
				<a href="<%=request.getContextPath()%>/police/login.jsp"
					class="btn btn-light w-100">Go</a>
			</div>

		</div>
	</div>

</body>
</html>