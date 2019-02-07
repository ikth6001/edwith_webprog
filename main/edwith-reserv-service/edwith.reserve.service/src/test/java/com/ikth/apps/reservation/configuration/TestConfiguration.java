package com.ikth.apps.reservation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@Import({ ServiceLayerConfiguration.class
		  , DataAccessObjectConfiguration.class })
@ComponentScan({"com.ikth.apps.reservation.controller"})
public class TestConfiguration extends WebMvcConfigurerAdapter
{
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() 
	{
	    return new MethodValidationPostProcessor();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("img/**").addResourceLocations("WEB-INF/views/img/");
		registry.addResourceHandler("js/**").addResourceLocations("WEB-INF/views/js/");
		
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() 
	{
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
}
