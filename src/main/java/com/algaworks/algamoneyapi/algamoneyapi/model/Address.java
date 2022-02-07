package com.algaworks.algamoneyapi.algamoneyapi.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Address {
	
	@NotNull
	private String street;
	@NotNull
	private Integer number;	
	private String complement;
	@NotNull
	private String district;
	@NotNull
	private String zipCode;
	@NotNull
	private String city;
	@NotNull
	private String state;
}
