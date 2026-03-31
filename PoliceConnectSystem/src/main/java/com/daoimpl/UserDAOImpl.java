package com.daoimpl;

import java.sql.*;

import com.dao.UserDAO;
import com.model.User;
import com.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	public boolean registerUser(User user) {
		boolean status = false;
		String sql = "INSERT INTO users(name,email,password,address) VALUES (?,?,?,?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAddress());

			int i = ps.executeUpdate();
			if (i > 0)
				status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public User loginUser(String email, String password) {

		User user = null;

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM users WHERE email=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}