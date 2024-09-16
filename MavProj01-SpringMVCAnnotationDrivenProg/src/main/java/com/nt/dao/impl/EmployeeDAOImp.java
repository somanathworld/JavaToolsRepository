package com.nt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;

@Repository
public class EmployeeDAOImp implements IEmployeeDAO {

	private static final String INSERT_EMPLOYEE = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, ADDRS, MOBNO, GENDER, HOBBIES, QUALIFICATION, DOB, RESUMEPATH, PHOTOPATH) VALUES(NEXTVAL('EMPNO_SEQ'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_EMPLOYEES = "SELECT EMPNO,ENAME, SAL, JOB , DEPTNO FROM EMP";
	private static final String GET_EMPLOYEE_BY_ID = "SELECT EMPNO,ENAME, SAL, JOB , DEPTNO FROM EMP WHERE EMPNO = ?";
	private static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE EMP SET ENAME=?, SAL=?, JOB=?,DEPTNO=? WHERE EMPNO=?";
	private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM EMP WHERE EMPNO = ?";

	@Autowired
	private JdbcTemplate jTemp;

	@Override
	public int saveEmployee(EmployeeBO bo) {
		int count = jTemp.update(INSERT_EMPLOYEE, bo.geteName(), bo.getJob(), 99999, bo.getDoj(), bo.getSalary(), null,
				bo.getDeptNo(), bo.getAddrs(), bo.getMobNo(), bo.getGender(), bo.getHobbies(), bo.getQualification(),
				bo.getDob(), bo.getResumePath(), bo.getPhotoPath());
		return count;
	}

	@Override
	public List<EmployeeBO> getAllEmployees() {

		List<EmployeeBO> boList = jTemp.query(GET_ALL_EMPLOYEES, rs -> {
			List<EmployeeBO> listBO = new ArrayList<>();
			while (rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.seteName(rs.getString(2));
				bo.setSalary(rs.getDouble(3));
				bo.setJob(rs.getString(4));
				bo.setDeptNo(rs.getInt(5));
//				System.out.println(bo);
				listBO.add(bo);
			}
			return listBO;
		});
		return boList;
	}

	@Override
	public EmployeeBO getEmployeeById(int empNo) {
		EmployeeBO empBO = jTemp.queryForObject(GET_EMPLOYEE_BY_ID, (rs, rowNum) -> {
			EmployeeBO bo = new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.seteName(rs.getString(2));
			bo.setSalary(rs.getDouble(3));
			bo.setJob(rs.getString(4));
			bo.setDeptNo(rs.getInt(5));
			return bo;
		}, empNo);
		return empBO;
	}

	@Override
	public int updateEmployeeById(EmployeeBO bo) {
		int count = jTemp.update(UPDATE_EMPLOYEE_BY_ID, bo.geteName(), bo.getSalary(), bo.getJob(), bo.getDeptNo(),
				bo.getEmpNo());
		return count;
	}

	@Override
	public int deleteEmployeeById(int empId) {
		int count = jTemp.update(DELETE_EMPLOYEE_BY_ID, empId);
		return count;
	}
}
