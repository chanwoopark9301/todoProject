package com.todoApp.ToDo_PPOMODORO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ToDoPpomodoroApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ToDoPpomodoroApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { // (2)
		return builder.sources(ToDoPpomodoroApplication.class);
	}
}
