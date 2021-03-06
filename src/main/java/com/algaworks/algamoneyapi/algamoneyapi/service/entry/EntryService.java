package com.algaworks.algamoneyapi.algamoneyapi.service.entry;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.algaworks.algamoneyapi.algamoneyapi.model.Entry;
import com.algaworks.algamoneyapi.algamoneyapi.repository.filter.EntrySearchFilter;

public interface EntryService {
	
	List<Entry> getAll();

	Entry insert(Entry entry, HttpServletResponse response);
	
	void delete(Long id);

	Entry findById(Long id);

	Entry update(Long id, Entry entry);
	
	List<Entry> findByFilter(EntrySearchFilter filter);

}
