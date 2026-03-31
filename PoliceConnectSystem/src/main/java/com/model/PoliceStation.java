package com.model;

public class PoliceStation {

	private int id;
	private String name;
	private String zone;
	private String username;
	private String password;

	public PoliceStation() {
	}

	public PoliceStation(String name, String zone, String username, String password) {
		this.name = name;
		this.zone = zone;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}