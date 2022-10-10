package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
	// kho luu tru JPA va giao dien kho luu tru
	//co tat ca cac crud tuong tac dat o day
}
