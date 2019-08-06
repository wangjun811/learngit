package com.test.annotation.test2;

public class UserService {

	@Inject
	private UserDao userDao;
	
	@Inject
	private ClassDao classDao;
	
	public void save() {
		userDao.save();
		classDao.save();
	}
	
	public UserService() {
		
	}
}
