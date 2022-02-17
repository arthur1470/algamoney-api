package com.algaworks.algamoneyapi.algamoneyapi.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class EntrySearchFilter {

	private String description;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate expirationDateFrom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate expirationDateTo;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getExpirationDateFrom() {
		return expirationDateFrom;
	}
	public void setExpirationDateFrom(LocalDate expirationDateFrom) {
		this.expirationDateFrom = expirationDateFrom;
	}
	public LocalDate getExpirationDateTo() {
		return expirationDateTo;
	}
	public void setExpirationDateTo(LocalDate expirationDateTo) {
		this.expirationDateTo = expirationDateTo;
	}	
}
