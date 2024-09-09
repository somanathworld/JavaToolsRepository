package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.IEmployeeMgmtService;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private EmployeeRepo empRepo;
	
	
	@Override
	public String registerEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp).getId()+"Registered successfully.";
	}
	
	@Override
	public List<Employee> getEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		empRepo.findAll().forEach(list::add);
		return list;
	}
}
