package com.ikth.apps.reservation.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@Import({ ServiceLayerConfiguration.class
		  , DataAccessObjectConfiguration.class
		  , SwaggerConfiguration.class })
@ComponentScan({"com.ikth.apps.reservation.controller"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter
{
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() 
	{
	    return new MethodValidationPostProcessor();
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource r= new ReloadableResourceBundleMessageSource();
		r.setBasename("classpath:messages/message");
		r.setDefaultEncoding("utf-8");
		r.setCacheSeconds(60);
		
		return r;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver()
	{
		SessionLocaleResolver r= new SessionLocaleResolver();
		r.setDefaultLocale(new Locale("ko"));
		return r;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		LocaleChangeInterceptor r= new LocaleChangeInterceptor();
		r.setParamName("lang");
		
		return r;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	};
	
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
