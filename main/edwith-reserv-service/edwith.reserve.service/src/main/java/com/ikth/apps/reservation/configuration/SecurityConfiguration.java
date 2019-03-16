package com.ikth.apps.reservation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.ikth.apps.reservation.auth.JwtConfigurer;
import com.ikth.apps.reservation.auth.SimpleUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan("com.ikth.apps.reservation.auth")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private SimpleUserDetailsService simpleUserDetailsService;
	
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
			/**
			 * form login 사용 안함 
			 * -> form login을 사용하고, Success/Error Handler를 구현해야 할듯 함.
			 * -> form login은 사용 안하고 JS에서 redirect 등등을 구현 하는게 맞을거 같음. REST 니까.. (확정)
			 */
//			.and()
//			.formLogin()
//			.and()
//			.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/");
			;
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
		ap.setUserDetailsService(simpleUserDetailsService);
		
		return ap;
	}
}