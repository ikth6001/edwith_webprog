package com.ikth.apps.reservation.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan( basePackages= {"com.ikth.apps.reservation"}
				, excludeFilters= { @ComponentScan.Filter(type=FilterType.ANNOTATION, value=Configuration.class) })
public class ServiceLayerConfiguration {

}
