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
			 * form login 사용 안함 
			 * -> form login을 사용하고, Success/Error Handler를 구현해야 할듯 함(추가로 Rest에 맞도록 변형 필요)
			 * -> 이게 맞을까?? form login은 사용 안하고 JS 단에서 redirect 등등을 구현 하는게 맞을거 같음. REST 니까..
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
