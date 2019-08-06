package com.test.service;

import com.test.model.User;

public interface UserService {

	public User getNameById(User user);
	
	public void addUser(User user);
}
