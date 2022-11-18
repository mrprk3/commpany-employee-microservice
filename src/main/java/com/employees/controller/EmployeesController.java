package com.employees.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employees.ConfigUtility;
import com.employees.entity.CompanyData;
import com.employees.entity.Employees;
import com.employees.service.EmployeesService;

@RestController
public class EmployeesController {
	@Autowired
	EmployeesService employeesService;
	@Autowired
	ConfigUtility config;

	@PostMapping("/employee/save")
	public Employees saveEmp(@RequestBody Employees employees) {
		return employeesService.save(employees);
	}

	@GetMapping("/employee/{employeeId}")
	public Employees getEmp(@PathVariable int employeeId) {

		String url = config.getProperty("company.service.url") + "/company/1";

		RestTemplate restTemplates = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<CompanyData> response = restTemplates.exchange(url, HttpMethod.GET, entity, CompanyData.class);

		System.out.println("==================================================" + response.getBody().getCompanyId()
				+ " " + response.getBody().getCompanyName());

		return employeesService.findByemployeeId(employeeId);
	}

}
