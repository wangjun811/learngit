package com.test.annotation.test2;

public class UserController {

	@Inject
	private UserService userService;
	
	public void save() {
		userService.save();
	}
	
	public UserController() {
		
	}
}
