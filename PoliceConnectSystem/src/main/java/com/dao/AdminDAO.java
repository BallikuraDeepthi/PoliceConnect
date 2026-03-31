package com.dao;

import com.model.Admin;

public interface AdminDAO {
	Admin loginAdmin(String username, String password);
}