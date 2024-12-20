package com.example.projection;

import com.example.projection.repository.EmployeeProjection;
import com.example.projection.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProjectionApplication.class, args);
	}

}
