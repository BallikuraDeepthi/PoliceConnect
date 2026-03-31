package com.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.dao.PoliceDAO;
import com.daoimpl.PoliceDAOImpl;
import com.model.PoliceStation;

@WebServlet("/addPolice")
public class AddPoliceServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String name = request.getParameter("name");
		String zone = request.getParameter("zone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PoliceStation police = new PoliceStation(name, zone, username, password);

		PoliceDAO dao = new PoliceDAOImpl();
		boolean status = dao.addPolice(police);

		if (status) {
			response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
		} else {
			response.getWriter().println("<h3 style='color:red;'>Failed to add police</h3>");
		}
	}
}