package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	Company findById(int companyId);

}
