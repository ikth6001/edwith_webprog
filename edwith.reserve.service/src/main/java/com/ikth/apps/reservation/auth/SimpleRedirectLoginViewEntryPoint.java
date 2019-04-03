package com.ikth.apps.reservation.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class SimpleRedirectLoginViewEntryPoint extends BasicAuthenticationEntryPoint
{
	@Override
	public void commence(
			HttpServletRequest request
			, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException 
	{
		/**
		 * REST API와 MVC 뷰 요청의 구분..
		 */
		if(request.getRequestURI().startsWith("/edwith.reserve.service/api")) {
			response.sendError(HttpStatus.UNAUTHORIZED.value());
		} else {
			response.sendRedirect("/edwith.reserve.service/loginView");
		}
	}
}
