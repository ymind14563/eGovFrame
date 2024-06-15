package com.easycompany.cmm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.easycompany.service.Department;

public class DepartmentValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Department.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		Department department = (Department)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deptname", "required");
		
		if(department.getDescription()==null || department.getDescription().length()<10){
			errors.rejectValue("description", "lengthsize", new Object[]{10}, "description's length must be larger than 10.");
		}		
	}
	
	
	public boolean isEmptyOrWhitespace(String value){
		if(value==null || value.trim().length() == 0){
			return true;
		}else{
			return false;
		}
	}
}
