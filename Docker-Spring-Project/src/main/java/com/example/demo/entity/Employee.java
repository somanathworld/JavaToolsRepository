package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMP")
public class Employee {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer id;
	  
	  private String firstName;
	  
	  private String lastName;
	  
	  private LocalDate dateOfBirth;
	  
	  public Employee() {}
	  
	  public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.dateOfBirth = dateOfBirth;
	  }
	  
	  public Integer getId() {
	    return this.id;
	  }
	  
	  public String getFirstName() {
	    return this.firstName;
	  }

	  public String getLastName() {
	    return this.lastName;
	  }

	  public LocalDate getDateOfBirth() {
	    return this.dateOfBirth;
	  }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	 
	}