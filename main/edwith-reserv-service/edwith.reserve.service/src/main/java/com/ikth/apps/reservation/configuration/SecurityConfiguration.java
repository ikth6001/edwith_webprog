package com.ikth.apps.reservation.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ikth.apps.reservation.auth.JwtConfigurer;
import com.ikth.apps.reservation.auth.SimpleUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.httpBasic().disable()
			.csrf().disable() /** FOR REST API TODO CORS */
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers("/reservation/**").hasRole("USER")
				.antMatchers("/**").permitAll()
				.and()
				.apply(new JwtConfigurer())
			.and()
			/**
			 * form login 사용 안함.
			 */
//			.formLogin()
//				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/");
	}
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception 
//	{
//		auth.inMemoryAuthentication()
//			.withUser("bxm").password("password").roles("USER");
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.authenticationProvider(authenticationProvider());
	}
	
	private DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider ap= new DaoAuthenticationProvider();
		ap.setUserDetailsService(new SimpleUserDetailsService());
		
		return ap;
	}
}
