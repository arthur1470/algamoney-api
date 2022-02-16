package com.algaworks.algamoneyapi.algamoneyapi.service.entry;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.algamoneyapi.event.ResourceCreatedEvent;
import com.algaworks.algamoneyapi.algamoneyapi.model.Entry;
import com.algaworks.algamoneyapi.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.algamoneyapi.repository.EntryRepository;
import com.algaworks.algamoneyapi.algamoneyapi.repository.PersonRepository;
import com.algaworks.algamoneyapi.algamoneyapi.service.exception.PersonNullOrInactiveException;

@Service
public class EntryServiceImpl implements EntryService {

	private final EntryRepository entryRepository;
	private final ApplicationEventPublisher publisher;
	private final PersonRepository personRepository;
	
	public EntryServiceImpl(EntryRepository entryRepository, ApplicationEventPublisher publisher, PersonRepository personRepository) {
		this.entryRepository = entryRepository;
		this.publisher = publisher;
		this.personRepository = personRepository;
	}
	
	@Override
	public List<Entry> getAll() {
		return entryRepository.findAll();
	}

	@Override
	public Entry insert(Entry entry, HttpServletResponse response) {
		Person person = personRepository.getById(entry.getPerson().getId());
		
		if(person == null || person.isInactive()) {
			throw new PersonNullOrInactiveException();
		}
		
		
		entry = entryRepository.saveAndFlush(entry);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, entry.getId()));
		return entry;
	}

	@Override
	public void delete(Long id) {
		entryRepository.deleteById(id);
	}

	@Override
	public Entry findById(Long id) {
		return entryRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Entry update(Long id, Entry entry) {
		Entry entryDatabase = findById(id);
		BeanUtils.copyProperties(entry, entryDatabase);
		return entryRepository.saveAndFlush(entryDatabase);
	}

}
