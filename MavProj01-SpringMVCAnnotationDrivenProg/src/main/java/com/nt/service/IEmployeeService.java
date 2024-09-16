package com.nt.service;

import java.io.IOException;
import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeService {

	public String registerEmployee(EmployeeDTO dto) throws IOException;
	public List<EmployeeDTO> getEmployees();
	public EmployeeDTO showEmployeeById(int empNo);
	public String modifyEmployeeById(EmployeeDTO dto);
	public String removeEmployeeById(int empId);
}
