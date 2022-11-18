package com.employees.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employees {
	@Id
	private int employeeId;

	private String employeeName;

}
