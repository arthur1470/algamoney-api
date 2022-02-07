package com.algaworks.algamoneyapi.algamoneyapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.algamoneyapi.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryResource {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		List<Category> category = categoryRepository.findAll();
		return ResponseEntity.ok(category);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Category> insert(@RequestBody @Valid Category category, HttpServletResponse response) {
		Category insertedCategory = categoryRepository.insert(category);			
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, insertedCategory.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(insertedCategory);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable String id) {
		Optional<Category> category = categoryRepository.findById(id);
		
		if(category.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(category.get());				
	}
}
