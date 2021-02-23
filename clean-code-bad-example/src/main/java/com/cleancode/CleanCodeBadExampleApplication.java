package com.cleancode;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CleanCodeBadExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanCodeBadExampleApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	// TODO: 16. Las clases y variables relacionadas deben seguir un patrón común.
	/**
	 * UserDataService, UserRecordsDAO, UserInfoExporter --> BAD!
	 * UserService, UserDAO, UserExporter --> GOOD
	 */
}
