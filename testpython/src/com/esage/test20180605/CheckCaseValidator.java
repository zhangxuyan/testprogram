package com.esage.test20180605;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
 * 约束条件CheckCase的验证器
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
	private CaseMode caseMode;

	public void initialize(CheckCase constraintAnnotation) {
		this.caseMode = constraintAnnotation.value();
	}

	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

		if (object == null)
			return true;

		if (caseMode == CaseMode.UPPER)
			return object.equals(object.toUpperCase());
		else
			return object.equals(object.toLowerCase());
	}

}
