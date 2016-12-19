package com.f9g4.webapp.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.domain.TrReferralsDomain;
import com.f9g4.businessobjects.services.AddNotificationQRequest;
import com.f9g4.businessobjects.services.AddReferralsRequest;
import com.f9g4.businessobjects.services.AddReferralsResponse;
import com.f9g4.businessobjects.services.DeleteReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralsForUserResponse;
import com.f9g4.businessobjects.services.ResendReferralMessageResponse;
import com.f9g4.businessobjects.services.UpdateReferralAndResendMessageRequest;
import com.f9g4.businessobjects.services.UpdateReferralAndResendMessageResponse;
import com.f9g4.businessobjects.services.UpdateReferralRequest;
import com.f9g4.businessobjects.services.UpdateReferralResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.NotificationQServiceSDK;
import com.f9g4.servicesdk.ReferralsServiceSDK;
import com.f9g4.web.forms.ReferralForm;
import com.f9g4.web.utils.TimeConvertUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"user", "userId", "referralsList","cart", "languagesList",  "skillsList", "timezoneOffset"})
@RequestMapping("/console")
public class ReferralController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReferralController.class);
	
	@Autowired
	private ReferralsServiceSDK referralServiceSDK;

	@Autowired
	private NotificationQServiceSDK notificationQServiceSDK;
	
	@RequestMapping(value ="referrals", method=RequestMethod.GET)
	public String popupReferrals(ModelMap model)
	{
		model.addAttribute("referralForm", new ReferralForm());
		//view
		return "referral";
	}
	
	@RequestMapping(value ="referrals", method=RequestMethod.POST)
	public @ResponseBody String setReferrals(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,@Valid ReferralForm formBean,BindingResult result,ModelMap model)
	{
		//check the user is not refer by them selves.
		if(formBean.getEmail().toUpperCase().equals(adUsersDomain.getUserName().toUpperCase()))
			result.rejectValue("email", "field.required",null, "Sorry, you cannot refer yourself. Please enter your referral email. Thank you.");
		if(result.hasErrors())
		{
			logger.debug("VALIDATION ERROR="+result.getAllErrors());
		}
		else
		{
			//push data to database
			//create object
			logger.trace("REFERRAL FORM=>"+formBean.toString());
			TrReferralsDomain domain=new TrReferralsDomain();
			domain.setSentUserId(adUsersDomain.getUserId());
			domain.setFirstName(formBean.getFirstName());
			domain.setLastName(formBean.getLastName());
			//Set data to phone--------------------//
			domain.setEmail(formBean.getEmail());
			domain.setWhyRefer(formBean.getReason());
			domain.setMessage(formBean.getBackground());
			domain.setPhone(formBean.getPhone());
			try 
			{
				//set expiration date
				//add the expiration days for 60 days from sysday
				Calendar day=Calendar.getInstance(); //UTC time
				day.add(Calendar.DAY_OF_MONTH, +60); //add 60 days
				domain.setExpirationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(day)); //UTC time
			} 
			catch (DatatypeConfigurationException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			domain.setAuthCode("111"); //TODO hardcoded data
			
			AddReferralsRequest request=new AddReferralsRequest();
			request.setReferrals(domain);
			AddReferralsResponse response=new AddReferralsResponse();
			response=referralServiceSDK.addReferrals(request);
			
			logger.debug("STATUS CODE="+response.getStatus().getStatuscode()+" / "+response.getStatus().getDescription());
			//Status Checking
			if(response.getStatus().getStatuscode().equals("0"))
				return "[\"SUCCESS\",\"Added referral "+formBean.getFirstName()+" successfully\"]";
			else
				return "[\"FAIL\",\"fail\"]";
		}
		return "[\"FAIL\",\""+result.getAllErrors().get(0).getDefaultMessage()+"\"]";
	}
	
	@RequestMapping(value ="manage_referrals", method=RequestMethod.GET)
	public String popupManageReferrals(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap model)
	{
		GetReferralsForUserResponse response=referralServiceSDK.getReferralsForUser(adUsersDomain.getUserId());
		List<TrReferralsDomain> referralsList=response.getReferrals();
		ArrayList<ReferralForm> beanReferralsList=new ArrayList<ReferralForm>();
		logger.debug("SIZE="+referralsList.size());
		//convert to formbean class
		for( TrReferralsDomain item : referralsList)
		{
			ReferralForm temp=new ReferralForm();
			temp.setFirstName(item.getFirstName());
			temp.setLastName(item.getLastName());
			temp.setPhone(item.getPhone());
			temp.setEmail(item.getEmail());
			//convert date type
			//format the date
			Calendar dateSent=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(item.getDateSent()); //convert to Calendar
			//convert to local time
			Calendar localTime=TimeConvertUtil.convertToLocalTime(dateSent, timezoneOffset);
			temp.setDateSent(localTime.getTime());
			//TODO set status
			if(item.getSignedupUserid()==0) //means the referral you refer has not registered yet.
				temp.setStatus("Pending");
			else
				temp.setStatus("Registered");
			beanReferralsList.add(temp);
		}
		
		logger.debug("REFERRALS SIZE="+referralsList.size());
		model.addAttribute("referralsList",referralsList); //referrals data
		model.addAttribute("beanReferralsList",beanReferralsList); //referrals data
		model.addAttribute("referralForm", new ReferralForm()); //put the form
		
		//view
		return "referral_manage";
	}
	
	@RequestMapping(value ="manage_referrals/{requireResend}/{rowCount}", method=RequestMethod.POST)
	public @ResponseBody ModelMap setManageReferrals(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,@PathVariable("requireResend") int requireResend,@PathVariable(value="rowCount") int rowCount,ReferralForm formBean,@ModelAttribute(value="referralsList") List<TrReferralsDomain> referralsList,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		logger.debug("ROW COUNT=>"+rowCount+" ; MANAGE REFERRAL="+formBean.toString());
		logger.debug("RAW DATA=>"+referralsList.get(rowCount).getSignedupUserid()+" ; "+referralsList.get(rowCount).getSignupOn());
		ModelMap map=new ModelMap();
		UpdateReferralRequest request=new UpdateReferralRequest();
		TrReferralsDomain data=new TrReferralsDomain();
		//prepare the data to update
		data.setReferalId(referralsList.get(rowCount).getReferalId());
		data.setSentUserId(adUsersDomain.getUserId());
		data.setFirstName(formBean.getFirstName());
		data.setLastName(formBean.getLastName());
		data.setPhone(formBean.getPhone());
		data.setEmail(formBean.getEmail());
		data.setAuthCode(referralsList.get(rowCount).getAuthCode());
		data.setLangCode(referralsList.get(rowCount).getLangCode());
		data.setMessage(referralsList.get(rowCount).getMessage());
		data.setSignedupUserid(referralsList.get(rowCount).getSignedupUserid());
		data.setSignupOn(referralsList.get(rowCount).getSignupOn());
		data.setWhyRefer(referralsList.get(rowCount).getWhyRefer());
		data.setAuthCode("111"); //TODO hardcoded the auth code
		try 
		{
			//set expiration date
			//add the expiration days for 60 days from sysday
			Calendar day=Calendar.getInstance();
			day.add(Calendar.DAY_OF_MONTH, +60); //add 60 days
			data.setExpirationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(day));
		} 
		catch (DatatypeConfigurationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setReferrals(data);
		UpdateReferralResponse response=referralServiceSDK.updateReferral(request);
		logger.debug("Update status="+response.getStatus().getStatuscode());
		
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			map.addAttribute("hasError",false);
			map.addAttribute("hasResend", false);
			//retrieve the referral data
			GetReferralsByIdResponse referralResponse=referralServiceSDK.getReferralsbyId(data.getReferalId());
			data=referralResponse.getReferrals();
			//convert to referral bean class
			ReferralForm beanReferral = new ReferralForm();
			beanReferral=convertDomainToBean(data,timezoneOffset);
			map.addAttribute("result", beanReferral);
			//update session
			referralsList.set(rowCount, data);
		}
		else
			map.addAttribute("hasError", true);
		return map;
	}
	
	@RequestMapping(value ="resendReferralNoti/{rowCount}", method=RequestMethod.POST)
	public @ResponseBody ModelMap resendReferralNotification(@PathVariable("rowCount") int rowCount,@ModelAttribute(value="referralsList") List<TrReferralsDomain> referralsList,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		ModelMap map=new ModelMap();
		//TODO update referral record to trigger DB event
		UpdateReferralRequest request=new UpdateReferralRequest();
		TrReferralsDomain data=new TrReferralsDomain();
		data=referralsList.get(rowCount);
		request.setReferrals(data);
		UpdateReferralResponse response=referralServiceSDK.updateReferral(request);
		
		if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(response.getStatus().getStatuscode()))
		{
			map.addAttribute("hasError", false);
			map.addAttribute("status", response.getStatus());
			//retrieve the referral data
			GetReferralsByIdResponse referralResponse=referralServiceSDK.getReferralsbyId(data.getReferalId());
			data=referralResponse.getReferrals();
			//convert to referral bean class
			ReferralForm beanReferral = new ReferralForm();
			beanReferral=convertDomainToBean(data,timezoneOffset);
			map.addAttribute("result", beanReferral);
		}
		else
		{
			map.addAttribute("hasError", true);
			map.addAttribute("status", response.getStatus());
		}
		return map;
	}
	
	private ReferralForm convertDomainToBean(TrReferralsDomain domain, Integer timezoneOffset)
	{
		//convert to referral bean class
		ReferralForm beanReferral = new ReferralForm();
		beanReferral.setFirstName(domain.getFirstName());
		beanReferral.setLastName(domain.getLastName());
		beanReferral.setPhone(domain.getPhone());
		beanReferral.setEmail(domain.getEmail());
		//convert date type
		//format the date
		Calendar dateSent=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getDateSent()); //convert to Calendar
		//convert to local time
		dateSent=TimeConvertUtil.convertToLocalTime(dateSent, timezoneOffset);
		beanReferral.setDateSent(dateSent.getTime());
		String dateString = new SimpleDateFormat("MMM dd,yyyy").format(dateSent.getTime());
		beanReferral.setDateSentString(dateString);
		//TODO set status
		if(domain.getSignedupUserid()==0) //means the referral you refer has not registered yet.
			beanReferral.setStatus("Pending");
		else
			beanReferral.setStatus("Registered");
		return beanReferral;
	}
}
