package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class})
@ComponentScan
public class GraphQlWithSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlWithSpringBootAppApplication.class, args);
	}

}
