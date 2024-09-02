package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;

@Controller
public class EmployeeController {
	

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showEmployeeRegisterPage(Map<String, Object> map) {
		Employee emp = new Employee();
		emp.setFname("SAI");
		map.put("empFrm", emp);
		return "register_employee";		
	}
	
	
	@PostMapping("/register")
	public String processEmployeeRegisterPage(Employee emp) {
		System.out.println(emp);
		return "home";
	}
	
	
}
