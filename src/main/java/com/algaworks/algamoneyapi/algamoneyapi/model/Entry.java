package com.algaworks.algamoneyapi.algamoneyapi.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "entry")
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private LocalDate expirationDate;
	private LocalDate paymentDay;
	private Double value;
	private String observationNote;		
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;		
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@Enumerated
	private EntryType entryType;	
	
	public Entry() {
		super();
	}
	
	public Entry(String description, LocalDate expirationDate, LocalDate paymentDay, Double value,
			String observationNote, Person person, Category category, EntryType entryType) {
		super();
		this.description = description;
		this.expirationDate = expirationDate;
		this.paymentDay = paymentDay;
		this.value = value;
		this.observationNote = observationNote;
		this.person = person;
		this.category = category;
		this.entryType = entryType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public LocalDate getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(LocalDate paymentDay) {
		this.paymentDay = paymentDay;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getObservationNote() {
		return observationNote;
	}
	public void setObservationNote(String observationNote) {
		this.observationNote = observationNote;
	}
	public Long getId() {
		return id;
	}		
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public EntryType getEntryType() {
		return entryType;
	}

	public void setEntryType(EntryType entryType) {
		this.entryType = entryType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		return Objects.equals(id, other.id);
	}	
}
