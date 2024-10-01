package com.nt.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.nt.dto.EmployeeDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excelView")
public class EmployeeExcelView extends AbstractXlsxView{
	
	private static final String SHEET_NAME = "Employee Details";

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<EmployeeDTO> listDTO = (List<EmployeeDTO>) model.get("listDTO");
		Sheet sheet = workbook.createSheet(SHEET_NAME);
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Employee ID");
		header.createCell(1).setCellValue("Employee Name");
		header.createCell(2).setCellValue("Employee Job");
		header.createCell(3).setCellValue("Employee Salary");		
		header.createCell(4).setCellValue("Dept No.");
		
		int seqNo = 1;
		
		for(EmployeeDTO dto : listDTO){
			Row row = sheet.createRow(seqNo++);
			row.createCell(0).setCellValue(dto.getEmpNo());
			row.createCell(1).setCellValue(dto.geteName());
			row.createCell(2).setCellValue(dto.getJob());
			row.createCell(3).setCellValue(dto.getSalary());		
			row.createCell(4).setCellValue(dto.getDeptNo());
		}
				
	}
	
}
