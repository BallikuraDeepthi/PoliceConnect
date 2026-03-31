<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="java.util.*,com.model.*,com.daoimpl.*"%>

<%
if (session.getAttribute("user") == null) {
	response.sendRedirect(request.getContextPath() + "/user/login.jsp");
	return;
}

User user = (User) session.getAttribute("user");

ComplaintDAOImpl dao = new ComplaintDAOImpl();
List<Complaint> list = dao.getComplaintsByUser(user.getId());
%>

<!DOCTYPE html>
<html>
<head>
<title>User Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<nav class="navbar bg-dark p-3">
		<span class="text-white">👤 User Dashboard</span> <a
			href="<%=request.getContextPath()%>/logout" class="btn btn-danger">Logout</a>
	</nav>

	<div class="container mt-4">

		<a href="<%=request.getContextPath()%>/user/complaint.jsp"
			class="btn btn-primary mb-3"> File Complaint </a>

		<h4>Your Complaints</h4>

		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Complaint</th>
				<th>Zone</th>
				<th>Status</th>
				<th>Image</th>
			</tr>

			<%
			for (Complaint c : list) {
			%>

			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getComplaint()%></td>
				<td><%=c.getZone()%></td>
				<td><%=c.getStatus()%></td>

				<td><img
					src="<%=request.getContextPath()%>/uploads/<%=c.getImage()%>"
					width="80"></td>
			</tr>

			<%
			}
			%>

		</table>

	</div>

</body>
</html>