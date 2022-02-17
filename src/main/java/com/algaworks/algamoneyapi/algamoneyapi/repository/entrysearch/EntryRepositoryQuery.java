package com.algaworks.algamoneyapi.algamoneyapi.repository.entrysearch;

import java.util.List;

import com.algaworks.algamoneyapi.algamoneyapi.model.Entry;
import com.algaworks.algamoneyapi.algamoneyapi.repository.filter.EntrySearchFilter;

public interface EntryRepositoryQuery {

	public List<Entry> filter(EntrySearchFilter filter);
}
