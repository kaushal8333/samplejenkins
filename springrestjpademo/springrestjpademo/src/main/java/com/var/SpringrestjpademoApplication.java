package com.var;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringrestjpademoApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringrestjpademoApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
	return new RestTemplate();
	}
	

}
/*
{
	"id":101,
	"name":"box"
	
}

*/

// application.properties

// springdoc.api-docs.path=/api-docs

//URL for swagger 
// http://localhost:8082/api-docs
// http://localhost:8082/swagger-ui/index.html