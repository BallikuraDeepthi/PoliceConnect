<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("user") == null) {
	response.sendRedirect(request.getContextPath() + "/user/login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>File Complaint</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark p-3">
		<span class="text-white">🚨 File Complaint</span> <a
			href="<%=request.getContextPath()%>/logout" class="btn btn-danger">Logout</a>
	</nav>

	<div class="container mt-5 col-md-6">
		<div class="card shadow p-4">
			<form action="<%=request.getContextPath()%>/addComplaint"
				method="post" enctype="multipart/form-data">
				<textarea name="complaint" class="form-control mb-3"
					placeholder="Enter complaint" required></textarea>
				<input type="file" name="image" class="form-control mb-3"> <select
					name="zone" class="form-control mb-3">
					<option>North</option>
					<option>South</option>
					<option>East</option>
					<option>West</option>
				</select>
				<button class="btn btn-danger w-100">Submit Complaint</button>
			</form>
		</div>
	</div>
</body>
</html>