package com.algaworks.algamoneyapi.algamoneyapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.algamoneyapi.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonResource {

	@Autowired
	private PersonRepository personRepository;	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		List<Person> person = personRepository.findAll();
		return ResponseEntity.ok(person);
	}
	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody @Valid Person person, HttpServletResponse response) {
		Person insertedPerson = personRepository.insert(person); 
		
		publisher.publishEvent(new ResourceCreatedEvent(this, response, insertedPerson.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(insertedPerson); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable String id) {
		Optional<Person> person = personRepository.findById(id);
		
		if(person.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(person.get());
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable String id) {
		personRepository.deleteById(id);		
	}
}
