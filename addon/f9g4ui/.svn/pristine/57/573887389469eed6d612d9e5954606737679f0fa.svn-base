package com.f9g4.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;

public class F9g4ValidatoinUtils {

	private static final String EMAIL_PATTERN =  "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	// "^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$";
	private static final String PHONE_NUMEBR_PATTERN = "\\d{3}-\\d{7}";
			
	private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);;
	private static final Pattern phoneNumberPattern = Pattern.compile(PHONE_NUMEBR_PATTERN);
	
/*	public static void rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage) {
		Assert.notNull(errors, "Errors object must not be null");
		Object value = errors.getFieldValue(field);
		if (value == null ||!StringUtils.hasText(value.toString())) {
			errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
		}
	}*/

	public static void rejectIfNotEmail(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage) {
		Assert.notNull(errors, "Errors object must not be null");
		String value = (String) errors.getFieldValue(field);
		Matcher matcher = emailPattern.matcher(value);
		if(!matcher.matches()){
			errors.rejectValue(field, errorCode, errorArgs, defaultMessage);	
		}
	}
	
	public static void rejectIfNotPhoneNumber(Errors errors, String field, String errorCode, Object[] errorArgs, String defaultMessage) {
		Assert.notNull(errors, "Errors object must not be null");
		String value = (String) errors.getFieldValue(field);
		Matcher matcher = phoneNumberPattern.matcher(value);
		if(!matcher.matches()){
			errors.rejectValue(field, errorCode, errorArgs, defaultMessage);	
		}
	}
}
