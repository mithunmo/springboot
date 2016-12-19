package com.f9g4.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.f9g4.web.forms.CreatePortfolioForm;

public class CreatePortfolioFormValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		CreatePortfolioForm form = (CreatePortfolioForm) target;
		
		ValidationUtils.rejectIfEmpty(errors, "portfolioName", "field.required",null, "Invalid input, Portfolio Name can't be empty." );
		ValidationUtils.rejectIfEmpty(errors, "portfolioDescription", "field.required",null, "Invalid input, Portfolio Description can't be empty." );
		ValidationUtils.rejectIfEmpty(errors, "division", "field.required",null, "Invalid input, Division can't be empty." );
		ValidationUtils.rejectIfEmpty(errors, "category", "field.required",null, "Invalid input, Category can't be empty." );
		ValidationUtils.rejectIfEmpty(errors, "season", "field.required",null, "Invalid input, Season can't be empty." );
		
		if(form.getCategory()<0)
			errors.reject("category","Invalid input, Category can't be empty.");
		if(form.getDivision()<0)
			errors.reject("division","Invalid input, Division can't be empty.");
		//ValidationUtils.rejectIfEmpty(errors, "expirationDate", "field.required",null, "Invalid input, Expiration Date can't be empty." );
		
	}

}
