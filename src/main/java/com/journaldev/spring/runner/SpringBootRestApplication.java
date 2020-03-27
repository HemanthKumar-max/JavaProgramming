package com.journaldev.spring.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;





@SpringBootApplication
@ComponentScan("com.journaldev.spring.dao")
public class SpringBootRestApplication  extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootRestApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

}
