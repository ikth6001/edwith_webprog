package com.ikth.apps.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.ikth.apps.reservation.configuration.ApplicationConfiguration;
import com.ikth.apps.reservation.configuration.SecurityConfiguration;

@SpringBootApplication
@Import({ApplicationConfiguration.class, SecurityConfiguration.class})
public class ApplicationBoot 
{
	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "DEVELOP");
		SpringApplication.run(ApplicationBoot.class, args);
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
	    return container -> container.setContextPath("/edwith.reserve.service");
	}

}
