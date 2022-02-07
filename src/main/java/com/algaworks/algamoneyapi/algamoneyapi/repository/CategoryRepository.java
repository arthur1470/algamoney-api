package com.algaworks.algamoneyapi.algamoneyapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.algaworks.algamoneyapi.algamoneyapi.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
