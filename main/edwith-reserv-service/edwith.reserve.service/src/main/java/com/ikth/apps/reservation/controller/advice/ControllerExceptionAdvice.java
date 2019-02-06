package com.ikth.apps.reservation.controller.advice;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@Deprecated
@RestControllerAdvice
public class ControllerExceptionAdvice 
{
//	private final static Logger logger= LoggerFactory.getLogger(ControllerExceptionAdvice.class);
//	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> redirectToErrorPage(Exception ex, HttpServletRequest req, HttpServletResponse res) {
//		logger.error("detected application exception", ex);
//		HttpHeaders header= new HttpHeaders();
//		URI redirectUri= URI.create("error?cause=" + ex.getMessage().replaceAll("\\s", "%20"));
//		logger.debug("redirect response uri [{}]", redirectUri.toString());
//		
//		header.setLocation(redirectUri);
//		return new ResponseEntity<HttpHeaders>(header, HttpStatus.MOVED_PERMANENTLY);
//	}
}
