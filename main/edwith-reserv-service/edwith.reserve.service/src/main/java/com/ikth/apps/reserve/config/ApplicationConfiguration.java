package com.ikth.apps.reserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@Import(DataAccessObjectConfiguration.class)
@ComponentScan({"com.ikth.apps.reserve"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("img/**").addResourceLocations("WEB-INF/views/img/");
		registry.addResourceHandler("js/**").addResourceLocations("WEB-INF/views/js/");
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() 
	{
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
}
