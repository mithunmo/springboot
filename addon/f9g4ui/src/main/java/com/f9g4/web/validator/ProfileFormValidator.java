package com.f9g4.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.web.forms.DesignerProfileForm;
import com.f9g4.web.forms.ProfileForm;

public class ProfileFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		
		ProfileForm form = (ProfileForm)target;
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required",null, "Invalid input, First Name can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "field.required",null, "Invalid input, Last Name can't be empty." );
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "field.required",null, "Invalid input, Street address 1 can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "field.required",null, "Invalid input, City can't be empty." );
		//check the state only when the country is USA
		if(form.getCountryId()==LookupTypeValueEnum.COUNTRY_US.getTypeId())
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "field.required",null, "Invalid input, State can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "field.required",null, "Invalid input, Zip can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryId", "field.required",null, "Invalid input, Country can't be empty." );
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required",null, "Invalid input, Phone can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cellPhone", "field.required",null, "Invalid input, Cell can't be empty." );
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fax", "field.required",null, "Invalid input, Fax can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "website", "field.required",null, "Invalid input, Website can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "field.required",null, "Invalid input, Company Name can't be empty." );		
	}

}

