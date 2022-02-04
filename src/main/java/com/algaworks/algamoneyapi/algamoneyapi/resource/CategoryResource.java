package com.algaworks.algamoneyapi.algamoneyapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.algamoneyapi.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryResource {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
}
