package com.ikth.apps.reservation.controller.advice;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice 
{
	private final static Logger logger= LoggerFactory.getLogger(ControllerExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> redirectToErrorPage(Exception ex, HttpServletRequest req, HttpServletResponse res) {
		logger.error("detected application exception", ex);
		HttpHeaders header= new HttpHeaders();
		URI redirectUri= URI.create("error?cause=" + ex.getMessage().replaceAll("\\s", "%20"));
		logger.debug("redirect response uri [{}]", redirectUri.toString());
		
		header.setLocation(redirectUri);
		return new ResponseEntity<HttpHeaders>(header, HttpStatus.MOVED_PERMANENTLY);
	}
}
