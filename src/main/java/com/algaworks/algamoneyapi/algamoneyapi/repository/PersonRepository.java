package com.algaworks.algamoneyapi.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.algamoneyapi.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
