package com.szdp.makeitnas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MakeItNAS API Documentation"))
public class MakeItNasApi {

	public static void main(String[] args) {
		SpringApplication.run(MakeItNasApi.class, args);
	}

}
