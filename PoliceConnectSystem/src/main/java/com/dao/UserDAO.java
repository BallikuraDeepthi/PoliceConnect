package com.dao;

import com.model.User;

public interface UserDAO {

	boolean registerUser(User user);

	User loginUser(String email, String password);
}