package com.algaworks.algamoneyapi.algamoneyapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.algaworks.algamoneyapi.algamoneyapi.model.Category;

public class CategoryDto {

	@NotEmpty
	@Size(min = 3, max = 30)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return new Category(name);
	}	
}
