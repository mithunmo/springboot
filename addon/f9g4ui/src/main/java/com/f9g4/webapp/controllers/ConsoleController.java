package com.f9g4.webapp.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.f9g4.businessobjects.domain.AdAddressDomain;
import com.f9g4.businessobjects.domain.AdContactsDomain;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUserDegaccsDomain;
import com.f9g4.businessobjects.domain.AdUserDocumentsDomain;
import com.f9g4.businessobjects.domain.AdUserEducationsDomain;
import com.f9g4.businessobjects.domain.AdUserExpertisesDomain;
import com.f9g4.businessobjects.domain.AdUserLanguagesDomain;
import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
import com.f9g4.businessobjects.domain.AdUserSkillsDomain;
import com.f9g4.businessobjects.domain.AdUserSpecialitiesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardSearchDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.domain.TrReferralsDomain;
import com.f9g4.businessobjects.services.AddPortfolioRequest;
import com.f9g4.businessobjects.services.AddPortfolioResponse;
import com.f9g4.businessobjects.services.AddReferralsRequest;
import com.f9g4.businessobjects.services.AddReferralsResponse;
import com.f9g4.businessobjects.services.BoardsViewed;
import com.f9g4.businessobjects.services.DesignWallBoardInfoDomain;
import com.f9g4.businessobjects.services.DesignerAccountDomain;
import com.f9g4.businessobjects.services.DrawerInfoResponse;
import com.f9g4.businessobjects.services.GetAlertsResponse;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetDesignWallBoardInfoResponse;
import com.f9g4.businessobjects.services.GetDesignerAccountResponse;
import com.f9g4.businessobjects.services.GetLookupTypeValuesForTypeResponse;
import com.f9g4.businessobjects.services.GetPortfolioByUserResponse;
import com.f9g4.businessobjects.services.GetRecentlyViewedBoardsResponse;
import com.f9g4.businessobjects.services.GetSeasonYearsResponse;
import com.f9g4.businessobjects.services.GetUserRatingRequest;
import com.f9g4.businessobjects.services.GetUserRatingResponse;
import com.f9g4.businessobjects.services.ResetPasswordRequest;
import com.f9g4.businessobjects.services.ResetPasswordResponse;
import com.f9g4.businessobjects.services.TrActivityDomain;
import com.f9g4.businessobjects.services.UpdateUserRequest;
import com.f9g4.businessobjects.services.UpdateUserResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.F9G4Hashing;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.PortfolioServiceSDK;
import com.f9g4.servicesdk.RatingServiceSDK;
import com.f9g4.servicesdk.ReferralsServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.Helper.GraphsData;
import com.f9g4.web.forms.ActivityGrid;
import com.f9g4.web.forms.BoardImageFilterResult;
import com.f9g4.web.forms.BoardImageForm;
import com.f9g4.web.forms.Cart;
import com.f9g4.web.forms.DesignerAccountForm;
import com.f9g4.web.forms.DesignerProfileForm;
import com.f9g4.web.forms.FeedbackForm;
import com.f9g4.web.forms.InvitationForm;
import com.f9g4.web.forms.MessageItem;
import com.f9g4.web.forms.ProfileForm;
import com.f9g4.web.forms.ResetPwdForm;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.TimeConvertUtil;
import com.f9g4.web.utils.UserNameUtil;
import com.f9g4.web.utils.UserProfileChecker;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.validator.DesignerProfileFormValidator;
import com.f9g4.web.validator.ProfileFormValidator;
//import com.f9g4.webapp.download.DownloadHelper;
import com.google.common.collect.Lists;
import com.googlecode.ehcache.annotations.Cacheable;

@Controller
@SessionAttributes({"user", "userId", "referralsList","cart", "languagesList",  "skillsList", "timezoneOffset", "profileScore","isVisibleDesigner"})
@RequestMapping("/console")
public class ConsoleController {

	private static final Logger logger = LoggerFactory.getLogger(ConsoleController.class);
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;
	
	@Autowired
	private RatingServiceSDK ratingsServiceSDK;
	
	@Autowired
	private ReferralsServiceSDK referralServiceSDK;
	
	@Autowired
	private ProfileFormValidator formValidator;
	
	@Autowired
	private DesignerProfileFormValidator designerProfileFormValidator;
	
	@Autowired
	private BoardServiceSDK boardServiceSDK;
	
	@Autowired
	private PortfolioServiceSDK portfolioServiceSDK;
	
	@Autowired @Value("${fileStore_ai}")
	private String profileLocation;
	
	//@Autowired @Value("${fileStore_zip}")
	//private String processLocation;
	
	//@Autowired @Value("${plmsplitterlocation}") 
	//private String plmsplitter;
	
	//@Autowired @Value("${ghostscriptlocation}") 
	//private String ghostscript;
	
	//@Autowired @Value("${plmsplitterparameters}") 
	//private String plmsplitterparameters;
	
	//@Autowired @Value("${plmsplitterparametersfordownload}") 
	//private String plmsplitterparametersForDownload;
	
