package com.xilou.open.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xilou.open.domain.Student;

public class StudentValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentId", "student.studentId.null");
		ValidationUtils.rejectIfEmpty(errors, "name", "student.studentId.null");

	}

}
