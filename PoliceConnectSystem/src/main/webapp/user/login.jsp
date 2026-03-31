<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5 col-md-4">
		<div class="card shadow p-4">
			<h3 class="text-center mb-3">User Login</h3>
			<form action="<%=request.getContextPath()%>/login" method="post">
				<input type="email" name="email" class="form-control mb-3"
					placeholder="Email" required> <input type="password"
					name="password" class="form-control mb-3" placeholder="Password"
					required>
				<button class="btn btn-success w-100">Login</button>
			</form>
			<p class="text-center mt-3">
				<a href="<%=request.getContextPath()%>/user/registr.jsp">New
					user? Register</a>
			</p>
		</div>
	</div>
</body>
</html>