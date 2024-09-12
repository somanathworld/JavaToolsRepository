package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;

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
	
	@GetMapping("/showAllEmployees")
	public String getAllEmployees(Map<String, List<EmployeeDTO>> map) {
	
		List<EmployeeDTO> listDTO = service.getEmployees();
		map.put("listDTO", listDTO);
		return "all_employees";
	}
}
