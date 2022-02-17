package com.algaworks.algamoneyapi.algamoneyapi.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.algaworks.algamoneyapi.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.algamoneyapi.model.Entry;
import com.algaworks.algamoneyapi.algamoneyapi.model.EntryType;
import com.algaworks.algamoneyapi.algamoneyapi.model.Person;

public class EntryDto {

	@NotNull
	private String description;
	@NotNull
	private LocalDate expirationDate;
	private LocalDate paymentDay;
	@NotNull
	private Double value;
	@NotNull
	private String observationNote;
	@NotNull
	private Person person;
	@NotNull
	private Category category;
	@NotNull
	private EntryType entryType;
	
	public String getDescription() {
		return description;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public LocalDate getPaymentDay() {
		return paymentDay;
	}
	
	public Double getValue() {
		return value;
	}
	
	public String getObservationNote() {
		return observationNote;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public EntryType getEntryType() {
		return entryType;
	}	
	
	public Entry getEntry() {
		return new Entry(description
						, expirationDate
						, paymentDay
						, value
						, observationNote
						, person
						, category
						, entryType);
	}
}
