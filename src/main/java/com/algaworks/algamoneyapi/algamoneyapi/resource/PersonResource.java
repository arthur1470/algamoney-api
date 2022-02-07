package com.algaworks.algamoneyapi.algamoneyapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algamoneyapi.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.algamoneyapi.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonResource {

	@Autowired
	private PersonRepository personRepository;	
	
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		List<Person> person = personRepository.findAll();
		return ResponseEntity.ok(person);
	}
	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody @Valid Person person) {
		Person insertedPerson = personRepository.insert(person); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(insertedPerson.getId())
					.toUri();
		
		return ResponseEntity.created(uri).body(insertedPerson); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable String id) {
		Optional<Person> person = personRepository.findById(id);
		
		if(person.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(person.get());
	}
}
