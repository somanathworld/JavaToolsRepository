package com.nt.model;

public class Employee {

	private String fname;
	private String lname;
	private String Job;
	private Double salary;
	
	public Employee() {}
	public Employee(String fname, String lname, String job, Double salaryl) {
		super();
		this.fname = fname;
		this.lname = lname;
		Job = job;
		this.salary = salaryl;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salaryl) {
		this.salary = salaryl;
	}
	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", Job=" + Job + ", salaryl=" + salary + "]";
	}
	
}
