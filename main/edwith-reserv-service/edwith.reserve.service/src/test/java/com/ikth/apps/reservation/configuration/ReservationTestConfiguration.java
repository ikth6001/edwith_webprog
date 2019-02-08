package com.ikth.apps.reservation.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ikth.apps.reservation.controller.ReservationRestController;
import com.ikth.apps.reservation.controller.advice.ControllerCommonAdvice;
import com.ikth.apps.reservation.dao.ReservationDao;
import com.ikth.apps.reservation.service.ReservationSc;

@Configuration
@EnableWebMvc
//@Import({ ServiceLayerConfiguration.class
//		  , DataAccessObjectConfiguration.class })
//@ComponentScan({"com.ikth.apps.reservation.controller"})
public class ReservationTestConfiguration extends WebMvcConfigurerAdapter
{
	@Bean
	public ReservationRestController getRealController() {
		return new ReservationRestController();
	}
	
	@Bean
	public ReservationSc getMockSc() {
		return Mockito.mock(ReservationSc.class);
	}
	
	@Bean
	public ReservationDao getMockDao() {
		return Mockito.mock(ReservationDao.class);
	}
	
	@Bean
	public ControllerCommonAdvice getControllerAdvice() {
		return new ControllerCommonAdvice();
	}
	
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
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
