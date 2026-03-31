<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5 col-md-4">
		<div class="card shadow p-4">
			<h3 class="text-center">Admin Login</h3>
			<form action="<%=request.getContextPath()%>/adminLogin" method="post">
				<input name="username" class="form-control mb-3"
					placeholder="Username" required> <input name="password"
					type="password" class="form-control mb-3" placeholder="Password"
					required>
				<button class="btn btn-danger w-100">Login</button>
			</form>
		</div>
	</div>
</body>
</html>