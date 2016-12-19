package com.f9g4.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.apache.commons.lang.StringUtils;

import com.f9g4.web.forms.DesignerProfileForm;

public class DesignerProfileFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		try
		{
		DesignerProfileForm form = (DesignerProfileForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required",null, "Invalid input, First Name can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "field.required",null, "Invalid input, Last Name can't be empty." );
		
		/*
		if(form.getEducationId() == -2 && StringUtils.isBlank(form.getOtherEducation()))
			errors.rejectValue("otherExpertise", "field.required", "Please enter your education detail.");
		
		if(form.getSpecialtyId() == -2 && StringUtils.isBlank(form.getOtherSpecialty()))
			errors.rejectValue("otherExpertise", "field.required", "Please enter your area of specialty detail.");
		
		if(form.getExpertiseId() == -2 && StringUtils.isBlank(form.getOtherExpertise()))
			errors.rejectValue("otherExpertise", "field.required", "Please enter your area of expertise field.");
		*/
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "field.required",null, "Invalid input, Street address 1 can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "field.required",null, "Invalid input, City can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "field.required",null, "Invalid input, State can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "field.required",null, "Invalid input, Zip can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryId", "field.required",null, "Invalid input, Country can't be empty." );
	
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required",null, "Invalid input, Phone can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cellPhone", "field.required",null, "Invalid input, Cell can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fax", "field.required",null, "Invalid input, Fax can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "website", "field.required",null, "Invalid input, Website can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "field.required",null, "Invalid input, Company Name can't be empty." );
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "languageId", "field.required",null, "Invalid input, Language can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skillId", "field.required",null, "Invalid input, Skills can't be empty." );
		
		/*if(form.getLanguagesId().length<1)
			errors.reject("languageId","Invalid input, Languages can't be empty.");
		if(form.getSkillsId().length<1)
			errors.reject("skillId","Invalid input, Skills can't be empty.");*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

