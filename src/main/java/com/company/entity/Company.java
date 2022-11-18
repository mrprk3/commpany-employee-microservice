package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Company {
	@Id
	private int companyId;

	private String companyName;

}
