<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Police</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: #f5f5f5;
}

.card {
	border-radius: 15px;
}
</style>

</head>
<body>

	<div class="container mt-5 col-md-4">
		<div class="card shadow p-4">

			<h3 class="text-center mb-3">🚔 Add Police Station</h3>

			<form action="<%=request.getContextPath()%>/addPolice" method="post">

				<input type="text" name="name" class="form-control mb-3"
					placeholder="Police Station Name" required> <select
					name="zone" class="form-control mb-3" required>
					<option value="">Select Zone</option>
					<option>North</option>
					<option>South</option>
					<option>East</option>
					<option>West</option>
				</select> <input type="text" name="username" class="form-control mb-3"
					placeholder="Username" required> <input type="password"
					name="password" class="form-control mb-3" placeholder="Password"
					required>

				<button class="btn btn-success w-100">Add Police</button>

			</form>

			<a href="dashboard.jsp" class="btn btn-secondary mt-3 w-100">Back</a>

		</div>
	</div>

</body>
</html>