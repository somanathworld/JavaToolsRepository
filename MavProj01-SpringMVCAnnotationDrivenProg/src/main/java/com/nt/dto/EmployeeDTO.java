package com.nt.dto;

public class EmployeeDTO {

	private int serialNo;
	private int empNo;
	private String eName;
	private String job;
	private float salary;
	private int deptNo;
	private double grossSalary;
	private double netSalary;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [serialNo=" + serialNo + ", empNo=" + empNo + ", eName=" + eName + ", job=" + job
				+ ", salary=" + salary + ", deptNo=" + deptNo + ", grossSalary=" + grossSalary + ", netSalary="
				+ netSalary + "]";
	}
	

}
