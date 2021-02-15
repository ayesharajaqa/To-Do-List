package com.qa.TDLproject.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	

}
