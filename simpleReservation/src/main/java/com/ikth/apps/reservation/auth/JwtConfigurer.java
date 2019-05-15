package com.ikth.apps.reservation.auth;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>
{
	@Override
	public void configure(HttpSecurity builder) throws Exception {
		JwtAuthTokenFilter customFilter= new JwtAuthTokenFilter(new JwtTokenManager());
		builder.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
