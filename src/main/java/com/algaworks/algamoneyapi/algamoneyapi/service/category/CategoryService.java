package com.algaworks.algamoneyapi.algamoneyapi.service.category;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.algaworks.algamoneyapi.algamoneyapi.model.Category;

public interface CategoryService {

	public List<Category> getAll();
	
	public Category insert(Category category, HttpServletResponse response);
		
	public Category findById(Long id);		

}
