package com.nt.bo;

public class EmployeeBO {

	private int empNo;
	private String eName;
	private String job;
	private double salary;
	private int deptNo;
	
	public EmployeeBO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "EmployeeBO [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", salary=" + salary + ", deptNo="
				+ deptNo + "]";
	}
	
	
}
