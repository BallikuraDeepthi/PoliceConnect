<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.daoimpl.*"%>

<%
if (session.getAttribute("admin") == null) {
	response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
	return;
}

ComplaintDAOImpl cdao = new ComplaintDAOImpl();
List<Complaint> complaints = cdao.getAllComplaints();

PoliceDAOImpl pdao = new PoliceDAOImpl();
List<PoliceStation> policeList = pdao.getAllPolice();
%>

<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<nav class="navbar navbar-dark bg-dark p-3">
		<span class="text-white fs-5">👑 Admin Dashboard</span> <a
			href="<%=request.getContextPath()%>/logout" class="btn btn-danger">Logout</a>
	</nav>

	<div class="container mt-4">

		<h3 class="mb-3">All Complaints</h3>

		<table class="table table-bordered table-hover">
			<tr>
				<th>ID</th>
				<th>Complaint</th>
				<th>Zone</th>
				<th>Status</th>
				<th>Image</th>
				<th>Assign</th>
			</tr>

			<%
			for (Complaint c : complaints) {
			%>

			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getComplaint()%></td>
				<td><%=c.getZone()%></td>
				<td><%=c.getStatus()%></td>

				<td><img
					src="<%=request.getContextPath()%>/uploads/<%=c.getImage()%>"
					width="80"></td>

				<td>
					<form action="<%=request.getContextPath()%>/assignComplaint"
						method="post">
						<input type="hidden" name="complaintId" value="<%=c.getId()%>">

						<select name="policeId" class="form-select">
							<%
							for (PoliceStation p : policeList) {
							%>
							<option value="<%=p.getId()%>">
								<%=p.getName()%> -
								<%=p.getZone()%>
							</option>
							<%
							}
							%>
						</select>

						<button class="btn btn-primary mt-2 w-100">Assign</button>
					</form>
				</td>
			</tr>

			<%
			}
			%>
		</table>

		<a href="<%=request.getContextPath()%>/admin/addPolice.jsp"
			class="btn btn-success"> Add Police </a>

	</div>

</body>
</html>