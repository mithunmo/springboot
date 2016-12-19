package com.f9g4.webapp.controllers;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;

import org.mockito.asm.tree.IntInsnNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrMembershipAuthSubmitDomain;
import com.f9g4.businessobjects.services.CreateMembershipAuthSbmitRequest;
import com.f9g4.businessobjects.services.CreateMembershipAuthSbmitResponse;
import com.f9g4.businessobjects.services.CreateMembershipRequest;
import com.f9g4.businessobjects.services.CreateMembershipResponse;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsRequest;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.GetMembershipdetailsResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.DateConverter;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.PaypalConstants;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.MembershipServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.forms.MembershipForm;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.TimeConvertUtil;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;

@Controller
@SessionAttributes({"user", "payKey", "userId", "isUpdateMembership", "timezoneOffset"})
public class MembershipController {
	
	private static final Logger logger = LoggerFactory.getLogger(MembershipController.class);
	
	@Autowired
	private MembershipServiceSDK membershipServiceSDK;
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;
	
	@Autowired @Value("${payment_membership_listener_url}")
	private String paymentMembershipListenerUrl;
	
	@Autowired @Value("${membership_return_url}")
	private String paymentMembershipReturnUrl;
	
	@Autowired @Value("${membership_cancel_url}")
	private String paymentMembershipCancelUrl;
	
	@Autowired @Value("${paypal_single_transaction_limit}")
	private String strpaypalSingleTransactionLimit;
	
	private BigDecimal paypalSingleTransactionLimit;
	
	@Autowired @Value("${footer_linkedin_url}")
	private String footer_linkedin_url;
	
	@Autowired @Value("${footer_facebook_url}")
	private String footer_facebook_url;
	
	@Autowired @Value("${footer_twitter_url}")
	private String footer_twitter_url;
	
	@Autowired @Value("${footer_rssfeed_url}")
	private String footer_rssfeed_url;
	
	@Autowired @Value("${paypalredirecturl}")
	private String paypalredirecturl;
	
	@ModelAttribute("footer_urls") 
	public ModelMap getFooterUrl()
	{
		ModelMap map=new ModelMap();
		map.addAttribute("footer_linkedin_url", footer_linkedin_url);
		map.addAttribute("footer_facebook_url", footer_facebook_url);
		map.addAttribute("footer_twitter_url", footer_twitter_url);
		map.addAttribute("footer_rssfeed_url", footer_rssfeed_url);
		return map;
	}
		
	public BigDecimal getPaypalSingleTransactionLimit() {
		return new BigDecimal(strpaypalSingleTransactionLimit);
	}



	public void setPaypalSingleTransactionLimit(
			BigDecimal paypalSingleTransactionLimit) {
		this.paypalSingleTransactionLimit = paypalSingleTransactionLimit;
	}

