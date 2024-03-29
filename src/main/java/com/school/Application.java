package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EntityScan(basePackages= {"com.school.domain"})
@EnableJpaRepositories(basePackages= {"com.school.repos"})
@ComponentScan(basePackages= {"com.school.mvc","com.school.rest","com.school.service"})
public class Application 
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

}
