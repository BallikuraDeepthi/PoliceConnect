package com.daoimpl;

import java.sql.*;
import java.util.*;

import com.dao.ComplaintDAO;
import com.model.Complaint;
import com.util.DBConnection;

public class ComplaintDAOImpl implements ComplaintDAO {

	// ✅ ADD COMPLAINT
	public boolean addComplaint(Complaint c) {

		boolean status = false;

		try {
			Connection con = DBConnection.getConnection();

			String sql = "INSERT INTO complaints(user_id, complaint, image, zone, status) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, c.getUserId());
			ps.setString(2, c.getComplaint());
			ps.setString(3, c.getImage());
			ps.setString(4, c.getZone());
			ps.setString(5, c.getStatus());

			int i = ps.executeUpdate();

			if (i > 0)
				status = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// ✅ ASSIGN COMPLAINT
	public boolean assignComplaint(int complaintId, int policeId) {

		boolean status = false;

		try {
			Connection con = DBConnection.getConnection();

			String sql = "UPDATE complaints SET police_id=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, policeId);
			ps.setInt(2, complaintId);

			int i = ps.executeUpdate();

			if (i > 0)
				status = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// ✅ UPDATE STATUS
	public boolean updateStatus(int complaintId, String statusStr) {

		boolean status = false;

		try {
			Connection con = DBConnection.getConnection();

			String sql = "UPDATE complaints SET status=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, statusStr);
			ps.setInt(2, complaintId);

			int i = ps.executeUpdate();

			if (i > 0)
				status = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// ✅ ADMIN: GET ALL COMPLAINTS
	public List<Complaint> getAllComplaints() {

		List<Complaint> list = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM complaints";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Complaint c = new Complaint();

				c.setId(rs.getInt("id"));
				c.setUserId(rs.getInt("user_id"));
				c.setComplaint(rs.getString("complaint"));
				c.setImage(rs.getString("image"));
				c.setZone(rs.getString("zone"));
				c.setPoliceId(rs.getInt("police_id"));
				c.setStatus(rs.getString("status"));

				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// ✅ USER: GET OWN COMPLAINTS
	public List<Complaint> getComplaintsByUser(int userId) {

		List<Complaint> list = new ArrayList<>();

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM complaints WHERE user_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Complaint c = new Complaint();

				c.setId(rs.getInt("id"));
				c.setUserId(rs.getInt("user_id"));
				c.setComplaint(rs.getString("complaint"));
				c.setImage(rs.getString("image"));
				c.setZone(rs.getString("zone"));
				c.setPoliceId(rs.getInt("police_id"));
				c.setStatus(rs.getString("status"));

				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}