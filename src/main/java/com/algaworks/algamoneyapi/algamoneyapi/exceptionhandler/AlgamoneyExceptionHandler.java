package com.algaworks.algamoneyapi.algamoneyapi.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String userErrorMessage = messageSource.getMessage("message.invalid", null, LocaleContextHolder.getLocale());
		String developerErrorMessage = ex.getCause().getMessage();
		
		return handleExceptionInternal(ex, new Error(userErrorMessage, developerErrorMessage), headers, HttpStatus.BAD_REQUEST, request);
	} 
	
	public static class Error {
		private String userErrorMessage;
		private String developerErrorMessage;
		
		public Error(String userErrorMessage, String developerErrorMessage) {
			this.userErrorMessage = userErrorMessage;
			this.developerErrorMessage = developerErrorMessage;
		}

		public String getUserErrorMessage() {
			return userErrorMessage;
		}

		public String getDeveloperErrorMessage() {
			return developerErrorMessage;
		}				
	}
}
