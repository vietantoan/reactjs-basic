package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class ProjectSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringBootApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setLastName("Viet");
		employee.setEmailId("viet.antoan44");
		employee.setFirstName("An");
		employeeRepository.save(employee);
	}

}
