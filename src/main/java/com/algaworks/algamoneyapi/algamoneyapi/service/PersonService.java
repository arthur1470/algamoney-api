package com.algaworks.algamoneyapi.algamoneyapi.service;

import javax.servlet.http.HttpServletResponse;

import com.algaworks.algamoneyapi.algamoneyapi.model.Person;

public interface PersonService {

	Person insert(Person person, HttpServletResponse response);

	Person findById(String id);

	Person update(String id, Person person);
}
