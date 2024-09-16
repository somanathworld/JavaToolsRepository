package com.nt.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
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
	public String registerEmployee(EmployeeDTO dto) throws IOException {

		String folderLocation = null, resumeName = null, photoName = null;
		InputStream resumeIS = null, photoIS = null;
		OutputStream resumeOS = null, photoOS = null;
		File file = null;
		
		folderLocation = "/files";
		file = new File(folderLocation);
		if(!file.exists()) {
			file.mkdir();
		}
		
		//get resume and photo file name
		resumeName = dto.getResume().getOriginalFilename();
		photoName = dto.getPhoto().getOriginalFilename();
		
		//get resume and photo IS
		resumeIS = dto.getResume().getInputStream();
		photoIS = dto.getPhoto().getInputStream();
		
		//create file output stream for photo resume
		resumeOS = new FileOutputStream(file +"/"+ resumeName);
		photoOS = new FileOutputStream(file +"/"+ photoName);

		IOUtils.copy(resumeIS, resumeOS);
		IOUtils.copy(photoIS, photoOS);

		resumeIS.close();
		photoIS.close();
		resumeOS.close();
		photoOS.close();
		
		EmployeeBO bo = new EmployeeBO();
		
		BeanUtils.copyProperties(dto, bo);
		bo.setHobbies(Arrays.toString(dto.getHobbies()));
		bo.setQualification(Arrays.toString(dto.getQualification().toArray(String[]::new)));
		bo.setResumePath(file +"/"+ resumeName);
		bo.setPhotoPath(file +"/"+ resumeName);
		
		int result = dao.saveEmployee(bo);
		return result != 0 ? "Employee registerd successfully.": "Employee registration failed.";
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
	
	@Override
	public EmployeeDTO showEmployeeById(int empNo) {
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeBO bo = dao.getEmployeeById(empNo);

		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
	@Override
	public String modifyEmployeeById(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		
		int count = dao.updateEmployeeById(bo);
		return count != 0 ? "Employee "+dto.getEmpNo()+" data updated successfully.":"Employee "+dto.getEmpNo()+" data updation failed.";
	}
	
	@Override
	public String removeEmployeeById(int empId) {
		int count = dao.deleteEmployeeById(empId);
		return count != 0 ? "Employee "+empId+" deleted successfully." : "Employee "+empId+" deletion failed.";
	}
}
