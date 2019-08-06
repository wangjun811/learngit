package com.test.optional;

import java.util.Optional;

public class User {

	String email;
	
	String position;
	
	Address address;
	
	public User() {
		
	}
	
	public User(String email, String position) {
		this.email = email;
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Optional<Address> getAddress() {
		return Optional.ofNullable(address);
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
