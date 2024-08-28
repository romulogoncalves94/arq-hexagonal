package com.api.arq_hexagonal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Arq Hexagonal", version = "1.0", description = "Arq Hexagonal API"))
public class ArqHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqHexagonalApplication.class, args);
	}

}
