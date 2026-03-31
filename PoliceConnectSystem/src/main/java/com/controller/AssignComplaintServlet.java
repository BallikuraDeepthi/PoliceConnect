package com.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.dao.ComplaintDAO;
import com.daoimpl.ComplaintDAOImpl;

@WebServlet("/assignComplaint")
public class AssignComplaintServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int complaintId = Integer.parseInt(request.getParameter("complaintId"));
		int policeId = Integer.parseInt(request.getParameter("policeId"));

		ComplaintDAO dao = new ComplaintDAOImpl();
		boolean status = dao.assignComplaint(complaintId, policeId);

		if (status) {
			response.sendRedirect("admin/dashboard.jsp");
		} else {
			response.getWriter().println("Assign Failed");
		}
	}
}