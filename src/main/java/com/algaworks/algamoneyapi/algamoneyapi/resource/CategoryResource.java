package com.algaworks.algamoneyapi.algamoneyapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.algamoneyapi.dto.CategoryDto;
import com.algaworks.algamoneyapi.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.algamoneyapi.service.category.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource {

	private final CategoryService categoryService;
	
	public CategoryResource(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		List<Category> category = categoryService.getAll();
		return ResponseEntity.ok(category);
	}
	
	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody @Valid CategoryDto categoryDto, HttpServletResponse response) {
		Category category = categoryService.insert(categoryDto.getCategory(), response);			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = categoryService.findById(id);		
		
		return ResponseEntity.ok(category);				
	}
}
