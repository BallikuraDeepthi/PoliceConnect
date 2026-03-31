package com.controller;

import java.io.IOException;
import com.daoimpl.AdminDAOImpl;
import com.model.Admin;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		AdminDAOImpl dao = new AdminDAOImpl();
		Admin admin = dao.loginAdmin(username, password);

		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);

			// ✅ Use context path
			response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
		} else {
			response.getWriter().println("<h3 style='color:red;'>Invalid Credentials</h3>");
		}
	}
}