package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.dao.PoliceDAO;
import com.daoimpl.PoliceDAOImpl;
import com.model.PoliceStation;

@WebServlet("/policeLogin")
public class PoliceLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PoliceDAOImpl dao = new PoliceDAOImpl();
		PoliceStation police = dao.loginPolice(username, password);

		if (police != null) {
			HttpSession session = request.getSession();
			session.setAttribute("police", police);

			response.sendRedirect(request.getContextPath() + "/police/dashboard.jsp");
		} else {
			response.getWriter().println("<h3 style='color:red;'>Invalid Police Login</h3>");
		}
	}
}