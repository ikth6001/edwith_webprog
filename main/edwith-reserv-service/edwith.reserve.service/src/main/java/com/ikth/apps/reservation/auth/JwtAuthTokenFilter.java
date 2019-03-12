package com.ikth.apps.reservation.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtAuthTokenFilter extends GenericFilterBean
{
	private final static Logger logger= LoggerFactory.getLogger(JwtAuthTokenFilter.class);

	private ITokenManager tokenManager;
	
	public JwtAuthTokenFilter(ITokenManager tokenManager) {
		this.tokenManager= tokenManager;
	}
	
	@Override
	public void doFilter(
			ServletRequest request
			, ServletResponse response
			, FilterChain chain) throws IOException, ServletException {
		
		final String token= tokenManager.resolveToken(request);
		logger.debug("The specified token value is [{}]", token);
		
		Authentication auth= tokenManager.getAutentication(token);
		if(auth != null) {
			if(tokenManager.validateToken(token)) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		chain.doFilter(request, response);
	}
}