package com.example.demo.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeMgmtService;

@Component
public class RunnerClass implements CommandLineRunner{

	@Autowired
	private IEmployeeMgmtService empService;
		
	@Override
	public void run(String... args) throws Exception {
//		empService.registerEmployee(new Employee("Rahul", "Dravid", LocalDate.of(1979, 3, 3)));			
//		empService.registerEmployee(new Employee("Ravi", "Sastri", LocalDate.of(1959, 4, 13)));			
//		empService.registerEmployee(new Employee("Gautam", "Gambhir", LocalDate.of(1983, 7, 23)));		
		
		empService.getEmployee().forEach(System.out::println);
	}
}
