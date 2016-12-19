package com.f9g4.webapp.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdEmailTemplatesDomain;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StCategoryMasterDomain;
import com.f9g4.businessobjects.domain.StMemPricingOptionsDomain;
import com.f9g4.businessobjects.domain.StSeasonYearDomain;
import com.f9g4.businessobjects.domain.TrBoardApprovalDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrBoardSearchDomain;
import com.f9g4.businessobjects.domain.TrBroadcastMessagesDomain;
import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.domain.TrPortfolioContestDomain;
import com.f9g4.businessobjects.domain.TrPortfolioContestMembersDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.domain.TrPortfolioImagesDomain;
import com.f9g4.businessobjects.domain.TrReferralsDomain;
import com.f9g4.businessobjects.services.AddBoardApprovalRequest;
import com.f9g4.businessobjects.services.AddBoardApprovalResponse;
import com.f9g4.businessobjects.services.AddNotificationQRequest;
import com.f9g4.businessobjects.services.AddNotificationQResponse;
import com.f9g4.businessobjects.services.AssignMembersToContestRequest;
import com.f9g4.businessobjects.services.AssignMembersToContestResponse;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesRequest;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.CreateContestRequest;
import com.f9g4.businessobjects.services.CreateContestResponse;
import com.f9g4.businessobjects.services.EditContestRequest;
import com.f9g4.businessobjects.services.EditContestResponse;
import com.f9g4.businessobjects.services.GetAllContestsResponse;
import com.f9g4.businessobjects.services.GetAllSamplesResponse;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.GetBoardsByPMRequest;
import com.f9g4.businessobjects.services.GetBoardsByPMResponse;
import com.f9g4.businessobjects.services.GetBoardsByPortfolioResponse;
import com.f9g4.businessobjects.services.GetBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.GetCategoriesRequest;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetContestDetailsResponse;
import com.f9g4.businessobjects.services.GetContestMembersResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.GetPortfolioByIdResponse;
import com.f9g4.businessobjects.services.GetPortfolioByUserResponse;
import com.f9g4.businessobjects.services.GetReferralsResponse;
import com.f9g4.businessobjects.services.GetSamplesByUserIdRequest;
import com.f9g4.businessobjects.services.GetSamplesByUserIdResponse;
import com.f9g4.businessobjects.services.GetUsersListRequest;
import com.f9g4.businessobjects.services.GetUsersListResponse;
import com.f9g4.businessobjects.services.ResubmitSamplesRequest;
import com.f9g4.businessobjects.services.ResubmitSamplesResponse;
import com.f9g4.businessobjects.services.ReturnSubmissionsRequest;
import com.f9g4.businessobjects.services.ReturnSubmissionsResponse;
import com.f9g4.businessobjects.services.SearchBoardsRequest;
import com.f9g4.businessobjects.services.SearchBoardsResponse;
import com.f9g4.businessobjects.services.SearchExampleBoardsRequest;
import com.f9g4.businessobjects.services.SearchExampleBoardsResponse;
import com.f9g4.businessobjects.services.UpdateAdminRatingRequest;
import com.f9g4.businessobjects.services.UpdateAdminRatingResponse;
import com.f9g4.businessobjects.services.UpdateApproverCommentRequest;
import com.f9g4.businessobjects.services.UpdateApproverCommentResponse;
import com.f9g4.businessobjects.services.UpdateBoardByAdminRequest;
import com.f9g4.businessobjects.services.UpdateBoardByAdminResponse;
import com.f9g4.businessobjects.services.UpdateUserMembershipRequest;
import com.f9g4.businessobjects.services.UpdateUserMembershipResponse;
import com.f9g4.businessobjects.services.UpdateUserRequest;
import com.f9g4.businessobjects.services.UpdateUserResponse;
import com.f9g4.businessobjects.services.UserInfoDomain;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.ContestStatusEnum;
import com.f9g4.common.util.ContestTypeEnum;
import com.f9g4.common.util.F9G4Hashing;
import com.f9g4.common.util.LanguageCodesEnum;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.MembershipServiceSDK;
import com.f9g4.servicesdk.MessageServiceSDK;
import com.f9g4.servicesdk.NotificationQServiceSDK;
import com.f9g4.servicesdk.PortfolioServiceSDK;
import com.f9g4.servicesdk.ReferralsServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.Helper.KeywordXmlHelper;
import com.f9g4.web.Helper.ProjectHelper;
import com.f9g4.web.forms.BroadcastMessageForm;
import com.f9g4.web.forms.ContestBean;
import com.f9g4.web.forms.ContestBeanBasic;
import com.f9g4.web.forms.ContestBeanDetail;
import com.f9g4.web.forms.CreateBoardForm;
import com.f9g4.web.forms.ReferralForm;
import com.f9g4.web.forms.SearchCriteriaForm;
import com.f9g4.web.utils.DomainToFormConverter;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.ModeConstants;
import com.f9g4.web.utils.TimeConvertUtil;
import com.f9g4.web.utils.UserProfileChecker;
import com.f9g4.web.utils.ViewAccess;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.googlecode.ehcache.annotations.Cacheable;

@Controller
@SessionAttributes({"user", "uName", "secQs", "adUserDomain","isMembershipExpired","currTermsId", "loggedInUserUUID", "timezoneOffset", "adminSearchResult"})
public class AdminModeController {

	private static final Logger logger = LoggerFactory.getLogger(AdminModeController.class);
	
	@Autowired
	MembershipServiceSDK membershipServiceSDK = new MembershipServiceSDK();
	
	@Autowired
	BoardServiceSDK boardServiceSDK=new BoardServiceSDK();
	
	@Autowired
	RegistrationServiceSDK registrationServiceSDK=new RegistrationServiceSDK();
	
	@Autowired
	NotificationQServiceSDK notificationQServiceSDK = new NotificationQServiceSDK();
	
	@Autowired
	ReferralsServiceSDK referralsServiceSDK = new ReferralsServiceSDK();
	
	@Autowired
	MessageServiceSDK messageServiceSDK = new MessageServiceSDK();
	
	@Autowired
	PortfolioServiceSDK portfolioServiceSDK = new PortfolioServiceSDK();
	
