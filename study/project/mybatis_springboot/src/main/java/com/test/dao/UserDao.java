package com.test.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.model.User;

@Mapper
public interface UserDao {

	public User getNameById(User uer);
	
	public void addUser(User uer);
	
	public void updateUser(User uer);
}
