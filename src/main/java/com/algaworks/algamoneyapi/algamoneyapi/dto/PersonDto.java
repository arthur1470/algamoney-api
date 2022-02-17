package com.algaworks.algamoneyapi.algamoneyapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.algaworks.algamoneyapi.algamoneyapi.model.Address;
import com.algaworks.algamoneyapi.algamoneyapi.model.Person;

public class PersonDto {

	@NotEmpty
	private String name;		
	private Boolean isActive;
	@NotNull
	private Address address;
	
	public String getName() {
		return name;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public Address getAddress() {
		return address;
	}	
	
	public Person getPerson() {
		return new Person(name, isActive, address);
	}
}
