package com.nt.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.EmployeeDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdfView")
public class EmployeePDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<EmployeeDTO> listDTO = (List<EmployeeDTO>) model.get("listDTO");
		
		Paragraph para = null;
		para = new Paragraph("Student Details Report", new
				Font(Font.HELVETICA, 24, Font.BOLDITALIC, Color.CYAN));
		
		document.add(para);
		
		Table tab = new Table(5);
		tab.addCell("Employee ID");
		tab.addCell("Employee Name");
		tab.addCell("Employee Job");
		tab.addCell("Employee Salary");
		tab.addCell("Dept No.");
		
		for(EmployeeDTO dto : listDTO) {
			tab.addCell(String.valueOf(dto.getEmpNo()));
			tab.addCell(dto.geteName());
			tab.addCell(dto.getJob());
			tab.addCell(String.valueOf(dto.getSalary()));
			tab.addCell(String.valueOf(dto.getDeptNo()));
		}
		
		document.add(tab);
	}

}
