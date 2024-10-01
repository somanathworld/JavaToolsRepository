package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class EmployeeNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public EmployeeNotFound() {
		super();
	}
	
	public EmployeeNotFound(String errMsg) {
		super(errMsg);
	}
		
}
