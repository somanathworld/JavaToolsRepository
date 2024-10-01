package com.nt.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.EmployeeDTO;
import com.nt.exception.EmployeeNotFound;
import com.nt.service.IEmployeeService;
import com.nt.validator.EmployeeValidator;
import com.nt.vo.EmployeeVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@Autowired
	private EmployeeValidator validator;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/register_emp")
	public String showEmployeeRegisterPage(@ModelAttribute("emp") EmployeeVO emp) {
		return "register_employee";
	}

	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				text = text.isBlank() ? LocalDate.now().toString() : text;
				this.setValue(LocalDate.now());
			}
		});
	}

	@PostMapping("/register_emp")
	public String processEmployeeRegisterPage(@ModelAttribute("emp") EmployeeVO emp, RedirectAttributes attrs,
			BindingResult errors) throws IOException {

		if (validator.supports(emp.getClass()))
			validator.validate(emp, errors);

		if (emp.getJob().equalsIgnoreCase("Politician") || emp.getJob().equalsIgnoreCase("Actor"))
			errors.rejectValue("job", "blocked.jobs");

		if (errors.hasErrors())
			return "register_employee";

		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(emp, dto);
		String result = service.registerEmployee(dto);
		attrs.addFlashAttribute(result, "result");
		return "redirect:showAllEmployees";

	}

	@ModelAttribute("genderList")
	public List<String> getAllGenders() {
		return List.of("M", "F", "N/A");
	}

	@ModelAttribute("hobbiesList")
	public List<String> getAllHobbies() {
		return List.of("Playing", "Sleeping");
	}

	@ModelAttribute("qualificationList")
	public List<String> getAllQualification() {
		return List.of("10", "+2", "B.sc");
	}

	@GetMapping("/showAllEmployees")
	public String getAllEmployees(Map<String, List<EmployeeDTO>> map) {
		List<EmployeeDTO> listDTO = service.getEmployees();
		map.put("listDTO", listDTO);
		return "all_employees";
	}

	@GetMapping("/employee_pdf_report")
	public String showPDFReport(Map<String, Object> map) {
		List<EmployeeDTO> listDTO = service.getEmployees();
		map.put("listDTO", listDTO);
		return "pdfView";
	}

	@GetMapping("/employee_excel_report")
	public String showExcelReport(Map<String, Object> map) {
		List<EmployeeDTO> listDTO = service.getEmployees();
		map.put("listDTO", listDTO);
		return "excelView";
	}

	@GetMapping("/udpate_emp")
	public String showUpdateEmployeeForm(@ModelAttribute("emp") EmployeeDTO emp, @RequestParam("no") int no) {
		EmployeeDTO dto = service.showEmployeeById(no);
		BeanUtils.copyProperties(dto, emp);
		return "update_employee_form";
	}

	@PostMapping("/udpate_emp")
	public String processUpdateEmployeeForm(@ModelAttribute("emp") EmployeeDTO emp, RedirectAttributes attr) {
		String result = service.modifyEmployeeById(emp);
		attr.addFlashAttribute("result", result);
		return "redirect:showAllEmployees";
	}

	@GetMapping("/delete_emp")
	public String processDeleteEmployee(@RequestParam("no") int no, RedirectAttributes attr) {
		String result = service.removeEmployeeById(no);
		attr.addFlashAttribute("result", result);
		return "redirect:showAllEmployees";

	}

	@GetMapping("/error")
	public String showErrorPage(Map<String, Object> map, HttpServletRequest req) {

		String errorMsg = null;
		LocalDateTime ldt = null;

		int httpErrorCode = (int) req.getAttribute("jakarta.servlet.error.status_code");
		ldt = LocalDateTime.now();

		switch (httpErrorCode) {
			case 400: {
				errorMsg = "Http Error Code: 400. Bad Request";
				break;
			}
			case 401: {
				errorMsg = "Http Error Code: 401. Unauthorized";
				break;
			}
			case 404: {
				errorMsg = "Http Error Code: 404. Resource not found";
				break;
			}
			case 500: {
				errorMsg = "Http Error Code: 500. Internal Server Error";
				break;
			}
			default: {
//				Enumeration<String> en =  req.getAttributeNames();
//				while(en.hasMoreElements()) {
//					String name = en.nextElement();
//					System.out.println(name +" "+req.getAttribute(name));
//				}
				
				Exception excp = (Exception) req.getAttribute("org.springframework.web.servlet.DispatcherServlet.EXCEPTION");
				String error = (String)req.getAttribute("jakarta.servlet.error.message");
				errorMsg = excp == null ? error : "Error generated while processing " + excp.getMessage();
				break;
			}
		}
		map.put("errorMsg", errorMsg);
		map.put("errCode", httpErrorCode);
		map.put("ldt", ldt);
		return null;
	}

	@GetMapping("500error")
	public String error() throws EmployeeNotFound{
		throw new EmployeeNotFound("Employee not found...");
	}

}
