package com.algaworks.algamoneyapi.algamoneyapi.repository.entrysearch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.algamoneyapi.algamoneyapi.model.Entry;
import com.algaworks.algamoneyapi.algamoneyapi.repository.filter.EntrySearchFilter;

public class EntryRepositoryQueryImpl implements EntryRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Entry> filter(EntrySearchFilter entrySearchFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Entry> criteria = builder.createQuery(Entry.class);
		Root<Entry> root = criteria.from(Entry.class);
		
		Predicate[] predicates = createRestrictions(entrySearchFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Entry> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] createRestrictions(EntrySearchFilter entrySearchFilter, CriteriaBuilder builder,
			Root<Entry> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(entrySearchFilter.getDescription())) {
			predicates.add(builder.like(
						builder.lower(root.get("description")), "%" + entrySearchFilter.getDescription().toLowerCase() + "%"
					));
		}
		
		if(entrySearchFilter.getExpirationDateFrom() != null) {
			predicates.add(
						builder.greaterThanOrEqualTo(root.get("expirationDate"), entrySearchFilter.getExpirationDateFrom())
					);
			
		}
		
		if(entrySearchFilter.getExpirationDateTo() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("expirationDate"), entrySearchFilter.getExpirationDateTo())
				);
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
