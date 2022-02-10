package com.algaworks.algamoneyapi.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.algamoneyapi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
