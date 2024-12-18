package com.nt.bo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeBO {

	private int empNo;
	private String eName;
	private String job;
	private double salary;
	private int deptNo;
	private String addrs;
	private long mobNo;
	private String gender;
	private String hobbies;
	private String qualification;
	private LocalDate dob;
	private LocalDate doj;
	private String resumePath;
	private String photoPath;
	
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
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	@Override
	public String toString() {
		return "EmployeeBO [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", salary=" + salary + ", deptNo="
				+ deptNo + ", addrs=" + addrs + ", mobNo=" + mobNo + ", gender=" + gender + ", hobbies="
				+ hobbies + ", qualification=" + qualification + ", dob=" + dob + ", doj=" + doj
				+ ", resumePath=" + resumePath + ", photoPath=" + photoPath + "]";
	}

}
