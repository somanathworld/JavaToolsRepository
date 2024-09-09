package com.example.demo.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeMgmtService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService service;
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee emp) {
		return service.registerEmployee(emp); 
	}
	
	@GetMapping("/showall")
	public HttpEntity<?> getAllEmployee() {
		return new HttpEntity<>(service.getEmployee());
	}
}
