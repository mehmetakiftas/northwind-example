package com.example.northwindexample;

import com.example.northwindexample.business.responses.MostExpensiveProductsPerCategoriesResponse;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NorthwindExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindExampleApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}


}
