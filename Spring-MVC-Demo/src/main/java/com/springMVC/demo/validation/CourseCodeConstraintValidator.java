package com.springMVC.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	// private String coursePrefix; for single string validation.
	private String[] coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {

		coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) { // value conatin data enter by user in
																				// html form

		boolean result = false;

//		if (value != null) {
//			result = value.startsWith(coursePrefix);  for single string validation
//		} else {
//			result = true;
//		}

		if (value != null) {
			for (String str : coursePrefix) {
				result = value.startsWith(str);

				if (result) {
					break;
				}
			}
		} else {
			result = true;
		}

		return result;
	}

}
