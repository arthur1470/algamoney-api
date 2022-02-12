package com.algaworks.algamoneyapi.algamoneyapi.service.category;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.algamoneyapi.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	private final ApplicationEventPublisher publisher;
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(ApplicationEventPublisher publisher, CategoryRepository categoryRepository) {
		this.publisher = publisher;
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category insert(Category category, HttpServletResponse response) {
		category = categoryRepository.save(category);		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, category.getId()));
		
		return category;
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1)); 		
	}

}
