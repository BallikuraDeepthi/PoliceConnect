package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.PoliceDAO;
import com.model.PoliceStation;
import com.util.DBConnection;

public class PoliceDAOImpl implements PoliceDAO {

	// 🔹 ADD POLICE
	public boolean addPolice(PoliceStation police) {

		boolean status = false;

		try {
			Connection con = DBConnection.getConnection();

			String sql = "INSERT INTO police_station(name, zone, username, password) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, police.getName());
			ps.setString(2, police.getZone());
			ps.setString(3, police.getUsername());
			ps.setString(4, police.getPassword());

			int i = ps.executeUpdate();

			if (i > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// 🔹 POLICE LOGIN
	public PoliceStation loginPolice(String username, String password) {

		PoliceStation police = null;

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM police_station WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				police = new PoliceStation();

				police.setId(rs.getInt("id"));
				police.setName(rs.getString("name"));
				police.setZone(rs.getString("zone"));
				police.setUsername(rs.getString("username"));
				police.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return police;
	}

	// 🔥 🔹 GET ALL POLICE (VERY IMPORTANT FOR ADMIN)
	public List<PoliceStation> getAllPolice() {

		List<PoliceStation> list = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM police_station";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				PoliceStation p = new PoliceStation();

				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setZone(rs.getString("zone"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));

				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}