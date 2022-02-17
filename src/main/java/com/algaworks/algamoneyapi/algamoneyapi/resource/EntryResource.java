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

import com.algaworks.algamoneyapi.algamoneyapi.dto.EntryDto;
import com.algaworks.algamoneyapi.algamoneyapi.model.Entry;
import com.algaworks.algamoneyapi.algamoneyapi.repository.filter.EntrySearchFilter;
import com.algaworks.algamoneyapi.algamoneyapi.service.entry.EntryService;

@RestController
@RequestMapping("/entry")
public class EntryResource {
	
	private final EntryService entryService;
	
	public EntryResource(EntryService entryService) {
		this.entryService = entryService;
	}	
	
	@GetMapping
	public List<Entry> search(EntrySearchFilter searchFilter) {
		return entryService.findByFilter(searchFilter);
	}
	
	@PostMapping
	public ResponseEntity<Entry> insert(@RequestBody @Valid EntryDto entryDto, HttpServletResponse response) {
		Entry entry = entryService.insert(entryDto.getEntry(), response);					
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entry);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entry> getEntryById(@PathVariable Long id) {
		Entry entry = entryService.findById(id);					
		
		return ResponseEntity.ok(entry);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEntry(@PathVariable Long id) {
		entryService.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Entry> update(@PathVariable Long id, @RequestBody @Valid EntryDto entryDto) {
		Entry entry = entryService.update(id, entryDto.getEntry()); 				
		
		return ResponseEntity.ok(entry);
	}	
}
