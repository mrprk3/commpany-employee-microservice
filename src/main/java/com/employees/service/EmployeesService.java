package com.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.entity.Employees;
import com.employees.repository.EmployeeRepository;

@Service
public class EmployeesService {
	@Autowired
	EmployeeRepository employeeRepository;

	public Employees save(Employees employees) {
		return employeeRepository.save(employees);
	}

	public Employees findByemployeeId(int employeeId) {
		return employeeRepository.findById(employeeId);
	}

}
