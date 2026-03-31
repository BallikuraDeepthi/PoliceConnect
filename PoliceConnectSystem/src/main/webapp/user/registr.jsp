<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5 col-md-4">
		<div class="card shadow p-4">
			<h3 class="text-center mb-3">Register</h3>
			<form action="<%=request.getContextPath()%>/register" method="post">
				<input name="name" class="form-control mb-3" placeholder="Full Name"
					required> <input name="email" class="form-control mb-3"
					placeholder="Email" required> <input name="password"
					type="password" class="form-control mb-3" placeholder="Password"
					required> <input name="address" class="form-control mb-3"
					placeholder="Address" required>
				<button class="btn btn-primary w-100">Register</button>
			</form>
		</div>
	</div>
</body>
</html>