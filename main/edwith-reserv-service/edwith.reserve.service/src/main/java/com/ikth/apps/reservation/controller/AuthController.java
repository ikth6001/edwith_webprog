package com.ikth.apps.reservation.controller;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ikth.apps.reservation.auth.ITokenManager;
import com.ikth.apps.reservation.dto.AuthToken;

@Validated
@Controller
public class AuthController {
	
	private final static Logger logger= LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private ITokenManager tokenManager;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@RequestMapping(value="/loginView", method= RequestMethod.GET)
	public String loginView() {
		return "loginView";
	}
	
	@RequestMapping(value="/login" , method= RequestMethod.GET)
	public ResponseEntity<AuthToken> login(@NotEmpty @RequestParam("id") String id
			, @NotEmpty @RequestParam("passwd") String passwd) {
		logger.debug("requested id [{}] and encrypted password [{}]", id, passwd);
		
		/**
		 * TODO User Service
		 */
		authManager.authenticate(new UsernamePasswordAuthenticationToken(id, passwd));
		
		AuthToken token= new AuthToken();
		token.setToken(tokenManager.createToken(id));
		token.setSuccess(true);
		
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

}
