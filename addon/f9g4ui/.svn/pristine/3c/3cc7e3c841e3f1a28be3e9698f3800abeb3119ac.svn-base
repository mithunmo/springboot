package com.f9g4.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.f9g4.web.forms.CreateBoardForm;

public class CreateBoardFormValidator implements Validator{

	@Autowired @Value("${minimun_board_price}")
	private Double minimunBoardPrice;
	
	@Autowired @Value("${maximun_board_price}")
	private Double maximunBoardPrice;
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		CreateBoardForm form = (CreateBoardForm) target;
		
		ValidationUtils.rejectIfEmpty(errors, "boardName", "field.required",null, "Invalid input, Board Name can't be empty." );
		ValidationUtils.rejectIfEmpty(errors, "boardDescription", "field.required",null, "Invalid input, Board Description can't be empty." );
		ValidationUtils.rejectIfEmpty(errors, "boardImageUrl", "field.required",null, "Invalid input, Board Image can't be empty." );
		
		//ValidationUtils.rejectIfEmpty(errors, "portfolioId", "field.required",null, "Invalid input, Board Image can't be empty." );
		//ValidationUtils.rejectIfEmpty(errors, "product", "field.required",null, "Invalid input, Board Image can't be empty." );
		//ValidationUtils.rejectIfEmpty(errors, "productType", "field.required",null, "Invalid input, Board Image can't be empty." );
		//ValidationUtils.rejectIfEmpty(errors, "price", "field.required",null, "Invalid input, Board Image can't be empty." );
		//ValidationUtils.rejectIfEmpty(errors, "expirationDays", "field.required",null, "Invalid input, Board Image can't be empty." );
		
		if(form.getPortfolioId()==null||form.getPortfolioId()<0)
			errors.reject("PortfolioId","Invalid input, PortfolioId can't be empty.");
		if(form.getProductTags()==null||form.getProductTags().length<0)
			errors.reject("product","Invalid input, Product can't be empty.");
		if(form.getProductTypeTags()==null|| form.getProductTypeTags().length<=0)
			errors.reject("productType","Invalid input, Product Type can't be empty.");
		if(form.getPrice()%1!=0)
			errors.reject("price","Invalid input, FFG credit doesn't allow decimal.");
		if(form.getPrice()<minimunBoardPrice)
			errors.reject("price","Invalid input, Price can't be empty or less than "+ minimunBoardPrice +" FFG credits.");
		if(form.getPrice()>maximunBoardPrice)
			errors.reject("price","Invalid input, Price can't be empty or lager than "+ maximunBoardPrice +" FFG credits.");
		/*if(form.getExpirationDays()==null||form.getExpirationDays()<0)
			errors.reject("expirationDays","Invalid input, Expiration Days can't be empty.");*/
	}

}
