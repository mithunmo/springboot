package com.f9g4.webapp.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdAccepttermsDomain;
import com.f9g4.businessobjects.domain.AdActiveUserDomain;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StTermConditionDomain;
import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.domain.TrReferralsDomain;
import com.f9g4.businessobjects.services.AddNotificationQRequest;
import com.f9g4.businessobjects.services.AddNotificationQResponse;
import com.f9g4.businessobjects.services.AddReferralsRequest;
import com.f9g4.businessobjects.services.AddReferralsResponse;
import com.f9g4.businessobjects.services.AddUserLogRequest;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeResponse;
import com.f9g4.businessobjects.services.GetMembershipdetailsResponse;
import com.f9g4.businessobjects.services.GetSecurityQuestionResponse;
import com.f9g4.businessobjects.services.GetTermsConditionsResponse;
import com.f9g4.businessobjects.services.ResetPasswordRequest;
import com.f9g4.businessobjects.services.ResetPasswordResponse;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsRequest;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsResponse;
import com.f9g4.businessobjects.services.UpdateUserRequest;
import com.f9g4.businessobjects.services.UpdateUserResponse;
import com.f9g4.businessobjects.services.ValidateUserRequest;
import com.f9g4.businessobjects.services.ValidateUserResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.F9G4Hashing;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.CompanyNewsSDK;
import com.f9g4.servicesdk.DataCaptureServiceSDK;
import com.f9g4.servicesdk.MembershipServiceSDK;
import com.f9g4.servicesdk.NotificationQServiceSDK;
import com.f9g4.servicesdk.ReferralsServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.forms.ForgotPasswordForm;
import com.f9g4.web.forms.InvitationForm;
import com.f9g4.web.forms.LoginForm;
import com.f9g4.web.forms.ResetPwdForm;
import com.f9g4.web.forms.SeqAndPasswordForm;
import com.f9g4.web.forms.TermsAndConditionForm;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;
import com.f9g4.web.validator.SeqAndPasswordFormValidator;

