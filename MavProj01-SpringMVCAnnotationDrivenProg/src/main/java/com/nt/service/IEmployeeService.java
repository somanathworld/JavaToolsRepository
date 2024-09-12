package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeService {

	public String registerEmployee();
	public List<EmployeeDTO> getEmployees();
}
