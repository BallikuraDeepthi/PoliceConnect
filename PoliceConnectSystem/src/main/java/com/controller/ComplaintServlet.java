package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import com.dao.ComplaintDAO;
import com.daoimpl.ComplaintDAOImpl;
import com.model.Complaint;
import com.model.User;

@WebServlet("/addComplaint")
@MultipartConfig 
public class ComplaintServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String complaintText = request.getParameter("complaint");
		String zone = request.getParameter("zone");

		Part filePart = request.getPart("image");
		String fileName = filePart.getSubmittedFileName();

		String uploadPath = getServletContext().getRealPath("") + "uploads";
		filePart.write(uploadPath + "/" + fileName);

		Complaint c = new Complaint(user.getId(), complaintText, fileName, zone, "Pending");

		ComplaintDAO dao = new ComplaintDAOImpl();
		boolean status = dao.addComplaint(c);

		if (status) {
			response.sendRedirect("user/dashboard.jsp");
		} else {
			response.getWriter().println("Failed");
		}
	}
}