@Controller
@SessionAttributes({"user", "userId", "uName", "secQs", "adUserDomain","isMembershipExpired","currTermsId", "loggedInUserUUID" ,"isUpdateMembership","isLoginFailed","securityQestions1_List","securityQestions2_List","timezoneOffset"})
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;
	
	@Autowired
	private CompanyNewsSDK companyNewsSDK;
	
	@Autowired
	private ReferralsServiceSDK referralServiceSDK;
	
	@Autowired
	private NotificationQServiceSDK notificationQServiceSDK;
	
	@Autowired
    private ServletContext servletContext;
	
	@Autowired @Value("${footer_linkedin_url}")
	private String footer_linkedin_url;
	
	@Autowired @Value("${footer_facebook_url}")
	private String footer_facebook_url;
	
	@Autowired @Value("${footer_twitter_url}")
	private String footer_twitter_url;
	
	@Autowired @Value("${footer_rssfeed_url}")
	private String footer_rssfeed_url;
	
	@Autowired @Value("${f9g4.webapp.key}")
	private String key;
	
	@Autowired
	private SeqAndPasswordFormValidator formValidator;
	
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
	
	@ModelAttribute("securityQestions1_List")
	public List<AdLookupValuesDomain> getSecurityQestions1List() {		
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.USER_SEC_QUESTION1.getTypeName()).getLookupTypeValues();
	}

	@ModelAttribute("securityQestions2_List")
	public List<AdLookupValuesDomain> getSecurityQestions2List() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.USER_SEC_QUESTION2.getTypeName()).getLookupTypeValues();
	}
	
	@Autowired
	private DataCaptureServiceSDK dataCaptureServiceSDK;
	
	private MessageSource msgSource;
	
	@Autowired  
    public void MsgController(MessageSource msgSource) {  
       this.msgSource = msgSource;  
    }
	
	@RequestMapping(value = "/user/login/panel", method = RequestMethod.GET)
	public String getLoginPanel(ModelMap model, @CookieValue(value="RememberMef4g",defaultValue="") String name) {
		
		return ViewNames.SPLASH_SCREEN;
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String getLoginForm(ModelMap model, @CookieValue(value="RememberMef4g",defaultValue="") String name) {
		logger.debug("Entry - getLoginForm");
		//ModelAndView model = new ModelAndView();
		/*LoginForm loginForm = new LoginForm();*/
		if(!name.equals("")){
			model.addAttribute("username", name);
			model.addAttribute("rememberme", true);
			/*loginForm.setUserName(name);
			loginForm.setRememberme(true);*/
		}
		else
		{
			model.addAttribute("username", "");
			model.addAttribute("password", "");
			model.addAttribute("rememberme", false);
			/*loginForm.setUserName("");
			loginForm.setPassword("");
			loginForm.setRememberme(true);*/
		}
		/*model.addAttribute("loginForm", loginForm);*/
		//model.setViewName("splashscreen");
		logger.debug("Exit - getLoginForm");
		//model.addAttribute("comapnynews", companyNewsSDK.getCompanyNews().getNews());
		return ViewNames.SPLASH_SCREEN;
	} 
	
	@RequestMapping(value = ViewPaths.LOGIN, method = RequestMethod.POST)
	public @ResponseBody ModelMap validateUser(@ModelAttribute("loginForm") LoginForm form, BindingResult result, HttpSession session, HttpServletResponse servletResponse, HttpServletRequest servletRequest,Model model) throws DatatypeConfigurationException {
		String serviceUnavailable = msgSource.getMessage("service.unavailable", null, null);
		logger.debug("Entry - validateUser");
		ValidateUserRequest request = new ValidateUserRequest();
		request.setPassword(F9G4Hashing.getHashValue(form.getPassword()));
		request.setUserName(form.getUserName());
		if(form.isRememberme()){
			Cookie saveCookie = new Cookie("RememberMef4g", form.getUserName());
			saveCookie.setMaxAge(7*60*60*24);
			//saveCookie.setPath(servletContext.getContextPath()); //set path for the context path so that the other pages can still retrieve the cookie value
			saveCookie.setPath("/"); //set path for the context path so that the other pages can still retrieve the cookie value
			servletResponse.addCookie(saveCookie);
		}
		else
		{
			Cookie saveCookie=new Cookie("RememberMef4g","");
			//saveCookie.setPath(servletContext.getContextPath());
			saveCookie.setPath("/");
			servletResponse.addCookie(saveCookie);
		}
		
		
		ModelMap modelMap = new ModelMap();
		if(result.hasErrors()){
			modelMap.put("hasError", true);
			modelMap.put("errors", result.getAllErrors());
		}else{
			logger.trace("ValidateUser : Calling API");
			ValidateUserResponse response =  registrationServiceSDK.validateUser(request);
			logger.trace("ValidateUser : Got the response");
			if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(response.getStatus().getStatuscode())){
				logger.trace("ValidateUser : Got the response, Validation successful");
				
				//check the user active status. If the active status is 0, disallow user to login.
				if(response.getUser().getActiveStatus()==ActiveStatusEnum.INACTIVE.value())
				{
					modelMap.put("hasError", true);
					result.rejectValue("userName", ErrorsCodeEnum.USER_AUTH_FAILED_INACTIVE.getCode(), null, ErrorsCodeEnum.USER_AUTH_FAILED_INACTIVE.getDefaultMessage());	
					modelMap.put("errors", result.getAllErrors());
					return modelMap;
				}
				modelMap.put("hasError", false);
				// keep in session..
				model.addAttribute("user", response.getUser());
				// Save timezone offset for display proper time
				model.addAttribute("timezoneOffset", form.getTimezoneOffset()/60);
					
				modelMap.put("termsExpired", response.isTermsExprired());
				modelMap.put("membershipExpired", response.isMembershipExprired());
				modelMap.put("termsId", response.getLatestTermsId());
				modelMap.put("userId", response.getUser().getUserId());
				
				AdUsersDomain user = response.getUser();
				//The condition is not used in the login flow. Used in membership payment flow.
				if(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode().equals(user.getRegisterStatusCode())
						|| LookupTypeValueEnum.REG_STATUS_REGSTRATION_COMPLETED.getTypeCode().equals(user.getRegisterStatusCode())){
					//user registration is completed, its update user membership. 
					modelMap.put("isUpdateMembership", true);					
				}else{
					modelMap.put("isUpdateMembership", false);
				}
				
				//Check the register status. If the status is 431 and the user type is designer, should redirect to sample submission.
				if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && user.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeCode()))
				{
					modelMap.put("needSamples", true);
				}
				else
				{
					modelMap.put("needSamples", false);
				}

				if(response.isMembershipExprired()==true || response.isTermsExprired()==true)
					model.addAttribute("isLoginFailed", true);
				else
					model.addAttribute("isLoginFailed", false);
				
				if(response.isMembershipExprired()==true && response.isTermsExprired()==true)
				{
					model.addAttribute("isMembershipExpired", true);
				}
				else
				{
					model.addAttribute("isMembershipExpired", false);
				}
				
				if(response.getUser().getIsTempPassword() == 1)
				{
					modelMap.put("needSetupSeqPassword", true);
					model.addAttribute("isLoginFailed", true); //if the temp password = 1, do not allow user to login
				}
				else
				{
					modelMap.put("needSetupSeqPassword", false);
					//check the security question setting for approved user. If both are null, ask user to setup.
					if(response.getUser().getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()) 
						&& response.getUser().getSecurityQuestion1() == 0 && StringUtils.isBlank(response.getUser().getSecurityAnswer1())
						&& response.getUser().getSecurityQuestion2() == 0 && StringUtils.isBlank(response.getUser().getSecurityAnswer2()))
					{
						modelMap.put("needSetupSeq", true);
						model.addAttribute("isLoginFailed", true); //do not allow user to login if the user do net setup the security settings.
					}
					else
						modelMap.put("needSetupSeq", false);
				}
					
				//add user record in database.
				String loggedInuserUUID = UUID.randomUUID().toString();
				model.addAttribute("loggedInUserUUID", loggedInuserUUID);
				AddUserLogRequest aduserLogRequest = new AddUserLogRequest();
				aduserLogRequest.setAction(Constants.ADD_USER_LOG_ACTION_CREATE);
				AdActiveUserDomain domain = new AdActiveUserDomain();
				domain.setUserId(response.getUser().getUserId());
				domain.setCreatedby(response.getUser().getUserId());
				domain.setLastupdateby(response.getUser().getUserId());
				domain.setLoginDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
				domain.setSessionId(loggedInuserUUID);
				aduserLogRequest.setUserLogger(domain);
				dataCaptureServiceSDK.logUserData(aduserLogRequest);
				
			}else{

				logger.trace("ValidateUser : Got the response, Validation failed");
				modelMap.put("hasError", true);
							
				if(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode().equals(response.getStatus().getStatuscode())){
					result.rejectValue("userName", ErrorsCodeEnum.INVALID_INPUT.getCode(), null, ErrorsCodeEnum.INVALID_INPUT.getDefaultMessage());	
				}
				
				if(StatusCodesEnum.STATUS_ERR_AUTH_FAILED.getCode().equals(response.getStatus().getStatuscode())){
					result.rejectValue("userName", ErrorsCodeEnum.USER_AUTH_FAILED.getCode(), null, ErrorsCodeEnum.USER_AUTH_FAILED.getDefaultMessage());	
				}
								
				if(StatusCodesEnum.STATUS_ERR_USER_NOT_FOUND.getCode().equals(response.getStatus().getStatuscode())){
					result.rejectValue("userName", ErrorsCodeEnum.USER_AUTH_FAILED.getCode(), null, ErrorsCodeEnum.USER_AUTH_FAILED.getDefaultMessage());
				}
				
				if(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode().equals(response.getStatus().getStatuscode())){
					result.rejectValue("userName", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode(), null, serviceUnavailable);
				}
				
				if(StatusCodesEnum.STATUS_ERR_REGISTRATION_DENIED.getCode().equals(response.getStatus().getStatuscode())){
					result.rejectValue("userName", ErrorsCodeEnum.USER_AUTH_FAILED_VETTING_FAILED.getCode(), null, ErrorsCodeEnum.USER_AUTH_FAILED_VETTING_FAILED.getDefaultMessage());
				}
				
				if(StatusCodesEnum.STATUS_ERR_REGISTRATION_VETTING_PROCESS.getCode().equals(response.getStatus().getStatuscode())){
					result.rejectValue("userName", ErrorsCodeEnum.USER_AUTH_FAILED_VETTING.getCode(), null, ErrorsCodeEnum.USER_AUTH_FAILED_VETTING.getDefaultMessage());
				}
				
				if(StatusCodesEnum.STATUS_ERR_NO_ACTIVE_TERMS.getCode().equals(response.getStatus().getStatuscode())){
					result.rejectValue("userName", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode(), null, serviceUnavailable);
				}
				
				modelMap.put("errors", result.getAllErrors());
			}
		}
		logger.debug("Exit - validateUser");
		return modelMap;
	}

	
	@RequestMapping(value="terms/{termsId}", method=RequestMethod.GET)
	public String getLatestTerms(@PathVariable("termsId") Integer termsId,  ModelMap model) {
		GetTermsConditionsResponse response = registrationServiceSDK.getTermsConditions(termsId);
		if(response.getStatus().getStatuscode().equalsIgnoreCase(StatusCodesEnum.STATUS_SUCCESS.getCode())){
			model.put("hasErrors", false);	
		}else{
			model.put("hasErrors", true);
		}
		
		model.put("termsId",termsId);
		model.addAttribute("terms", new String(response.getTermCondition().getDisplayedTerm()));
  		return "terms";
	}

	@RequestMapping(value="terms", method=RequestMethod.POST)
	public @ResponseBody ModelMap acceptTerms(@RequestParam("termsId") int termsId, @ModelAttribute("user") AdUsersDomain user, Model model) {
		ModelMap modelMap = new ModelMap();
		try {
			
			UpdateTermsAndConditionsRequest request = new UpdateTermsAndConditionsRequest();
			request.setUserId(user.getUserId());
			AdAccepttermsDomain adAccepttermsDomain = new AdAccepttermsDomain();
			adAccepttermsDomain.setAcceptanceDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
			adAccepttermsDomain.setUserId(user.getUserId());
			adAccepttermsDomain.setAcceptTermId(termsId);
			request.setAdAccepttermsDomain(adAccepttermsDomain);
			//update terms and condition...
			UpdateTermsAndConditionsResponse response = registrationServiceSDK.updateTermsAndConditions(request);			
			Status status = response.getStatus();
			if(status.getStatuscode().equalsIgnoreCase(StatusCodesEnum.STATUS_SUCCESS.getCode())){
				modelMap.put("hasErrors", false);	
			}else{
				modelMap.put("hasErrors", true);
			}
		} catch (DatatypeConfigurationException e) {
			logger.error("Exception occured",e);
			modelMap.put("hasErrors", true);
		}
  		return modelMap;
	}

	@RequestMapping(value = "/user/forgotpwd", method = RequestMethod.GET)
	public String forgotPassword(Model model) 
	{
		logger.trace("FORGET");
		model.addAttribute("forgotPwd", new ForgotPasswordForm());
		model.addAttribute("resetPwdForm", new ResetPwdForm());
		return "forgot_password";
	}
		
	@RequestMapping(value = "/user/questions", method = RequestMethod.GET)
	public @ResponseBody ModelMap getSecurityQuestions(@RequestParam("userName") String userName, Model model) {
		logger.debug("Entry - getSecurityQuestions");
		//Map<String, String> secQs = new HashMap<String, String>();
		ModelMap modelMap = new ModelMap();
		ForgotPasswordForm forgotPassForm = new ForgotPasswordForm();
		GetSecurityQuestionResponse response =  registrationServiceSDK.getSecurityQuestions(userName);
		if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(response.getStatus().getStatuscode()))
		{
			//both question are null. We use email to reset the email.
			if(null == response.getSecurityQuestion1() && null == response.getSecurityQuestion2())
			{
				modelMap.addAttribute("noSeqSettings", true);
				//the logic to setup the temp password
				ViewUserResponse viewUserResponse = registrationServiceSDK.viewUserByUserName(userName);
				AdUsersDomain user = viewUserResponse.getUser();
				if(viewUserResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					//Create 10 chars temp password
					String tempPassword = RandomStringUtils.random(10,true,true);
					//Hash the temp password to save to the database. And set TEMP_PASSWORD = 1
					UpdateUserRequest updateUserRequest = new UpdateUserRequest();
					user.setIsTempPassword(1);
					user.setPassword(F9G4Hashing.getHashValue(tempPassword));
					updateUserRequest.setUser(user);
					UpdateUserResponse updateUserResponse = registrationServiceSDK.updateUser(updateUserRequest);
					if(updateUserResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())) 
					{
						user=updateUserResponse.getUser();
						//Get Email templates
						GetEmailTemplateByCodeResponse template = notificationQServiceSDK.getEmailTemplateByCode(Constants.TEMPLATE_CODE_TEMP_PASSWORD);
						AddNotificationQRequest addNotificationQRequest = new AddNotificationQRequest();
						TrNotificationQDomain domain=new TrNotificationQDomain();
						domain.setFromEmail("support@fashionforglobe.com");
						domain.setFromUserId(2); //System user
						domain.setToEmail(user.getUserName());
						domain.setToUserId(user.getUserId());
						domain.setSubject(template.getSubject());
						String body=template.getBody();
						body=body.replace("$2", user.getFirstname()+" "+user.getLastname());
						body=body.replace("$3", tempPassword);
						domain.setBodyText(body); //send plain password to user
						domain.setEmailStatusId(LookupTypeValueEnum.EMAIL_STATUS_ID_READY_TO_SEND.getTypeId());
						addNotificationQRequest.setNotificationQ(domain);
						AddNotificationQResponse addNotifResponse = notificationQServiceSDK.addNotificationQ(addNotificationQRequest);
						if(addNotifResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())) {
							modelMap.addAttribute("hasError", false);
						}
						else {
							modelMap.addAttribute("hasError", true);
							modelMap.addAttribute("errorCode", ErrorsCodeEnum.ADMIN_SEND_EMAIL_FAILED.getCode());
							modelMap.addAttribute("errorDescription", ErrorsCodeEnum.ADMIN_SEND_EMAIL_FAILED.getDefaultMessage());
						}
					}
					else {
						modelMap.addAttribute("hasError", true);
						modelMap.addAttribute("errorCode", ErrorsCodeEnum.ADMIN_RESET_PASSWORD_FAILED.getCode());
						modelMap.addAttribute("errorDescription", ErrorsCodeEnum.ADMIN_RESET_PASSWORD_FAILED.getDefaultMessage());
					}
				}
				else
				{
					modelMap.addAttribute("hasError", true);
				}
			}
			else
			{
				modelMap.addAttribute("noSeqSettings", false);
				if(null != response.getSecurityQuestion1()){
					modelMap.addAttribute("Q1Id", response.getSecurityQuestion1().getQuestionId());
					modelMap.addAttribute("Q1val", response.getSecurityQuestion1().getDescription());
					forgotPassForm.setSecQ1id(response.getSecurityQuestion1().getQuestionId());
					forgotPassForm.setSecQ1Ans(response.getSecurityQuestion1().getDescription());
				}
				
				if(null != response.getSecurityQuestion2()){
					modelMap.addAttribute("Q2Id", response.getSecurityQuestion2().getQuestionId());
					modelMap.addAttribute("Q2val", response.getSecurityQuestion2().getDescription());
					forgotPassForm.setSecQ2id(response.getSecurityQuestion2().getQuestionId());
					forgotPassForm.setSecQ2Ans(response.getSecurityQuestion2().getDescription());
				}
			}
			
			model.addAttribute("uName", userName);
			model.addAttribute("forgotPwd", forgotPassForm);
			modelMap.addAttribute("hasError", false);
		}
		else
		{
			modelMap.addAttribute("hasError", true);
			
		}
		logger.debug("Exit - getSecurityQuestions");
		return modelMap;
	}

	@RequestMapping(value = "/user/forgotpwd", method = RequestMethod.POST)
	public @ResponseBody ModelMap submitSecurityQuestions(@ModelAttribute("uName") String userName, @ModelAttribute("forgotPwd") ForgotPasswordForm forgotPasswordForm, BindingResult results, Model model) {
		logger.debug("Entry - submitSecurityQuestions");
		ViewUserResponse response = registrationServiceSDK.viewUserByUserName(userName);
		AdUsersDomain adUserDomain = response.getUser();
		model.addAttribute("adUserDomain", adUserDomain);
		ModelMap modelMap = new ModelMap();
		//match security question
		/*boolean q1Mathced =adUserDomain.getSecurityQuestion1() == forgotPasswordForm.getSecQ1id()  &&  adUserDomain.getSecurityAnswer1().equalsIgnoreCase(forgotPasswordForm.getSecQ1Ans()); 
		boolean q2Mathced =adUserDomain.getSecurityQuestion2() == forgotPasswordForm.getSecQ2id()  &&  adUserDomain.getSecurityAnswer2().equalsIgnoreCase(forgotPasswordForm.getSecQ2Ans());*/
		//Match the hashed security answer (convert the user input to upper case first)
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		boolean q1Mathced=false;
		boolean q2Mathced=false;
		try
		{
			textEncryptor.setPassword(this.key);
			String decryptAns1=textEncryptor.decrypt(adUserDomain.getSecurityAnswer1());
			String decryptAns2=textEncryptor.decrypt(adUserDomain.getSecurityAnswer2());
			q1Mathced =adUserDomain.getSecurityQuestion1() == forgotPasswordForm.getSecQ1id()  &&  textEncryptor.decrypt(adUserDomain.getSecurityAnswer1()).equals(forgotPasswordForm.getSecQ1Ans().toUpperCase()); 
			q2Mathced =adUserDomain.getSecurityQuestion2() == forgotPasswordForm.getSecQ2id()  &&  textEncryptor.decrypt(adUserDomain.getSecurityAnswer2()).equals(forgotPasswordForm.getSecQ2Ans().toUpperCase());
			
			if(q1Mathced && q2Mathced)
			{
				modelMap.addAttribute("isSecQsMatched", true);
				modelMap.addAttribute("hasError", false);
				modelMap.addAttribute("resetpassword","reset_pwd");
			}
			else
				modelMap.addAttribute("hasError", true);
		}
		catch(Exception e)
		{
			modelMap.addAttribute("hasError", true);
		}
		
		logger.trace("isSecQsMatched :" + model.asMap().get("isSecQsMatched"));
	
		logger.debug("Exit - submitSecurityQuestions");
		
		return modelMap;
	}
	
	@RequestMapping(value = "/user/resetpwd", method = RequestMethod.POST)
	public @ResponseBody ModelMap resetPassword(@ModelAttribute("adUserDomain") AdUsersDomain adUserDomain, @ModelAttribute("resetPwdForm") ResetPwdForm resetPwdForm, BindingResult results, Model model ) {
		logger.debug("Entry - resetPassword");
		//Map<String, String> resetPwdResp  = new HashMap<String, String>();
		ModelMap map = new ModelMap();
		String responseStatusCode;
		if(resetPwdForm.getNewPwd().equals(resetPwdForm.getConfirmPwd()))
		{
			ResetPasswordRequest request = new ResetPasswordRequest();
			request.setNewPassword(F9G4Hashing.getHashValue(resetPwdForm.getNewPwd()));
			request.setUserId(adUserDomain.getUserId());
			ResetPasswordResponse response = registrationServiceSDK.resetPassword(request);
			responseStatusCode = response.getStatus().getStatuscode();
		}
		else
			responseStatusCode = StatusCodesEnum.STATUS_BRD_INVALID_INPUT.getCode();
			 //StatusCodesEnum.STATUS_SUCCESS.getCode()
		if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(responseStatusCode)){
			map.addAttribute("hasError", false);	
		}else{
			map.addAttribute("hasError", true);
		}
		logger.debug("Exit - resetPassword");
		
		return map;
	}
	
	@RequestMapping(value = ViewPaths.KEEP_SESSION_ALIVE, method=RequestMethod.GET)
	public @ResponseBody String keepSessionAlive()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.trace("Keep Session Alive"+dateFormat.format(date));
		return "OK";
	}
	
	//technically this should go into the terms and condition controller but then it was not bound to a session variable
	//hence because of logical ordering i have put this in login controller since it is bound with the session and this validation happens during login
	@RequestMapping(value="/user/terms",method=RequestMethod.GET)
	public String getlatestRegistraionTerms(@ModelAttribute(value="user") AdUsersDomain user,@RequestParam("termId") int termId, ModelMap model){
		GetTermsConditionsResponse request;
		
		//Here i am retrieving the latest terms and condition based on the whether the user being the Designer or the customer
		if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
			request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode() , LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode());
		else
			request = registrationServiceSDK.getLatestTermsConditions(LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode() , LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
		
		StTermConditionDomain stTermCondition = request.getTermCondition();
		byte[] Msg = stTermCondition.getDisplayedTerm();
		model.addAttribute("currTermsId", stTermCondition.getTermCondId());
		
		TermsAndConditionForm form = new TermsAndConditionForm();
		form.setAccept(false);
		form.setMessageTermsandCond(new String(Msg));
		model.addAttribute("terms",form);
		
		return ViewNames.TERMS;
	}
	
	@Autowired
	private MembershipServiceSDK membershipServiceSDK;

	@RequestMapping(value="/user/terms",method=RequestMethod.POST)
	public ModelAndView setlatestRegistraionTerms(@ModelAttribute(value="user") AdUsersDomain user,HttpServletRequest servRequest, @ModelAttribute(value="currTermsId") int currTermsId, @ModelAttribute(value="isMembershipExpired") boolean isMembershipExpired,@RequestParam("termId") int termId,TermsAndConditionForm form, Model model){
		ModelAndView view = new ModelAndView();
		if(form.isAccept()==false)
		{
			servRequest.getSession().invalidate();
			//return ViewNames.LOGIN_PAGE;
		}
		
		//AdAccepttermsDomain usertermsDomain =  user.getAcceptedTermsCondition().get(0);
		UpdateTermsAndConditionsRequest request = new UpdateTermsAndConditionsRequest();
		AdAccepttermsDomain termsDomain = new AdAccepttermsDomain();
		XMLGregorianCalendar curDate = null;
		try{
			Calendar calendar  = Calendar.getInstance();
			curDate = XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(calendar); //UTC time
		}catch(Exception ex){logger.error("Error in XML Georgian Calender Type conversion !!");}
		
		termsDomain.setAcceptanceDate(curDate);
		termsDomain.setUserId(user.getUserId());
		termsDomain.setTermConditionId(currTermsId);
		
		request.setAdAccepttermsDomain(termsDomain);
		request.setUserId(user.getUserId());
		
		registrationServiceSDK.updateTermsAndConditions(request);
		
		if(isMembershipExpired==true){
			GetMembershipdetailsResponse membershipdetailsResponse = membershipServiceSDK.getMembershipdetails(user.getUserId());
			AdUserMembershipDomain adUserMembership = membershipdetailsResponse.getAdUserMembership();
			if(null != adUserMembership){
				Calendar today = Calendar.getInstance(); //UTC time
				Calendar expirationDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adUserMembership.getExperiationDate()); //UTC time
				if(null != expirationDate){
					//boolean isPaymentDue  = expirationDate.compareTo(today) > 0 ? true : false;
					boolean isPaymentDue  = expirationDate.compareTo(today) < 0 ? true : false;
					model.addAttribute("isPaymentDue", isPaymentDue);
				}
				model.addAttribute("expDate", expirationDate.getTime());
				model.addAttribute("membershipPrice", adUserMembership.getMembershipPrice());
				
				if(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode().equals(user.getRegisterStatusCode())
						|| LookupTypeValueEnum.REG_STATUS_REGSTRATION_COMPLETED.getTypeCode().equals(user.getRegisterStatusCode())){
					//user registration is completed, its update user membership. 
					model.addAttribute("isUpdateMembership", true);					
				}else{
					model.addAttribute("isUpdateMembership", false);
				}
			}
			//return ViewNames.MEMBERSHIP_PAYMENT;
			//put userId
			model.addAttribute("userId", user.getUserId());
			view = new ModelAndView(ViewNames.MEMBERSHIP_PAYMENT);
			return view;
		}
		
		model.addAttribute("isLoginFailed", false); //update the flag, or it will stop login to console.
		RedirectView rv=new RedirectView(ViewPaths.CONSOLE_HOME,true,true,false);
		view = new ModelAndView(rv);
		return view;
	}
	
	@RequestMapping(value=ViewPaths.INVITATION_FORM,method=RequestMethod.GET)
	public String showInvitationForm()
	{
		
		return ViewNames.INVITATION_FORM;
	}
	
	@RequestMapping(value=ViewPaths.INVITATION_FORM,method=RequestMethod.POST)
	public @ResponseBody ModelMap submitInvitationForm(@Valid InvitationForm formBean, BindingResult result)
	{
		//TODO write into tr_referrals database.
		ModelMap model=new ModelMap();
		if(result.hasErrors())
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorDetail", result.getAllErrors());
		}
		else
		{
			TrReferralsDomain domain=new TrReferralsDomain();
			domain.setSentUserId(1); //SYSTEM user ID, so that any user can't find this record from tr_referrals table.
			domain.setFirstName(formBean.getFirstname());
			domain.setLastName(formBean.getLastname());
			//Set data to phone--------------------//
			domain.setEmail(formBean.getEmail());
			domain.setWhyRefer("Refer by self");
			domain.setMessage(formBean.getComment_remarks());
			domain.setPhone(formBean.getPhone());
			try 
			{
				//set expiration date
				//add the expiration days for 60 days from sysday
				Calendar day=Calendar.getInstance();
				day.add(Calendar.DAY_OF_MONTH, +60); //add 60 days
				domain.setExpirationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(day)); //UTC time
			} 
			catch (DatatypeConfigurationException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			domain.setAuthCode("");
			
			AddReferralsRequest request=new AddReferralsRequest();
			request.setReferrals(domain);
			AddReferralsResponse response=new AddReferralsResponse();
			response=referralServiceSDK.addReferrals(request);
			
			if(response.getStatus().getStatuscode().equals("0"))
			{
				model.addAttribute("hasError", false);
				model.addAttribute("firstname", formBean.getFirstname());
				model.addAttribute("lastname", formBean.getLastname());
			}
			else
			{
				model.addAttribute("hasError", true);
				result.addError(new ObjectError(ErrorsCodeEnum.INVITATION_SUBMIT_FAILED.getDefaultMessage(),""));
				model.addAttribute("errorDetail", result.getAllErrors());
			}
		}
		return model;
	}
	
	//new setup password flow
	@RequestMapping(value = ViewPaths.SETUP_SEQ_PASSWORD, method = RequestMethod.GET)
	public String setupSeqPassword(@ModelAttribute("user") AdUsersDomain user, @RequestParam(value="setupSeq", defaultValue="true") Boolean setupSeq, @RequestParam(value="setupPwd", defaultValue="true") Boolean setupPwd, Model model) 
	{
		logger.trace("SEQ AND PASSWORD");
		model.addAttribute("setupSeq",setupSeq);
		model.addAttribute("setupPwd",setupPwd);
		model.addAttribute("seqPasswordForm",new SeqAndPasswordForm());
		return ViewNames.SETUP_SEQ_PASSWORD;
	}
	
	//new setup password flow
	@RequestMapping(value = ViewPaths.SETUP_SEQ_PASSWORD, method = RequestMethod.POST)
	public @ResponseBody ModelMap submitSeqPassword(@ModelAttribute("seqPasswordForm") SeqAndPasswordForm form, BindingResult result, @RequestParam(value="setupSeq", defaultValue="true") Boolean setupSeq, @RequestParam(value="setupPwd", defaultValue="true") Boolean setupPwd, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		form.setSetupSeq(setupSeq);
		form.setSetupPwd(setupPwd);
		map.addAttribute("setupSeq",setupSeq);
		map.addAttribute("setupPwd",setupPwd);
		formValidator.validate(form, result);
		logger.trace("SEQ AND PASSWORD");
		if(result.hasErrors())
		{
			map.addAttribute("hasError", true);
			map.addAttribute("errors", result.getAllErrors());
		}
		else
		{
			AdUsersDomain user = (AdUsersDomain)model.get("user");
			Integer userId = user.getUserId();
			
			//update the security set and password
			UpdateUserRequest request= new UpdateUserRequest();
			UpdateUserResponse response = new UpdateUserResponse();
			AdUsersDomain updateUser = request.getUser();
			updateUser = user;
			
			if(form.getSetupPwd())
			{
				//check the password that user entered is different from previous password
				if(user.getPassword().equals(F9G4Hashing.getHashValue(form.getResetPassword())))
				{
					map.addAttribute("hasError", true);
					result.addError(new ObjectError(ErrorsCodeEnum.SETUP_USING_PREVIOUS_PASSWORD.getCode(),ErrorsCodeEnum.SETUP_USING_PREVIOUS_PASSWORD.getDefaultMessage()));
					map.addAttribute("errors", result.getAllErrors());
					return map;
				}
				else
				{
					updateUser.setPassword(F9G4Hashing.getHashValue(form.getResetPassword()));
					updateUser.setIsTempPassword(0);
				}
			}
			if(form.getSetupSeq())
			{
				updateUser.setSecurityQuestion1(form.getSecurityQ1());
				//updateUser.setSecurityAnswer1(form.getSecurityQ1Value());
				updateUser.setSecurityQuestion2(form.getSecurityQ2());
				//updateUser.setSecurityAnswer2(form.getSecurityQ2Value());
				//convert to upper case and then hash the security answer
				BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
				textEncryptor.setPassword(this.key);
				updateUser.setSecurityAnswer1(textEncryptor.encrypt(form.getSecurityQ1Value().toUpperCase()));
				updateUser.setSecurityAnswer2(textEncryptor.encrypt(form.getSecurityQ2Value().toUpperCase()));
			}
			
			request.setUser(updateUser);
			response=registrationServiceSDK.updateUser(request);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				map.addAttribute("hasError", false);
				model.addAttribute("isLoginFailed", false); //once user setup the password, allow them to login.
			}
			else
			{
				map.addAttribute("hasError", true);
				result.addError(new ObjectError(ErrorsCodeEnum.SETUP_SEQ_PASSWORD_FAILED.getCode(),ErrorsCodeEnum.SETUP_SEQ_PASSWORD_FAILED.getDefaultMessage()));
				map.addAttribute("errors", result.getAllErrors());
			}		
		}
		return map;
	}
}
