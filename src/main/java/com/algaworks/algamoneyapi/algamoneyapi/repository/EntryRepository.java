package com.algaworks.algamoneyapi.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.algamoneyapi.model.Entry;
import com.algaworks.algamoneyapi.algamoneyapi.repository.entrysearch.EntryRepositoryQuery;

public interface EntryRepository extends JpaRepository<Entry, Long>,  EntryRepositoryQuery {

}