	//membership pay from splashscreen
	@RequestMapping(value=ViewPaths.MEMBERSHIP_PAY, method=RequestMethod.GET)
	public String setupMembershipForm(@RequestParam("userId") int userId,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap model) {		
		model.put("userId", userId);
		ViewUserResponse viewUserResponse=registrationServiceSDK.viewUser(userId); //get user type
		GetMembershipdetailsResponse membershipdetailsResponse = membershipServiceSDK.getMembershipdetails(userId);
		AdUserMembershipDomain adUserMembership = membershipdetailsResponse.getAdUserMembership();
		if(null != adUserMembership){
			Calendar today = Calendar.getInstance(); //UTC time
			Calendar expirationDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adUserMembership.getExperiationDate()); //UTC time
			if(null != expirationDate){
				boolean isPaymentDue  = expirationDate.compareTo(today) < 0 ? true : false;				
				model.addAttribute("isPaymentDue", isPaymentDue);
			}
			
			int noofMonths = DateConverter.GetExpiredMonths(expirationDate);
			//Convert to show local time
			model.addAttribute("expDate", TimeConvertUtil.convertToLocalTime(expirationDate, timezoneOffset).getTime());
			//model.addAttribute("expDate", expirationDate.getTime());
			//check the total price is under the paypal limit.
			BigDecimal totalFee=adUserMembership.getMembershipPrice().multiply(new BigDecimal(noofMonths));
			if(totalFee.compareTo(this.getPaypalSingleTransactionLimit())==1)
			{
				model.addAttribute("hasError", true);
				model.addAttribute("errorCode", ErrorsCodeEnum.SINGLE_TRANSACTION_LIMIT.getCode());
				model.addAttribute("membershipPrice", totalFee);
			}
			else if(totalFee.compareTo(new BigDecimal(0))!=1) //fee is not larger than $0.00 dollars
			{
				model.addAttribute("hasError", true);
				model.addAttribute("errorCode", ErrorsCodeEnum.MEMBERSHIP_FEE_FREE.getCode());
				model.addAttribute("membershipPrice", totalFee);
			}
			else
			{
				model.addAttribute("hasError", false);
				//check user type
				if(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode().equals(viewUserResponse.getUser().getUserType()))
					model.addAttribute("isCtUserType", true);
				else
					model.addAttribute("isCtUserType", false);
				model.addAttribute("membershipPrice", totalFee);
			}
			model.addAttribute("isUpdateMembership", false);
			
		}
		model.addAttribute("membershipForm", new MembershipForm());
  		return ViewNames.MEMBERSHIP_PAYMENT;
	}


	//membership pay from console
	@RequestMapping(value=ViewPaths.UPDATE_MEMBERSHIP_PAY, method=RequestMethod.GET)
	public String setupUpdateMembershipForm(@RequestParam("userId") int userId,@ModelAttribute("timezoneOffset") Integer timezoneOffset, /*@RequestParam(value="isUpdateMembership") boolean isUpdateMembership,*/ModelMap model) {		
		model.put("userId", userId);
		ViewUserResponse viewUserResponse=registrationServiceSDK.viewUser(userId); //get user type
		GetMembershipdetailsResponse membershipdetailsResponse = membershipServiceSDK.getMembershipdetails(userId);
		AdUserMembershipDomain adUserMembership = membershipdetailsResponse.getAdUserMembership();
		if(null != adUserMembership){
			Calendar today = Calendar.getInstance();
			Calendar expirationDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adUserMembership.getExperiationDate());
			if(null != expirationDate){
				boolean isPaymentDue  = expirationDate.compareTo(today) < 0 ? true : false;				
				model.addAttribute("isPaymentDue", isPaymentDue);
			}
			//Convert to show local time
			model.addAttribute("expDate", TimeConvertUtil.convertToLocalTime(expirationDate, timezoneOffset).getTime());
			if(adUserMembership.getMembershipPrice().compareTo(new BigDecimal(0))!=1) //fee is not larger than $0.00 dollars
			{
				model.addAttribute("hasError", true);
				model.addAttribute("errorCode", ErrorsCodeEnum.MEMBERSHIP_FEE_FREE.getCode());
			}
			model.addAttribute("membershipPrice", adUserMembership.getMembershipPrice());
			model.addAttribute("isUpdateMembership", true);
			//model.addAttribute("isUpdateMembership", isUpdateMembership);
			
		}
		model.addAttribute("membershipForm", new MembershipForm());
		//check user type
		if(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode().equals(viewUserResponse.getUser().getUserType()))
			model.addAttribute("isCtUserType", true);
		else
			model.addAttribute("isCtUserType", false);
  		return ViewNames.MEMBERSHIP_PAYMENT_UPDATE;
	}
	
	//@RequestMapping(value=ViewPaths.DESIGNER_MEMBERSHIP, method=RequestMethod.POST)
	public @ResponseBody ModelMap submitDesignerMembershipForm(@ModelAttribute("membershipForm") MembershipForm membershipForm, BindingResult results,  ModelMap model) throws DatatypeConfigurationException {
		
		try{
			Calendar today = Calendar.getInstance();
			CreateMembershipRequest request = new CreateMembershipRequest();
			AdUserMembershipDomain adUserMembershipDomain = new AdUserMembershipDomain();
			adUserMembershipDomain.setAutopay(Constants.AUTO_PAY_NO);
			adUserMembershipDomain.setCreatedby(membershipForm.getUserId());
			adUserMembershipDomain.setLastupdateby(membershipForm.getUserId());
			adUserMembershipDomain.setPaymentStatus(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PROCESSING.getTypeCode());
			adUserMembershipDomain.setUserId(membershipForm.getUserId());			
			
			TrMembershipAuthSubmitDomain trMembershipAuthSubmitDomain = new TrMembershipAuthSubmitDomain();
//			trMembershipAuthSubmitDomain.setMemAuthSubmitId(value);
			trMembershipAuthSubmitDomain.setChargeAmount(membershipForm.getChargeAmount());
			trMembershipAuthSubmitDomain.setCreatedby(membershipForm.getUserId());
			trMembershipAuthSubmitDomain.setInitialTimeStamp(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(today));
			trMembershipAuthSubmitDomain.setLastupdateby(membershipForm.getUserId());
			trMembershipAuthSubmitDomain.setSecureToken(membershipForm.getSecureToken());
//			trMembershipAuthSubmitDomain.setMembershipId(value);
			request.setAdUserMembershipDomain(adUserMembershipDomain);
			CreateMembershipResponse response = membershipServiceSDK.createMembership(request);
			if(StatusCodesEnum.STATUS_SUCCESS.equals(response.getStatus().getStatuscode())){
				model.put("hasError", false);
			}else{
				model.put("hasError", true);
			}
			
		}catch(Throwable th){
			logger.error("Exception occured" + th);
			model.put("hasError", true);
		}
		
  		return model;
	}
	
	@RequestMapping(value=ViewPaths.SHOW_COMMISSION+"/{price}", method=RequestMethod.GET)
	public String getCommission(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable("price") BigDecimal price,ModelMap model) 
	{
		
		GetMembershipCommissionRequest request = new GetMembershipCommissionRequest();
		request.setUserId(adUser.getUserId());
		GetMembershipCommissionResponse response =  membershipServiceSDK.getMembershipCommissiondetails(request);
		BigDecimal commission = response.getStPricingOptions().getCommission();
		model.put("commission",	commission.setScale(2));
		if(price.equals(new BigDecimal(-1.0)))
		{
//			System.out.println("Price is zero !!");
			BigDecimal zeroVal = new BigDecimal("0.00").setScale(2);
			model.put("price",	zeroVal);
			model.put("commissionAmount", zeroVal);
			model.put("boardPrice",	zeroVal);
		}
		else
		{
			model.put("price",	price.setScale(2));
			BigDecimal CommissionAmount = commission.multiply(price.divide(new BigDecimal("100.00")));
			model.put("commissionAmount",	CommissionAmount.setScale(2));
			BigDecimal BoardPrice = price.subtract( CommissionAmount );
			model.put("boardPrice",	BoardPrice.setScale(2));
		
		}
			return ViewNames.SHOW_COMMISSION;
	}
	
	
	@RequestMapping(value=ViewPaths.MEMBERSHIP_PAY, method=RequestMethod.POST)
	public String membershipPayment(HttpServletRequest httpRequest, HttpSession session, ModelMap model) 
	{
		String payKey ="";
	
		String url = "http://" + httpRequest.getServerName() + httpRequest.getContextPath();//TODO - convert into https
		String cancelUrl = paymentMembershipCancelUrl; //url + ViewPaths.MEMBERSHIP_PAY_CANCEl_URL; 
		String returnUrl = paymentMembershipReturnUrl; //url + ViewPaths.MEMBERSHIP_PAY_RETURN_URL;
				
		CreateMembershipAuthSbmitRequest request = new CreateMembershipAuthSbmitRequest(); 
		request.setUserID((Integer) session.getAttribute("userId"));
		request.setCancelUrl(cancelUrl);
		request.setReturnUrl(returnUrl);
		request.setPaymentMembershipListenerUrl(paymentMembershipListenerUrl);
		request.setMembershipType(LookupTypeValueEnum.MEMEBERSHIP_TYPE_STANDARD.getTypeCode());//right now its standard
		
		TrMembershipAuthSubmitDomain trMembershipAuthSubmitDomain = new TrMembershipAuthSubmitDomain();
//		trMembershipAuthSubmitDomain.setChargeAmount(value); - would be decided in service..
		trMembershipAuthSubmitDomain.setCreatedby((Integer) session.getAttribute("userId"));
//		trMembershipAuthSubmitDomain.setInitialTimeStamp(value); - would be set  in service.
		trMembershipAuthSubmitDomain.setLastupdateby((Integer) session.getAttribute("userId"));
//		trMembershipAuthSubmitDomain.setMemAuthSubmitId(value); -- Would be set in service.
//		trMembershipAuthSubmitDomain.setMembershipId(value); -- Would be created by dao in services..
//		trMembershipAuthSubmitDomain.setSecureToken(value); - would be set in service..
		
		request.setTrMembershipAuthSubmitDomain(trMembershipAuthSubmitDomain);
		String viewName = ""; 
		CreateMembershipAuthSbmitResponse response = membershipServiceSDK.createMembershipAuthSbmit(request);
		if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(response.getStatus().getStatuscode())){
			//success
			payKey = response.getPayKey();
			session.setAttribute("payKey", payKey);
			viewName = "redirect:" + paypalredirecturl + "&paykey=" + payKey;
		}else{
			//error
//			System.out.println(response.getStatus().getStatuscode());
			viewName = "";//show error screen
		}
		return viewName;
	}
	
	@RequestMapping(value=ViewPaths.MEMBERSHIP_PAY_RETURN_URL, method=RequestMethod.GET)
	public String membershipPaymentReturn(HttpSession session, ModelMap model) 
	{
		// Kamlesh - Changing the membership handling - Added new IPN listner for messages and as soon as membership is paid a message will be sent to message listener and memerbship will be created
		//When user retrns from paypal we have to check the membership and if its processed show the message.
		
		//First condition if user session is expired - take him to login page.
		String viewName = null;
		int userId=0;		
		try{
		userId =(Integer)session.getAttribute("userId");
		}catch(Exception e){
			viewName =  "redirect:" + ViewPaths.LOGIN;;
			return viewName;
		}
		
		// otherwise check the users membership and if membership is processed by message listener and its updated in database - show the confirmation.
		GetMembershipdetailsResponse membershipdetailsResponse = membershipServiceSDK.getMembershipdetails(userId);
		AdUserMembershipDomain adUserMembership = membershipdetailsResponse.getAdUserMembership();
		//Get user info
		ViewUserResponse viewUserResponse=registrationServiceSDK.viewUser(userId);
		AdUsersDomain userInfo=viewUserResponse.getUser();
		boolean isPaymentDue=false;
		boolean isNewUser=false;
		//update the model attribute.
		//to check the user is new user or exist user by register status
		if(userInfo.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()))
			isNewUser=false;
		else
			isNewUser=true; //if the user is not the status of 432, it means this user is a new user.
				
		if(null != adUserMembership){
			viewName = ViewNames.MEMBERSHIP_PAYMENT_END;
			Calendar today = Calendar.getInstance(); //UTC time
			Calendar expirationDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adUserMembership.getExperiationDate()); //UTC time
			if(null != expirationDate){
				 isPaymentDue  = expirationDate.compareTo(today) < 0 ? false : true;				
			}
			if(isPaymentDue || isNewUser == true){
				//if the user is the new user, we set the expiration date to today, so it's expired. However, we don't want to show the error message.
				model.put("showError", false);
				
			}else{
				//sometime the membership will be updated after return back to our system. Needs to change the display text of error. -C
				model.put("showError", true);
			}
		}
		model.put("isNewUser", isNewUser);
		return viewName;
		//Kamlesh Commented out old Pardha code to insert membership on users return.
		
