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

	private static final String GET_ALL_EMPLOYEES = "SELECT EMPNO,ENAME, SAL, JOB , DEPTNO FROM EMP";

	@Autowired
	private JdbcTemplate jTemp;

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
}
