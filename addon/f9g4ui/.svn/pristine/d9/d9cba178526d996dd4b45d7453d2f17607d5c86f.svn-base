package com.f9g4.webapp.controllers;

import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdAccepttermsDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StTermConditionDomain;
import com.f9g4.businessobjects.services.GetLatestTermsByUserResponse;
import com.f9g4.businessobjects.services.GetTermsConditionsResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;

@Controller
@SessionAttributes({"user"})
public class TermsAndCoditionsController {
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;

	@RequestMapping(value=ViewPaths.DESIGNER_REGISTRATION_TERMS,method=RequestMethod.GET)
	public String latestDesignerRegistraionTerms(ModelMap model){
		
		GetTermsConditionsResponse request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode() , LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode());
		StTermConditionDomain stTermCondition = request.getTermCondition();
		byte[] Msg = stTermCondition.getDisplayedTerm();
		model.addAttribute("hasError", false);
		model.addAttribute("termsId", stTermCondition.getTermCondId());
		model.addAttribute("terms", new String(Msg));
		return ViewNames.DESIGNER_REGISTRATION_TERMS;
	}
	
	@RequestMapping(value=ViewPaths.DESIGNER_REGISTRATION_TERMS_BASIC,method=RequestMethod.GET)
	public String latestBasicDesignerRegistraionTerms(ModelMap model){
		
		GetTermsConditionsResponse request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION_DESIGNER.getTypeCode() , LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode());
		StTermConditionDomain stTermCondition = request.getTermCondition();
		byte[] Msg = stTermCondition.getDisplayedTerm();
		model.addAttribute("hasError", false);
		model.addAttribute("termsId", stTermCondition.getTermCondId());
		model.addAttribute("terms", new String(Msg));
		return ViewNames.VIEW_TERMS;
	}
	
	/*@RequestMapping(value=ViewPaths.DESIGNER_MEMBERSHIP_TERMS,method=RequestMethod.GET)
	public String latestDesignerMembershipTerms(ModelMap model){
		GetTermsConditionsResponse request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_SALE.getTypeCode() , LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode());
		StTermConditionDomain stTermCondition = request.getTermCondition();
		byte[] Msg = stTermCondition.getDisplayedTerm();
		model.addAttribute("hasError", false);
		model.addAttribute("termsId",stTermCondition.getTermCondId());
		model.addAttribute("terms", new String(Msg));
		return ViewNames.DESIGNER_MEMBERSHIP_TERMS;
	}*/

	@RequestMapping(value=ViewPaths.CUSTOMER_REGISTRATION_TERMS,method=RequestMethod.GET)
	public String latestCustomerRegistraionTerms(ModelMap model){
		GetTermsConditionsResponse request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode() , LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
		StTermConditionDomain stTermCondition = request.getTermCondition();
		byte[] Msg = stTermCondition.getDisplayedTerm();
		model.addAttribute("hasError", false);
		model.addAttribute("termsId", stTermCondition.getTermCondId());
		model.addAttribute("terms", new String(Msg));

		return ViewNames.CUSTOMER_REGISTRATION_TERMS;
	}

	//my controller for the sale terms
	@RequestMapping(value=ViewPaths.CUSTOMER_SALE_TERMS, method=RequestMethod.GET)	
	public String latestCustomerSaleTerms(ModelMap model){
		
		GetTermsConditionsResponse request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_SALE.getTypeCode() , LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
		StTermConditionDomain stTermCondition = request.getTermCondition();
		byte[] Msg = stTermCondition.getDisplayedTerm();
		model.addAttribute("hasError", false);
		model.addAttribute("termsId", stTermCondition.getTermCondId());
		model.addAttribute("terms", new String(Msg));
	
		return ViewNames.CUSTOMER_SALE_TERMS;
	}
	/*@RequestMapping(value=ViewPaths.CUSTOMER_MEMBERSHIP_TERMS, method=RequestMethod.GET)	
	public String latestCustomerMembershipTerms(ModelMap model){
		GetTermsConditionsResponse request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_SALE.getTypeCode() , LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
		StTermConditionDomain stTermCondition = request.getTermCondition();
		byte[] Msg = stTermCondition.getDisplayedTerm();
		model.addAttribute("hasError", false);
		model.addAttribute("termsId", stTermCondition.getTermCondId());
		model.addAttribute("terms", new String(Msg));
		
		return ViewNames.CUSTOMER_MEMBERSHIP_TERMS;
	}*/
	
	@RequestMapping(value=ViewPaths.VIEW_TERMS, method=RequestMethod.GET)	
	public String viewTerms(ModelMap model,@ModelAttribute("user") AdUsersDomain user){
		GetLatestTermsByUserResponse response = registrationServiceSDK.getLatestTermsByUser(user.getUserId());
		//GetTermsConditionsResponse response = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode() , user.getUserType());
		StTermConditionDomain stTermCondition = response.getTerm();
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			byte[] Msg = stTermCondition.getDisplayedTerm();
			model.addAttribute("hasError", false);
			model.addAttribute("termsId", stTermCondition.getTermCondId());
			model.addAttribute("terms", new String(Msg));
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("termsId", 99999); //Hardcoded, do not use.
			model.addAttribute("terms", "Sorry, our service is not available. Please try again. Thanks.");
		}
	
		return ViewNames.VIEW_TERMS;
	}
	
}
