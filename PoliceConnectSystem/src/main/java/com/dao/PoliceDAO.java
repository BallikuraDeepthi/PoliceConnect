package com.dao;

import java.util.List;
import com.model.PoliceStation;

public interface PoliceDAO {

	// Add new police station
	boolean addPolice(PoliceStation police);

	// Police login
	PoliceStation loginPolice(String username, String password);

	// 🔥 NEW: Get all police stations
	List<PoliceStation> getAllPolice();
}