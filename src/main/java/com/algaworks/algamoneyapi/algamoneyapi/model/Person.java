package com.algaworks.algamoneyapi.algamoneyapi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "person")
public class Person {
	
	@Null
	private String id;
	@NotNull
	private String name;		
	private Boolean isActive;
	@NotNull
	private Address address;	
}
