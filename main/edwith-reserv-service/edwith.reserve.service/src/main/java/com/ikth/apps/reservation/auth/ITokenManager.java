package com.ikth.apps.reservation.auth;

import javax.servlet.ServletRequest;

import org.springframework.security.core.Authentication;

public interface ITokenManager {
	
	String createToken(String userName);
	
	Authentication getAutentication(final String token);
	
	String resolveToken(ServletRequest request);

	boolean validateToken(final String token);
}
