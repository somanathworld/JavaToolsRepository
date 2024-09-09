package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface IEmployeeMgmtService {

	public String registerEmployee(Employee emp);
	public List<Employee> getEmployee();
}
