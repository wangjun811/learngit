package com.test.optional;

import java.util.Optional;

public class Address {

	Country country;

	public Optional<Country> getCountry() {
		return Optional.ofNullable(country);
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
