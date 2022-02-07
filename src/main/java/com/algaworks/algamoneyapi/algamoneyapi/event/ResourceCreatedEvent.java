package com.algaworks.algamoneyapi.algamoneyapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class ResourceCreatedEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;
	private String id;
	
	public ResourceCreatedEvent(Object source, HttpServletResponse response, String id) {
		super(source);
		this.response = response;
		this.id = id;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public String getId() {
		return id;
	}
}
