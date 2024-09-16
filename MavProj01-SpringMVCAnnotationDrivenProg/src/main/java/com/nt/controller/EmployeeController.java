package com.nt.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeService;
import com.nt.vo.EmployeeVO;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;

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
				this.setValue(LocalDate.parse(text));
			}
		});
	}

	@PostMapping("/register_emp")
	public String processEmployeeRegisterPage(@ModelAttribute("emp") EmployeeVO emp, RedirectAttributes attrs) throws IOException {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(emp, dto);
		String result = service.registerEmployee(dto);
		attrs.addFlashAttribute(result, "result");
		return "redirect:showAllEmployees";		
		
	}
		
	@ModelAttribute("genderList")
	public List<String> getAllGenders(){
		return List.of("M","F", "N/A");
	}

	@ModelAttribute("hobbiesList")
	public List<String> getAllHobbies(){
		return List.of("Playing", "Sleeping");
	}
		
	@ModelAttribute("qualificationList")
	public List<String> getAllQualification(){
		return List.of("10", "+2", "B.sc");
	}

	@GetMapping("/showAllEmployees")
	public String getAllEmployees(Map<String, List<EmployeeDTO>> map) {	
		List<EmployeeDTO> listDTO = service.getEmployees();
		map.put("listDTO", listDTO);
		return "all_employees";
	}
	

	@GetMapping("/udpate_emp")
	public String showUpdateEmployeeForm(@ModelAttribute("emp") EmployeeDTO emp, @RequestParam("no") int no) {
		EmployeeDTO dto = service.showEmployeeById(no);
		BeanUtils.copyProperties(dto,emp);
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
}

