package com.vagner.foodtruckfinder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Food truck finder API", version = "2.0", description = "Food truck finder API"))
@SecurityScheme(name = "foodtruckfinder", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class FoodtruckFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodtruckFinderApplication.class, args);
		System.out.println();
	}

}