	@Cacheable(cacheName="statesList")
	@ModelAttribute("statesList")
	public List<AdLookupValuesDomain> getStatesList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.US_STATES.getTypeName()).getLookupTypeValues();
	}
	
	@ModelAttribute("securityQestions1_List")
	public List<AdLookupValuesDomain> getSecurityQestions1List() {		
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.USER_SEC_QUESTION1.getTypeName()).getLookupTypeValues();
	}

	@ModelAttribute("securityQestions2_List")
	public List<AdLookupValuesDomain> getSecurityQestions2List() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.USER_SEC_QUESTION2.getTypeName()).getLookupTypeValues();
	}
	
	@ModelAttribute("memPricingOptions")
	public List<StMemPricingOptionsDomain> getMembershipLevelList() 
	{
		return membershipServiceSDK.getMemPricingOptions().getOptions();
	}
	
	@ModelAttribute("seasonYear")
	public List<StSeasonYearDomain> getSeasonYear() 
	{
		return registrationServiceSDK.getSeasonAllYears().getStSeasonYearDomains();
	}
	
	@ModelAttribute("seasonYearMap")
	public HashMap<Integer, StSeasonYearDomain> getSeasonYearHashMap() 
	{
		HashMap<Integer, StSeasonYearDomain> hm = new LinkedHashMap<Integer, StSeasonYearDomain>();
		List<StSeasonYearDomain> list = registrationServiceSDK.getSeasonAllYears().getStSeasonYearDomains();
		for(StSeasonYearDomain item :list)
		{
			hm.put(item.getSeasonYearId(), item);
		}
		return hm;
	}
	
	@ModelAttribute("boardDimension")
	public List<AdLookupValuesDomain> getBoardDimension()
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.BOARD_DIMENSION.getTypeName()).getLookupTypeValues();
	}
	
	@ModelAttribute("boardFormat")
	public List<AdLookupValuesDomain> getBoardFormat()
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.BOARD_FORMAT.getTypeName()).getLookupTypeValues();
	}
	
	@ModelAttribute("projectTypeList")
	public List<ContestTypeEnum> getProjectType()
	{
		List<ContestTypeEnum> projectTypeList=new ArrayList<ContestTypeEnum>();
		projectTypeList.add(ContestTypeEnum.TYPE_COMMISSIONED);
		projectTypeList.add(ContestTypeEnum.TYPE_INNER_CIRCLE);
		projectTypeList.add(ContestTypeEnum.TYPE_MEMBERS_ONLY);
		projectTypeList.add(ContestTypeEnum.TYPE_PUBLIC_CONTEST);
		return projectTypeList;
	}
	
	@Autowired @Value("${f9g4.webapp.administrator}")
	private String adminUserIdChain;
	
	@Autowired @Value("${f9g4.webapp.key}")
	private String key;
	
	@Autowired @Value("${f9g4.webapp.sse.duration}")
	private Integer sseDuration;
	
	@Autowired @Value("${fileStore_error_files}")
	private String profileLocation_error_files;
	
	@Autowired @Value("${fileStore_ai}")
	private String profileLocation_files;
	
	@ModelAttribute("sseDuration")
	public Integer getSseDuration()
	{
		return this.sseDuration;
	}
	
	@ModelAttribute("broadcastMsgTemplates")
	public List<AdEmailTemplatesDomain> getBroadcastMsgTemplates()
	{
		//Get all template name
		return notificationQServiceSDK.getEmailTemplateByCodeContaining("BROADCAST_%").getTemplates();
	}
	
	//Retrieve the board price range from the property file and then put into container.
	@Autowired @Value("${minimun_board_price}")
	private Double minimunBoardPrice;
	
	@ModelAttribute("minimunBoardPrice")
	public Double getMinimunBoardPrice()
	{
		return this.minimunBoardPrice;
	}
	
	@Autowired @Value("${maximun_board_price}")
	private Double maximunBoardPrice;
	
	@ModelAttribute("maximunBoardPrice")
	public Double getMaximunBoardPrice()
	{
		return this.maximunBoardPrice;
	}
	
	@Cacheable(cacheName="saleTypeList")
	@ModelAttribute("saleTypeList")
	public List<AdLookupValuesDomain> getSaleTypeList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.SALE_TYPE.getTypeName()).getLookupTypeValues();
	}
	
	//Division
	@Cacheable(cacheName="divisionList")
	@ModelAttribute("divisionList")
	public List<StCategoryMasterDomain> getCategoryList() 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_1, 0).getStCategoryMasterDomain();
	}
	
	public List<StCategoryMasterDomain> getProductList(Integer parentId) 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_3, parentId).getStCategoryMasterDomain();
	}
	
	public List<StCategoryMasterDomain> getProductTypeList(Integer parentId) 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_4, parentId).getStCategoryMasterDomain();
	}
	
	//Get portfolio list by user id
	public List<TrPortfolioDomain> getPortfolioList(int userId)
	{
		GetPortfolioByUserResponse response=portfolioServiceSDK.getPortfoliobyUser(userId);
		return response.getPortfolio();
	}
	
	//Countries
	@ModelAttribute("countryList")
	public List<AdLookupValuesDomain> getCountryList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.ISO_COUNTRY.getTypeName()).getLookupTypeValues();
	}
	
	//Credit conversion rate property
	@Autowired @Value("${f9g4.webapp.credit.conversion.usd}")
	private int creditConversionToUsd;
	
	@ModelAttribute("creditConversionToUsd")
	public int getCreditConversionToUsd()
	{
		return this.creditConversionToUsd;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_BOARDS_APPROVAL, method = RequestMethod.GET)
	public String viewBoardsForApproval(@RequestParam(value="pmp",defaultValue="all") String pmp, @RequestParam(value="did",defaultValue="all") final String did, @RequestParam(value="ptype",defaultValue="all") String ptype, @RequestParam(value="mode",defaultValue="boards") String mode, @RequestParam(value="sortOption",defaultValue="1") final Integer sortOption, @ModelAttribute("user") AdUsersDomain user, @ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		//detect the user have the permission to access this page or not.
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			GetBoardsByPMRequest request=new GetBoardsByPMRequest();
			List<Integer> pmpList = request.getPublishToMP();
			if(pmp.toLowerCase().equals("all"))
			{
				pmpList.add(Constants.PUBLISH_TO_MARKET_YES);
				pmpList.add(Constants.PUBLISH_TO_MARKET_REVIEWING);
			}
			else
				pmpList.add(Integer.parseInt(pmp));
			List<Integer> portfolioTypes = request.getPortfolioTypes();
			if(ptype.toLowerCase().equals("all"))
			{
				portfolioTypes.add(ActiveStatusEnum.ACTIVE.value());
				portfolioTypes.add(ActiveStatusEnum.INACTIVE.value());
			}
			else
				portfolioTypes.add(Integer.parseInt(ptype));
			request.setUserId(user.getUserId()); //for security purpose, check the user privilege on service side also.
			
			List<TrBoardDomain> domain = new ArrayList<TrBoardDomain>();
			Status status = new Status();
			GetBoardsByPMResponse response = new GetBoardsByPMResponse();
			GetAllSamplesResponse samplesResponse = new GetAllSamplesResponse();
			if(mode.equals("boards"))
			{
				//Get boards if mode == boards
				response = boardServiceSDK.fetchBoardsByPMStatus(request);
				domain = response.getBoards(); //filter boards by user Id.
				status = response.getStatus(); //update status
			}
			else if(mode.equals("samples"))
			{
				//Get samples if mode == samples
				samplesResponse = boardServiceSDK.getAllSamples();
				//filter boards by user Id.
				domain = samplesResponse.getSamples(); //filter boards by user Id.
				status = samplesResponse.getStatus(); //updatye status
			}
			
			if(status.getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				map.addAttribute("canRender", true);
				//Retrieve the 3rd category from keywords column.
				HashMap<Integer,String> productList=new HashMap<Integer,String>();
				//Retrieve the 4th category from keywords column.
				HashMap<Integer,String> productTypeList=new HashMap<Integer,String>();
				//get the designer name list and boards count;
				HashMap<Integer,Integer> designersList=new HashMap<Integer,Integer>();
				HashMap<Integer,String> designersNameList=new HashMap<Integer,String>();
				//Hashmap for board timestamp
				HashMap<Integer,String> boardTimestamp=new HashMap<Integer,String>();
				for(TrBoardDomain item : domain)
				{
					Integer count;
					if(designersList.containsKey(item.getOriginalUserId()))
						count=designersList.get(item.getOriginalUserId())+1;
					else
					{
						count=1;
						designersNameList.put(item.getOriginalUserId(), item.getOriginalUser().getFirstname()+" "+item.getOriginalUser().getLastname());
					}
					designersList.put(item.getOriginalUserId(), count);
				}
				//If the target user id do not have boards in the list, generate the option in select component with 0 boards count.
				if(!did.equals("all") && !designersNameList.containsKey(Integer.parseInt(did)))
				{
					//Get target user info
					ViewUserResponse targetUser = registrationServiceSDK.viewUser(Integer.parseInt(did));
					//Add to the designersName List and show 0 boards count.
					designersList.put(targetUser.getUser().getUserId(),0);
					designersNameList.put(targetUser.getUser().getUserId(), targetUser.getUser().getFirstname()+" "+targetUser.getUser().getLastname());
				}
				if(!did.toLowerCase().equals("all"))
				{
					Predicate<TrBoardDomain> filter = new Predicate<TrBoardDomain>()
					{ 
						public boolean apply(TrBoardDomain item)
						{
							if(item.getOriginalUserId()==Integer.parseInt(did))
								return false;
							else
								return true;
						}
					};
					Collection<TrBoardDomain> collection = Collections2.filter(domain, filter);
					collection.clear();
				}
				for(TrBoardDomain item : domain)
				{
					//Retrieve the product from keyword
					String bcl3=KeywordXmlHelper.retrieveBoardCategoryLevelContent(3, item.getKeyword());
					productList.put(item.getBoardId(), bcl3);
					//Retrieve the product type from keyword
					String ptl=KeywordXmlHelper.retrieveProductTypeContent(item.getKeyword());
					productTypeList.put(item.getBoardId(), ptl);
					//Reformat the keyword value as pure keyword
					String keywords=KeywordXmlHelper.retrieveSubkeywordContentAsHashMap(item.getKeyword()).toString();
					keywords=keywords.replace("skw1", "Inspiration/Trends");
					keywords=keywords.replace("skw2", "Design details");
					keywords=keywords.replace("skw3", "Fabric");
					keywords=keywords.replace("skw4", "Others");
					item.setKeyword(keywords);
					//Push board last update date to HashMap container
					if(item.getBoardImages() != null && !item.getBoardImages().isEmpty())
					{
						TrBoardImagesDomain itemImage = item.getBoardImages().get(0);
						itemImage.setLastUpdateDate(TimeConvertUtil.convertToLocalTime(itemImage.getLastUpdateDate(), timezoneOffset));
						String dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(itemImage.getLastUpdateDate().toGregorianCalendar().getTime());
						boardTimestamp.put(item.getBoardId(), dateString);
					}
				}
				//Sorting
				try
				{
					Collections.sort(domain, new Comparator<TrBoardDomain>() {
				        public int compare(TrBoardDomain o1, TrBoardDomain o2) {
				        	int result=1;
				        	if(Math.abs(sortOption)==1)
				        	{
					            if(o1.getBoardImages().get(0).getLastUpdateDate().compare(o2.getBoardImages().get(0).getLastUpdateDate())==DatatypeConstants.LESSER)
					            	result=1;
					            else
					            	result=-1;
				        	}
				        	else if(Math.abs(sortOption)==2)
				        	{
				        		if(o1.getName().compareToIgnoreCase(o2.getName())>0)
					            	result=1;
					            else
					            	result=-1;
				        	}
				        	else if(Math.abs(sortOption)==3)
				        	{
				        		if(o1.getOriginalUser().getLastname().compareToIgnoreCase(o2.getOriginalUser().getLastname())>0)
					            	result=1;
					            else
					            	result=-1;
				        	}
				        	else if(Math.abs(sortOption)==4)
				        	{
				        		if(o1.getOriginalUser().getFirstname().compareToIgnoreCase(o2.getOriginalUser().getFirstname())>0)
					            	result=1;
					            else
					            	result=-1;
				        	}
				        	else if(Math.abs(sortOption)==5)
				        	{
				        		if(o1.getOriginalUser().getUserName().compareToIgnoreCase(o2.getOriginalUser().getUserName())>0)
					            	result=1;
					            else
					            	result=-1;
				        	}
				        	else if(sortOption==6) //admin rating highest
				        	{
				        		if(o1.getOriginalUser().getAdminRating()>=o2.getOriginalUser().getAdminRating())
				        			result=-1;
				        		else
				        			result=1;
				        	}
				        	else if(sortOption==7) //admin rating lowest
				        	{
				        		if(o1.getOriginalUser().getAdminRating()<=o2.getOriginalUser().getAdminRating())
				        			result=-1;
				        		else
				        			result=1;
				        	}
				        	else
				        	{
				        		if(o1.getBoardImages().get(0).getLastUpdateDate().compare(o2.getBoardImages().get(0).getLastUpdateDate())==DatatypeConstants.LESSER)
					            	result=1;
					            else
					            	result=-1;
				        	}
				        	if(sortOption<0)
				        		result=result*-1; //reverse the order
				        	return result;
				        }
					});
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				map.addAttribute("boards", domain);
				map.addAttribute("boardsTimeHashMap", boardTimestamp);
				map.addAttribute("productHashMap", productList);
				map.addAttribute("productTypeHashMap", productTypeList);
				map.addAttribute("designersList", designersList);
				map.addAttribute("designersNameList", designersNameList);
				
				map.addAttribute("pmpFilter", pmp);
				map.addAttribute("designerFilter", did);
				map.addAttribute("pTypeFilter", ptype);
				map.addAttribute("mode", mode);
				//sortOptionHM
				HashMap<String, String> sortOptionHM=new HashMap<String, String>();
				sortOptionHM.put(sortOption.toString(), "selected=\"selected\"");
				map.addAttribute("sortOptionHM", sortOptionHM);
			}
			else if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_UNAUTHORIZED_USER.getCode()))
			{
				map.addAttribute("canRender", false);
				map.addAttribute("renderTypeCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
			}
			else
			{
				map.addAttribute("canRender", false);
				map.addAttribute("renderTypeCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
			}
		}
		else
		{
			map.addAttribute("canRender", false);
			map.addAttribute("renderTypeCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
		}
		return ViewNames.ADMIN_BOARDS_APPROVAL;
	}
	
	/**
	 * 
	 * @param boardId
	 * @param comments
	 * @param mainImageUrl
	 * @param approvalStatus
	 * @param user
	 * @return
	 */
	@RequestMapping(value = ViewPaths.ADMIN_ADD_BOARDS_APPROVAL, method = RequestMethod.POST)
	public @ResponseBody ModelMap addBoardApproval(@RequestParam("board_id") Integer boardId,@RequestParam("comments") String comments,@RequestParam("main_image_url") String mainImageUrl,@RequestParam("approval_status") Integer approvalStatus,@ModelAttribute("user") AdUsersDomain user) {
		//detect the user have the permission to access this page or not.
		ModelMap model=new ModelMap();
		AddBoardApprovalRequest request=new AddBoardApprovalRequest();
		TrBoardApprovalDomain domain=new TrBoardApprovalDomain();
		request.setInstance(domain);
		request.setUserId(user.getUserId()); //for security purpose, check the user privilege on service side also.
		request.setBoardId(boardId); //set board id
		//Set data
		domain.setMainImageUrl(mainImageUrl);
		domain.setApprovalStatus(approvalStatus);
		domain.setComments(comments);
		domain.setApproverName(user.getFirstname()+" "+user.getLastname());
		domain.setProcessStatus(null);
		domain.setErrorMessage(null);
		domain.setCreatedBy(2); //System user.
		domain.setLastUpdatedBy(2); //System user.
		try {
			domain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
			domain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
		} catch (DatatypeConfigurationException e) {
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
			model.addAttribute("errorDescription", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getDefaultMessage());
			return model;
		}
		AddBoardApprovalResponse response = boardServiceSDK.addBoardApproval(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			model.addAttribute("hasError", false);
		else if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_UNAUTHORIZED_USER.getCode()))
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
			model.addAttribute("errorDescription", ErrorsCodeEnum.UNAUTHORIZED_USER.getDefaultMessage());
		}
		else if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_RECORD_EXISTED.getCode()))
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", "record.existed");
			model.addAttribute("errorDescription", "record has existed");
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
			model.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_RESUBMIT_SAMPLES, method = RequestMethod.POST)
	public @ResponseBody ModelMap resubmitSamples(@RequestParam("board_id") Integer boardId,@RequestParam("comments") String comments,@RequestParam("main_image_url") String mainImageUrl,@RequestParam("approval_status") Integer approvalStatus,@ModelAttribute("user") AdUsersDomain user) {
		//detect the user have the permission to access this page or not.
		ModelMap model=new ModelMap();
		ResubmitSamplesRequest request=new ResubmitSamplesRequest();
		TrBoardApprovalDomain domain=new TrBoardApprovalDomain();
		request.setInstance(domain);
		request.setUserId(user.getUserId()); //for security purpose, check the user privilege on service side also.
		request.setBoardId(boardId); //set board id
		//Set data
		domain.setMainImageUrl(mainImageUrl);
		domain.setApprovalStatus(approvalStatus);
		domain.setComments(comments);
		domain.setApproverName(user.getFirstname()+" "+user.getLastname());
		domain.setProcessStatus(null);
		domain.setErrorMessage(null);
		domain.setCreatedBy(2); //System user.
		domain.setLastUpdatedBy(2); //System user.
		try {
			domain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
			domain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
		} catch (DatatypeConfigurationException e) {
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
			model.addAttribute("errorDescription", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getDefaultMessage());
			return model;
		}
		ResubmitSamplesResponse response = boardServiceSDK.resubmitSamples(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			model.addAttribute("hasError", false);
		else if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_UNAUTHORIZED_USER.getCode()))
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
			model.addAttribute("errorDescription", ErrorsCodeEnum.UNAUTHORIZED_USER.getDefaultMessage());
		}
		else if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_RECORD_EXISTED.getCode()))
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", "record.existed");
			model.addAttribute("errorDescription", "record has existed");
		}
		else if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_REQUEST_REJECTED.getCode()))
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", "user.approved");
			model.addAttribute("errorDescription", "This user is already the approved user. Cannot resubmit the example");
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
			model.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_USERS_VIEWER, method = RequestMethod.GET)
	public String viewUsersInfo(@ModelAttribute("user") AdUsersDomain user, @ModelAttribute("timezoneOffset") Integer timezoneOffset, @RequestParam(value="usertype",defaultValue="all") String userTypeFilter,@RequestParam(value="filter",defaultValue="all") String filter,@RequestParam(value="sortoption",defaultValue="-4") Integer sortOption, @RequestParam(value="p",defaultValue="1") Integer page,ModelMap map) {
		//detect the user have the permission to access this page or not.
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		Integer itemsPerPage = 30;
		if(items.contains(Integer.toString(user.getUserId())))
		{
			GetUsersListRequest request=new GetUsersListRequest();
			//Set user type.
			AdLookupValuesDomain designerUserType=new AdLookupValuesDomain();
			designerUserType.setLookupValueId(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeId());
			designerUserType.setLookupCode(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode());
			AdLookupValuesDomain companyUserType=new AdLookupValuesDomain();
			companyUserType.setLookupValueId(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeId());
			companyUserType.setLookupCode(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
			if(userTypeFilter.equals("all") || userTypeFilter.equals("designer"))
				request.getUserType().add(designerUserType);
			if(userTypeFilter.equals("all") || userTypeFilter.equals("company"))
				request.getUserType().add(companyUserType);
			//Set registration status to retrieve 431,432,433
			AdLookupValuesDomain regStatusCompletedForm=new AdLookupValuesDomain();
			AdLookupValuesDomain regStatusConfirmed=new AdLookupValuesDomain();
			AdLookupValuesDomain regStatusWaiting=new AdLookupValuesDomain();
			AdLookupValuesDomain regStatusRejected=new AdLookupValuesDomain();
			AdLookupValuesDomain regSubmitSamplesCompleted=new AdLookupValuesDomain();
			if(filter.equals("all") || filter.equals("approved"))
			{
				regStatusConfirmed.setLookupValueId(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeId());
				regStatusConfirmed.setLookupCode(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode());
				request.getRegStatus().add(regStatusConfirmed);
			}
			if(filter.equals("all") || filter.equals("rc") || filter.equals("waitapproval"))
			{
				regStatusCompletedForm.setLookupValueId(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeId());
				regStatusCompletedForm.setLookupCode(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeCode());
				request.getRegStatus().add(regStatusCompletedForm);
			}
			if(filter.equals("all") || filter.equals("sbsc") || filter.equals("waitapproval"))
			{
				regSubmitSamplesCompleted.setLookupValueId(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeId());
				regSubmitSamplesCompleted.setLookupCode(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeCode());
				request.getRegStatus().add(regSubmitSamplesCompleted);
			}
			if(filter.equals("all") || filter.equals("wc") || filter.equals("waitapproval"))
			{
				regStatusWaiting.setLookupValueId(LookupTypeValueEnum.REG_STATUS_WAITING_FOR_COFIRMATION.getTypeId());
				regStatusWaiting.setLookupCode(LookupTypeValueEnum.REG_STATUS_WAITING_FOR_COFIRMATION.getTypeCode());
				request.getRegStatus().add(regStatusWaiting);
			}
			if(filter.equals("all") || filter.equals("rejected"))
			{
				regStatusRejected.setLookupValueId(LookupTypeValueEnum.REG_STATUS_DENIED.getTypeId());
				regStatusRejected.setLookupCode(LookupTypeValueEnum.REG_STATUS_DENIED.getTypeCode());
				request.getRegStatus().add(regStatusRejected);
			}
			//setup sortOption and pagination value
			request.setSortOption(sortOption);
			if(page==-1)
			{
				request.setFirstResult(-1);
				request.setMaxResult(-1);
				map.addAttribute("showAll", true);
			}
			else
			{
				request.setFirstResult((page-1)*itemsPerPage);
				request.setMaxResult(itemsPerPage);
				map.addAttribute("showAll", false);
			}
			GetUsersListResponse response = registrationServiceSDK.getUsersList(request);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				map.addAttribute("users", response.getUsers());
				HashMap<Integer, String> expDateHM = new HashMap<Integer, String>();
				HashMap<Integer, String> effectiveDateHM = new HashMap<Integer, String>();
				//convert the expiration date to Date
				for(UserInfoDomain item : response.getUsers())
				{
					if(item.getMembership().size() > 0)
					{	
						item.getMembership().get(0).setExperiationDate(TimeConvertUtil.convertToLocalTime(item.getMembership().get(0).getExperiationDate(), timezoneOffset));
						//Add one day on the signed up date
						item.getMembership().get(0).setEffectiveDate(TimeConvertUtil.convertToLocalTime(item.getMembership().get(0).getEffectiveDate(), timezoneOffset,24));
						String dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(item.getMembership().get(0).getExperiationDate().toGregorianCalendar().getTime());
						expDateHM.put(item.getUserId(), dateString);
						dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(item.getMembership().get(0).getEffectiveDate().toGregorianCalendar().getTime());
						effectiveDateHM.put(item.getUserId(), dateString);
					}
				}
				map.addAttribute("expDateHM", expDateHM);
				map.addAttribute("effectiveDateHM", effectiveDateHM);
				map.addAttribute("usersCount", response.getTotal());
				map.addAttribute("canRender", true);
				map.addAttribute("currentPage", page);
				Double totalPages = Math.ceil(response.getTotal()/itemsPerPage)+1;
				map.addAttribute("totalPages", totalPages.intValue());
				//calculate prev and next page
				Double nextPage = (page+1)%totalPages;
				Double prevPage = (page-1)%totalPages;
				if(prevPage <= 0)
					prevPage=totalPages;
				map.addAttribute("pPrevPage", prevPage.intValue());
				map.addAttribute("pNextPage", nextPage.intValue());
			}
			else
			{
				map.addAttribute("canRender", false);
				map.addAttribute("renderTypeCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
			}
		}
		else
		{
			map.addAttribute("canRender", false);
			map.addAttribute("renderTypeCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
		}
		HashMap<String, String> filterMap=new HashMap<String, String>();
		filterMap.put(filter, "selected=\"selected\"");
		map.addAttribute("filter", filterMap);
		HashMap<String, String> userTypeFilterMap=new HashMap<String, String>();
		userTypeFilterMap.put(userTypeFilter, "selected=\"selected\"");
		map.addAttribute("userTypeFilter", userTypeFilterMap);
		//sortOptionHM
		HashMap<String, String> sortOptionHM=new HashMap<String, String>();
		sortOptionHM.put(sortOption.toString(), "selected=\"selected\"");
		map.addAttribute("sortOptionHM", sortOptionHM);
		map.addAttribute("pUsertype", userTypeFilter);
		map.addAttribute("pFilter", filter);
		map.addAttribute("pSortoption", sortOption);
		map.addAttribute("pPage", page);
		return ViewNames.ADMIN_USERS_VIEWER;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_USERS_VIEWER, method = RequestMethod.POST)
	public @ResponseBody ModelMap addUserApproval(@ModelAttribute("timezoneOffset") Integer timezoneOffset, @RequestParam("userId") Integer userId,@RequestParam("memPricingOption") Integer memPricingOptionId,@RequestParam("approval_status") Integer approvalStatus,@RequestParam(value="trial_period",defaultValue="0") Integer trialPeriod) {
		ModelMap model=new ModelMap();
		ViewUserResponse response = registrationServiceSDK.viewUser(userId);
		AdUsersDomain userData = response.getUser();
		//Change registration status
		userData.setActiveStatus(ActiveStatusEnum.ACTIVE.value()); //change active state to 1
		if(approvalStatus == 1) //approve user
		{
			userData.setRegisterStatusId(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeId()); //Change registration status to confirm
			//Change membership detail
			if(userData.getUserMembership().size()>0)
			{
				AdUserMembershipDomain adUserMembershipDomain = userData.getUserMembership().get(0);
				adUserMembershipDomain.setPaymentStatusId(LookupTypeValueEnum.MEM_PAYMENT_STATUS_PAID.getTypeId()); //Change to paid status
				adUserMembershipDomain.setMembershipPricingId(memPricingOptionId); //Change pricing Id
				Calendar expDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adUserMembershipDomain.getExperiationDate());
				expDate.add(Calendar.DAY_OF_MONTH, +trialPeriod);
				try {
					adUserMembershipDomain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(expDate));
				} catch (DatatypeConfigurationException e) {
					model.addAttribute("hasError", true);
					return model;
				}
			}
			else
			{
				model.addAttribute("hasError", true);
				return model;
			}
		}
		else if(approvalStatus == 0) //reject user
			userData.setRegisterStatusId(LookupTypeValueEnum.REG_STATUS_DENIED.getTypeId()); //Change registration status to deny
		else if(approvalStatus == 2) //resubmit samples
			userData.setRegisterStatusId(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeId()); //Change registration status back to form completed, so the user has to submit the samples again.
		else
		{
			model.addAttribute("hasError", true);
			return model;
		}
		
		UpdateUserMembershipRequest request = new UpdateUserMembershipRequest();
		request.setUser(response.getUser());
		UpdateUserMembershipResponse updateUserMembershipResponse = membershipServiceSDK.updateUserMembership(request);
		AdUsersDomain updatedUser = updateUserMembershipResponse.getUser();
		if(updateUserMembershipResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			model.addAttribute("hasError", false);
			model.addAttribute("user",updatedUser);
			updatedUser.getUserMembership().get(0).setExperiationDate(TimeConvertUtil.convertToLocalTime(updatedUser.getUserMembership().get(0).getExperiationDate(), timezoneOffset));
			String dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(updatedUser.getUserMembership().get(0).getExperiationDate().toGregorianCalendar().getTime());
			model.addAttribute("userExpDate",dateString);
		}
		else
		{
			model.addAttribute("hasError", true);
		}
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_USERS_VIEWER_DETAIL, method = RequestMethod.GET)
	public String viewUsersInfoDetail(@ModelAttribute("timezoneOffset") Integer timezoneOffset, @RequestParam("userId") Integer userId, @RequestParam(value="mode",required=false,defaultValue=ModeConstants.ADMIN_USER_DETAIL_ENABLE_UTILITY) String mode, @ModelAttribute("statesList") List<AdLookupValuesDomain> statesList,ModelMap map) {
		ViewUserResponse response = registrationServiceSDK.viewUser(userId);
		AdUsersDomain user = response.getUser();
		//Covert to state id to string
		if(user.getAddress().size()>0)
			user.getAddress().get(0).setState(getDescptionGivenadLookupvalueIdfromList(statesList,user.getAddress().get(0).getState()));
		//TODO Decrypt the security answers 09052013: no need to show security answers.
		/*BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(this.key);
		try
		{
			String decryptAns1=textEncryptor.decrypt(user.getSecurityAnswer1());
			String decryptAns2=textEncryptor.decrypt(user.getSecurityAnswer2());
			user.setSecurityAnswer1(decryptAns1);
			user.setSecurityAnswer2(decryptAns2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//TODO means the security answer is not encrypted.
		}*/
		map.addAttribute("viewUserDetail", user);
		//check the reg status to see if this person has examples or not
		if(user.getRegisterStatusCode().equals(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeCode()) 
				|| user.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()) 
				|| user.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_DENIED.getTypeCode())
				|| user.getRegisterStatusCode().equals(LookupTypeValueEnum.REG_STATUS_WAITING_FOR_COFIRMATION.getTypeCode()))
		{
			//retrieve the example detail
			GetSamplesByUserIdRequest getSamplesRequest = new GetSamplesByUserIdRequest();
			getSamplesRequest.getUserId().add(userId);
			GetSamplesByUserIdResponse getSamplesResponse = boardServiceSDK.getSamplesByUserId(getSamplesRequest);
			map.addAttribute("examples", getSamplesResponse.getSamples());
		}
		//check user's profile progress
		UserProfileChecker profileChecker = new UserProfileChecker();
		if(profileChecker.getProfileProgressInfo(user))
		{
			map.addAttribute("score", profileChecker.getScore());
			map.addAttribute("toDoList", profileChecker.getToDoList());
		}
		//Convert membership date
		try
		{
			Calendar effectiveDate= XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(user.getUserMembership().get(0).getEffectiveDate());
			Calendar expDate= XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(user.getUserMembership().get(0).getExperiationDate());
			TimeConvertUtil.convertToLocalTime(effectiveDate, timezoneOffset);
			TimeConvertUtil.convertToLocalTime(expDate, timezoneOffset);
			map.addAttribute("memEffectiveDate", effectiveDate.getTime());
			map.addAttribute("memExpDate", expDate.getTime());
			map.addAttribute("hasError", false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			map.addAttribute("hasError", true);
			map.addAttribute("memEffectiveDate", "");
			map.addAttribute("memExpDate", "");
		}
		if(mode.equals(ModeConstants.ADMIN_USER_DETAIL_ENABLE_UTILITY))
			map.addAttribute("hasEnableMessage", true);
		else
			map.addAttribute("hasEnableMessage", false);
		return ViewNames.ADMIN_USERS_VIEWER_DETAIL;
	}
	
	@RequestMapping(value = ViewPaths.SEND_EMAIL, method = RequestMethod.POST)
	public @ResponseBody ModelMap sendEmail(@RequestParam("mailUserId") Integer mailUserId,@RequestParam("mailSubject") String mailSubject,@RequestParam("mailContent") String mailContent) {
		ModelMap model = new ModelMap();
		//Retrieve the user info
		ViewUserResponse userResponse = registrationServiceSDK.viewUser(mailUserId);
		AddNotificationQRequest request=new AddNotificationQRequest();
		TrNotificationQDomain domain=new TrNotificationQDomain();
		domain.setFromEmail("support@fashionforglobe.com");
		domain.setFromUserId(2); //System user
		domain.setToEmail(userResponse.getUser().getUserName());
		domain.setToUserId(mailUserId);
		domain.setSubject(mailSubject); //TODO allow administrator to change subject?
		domain.setBodyText(mailContent);
		domain.setEmailStatusId(LookupTypeValueEnum.EMAIL_STATUS_ID_READY_TO_SEND.getTypeId());
		request.setNotificationQ(domain);
		AddNotificationQResponse response = notificationQServiceSDK.addNotificationQ(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())) {
			model.addAttribute("hasError", false);
		}
		else {
			model.addAttribute("hasError", true);
		}
		return model;
	}
	
	private String getDescptionGivenadLookupvalueIdfromList(
			List<AdLookupValuesDomain> statesList, String state) {
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
	
	@RequestMapping(value = ViewPaths.ADMIN_RESET_PASSWORD, method = RequestMethod.GET)
	public @ResponseBody ModelMap resetPassword(@RequestParam("userId") Integer userId,ModelMap map) {
		ModelMap model = new ModelMap();
		//Retrieve the user info
		ViewUserResponse userResponse = registrationServiceSDK.viewUser(userId);
		AdUsersDomain user = userResponse.getUser();
		//Create 10 chars temp password
		String tempPassword = RandomStringUtils.random(10,true,true);
		
		//TODO Hash the temp password to save to the database. And set TEMP_PASSWORD = 1
		UpdateUserRequest updateUserRequest = new UpdateUserRequest();
		user.setIsTempPassword(1);
		user.setPassword(F9G4Hashing.getHashValue(tempPassword));
		updateUserRequest.setUser(user);
		UpdateUserResponse updateUserResponse = registrationServiceSDK.updateUser(updateUserRequest);
		if(updateUserResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())) {
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
			domain.setBodyText(body); //TODO send plain password to user
			domain.setEmailStatusId(LookupTypeValueEnum.EMAIL_STATUS_ID_READY_TO_SEND.getTypeId());
			addNotificationQRequest.setNotificationQ(domain);
			AddNotificationQResponse response = notificationQServiceSDK.addNotificationQ(addNotificationQRequest);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())) {
				model.addAttribute("hasError", false);
			}
			else {
				model.addAttribute("hasError", true);
				model.addAttribute("errorCode", ErrorsCodeEnum.ADMIN_SEND_EMAIL_FAILED.getCode());
				model.addAttribute("errorDescription", ErrorsCodeEnum.ADMIN_SEND_EMAIL_FAILED.getDefaultMessage());
			}
		}
		else {
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.ADMIN_RESET_PASSWORD_FAILED.getCode());
			model.addAttribute("errorDescription", ErrorsCodeEnum.ADMIN_RESET_PASSWORD_FAILED.getDefaultMessage());
			return model;
		}
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_REFERRALS_VIEWER, method = RequestMethod.GET)
	public String referrlasViewer(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			map.addAttribute("canRender", true);
			GetReferralsResponse response = referralsServiceSDK.getReferrals();
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				ArrayList<ReferralForm> beanReferralsList=new ArrayList<ReferralForm>();
				//convert to formbean class
				for( TrReferralsDomain item : response.getReferrals())
				{
					ReferralForm temp=new ReferralForm();
					temp.setFirstName(item.getFirstName());
					temp.setLastName(item.getLastName());
					temp.setPhone(item.getPhone());
					temp.setEmail(item.getEmail());
					temp.setBackground(item.getMessage());
					temp.setReason(item.getWhyRefer());
					if(item.getSentUserId()!=1 && item.getSentUserId()!=2)
					{
						ViewUserResponse referredBy= registrationServiceSDK.viewUser(item.getSentUserId());
						if(referredBy.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
							temp.setReferredBy(referredBy.getUser().getFirstname()+" "+referredBy.getUser().getLastname()+" ("+referredBy.getUser().getUserName()+")");
						else
							temp.setReferredBy("Cannot find the referred user info.");
					}
					else
					{
						temp.setReferredBy("System user");
					}
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
				map.addAttribute("hasError", false);
				map.addAttribute("referrlas", beanReferralsList);
				map.addAttribute("referralsCount", beanReferralsList.size());
			}
			else
			{
				map.addAttribute("hasError", true);
			}
		}
		else
			map.addAttribute("canRender", false);
		return ViewNames.ADMIN_REFERRALS_VIEWER;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_BROADCAST_ALERT, method = RequestMethod.GET)
	public String broadcastAlert(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			map.addAttribute("canRender", true);
			//Get user group value
			map.addAttribute("msg_scope", registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.MSG_SCOPE.getTypeName()).getLookupTypeValues());
			//Get previous broadcast messages
			GetBroadcastMessagesResponse response = messageServiceSDK.getBroadcastMessages();
			HashMap<Integer, Date> creationDateHM = new HashMap<Integer, Date>();
			for(TrBroadcastMessagesDomain item : response.getResult())
			{
				//format the date
				Calendar createtionDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(item.getCreationDate()); //convert to Calendar
				//convert to local time
				Calendar localTime=TimeConvertUtil.convertToLocalTime(createtionDate, timezoneOffset);
				creationDateHM.put(item.getBroadcastId(), localTime.getTime());
			}
			map.addAttribute("previousBroadcastMessages", response.getResult());
			map.addAttribute("previousBroadcastMessagesDate", creationDateHM);
		}
		else
			map.addAttribute("canRender", false);
		return ViewNames.ADMIN_BROADCAST_ALERT;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_BROADCAST_ALERT, method = RequestMethod.POST)
	public @ResponseBody ModelMap submitBroadcastAlert(BroadcastMessageForm form, @ModelAttribute("user") AdUsersDomain user, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		ModelMap model=new ModelMap();
		if(items.contains(Integer.toString(user.getUserId())))
		{
			CreateBroadcastMessagesRequest request = new CreateBroadcastMessagesRequest();
			TrBroadcastMessagesDomain domain = new TrBroadcastMessagesDomain();
			request.setItem(domain);
			if(form.getTemplateCode().equals("BLANK"))
			{
				domain.setSubject(form.getMessageSubject());
				domain.setMessageText(form.getMessageBody());
			}
			else
				domain.setTemplateName(form.getTemplateCode());
			domain.setMsgScopeId(form.getMessageScope());
			domain.setMsgStatusId(LookupTypeValueEnum.EMAIL_STATUS_ID_READY_TO_SEND.getTypeId());
			CreateBroadcastMessagesResponse response = messageServiceSDK.createBroadcastMessages(request);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				model.addAttribute("hasError", false);
				model.addAttribute("message", response.getUpdate());
			}
			else
			{
				model.addAttribute("hasError", true);
				model.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
				model.addAttribute("errorDescription", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getDefaultMessage());
			}
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
			model.addAttribute("errorDescription", ErrorsCodeEnum.UNAUTHORIZED_USER.getDefaultMessage());
		}
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_BROADCAST_TEMPLATE_CONTENT, method = RequestMethod.GET)
	public @ResponseBody ModelMap getTemplateBody(@RequestParam(value="index") Integer index,@ModelAttribute("broadcastMsgTemplates") List<AdEmailTemplatesDomain> templates, ModelMap map) {
		ModelMap model = new ModelMap();
		if(index!=0)
		{
			model.addAttribute("subject", templates.get(index-1).getSubject());
			model.addAttribute("body", templates.get(index-1).getBody());
		}
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_EDIT_BOARD, method = RequestMethod.GET)
	public String editBoard(@RequestParam(value="boardId") Integer boardId, @RequestParam(value="pmp",required=false,defaultValue="all") String pmp, @RequestParam(value="did",required=false,defaultValue="all") String did, @ModelAttribute("user") AdUsersDomain user, @ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) 
	{
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			map.addAttribute("canRender", true);
			
			logger.trace("MODIFY BOARD=>"+boardId);
			map.addAttribute("createBoardForm", new CreateBoardForm());
			
			GetBoardByIdResponse response=boardServiceSDK.getBoardbyId(boardId);
			GetBoardsByPortfolioResponse boardsByPortfolio=boardServiceSDK.getBoardsbyPortfolioId(response.getBoard().getPortfolioId());
			List<TrBoardDomain> domain=boardsByPortfolio.getBoards();
			boardsFilter(domain); //filtered out the board.
			map.addAttribute("boardsByPortfolio", domain);
			
			map.addAttribute("portfolioList", getPortfolioList(response.getBoard().getOriginalUserId()));
			map.addAttribute("boardDetail", response.getBoard());
			map.addAttribute("portfolioId", response.getBoard().getPortfolioId());
			//format the date
			Calendar expDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(response.getBoard().getExperiationDate()); //convert to Calendar
			//convert to local time
			expDate=TimeConvertUtil.convertToLocalTime(expDate, timezoneOffset);
			map.addAttribute("expirationDate", expDate.getTime());
			
			//get product list
			GetPortfolioByIdResponse portfolioResponse=portfolioServiceSDK.getPortfoliobyId(response.getBoard().getPortfolioId());
			List<StCategoryMasterDomain> productDomain=getProductList(portfolioResponse.getPortfolio().getCategoryLevel2Id());
			//Get product type list
			List<StCategoryMasterDomain> productTypeDomain = new ArrayList<StCategoryMasterDomain>();
			GetCategoriesRequest categoryRequest = new GetCategoriesRequest();
			categoryRequest.setLevel(4);
			categoryRequest.setPortfolioId(portfolioResponse.getPortfolio().getPortfolioId());
			List<String> nameForLevel3 = categoryRequest.getNameForLevel3();
			nameForLevel3.addAll(KeywordXmlHelper.retrieveBoardCategoryLevelAslist(3, response.getBoard().getKeyword()));
			GetCategoriesResponse categoryResponse = new GetCategoriesResponse();
			if(!nameForLevel3.isEmpty())
			{
				categoryResponse =registrationServiceSDK.getCategoriesByLevel(categoryRequest);
				productTypeDomain = categoryResponse.getStCategoryMasterDomain();
			}
			map.addAttribute("productList", productDomain);
			map.addAttribute("productTypeList", productTypeDomain);
			map.addAttribute("hasWithPortfolio", true);
			map.addAttribute("editMode",true);
			
			GetMembershipCommissionRequest membershipRequest = new GetMembershipCommissionRequest();
			GetMembershipCommissionResponse membershipResponse = new GetMembershipCommissionResponse();
			membershipRequest.setUserId(response.getBoard().getOriginalUserId());
			membershipResponse =  membershipServiceSDK.getMembershipCommissiondetails(membershipRequest);
			BigDecimal commissionRate=membershipResponse.getStPricingOptions().getCommission();
			map.addAttribute("commissionRate", commissionRate);
			//Parse sub keywords
	        try 
	        {
	        	if(response.getBoard().getKeyword()!=null)
	        	{
	        		if(response.getBoard().getKeyword().length()>0)
	        		{
	        			map.addAllAttributes(KeywordXmlHelper.retrieveSubkeywordContentAsHashMap(response.getBoard().getKeyword()));
				        //retrieve product type list
	        			map.addAllAttributes(KeywordXmlHelper.retrieveProductTypeContentAsHashMap(response.getBoard().getKeyword()));
	        			 //retrieve product list
	        			map.addAllAttributes(KeywordXmlHelper.retrieveBoardCategoryLevelAsHashMap(3, response.getBoard().getKeyword()));
	        		}
	        	}
			}
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
		}
		else
			map.addAttribute("canRender", false);
		//Create param for cancel
		map.addAttribute("cancelParams", "?pmp="+pmp+"&did="+did);
		return ViewNames.ADMIN_EDIT_BOARD;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_EDIT_BOARD, method = RequestMethod.POST)
	public @ResponseBody ModelMap submitEditedBoard(@RequestParam(value="boardId",defaultValue="0",required=true) Integer boardId, CreateBoardForm formBean, ModelMap map)
	{
		ModelMap model = new ModelMap();
		List<ObjectError> errors = new ArrayList<ObjectError>();
		//input checking
		if(boardId==0)
			errors.add(new ObjectError(ErrorsCodeEnum.INVALID_INPUT.getCode(),"The board id did not exist."));
		if(formBean.getProductTags().length<=0)
			errors.add(new ObjectError(ErrorsCodeEnum.INVALID_INPUT.getCode(),"Product can not be empty."));
		if(formBean.getProductTypeTags().length<=0)
			errors.add(new ObjectError(ErrorsCodeEnum.INVALID_INPUT.getCode(),"Product type can not be empty."));
		if(formBean.getPrice()==0)
			errors.add(new ObjectError(ErrorsCodeEnum.INVALID_INPUT.getCode(),"Board price can not be empty"));
		if(errors.size()>0)
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errors", errors);
		}
		else
		{
			GetBoardByIdResponse board=boardServiceSDK.getBoardbyId(boardId);
			UpdateBoardByAdminRequest updateRequest=new UpdateBoardByAdminRequest();
			UpdateBoardByAdminResponse updateResponse = new UpdateBoardByAdminResponse();
			GetMembershipCommissionRequest membershipRequest = new GetMembershipCommissionRequest();
			GetMembershipCommissionResponse membershipResponse = new GetMembershipCommissionResponse();
			TrBoardDomain currentBoard=board.getBoard();
			TrBoardDomain domain=new TrBoardDomain();
			updateRequest.setOldBoard(currentBoard);
			updateRequest.setNewBoard(domain);
			
			domain.setBoardId(formBean.getBoardId());
			//domain.setCategoryLevel3Id(formBean.getProduct()); //Save 3rd level in keyword.
			//prepare keywords from subKeywords in xml format
			String subKeywords_1="<skw1>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_1())+"</skw1>";
			String subKeywords_2="<skw2>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_2())+"</skw2>";
			String subKeywords_3="<skw3>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_3())+"</skw3>";
			String subKeywords_4="<skw4>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_4())+"</skw4>";
			//
			Pattern patternForDivision = Pattern.compile("<bcl1>.*</bcl1>");
			Pattern patternForCategory = Pattern.compile("<bcl2>.*</bcl2>");
			Matcher matcherForDivision = patternForDivision.matcher(board.getBoard().getKeyword());
			Matcher matcherForCategory = patternForCategory.matcher(board.getBoard().getKeyword());
			String divisionList="";
			String categoryList="";
			if(matcherForDivision.find())
				divisionList=matcherForDivision.group(); //Get value from keywords
			if(matcherForCategory.find())
				categoryList=matcherForCategory.group(); //Get value from keywords
			String productList="<bcl3>"+StringUtils.join(formBean.getProductTags(), ",")+"</bcl3>"; //Insert 3rd level to keywords fields
			String productTypeList="<ptl>"+StringUtils.join(formBean.getProductTypeTags(), ",")+"</ptl>"; //Insert 4th level to keywords fields
			String keywords="<kw>"+subKeywords_1+subKeywords_2+subKeywords_3+subKeywords_4+productTypeList+productList+categoryList+divisionList+"</kw>";
			//
			domain.setKeyword(keywords);
			domain.setLastupdateby(2); //System user
			
			//Compute the total price from board price (totalPrice = boardPrice*(1+commissionRate))
			domain.setBoardPrice(new BigDecimal(formBean.getPrice()));
			membershipRequest.setUserId(board.getBoard().getOriginalUserId());
			membershipResponse =  membershipServiceSDK.getMembershipCommissiondetails(membershipRequest);
			BigDecimal commissionRate=membershipResponse.getStPricingOptions().getCommission();
			BigDecimal rate=commissionRate.divide(new BigDecimal(100.00));
			BigDecimal totalPrice=new BigDecimal(formBean.getPrice()).multiply((rate.add(new BigDecimal(1.0))));
			domain.setTotalPrice(totalPrice);
			
			updateResponse=boardServiceSDK.updateBoardByAdmin(updateRequest);
			if(updateResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				model.addAttribute("hasError", false);
				model.addAttribute("errorCode", updateResponse.getStatus().getStatuscode());
			}
			else
			{
				model.addAttribute("hasError", true);
				model.addAttribute("errorCode", updateResponse.getStatus().getStatuscode());
			}
		}
		return model;
	}
	
	private void boardsFilter(List<TrBoardDomain> domain)
	{
		Predicate<TrBoardDomain> filter = new Predicate<TrBoardDomain>()
		{ 
			public boolean apply(TrBoardDomain item)
			{
				//if the board is not available, inactive or unpublished boards. Filtered out the array.
				if(item.getActiveStatus()==ActiveStatusEnum.INACTIVE.value() 
						|| item.getPublishToMP()==Constants.PUBLISH_TO_MARKET_NO 
						|| item.getStatusId()!=LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId() 
						|| item.getOriginalUserId()!=item.getCurrentUerId()
						|| XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(item.getExperiationDate()).before(Calendar.getInstance()))
					return true;
				else
					return false;
			}
		};
		Collection<TrBoardDomain> collection = Collections2.filter(domain, filter);
		collection.clear();
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_APPROVER_COMMENTS, method = RequestMethod.GET)
	public String getApproverCommentsHistory(@RequestParam(value="uid") Integer userId, @ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			map.addAttribute("canRender", true);
			ViewUserResponse response = registrationServiceSDK.viewUser(userId);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				map.addAttribute("comments", response.getUser().getApproverComments());
				map.addAttribute("hasError", false);
			}
			else
			{
				map.addAttribute("hasError", true);
			}
		}
		else
			map.addAttribute("canRender", false);
		return ViewNames.ADMIN_APPROVER_COMMENTS_HISTORY;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_APPROVER_COMMENTS, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateApproverComments(@RequestParam(value="uid") Integer userId, @RequestParam(value="comment") String comment, @ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		ModelMap model = new ModelMap();
		if(items.contains(Integer.toString(user.getUserId())))
		{
			model.addAttribute("canRender", true);
			UpdateApproverCommentRequest request = new UpdateApproverCommentRequest();
			request.setUserId(userId);
			request.setApproverComment(comment);
			UpdateApproverCommentResponse response = registrationServiceSDK.updateApproverComment(request);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				model.addAttribute("comments", response.getApproverComment());
				model.addAttribute("hasError", false);
			}
			else
			{
				model.addAttribute("hasError", true);
			}
		}
		else
			model.addAttribute("canRender", false);
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_RETRIEVE_ERROR_FILE, method = RequestMethod.GET)
	public void retrieveErrorFile(@RequestParam(value="sourcefile") String sourceFile, @ModelAttribute("user") AdUsersDomain user,HttpServletResponse response, ModelMap map) 
	{
		retrieveFile(response,this.profileLocation_error_files, this.profileLocation_files, sourceFile, user);
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_RETRIEVE_FILE, method = RequestMethod.GET)
	public void retrieveSourceFile(@RequestParam(value="sourcefile") String sourceFile, @ModelAttribute("user") AdUsersDomain user,HttpServletResponse response, ModelMap map) 
	{
		retrieveFile(response, this.profileLocation_error_files, this.profileLocation_files, sourceFile, user);
	}
	
	private void retrieveFile(HttpServletResponse response, String location, String fallbackLocation, String targetFileName, AdUsersDomain user)
	{
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		File target = new File(location + targetFileName);
		File fallbackTarget = new File(fallbackLocation + targetFileName);
		if(items.contains(Integer.toString(user.getUserId())))
		{
			try
			{
				if(target.exists())
				{
					InputStream is = new FileInputStream(target);
			      	//response.setContentLength((int)filetoDownload.getTotalSpace()); //Disabled this because it will give wrong file size information
			      	response.setHeader("Content-Disposition","attachment; filename=\""+targetFileName+"\"");
			      	IOUtils.copy(is, response.getOutputStream());
			      	response.flushBuffer();
				}
				else
				{
					if(fallbackTarget.exists())
					{
						//fallback location
						InputStream is = new FileInputStream(fallbackTarget);
				      	//response.setContentLength((int)filetoDownload.getTotalSpace()); //Disabled this because it will give wrong file size information
				      	response.setHeader("Content-Disposition","attachment; filename=\""+targetFileName+"\"");
				      	IOUtils.copy(is, response.getOutputStream());
				      	response.flushBuffer();	
					}
					else
					{
						response.setContentType(MediaType.TEXT_PLAIN);
						response.setStatus(HttpStatus.NOT_FOUND.value());
						response.getOutputStream().print("File not found.");
						response.flushBuffer();
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				response.setContentType(MediaType.TEXT_PLAIN);
				response.setStatus(HttpStatus.NOT_FOUND.value());
				response.getOutputStream().print("Unauthorized user.");
				response.flushBuffer();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_UPDATE_RATING, method = RequestMethod.GET)
	public String showAdminRating(@RequestParam(value="uid") Integer uid, @ModelAttribute("user") AdUsersDomain user, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			ViewUserResponse response = registrationServiceSDK.viewUser(uid);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				map.addAttribute("hasError", false);
				
				map.addAttribute("adminRatingUser", response.getUser());
				map.addAttribute("adminRatingValue", response.getUser().getAdminRating());
			}
			else
			{
				map.addAttribute("hasError", true);
				map.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
				map.addAttribute("errorDescription", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getDefaultMessage());
			}
		}
		else
		{
			map.addAttribute("hasError", true);
			map.addAttribute("errorCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
			map.addAttribute("errorDescription", ErrorsCodeEnum.UNAUTHORIZED_USER.getDefaultMessage());
		}
		return ViewNames.ADMIN_RATING_PANEL;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_UPDATE_RATING, method = RequestMethod.POST)
	public @ResponseBody ModelMap updateAdminRating(@RequestParam(value="uid") Integer uid,@RequestParam("score") Float score, @ModelAttribute("user") AdUsersDomain user, ModelMap map) {
		ModelMap model = new ModelMap();
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			UpdateAdminRatingRequest request = new UpdateAdminRatingRequest();
			request.setUserId(uid);
			request.setRating(score);
			UpdateAdminRatingResponse response = registrationServiceSDK.updateApprovalRating(request);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				model.addAttribute("hasError", false);
			else
			{
				model.addAttribute("hasError", true);
				model.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
				model.addAttribute("errorDescription", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getDefaultMessage());
			}
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
			model.addAttribute("errorDescription", ErrorsCodeEnum.UNAUTHORIZED_USER.getDefaultMessage());
		}
		return model;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_DASHBOARD, method = RequestMethod.GET)
	public String overview(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			map.addAttribute("canRender", true);
			map.addAttribute("dashboard", "selected");
		}
		else
			map.addAttribute("canRender", false);
		return ViewNames.ADMIN_DASHBOARD;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_SEARCH_CRITERIA, method = RequestMethod.GET)
	public String showSearchCriteria(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			map.addAttribute("canRender", true);
			map.addAttribute("search_criteria", "selected");
		}
		else
			map.addAttribute("canRender", false);
		return ViewNames.ADMIN_SEARCH_CRITERIA;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ViewPaths.ADMIN_SEARCH_CRITERIA, method = RequestMethod.POST)
	public @ResponseBody ModelMap syncAdminSearch(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) 
	{
		ModelMap model = new ModelMap();
		if(map.containsKey("adminSearchResult"))
		{
			ModelMap searchResult = (ModelMap) map.get("adminSearchResult");
			model.addAttribute("syncSearchResult", searchResult);
		}
		else
			model.addAttribute("syncSearchResult", 0);
		return model;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ViewPaths.ADMIN_SEARCH_VIEWER, method = RequestMethod.GET)
	public String showSearchPortfolioPages(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(user.getUserId())))
		{
			map.addAttribute("canRender", true);
			map.addAttribute("search_criteria", "selected");
		}
		else
			map.addAttribute("canRender", false);
		return ViewNames.ADMIN_SEARCH_VIEWER;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_SEARCH_VIEWER, method = RequestMethod.POST)
	public @ResponseBody ModelMap syncSearchResult(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) {
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		ModelMap model = new ModelMap();
		if(items.contains(Integer.toString(user.getUserId())))
		{
			if(map.containsKey("adminSearchResult"))
			{
				ModelMap searchResult = (ModelMap) map.get("adminSearchResult");
				model.addAttribute("finalSearchResult", searchResult);
			}
			else
			{
				model.addAttribute("finalSearchResult", 0);
			}
		}
		return model;
	}
	
	//Get users list
	@RequestMapping(value = ViewPaths.ADMIN_USERS_VIEWER_DATA, method = RequestMethod.GET)
	public @ResponseBody ModelMap getUsersInfo(@ModelAttribute("user") AdUsersDomain user, @ModelAttribute("timezoneOffset") Integer timezoneOffset, @RequestParam(value="usertype",defaultValue="all") String userTypeFilter,@RequestParam(value="filter",defaultValue="all") String filter,@RequestParam(value="sortoption",defaultValue="-4") Integer sortOption, @RequestParam(value="p",defaultValue="1") Integer page,ModelMap map) {
		//ModelMap
		ModelMap model = new ModelMap();
		//detect the user have the permission to access this page or not.
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		Integer itemsPerPage = 30;
		if(items.contains(Integer.toString(user.getUserId())))
		{
			GetUsersListRequest request=new GetUsersListRequest();
			//Set user type.
			AdLookupValuesDomain designerUserType=new AdLookupValuesDomain();
			designerUserType.setLookupValueId(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeId());
			designerUserType.setLookupCode(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode());
			AdLookupValuesDomain companyUserType=new AdLookupValuesDomain();
			companyUserType.setLookupValueId(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeId());
			companyUserType.setLookupCode(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
			if(userTypeFilter.equals("all") || userTypeFilter.equals("designer"))
				request.getUserType().add(designerUserType);
			if(userTypeFilter.equals("all") || userTypeFilter.equals("company"))
				request.getUserType().add(companyUserType);
			//Set registration status to retrieve 431,432,433
			AdLookupValuesDomain regStatusCompletedForm=new AdLookupValuesDomain();
			AdLookupValuesDomain regStatusConfirmed=new AdLookupValuesDomain();
			AdLookupValuesDomain regStatusWaiting=new AdLookupValuesDomain();
			AdLookupValuesDomain regStatusRejected=new AdLookupValuesDomain();
			AdLookupValuesDomain regSubmitSamplesCompleted=new AdLookupValuesDomain();
			if(filter.equals("all") || filter.equals("approved"))
			{
				regStatusConfirmed.setLookupValueId(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeId());
				regStatusConfirmed.setLookupCode(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode());
				request.getRegStatus().add(regStatusConfirmed);
			}
			if(filter.equals("all") || filter.equals("rc") || filter.equals("waitapproval"))
			{
				regStatusCompletedForm.setLookupValueId(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeId());
				regStatusCompletedForm.setLookupCode(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeCode());
				request.getRegStatus().add(regStatusCompletedForm);
			}
			if(filter.equals("all") || filter.equals("sbsc") || filter.equals("waitapproval"))
			{
				regSubmitSamplesCompleted.setLookupValueId(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeId());
				regSubmitSamplesCompleted.setLookupCode(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeCode());
				request.getRegStatus().add(regSubmitSamplesCompleted);
			}
			if(filter.equals("all") || filter.equals("wc") || filter.equals("waitapproval"))
			{
				regStatusWaiting.setLookupValueId(LookupTypeValueEnum.REG_STATUS_WAITING_FOR_COFIRMATION.getTypeId());
				regStatusWaiting.setLookupCode(LookupTypeValueEnum.REG_STATUS_WAITING_FOR_COFIRMATION.getTypeCode());
				request.getRegStatus().add(regStatusWaiting);
			}
			if(filter.equals("all") || filter.equals("rejected"))
			{
				regStatusRejected.setLookupValueId(LookupTypeValueEnum.REG_STATUS_DENIED.getTypeId());
				regStatusRejected.setLookupCode(LookupTypeValueEnum.REG_STATUS_DENIED.getTypeCode());
				request.getRegStatus().add(regStatusRejected);
			}
			//setup sortOption and pagination value
			request.setSortOption(sortOption);
			if(page==-1)
			{
				request.setFirstResult(-1);
				request.setMaxResult(-1);
				model.addAttribute("showAll", true);
			}
			else
			{
				request.setFirstResult((page-1)*itemsPerPage);
				request.setMaxResult(itemsPerPage);
				model.addAttribute("showAll", false);
			}
			GetUsersListResponse response = registrationServiceSDK.getUsersList(request);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				//model.addAttribute("users", response.getUsers());
				HashMap<Integer, String> expDateHM = new HashMap<Integer, String>();
				HashMap<Integer, String> effectiveDateHM = new HashMap<Integer, String>();
				//convert the expiration date to Date
				/*for(UserInfoDomain item : response.getUsers())
				{
					if(item.getMembership().size() > 0)
					{	
						item.getMembership().get(0).setExperiationDate(TimeConvertUtil.convertToLocalTime(item.getMembership().get(0).getExperiationDate(), timezoneOffset));
						//Add one day on the signed up date
						item.getMembership().get(0).setEffectiveDate(TimeConvertUtil.convertToLocalTime(item.getMembership().get(0).getEffectiveDate(), timezoneOffset,24));
						String dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(item.getMembership().get(0).getExperiationDate().toGregorianCalendar().getTime());
						expDateHM.put(item.getUserId(), dateString);
						dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(item.getMembership().get(0).getEffectiveDate().toGregorianCalendar().getTime());
						effectiveDateHM.put(item.getUserId(), dateString);
					}
				}*/
				//
				for(AdUsersDomain item : response.getUsersAdUsersDomain())
				{
					//
					item.getUserMembership().get(0).setExperiationDate(TimeConvertUtil.convertToLocalTime(item.getUserMembership().get(0).getExperiationDate(), timezoneOffset));
					//Add one day on the signed up date
					item.getUserMembership().get(0).setEffectiveDate(TimeConvertUtil.convertToLocalTime(item.getUserMembership().get(0).getEffectiveDate(), timezoneOffset,24));
					String dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(item.getUserMembership().get(0).getExperiationDate().toGregorianCalendar().getTime());
					expDateHM.put(item.getUserId(), dateString);
					dateString = new SimpleDateFormat("MMM-dd-yyyy hh:mm a").format(item.getUserMembership().get(0).getEffectiveDate().toGregorianCalendar().getTime());
					effectiveDateHM.put(item.getUserId(), dateString);
					//compute profile score
					UserProfileChecker checker = new UserProfileChecker();
					checker.getProfileProgressInfo(item);
					item.setProfileScore(checker.getScore());
				}
				model.addAttribute("users", response.getUsersAdUsersDomain());
				model.addAttribute("expDateHM", expDateHM);
				model.addAttribute("effectiveDateHM", effectiveDateHM);
				model.addAttribute("usersCount", response.getTotal());
				model.addAttribute("canRender", true);
				model.addAttribute("currentPage", page);
				Double totalPages = Math.ceil(response.getTotal()/itemsPerPage)+1;
				model.addAttribute("totalPages", totalPages.intValue());
				//calculate prev and next page
				Double nextPage = (page+1)%totalPages;
				Double prevPage = (page-1)%totalPages;
				if(prevPage <= 0)
					prevPage=totalPages;
				model.addAttribute("pPrevPage", prevPage.intValue());
				model.addAttribute("pNextPage", nextPage.intValue());
			}
			else
			{
				model.addAttribute("canRender", false);
				model.addAttribute("renderTypeCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
			}
		}
		else
		{
			model.addAttribute("canRender", false);
			model.addAttribute("renderTypeCode", ErrorsCodeEnum.UNAUTHORIZED_USER.getCode());
		}
		HashMap<String, String> filterMap=new HashMap<String, String>();
		filterMap.put(filter, "selected=\"selected\"");
		model.addAttribute("filter", filterMap);
		HashMap<String, String> userTypeFilterMap=new HashMap<String, String>();
		userTypeFilterMap.put(userTypeFilter, "selected=\"selected\"");
		model.addAttribute("userTypeFilter", userTypeFilterMap);
		//sortOptionHM
		HashMap<String, String> sortOptionHM=new HashMap<String, String>();
		sortOptionHM.put(sortOption.toString(), "selected=\"selected\"");
		model.addAttribute("sortOptionHM", sortOptionHM);
		model.addAttribute("pUsertype", userTypeFilter);
		model.addAttribute("pFilter", filter);
		model.addAttribute("pSortoption", sortOption);
		model.addAttribute("pPage", page);
		return model;
	}
	
	@RequestMapping(value=ViewPaths.ADMIN_SEARCH_RESULT,method=RequestMethod.GET)
	//public String searchResult(SearchCriteriaForm formBean, ModelMap model)
	public @ResponseBody ModelMap adminSearchResult(SearchCriteriaForm formBean, @ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model)
	{
		logger.trace("SEARCH RESULT formBean=>"+formBean.toString());
		
		SearchBoardsRequest request = new SearchBoardsRequest();
		request.setDesignerName(formBean.getDesignerName());
		
		
		List<Integer> countryIds = request.getCountryIds();
		if(null != formBean.getCountry())
			countryIds.add(formBean.getCountry());

		List<Integer>  langIds =request.getLanguageIds();
		
		if(null != formBean.getLangs()){
			for(Integer id : formBean.getLangs()){
				langIds.add(id);
			}			
		}
		
		
		List<Integer> skillIds = request.getSkillIds();
		if(null != formBean.getSkills()){
			for(Integer id : formBean.getSkills()){
				skillIds.add(id);
			}
		}
		
		//
		List<Integer> seasonYearIds = request.getSeasonYearIds();
		if(null != formBean.getSeason()){
			for(Integer id : formBean.getSeason()){
				seasonYearIds.add(id);
			}
		}
		
		List<Integer> saleTypeIds = request.getSaleTypeIds();//Image formats
		if(null != formBean.getSaleTypes()){
			for(Integer id : formBean.getSaleTypes()){
				saleTypeIds.add(id);
			}
		}

		List<String> productType = request.getProductType(); //Set product type values
		if(null != formBean.getProductType()){
			for(String value : formBean.getProductType()){
				productType.add(value);
			}
		}
		
		//08042014 Fred - Add expertise, specialty, education================
		List<Integer> expertiseIds = request.getExpertiseIds();
		if(null != formBean.getExpId()){
			for(Integer id: formBean.getExpId()){
				expertiseIds.add(id);
			}
		}
		
		List<Integer> specialtyIds = request.getSpecialtyIds();
		if(null != formBean.getSplId()){
			for(Integer id: formBean.getSplId()){
				specialtyIds.add(id);
			}
		}
		
		List<Integer> educationIds = request.getEducationIds();
		if(null != formBean.getEduId()){
			for(Integer id: formBean.getEduId()){
				educationIds.add(id);
			}
		}
		//=====================================================================
		
		request.setDivision(formBean.getDivision());
		request.setCategory(formBean.getCategory());
		request.setProduct(formBean.getProduct()); 
		//request.setPriceOption(formBean.getPriceRange());
		request.setPriceOption(null);
		//08082014
		request.setMinPrice(new BigDecimal(formBean.getMinPrice()));
		request.setMaxPrice(new BigDecimal(formBean.getMaxPrice()));
		request.setMinAdminRating(formBean.getMinAdminRating());
		request.setMaxAdminRating(formBean.getMaxAdminRating());
		request.setMinBuyerRating(formBean.getMinBuyerRating());
		request.setMaxBuyerRating(formBean.getMaxBuyerRating());
		//======================================================

		request.setRatingOption(formBean.getRatings());
		request.setSchoolAwards(formBean.getMisc());
		request.setKeywords(StringEscapeUtils.escapeXml(formBean.getKeywords()));
		
		try 
		{
			Calendar begin = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
			if(formBean.getPortfolioSearchStartDate()!=null)
			{
				begin.setTime(dateFormat.parse(formBean.getPortfolioSearchStartDate()));
			}
			else
			{
				begin.set(2000, 1, 1); //set to long time back
			}
			
			if(formBean.getPortfolioSearchEndDate()!=null)
			{
				end.setTime(dateFormat.parse(formBean.getPortfolioSearchEndDate()));
			}
			
			request.setPortfoliosearchstartdate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(begin));
			request.setPortfoliosearchenddate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(end));
		} 
		catch (DatatypeConfigurationException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//assign searching user id
		request.setUserId(adUser.getUserId());
		ModelMap modelMap = new ModelMap();
		request.setIsPortfolioSearch(false);
		SearchBoardsResponse marketplaceSubmissionResponse = boardServiceSDK.searchBoards(request); //marketplace submission search
		
		//=========================================================================
		//Run portfolio page search
		//reset the board category to perform portfolio page search
		request.setPriceOption(null);
		request.setMinPrice(new BigDecimal(0));
		request.setMaxPrice(new BigDecimal(30000));
		request.setDivision(null);
		request.setCategory(null);
		request.setProduct(null);
		request.getProductType().clear();
		request.setIsPortfolioSearch(true);
		SearchBoardsResponse portfolioPageResponse = boardServiceSDK.searchBoards(request); //portfolio page search
		
		//=========================================================================
		//Run examples search
		//setup request params
		SearchExampleBoardsRequest searchExamplesRequest = new SearchExampleBoardsRequest();
		searchExamplesRequest.setDesignerName(formBean.getDesignerName());
		searchExamplesRequest.getCountryIds().addAll(countryIds);
		searchExamplesRequest.getLanguageIds().addAll(langIds);
		searchExamplesRequest.getSkillIds().addAll(skillIds);
		searchExamplesRequest.getExpertiseIds().addAll(expertiseIds);
		searchExamplesRequest.getSpecialtyIds().addAll(specialtyIds);
		searchExamplesRequest.getEducationIds().addAll(educationIds);
		searchExamplesRequest.setMinAdminRating(formBean.getMinAdminRating());
		searchExamplesRequest.setMaxAdminRating(formBean.getMaxAdminRating());
		searchExamplesRequest.setIsPortfolioSearch(true);
		searchExamplesRequest.setSchoolAwards(formBean.getMisc());
		searchExamplesRequest.setPortfoliosearchstartdate(request.getPortfoliosearchstartdate());
		searchExamplesRequest.setPortfoliosearchenddate(request.getPortfoliosearchenddate());
		searchExamplesRequest.setRatingOption(null);
		searchExamplesRequest.setUserId(adUser.getUserId());
		SearchExampleBoardsResponse searchExamplesResponse = boardServiceSDK.searchExampleBoards(searchExamplesRequest);
		
		if(portfolioPageResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())
			&& marketplaceSubmissionResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())
			&& searchExamplesResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			modelMap.addAttribute("hasError", false);
		}else
		{
			modelMap.addAttribute("hasError", true);
			if(portfolioPageResponse.getStatus().getStatuscode().equals(StatusCodesEnum.MAXIMUM_RECORDS_REACHED.getCode()))
			{
				modelMap.addAttribute("errorCode", ErrorsCodeEnum.MAX_SEARCH_RESULT_REACHED.getCode());
				modelMap.addAttribute("errorDescription", ErrorsCodeEnum.MAX_SEARCH_RESULT_REACHED.getDefaultMessage());
			}
			else
			{
				modelMap.addAttribute("errorCode", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getCode());
				modelMap.addAttribute("errorDescription", ErrorsCodeEnum.SERVICE_UNAVAILABLE.getDefaultMessage());
			}
		}
		//prepare profile result from marketplace submission
		List<String> profiles = new ArrayList<String>();
		for(TrBoardSearchDomain item : portfolioPageResponse.getTrBoardSearchDomains())
		{
			if(!profiles.contains(item.getDesignerName()))
				profiles.add(item.getDesignerName());
		}
		//logger.trace("SEARCH RESULT SIZE=>"+portfolioPageResponse.getTrBoardSearchDomains().size());
		//prepare JSON object
		ModelMap allResult = new ModelMap();
		ModelMap portfolioPagesResult = new ModelMap();
		ModelMap marketplaceSubmissionResult = new ModelMap();
		ModelMap examplesResult = new ModelMap();
		ModelMap profilesResult = new ModelMap();
		//Search data
		portfolioPagesResult.addAttribute("data", portfolioPageResponse.getTrBoardSearchDomains());
		marketplaceSubmissionResult.addAttribute("data", marketplaceSubmissionResponse.getTrBoardSearchDomains());
		profilesResult.addAttribute("data", profiles);
		examplesResult.addAttribute("data", searchExamplesResponse.getTrBoardSearchDomains());
		//Bind all data to response object
		allResult.addAttribute("portfolioPages", portfolioPagesResult);
		allResult.addAttribute("marketplaceSubmission", marketplaceSubmissionResult);
		allResult.addAttribute("profiles", profilesResult);
		allResult.addAttribute("examples", examplesResult);
		allResult.addAttribute("form", formBean);
		modelMap.addAttribute("result", allResult);
		//
		model.addAttribute("adminSearchResult", allResult); //put search result into session
		return modelMap;
	}
	
	//Dash board info
	@RequestMapping(value=ViewPaths.ADMIN_DASHBOARD,method=RequestMethod.POST)
	public @ResponseBody ModelMap getDashboardInfo(@ModelAttribute(value="user") AdUsersDomain adUser) 
	{
		ModelMap model = new ModelMap();
		
		GetBoardsByPMRequest request=new GetBoardsByPMRequest();
		List<Integer> pmpList = request.getPublishToMP();
		List<Integer> portfolioTypes = request.getPortfolioTypes();
		
		pmpList.add(Constants.PUBLISH_TO_MARKET_YES);
		pmpList.add(Constants.PUBLISH_TO_MARKET_REVIEWING);
		portfolioTypes.add(ActiveStatusEnum.ACTIVE.value());
		portfolioTypes.add(ActiveStatusEnum.INACTIVE.value());
		request.setUserId(adUser.getUserId()); //for security purpose, check the user privilege on service side also.
		
		GetBoardsByPMResponse boardsResponse = boardServiceSDK.fetchBoardsByPMStatus(request);
				
		GetAllSamplesResponse examplesResponse = boardServiceSDK.getAllSamples();
		if(examplesResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode())
			&& boardsResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			model.addAttribute("hasError", false);
			model.addAttribute("examplesCount", examplesResponse.getSamples().size());
			model.addAttribute("boardsCount", boardsResponse.getBoards().size());
		}
		else
		{
			model.addAttribute("hasError", true);
		}
		return model;
	}
	
	//specialty
	@RequestMapping(value=ViewPaths.SPECIALTY_LIST,method=RequestMethod.GET)
	public @ResponseBody ModelMap getSpecialtiesList() {
		ModelMap model = new ModelMap();
		model.addAttribute("list", registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeName()).getLookupTypeValues());
		return model;
	}
	
	//Languages 
	@RequestMapping(value=ViewPaths.LANGUAGE_LIST,method=RequestMethod.GET)
	public @ResponseBody ModelMap getLanguagesList() 
	{
		ModelMap model = new ModelMap();
		model.addAttribute("list", registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.ISO_LANGUAGES.getTypeName()).getLookupTypeValues());
		return model;
	}
	
	//Skills 
	@RequestMapping(value=ViewPaths.SKILL_LIST,method=RequestMethod.GET)
	public @ResponseBody ModelMap getSkillsList() 
	{
		ModelMap model = new ModelMap();
		model.addAttribute("list", registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.USER_SKILLS.getTypeName()).getLookupTypeValues());
		return model;
	}
	
	//expertise
	@RequestMapping(value=ViewPaths.EXPERTISE_LIST,method=RequestMethod.GET)
	public @ResponseBody ModelMap getExpertiseList() {
		ModelMap model = new ModelMap();
		model.addAttribute("list", registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.AREA_OF_EXPERTISE.getTypeName()).getLookupTypeValues());
		return model;
	}
	
	//specialty
	@RequestMapping(value=ViewPaths.EDUCAION_LIST,method=RequestMethod.GET)
	public @ResponseBody ModelMap getEducationList() {
		ModelMap model = new ModelMap();
		model.addAttribute("list", registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.EDUCATION.getTypeName()).getLookupTypeValues());
		return model;
	}
	
	//buyer list
	@RequestMapping(value=ViewPaths.BUYER_LIST,method=RequestMethod.GET)
	public @ResponseBody ModelMap getBuyerList() {
		ModelMap map = new ModelMap();
		//get buyer list
		GetUsersListRequest request = new GetUsersListRequest();
		AdLookupValuesDomain buyer = new AdLookupValuesDomain();
		AdLookupValuesDomain approved = new AdLookupValuesDomain();
		buyer.setLookupCode(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode());
		approved.setLookupCode(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode());
		request.getUserType().add(buyer);
		request.getRegStatus().add(approved);
		GetUsersListResponse response = registrationServiceSDK.getUsersList(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			map.addAttribute("buyerList", response.getUsersAdUsersDomain());
			map.addAttribute("hasError",false);
		}
		else
			map.addAttribute("hasError",true);
		return map;
	}
	
	//members page 
	@RequestMapping(value=ViewPaths.ADMIN_MEMBERS,method=RequestMethod.GET)
	public String showAdminMembersView(@ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		return ViewNames.ADMIN_MEMBERS;
	}
	
	//Ajax path retrieval
	@RequestMapping(value=ViewPaths.ADMIN_AJAX_PATHS,method=RequestMethod.GET)
	public String retrieveAjaxPaths(ModelMap model) 
	{
		return ViewNames.ADMIN_AJAX_PATHS;
	}
	
	//Projects Basic frame
	@RequestMapping(value={ViewPaths.ADMIN_PROJECTS, 
			ViewPaths.ADMIN_PROJECTS_CREATE_PROJECT,
			ViewPaths.ADMIN_PROJECTS_APPROVE_SUBMISSIONS+"/{portfolioId}",
			ViewPaths.ADMIN_PROJECTS_UPDATE_PROJECT+"/{portfolioId}",
			ViewPaths.ADMIN_PROJECTS_UPDATE_PROJECT+"/{portfolioId}/{contestId}",
			ViewPaths.ADMIN_PROJECTS_MANAGE_PROJECTS},method=RequestMethod.GET)
	public String showAdminProjectsBasicView(@ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		return ViewNames.ADMIN_PROJECTS;
	}
	
	//Projects create project content
	@RequestMapping(value={ViewPaths.ADMIN_PROJECTS_CREATE_PROJECT_CONTENT, ViewPaths.ADMIN_PROJECTS_UPDATE_PROJECT},method=RequestMethod.GET)
	public String showAdminCreateProjectView(@ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		return ViewNames.ADMIN_PROJECTS_CREATE_PROJECT;
	}
	
	//Projects manage projects content
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_MANAGE_PROJECTS_CONTENT,method=RequestMethod.GET)
	public String showAdminManageProjectsView(@ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		return ViewNames.ADMIN_PROJECTS_MANAGE_PROJECTS;
	}
	
	//Projects approve projects content
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_APPROVE_SUBMISSIONS_CONTENT,method=RequestMethod.GET)
	public String showAdminApproveSubmissionsView(@ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ViewAccess viewAccess=new ViewAccess();
		viewAccess.assignBoardViewerAccess(model,false,false,true,true,true,true,false,false,true);
		return ViewNames.ADMIN_PROJECTS_APPROVE_SUBMISSIONS;
	}
	
	//Get project list data or specific project information by passing portfolioId
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_MANAGE_PROJECTS_DATA,method=RequestMethod.GET)
	public @ResponseBody ModelMap getProjectListData(@RequestParam(value="portfolioId",defaultValue="-1",required=false) Integer portfolioId,@RequestParam(value="contestId",defaultValue="-1",required=false) Integer contestId, @RequestParam(value="access",defaultValue="detail") String mode,@ModelAttribute(value="user") AdUsersDomain adUser, @ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM, @ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		DomainToFormConverter converter=new DomainToFormConverter();
		GetAllContestsResponse response = portfolioServiceSDK.getAllContests();
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			//filter out inactive portfolio
			List<TrPortfolioContestDomain> result=new ArrayList<TrPortfolioContestDomain>();
			for(TrPortfolioContestDomain item:response.getContest())
			{
				if(item.getContestPortfolioDomain().getActiveStatus()==ActiveStatusEnum.ACTIVE.value()
					&& (item.getPortfolioId()==portfolioId || portfolioId==-1 ))//get the specific project if portfolioId is assigned
					result.add(item);
			}
			map.addAttribute("hasError", false);
			
			if(result.size()>0)
			{
				if(mode.toUpperCase().equals("DETAIL"))
				{
					List<ContestBean> beans = converter.convertDomainToForm(result, seasonYearHM, timezoneOffset);
					map.addAttribute("contests", beans);
				}
				else
				{
					List<ContestBeanBasic> beans = converter.convertDomainToBasicForm(result, seasonYearHM, timezoneOffset);
					map.addAttribute("contests", beans);
				}
			}
		}
		else
		{
			map.addAttribute("hasError", true);
		}
		return map;
	}
	
	//get the project detail by passing portfolioId and contestId
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_PROJECT_DETAIL,method=RequestMethod.GET)
	public @ResponseBody ModelMap getProjectDetail(@RequestParam(value="portfolioId",defaultValue="-1",required=false) Integer portfolioId,@RequestParam(value="contestId",defaultValue="-1",required=false) Integer contestId, @RequestParam(value="access",defaultValue="detail") String mode,@ModelAttribute(value="user") AdUsersDomain adUser, @ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM, @ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		DomainToFormConverter converter=new DomainToFormConverter();
		if(portfolioId!=-1 && contestId!=-1)
		{
			GetContestDetailsResponse response = portfolioServiceSDK.getContestDetails(portfolioId, contestId);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				//filter out inactive portfolio
				List<TrPortfolioContestDomain> result=new ArrayList<TrPortfolioContestDomain>();
				TrPortfolioContestDomain item=response.getContest();
				if(item.getContestPortfolioDomain().getActiveStatus()==ActiveStatusEnum.ACTIVE.value())//get the specific project if portfolioId is assigned
					result.add(item);
				map.addAttribute("hasError", false);
				
				if(result.size()>0)
				{
					if(mode.toUpperCase().equals("DETAIL"))
					{
						List<ContestBean> beans = converter.convertDomainToForm(result, seasonYearHM, timezoneOffset);
						map.addAttribute("contests", beans);
					}
					else
					{
						List<ContestBeanBasic> beans = converter.convertDomainToBasicForm(result, seasonYearHM, timezoneOffset);
						map.addAttribute("contests", beans);
					}
				}
			}
			else
			{
				map.addAttribute("hasError", true);
			}
		}
		else
			map.addAttribute("hasError", true);
		return map;
	}
	
	//get assigned members for the project
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_PROJECT_MEMBERS+"/{portfolioId}/{contestId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap getProjectMembers(@PathVariable(value="portfolioId") Integer portfolioId, @PathVariable(value="contestId") Integer contestId, @ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		GetContestMembersResponse response = portfolioServiceSDK.getContestMembers(portfolioId);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			map.addAttribute("hasError", false);
			map.addAttribute("members", response.getMember());
		}
		else
		{
			map.addAttribute("hasError", true);
		}
		return map;
	}
	
	//assign project members
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_ASSIGN_PROJECT_MEMBERS+"/{portfolioId}",method=RequestMethod.POST)
	public @ResponseBody ModelMap assignProjectMembers(@RequestParam(value="uid") Integer[] uIds, @PathVariable(value="portfolioId") Integer portfolioId, @ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		AssignMembersToContestRequest request = new AssignMembersToContestRequest();
		request.setPortfolioid(portfolioId);
		List<TrPortfolioContestMembersDomain> members=new ArrayList<TrPortfolioContestMembersDomain>();
		//assign members
		for(Integer uid: uIds)
		{
			TrPortfolioContestMembersDomain member=new TrPortfolioContestMembersDomain();
			member.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
			member.setPortfolioId(portfolioId);
			member.setUserId(uid);
			member.setCreatedby(adUser.getUserId());
			member.setLastupdateby(adUser.getUserId()); 
			members.add(member);
		}
		request.getMember().addAll(members);
		AssignMembersToContestResponse response = portfolioServiceSDK.assignMembersToContest(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			map.addAttribute("hasError", false);
		}
		else
		{
			map.addAttribute("hasError", true);
		}
		return map;
	}
	
	@RequestMapping(value = {ViewPaths.ADMIN_PROJECTS_BOARDS_DATA}, method=RequestMethod.GET)
	public @ResponseBody ModelMap getContestBoards(@RequestParam(value="portfolioId") Integer[] portfolioIds, @ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		HashMap<Integer, List<TrBoardDomain>> boardsMap= new LinkedHashMap<Integer, List<TrBoardDomain>>();
		Boolean hasError=false;
		for(Integer portfolioId: portfolioIds)
		{
			GetBoardsByPortfolioResponse response = boardServiceSDK.getBoardsbyPortfolioId(portfolioId);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				//Add to the collection only if the active board(active_status == 0)
				List<TrBoardDomain> boards=new ArrayList<TrBoardDomain>();
				for(TrBoardDomain item: response.getBoards())
				{
					if(item.getActiveStatus()==ActiveStatusEnum.ACTIVE.value())
						boards.add(item);
				}
				boardsMap.put(portfolioId, boards);
			}
			else
				hasError=true;
		}
		map.addAttribute("boards", boardsMap);
		map.addAttribute("hasError", hasError);
		return map;
	}
	
	//Projects start project
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_START_PROJECT,method=RequestMethod.GET)
	public @ResponseBody ModelMap startProject(@ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model) 
	{
		ModelMap map = new ModelMap();
		//get Board Dimension list from container
		List<AdLookupValuesDomain> boardDimension=(List<AdLookupValuesDomain>) model.get("boardDimension");
		//get Board Format list from container
		List<AdLookupValuesDomain> boardFormat=(List<AdLookupValuesDomain>) model.get("boardFormat");
		Boolean hasError=false;
		//create the template project
		CreateContestRequest request = new CreateContestRequest();
		TrPortfolioDomain portfolioDomain = new TrPortfolioDomain();
		TrPortfolioContestDomain contestDomain = new TrPortfolioContestDomain();
		contestDomain.setContestPortfolioDomain(portfolioDomain);
		request.setContest(contestDomain);
		//portfolio table info
		portfolioDomain.setPortfolioId(0);
		portfolioDomain.setName("{{DEFAULT}}");
		portfolioDomain.setDescription("{{DEFAULT}}");
		portfolioDomain.setSeasonYearId(5);
		GetCategoriesResponse level1 = registrationServiceSDK.getCategories(1, 0);
		//get available first level category value
		if(level1.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()) && level1.getStCategoryMasterDomain().size()>0)
		{
			//get available second level category value by level 1 id.
			GetCategoriesResponse level2 = registrationServiceSDK.getCategories(2, level1.getStCategoryMasterDomain().get(0).getCategoryId());
			if(level2.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()) && level2.getStCategoryMasterDomain().size()>0)
			{
				portfolioDomain.setCategoryLevel1Id(level2.getStCategoryMasterDomain().get(0).getParentID()); //hardcoded. Use first available record
				portfolioDomain.setCategoryLevel2Id(level2.getStCategoryMasterDomain().get(0).getCategoryId()); //hardcoded. Use first available record
			}
			else
			{
				hasError=true;
			}
		}
		else
		{
			hasError=true;
		}
		portfolioDomain.setUserId(2); //assign to system user id first
		portfolioDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
		portfolioDomain.setCreatedby(2); //system user
		portfolioDomain.setLastupdateby(2); //system user
		portfolioDomain.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
		
		//portfolio_contest table info
		contestDomain.setContestId(0);
		contestDomain.setCategory(Constants.KEYWORD_TEMPLATE); //keyword value
		contestDomain.setIntroduction("{{DEFAULT}}");
		contestDomain.setProjectType(ContestTypeEnum.TYPE_DEFAULT.getId());
		contestDomain.setProjectStatus(ContestStatusEnum.STATUS_PENDING.getId());
		contestDomain.setCreatedby(2); //system user
		contestDomain.setLastupdateby(2); //system user
		contestDomain.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
		contestDomain.setBoardDimension(boardDimension.get(0).getLookupValueId());
		contestDomain.setBoardFormat(boardFormat.get(0).getLookupValueId());
		contestDomain.setNumberOfWinners(0);
		contestDomain.setDeliverable("{{DEFAULT}}");
		contestDomain.setOtherInformation("{{DEFAULT}}");
		contestDomain.setAssociatedBrandsHangWith("{{DEFAULT}}");
		contestDomain.setAssociatedBrandsInfluence("{{DEFAULT}}");
		try 
		{
			Calendar startDate = Calendar.getInstance();
			contestDomain.setStartDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(startDate));
			contestDomain.setEndDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(startDate));
		}
		catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hasError=true;
		}
		
		CreateContestResponse response = portfolioServiceSDK.createContest(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			hasError=false;
			map.addAttribute("result", response.getContest());
		}
		else
		{
			hasError=true;
			map.addAttribute("error", response.getStatus());
		}
		map.addAttribute("hasError", hasError);
		return map;
	}
	
	/**
	 * @param form
	 * @param mode save/publish(pending => running)/cancel(delete)/pause/resume/complete
	 * @param adUser
	 * @param model
	 * @return
	 */
	//project edit(save/publish/cancel) project
	@RequestMapping(value=ViewPaths.ADMIN_PROJECTS_EDIT_PROJECT,method=RequestMethod.POST)
	public @ResponseBody ModelMap editProject(ContestBeanDetail form,@PathVariable(value="mode") String mode, @ModelAttribute(value="user") AdUsersDomain adUser, @ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM, @ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap model)
	{
		ModelMap map=new ModelMap();
		Boolean hasError=false;
		Boolean requireReturnSubmission=false;
		//Boolean hasDueDateChanged=false;
		DomainToFormConverter converter=new DomainToFormConverter();
		//get contest data
		GetContestDetailsResponse contestDetailResponse = portfolioServiceSDK.getContestDetails(form.getPortfolioId(), form.getContestId());
		if(contestDetailResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			//locate the contest data
			TrPortfolioContestDomain targetContest=contestDetailResponse.getContest();
			if(targetContest!=null)
			{
				EditContestRequest request = new EditContestRequest();
				TrPortfolioContestDomain contestDomain = targetContest;
				request.setContest(contestDomain);
				
				form.setContestStatus(targetContest.getProjectStatus());
				if(mode.toUpperCase().equals("PUBLISH"))
				{
					//set project status to RUNNING
					form.setContestStatus(ContestStatusEnum.STATUS_RUNNING.getId());
				}
				else if(mode.toUpperCase().equals("CANCEL"))
				{
					//delete project (set active_status in tr_portfolio table to 0)
					contestDomain.getContestPortfolioDomain().setActiveStatus(ActiveStatusEnum.INACTIVE.value());
					if(form.getReturnSubmissions())
						requireReturnSubmission=true; //need to return submission after status updated.
				}
				else if(mode.toUpperCase().equals("PAUSE"))
				{
					//set project status to Suspended
					form.setContestStatus(ContestStatusEnum.STATUS_SUSPENDED.getId());
				}
				else if(mode.toUpperCase().equals("COMPLETE"))
				{
					//set project status to Completed
					form.setContestStatus(ContestStatusEnum.STATUS_COMPLETED.getId());
					if(form.getReturnSubmissions())
						requireReturnSubmission=true; //need to return submission after status updated.
				}
				else if(mode.toUpperCase().equals("RESUME"))
				{
					//check today does not exceed the due date
					Calendar today=Calendar.getInstance();
					Calendar dueDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(targetContest.getEndDate());
					if(today.after(dueDate))
					{
						hasError=true;
						map.addAttribute("errorCode", ErrorsCodeEnum.PROJECT_INVALID_DUEDATE.getCode());
						map.addAttribute("errorDesc", ErrorsCodeEnum.PROJECT_INVALID_DUEDATE.getDefaultMessage());
						map.addAttribute("errorId", ErrorsCodeEnum.PROJECT_INVALID_DUEDATE.getErrorId());
					}
					else
					{
						//set project status to running
						form.setContestStatus(ContestStatusEnum.STATUS_RUNNING.getId());
					}
				}
				
				//TODO If the projectStatus is already in running state and in PUBLISH mode. If due date changed, send notifications.
				/*if(targetContest.getProjectStatus()==ContestEnum.STATUS_RUNNING.getId() && form.getContestStatus()==ContestEnum.STATUS_RUNNING.getId()
					|| targetContest.getProjectStatus()==ContestEnum.STATUS_SUSPENDED.getId() && form.getContestStatus()==ContestEnum.STATUS_RUNNING.getId())
				{
					//TODO send notification if due date has been changed
					SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
					Date dueDate= new Date();
					if(form.getDueDate()!=null) 
					{
						try
						{
							dueDate=dateFormat.parse(form.getDueDate());
						} 
						catch (ParseException e) 
						{
							e.printStackTrace();
						}
					}
					Date currentDueDate = TimeConvertUtil.convertXMLDateToLocalTime(targetContest.getEndDate(), timezoneOffset);
					if(dueDate.compareTo(currentDueDate)!=0)
					{
						hasDueDateChanged=true;
					}
				}*/
				
				//update data from formBean
				convertBeanToDomain(form, contestDomain, adUser);
				
				EditContestResponse response = portfolioServiceSDK.editContest(request);
				if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					map.addAttribute("hasError", false);
					//convert to bean class
					ContestBean contestBean=new ContestBean();
					contestBean = converter.convertDomainToForm(response.getContest(), seasonYearHM, timezoneOffset);
					map.addAttribute("result", contestBean);
					//if requireReturnSubmission is true, return boards back to their own designer
					map.addAttribute("hasReturnSubmission", false);
					if(requireReturnSubmission)
					{
						map.addAttribute("hasReturnSubmission", true);
						//call return submissions service
						ReturnSubmissionsRequest returnSubmissionsRequest=new ReturnSubmissionsRequest();
						TrPortfolioDomain newPortfolioDomain=new TrPortfolioDomain();
						returnSubmissionsRequest.setTargetPortfolioId(targetContest.getPortfolioId());
						returnSubmissionsRequest.setTargetBoardPrice(this.creditConversionToUsd); //1 credit
						returnSubmissionsRequest.setSendNotification(form.getSendNotification()); //send notification to designers
						returnSubmissionsRequest.setNewPortfolio(newPortfolioDomain);
						String targetLabel="Return submission from "+targetContest.getContestPortfolioDomain().getName()+" ("+ProjectHelper.projectIdFormatter(targetContest)+")";
						newPortfolioDomain.setName(targetLabel);
						newPortfolioDomain.setDescription(targetLabel);
						ReturnSubmissionsResponse returnSubmissionsResponse=boardServiceSDK.returnSubmissions(returnSubmissionsRequest);
						if(returnSubmissionsResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
						{
							map.addAttribute("portfolio", returnSubmissionsResponse.getPortfolio());
						}
						else
						{
							hasError=true;
						}
					}
					//TODO send notifications to designers if due date changed.
				}
				else
				{
					hasError=true;
				}
			}
			else
			{
				hasError=true;
			}
		}
		else
		{
			hasError=true;
		}
		map.addAttribute("hasError", hasError);
		return map;
	}
	
	//Confirm project
	@RequestMapping(value = ViewPaths.ADMIN_PROJECTS_CONFIRM_PROJECT, method=RequestMethod.GET)
	public ModelAndView confirmProject(@RequestParam(value="portfolioId", required=false, defaultValue="-1") Integer portfolioId, @RequestParam(value="contestId", required=false, defaultValue="-1") Integer contestId, @ModelAttribute(value="user") AdUsersDomain user, @ModelAttribute(value="timezoneOffset") Integer timezoneOffset, @ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM, ModelMap model)
	{
		ModelAndView view;
		RedirectView rv;
		if(portfolioId!=-1 && contestId!=-1)
		{
			GetContestDetailsResponse response = portfolioServiceSDK.getContestDetails(portfolioId, contestId);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				//update the project status and start date as today
				TrPortfolioContestDomain contest=response.getContest();
				EditContestRequest editContestRequest=new EditContestRequest();
				editContestRequest.setContest(contest);
				//update start date as today
				try 
				{
					contest.setStartDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
				} 
				catch (DatatypeConfigurationException e) 
				{
					e.printStackTrace();
					rv=new RedirectView(ViewPaths.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL_PREVIEW+"?portfolioId="+portfolioId+"&contestId="+contestId,true,true,false);
				}
				//update project status to running
				contest.setProjectStatus(ContestStatusEnum.STATUS_RUNNING.getId());	
				//update project by calling edit contest
				EditContestResponse editResponse = portfolioServiceSDK.editContest(editContestRequest);
				if(editResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					//redirect to the manage projects tab
					rv=new RedirectView(ViewPaths.ADMIN_PROJECTS_MANAGE_PROJECTS,true,true,false);
				}
				else
				{
					rv=new RedirectView(ViewPaths.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL_PREVIEW+"?portfolioId="+portfolioId+"&contestId="+contestId,true,true,false);
				}
			}
			else
			{
				//if service call failed, return to the creative brief detail page.
				rv=new RedirectView(ViewPaths.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL_PREVIEW+"?portfolioId="+portfolioId+"&contestId="+contestId,true,true,false);
			}
		}
		else
		{
			//If the user do not passing valid portfolioId and contestId, redirect back to the manage projects view
			rv=new RedirectView(ViewPaths.ADMIN_PROJECTS_MANAGE_PROJECTS,true,true,false);
		}
		view=new ModelAndView(rv);
		view.addAllObjects(model);
		return view;
	}
	
	private Boolean convertBeanToDomain(ContestBeanDetail source, TrPortfolioContestDomain target, AdUsersDomain user)
	{
		TrPortfolioDomain contestPortfolio=target.getContestPortfolioDomain();
		//contest domain
		target.setContestId(source.getContestId());
		if(source.getContestType()!=null)
			target.setProjectType(source.getContestType());
		if(source.getWinners()!=null)
			target.setNumberOfWinners(source.getWinners());
		if(source.getContestStatus()!=null)
			target.setProjectStatus(source.getContestStatus());
		//set due date
		try 
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
			Calendar dueDate= Calendar.getInstance();
			if(source.getDueDate()!=null) {
				dueDate.setTime(dateFormat.parse(source.getDueDate()));
				target.setEndDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(dueDate));
			}
		} 
		catch (Exception e) 
		{
			return false;
		}
		//category(format is the same as keyword column in tr_board)
		String category=KeywordXmlHelper.setupKeywords(source.getSubKeywords1(), source.getSubKeywords2(), source.getSubKeywords3(), source.getSubKeywords4(), contestPortfolio.getCategoryLevel1(), contestPortfolio.getCategoryLevel2(), source.getProduct(), source.getProductType());
		target.setCategory(category); //assign board level 3, 4 value and keywords.
		if(source.getAssociatedBrandsInfluence()!=null)
			target.setAssociatedBrandsInfluence(source.getAssociatedBrandsInfluence());
		if(source.getAssociatedBrandsHangWith()!=null)
			target.setAssociatedBrandsHangWith(source.getAssociatedBrandsHangWith());
		if(source.getIntroduction()!=null)
			target.setIntroduction(source.getIntroduction());
		if(source.getDeliverables()!=null)
			target.setDeliverable(source.getDeliverables());
		if(source.getOtherInformation()!=null)
			target.setOtherInformation(source.getOtherInformation());
		if(source.getDimensions()!=null)
			target.setBoardDimension(source.getDimensions());
		if(source.getFormat()!=null)
			target.setBoardFormat(source.getFormat());
		target.setLastupdateby(user.getUserId());
		target.setCreatedby(user.getUserId());
		target.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
		
		//target.set
		//portfolio domain
		if(source.getTitle()!=null)
		contestPortfolio.setName(source.getTitle());
		if(source.getDescription()!=null)
			contestPortfolio.setDescription(source.getDescription());
		contestPortfolio.setPortfolioId(source.getPortfolioId());
		//client
		if(source.getClient()!=null)
			contestPortfolio.setUserId(source.getClient());
		else
			contestPortfolio.setUserId(2); //system user
		if(source.getDivision()!=null)
			contestPortfolio.setCategoryLevel1Id(source.getDivision());
		if(source.getCategory()!=null)
			contestPortfolio.setCategoryLevel2Id(source.getCategory());
		if(source.getSeason()!=null)
			contestPortfolio.setSeasonYearId(source.getSeason());
		contestPortfolio.setLastupdateby(user.getUserId());
		contestPortfolio.setCreatedby(user.getUserId());
		contestPortfolio.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
		
		if(source.getPortfolio_image_id()!=null)
		{
			//files
			List<TrPortfolioImagesDomain> images = target.getContestPortfolioDomain().getPortfolioImages();
			//Convert to Hashmap
			HashMap<Integer, TrPortfolioImagesDomain> imagesMap=new LinkedHashMap<Integer, TrPortfolioImagesDomain>();
			for(TrPortfolioImagesDomain item:images)
				imagesMap.put(item.getPortfolioImageId(), item);
		
			images.clear(); //reset the container
			//setup portfolio images
			for(int index=0;index<source.getPortfolio_image_id().length;index++)
			{
				if(source.getPortfolio_image_id()[index]!=null)
				{
					//check all images url are existed
					if(source.getFilename()[index].replaceAll(" ", "").length()>0 
						&& source.getFilename_ext()[index].replaceAll(" ", "").length()>0 
						&& source.getFilename_400()[index].replaceAll(" ", "").length()>0 
						&& source.getFilename_100()[index].replaceAll(" ", "").length()>0 
						&& source.getFilename_original()[index].replaceAll(" ", "").length()>0)
					{
						//locate the item from the hash map to update or to create a new one
						TrPortfolioImagesDomain item=null;
						item=imagesMap.get(source.getPortfolio_image_id()[index]);
						if(item==null) //create new record
							item=new TrPortfolioImagesDomain();
						//setup the image url
						item.setFileName(source.getFilename_400()[index].replaceAll(" ", ""));
						item.setFileType(source.getFilename_ext()[index].replaceAll(" ", ""));
						item.setMainImageUrl(source.getFilename_original()[index].replaceAll(" ", ""));
						item.setSourceFileURL(source.getFilename()[index].replaceAll(" ", ""));
						item.setThumbnailUrl(source.getFilename_100()[index].replaceAll(" ", ""));
						item.setCreatedby(user.getUserId());
						item.setLastupdateby(user.getUserId());
						item.setActiveStatus(source.getActive_status()[index]);
						images.add(item);
					}
					else
					{
						return false;
					}
				}
			}	
		}
		
		return true;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL, method=RequestMethod.GET)
	public String showCreativeBriefView(@RequestParam(value="portfolioId", required=false, defaultValue="-1") Integer portfolioId, @RequestParam(value="contestId", required=false, defaultValue="-1") Integer contestId, @ModelAttribute(value="user") AdUsersDomain user, @ModelAttribute(value="timezoneOffset") Integer timezoneOffset, @ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM, ModelMap model)
	{
		GetContestDetailsResponse response = portfolioServiceSDK.getContestDetails(portfolioId, contestId);
		TrPortfolioContestDomain targetContest=null;
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			targetContest = response.getContest();
		}
		if(targetContest!=null)
		{
			DomainToFormConverter converter=new DomainToFormConverter();
			List<AdLookupValuesDomain> boardDimension = (List<AdLookupValuesDomain>) model.get("boardDimension");
			List<AdLookupValuesDomain> boardFormat = (List<AdLookupValuesDomain>) model.get("boardFormat");
			
			ContestBean bean = converter.convertDomainToForm(targetContest, seasonYearHM, timezoneOffset,boardDimension, boardFormat);
			model.addAttribute("targetContest", bean);
			model.addAttribute("hasError", false);
		}
		else
		{
			model.addAttribute("hasError", true);
		}
		return ViewNames.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL;
	}
	
	@RequestMapping(value = ViewPaths.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL_PREVIEW, method=RequestMethod.GET)
	public String showCreativeBriefPreView(@RequestParam(value="portfolioId", required=false, defaultValue="-1") Integer portfolioId, @RequestParam(value="contestId", required=false, defaultValue="-1") Integer contestId, @ModelAttribute(value="user") AdUsersDomain user, @ModelAttribute(value="timezoneOffset") Integer timezoneOffset, @ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM, ModelMap model)
	{
		GetContestDetailsResponse response = portfolioServiceSDK.getContestDetails(portfolioId, contestId);
		TrPortfolioContestDomain targetContest=null;
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			targetContest = response.getContest();
		}
		if(targetContest!=null)
		{
			DomainToFormConverter converter=new DomainToFormConverter();
			List<AdLookupValuesDomain> boardDimension = (List<AdLookupValuesDomain>) model.get("boardDimension");
			List<AdLookupValuesDomain> boardFormat = (List<AdLookupValuesDomain>) model.get("boardFormat");
			
			ContestBean bean = converter.convertDomainToForm(targetContest, seasonYearHM, timezoneOffset,boardDimension, boardFormat);
			model.addAttribute("targetContest", bean);
			model.addAttribute("hasError", false);
		}
		else
		{
			model.addAttribute("hasError", true);
		}
		return ViewNames.ADMIN_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL_PREVIEW;
	}
	
	
}