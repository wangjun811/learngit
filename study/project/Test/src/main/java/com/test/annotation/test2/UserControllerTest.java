package com.test.annotation.test2;

public class UserControllerTest {

	public static void main(String[] args) {
		UserController userController = BeanFactory.getBean(UserController.class);
		userController.save();
	}
}
