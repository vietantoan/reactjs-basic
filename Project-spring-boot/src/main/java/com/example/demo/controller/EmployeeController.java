package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping 
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	
	// xay dung CREATE employees API
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// tao get ID employees bang REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Khong ton nhan vien co id:" + id));
		return ResponseEntity.ok(employee);
	}
	
	//Create update nhan vien to REST APT
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody  Employee employeeDetails){
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Khong co nhan vien nao co id: "+id));
		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setEmailId(employeeDetails.getEmailId());
		
		employeeRepository.save(updateEmployee);
		
		return ResponseEntity.ok(updateEmployee);
		
	}	
	// xoa nhancien
		@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
		
		Employee employees = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Khong co ID ton tai: "+ id));
		
		employeeRepository.delete(employees);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
		
	}
	
	
	
	
	
	
