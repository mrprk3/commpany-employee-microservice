package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Company;
import com.company.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public Company findById(int companyId) {
		return companyRepository.findById(companyId);
	}

}
