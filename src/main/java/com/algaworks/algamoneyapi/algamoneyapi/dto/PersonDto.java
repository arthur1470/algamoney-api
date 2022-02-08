package com.algaworks.algamoneyapi.algamoneyapi.dto;

import javax.validation.constraints.NotNull;

import com.algaworks.algamoneyapi.algamoneyapi.model.Address;

public class PersonDto {

	@NotNull
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
}
