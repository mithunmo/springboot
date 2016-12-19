package com.f9g4.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.f9g4.web.forms.SeqAndPasswordForm;


public class SeqAndPasswordFormValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		SeqAndPasswordForm form = (SeqAndPasswordForm) target;
		
		if(form.getSetupSeq())
		{
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityQ1Value", "field.required",null, "Invalid input, Security Question 1 can't be empty." );
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityQ2Value", "field.required",null, "Invalid input, Security Question 2 can't be empty." );
		}
		if(form.getSetupPwd())
		{
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resetPassword", "field.required",null, "Invalid input, password can't be empty." );
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "field.required",null, "Invalid input, ConfirmPassword can't be empty." );
			if(!form.getResetPassword().equals(form.getConfirmPassword()))
			{
				errors.rejectValue("resetPassword", "field.required",null, "Invalid input, Password and Confirm Password didn't match." );
			}
		}
	}

}