	@Cacheable(cacheName="statesList")
	@ModelAttribute("statesList")
	public List<AdLookupValuesDomain> getStatesList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.US_STATES.getTypeName()).getLookupTypeValues();
	}
	
	@Cacheable(cacheName="countriesList")
	@ModelAttribute("countriesList")
	public List<AdLookupValuesDomain> getCountriesList()
	{
		//Make United State is the first record
		List<AdLookupValuesDomain> countries = new ArrayList<AdLookupValuesDomain>();
		countries.addAll(registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.ISO_COUNTRY.getTypeName()).getLookupTypeValues());
		for(int i=0;i<countries.size();i++)
		{
			if(countries.get(i).getLookupCode().equals(LookupTypeValueEnum.COUNTRY_US.getTypeCode()))
			{
				AdLookupValuesDomain usa = countries.get(i);
				countries.remove(i);
				countries.add(0, usa);
			}
		}
		return countries;
	}
	
	//Languages 
	@Cacheable(cacheName="languagesList")
	@ModelAttribute("languagesList")
	public List<AdLookupValuesDomain> getLanguagesList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.ISO_LANGUAGES.getTypeName()).getLookupTypeValues();
	}
	
	//Skills 
	@Cacheable(cacheName="skillsList")
	@ModelAttribute("skillsList")
	public List<AdLookupValuesDomain> getSkillsList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.USER_SKILLS.getTypeName()).getLookupTypeValues();
	}
	
	//education(schools)
	@ModelAttribute("educationsList")
	public List<AdLookupValuesDomain> getEducationsList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.EDUCATION.getTypeName()).getLookupTypeValues();
	}
	
	//specialty
	@ModelAttribute("specialtiesList")
	public List<AdLookupValuesDomain> getSpecialtiesList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeName()).getLookupTypeValues();
	}
	
	//expertise
	@ModelAttribute("expertisesList")
	public List<AdLookupValuesDomain> getExpertisesList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.AREA_OF_EXPERTISE.getTypeName()).getLookupTypeValues();
	}
	
	//degrees
	@ModelAttribute("degAccList")
	public List<AdLookupValuesDomain> getDegAccList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.DEGREE_ACCRED.getTypeName()).getLookupTypeValues();
	}
	
	//years of experience
	@ModelAttribute("yrsExpList")
	public List<AdLookupValuesDomain> getYrsExpList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.YRS_OF_EXP.getTypeName()).getLookupTypeValues();
	}
	
	@ModelAttribute("cart")
	public Cart getCartForm() {
		return new Cart();
	}
	
	@Autowired @Value("${footer_linkedin_url}")
	private String footer_linkedin_url;
	
	@Autowired @Value("${footer_facebook_url}")
	private String footer_facebook_url;
	
	@Autowired @Value("${footer_twitter_url}")
	private String footer_twitter_url;
	
	@Autowired @Value("${footer_rssfeed_url}")
	private String footer_rssfeed_url;
	
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
	
	@Autowired @Value("${f9g4.webapp.administrator}")
	private String adminUserIdChain; //The user who can use admin mode and admin mode can access from profile tab.
	
	@Autowired @Value("${f9g4.webapp.sse.duration}")
	private Integer sseDuration;
	
	@ModelAttribute("sseDuration")
	public Integer getSseDuration()
	{
		return this.sseDuration;
	}
	
	public boolean hasAdminMode(AdUsersDomain user)
	{
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
			return true;
		else
			return false;
	}
	
	private boolean isVisibleDesigner(TrPortfolioDomain domain)
	{
		int publishedBoards=0;
		if(domain.getSellable()==ActiveStatusEnum.INACTIVE.value() && domain.getActiveStatus()==ActiveStatusEnum.ACTIVE.value())
		{
			//check how many published boards. If it's more than 3, the user is visible.
			List<TrBoardDomain> pages = domain.getBoards();
			for(TrBoardDomain page : pages)
			{
				if(page.getPublishToMP() == Constants.PUBLISH_TO_MARKET_YES && page.getActiveStatus() == ActiveStatusEnum.ACTIVE.value())
					publishedBoards++;
			}
		}
		else
			return false;
		if(publishedBoards>=3)
			return true;
		return false;
	}
	
	@Autowired @Value("${f9g4.webapp.credit.conversion.usd}")
	private int creditConversionToUsd;
	
	@ModelAttribute("creditConversionToUsd")
	public int getCreditConversionToUsd()
	{
		return this.creditConversionToUsd;
	}

	@RequestMapping(value ="home", method=RequestMethod.GET)
	public String consoleDefaultHome(/*ServletRequest req, */@ModelAttribute(value="user") AdUsersDomain user, @ModelAttribute(value="cart") Cart cart,@ModelAttribute(value="timezoneOffset") Integer timezoneOffset, ModelMap modelMap)
	{
		/*HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		AdUsersDomain user = new AdUsersDomain();
		Cart cart = new Cart();
		try
		{
			user = (AdUsersDomain) session.getAttribute("user");
			cart = (Cart) session.getAttribute("cart");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		logger.debug("LOGIN");
		logger.debug("USER TYPE="+user.getUserMembership().size());
		String userType=user.getUserType();
		Date todaysDate = new Date();
		//keep this value in session
		modelMap.addAttribute("userId", user.getUserId());
		modelMap.addAttribute("userName",user.getFirstname()+" "+user.getLastname()); //put username on the header
		modelMap.addAttribute("logoImageUrl", user.getLogoimageurl());
		modelMap.addAttribute("cartItems", cart.getNumberOfItems());
		modelMap.addAttribute("cart", cart);
		modelMap.addAttribute("date",todaysDate );
		if(userType.equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
		{
			//calculate user's profile score
			UserProfileChecker profileChecker = new UserProfileChecker();
			Integer score=0;
			if(profileChecker.getProfileProgressInfo(user))
			{
				score = profileChecker.getScore();
			}
			modelMap.addAttribute("profileScore", score); //keep profile score in the session
			modelMap.put("hasAdminMode", false);
			
			//get unsellable portfolio id
			GetPortfolioByUserResponse response=portfolioServiceSDK.getUnsellablePortfoliobyUser(user.getUserId());
			//setup the designer visibility as false as default.
			modelMap.addAttribute("isVisibleDesigner", false);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				List<TrPortfolioDomain> domain=response.getPortfolio();
				if(domain.size()>0)
				{
					for(TrPortfolioDomain item : domain)
					{
						//get the first unsellable portfolio
						if(item.getSellable()==ActiveStatusEnum.INACTIVE.value() && item.getActiveStatus()==ActiveStatusEnum.ACTIVE.value())
						{
							modelMap.put("newPortfolioId", item.getPortfolioId());
							modelMap.put("newPortfolioIdError", false);
							//check the designer visibility and save the info in the session
							modelMap.addAttribute("isVisibleDesigner", isVisibleDesigner(item));
							break;
						}
					}
				}
				else
				{
					//create a unsellable portfolio as default
					AddPortfolioRequest addPortfolioRequest = new AddPortfolioRequest();
					TrPortfolioDomain trPortfolioDomain=new TrPortfolioDomain();
					addPortfolioRequest.setPortfolio(trPortfolioDomain);
					//setting data
					trPortfolioDomain.setUserId(user.getUserId());
					trPortfolioDomain.setName("Default Portfolio");
					trPortfolioDomain.setDescription("Default Portfolio for "+user.getFirstname()+" "+user.getLastname());
					GetCategoriesResponse level1 = registrationServiceSDK.getCategories(1, 0);
					//get available first level category value
					if(level1.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()) && level1.getStCategoryMasterDomain().size()>0)
					{
						//get available second level category value by level 1 id.
						GetCategoriesResponse level2 = registrationServiceSDK.getCategories(2, level1.getStCategoryMasterDomain().get(0).getCategoryId());
						if(level2.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()) && level2.getStCategoryMasterDomain().size()>0)
						{
							//get all seasons list
							GetSeasonYearsResponse seasons = registrationServiceSDK.getSeasonAllYears();
							if(seasons.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()) && seasons.getStSeasonYearDomains().size()>0)
							{
								trPortfolioDomain.setCategoryLevel1Id(level2.getStCategoryMasterDomain().get(0).getParentID()); //hardcoded. Use first available record
								trPortfolioDomain.setCategoryLevel2Id(level2.getStCategoryMasterDomain().get(0).getCategoryId()); //hardcoded. Use first available record
								trPortfolioDomain.setSeasonYearId(5); //hardcoded. Use 5 as default
								trPortfolioDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
								trPortfolioDomain.setLastupdateby(user.getUserId());
								trPortfolioDomain.setCreatedby(2);
								trPortfolioDomain.setLangCode(user.getLangCode());
								trPortfolioDomain.setSellable(ActiveStatusEnum.INACTIVE.value()); //Setup the portfolio as unsellable.
								AddPortfolioResponse addPortfolioResponse = portfolioServiceSDK.addPortfolio(addPortfolioRequest);
								if(addPortfolioResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
								{
									modelMap.put("newPortfolioId", addPortfolioResponse.getPortfolio().getPortfolioId());
									modelMap.put("newPortfolioIdError", false);
								}
								else
									modelMap.put("newPortfolioIdError", true);
							}
							else
								modelMap.put("newPortfolioIdError", true);
						}
						else
							modelMap.put("newPortfolioIdError", true);
					}
					else
						modelMap.put("newPortfolioIdError", true);
				}
			}
			else
			{
				//Error handling
				modelMap.put("newPortfolioIdError", true);
			}
			
			if(user.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()) && score>=100)
				return ViewNames.CONSOLE_HOME_DESIGNER;
			else //The reg status is not approved or the profile score is not 100. Show limited access user UI.
				return ViewNames.CONSOLE_HOME_DESIGNER_LIMITED_ACCESS;
		}
		else
		{
			modelMap.put("hasAdminMode", hasAdminMode(user));
			return ViewNames.CONSOLE_HOME_COMPANY;
		}
	}
	
	@RequestMapping(value ="compinfo", method=RequestMethod.GET)
	public String getCompanyInfo(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,@ModelAttribute(value="statesList")  List<AdLookupValuesDomain> statesList,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap modelMap){
 
		//retrieve the user information from DB
		ViewUserResponse response = registrationServiceSDK.viewUser(adUsersDomain.getUserId());
		AdUsersDomain user = response.getUser();
		
		ProfileForm profileForm = new ProfileForm();
		AdAddressDomain adAddressDomain = null;
		logger.debug("ADDRESS SIZE=>"+user.getAddress().size());
		if(user.getAddress().size() > 0)
		{
			adAddressDomain =  user.getAddress().get(0);
			profileForm.setAddress1(adAddressDomain.getAddressLine1());
			profileForm.setAddress2(adAddressDomain.getAddressLine2());
			profileForm.setCity(adAddressDomain.getCity());
			profileForm.setCountryId(adAddressDomain.getCountryId());
			profileForm.setCountryName(adAddressDomain.getCountryName());
			//Pravin -> to set the State to description instead of code 
			profileForm.setState(getDescptionGivenadLookupvalueIdfromList(statesList,adAddressDomain.getState()));	
			profileForm.setZip(adAddressDomain.getPostalcode());
		}
		
		AdUserMembershipDomain adUserMembershipDomain =	null;
		if(user.getUserMembership().size() > 0)
		{
			adUserMembershipDomain =	user.getUserMembership().get(0);
			//convert to local time
			profileForm.setDue(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberExpires(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberSince(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getEffectiveDate(), timezoneOffset).toGregorianCalendar().getTime());
			/*profileForm.setDue(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberExpires(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberSince(adUserMembershipDomain.getEffectiveDate().toGregorianCalendar().getTime());*/
		}
		
		AdContactsDomain adContactsDomain = null;
		if(user.getContacts().size() > 0)
		{
			adContactsDomain =  user.getContacts().get(0);
			profileForm.setCellPhone(adContactsDomain.getCellphone());
			profileForm.setPhone(adContactsDomain.getWorkphone());
			profileForm.setExt(adContactsDomain.getWorkext());
			profileForm.setFax(adContactsDomain.getFax());
		}
		profileForm.setFirstName(user.getFirstname());
		profileForm.setLastName(user.getLastname());
		profileForm.setWebsite(user.getCompanywebsite());
		profileForm.setCompanyName(user.getCompanyname());
		profileForm.setLogoImageUrl(user.getLogoimageurl());
		
		modelMap.put("compProfile", profileForm);
		modelMap.put("hasAdminMode", hasAdminMode(user));
		return "company_profile";
	}	

	private String getDescptionGivenadLookupvalueIdfromList(
			List<AdLookupValuesDomain> statesList, String state) {
		//Pravin added this code to loop through the States List and then Display the correct State 
		//I have done a exception handling incase of number format exception it will display which ever text is in the DB
		try
		{
			for (AdLookupValuesDomain adLookupValuesDomain : statesList) {
				if(adLookupValuesDomain.getLookupValueId()==Integer.parseInt(state))
				{
					return adLookupValuesDomain.getDescription();
				}
			}
		}catch(Exception e){
			//do nothing by default return the state which comes in
		}
		return state;
	}

	@RequestMapping(value ="editcompinfo", method=RequestMethod.GET)
	public String getEditCompanyInfo(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap modelMap){
 
		ProfileForm profileForm = new ProfileForm();
		
		AdAddressDomain adAddressDomain = null;
		logger.debug("ADDRESS SIZE=>"+adUsersDomain.getAddress().size());
		if(adUsersDomain.getAddress().size() > 0)
		{
			adAddressDomain =  adUsersDomain.getAddress().get(0);
			
			profileForm.setAddress1(adAddressDomain.getAddressLine1());
			profileForm.setAddress2(adAddressDomain.getAddressLine2());
			profileForm.setCity(adAddressDomain.getCity());
			profileForm.setCountryId(adAddressDomain.getCountryId());
			profileForm.setCompanyName(adAddressDomain.getCountryName());
			profileForm.setState(adAddressDomain.getState());
			profileForm.setZip(adAddressDomain.getPostalcode());
		}
		
		AdUserMembershipDomain adUserMembershipDomain =	null;
		if(adUsersDomain.getUserMembership().size() > 0)
		{
			adUserMembershipDomain = adUsersDomain.getUserMembership().get(0);
			//convert to local time
			profileForm.setDue(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberExpires(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberSince(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getEffectiveDate(), timezoneOffset).toGregorianCalendar().getTime());
			/*profileForm.setDue(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberExpires(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberSince(adUserMembershipDomain.getEffectiveDate().toGregorianCalendar().getTime());*/
		}
		
		AdContactsDomain adContactsDomain = null;
		if(adUsersDomain.getContacts().size() > 0)
		{
			adContactsDomain =  adUsersDomain.getContacts().get(0);
			profileForm.setCellPhone(adContactsDomain.getCellphone());
			profileForm.setPhone(adContactsDomain.getWorkphone());
			profileForm.setExt(adContactsDomain.getWorkext());
			profileForm.setFax(adContactsDomain.getFax());
		}
		profileForm.setFirstName(adUsersDomain.getFirstname());
		profileForm.setLastName(adUsersDomain.getLastname());
		profileForm.setWebsite(adUsersDomain.getCompanywebsite());
		profileForm.setCompanyName(adUsersDomain.getCompanyname());
		profileForm.setLogoImageUrl(adUsersDomain.getLogoimageurl());
		
		modelMap.put("compProfile", profileForm);
		
		return "edit_company_profile";
	}
	
	@RequestMapping(value ="editcompinfo", method=RequestMethod.POST)
	public @ResponseBody ModelMap submitEditCompanyInfo(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,ProfileForm profileForm,BindingResult result, ModelMap modelMap){
		
		formValidator.validate(profileForm, result);
		ModelMap model=new ModelMap();
		if(result.hasErrors()){
			logger.debug("hasErrors -  true" );
			model.put("hasError",true);
			model.put("errors", result.getAllErrors());
		}else{
			ViewUserResponse viewUserResponse = registrationServiceSDK.viewUser(adUsersDomain.getUserId());
			adUsersDomain = viewUserResponse.getUser();
			
			AdAddressDomain adAddressDomain = null;
			if(adUsersDomain.getAddress().size() > 0)
			{
				adAddressDomain =  adUsersDomain.getAddress().get(0);
				adAddressDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				adAddressDomain.setAddressLine1(profileForm.getAddress1());
				adAddressDomain.setAddressLine2(profileForm.getAddress2());
				adAddressDomain.setCity(profileForm.getCity());
				adAddressDomain.setCountryId(profileForm.getCountryId());
				adAddressDomain.setPostalcode(profileForm.getZip());
				adAddressDomain.setState(profileForm.getState());
			}
			
			AdContactsDomain adContactsDomain = null;
			if(adUsersDomain.getContacts().size() > 0)
			{
				adContactsDomain =  adUsersDomain.getContacts().get(0);
				adContactsDomain.setCellphone(profileForm.getCellPhone());
				adContactsDomain.setFax(profileForm.getFax());
				adContactsDomain.setWorkext(profileForm.getExt());
				adContactsDomain.setWorkphone(profileForm.getPhone()); //Try to get the work phone -C
			}
			adUsersDomain.setFirstname(profileForm.getFirstName());
			adUsersDomain.setLastname(profileForm.getLastName());
			adUsersDomain.setCompanywebsite(profileForm.getWebsite());
			adUsersDomain.setCompanyname(profileForm.getCompanyName());
			adUsersDomain.setLogoimageurl(profileForm.getLogoImageUrl());
			
			UpdateUserRequest request = new UpdateUserRequest();
			request.setUser(adUsersDomain);
			UpdateUserResponse response=registrationServiceSDK.updateUser(request);

			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				//Pravin added this code to update the session value of user since it contains inconsistent data
				modelMap.put("user", adUsersDomain);
				model.addAttribute("hasError", false);
				model.put("userFirstName", adUsersDomain.getFirstname());
				model.put("userLastName", adUsersDomain.getLastname());
				model.put("userLogo",adUsersDomain.getLogoimageurl());
				model.put("errorCode", response.getStatus().getStatuscode());
				model.put("errorDescription", response.getStatus().getDescription());
			}
			else
			{
				model.addAttribute("hasError", true);
				model.put("errorCode", response.getStatus().getStatuscode());
				model.put("errorDescription", response.getStatus().getDescription());
			}
		}
		return model;
	}	
	
	@RequestMapping(value ="designer", method=RequestMethod.GET)
	public String getDesignerInfo(@ModelAttribute(value="userId") int userId,@ModelAttribute(value="statesList")  List<AdLookupValuesDomain> statesList,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap modelMap){
		
		ViewUserResponse response = registrationServiceSDK.viewUser(userId);
		AdUsersDomain adUsersDomain = response.getUser();

		DesignerProfileForm profileForm = new DesignerProfileForm();
		logger.debug("VALUE=>"+adUsersDomain.toString());

		AdAddressDomain adAddressDomain = null;
		logger.debug("ADDRESS SIZE=>"+adUsersDomain.getAddress().size());
		if(adUsersDomain.getAddress().size() > 0)
		{
			logger.debug("FETCH ADDRESS");
			adAddressDomain =  adUsersDomain.getAddress().get(0);
			profileForm.setAddress1(adAddressDomain.getAddressLine1());
			profileForm.setAddress2(adAddressDomain.getAddressLine2());
			profileForm.setCity(adAddressDomain.getCity());
			profileForm.setCountryId(adAddressDomain.getCountryId());
			profileForm.setCountryName(adAddressDomain.getCountryName());
			//Pravin -> to set the State to description instead of code 
			profileForm.setState(getDescptionGivenadLookupvalueIdfromList(statesList,adAddressDomain.getState()));	
			profileForm.setZip(adAddressDomain.getPostalcode());
		}
		
		//TODO find how to get the correct membership
		AdUserMembershipDomain adUserMembershipDomain =	null;
		if(adUsersDomain.getUserMembership().size() > 0)
		{
			adUserMembershipDomain =	adUsersDomain.getUserMembership().get(0);
			//convert to local time
			profileForm.setDue(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberExpires(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberSince(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getEffectiveDate(), timezoneOffset).toGregorianCalendar().getTime());
			/*profileForm.setDue(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberExpires(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberSince(adUserMembershipDomain.getEffectiveDate().toGregorianCalendar().getTime());*/
		}
		
		AdContactsDomain adContactsDomain = null;
		if(adUsersDomain.getContacts().size() > 0)
		{
			adContactsDomain =  adUsersDomain.getContacts().get(0);
			profileForm.setCellPhone(adContactsDomain.getCellphone());
			profileForm.setPhone(adContactsDomain.getWorkphone());
			profileForm.setPhone_ext(adContactsDomain.getWorkext());
			profileForm.setFax(adContactsDomain.getFax());
		}

		profileForm.setAboutYou(adUsersDomain.getAboutYou());
		profileForm.setMisc(adUsersDomain.getSchoolawards());
	
		//convert AdUserLanguagesDomain to int and String array
		List<Integer> langIds = new ArrayList<Integer>();
		List<String> langNames = new ArrayList<String>();
		List<AdUserLanguagesDomain> adUserLanguagesDomains = adUsersDomain.getUserLangs();
		for (AdUserLanguagesDomain adUserLanguagesDomain : adUserLanguagesDomains) 
		{
			langIds.add(adUserLanguagesDomain.getLangId());
			langNames.add(adUserLanguagesDomain.getLangName());
		}
		//convert to array
		profileForm.setLanguagesId(langIds.toArray(new Integer[0]));
		profileForm.setLanguagesName(langNames.toArray(new String[0]));
		
		
		List<Integer> skillIds=new ArrayList<Integer>();
		List<String> skillNames=new ArrayList<String>();
		List<AdUserSkillsDomain> adUserSkillsDomains=adUsersDomain.getUseSkills();
		for(AdUserSkillsDomain adUserSkillsDomain : adUserSkillsDomains)
		{
			skillIds.add(adUserSkillsDomain.getSkillId());
			skillNames.add(adUserSkillsDomain.getSkillName());
		}
		profileForm.setSkillsId(skillIds.toArray(new Integer[0]));
		profileForm.setSkillsName(skillNames.toArray(new String[0]));
		
		//additional documents
		List<String> adoc_oname = new ArrayList<String>();
		List<String> adoc_type = new ArrayList<String>();
		List<String> adoc_iname = new ArrayList<String>();
		List<AdUserDocumentsDomain> adUserDocumentsDomains = adUsersDomain.getUserDocuments();
		for(AdUserDocumentsDomain adUserDocumentsDomain : adUserDocumentsDomains)
		{
			adoc_oname.add(adUserDocumentsDomain.getSourceFileURL());
			adoc_type.add(adUserDocumentsDomain.getFileType());
			adoc_iname.add(adUserDocumentsDomain.getFileName());
		}
		profileForm.setAdoc_oname(adoc_oname.toArray(new String[0]));
		profileForm.setAdoc_type(adoc_type.toArray(new String[0]));
		profileForm.setAdoc_iname(adoc_iname.toArray(new String[0]));
		
		profileForm.setLogoImageUrl(adUsersDomain.getLogoimageurl());
		profileForm.setFirstName(adUsersDomain.getFirstname());
		profileForm.setLastName(adUsersDomain.getLastname());
		profileForm.setCompanyName(adUsersDomain.getCompanyname());
		profileForm.setWebsite(adUsersDomain.getCompanywebsite());
		profileForm.setFinalName(adUsersDomain.getProfilename());
		modelMap.put("designerProfile", profileForm);
		modelMap.put("userDetail", adUsersDomain);
		//user profile scoring
		UserProfileChecker profileChecker = new UserProfileChecker();
		if(profileChecker.getProfileProgressInfo(adUsersDomain))
		{
			modelMap.addAttribute("score", profileChecker.getScore());
			modelMap.addAttribute("toDoList", profileChecker.getToDoList());
		}
		//if the reg status is not approved, means the user has limited access for the profile tab
		if(!adUsersDomain.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()) || profileChecker.getScore()<100)
		{
			modelMap.addAttribute("hasFullAccess", false);
		}
		else
			modelMap.addAttribute("hasFullAccess", true);
		return "designer_profile";
	}	

	@RequestMapping(value ="editdesignerinfo", method=RequestMethod.GET)
	public String getEditDesignerInfo(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap modelMap)
	{
		//refresh the list
		//modelMap.addAttribute("educationsList", this.getEducationsList());
		//modelMap.addAttribute("specialtiesList", this.getSpecialtiesList());
		List<AdLookupValuesDomain> expsList = this.getExpertisesList();
		modelMap.addAttribute("expertisesList", expsList);
		
		ViewUserResponse response = registrationServiceSDK.viewUser(adUsersDomain.getUserId());
		adUsersDomain = response.getUser(); //sync user object from database
		
		DesignerProfileForm profileForm = new DesignerProfileForm();
		
		AdAddressDomain adAddressDomain = null;
		if(adUsersDomain.getAddress().size() > 0)
		{
			adAddressDomain =  adUsersDomain.getAddress().get(0);
			
			profileForm.setAddress1(adAddressDomain.getAddressLine1());
			profileForm.setAddress2(adAddressDomain.getAddressLine2());
			profileForm.setCity(adAddressDomain.getCity());
			profileForm.setCountryId(adAddressDomain.getCountryId());
			profileForm.setCompanyName(adAddressDomain.getCountryName());
			profileForm.setState(adAddressDomain.getState());
			profileForm.setZip(adAddressDomain.getPostalcode());
		}
		
		AdUserMembershipDomain adUserMembershipDomain =	null;
		if(adUsersDomain.getUserMembership().size() > 0)
		{
			adUserMembershipDomain =	adUsersDomain.getUserMembership().get(0);
			//convert to local time
			profileForm.setDue(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberExpires(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getExperiationDate(), timezoneOffset).toGregorianCalendar().getTime());
			profileForm.setMemberSince(TimeConvertUtil.convertToLocalTime(adUserMembershipDomain.getEffectiveDate(), timezoneOffset).toGregorianCalendar().getTime());
			/*profileForm.setDue(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberExpires(adUserMembershipDomain.getExperiationDate().toGregorianCalendar().getTime());
			profileForm.setMemberSince(adUserMembershipDomain.getEffectiveDate().toGregorianCalendar().getTime());*/
		}
		
		AdContactsDomain adContactsDomain = null;
		if(adUsersDomain.getContacts().size() > 0)
		{
			adContactsDomain =  adUsersDomain.getContacts().get(0);
			profileForm.setCellPhone(adContactsDomain.getCellphone());
			profileForm.setPhone(adContactsDomain.getWorkphone());
			profileForm.setPhone_ext(adContactsDomain.getWorkext());
			profileForm.setFax(adContactsDomain.getFax());
		}
		profileForm.setAboutYou(adUsersDomain.getAboutYou());
		profileForm.setMisc(adUsersDomain.getSchoolawards());
		
		//convert AdUserLanguagesDomain to int and String array
		List<Integer> langIds = new ArrayList<Integer>();
		List<String> langNames = new ArrayList<String>();
		List<AdUserLanguagesDomain> adUserLanguagesDomains = adUsersDomain.getUserLangs();
		for (AdUserLanguagesDomain adUserLanguagesDomain : adUserLanguagesDomains) 
		{
			langIds.add(adUserLanguagesDomain.getLangId());
			langNames.add(adUserLanguagesDomain.getLangName());
		}
		//convert to array
		profileForm.setLanguagesId(langIds.toArray(new Integer[0]));
		profileForm.setLanguagesName(langNames.toArray(new String[0]));
					
		List<Integer> skillIds=new ArrayList<Integer>();
		List<String> skillNames=new ArrayList<String>();
		List<AdUserSkillsDomain> adUserSkillsDomains=adUsersDomain.getUseSkills();
		for(AdUserSkillsDomain adUserSkillsDomain : adUserSkillsDomains)
		{
			skillIds.add(adUserSkillsDomain.getSkillId());
			skillNames.add(adUserSkillsDomain.getSkillName());
		}
		profileForm.setSkillsId(skillIds.toArray(new Integer[0]));
		profileForm.setSkillsName(skillNames.toArray(new String[0]));
		
		//additional documents
		List<Integer> adoc_id = new ArrayList<Integer>();
		List<String> adoc_oname = new ArrayList<String>();
		List<String> adoc_type = new ArrayList<String>();
		List<String> adoc_iname = new ArrayList<String>();
		List<AdUserDocumentsDomain> adUserDocumentsDomains = adUsersDomain.getUserDocuments();
		for(AdUserDocumentsDomain adUserDocumentsDomain : adUserDocumentsDomains)
		{
			adoc_id.add(adUserDocumentsDomain.getDocId());
			adoc_oname.add(adUserDocumentsDomain.getSourceFileURL());
			adoc_type.add(adUserDocumentsDomain.getFileType());
			adoc_iname.add(adUserDocumentsDomain.getFileName());
		}
		profileForm.setAdoc_id(adoc_id.toArray(new Integer[0]));
		profileForm.setAdoc_oname(adoc_oname.toArray(new String[0]));
		profileForm.setAdoc_type(adoc_type.toArray(new String[0]));
		profileForm.setAdoc_iname(adoc_iname.toArray(new String[0]));
		
		profileForm.setLogoImageUrl(adUsersDomain.getLogoimageurl());
		profileForm.setFirstName(adUsersDomain.getFirstname());
		profileForm.setLastName(adUsersDomain.getLastname());
		profileForm.setCompanyName(adUsersDomain.getCompanyname());
		profileForm.setWebsite(adUsersDomain.getCompanywebsite());
				
		// 05192014 Fred new logic to support multi-values for the new columns.
		// education
		List<Integer> educationIds=new ArrayList<Integer>();
		List<AdUserEducationsDomain> adUserEducationsDomains=adUsersDomain.getEducation();
		for(AdUserEducationsDomain adUserEducationsDomain : adUserEducationsDomains)
		{
			educationIds.add(adUserEducationsDomain.getEducationId());
		}
		profileForm.setEducationId(educationIds.toArray(new Integer[0]));
		
		// expertise
		List<Integer> expertiseIds=new ArrayList<Integer>();
		List<AdUserExpertisesDomain> adUserExpertiseDomains=adUsersDomain.getExpertise();
		for(AdUserExpertisesDomain adUserExpertiseDomain : adUserExpertiseDomains)
		{
			expertiseIds.add(adUserExpertiseDomain.getExpertiseId());
		}
		profileForm.setExpertiseId(expertiseIds.toArray(new Integer[0]));
		
		// specialty
		List<Integer> specialtyIds=new ArrayList<Integer>();
		List<AdUserSpecialitiesDomain> adUserSpecialtyDomains=adUsersDomain.getSpecialty();
		for(AdUserSpecialitiesDomain adUserSpecialtyDomain : adUserSpecialtyDomains)
		{
			specialtyIds.add(adUserSpecialtyDomain.getSpecialitiesId());
		}
		profileForm.setSpecialtyId(specialtyIds.toArray(new Integer[0]));
		
		// deg acc
		List<Integer> degAccIds=new ArrayList<Integer>();
		List<AdUserDegaccsDomain> adUserDegAccDomains=adUsersDomain.getDegAcc();
		for(AdUserDegaccsDomain adUserDegAccDomain : adUserDegAccDomains)
		{
			degAccIds.add(adUserDegAccDomain.getDegaccsId());
		}
		profileForm.setDegAccId(degAccIds.toArray(new Integer[0]));
		// ^^^ 05192014 Fred new logic to support multi-values for the new columns.
		
		if(adUsersDomain.getYrsExp()!=null)
			profileForm.setYrsExpId(adUsersDomain.getYrsExp().getLookupValueId());
		else
			profileForm.setYrsExpId(-1);
		profileForm.setCompaniesWorked(adUsersDomain.getCompaniesWorked());
		
		modelMap.put("designerProfile", profileForm);
		//user profile scoring
		UserProfileChecker profileChecker = new UserProfileChecker();
		if(profileChecker.getProfileProgressInfo(adUsersDomain))
		{
			modelMap.addAttribute("score", profileChecker.getScore());
			HashMap<String,Boolean> toDoHM = new LinkedHashMap<String, Boolean>();
			for(String item : profileChecker.getToDoList())
				toDoHM.put(item, true);
			modelMap.addAttribute("toDoHM", toDoHM);
			modelMap.addAttribute("fullToDoList", profileChecker.getFullToDoList());
		}
		//if the reg status is not approved, means the user has limited access for the edit profile tab
		if(!adUsersDomain.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()) || profileChecker.getScore()<100)
		{
			modelMap.addAttribute("hasFullAccess", false);
		}
		else
			modelMap.addAttribute("hasFullAccess", true);
		return "edit_designer_profile";
	}
	
	@RequestMapping(value ="editdesignerinfo", method=RequestMethod.POST)
	public @ResponseBody ModelMap submitEditDesignerInfo(DesignerProfileForm profileForm, BindingResult result, @ModelAttribute(value="user") AdUsersDomain adUsersDomain, @ModelAttribute(value="profileScore") Integer profileScore,ModelMap modelMap)
	{
		designerProfileFormValidator.validate(profileForm, result);
		ModelMap model=new ModelMap();
		if(result.hasErrors()){
			logger.debug("hasErrors -  true" );
			model.put("hasError",true);
			model.put("errors", result.getAllErrors());
		}else{
			logger.debug("RECEIVE DESIGNER PROFILE=>"+profileForm.toString());
			AdAddressDomain adAddressDomain = null;
			if(adUsersDomain.getAddress().size() > 0)
			{
				adAddressDomain = adUsersDomain.getAddress().get(0);
				adAddressDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				adAddressDomain.setAddressLine1(profileForm.getAddress1());
				adAddressDomain.setAddressLine2(profileForm.getAddress2());
				adAddressDomain.setCity(profileForm.getCity());
				adAddressDomain.setCountryId(profileForm.getCountryId());
				adAddressDomain.setPostalcode(profileForm.getZip());
				//if the state id is zero, use empty string.
				if(profileForm.getState()!=null && !profileForm.getState().equals("0"))
					adAddressDomain.setState(profileForm.getState());
				else
					adAddressDomain.setState("");
			}	
			
			//update contacts
			AdContactsDomain adContactsDomain = null;
			if(adUsersDomain.getContacts().size() > 0)
			{
				adContactsDomain =  adUsersDomain.getContacts().get(0);
				adContactsDomain.setCellphone(profileForm.getCellPhone());
				adContactsDomain.setWorkphone(profileForm.getPhone());
				adContactsDomain.setWorkext(profileForm.getPhone_ext());
				adContactsDomain.setFax(profileForm.getFax());
			}
			
			//update languages
			List<AdUserLanguagesDomain> adUserLanguagesDomainsListPointer = adUsersDomain.getUserLangs();
			
			adUserLanguagesDomainsListPointer.clear();
			Integer langs[] = profileForm.getLanguagesId();
			logger.trace("NEW LANGUAGEs SIZE list=>"+langs.length);
			for (Integer i : langs) 
			{
				AdUserLanguagesDomain adUserLanguagesDomain = new AdUserLanguagesDomain();
				adUserLanguagesDomain.setUserId(adUsersDomain.getUserId());
				adUserLanguagesDomain.setLangId(i);
				adUserLanguagesDomainsListPointer.add(adUserLanguagesDomain);
			}
			
			//update skills
			List<AdUserSkillsDomain> adUserSkillsDomainListPointer =  adUsersDomain.getUseSkills();
			adUserSkillsDomainListPointer.clear();
			Integer skills[] = profileForm.getSkillsId();
	
			for (Integer i : skills) {
				AdUserSkillsDomain adUserSkillsDomain = new AdUserSkillsDomain();
				adUserSkillsDomain.setUserId(adUsersDomain.getUserId());
				adUserSkillsDomain.setSkillId(i);
				adUserSkillsDomainListPointer.add(adUserSkillsDomain);
			}
			
			//update additional documents
			List<AdUserDocumentsDomain> adUserDocumentsDomainListPointer = adUsersDomain.getUserDocuments();
			adUserDocumentsDomainListPointer.clear();
			String adoc_oname[] = profileForm.getAdoc_oname();
			String adoc_type[] = profileForm.getAdoc_type();
			String adoc_iname[] = profileForm.getAdoc_iname();
			
			if(adoc_oname.length>0 && adoc_type.length>0 && adoc_iname.length>0)
			{
				for(Integer i=0;i<adoc_oname.length;i++)
				{
					AdUserDocumentsDomain item = new AdUserDocumentsDomain();
					item.setSourceFileURL(profileForm.getAdoc_oname()[i]);
					item.setFileType(profileForm.getAdoc_type()[i]);
					item.setFileName(profileForm.getAdoc_iname()[i]);
					item.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
					adUserDocumentsDomainListPointer.add(item);
				}
			}
			
			adUsersDomain.setFirstname(profileForm.getFirstName());
			adUsersDomain.setLastname(profileForm.getLastName());
			adUsersDomain.setCompanywebsite(profileForm.getWebsite());
			adUsersDomain.setCompanyname(profileForm.getCompanyName());
			adUsersDomain.setAboutYou(profileForm.getAboutYou());
			adUsersDomain.setSchoolawards(profileForm.getMisc());
			adUsersDomain.setLogoimageurl(profileForm.getLogoImageUrl());
			
			//new columns
			//05192014 Fred - change to multi-select value
			//update educations
			List<AdUserEducationsDomain> adUserEducationsDomainListPointer =  adUsersDomain.getEducation();
			adUserEducationsDomainListPointer.clear();
			Integer educations[] = profileForm.getEducationId();
			for (Integer i : educations) {
				if(i!=0)
				{
					AdUserEducationsDomain adUserEducationsDomain = new AdUserEducationsDomain();
					adUserEducationsDomain.setUserId(adUsersDomain.getUserId());
					adUserEducationsDomain.setEducationId(i);
					adUserEducationsDomainListPointer.add(adUserEducationsDomain);
				}
			}
			//Handle other value
			String otherEducations[] = profileForm.getOtherEducation();
			for(String temp : otherEducations) {
				AdUserEducationsDomain adUserEducationsDomain = new AdUserEducationsDomain();
				adUserEducationsDomain.setUserId(adUsersDomain.getUserId());
				adUserEducationsDomain.setEducationId(0);
				adUserEducationsDomain.setOther(temp);
				adUserEducationsDomain.setActiveStatus(ActiveStatusEnum.OTHERS.value());
				adUserEducationsDomainListPointer.add(adUserEducationsDomain);
			}
			
			//update expertise
			List<AdUserExpertisesDomain> adUserExpertisesDomainListPointer =  adUsersDomain.getExpertise();
			adUserExpertisesDomainListPointer.clear();
			Integer expertises[] = profileForm.getExpertiseId();
			for (Integer i : expertises) {
				if(i!=0)
				{
					AdUserExpertisesDomain adUserExpertisesDomain = new AdUserExpertisesDomain();
					adUserExpertisesDomain.setUserId(adUsersDomain.getUserId());
					adUserExpertisesDomain.setExpertiseId(i);
					adUserExpertisesDomainListPointer.add(adUserExpertisesDomain);
				}
			}
			//Handle other value
			String otherExpertises[] = profileForm.getOtherExpertise();
			for(String temp : otherExpertises) {
				AdUserExpertisesDomain adUserExpertisesDomain = new AdUserExpertisesDomain();
				adUserExpertisesDomain.setUserId(adUsersDomain.getUserId());
				adUserExpertisesDomain.setExpertiseId(0);
				adUserExpertisesDomain.setOther(temp);
				adUserExpertisesDomain.setActiveStatus(ActiveStatusEnum.OTHERS.value());
				adUserExpertisesDomainListPointer.add(adUserExpertisesDomain);
			}
			
			//update specialty
			List<AdUserSpecialitiesDomain> adUserSpecialtiesDomainListPointer =  adUsersDomain.getSpecialty();
			adUserSpecialtiesDomainListPointer.clear();
			Integer specialties[] = profileForm.getSpecialtyId();
			for (Integer i : specialties) {
				if(i!=0)
				{
					AdUserSpecialitiesDomain adUserSpecialtiesDomain = new AdUserSpecialitiesDomain();
					adUserSpecialtiesDomain.setUserId(adUsersDomain.getUserId());
					adUserSpecialtiesDomain.setSpecialitiesId(i);
					adUserSpecialtiesDomainListPointer.add(adUserSpecialtiesDomain);
				}
			}
			//Handle other value
			String otherSpecialties[] = profileForm.getOtherSpecialty();
			for(String temp : otherSpecialties) {
				AdUserSpecialitiesDomain adUserSpecialtiesDomain = new AdUserSpecialitiesDomain();
				adUserSpecialtiesDomain.setUserId(adUsersDomain.getUserId());
				adUserSpecialtiesDomain.setSpecialitiesId(0);
				adUserSpecialtiesDomain.setOther(temp);
				adUserSpecialtiesDomain.setActiveStatus(ActiveStatusEnum.OTHERS.value());
				adUserSpecialtiesDomainListPointer.add(adUserSpecialtiesDomain);
			}
			
			//update deg acc
			List<AdUserDegaccsDomain> adUserDegAccsDomainListPointer =  adUsersDomain.getDegAcc();
			adUserDegAccsDomainListPointer.clear();
			Integer degAccs[] = profileForm.getDegAccId();
			for (Integer i : degAccs) {
				AdUserDegaccsDomain adUserDegAccsDomain = new AdUserDegaccsDomain();
				adUserDegAccsDomain.setUserId(adUsersDomain.getUserId());
				adUserDegAccsDomain.setDegaccsId(i);
				adUserDegAccsDomainListPointer.add(adUserDegAccsDomain);
			}
			
			//years of experience
			if(profileForm.getYrsExpId()!=-1 && profileForm.getYrsExpId()!=0)
			{
				AdLookupValuesDomain yrsExp = new AdLookupValuesDomain();
				adUsersDomain.setYrsExp(yrsExp);
				yrsExp.setLookupValueId(profileForm.getYrsExpId());
				yrsExp.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
			}
			else
			{
				adUsersDomain.setYrsExp(null); //delete record
			}
			
			//companies worked
			if(!StringUtils.isBlank(profileForm.getCompaniesWorked()))
				adUsersDomain.setCompaniesWorked(profileForm.getCompaniesWorked());
			
			UpdateUserRequest request = new UpdateUserRequest();
			request.setUser(adUsersDomain);
			UpdateUserResponse response = registrationServiceSDK.updateUser(request);
			
			logger.trace("RESPONSE STATUS=>"+response.getStatus().getStatuscode()+" : "+response.getStatus().getDescription()); 
			
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				//Pravin added this code to update the session value of user since it contains inconsistent data
				modelMap.put("user", response.getUser());
				//get old profile score
				UserProfileChecker profileChecker = new UserProfileChecker();
				model.put("ucAccessChanged", false);
				//get update profile score
				if(profileChecker.getProfileProgressInfo(response.getUser()))
				{
					//If the user is the approved user and the current score and old score are changed between 90 and 100, the access of the console has to update. 
					if(response.getUser().getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()) && ((profileChecker.getScore()==100 && profileScore<100) || (profileChecker.getScore()<100 && profileScore==100)))
						model.put("ucAccessChanged", true);
				}
				model.put("hasError", false);
				model.put("userFirstName", adUsersDomain.getFirstname());
				model.put("userLastName", adUsersDomain.getLastname());
				model.put("userLogo",adUsersDomain.getLogoimageurl());
				model.put("errorCode", response.getStatus().getStatuscode());
				model.put("errorDescription", response.getStatus().getDescription());
				//update profileScore to the updated score in the session
				modelMap.put("profileScore", profileChecker.getScore());
			}
			else
			{
				model.put("hasError", true);
				model.put("errorCode", response.getStatus().getStatuscode());
				model.put("errorDescription", response.getStatus().getDescription());
			}
		}
		return model;
	}
	
	@RequestMapping(value ="alerts", method=RequestMethod.GET)
	public String getAlerts(@ModelAttribute(value="user") AdUsersDomain adUsersDomain, @ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap model){
		GetAlertsResponse response = registrationServiceSDK.getAlerts(adUsersDomain.getUserId(),true);
		
		ArrayList<MessageItem> alertHistory=new ArrayList<MessageItem>(); 
		for(TrMessagesDomain domain:response.getAlertMessages())
		{
			MessageItem item=new MessageItem();
			item.setToUserId(domain.getToUserId());
			item.setMessageBody(domain.getMessageBody());
			item.setSubject(domain.getSubject());
			Calendar creationDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getCreationDate()); //convert to Calendar
			//convert to local time
			creationDate=TimeConvertUtil.convertToLocalTime(creationDate, timezoneOffset);
			item.setCreationDate(creationDate.getTime());
			alertHistory.add(item);
		}
		model.addAttribute("alertHistory",alertHistory);
		
		return "console_alerts";
	}

	/*	private RegistrationForm convertAdUsersDomainToFormBeean(AdUsersDomain adUsersDomain){
		RegistrationForm 
	}
	*/
	
	/* Put referral functions back*/
	
	@RequestMapping(value ="sidebar", method=RequestMethod.GET)
	public String showSidebar(@ModelAttribute(value="user") AdUsersDomain adUsersDomain, ModelMap model)
	{
		DrawerInfoResponse response = boardServiceSDK.drawerInfo(adUsersDomain.getUserId());
		model.addAttribute("drawerInfo", response);
		//get rating value
		GetUserRatingRequest userRatingRequest = new GetUserRatingRequest();
		userRatingRequest.setUserId(adUsersDomain.getUserId());
		GetUserRatingResponse userRatingresponse = ratingsServiceSDK.getRatingforUser(userRatingRequest);
		model.addAttribute("average_rating", userRatingresponse.getAverageRating().getValue());
		//view
		if(adUsersDomain.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
		{
			convertPriceToCredit(response.getRecentActivity(),this.creditConversionToUsd);
			return "sidebar";
		}
		else
			return "sidebar_designer";
	}
	
	@RequestMapping(value ="download/{filenameuri}/{filetype}/{fileNametoStore}", method=RequestMethod.GET)
	public void downloadFile(@PathVariable("filenameuri") String file,@PathVariable("filetype") String filetype,@PathVariable("fileNametoStore") String fileNametoStore,HttpServletResponse response)
	{
		logger.debug("Pravin Trace -> Download file got the call !");
		//DownloadHelper to generate zip package
		/*
		DownloadHelper download = new DownloadHelper(profileLocation,processLocation,plmsplitter,ghostscript,plmsplitterparametersForDownload);
		String sanitizedFilename = FilenameUtils.removeExtension(this.fileNameFilter(fileNametoStore))+"."+filetype; //remove the special characters
		String sanitizedFilenameAsZip = FilenameUtils.removeExtension(this.fileNameFilter(fileNametoStore))+".zip"; //remove the special characters
		*/
		//JPG HAS BEEN HARD CODED HAS TO BE CHANGED!
		File filetoDownload = new File(profileLocation + file );
	    try {
	    	/* new login to compress file into zip
	    	InputStream is = null;
	    	if(filetype.toLowerCase().equals("jpg") || filetype.toLowerCase().equals("jpeg")) {
	    		is = new FileInputStream(filetoDownload);
	    		response.setHeader("Content-Disposition","attachment; filename=\""+sanitizedFilename+"\"");
	    	}
	    	else {
	    		boolean hasError = download.getDownloadStreamWithZip(file, sanitizedFilename);
	    		is = download.getInputStream();
	    		response.setHeader("Content-Disposition","attachment; filename=\""+sanitizedFilenameAsZip+"\"");
	    	}
		    //response.setContentLength((int)filetoDownload.getTotalSpace()); //Disabled this because it will give wrong file size information
		    IOUtils.copy(is, response.getOutputStream());
		    response.flushBuffer();
		    is.close(); //close file stream
		    if(filetype.toLowerCase().equals("ai"))
		    	download.cleanFiles(); //remove related files
			*/
			//current logic
			InputStream is = new FileInputStream(filetoDownload);
	      	//response.setContentLength((int)filetoDownload.getTotalSpace()); //Disabled this because it will give wrong file size information
	      	response.setHeader("Content-Disposition","attachment; filename=\""+fileNametoStore+"\"");
	      	IOUtils.copy(is, response.getOutputStream());
	      	response.flushBuffer();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    	throw new RuntimeException("IOError writing file to output stream");
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	@RequestMapping(value ="design_wall/{page}/{sort_column}/{sort_direction}", method=RequestMethod.GET)
	public String showDesignWall(@ModelAttribute(value="user") AdUsersDomain adUsersDomain, @PathVariable("page") int page,@PathVariable("sort_column") int sort_column,@PathVariable("sort_direction") int sort_direction,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		logger.debug("BEGIN OF DESIGNWALL=>"+page+"/"+sort_column+"/"+sort_direction);
		GetDesignWallBoardInfoResponse response=registrationServiceSDK.getDesignWallBoardInfo(adUsersDomain.getUserId(), (page)*10, 10, sort_column, sort_direction);

		logger.debug("DESIGNWALL CONTENT="+response.getBoards().size()+" ; Total Rows="+response.getTotalRows());
		
		model.addAttribute("totalBoards", response.getTotalRows());
		model.addAttribute("totalAmount", response.getTotalAmount());
		
		List<DesignWallBoardInfoDomain> boards = response.getBoards();
		List<BoardImageForm> boardImageForm = new ArrayList<BoardImageForm>();
		for (Iterator<DesignWallBoardInfoDomain> iterator = boards.iterator(); iterator.hasNext();) {
			DesignWallBoardInfoDomain designWallBoardInfoDomain = (DesignWallBoardInfoDomain) iterator.next();
			//convert to local time
			designWallBoardInfoDomain.setSellerPayDate(TimeConvertUtil.convertToLocalTime(designWallBoardInfoDomain.getSellerPayDate(), timezoneOffset));
			boardImageForm.add(new BoardImageForm(designWallBoardInfoDomain,profileLocation));
			
		}
		model.addAttribute("boardList",boardImageForm);
		model.addAttribute("page", page);
		model.addAttribute("sort_column", sort_column);
		model.addAttribute("sort_direction", sort_direction);
		
		
		double temp=Math.ceil(response.getTotalRows()/10.0);
		int totalPages=(int)temp;
		
		//pagination
		ArrayList<String> pageList=new ArrayList<String>();
		//page--;
		//show head pagin
		if(page==0)
			pageList.add("1&nbsp;");
		else
			pageList.add("<a href=\"#design_wall_0_"+sort_column+"_"+sort_direction+"\">1</a>&nbsp;");
		//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
		if(totalPages>2)
		{
			//show ... before current page
			if(page>=3)
				pageList.add("...&nbsp;");
			//show adajacent page
			if(page>=2)
				pageList.add("<a href=\"#design_wall_"+(page-1)+"_"+sort_column+"_"+sort_direction+"\">"+page+"</a>&nbsp;");
			//current page
			if(page!=0 && page!=totalPages-1)
				pageList.add((page+1)+"&nbsp;");
			//show adajacent page
			if(totalPages-page>=3)
				pageList.add("<a href=\"#design_wall_"+(page+1)+'_'+sort_column+"_"+sort_direction+"\">"+(page+2)+"</a>&nbsp;");
			//show ... after current page
			if(totalPages-page>=4)
				pageList.add("...&nbsp;");
		}
		//show tail pagin
		if(totalPages>=2)
		{
			if(page==totalPages-1)
				pageList.add(totalPages+"&nbsp;");
			else
				pageList.add("<a href=\"#design_wall_"+(totalPages-1)+'_'+sort_column+"_"+sort_direction+"\">"+totalPages+"</a>&nbsp;");
		}
		
		/*for(int i=1;i<=totalPages;i++)
		{
			//create the hash code
			pageList.add("#design_wall_"+i+"_"+sort_column+"_"+sort_direction);
		}*/
		model.addAttribute("pageList",pageList);
		//view
		return "design_wall";
	}
	
	@RequestMapping(value ="designer_account/{page}/{sort_column}/{sort_direction}", method=RequestMethod.GET)
	public String showDesignerAccount(@ModelAttribute(value="user") AdUsersDomain adUsersDomain, @PathVariable("page") int page,@PathVariable("sort_column") int sort_column,@PathVariable("sort_direction") int sort_direction,@ModelAttribute(value="timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		logger.debug("BEGIN OF DESIGNWALL=>"+page+"/"+sort_column+"/"+sort_direction);
		GetDesignerAccountResponse response=registrationServiceSDK.getDesignerAccountInfo(adUsersDomain.getUserId(), page*10, 10, sort_column, sort_direction);

		logger.debug("DESIGNWALL CONTENT="+response.getBoards().size()+" ; Total Rows="+response.getTotalRows());
		
		model.addAttribute("totalBoards", response.getTotalRows());
		model.addAttribute("totalAmount", response.getTotalAmount());
		
		List<DesignerAccountDomain> boards = response.getBoards();
		List<DesignerAccountForm> designerAccountForm = new ArrayList<DesignerAccountForm>();
		for (Iterator<DesignerAccountDomain> iterator = boards.iterator(); iterator.hasNext();) 
		{
			DesignerAccountDomain designWallBoardInfoDomain = (DesignerAccountDomain) iterator.next();
			//convert to local time
			designWallBoardInfoDomain.setDateSold(TimeConvertUtil.convertToLocalTime(designWallBoardInfoDomain.getDateSold(), timezoneOffset));
			designerAccountForm.add(new DesignerAccountForm(designWallBoardInfoDomain));
		}
		model.addAttribute("boardList",designerAccountForm);
		model.addAttribute("page", page);
		model.addAttribute("sort_column", sort_column);
		model.addAttribute("sort_direction", sort_direction);
		
		double temp=Math.ceil(response.getTotalRows()/10.0);
		int totalPages=(int)temp;
		
		//pagination
		ArrayList<String> pageList=new ArrayList<String>();
		//page--;
		//show head pagin
		if(page==0)
			pageList.add("1&nbsp;");
		else
			pageList.add("<a href=\"#designer_account_0_"+sort_column+"_"+sort_direction+"\">1</a>&nbsp;");
		//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
		if(totalPages>2)
		{
			//show ... before current page
			if(page>=3)
				pageList.add("...&nbsp;");
			//show adajacent page
			if(page>=2)
				pageList.add("<a href=\"#designer_account_"+(page-1)+"_"+sort_column+"_"+sort_direction+"\">"+page+"</a>&nbsp;");
			//current page
			if(page!=0 && page!=totalPages-1)
				pageList.add((page+1)+"&nbsp;");
			//show adajacent page
			if(totalPages-page>=3)
				pageList.add("<a href=\"#designer_account_"+(page+1)+'_'+sort_column+"_"+sort_direction+"\">"+(page+2)+"</a>&nbsp;");
			//show ... after current page
			if(totalPages-page>=4)
				pageList.add("...&nbsp;");
		}
		//show tail pagin
		if(totalPages>=2)
		{
			if(page==totalPages-1)
				pageList.add(totalPages+"&nbsp;");
			else
				pageList.add("<a href=\"#designer_account_"+(totalPages-1)+'_'+sort_column+"_"+sort_direction+"\">"+totalPages+"</a>&nbsp;");
		}
		
		/*for(int i=1;i<=totalPages;i++)
		{
			//create the hash code
			pageList.add("#design_wall_"+i+"_"+sort_column+"_"+sort_direction);
		}*/
		model.addAttribute("pageList",pageList);
		return ViewNames.ACCOUNT;
	}
	
	@RequestMapping(value ="activity_company", method=RequestMethod.GET)
	public String getCompanyActivity(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,ModelMap model)
	{
		//GetRecentlyViewedBoardsResponse response=boardServiceSDK.getRecentlyViewedBoards(adUsersDomain.getUserId(), 30, LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
		GetUserRatingRequest request = new GetUserRatingRequest();
		request.setUserId(adUsersDomain.getUserId());
		
		GetUserRatingResponse response = ratingsServiceSDK.getRatingforUser(request);
		
		//Get rating question set
		GetLookupTypeValuesForTypeResponse rate1 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION1.getTypeName());
		GetLookupTypeValuesForTypeResponse rate2 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION2.getTypeName());
		GetLookupTypeValuesForTypeResponse rate3 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION3.getTypeName());
		GetLookupTypeValuesForTypeResponse rate4 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION4.getTypeName());
		List<AdLookupValuesDomain> rate1Set = rate1.getLookupTypeValues();
		List<AdLookupValuesDomain> rate2Set = rate2.getLookupTypeValues();
		List<AdLookupValuesDomain> rate3Set = rate3.getLookupTypeValues();
		List<AdLookupValuesDomain> rate4Set = rate4.getLookupTypeValues();
		model.addAttribute("rate1", rate1Set);
		model.addAttribute("rate2", rate2Set);
		model.addAttribute("rate3", rate3Set);
		model.addAttribute("rate4", rate4Set);
		model.addAttribute("question1Type",LookupTypeValueEnum.RATING_QUALITY_OF_COMMUNICATION.getTypeCode());
		model.addAttribute("question2Type",LookupTypeValueEnum.RATING_DENPENDABILITY.getTypeCode());
		model.addAttribute("question3Type",LookupTypeValueEnum.RATING_EXPECTATIONS_FROM_YOU.getTypeCode());
		model.addAttribute("question4Type",LookupTypeValueEnum.RATING_PAYMENT_TERMS.getTypeCode());
		
		//TODO get overall rating value
		model.addAttribute("overallRating", response.getAverageRating().getValue());
				
		model.addAttribute("rating1", response.getQualityRating().getValue());	
		model.addAttribute("rating2", response.getPriceRating().getValue());
		model.addAttribute("rating3", response.getReliabilityRating().getValue());	
		model.addAttribute("rating4",response.getCustomizationRating().getValue());
		logger.debug("OVERALL="+response.getAverageRating().getValue());
		logger.debug("QUALITY="+response.getQualityRating().getValue());
		
		return "activity_company";
	}
	
	private List<TrActivityDomain> ConvertoActivityDesigner(
			List<TrActivityDomain> grid) {
		// TODO Auto-generated method stub
		List<TrActivityDomain> companyActivityList = new ArrayList<TrActivityDomain>();
		//Pravin assuming that board image url is going to be unique and using it as a key for getting the unique row counts 
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (TrActivityDomain trActivityDomain : grid) {
			String key = trActivityDomain.getBoardImageUrl();
			if(map.containsKey(key))
				map.put(key, map.remove(key)+1);
			else
				map.put(key, 1);
		}
		for (TrActivityDomain trActivityDomain : grid) {
			String key = trActivityDomain.getBoardImageUrl();
			if(map.containsKey(key))
			{
				TrActivityDomain temp = new TrActivityDomain();
				temp.setBoardId(trActivityDomain.getBoardId());
				temp.setBoardImageUrl(trActivityDomain.getBoardImageUrl());
				temp.setBoardName(trActivityDomain.getBoardName());
				temp.setBoard(trActivityDomain.getBoard());
				temp.setSeason(trActivityDomain.getSeason());
				temp.setPortfolioname(trActivityDomain.getPortfolioname());
				temp.setPrice(trActivityDomain.getPrice());
				temp.setNoofhits(map.get(key));
				companyActivityList.add(temp);
				map.remove(key);
			}
		}
		
		return companyActivityList;
	}

	@RequestMapping(value ="activity_designer", method=RequestMethod.GET)
	public String getDesignerActivity(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,ModelMap model)
	{
		//if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
		//GetRecentlyViewedBoardsResponse response=boardServiceSDK.getRecentlyViewedBoards(adUsersDomain.getUserId(), 30, LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode() );
		GetUserRatingRequest request = new GetUserRatingRequest();
		request.setUserId(adUsersDomain.getUserId());
		
		GetUserRatingResponse response = ratingsServiceSDK.getRatingforUser(request);
		
		//Get rating question set
		GetLookupTypeValuesForTypeResponse rate1 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION1.getTypeName());
		GetLookupTypeValuesForTypeResponse rate2 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION2.getTypeName());
		GetLookupTypeValuesForTypeResponse rate3 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION3.getTypeName());
		GetLookupTypeValuesForTypeResponse rate4 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION4.getTypeName());
		List<AdLookupValuesDomain> rate1Set = rate1.getLookupTypeValues();
		List<AdLookupValuesDomain> rate2Set = rate2.getLookupTypeValues();
		List<AdLookupValuesDomain> rate3Set = rate3.getLookupTypeValues();
		List<AdLookupValuesDomain> rate4Set = rate4.getLookupTypeValues();
		model.addAttribute("rate1", rate1Set);
		model.addAttribute("rate2", rate2Set);
		model.addAttribute("rate3", rate3Set);
		model.addAttribute("rate4", rate4Set);
		model.addAttribute("question1Type",LookupTypeValueEnum.RATING_QUALITY_OF_WORK.getTypeCode());
		model.addAttribute("question2Type",LookupTypeValueEnum.RATING_PRICING.getTypeCode());
		model.addAttribute("question3Type",LookupTypeValueEnum.RATING_RELIABILITY.getTypeCode());
		model.addAttribute("question4Type",LookupTypeValueEnum.RATING_CUSTOMIZATION.getTypeCode());
				
		//TODO get overall rating value	
		model.addAttribute("overallRating", response.getAverageRating().getValue());
		model.addAttribute("rating1", response.getQualityRating().getValue());	
		model.addAttribute("rating2", response.getPriceRating().getValue());
		model.addAttribute("rating3", response.getReliabilityRating().getValue());	
		model.addAttribute("rating4",response.getCustomizationRating().getValue());
		logger.debug("OVERALL="+response.getAverageRating().getValue());
		
		//List<TrBoardDomain> results=response.getBoards();
		//List<TrActivityDomain> activityGrid = ConvertoActivityCompnay(response.getGrid());
		//logger.debug("ACTIVITY SIZE="+results.get(0).toString());
		//model.addAttribute("activityList", results);
		//model.addAttribute("activityGrid", activityGrid);
		//model.addAttribute("boardCount", 0);
		return "activity_designer";
	}
	
	@RequestMapping(value ="chart/{days}", method=RequestMethod.GET)
	public @ResponseBody ModelMap getCharts(@ModelAttribute(value="user") AdUsersDomain adUsersDomain,@PathVariable("days") int numOfDays)
	{
		ModelMap map = new ModelMap();
		try{
			logger.debug("RECEIVE CHART "+numOfDays);
			GetRecentlyViewedBoardsResponse response=boardServiceSDK.getRecentlyViewedBoards(adUsersDomain.getUserId(), numOfDays,adUsersDomain.getUserType()); //Check with C GIRISH
			
			//Converting the incoming list into a map -> no zero counts will be present
			Map<Date,Integer> mapDateTime = getMap(response.getBoardsViewedByDate());
			//Adding the zero counts
			GraphsData counts = getCompleteCount(mapDateTime,numOfDays);
			
			String data = counts.getFormattedDate();
			String ticks = counts.getFormattedTicks(4);
			String pointLabels = counts.getFormattedPointLabels();
			logger.debug("CHART DATA="+data);
			map.put("data", data);
			map.put("ticks", ticks);
			map.put("pointLabels", pointLabels);
			List<TrActivityDomain> activityGrid;
			//Setting the Company/Customer Flag so that the corresponding grid can be loaded at runtime in java script
			if(adUsersDomain.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode())){
				map.put("userType","company");
				activityGrid = response.getGrid();
				}
			else{
				activityGrid = ConvertoActivityDesigner(response.getGrid());
				map.put("userType","designer");
			}
			
			List<ActivityGrid> activityGridBean = new ArrayList<ActivityGrid>();
			for (TrActivityDomain trActivityDomain : activityGrid) 
			{
				ActivityGrid temp =  new ActivityGrid(trActivityDomain);
				//update designer name
				if(adUsersDomain.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
					UserNameUtil.getDesignerName(temp, trActivityDomain);
				//determine to show board image or not by checking board status, original user, and current user.
				BoardImageFilterResult filterResult=this.boardImageFilter(trActivityDomain.getBoard(), adUsersDomain);
				if(filterResult.isShow())
				{
					temp.setShowImage(true);
				}
				else
				{
					temp.setShowImage(false);
					temp.setTypeCode(filterResult.getTypeCode());
					temp.setBoardImageUrl(""); //wipe out the image address
				}
				/*if(trActivityDomain.getBoard().getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId())
					temp.setShowImage(true);
				else if(trActivityDomain.getBoard().getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() || trActivityDomain.getBoard().getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId())
				{
					if(adUsersDomain.getUserId()==trActivityDomain.getBoard().getOriginalUserId() || adUsersDomain.getUserId()==trActivityDomain.getBoard().getCurrentUerId())
						temp.setShowImage(true);
					else
					{
						temp.setShowImage(false);
						//wipe out the image address
						temp.setBoardImageUrl("");
					}
				}
				else if(trActivityDomain.getBoard().getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeId())
				{
					if(adUsersDomain.getUserId()==trActivityDomain.getBoard().getLastupdateby() || adUsersDomain.getUserId()==trActivityDomain.getBoard().getOriginalUserId())
						temp.setShowImage(true);
					else
						temp.setShowImage(false);
				}
				else
					temp.setShowImage(true);*/
				activityGridBean.add(temp);
			}
			
			map.put("boardCount", activityGridBean.size());
			map.put("activityGrid", activityGridBean);
			map.put("hasError", false);
			
		}catch(Exception e){
			map.put("hasError", true);
		}
		return map;
	}
	
	@SuppressWarnings("deprecation")
	private GraphsData getCompleteCount(
			Map<Date, Integer> mapDateTime, int numOfDays) {
		List<Integer> hitCount = new ArrayList<Integer>();
		List<Date> date = new ArrayList<Date>();
		Calendar calDate = Calendar.getInstance();
		for (int i = 0; i < numOfDays; i++) {
			
			Date temp = calDate.getTime();
			//removing the time parameters and using only the date
			temp = new Date(temp.getYear(),temp.getMonth(),temp.getDate());
			date.add(temp);
			//System.out.println("day->"+temp.getDay()+"month->"+temp.getMonth());
			//System.out.println(temp.toLocaleString());
			if(mapDateTime.containsKey(temp))
			{
				hitCount.add(mapDateTime.get(temp));
			}
			else
				hitCount.add(0);
			calDate.add(Calendar.DATE, -1);
		}
		return new GraphsData(Lists.reverse(date), Lists.reverse(hitCount));
	}

	private Map<Date, Integer> getMap(List<BoardsViewed> list) {
		Map<Date,Integer> mapDateTimeMap = new HashMap<Date, Integer>();
		for (BoardsViewed boardsViewed : list) {
			mapDateTimeMap.put(boardsViewed.getDateViewed().toGregorianCalendar().getTime(), boardsViewed.getNumberOfBoards());
		}
		return mapDateTimeMap;
	}

	@RequestMapping(value ="userinfo", method=RequestMethod.GET)	
	public String showUserInfo(@RequestParam(value="profileUserName") String profileUserName,@RequestParam(value="profileUserId") Integer profileUserId,ModelMap model)
	{
		ViewUserResponse response=new ViewUserResponse();
		if(profileUserName!="")
			response=registrationServiceSDK.viewUserByUserName(profileUserName);
		else if(profileUserId!=null)
			response=registrationServiceSDK.viewUser(profileUserId);
		AdUsersDomain adUsersDomain=response.getUser();
		
		GetUserRatingRequest getRatingsRequest = new GetUserRatingRequest(adUsersDomain.getUserId());
		GetUserRatingResponse ratingResponse = ratingsServiceSDK.getRatingforUser(getRatingsRequest);
		//get rating question
		GetLookupTypeValuesForTypeResponse rate1 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION1.getTypeName());
		GetLookupTypeValuesForTypeResponse rate2 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION2.getTypeName());
		GetLookupTypeValuesForTypeResponse rate3 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION3.getTypeName());
		GetLookupTypeValuesForTypeResponse rate4 = registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.RATING_QUESTION4.getTypeName());
		List<AdLookupValuesDomain> rate1Set = rate1.getLookupTypeValues();
		List<AdLookupValuesDomain> rate2Set = rate2.getLookupTypeValues();
		List<AdLookupValuesDomain> rate3Set = rate3.getLookupTypeValues();
		List<AdLookupValuesDomain> rate4Set = rate4.getLookupTypeValues();
		model.addAttribute("rate1", rate1Set);
		model.addAttribute("rate2", rate2Set);
		model.addAttribute("rate3", rate3Set);
		model.addAttribute("rate4", rate4Set);
		
		//check user type
		if(adUsersDomain.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
		{
			//customer
			ProfileForm profileForm = new ProfileForm();
			AdAddressDomain adAddressDomain = adUsersDomain.getAddress().get(0);
			if(adUsersDomain.getAddress().size() > 0)
			{
				profileForm.setCountryName(adAddressDomain.getCountryName());
			}
			
			profileForm.setFirstName(adUsersDomain.getFirstname());
			profileForm.setLastName(adUsersDomain.getLastname());
			profileForm.setWebsite(adUsersDomain.getCompanywebsite());
			profileForm.setCompanyName(adUsersDomain.getCompanyname());
			profileForm.setLogoImageUrl(adUsersDomain.getLogoimageurl());
			
			//get question lookup code for customer
			model.addAttribute("question1Type",LookupTypeValueEnum.RATING_QUALITY_OF_COMMUNICATION.getTypeCode());
			model.addAttribute("question2Type",LookupTypeValueEnum.RATING_DENPENDABILITY.getTypeCode());
			model.addAttribute("question3Type",LookupTypeValueEnum.RATING_EXPECTATIONS_FROM_YOU.getTypeCode());
			model.addAttribute("question4Type",LookupTypeValueEnum.RATING_PAYMENT_TERMS.getTypeCode());
			//get ratings
			model.addAttribute("overallRating", ratingResponse.getAverageRating().getValue());
			model.addAttribute("rating1", ratingResponse.getQualityRating().getValue());	
			model.addAttribute("rating2", ratingResponse.getPriceRating().getValue());
			model.addAttribute("rating3", ratingResponse.getReliabilityRating().getValue());	
			model.addAttribute("rating4",ratingResponse.getCustomizationRating().getValue());
			
			model.addAttribute("userProfile", profileForm);
			model.addAttribute("userType", adUsersDomain.getUserType());
			return "company_info";
		}
		else
		{
			//designer
			DesignerProfileForm profileForm = new DesignerProfileForm();
			AdAddressDomain adAddressDomain = adUsersDomain.getAddress().get(0);
			if(adUsersDomain.getAddress().size() > 0)
			{
				profileForm.setCountryName(adAddressDomain.getCountryName());
			}
			
			profileForm.setFirstName(adUsersDomain.getFirstname());
			profileForm.setLastName(adUsersDomain.getLastname());
			profileForm.setWebsite(adUsersDomain.getCompanywebsite());
			profileForm.setCompanyName(adUsersDomain.getCompanyname());
			profileForm.setLogoImageUrl(adUsersDomain.getLogoimageurl());
			profileForm.setAboutYou(adUsersDomain.getAboutYou());
			profileForm.setMisc(adUsersDomain.getSchoolawards());
			
			//convert AdUserLanguagesDomain to int and String array
			List<Integer> langIds = new ArrayList<Integer>();
			List<String> langNames = new ArrayList<String>();
			List<AdUserLanguagesDomain> adUserLanguagesDomains = adUsersDomain.getUserLangs();
			for (AdUserLanguagesDomain adUserLanguagesDomain : adUserLanguagesDomains) 
			{
				langIds.add(adUserLanguagesDomain.getLangId());
				langNames.add(adUserLanguagesDomain.getLangName());
			}
			//convert to array
			profileForm.setLanguagesId(langIds.toArray(new Integer[0]));
			profileForm.setLanguagesName(langNames.toArray(new String[0]));
			
			List<Integer> skillIds=new ArrayList<Integer>();
			List<String> skillNames=new ArrayList<String>();
			List<AdUserSkillsDomain> adUserSkillsDomains=adUsersDomain.getUseSkills();
			for(AdUserSkillsDomain adUserSkillsDomain : adUserSkillsDomains)
			{
				skillIds.add(adUserSkillsDomain.getSkillId());
				skillNames.add(adUserSkillsDomain.getSkillName());
			}
			profileForm.setSkillsId(skillIds.toArray(new Integer[0]));
			profileForm.setSkillsName(skillNames.toArray(new String[0]));
			profileForm.setFinalName(UserNameUtil.getDesignerName(adUsersDomain));
			
			//get question lookup code for customer
			model.addAttribute("question1Type",LookupTypeValueEnum.RATING_QUALITY_OF_WORK.getTypeCode());
			model.addAttribute("question2Type",LookupTypeValueEnum.RATING_PRICING.getTypeCode());
			model.addAttribute("question3Type",LookupTypeValueEnum.RATING_RELIABILITY.getTypeCode());
			model.addAttribute("question4Type",LookupTypeValueEnum.RATING_CUSTOMIZATION.getTypeCode());
			//TODO get overall rating value	
			model.addAttribute("overallRating", ratingResponse.getAverageRating().getValue());
			model.addAttribute("rating1", ratingResponse.getQualityRating().getValue());	
			model.addAttribute("rating2", ratingResponse.getPriceRating().getValue());
			model.addAttribute("rating3", ratingResponse.getReliabilityRating().getValue());	
			model.addAttribute("rating4",ratingResponse.getCustomizationRating().getValue());
			
			model.addAttribute("userProfile", profileForm);
			model.addAttribute("userType", adUsersDomain.getUserType());
			model.addAttribute("userDetail", adUsersDomain);
			return "designer_info";
		}
	}
	
	@SuppressWarnings("unused")
	private String dateCoverter(XMLGregorianCalendar data)
	{
		String[] month={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		return data.getYear()+"-"+month[data.getMonth()]+"-"+data.getDay();
	}
	
	@RequestMapping(value ="feedback", method=RequestMethod.GET)
	public String showFeedback(@ModelAttribute(value="user") AdUsersDomain user, ModelMap modelMap)
	{
		modelMap.addAttribute("user", user);
		return ViewNames.FEEDBACK_FORM;
	}
	
	@RequestMapping(value ="feedback", method=RequestMethod.POST)
	public @ResponseBody ModelMap submitFeedback(@ModelAttribute(value="user") AdUsersDomain user,@Valid FeedbackForm formBean, BindingResult result, ModelMap modelMap)
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
			domain.setWhyRefer("Feedback");
			domain.setMessage(formBean.getFeedback());
			domain.setPhone("");
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
	
	@RequestMapping(value = "change_password", method=RequestMethod.GET)
	public String showChangePasswordPopup(@ModelAttribute(value="user") AdUsersDomain user, ModelMap modelMap)
	{
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("changePasswordForm", new ResetPwdForm());
		return ViewNames.CHANGE_PASSWORD;
	}
	
	@RequestMapping(value = "change_password", method=RequestMethod.POST)
	public @ResponseBody ModelMap changePasswordSubmit(@ModelAttribute(value="user") AdUsersDomain user,@ModelAttribute("changePasswordForm") ResetPwdForm form, BindingResult result)
	{
		ModelMap model=new ModelMap();
		//update user session object from database
		ViewUserResponse response = registrationServiceSDK.viewUser(user.getUserId());
		user=response.getUser();
		//Input checking
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "currentPassword", "field.required",null, "Invalid input, Current password can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "newPwd", "field.required",null, "Invalid input, New password can't be empty." );
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "confirmPwd", "field.required",null, "Invalid input, Confirmed password can't be empty." );
		//check current password is matching from database.
		if(!user.getPassword().equals(F9G4Hashing.getHashValue(form.getCurrentPassword())))
		{
			result.rejectValue("currentPassword", "field.required",null, ErrorsCodeEnum.CURRENT_PASSWORD_NOT_MATCH.getDefaultMessage());
		}
		else
		{
			//Check the new password and confirmed password is the same.
			if(!form.getNewPwd().equals(form.getConfirmPwd()))
			{
				result.rejectValue("confirmPwd", "field.required",null, "Invalid input, Password and Confirm Password didn't match." );
			}
			else
			{
				if(form.getNewPwd().equals(form.getCurrentPassword()))
					result.rejectValue("newPwd", "field.required",null, ErrorsCodeEnum.SETUP_USING_PREVIOUS_PASSWORD.getDefaultMessage() );
			}
		}
		if(result.hasErrors()) {
			model.addAttribute("hasError", true);
			model.addAttribute("errors", result.getAllErrors());
		}
		else {
			//update the password
			String responseStatusCode;
			ResetPasswordRequest request = new ResetPasswordRequest();
			request.setNewPassword(F9G4Hashing.getHashValue(form.getNewPwd()));
			request.setUserId(user.getUserId());
			ResetPasswordResponse resetPasswprdResponse = registrationServiceSDK.resetPassword(request);
			responseStatusCode = resetPasswprdResponse.getStatus().getStatuscode();
			if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(responseStatusCode)) {
				model.addAttribute("hasError", false);
			}
			else {
				result.addError(new ObjectError(ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode(),ErrorsCodeEnum.SERVICE_UNAVAILABLE.getDefaultMessage()));
				model.addAttribute("hasError", true);
				model.addAttribute("errors", result.getAllErrors());
			}
		}
		return model;
	}
	
	@RequestMapping(value = "progress/profile", method=RequestMethod.GET)
	public String checkProfileProgress(@ModelAttribute(value="user") AdUsersDomain user, ModelMap modelMap)
	{
		//update user session object from database
		ViewUserResponse response = registrationServiceSDK.viewUser(user.getUserId());
		user=response.getUser();
		UserProfileChecker profileChecker = new UserProfileChecker();
		if(profileChecker.getProfileProgressInfo(user))
		{
			modelMap.addAttribute("score", profileChecker.getScore());
			modelMap.addAttribute("toDoList", profileChecker.getToDoList());
		}
		return ViewNames.CONSOLE_PROFILE_PROGRESS;
	}
	
	@RequestMapping(value = "progress/profile/why", method=RequestMethod.GET)
	public String popupWhyCompleteProfile(@ModelAttribute(value="user") AdUsersDomain user, ModelMap modelMap)
	{
		return ViewNames.WHY_COMPLETE_PROFILE;
	}
	
	private BoardImageFilterResult boardImageFilter(TrBoardDomain board,AdUsersDomain user)
	{
		BoardImageFilterResult filterResult=new BoardImageFilterResult();
		//check board status
		switch(board.getPublishToMP())
		{
		case 0: //unpublished
			//the board is being sold or ready to download (handle MP=0, Board is SOLD or READY)
			if(board.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId()
				|| board.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId())
			{
				//if user is original user or current user of board, show the thumb image.
				if(user.getUserId()==board.getOriginalUserId() || user.getUserId()==board.getCurrentUerId())
					filterResult.setShow(true);
				else
				{
					filterResult.setShow(false);	//if it's sold and the user is not current user or original user, don't show the image.
					filterResult.setTypeCode("board.sold.unrelatedusers");
				}		
			}
			else //handle MP=0, the board is processing or available
			{
				//if the user is designer, he can see the image, and others cannot.
				if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && (user.getUserId()==board.getCurrentUerId() || user.getUserId()==board.getOriginalUserId()))
					filterResult.setShow(true);
				else
				{
					filterResult.setShow(false);
					filterResult.setTypeCode("board.unpublished");
				}
			}
			break;
		case 1: //published
			if(board.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId()) //Everybody can see the image.
				filterResult.setShow(true);
			else if(board.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() 
					|| board.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId()
					|| board.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeId())
			{
				//if user is original user or current user of board, show the thumb image.
				if(user.getUserId()==board.getCurrentUerId() || user.getUserId()==board.getOriginalUserId() || user.getUserId()==board.getLastupdateby())
					filterResult.setShow(true);
				else
				{
					filterResult.setShow(false);	//if it's sold and the user is not current user or original user, don't show the image.
					filterResult.setTypeCode("board.sold.unrelatedusers");
				}
			}
			else
				filterResult.setShow(true);
			break;
		case 2: //processing
			//Only the user who is original user can see the image
			if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && (user.getUserId()==board.getCurrentUerId() || user.getUserId()==board.getOriginalUserId()))
				filterResult.setShow(true);
			else
			{
				filterResult.setShow(false);
				filterResult.setTypeCode("board.processing");
			}
			break;
		default:
			filterResult.setShow(false);
			filterResult.setTypeCode("board.unknownstates");
			break;
		}
		return filterResult;
	}
	
	//filename filter to replace special characters to _
	private String fileNameFilter(String source)
	{
		String target = source;
		target = target.replaceAll("[\"/:*?\\<>|%]", "_");
		//Trim the filename
		if(target.length()>50)
		{
			target=target.substring(0,50);
		}
		return target;
	}
	
	private void convertPriceToCredit(List<TrBoardSearchDomain> target,int conversionRate)
	{
		//convert USD to FFG Credit
		for(TrBoardSearchDomain domain : target)
		{
			BigDecimal ffgCredit = domain.getSalePrice().divide(new BigDecimal(conversionRate));
			domain.setSalePrice(ffgCredit.setScale(0,BigDecimal.ROUND_CEILING));
		}
	}
}