//		String payKey = null;
//		 viewName = ViewNames.MEMBERSHIP_PAYMENT_END;;
//		if((payKey = getPayKey(session)) != null){
//			CreateReceiveMembershipPaymentsRequest request = new CreateReceiveMembershipPaymentsRequest();
//			request.setPayCommand(PaypalConstants.COMMAND_RETURN);
//			request.setSecureToken(payKey);
//			CreateReceiveMembershipPaymentsResponse response =  membershipServiceSDK.createReceiveMembershipPayments(request);
//			if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(response.getStatus().getStatuscode())){
//				model.put("showError", false);
//			}else{
//				model.put("showError", true);
//			}
//		}
//		return viewName;
	}
	
	@RequestMapping(value=ViewPaths.MEMBERSHIP_PAY_CANCEl_URL, method=RequestMethod.GET)
	public String membershipPaymentCancel(@ModelAttribute("userId") Integer userId,  HttpSession session, ModelMap model) 
	{
		String viewName = null;
		String payKey = null;
		if(null  == session.getAttribute("payKey")){
			viewName = "redirect:" + ViewPaths.LOGIN;
		}else{
			if((payKey = getPayKey(session)) != null){
				//Pravin i think this is wen the user hits return
				CreateReceiveMembershipPaymentsRequest request = new CreateReceiveMembershipPaymentsRequest();
				request.setPayCommand(PaypalConstants.COMMAND_CANCEL);
				request.setSecureToken(payKey);
				membershipServiceSDK.createReceiveMembershipPayments(request);
//				System.out.println(model.toString());
				Boolean isUpdateMembership=(Boolean) model.get("isUpdateMembership");
				if(isUpdateMembership.booleanValue())
					viewName = "redirect:" + ViewPaths.UPDATE_MEMBERSHIP_PAY;
				else
					viewName = "redirect:" + ViewPaths.MEMBERSHIP_PAY; 	
			}						
		}
		return viewName;
	}
	
	private synchronized String getPayKey(HttpSession httpSession){
		String payKey = null;
		payKey = (String) httpSession.getAttribute("payKey");
		httpSession.removeAttribute("payKey");
		return payKey;
	}
}