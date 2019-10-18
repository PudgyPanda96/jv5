package com.penrose.Jv5Core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Jv5CoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Jv5CoreApplication.class, args);
	}

}
