package com.ikth.apps.reservation.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(id, passwd));
		} catch (BadCredentialsException e) {
			AuthToken token= new AuthToken();
			token.setSuccess(false);
			token.setFailMsg("It is invalid user or password.");
			return new ResponseEntity<>(token, HttpStatus.OK);
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		AuthToken token= new AuthToken();
		
		/**
		 * TODO password encryption
		 */
		token.setToken(tokenManager.createToken(id, passwd));
		token.setSuccess(true);
		
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
	
	@RequestMapping(value="/userLogout", method= RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		/**
		 * do nothing -> 그냥 간단히 여기서..
		 */
		Cookie[] cookies= req.getCookies();
		
		if(cookies == null
				|| cookies.length < 1) {
			logger.debug("no cookie is detected.");
			return "redirect:/";
		}
		
		for(Cookie cookie : cookies) {
			if("Bearer".equals(cookie.getName())) {
				cookie.setMaxAge(-1);
				cookie.setValue(null);
				res.addCookie(cookie);
			}
		}
		
		try {
			req.logout();
		} catch (ServletException e) {
			logger.error(e.getMessage(), e);
		}
		
		return "redirect:/";
	}
}
