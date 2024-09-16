package com.nt.vo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeVO {
	
	private int empNo;
	private String eName;
	private String job;
	private double salary;
	private int deptNo;
	private String addrs;
	private long mobNo;
	private String gender;
	private String[] hobbies;
	private List<String> qualification;
	private LocalDate dob;
	private LocalDate doj;
	private MultipartFile resume;
	private MultipartFile photo;
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public List<String> getQualification() {
		return qualification;
	}
	public void setQualification(List<String> qualification) {
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
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "EmployeeVO [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", salary=" + salary + ", deptNo="
				+ deptNo + ", addrs=" + addrs + ", mobNo=" + mobNo + ", gender=" + gender + ", hobbies="
				+ Arrays.toString(hobbies) + ", qualification=" + qualification + ", dob=" + dob + ", doj=" + doj
				+ ", resume=" + resume + ", photo=" + photo + "]";
	}

}
