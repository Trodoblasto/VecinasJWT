package com.vecinitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {
        "com.vecinitas",
        "com.vecinitas.dao",
        "com.vecinitas.dao.security",
        "com.vecinitas.controller",
        "com.vecinitas.model",
        "com.vecinitas.utils",
        "com.vecinitas.security",
        "com.vecinitas.entities.security"})
public class VecinasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VecinasApplication.class, args);
	}

}
