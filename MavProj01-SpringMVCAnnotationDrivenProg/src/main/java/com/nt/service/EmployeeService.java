package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {

	public String registerEmployee();
	public List<EmployeeDTO> getEmployee();
}
