package com.model;

public class Complaint {

	private int id;
	private int userId;
	private String complaint;
	private String image;
	private String zone;
	private int policeId;
	private String status;

	public Complaint() {
	}

	public Complaint(int userId, String complaint, String image, String zone, String status) {
		this.userId = userId;
		this.complaint = complaint;
		this.image = image;
		this.zone = zone;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public int getPoliceId() {
		return policeId;
	}

	public void setPoliceId(int policeId) {
		this.policeId = policeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}