package com.algaworks.algamoneyapi.algamoneyapi.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "category")
public class Category {

	@Id		
	private String id;	
	@NotNull
	@Size(min = 3, max = 30)
	private String name;		
}
