package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.dao.UserDAO;
import com.daoimpl.UserDAOImpl;
import com.model.User;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDAOImpl dao = new UserDAOImpl();
		User user = dao.loginUser(email, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			response.sendRedirect(request.getContextPath() + "/user/dashboard.jsp");
		} else {
			response.getWriter().println("<h3 style='color:red;'>Invalid Email or Password</h3>");
		}
	}
}