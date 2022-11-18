package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Company;
import com.company.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@PostMapping("/company/save")
	public Company saveComp(@RequestBody Company company) {
		return companyService.save(company);
	}
	
	@GetMapping("/company/{companyId}")
	public Company getCompany(@PathVariable int companyId) {
		return companyService.findById(companyId);
		
	}
}
