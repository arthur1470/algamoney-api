package com.algaworks.algamoneyapi.algamoneyapi.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		
		List<Error> error = Arrays.asList(new Error(userErrorMessage, developerErrorMessage));
		
		return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
	} 
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) { 
		
		List<Error> error = getErrorList(ex.getBindingResult());
		return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(WebRequest request, EmptyResultDataAccessException ex) {
		
		String userErrorMessage = messageSource.getMessage("resource.not-found", null, LocaleContextHolder.getLocale());
		String developerErrorMessage = ex.toString();
		
		List<Error> error = Arrays.asList(new Error(userErrorMessage, developerErrorMessage));
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Error> getErrorList(BindingResult bindingResult) {
		List<Error> error = new ArrayList<Error>();
		
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) {			
			String userErrorMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String developerErrorMessage = fieldError.toString();
			
			error.add(new Error(userErrorMessage, developerErrorMessage));
		}
		
		return error;
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
