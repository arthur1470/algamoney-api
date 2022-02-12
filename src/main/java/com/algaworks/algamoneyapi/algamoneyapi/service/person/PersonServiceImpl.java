package com.algaworks.algamoneyapi.algamoneyapi.service.person;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.algamoneyapi.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
 	 
	private final PersonRepository personRepository;
	private final ApplicationEventPublisher publisher;


	public PersonServiceImpl(PersonRepository personRepository, ApplicationEventPublisher publisher) {
		this.personRepository = personRepository;
		this.publisher = publisher;
	}
	
	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findById(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Person insert(Person person, HttpServletResponse response) {
		person = personRepository.saveAndFlush(person); 		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, person.getId()));
		return person;
 	}
	
	@Override
	public void delete(Long id) {
		personRepository.deleteById(id);		
	}

	@Override
	public Person update(Long id, Person person) {
		Person databasePerson = findById(id);							
		BeanUtils.copyProperties(person, databasePerson);		
		
		return personRepository.save(databasePerson);
	}

	@Override
	public void update(Long id, Boolean isActive) {
		Person person = findById(id);
		
		if(!person.getIsActive().equals(isActive)) {
			person.setIsActive(isActive);
			personRepository.save(person);
		}		
	}	
}
