<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.model.*,com.daoimpl.*"%>

<%
// 🔴 SESSION CHECK (IMPORTANT FIX)
if (session.getAttribute("police") == null) {
	response.sendRedirect(request.getContextPath() + "/police/login.jsp");
	return; // ✅ VERY IMPORTANT (prevents infinite redirect loop)
}

//  Get logged-in police
PoliceStation police = (PoliceStation) session.getAttribute("police");


ComplaintDAOImpl dao = new ComplaintDAOImpl();
List<Complaint> list = dao.getAllComplaints();
%>

<!DOCTYPE html>
<html>
<head>
<title>Police Dashboard</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">


<style>
body {
	background: #f4f6f9;
}

.navbar {
	background: #212529;
}

.table th {
	background: #343a40;
	color: white;
}

.card {
	border-radius: 12px;
}
</style>
</head>

<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-dark px-4">
		<span class="text-white fs-5">👮 Police Dashboard</span>

		<div>
			<span class="text-white me-3"> Welcome, <b><%=police.getName()%></b>
			</span> <a href="<%=request.getContextPath()%>/logout"
				class="btn btn-danger btn-sm">Logout</a>
		</div>
	</nav>

	<!-- CONTENT -->
	<div class="container mt-4">

		<div class="card shadow p-3">
			<h4 class="mb-3">Assigned Complaints</h4>

			<table class="table table-bordered table-hover text-center">
				<tr>
					<th>ID</th>
					<th>Complaint</th>
					<th>Status</th>
					<th>Update</th>
				</tr>

				<%
				for (Complaint c : list) {
					if (c.getPoliceId() == police.getId()) {
				%>

				<tr>
					<td><%=c.getId()%></td>
					<td><%=c.getComplaint()%></td>
					<td><span class="badge bg-warning text-dark"> <%=c.getStatus()%>
					</span></td>

					<td>
						<form action="<%=request.getContextPath()%>/updateStatus"
							method="post">

							<input type="hidden" name="complaintId" value="<%=c.getId()%>">

							<select name="status" class="form-select">
								<option>Pending</option>
								<option>In Progress</option>
								<option>Resolved</option>
							</select>

							<button class="btn btn-success mt-2 w-100">Update</button>
						</form>
					</td>
				</tr>

				<%
				}
				}
				%>

			</table>

		</div>

	</div>

</body>
</html>