package com.springMVC.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseNameConstraintValidator implements ConstraintValidator<CourseName, String> {

	private String preFix;

	@Override
	public void initialize(CourseName constraintAnnotation) {

		preFix = constraintAnnotation.value();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		boolean rs;
		if (value != null) {
			rs = value.startsWith(preFix);
		} else {
			rs = true;
		}

		return rs;

	}

}
