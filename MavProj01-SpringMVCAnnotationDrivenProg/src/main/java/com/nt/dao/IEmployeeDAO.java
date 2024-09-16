package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {

	public int saveEmployee(EmployeeBO bo);
	public List<EmployeeBO> getAllEmployees();
	public EmployeeBO getEmployeeById(int empNo);
	public int updateEmployeeById(EmployeeBO bo);
	public int deleteEmployeeById(int empId);
}
