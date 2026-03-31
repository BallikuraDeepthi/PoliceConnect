package com.controller;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.dao.ComplaintDAO;
import com.daoimpl.ComplaintDAOImpl;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int complaintId = Integer.parseInt(request.getParameter("complaintId"));
		String status = request.getParameter("status");

		ComplaintDAO dao = new ComplaintDAOImpl();
		boolean result = dao.updateStatus(complaintId, status);

		if (result) {
			response.sendRedirect("police/dashboard.jsp");
		} else {
			response.getWriter().println("Update Failed");
		}
	}
}