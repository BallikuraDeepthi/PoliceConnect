package com.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.daoimpl.UserDAOImpl;
import com.model.User;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");

		User user = new User(name, email, password, address);
		UserDAOImpl dao = new UserDAOImpl();
		boolean status = dao.registerUser(user);

		if (status) {
			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
		} else {
			response.getWriter().println("<h3 style='color:red;'>Registration Failed. Email may already exist.</h3>");
		}
	}
}