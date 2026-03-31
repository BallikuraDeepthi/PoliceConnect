package com.daoimpl;

import java.sql.*;

import com.dao.AdminDAO;
import com.model.Admin;
import com.util.DBConnection;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin loginAdmin(String username, String password) {

		Admin admin = null;

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM admin WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return admin;
	}
}