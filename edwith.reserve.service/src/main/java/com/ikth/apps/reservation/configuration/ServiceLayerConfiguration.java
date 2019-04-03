package com.ikth.apps.reservation.configuration;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan( basePackages= {"com.ikth.apps.reservation.service"} )
//				, excludeFilters= { @ComponentScan.Filter(type=FilterType.ANNOTATION, value=Configuration.class) })
public class ServiceLayerConfiguration {

}
