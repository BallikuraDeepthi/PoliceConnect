package com.dao;

import java.util.List;
import com.model.Complaint;

public interface ComplaintDAO {

	// Add complaint
	boolean addComplaint(Complaint complaint);

	// Assign complaint to police
	boolean assignComplaint(int complaintId, int policeId);

	// Update complaint status
	boolean updateStatus(int complaintId, String status);

	List<Complaint> getAllComplaints();

	List<Complaint> getComplaintsByUser(int userId);
}