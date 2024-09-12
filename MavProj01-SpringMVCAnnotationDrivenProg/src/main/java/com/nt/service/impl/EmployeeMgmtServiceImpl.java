package com.nt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeService;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public String registerEmployee() {
		return null;
	}

	@Override
	public List<EmployeeDTO> getEmployees() {
		
		List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
		List<EmployeeBO> listBO = dao.getAllEmployees();

		listBO.forEach(e->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(e, dto);
			dto.setSerialNo(listDTO.size() + 1);
			dto.setGrossSalary(e.getSalary() * 1.3F);
			dto.setNetSalary(dto.getGrossSalary() * 1.1F);
			dto.setSalary(Math.round(dto.getNetSalary()));
			listDTO.add(dto);			
		});
		
		return listDTO;
		
	}
}
