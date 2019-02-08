package com.ikth.apps.reservation.controller.advice;

import java.net.URI;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerCommonAdvice 
{
	private final static Logger logger= LoggerFactory.getLogger(ControllerCommonAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> redirectToErrorPage(Exception ex, HttpServletRequest req, HttpServletResponse res) {
		logger.error("detected application exception", ex);
		HttpHeaders header= new HttpHeaders();
		Throwable cause= ex.getCause();
		String causeMsg= (cause == null) ? "" : cause.getMessage();
		URI redirectUri= URI.create("error?cause=" + causeMsg.replaceAll("\\s", "%20"));
		logger.debug("redirect response uri [{}]", redirectUri.toString());
		
		header.setLocation(redirectUri);
		return new ResponseEntity<HttpHeaders>(header, HttpStatus.MOVED_PERMANENTLY);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> noticeInvalidParameterRequest(ConstraintViolationException ex) {
		Iterator<ConstraintViolation<?>> iter= ex.getConstraintViolations().iterator();
		
		StringBuilder causeMsg= new StringBuilder();
		
		HttpHeaders responseHeader = new HttpHeaders();
	    responseHeader.add("Content-Type", "application/json;charset=UTF-8");
		
		while(iter.hasNext()) {
			ConstraintViolation<?> v= iter.next();
			causeMsg.append(v.getMessage()).append(System.getProperty("line.separator"));
		}
		
		return new ResponseEntity<String>(causeMsg.toString(), responseHeader, HttpStatus.BAD_REQUEST);
	}
}
