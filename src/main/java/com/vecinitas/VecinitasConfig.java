package com.vecinitas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class VecinitasConfig implements WebMvcConfigurer{

	public VecinitasConfig() {}
    private final Logger log = LoggerFactory.getLogger(getClass()); 
	

	
	
}
