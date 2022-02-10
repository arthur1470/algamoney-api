package com.algaworks.algamoneyapi.algamoneyapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.algamoneyapi.dto.PersonDto;
import com.algaworks.algamoneyapi.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.algamoneyapi.repository.PersonRepository;
import com.algaworks.algamoneyapi.algamoneyapi.service.person.PersonService;

@RestController
@RequestMapping("/person")
public class PersonResource {
	
	private PersonService personService;	
	
	public PersonResource(PersonService personService, PersonRepository personRepository) {
		this.personService = personService;		
	}		
	
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		List<Person> person = personService.getAll();
		
		return ResponseEntity.ok(person);
	}
	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody @Valid PersonDto personDto, HttpServletResponse response) {
		Person person = personService.insert(personDto.getPerson(), response);			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(person);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		Person person = personService.findById(id);			
		
		return ResponseEntity.ok(person);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		personService.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) {
		Person person = personService.update(id, personDto.getPerson()); 				
		
		return ResponseEntity.ok(person);
	}
	
	@PutMapping("/{id}/active")
	public void update(Long id, Boolean isActive) {
		personService.update(id, isActive);
	}
}
