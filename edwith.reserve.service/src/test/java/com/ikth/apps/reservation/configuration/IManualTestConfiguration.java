package com.ikth.apps.reservation.configuration;

import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;

import com.ikth.apps.reservation.controller.advice.ControllerCommonAdvice;

public interface IManualTestConfiguration 
{
	ApplicationConfiguration applicationConfiguration= new ApplicationConfiguration();
	
	default Object getControllerAdvice() {
		return new ControllerCommonAdvice();
	}

	default Validator getValidator() {
		return new LocalValidatorFactoryBean();
	}
	
	default ViewResolver getViewResolver() {
		return applicationConfiguration.getInternalResourceViewResolver();
	}
}
