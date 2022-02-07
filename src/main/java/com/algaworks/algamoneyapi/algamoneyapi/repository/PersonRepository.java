package com.algaworks.algamoneyapi.algamoneyapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.algaworks.algamoneyapi.algamoneyapi.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}
