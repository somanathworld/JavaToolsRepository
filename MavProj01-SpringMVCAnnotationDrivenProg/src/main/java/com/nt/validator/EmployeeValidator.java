package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.vo.EmployeeVO;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(EmployeeVO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeeVO vo = null;
		vo = (EmployeeVO)target;
		
		if(vo.geteName() == null || vo.geteName().isBlank()) {
			errors.rejectValue("eName", "emp.name.required");
		}		
		if(vo.geteName().length()<5) {
			errors.rejectValue("eName", "emp.name.length");
		}

		if(vo.getJob() == null || vo.getJob().isBlank()) {
			errors.rejectValue("job", "emp.job.required");
		}		
		if(vo.getJob().length()<2) {
			errors.rejectValue("job", "emp.job.length");
		}

		if(vo.getSalary() <= 0.0) {
			errors.rejectValue("salary", "emp.sal.required");
		}		
		if(vo.getSalary()<1000 || vo.getSalary()>20000) {
			errors.rejectValue("salary", "emp.sal.range");
		}
		
	}

}
