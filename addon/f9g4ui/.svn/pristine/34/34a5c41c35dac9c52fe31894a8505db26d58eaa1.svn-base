package com.f9g4.web.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.f9g4.businessobjects.services.CheckUsernameAvailabilityResponse;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.forms.RegistrationForm;

public class RegistrationFormValidator implements Validator {
	
	RegistrationServiceSDK registrationServiceSDK;

	public boolean supports(Class<?> clazz) {
		return RegistrationForm.class.isAssignableFrom(clazz);
	}
	
	public void SetRegistrationService(RegistrationServiceSDK registrationServiceSDK)
	{
		this.registrationServiceSDK =  registrationServiceSDK;
	}

	public void validate(Object target, Errors errors) {
		try
		{
		RegistrationForm registrationForm = (RegistrationForm) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required",null, "Invalid input, E-mail ID can't be empty." );
		F9g4ValidatoinUtils.rejectIfNotEmail(errors, "userName", "field.email", null, "Invalid input, username has to be a valid email." );
		//using registation service s
		CheckUsernameAvailabilityResponse response = registrationServiceSDK.checkUserNameAvailability(registrationForm.getUserName());
		if(!response.isIsAvailable())
			errors.rejectValue("userName", "filed.alreadyexists", null, "Username already exists. Please choose different one.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required",null, "Invalid input, password can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "field.required",null, "Invalid input, ConfirmPassword can't be empty." );
		
		if(null != registrationForm.getPassword() && !registrationForm.getPassword().equals(registrationForm.getConfirmPassword())){
			errors.rejectValue("password", "field.required",null, "Invalid input, Password and  Confirm Password didn't match." );
		}
		
		int [] langs = registrationForm.getLangs();
		if(null != langs && langs.length <=0 ){
			errors.rejectValue("langs", "field.required",null, "Invalid input, At least one Languages has to be selected." );
		}

		int [] skills = registrationForm.getSkills();
		if(null != skills && skills.length <=0 ){
			errors.rejectValue("skills", "field.required",null, "Invalid input, At least one Skills has to be selected." );
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required",null, "Invalid input, First Name can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "field.required",null, "Invalid input, Last Name can't be empty." );
		
		if(!LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode().equals(registrationForm.getUserType())){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityQ1Value", "field.required",null, "Invalid input, Security Question 1 can't be empty." );
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityQ2Value", "field.required",null, "Invalid input, Security Question 2 can't be empty." );
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street1", "field.required",null, "Invalid input, Street 1 can't be empty." );
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "field.required",null, "Invalid input, City can't be empty." );
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "field.required",null, "Invalid input, Zip can't be empty." );
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "field.required",null, "Invalid input, Country can't be empty." );
		}
		
/*		if(!registrationForm.isTermsAccepted()){
			errors.rejectValue("termsAccepted", "field.required",null, "Invalid input, Terms and Conditions has to be accpted." );
		}*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "acceptedTermsId", "field.required",null, "Invalid input, Accepted Terms and Conditions can't be empty." );
		
		//TODO need to research how to resolve the error codes when ajax calls made
		if(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode().equals(registrationForm.getUserType())){
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cell", "field.required",null, "Invalid input, Mobile phone can't be empty." );
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aboutYou", "field.required",null, "Invalid input, AboutYou can't be empty." );		
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fax", "field.required",null, "Invalid input, Fax can't be empty." );
			//if(registrationForm.getEducationId() == -2 && StringUtils.isBlank(registrationForm.getOtherEducation()))
			//	errors.rejectValue("otherEducation","field.required","Please enter your education detail.");
			//if(registrationForm.getSpecialtyId() == -2 && StringUtils.isBlank(registrationForm.getOtherSpecialty()))
			//	errors.rejectValue("otherSpecialty","field.required","Please enter your area of specialty detail.");
			
		}else{
			//customer 
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "field.required",null, "Invalid input, Company Name can't be empty." );
		}
		}catch(Exception ex)
		{
			errors.reject("Sorry, Registration Failed !");
		}
	}
		
}