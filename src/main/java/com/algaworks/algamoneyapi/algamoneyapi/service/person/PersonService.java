package com.algaworks.algamoneyapi.algamoneyapi.service.person;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.algaworks.algamoneyapi.algamoneyapi.model.Person;

public interface PersonService {

	List<Person> getAll();

	Person insert(Person person, HttpServletResponse response);
	
	void delete(Long id);

	Person findById(Long id);

	Person update(Long id, Person person);

	void update(Long id, Boolean isActive);

}
