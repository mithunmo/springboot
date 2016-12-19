package com.f9g4.webapp.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.xml.bind.Element;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
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
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StCategoryMasterDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.domain.TrPortfolioImagesDomain;
import com.f9g4.businessobjects.domain.TrRecentlyViewedDomain;
import com.f9g4.businessobjects.services.AddBoardRequest;
import com.f9g4.businessobjects.services.AddBoardResponse;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardRequest;
import com.f9g4.businessobjects.services.CreateBoardImageRequest;
import com.f9g4.businessobjects.services.CreateBoardImageResponse;
import com.f9g4.businessobjects.services.DeleteBoardByIdResponse;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.GetBoardsByPortfolioResponse;
import com.f9g4.businessobjects.services.GetBoardsSuggestionRequest;
import com.f9g4.businessobjects.services.GetBoardsSuggestionResponse;
import com.f9g4.businessobjects.services.GetCategoriesRequest;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.GetPortfolioByIdResponse;
import com.f9g4.businessobjects.services.GetPortfolioByUserResponse;
import com.f9g4.businessobjects.services.UpdateBoardRequest;
import com.f9g4.businessobjects.services.UpdateBoardResponse;
import com.f9g4.businessobjects.services.UpdatePublishBoardStatusRequest;
import com.f9g4.businessobjects.services.UpdatePublishBoardStatusResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.DataCaptureServiceSDK;
import com.f9g4.servicesdk.MembershipServiceSDK;
import com.f9g4.servicesdk.PortfolioServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.Helper.KeywordXmlHelper;
import com.f9g4.web.forms.Cart;
import com.f9g4.web.forms.CreateBoardForm;
import com.f9g4.web.forms.DeleteItemsForm;
import com.f9g4.web.forms.MessageForm;
import com.f9g4.web.utils.TimeConvertUtil;
import com.f9g4.web.utils.UserNameUtil;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;
import com.f9g4.web.validator.CreateBoardFormValidator;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.googlecode.ehcache.annotations.Cacheable;

@Controller
@SessionAttributes({ "user", "userId", "referralsList","cart","timezoneOffset","isVisibleDesigner"})
public class BoardController 
{
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	PortfolioServiceSDK portfolioServiceSDK=new PortfolioServiceSDK();
	
	@Autowired
	RegistrationServiceSDK registrationServiceSDK=new RegistrationServiceSDK();
	
	@Autowired
	MembershipServiceSDK membershipServiceSDK=new MembershipServiceSDK();
	
	@Autowired
	private BoardServiceSDK boardServiceSDK;
	
	@Autowired
	private CreateBoardFormValidator createBoardFormValidator;
	
	@Autowired @Value("${fileStore_bigimage}")
	private String profileLocation_bigimage;
	
	
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
	
	@Autowired @Value("${f9g4.webapp.boards.exp}")
	private int boardExpiratonDate;
	
	@Autowired @Value("${f9g4.webapp.credit.conversion.usd}")
	private int creditConversionToUsd;
	
	@ModelAttribute("creditConversionToUsd")
	public int getCreditConversionToUsd()
	{
		return this.creditConversionToUsd;
	}
	
	@Cacheable(cacheName="saleTypeList")
	@ModelAttribute("saleTypeList")
	public List<AdLookupValuesDomain> getSaleTypeList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.SALE_TYPE.getTypeName()).getLookupTypeValues();
	}
	
	//Check the designer visibility
	private boolean isVisibleDesigner(AdUsersDomain user) 
	{
		boolean isVisible=false;
		if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
		{
			//get unsellable portfolio
			GetPortfolioByUserResponse response=portfolioServiceSDK.getUnsellablePortfoliobyUser(user.getUserId());
			//setup the designer visibility as false as default.
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
							int publishedBoards=0;
								//check how many published boards. If it's more than 3, the user is visible.
								List<TrBoardDomain> pages = item.getBoards();
								for(TrBoardDomain page : pages)
								{
									if(page.getPublishToMP() == Constants.PUBLISH_TO_MARKET_YES && page.getActiveStatus() == ActiveStatusEnum.ACTIVE.value())
										publishedBoards++;
								}
							if(publishedBoards>=3)
								isVisible=true;
							break;
						}
					}
				}
			}
		}
		return isVisible;
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
	public List<TrPortfolioDomain> getPortfolioList(int userId, boolean sellable)
	{
		GetPortfolioByUserResponse response = new GetPortfolioByUserResponse();
		if(sellable)
			response=portfolioServiceSDK.getPortfoliobyUser(userId);
		else
			response=portfolioServiceSDK.getUnsellablePortfoliobyUser(userId);
		return response.getPortfolio();
	}
	
	
	@RequestMapping(value=ViewPaths.BOARD,method=RequestMethod.GET)
	public String getBoardView(ModelMap model)
	{
		return ViewNames.BOARD;
	}
	
	//get board view by portfortlio (COLLECTION)
	@RequestMapping(value=ViewPaths.BOARD+"/{portfolioId}",method=RequestMethod.GET)
	public String getBoardViewByPortfolio(@PathVariable(value="portfolioId") int portfolioId,@ModelAttribute(value="user") AdUsersDomain adUser,ModelMap model)
	{
		logger.trace("BOARD PORTFOLIO=>"+portfolioId);
		model.addAttribute("portfolioList", getPortfolioList(adUser.getUserId(),true));
		GetPortfolioByIdResponse response = portfolioServiceSDK.getPortfoliobyId(portfolioId);
		model.addAttribute("portfolio", response.getPortfolio());
		model.addAttribute("currentPortfolio", portfolioId);
		return ViewNames.BOARD;
	}
	
	//get board view by portfortlio (PORTFOLIO)
	@RequestMapping(value=ViewPaths.NEW_PORTFOLIO_BOARD+"/{portfolioId}",method=RequestMethod.GET)
	public String getPortfolioBoardViewByPortfolio(@PathVariable(value="portfolioId") int portfolioId,@ModelAttribute(value="user") AdUsersDomain adUser,ModelMap model)
	{
		logger.trace("BOARD PORTFOLIO=>"+portfolioId);
		model.addAttribute("portfolioList", getPortfolioList(adUser.getUserId(),false));
		model.addAttribute("currentPortfolio", portfolioId);
		return ViewNames.NEW_PORTFOLIO_BOARD;
	}
	
	
	@RequestMapping(value=ViewPaths.BOARDS_BY_PORTFOLIO_ID+"/{id}",method=RequestMethod.POST)
	public @ResponseBody ModelMap getBoardsByPortfolioId(@PathVariable(value="id") int id, @ModelAttribute(value="user") AdUsersDomain adUser)
	{
		ModelMap model=new ModelMap();
		GetBoardsByPortfolioResponse response=boardServiceSDK.getBoardsbyPortfolioId(id);
		List<TrBoardDomain> domain=response.getBoards();
		convertPriceToCredit(domain,this.creditConversionToUsd); //convert the board price to FFG credits
		//Convert board price to FFG credit
		model.addAttribute("results", domain);
		model.addAttribute("isVisibleDesigner",isVisibleDesigner(adUser));
		return model;
	}
	
	//Collection (Sellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_BOARD,method=RequestMethod.GET)
	public String createBoardView(@ModelAttribute(value="user") AdUsersDomain adUser,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		model.addAttribute("createBoardForm", new CreateBoardForm());
		List<TrPortfolioDomain> portfolios = getPortfolioList(adUser.getUserId(),true);
		model.addAttribute("portfolioList", portfolios );
		int portfolioId; 
		
		if(portfolios!=null&&portfolios.size()>0)
		{
			 portfolioId= portfolios.get(0).getPortfolioId();
			 GetCreateBoardInfoFromPortfolio(model,portfolioId);
		}
		
		//compute the estimate expiration date
		Calendar day=Calendar.getInstance();
		day.add(Calendar.DAY_OF_MONTH, +60);
		//convert to local time
		day=TimeConvertUtil.convertToLocalTime(day, timezoneOffset);
		model.addAttribute("expirationDate", day.getTime());
		model.addAttribute("hasWithPortfolio", false);
		return ViewNames.CREATE_BOARD;
	}
	
	//Portfolio (Unsellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_PORTFOLIO_BOARD,method=RequestMethod.GET)
	public String createPortfolioBoardView(@ModelAttribute(value="user") AdUsersDomain adUser,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		model.addAttribute("createBoardForm", new CreateBoardForm());
		List<TrPortfolioDomain> portfolios = getPortfolioList(adUser.getUserId(),false);
		model.addAttribute("portfolioList", portfolios );
		int portfolioId; 
		
		if(portfolios!=null&&portfolios.size()>0)
		{
			 portfolioId= portfolios.get(0).getPortfolioId();
			 GetCreateBoardInfoFromPortfolio(model,portfolioId);
		}
		
		//compute the estimate expiration date
		Calendar day=Calendar.getInstance();
		day.add(Calendar.DAY_OF_MONTH, +60);
		//convert to local time
		day=TimeConvertUtil.convertToLocalTime(day, timezoneOffset);
		model.addAttribute("expirationDate", day.getTime());
		model.addAttribute("hasWithPortfolio", false);
		return ViewNames.CREATE_PORTFOLIO_BOARD;
	}
	
	//Collection (Sellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_BOARD_WITH_PORTFOLIO+"/{portfolioId}",method=RequestMethod.GET)
	public String createBoardViewWithPortfolio(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable(value="portfolioId") int portfolioId,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		model.addAttribute("createBoardForm", new CreateBoardForm());
		model.addAttribute("portfolioList", getPortfolioList(adUser.getUserId(),true));
		
		GetCreateBoardInfoFromPortfolio(model,portfolioId);
		//compute the estimate expiration date
		Calendar day=Calendar.getInstance();
		day.add(Calendar.DAY_OF_MONTH, +60);
		//convert to local time
		day=TimeConvertUtil.convertToLocalTime(day, timezoneOffset);
		model.addAttribute("expirationDate", day.getTime());
		model.addAttribute("hasWithPortfolio", true);
		return ViewNames.CREATE_BOARD;
	}
	
	//Portfolio (Unsellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_PORTFOLIO_BOARD_WITH_PORTFOLIO+"/{portfolioId}",method=RequestMethod.GET)
	public String createPortfolioBoardViewWithPortfolio(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable(value="portfolioId") int portfolioId,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		model.addAttribute("createBoardForm", new CreateBoardForm());
		model.addAttribute("portfolioList", getPortfolioList(adUser.getUserId(),false));
		
		GetCreateBoardInfoFromPortfolio(model,portfolioId);
		//compute the estimate expiration date
		Calendar day=Calendar.getInstance();
		day.add(Calendar.DAY_OF_MONTH, +60);
		//convert to local time
		day=TimeConvertUtil.convertToLocalTime(day, timezoneOffset);
		model.addAttribute("expirationDate", day.getTime());
		model.addAttribute("hasWithPortfolio", true);
		return ViewNames.CREATE_PORTFOLIO_BOARD;
	}
	
	private void GetCreateBoardInfoFromPortfolio(ModelMap model, int portfolioId) {
		
		model.addAttribute("portfolioId", portfolioId);
		//get product type list
		GetPortfolioByIdResponse portfolioResponse=portfolioServiceSDK.getPortfoliobyId(portfolioId);
		List<StCategoryMasterDomain> productDomain=getProductList(portfolioResponse.getPortfolio().getCategoryLevel2Id());
		List<StCategoryMasterDomain> productTypeDomain=new ArrayList<StCategoryMasterDomain>();
		model.addAttribute("productList", productDomain);
		if(productDomain!=null && productDomain.size() > 0)
		{
			productTypeDomain=getProductTypeList(productDomain.get(0).getCategoryId());
			model.addAttribute("productTypeList", productTypeDomain);
		}
	}

	//Collection (Sellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_BOARD+"/{boardId}",method=RequestMethod.GET)
	public String updateBoardViewByBoardId(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable(value="boardId") int boardId,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		logger.trace("MODIFY BOARD=>"+boardId);
		model.addAttribute("createBoardForm", new CreateBoardForm());
		model.addAttribute("portfolioList", getPortfolioList(adUser.getUserId(),true));
		GetBoardByIdResponse response=boardServiceSDK.getBoardbyId(boardId);
		model.addAttribute("boardDetail", response.getBoard());
		model.addAttribute("portfolioId", response.getBoard().getPortfolioId());
		//format the date
		Calendar expDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(response.getBoard().getExperiationDate()); //convert to Calendar
		//convert to local time
		expDate=TimeConvertUtil.convertToLocalTime(expDate, timezoneOffset);
		model.addAttribute("expirationDate", expDate.getTime());
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
		//Parse sub keywords
        try 
        {
        	if(response.getBoard().getKeyword()!=null)
        	{
        		if(response.getBoard().getKeyword().length()>0)
        		{
		        	model.addAllAttributes(KeywordXmlHelper.retrieveSubkeywordContentAsHashMap(response.getBoard().getKeyword()));
			        //retrieve product type list
			        model.addAllAttributes(KeywordXmlHelper.retrieveProductTypeContentAsHashMap(response.getBoard().getKeyword()));
			        //retrieve product list
			        model.addAllAttributes(KeywordXmlHelper.retrieveBoardCategoryLevelAsHashMap(3, response.getBoard().getKeyword()));
        		}
        	}
		}
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        //covert board price to FFG credits
        BigDecimal ffgCredit = response.getBoard().getBoardPrice().divide(new BigDecimal(this.creditConversionToUsd));
        response.getBoard().setBoardPrice(ffgCredit.setScale(0,BigDecimal.ROUND_CEILING));
        model.addAttribute("productList", productDomain);
		model.addAttribute("productTypeList", productTypeDomain);
		model.addAttribute("hasWithPortfolio", true);
		model.addAttribute("editMode",true);
        return ViewNames.CREATE_BOARD;
	}
	
	//Portfolio (Unsellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_PORTFOLIO_BOARD+"/{boardId}",method=RequestMethod.GET)
	public String updatePortfolioBoardViewByBoardId(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable(value="boardId") int boardId,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		logger.trace("MODIFY BOARD=>"+boardId);
		model.addAttribute("createBoardForm", new CreateBoardForm());
		model.addAttribute("portfolioList", getPortfolioList(adUser.getUserId(),false));
		GetBoardByIdResponse response=boardServiceSDK.getBoardbyId(boardId);
		model.addAttribute("boardDetail", response.getBoard());
		model.addAttribute("portfolioId", response.getBoard().getPortfolioId());
		//format the date
		Calendar expDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(response.getBoard().getExperiationDate()); //convert to Calendar
		//convert to local time
		expDate=TimeConvertUtil.convertToLocalTime(expDate, timezoneOffset);
		model.addAttribute("expirationDate", expDate.getTime());
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
		//Parse sub keywords
        try 
        {
        	if(response.getBoard().getKeyword()!=null)
        	{
        		if(response.getBoard().getKeyword().length()>0)
        		{
		        	model.addAllAttributes(KeywordXmlHelper.retrieveSubkeywordContentAsHashMap(response.getBoard().getKeyword()));
			        //retrieve product type list
			        model.addAllAttributes(KeywordXmlHelper.retrieveProductTypeContentAsHashMap(response.getBoard().getKeyword()));
			        //retrieve product list
			        model.addAllAttributes(KeywordXmlHelper.retrieveBoardCategoryLevelAsHashMap(3, response.getBoard().getKeyword()));
        		}
        	}
		}
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        model.addAttribute("productList", productDomain);
		model.addAttribute("productTypeList", productTypeDomain);
		model.addAttribute("hasWithPortfolio", true);
		model.addAttribute("editMode",true);
        return ViewNames.CREATE_PORTFOLIO_BOARD;
	}
	
	//Collection (Sellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_BOARD,method=RequestMethod.POST)
	public @ResponseBody ModelMap manageBoardResult(@ModelAttribute(value="user") AdUsersDomain adUser, CreateBoardForm formBean,BindingResult result, ModelMap model)
	{
		ModelMap map=new ModelMap();
		createBoardFormValidator.validate(formBean, result);
		if(result.hasErrors()==false)
		{
			logger.trace("CREATE BOARD=>"+formBean.toString());
			
			AddBoardRequest request =new AddBoardRequest();
			UpdateBoardRequest updateRequest=new UpdateBoardRequest();
			TrBoardDomain domain=new TrBoardDomain();
			//TODO get the commission rate
			GetMembershipCommissionRequest membershipRequest = new GetMembershipCommissionRequest();
			GetMembershipCommissionResponse membershipResponse = new GetMembershipCommissionResponse();
			Calendar day=Calendar.getInstance();
			day.add(Calendar.DAY_OF_MONTH, +this.boardExpiratonDate); //Set expiration date from property file.
			
			try
			{
				membershipRequest.setUserId(adUser.getUserId());
				membershipResponse =  membershipServiceSDK.getMembershipCommissiondetails(membershipRequest);
				BigDecimal commissionRate=membershipResponse.getStPricingOptions().getCommission(); 
				if(formBean.getBoardId()!=null)
				{
					//get the board original data from database.
					GetBoardByIdResponse boardResponse=boardServiceSDK.getBoardbyId(formBean.getBoardId());
					domain=boardResponse.getBoard();
					
					//check the board is not locked. If it's locked, set the error status back to the user.
					if(domain.getStatusId() != LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId())
					{
						map.addAttribute("hasError", true);
						map.addAttribute("errorCode", StatusCodesEnum.STATUS_BOARD_UNDER_PROCESSED.getCode());
						map.addAttribute("errorDescription", "Board is being processed");
						map.addAttribute("errors", result.getAllErrors());
						return map;
					}
					if(domain.getPublishToMP()==1){
						//the board is already published (i cant find any specific changes) leaving it as a space holder for future use
					}else{
						//here the board is not published yet hence am setting effective date 
						domain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
					}
				}
				else{	//Setting the parameters that are created only during creation
					domain.setPublishToMP(formBean.getPublishToMp());
					domain.setCreatedby(adUser.getUserId());
					domain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
					domain.setLangCode(adUser.getLangCode());
					domain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
				}
				domain.setPublishToMP(formBean.getPublishToMp());
				domain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(day)); //UTC time
				//domain.setCurrentUerId(adUser.getUserId());
				domain.setPortfolioId(formBean.getPortfolioId());
				domain.setName(formBean.getBoardName());
				domain.setDescription(formBean.getBoardDescription());
				//domain.setCategoryLevel3Id(formBean.getProduct()); //No use for now.
				//domain.setCategoryLevel4Id(formBean.getProductType()); //No use for now.
				//prepare keywords from subKeywords in xml format
				String subKeywords_1="<skw1>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_1())+"</skw1>";
				String subKeywords_2="<skw2>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_2())+"</skw2>";
				String subKeywords_3="<skw3>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_3())+"</skw3>";
				String subKeywords_4="<skw4>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_4())+"</skw4>";
				//
				GetPortfolioByIdResponse portfolio = portfolioServiceSDK.getPortfoliobyId(formBean.getPortfolioId());
				String divisionList="<bcl1>"+portfolio.getPortfolio().getCategoryLevel1()+"</bcl1>"; //Insert 1st level to keywords fields
				String categoryList="<bcl2>"+portfolio.getPortfolio().getCategoryLevel2()+"</bcl2>"; //Insert 2nd level to keywords fields
				String productList="<bcl3>"+StringUtils.join(formBean.getProductTags(), ",")+"</bcl3>"; //Insert 3rd level to keywords fields
				String productTypeList="<ptl>"+StringUtils.join(formBean.getProductTypeTags(), ",")+"</ptl>"; //Insert 4th level to keywords fields
				String keywords="<kw>"+subKeywords_1+subKeywords_2+subKeywords_3+subKeywords_4+productTypeList+productList+categoryList+divisionList+"</kw>";
				//
				domain.setKeyword(keywords);
				//Calculate total price from board price
				formBean.setPrice(formBean.getPrice()*this.creditConversionToUsd); //05132014 Fred - Convert FFG credit to USD.
				domain.setBoardPrice(new BigDecimal(formBean.getPrice())); 
				BigDecimal rate=commissionRate.divide(new BigDecimal(100.00));
				BigDecimal totalPrice=new BigDecimal(formBean.getPrice()).multiply((rate.add(new BigDecimal(1.0))));
				logger.trace("PRICE=>"+totalPrice+" ; rate=>"+rate);
				domain.setTotalPrice(totalPrice);
				domain.setSaleTypeId(formBean.getSaletype());
				domain.setLastupdateby(adUser.getUserId());
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			logger.trace("EXP days=>"+formBean.getExpirationDays());
			logger.trace("EXP=>"+domain.getExperiationDate().toString());
			
			/*List<TrBoardImagesDomain> imagesDomainList=domain.getBoardImages();
			TrBoardImagesDomain imageDomain=new TrBoardImagesDomain();*/
			
			AddBoardResponse response=new AddBoardResponse();
			UpdateBoardResponse updateResponse=new UpdateBoardResponse();
			//create board if formBean.getBoardId() is null
			if(formBean.getBoardId()==null)
			{
				logger.trace("Add Board");
				map.addAttribute("type", "create");
				request.setBoard(domain);
				domain.setStatusId(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId());
				response=boardServiceSDK.addBoards(request);
				if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					CreateBoardImageRequest imageRequest=new CreateBoardImageRequest();
					TrBoardImagesDomain imageDomain=new TrBoardImagesDomain();
					imageDomain.setBoardId(response.getBoard().getBoardId());
					imageDomain.setFileName(formBean.getBoardImageUrl_file());
					imageDomain.setCreatedby(adUser.getUserId());
					imageDomain.setLastupdateby(adUser.getUserId());
					imageDomain.setFileType(formBean.getBoardImageType());
					imageDomain.setMainImageUrl(formBean.getBoardImageUrl_main());
					imageDomain.setSourceFileURL(formBean.getBoardImageUrl());
					imageDomain.setThumbnailUrl(formBean.getBoardImageUrl_thumb());
					imageRequest.setTrBoardImagesDomain(imageDomain);
					CreateBoardImageResponse imageResponse = boardServiceSDK.createBoardImage(imageRequest);
					logger.trace("Add Board Image REsponse=>"+imageResponse.getStatus().getStatuscode()+":"+imageResponse.getStatus().getDescription());
					if(imageResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
					{
						map.addAttribute("hasError", false);
						map.addAttribute("errorCode", imageResponse.getStatus().getStatuscode()+"image");
						map.addAttribute("errorDescription", imageResponse.getStatus().getDescription());
					}
					else
					{
						map.addAttribute("hasError", true);
						map.addAttribute("errorCode", imageResponse.getStatus().getStatuscode()+"image");
						map.addAttribute("errorDescription", imageResponse.getStatus().getDescription());
					}
				}
				else
				{
					map.addAttribute("hasError", true);
					map.addAttribute("errorCode", response.getStatus().getStatuscode());
					map.addAttribute("errorDescription", response.getStatus().getDescription());
				}
				logger.trace("Add Board Response=>"+response.getStatus().getStatuscode()+":"+response.getStatus().getDescription());
			}
			else
			{
				//update board if formBean.getBoardId() is not null
				logger.trace("Update Board");
				map.addAttribute("type", "update");
				//domain.setBoardId(formBean.getBoardId());
				domain.setStatusId(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId());
				//update images
				TrBoardImagesDomain imageDomain=domain.getBoardImages().get(0);
				imageDomain.setFileName(formBean.getBoardImageUrl_file());
				imageDomain.setCreatedby(adUser.getUserId());
				imageDomain.setLastupdateby(adUser.getUserId());
				imageDomain.setFileType(formBean.getBoardImageType());
				imageDomain.setMainImageUrl(formBean.getBoardImageUrl_main());
				imageDomain.setSourceFileURL(formBean.getBoardImageUrl());
				imageDomain.setThumbnailUrl(formBean.getBoardImageUrl_thumb());
				updateRequest.setBoard(domain);
				updateResponse=boardServiceSDK.updateBoard(updateRequest);
				if(updateResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					map.addAttribute("hasError", false);
					map.addAttribute("boardId", formBean.getBoardId());
					map.addAttribute("errorCode", response.getStatus().getStatuscode());
					map.addAttribute("errorDescription", response.getStatus().getDescription());
				}
				else
				{
					map.addAttribute("hasError", true);
					map.addAttribute("errorCode", response.getStatus().getStatuscode());
					map.addAttribute("errorDescription", response.getStatus().getDescription());
				}
				logger.trace("Update Board Response=>"+updateResponse.getStatus().getStatuscode()+":"+updateResponse.getStatus().getDescription());
			}
		}
		else
		{
			logger.debug("hasErrors -  true" );
			map.put("hasError",true);
			map.put("errors", result.getAllErrors());
		}
		return map;
	}
	
	//Portfolio (Unsellable portfolio)
	@RequestMapping(value=ViewPaths.CREATE_PORTFOLIO_BOARD,method=RequestMethod.POST)
	public @ResponseBody ModelMap managePortfolioBoardResult(@ModelAttribute(value="user") AdUsersDomain adUser, CreateBoardForm formBean,BindingResult result, ModelMap model)
	{
		ModelMap map=new ModelMap();
		//createBoardFormValidator.validate(formBean, result);
		if(result.hasErrors()==false)
		{
			logger.trace("CREATE BOARD=>"+formBean.toString());
			
			AddBoardRequest request =new AddBoardRequest();
			UpdateBoardRequest updateRequest=new UpdateBoardRequest();
			TrBoardDomain domain=new TrBoardDomain();
			Calendar day=Calendar.getInstance();
			day.add(Calendar.DAY_OF_MONTH, +120); //hardcode the expiration days to 120 
			
			try
			{
				if(formBean.getBoardId()!=null)
				{
					//get the board original data from database.
					GetBoardByIdResponse boardResponse=boardServiceSDK.getBoardbyId(formBean.getBoardId());
					domain=boardResponse.getBoard();
					
					//check the board is not locked. If it's locked, set the error status back to the user.
					if(domain.getStatusId() != LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId())
					{
						map.addAttribute("hasError", true);
						map.addAttribute("errorCode", StatusCodesEnum.STATUS_BOARD_UNDER_PROCESSED.getCode());
						map.addAttribute("errorDescription", "Board is being processed");
						map.addAttribute("errors", result.getAllErrors());
						return map;
					}
					if(domain.getPublishToMP()==1){
						//the board is already published (i cant find any specific changes) leaving it as a space holder for future use
					}else{
						//here the board is not published yet hence am setting effective date 
						domain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
					}
				}
				else{	//Setting the parameters that are created only during creation
					domain.setCreatedby(adUser.getUserId());
					domain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
					domain.setLangCode(adUser.getLangCode());
					domain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
				}
				domain.setPublishToMP(formBean.getPublishToMp());
				domain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(day)); //UTC time
				//domain.setCurrentUerId(adUser.getUserId());
				domain.setPortfolioId(formBean.getPortfolioId());
				domain.setName(formBean.getBoardName());
				domain.setDescription(formBean.getBoardDescription());
				//domain.setCategoryLevel3Id(formBean.getProduct()); //No use for now.
				//domain.setCategoryLevel4Id(formBean.getProductType()); //No use for now.
				//prepare keywords from subKeywords in xml format
				String subKeywords_1="<skw1>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_1())+"</skw1>";
				String subKeywords_2="<skw2>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_2())+"</skw2>";
				String subKeywords_3="<skw3>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_3())+"</skw3>";
				String subKeywords_4="<skw4>"+StringEscapeUtils.escapeXml(formBean.getSubKeywords_4())+"</skw4>";
				//
				GetPortfolioByIdResponse portfolio = portfolioServiceSDK.getPortfoliobyId(formBean.getPortfolioId());
				String divisionList="<bcl1>"+portfolio.getPortfolio().getCategoryLevel1()+"</bcl1>"; //Insert 1st level to keywords fields
				String categoryList="<bcl2>"+portfolio.getPortfolio().getCategoryLevel2()+"</bcl2>"; //Insert 2nd level to keywords fields
				String productList="<bcl3></bcl3>"; //Insert 3rd level to keywords fields
				String productTypeList="<ptl></ptl>"; //Insert 4th level to keywords fields
				String keywords="<kw>"+subKeywords_1+subKeywords_2+subKeywords_3+subKeywords_4+productTypeList+productList+categoryList+divisionList+"</kw>";
				//
				domain.setKeyword(keywords);
				domain.setBoardPrice(new BigDecimal(2.0));
				domain.setTotalPrice(new BigDecimal(2.0));
				domain.setSaleTypeId(LookupTypeValueEnum.BOARD_SALE_TYPE_JPG.getTypeId());
				domain.setLastupdateby(adUser.getUserId());
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			/*List<TrBoardImagesDomain> imagesDomainList=domain.getBoardImages();
			TrBoardImagesDomain imageDomain=new TrBoardImagesDomain();*/
			
			AddBoardResponse response=new AddBoardResponse();
			UpdateBoardResponse updateResponse=new UpdateBoardResponse();
			//create board if formBean.getBoardId() is null
			if(formBean.getBoardId()==null)
			{
				logger.trace("Add Board");
				map.addAttribute("type", "create");
				request.setBoard(domain);
				domain.setStatusId(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId());
				response=boardServiceSDK.addBoards(request);
				if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					CreateBoardImageRequest imageRequest=new CreateBoardImageRequest();
					TrBoardImagesDomain imageDomain=new TrBoardImagesDomain();
					imageDomain.setBoardId(response.getBoard().getBoardId());
					imageDomain.setFileName(formBean.getBoardImageUrl_file());
					imageDomain.setCreatedby(adUser.getUserId());
					imageDomain.setLastupdateby(adUser.getUserId());
					imageDomain.setFileType(formBean.getBoardImageType());
					imageDomain.setMainImageUrl(formBean.getBoardImageUrl_main());
					imageDomain.setSourceFileURL(formBean.getBoardImageUrl());
					imageDomain.setThumbnailUrl(formBean.getBoardImageUrl_thumb());
					imageRequest.setTrBoardImagesDomain(imageDomain);
					CreateBoardImageResponse imageResponse = boardServiceSDK.createBoardImage(imageRequest);
					logger.trace("Add Board Image REsponse=>"+imageResponse.getStatus().getStatuscode()+":"+imageResponse.getStatus().getDescription());
					if(imageResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
					{
						map.addAttribute("hasError", false);
						map.addAttribute("errorCode", imageResponse.getStatus().getStatuscode()+"image");
						map.addAttribute("errorDescription", imageResponse.getStatus().getDescription());
					}
					else
					{
						map.addAttribute("hasError", true);
						map.addAttribute("errorCode", imageResponse.getStatus().getStatuscode()+"image");
						map.addAttribute("errorDescription", imageResponse.getStatus().getDescription());
					}
				}
				else
				{
					map.addAttribute("hasError", true);
					map.addAttribute("errorCode", response.getStatus().getStatuscode());
					map.addAttribute("errorDescription", response.getStatus().getDescription());
				}
				logger.trace("Add Board Response=>"+response.getStatus().getStatuscode()+":"+response.getStatus().getDescription());
			}
			else
			{
				//update board if formBean.getBoardId() is not null
				logger.trace("Update Board");
				map.addAttribute("type", "update");
				//domain.setBoardId(formBean.getBoardId());
				domain.setStatusId(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId());
				//update images
				TrBoardImagesDomain imageDomain=domain.getBoardImages().get(0);
				imageDomain.setFileName(formBean.getBoardImageUrl_file());
				imageDomain.setCreatedby(adUser.getUserId());
				imageDomain.setLastupdateby(adUser.getUserId());
				imageDomain.setFileType(formBean.getBoardImageType());
				imageDomain.setMainImageUrl(formBean.getBoardImageUrl_main());
				imageDomain.setSourceFileURL(formBean.getBoardImageUrl());
				imageDomain.setThumbnailUrl(formBean.getBoardImageUrl_thumb());
				updateRequest.setBoard(domain);
				updateResponse=boardServiceSDK.updateBoard(updateRequest);
				if(updateResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				{
					map.addAttribute("hasError", false);
					map.addAttribute("boardId", formBean.getBoardId());
					map.addAttribute("errorCode", response.getStatus().getStatuscode());
					map.addAttribute("errorDescription", response.getStatus().getDescription());
				}
				else
				{
					map.addAttribute("hasError", true);
					map.addAttribute("errorCode", response.getStatus().getStatuscode());
					map.addAttribute("errorDescription", response.getStatus().getDescription());
				}
				logger.trace("Update Board Response=>"+updateResponse.getStatus().getStatuscode()+":"+updateResponse.getStatus().getDescription());
			}
		}
		else
		{
			logger.debug("hasErrors -  true" );
			map.put("hasError",true);
			map.put("errors", result.getAllErrors());
		}
		return map;
	}
	
	@Autowired
	private DataCaptureServiceSDK dataCaptureServiceSDK;
	
	@RequestMapping(value=ViewPaths.BOARD_DETAIL+"/{id}",method=RequestMethod.GET)
	public String getBoardDetail(@PathVariable(value="id") Integer id, @ModelAttribute(value="user") AdUsersDomain adUser, @ModelAttribute(value="cart") Cart cart, @ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model) throws DatatypeConfigurationException
	{
		logger.trace("BOARD DETAIL=>"+id);
		GetBoardByIdResponse response=boardServiceSDK.getBoardbyId(id);
		TrBoardDomain domain=response.getBoard();
		
		if(domain.getHasSellablePortfolio()==ActiveStatusEnum.ACTIVE.value()) //only push board which under sellable portfolio
		{
			AddRecentlyViewedBoardRequest request = new AddRecentlyViewedBoardRequest();
			TrRecentlyViewedDomain trRecentlyViewedDomain = new TrRecentlyViewedDomain();
			trRecentlyViewedDomain.setBoardId(id);
	//		trRecentlyViewedDomain.setClickId(value);
			trRecentlyViewedDomain.setCreatedby(adUser.getUserId());
			trRecentlyViewedDomain.setEventTime(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
			trRecentlyViewedDomain.setLastupdateby(adUser.getUserId());
			trRecentlyViewedDomain.setUserId(adUser.getUserId());
			request.setLogBoard(trRecentlyViewedDomain);
			if(adUser.getUserId()!=domain.getOriginalUserId())
				dataCaptureServiceSDK.addRecentlyViewBoard(request);
		}
		//Convert board price to FFG credit
		//this.convertPriceToCredit(domain, this.creditConversionToUsd);
		model.addAttribute("detail", domain); //add board detail
		//format the date
		Calendar postDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getLastUpdateDate()); //convert to Calendar
		postDate=TimeConvertUtil.convertToLocalTime(postDate, timezoneOffset); //convert to local time
		model.addAttribute("postDate", postDate.getTime()); //convert to Date
		//get designer's name
		ViewUserResponse userResponse=registrationServiceSDK.viewUser(domain.getOriginalUserId());
		model.addAttribute("userType", adUser.getUserType());
		model.addAttribute("designerName", userResponse.getUser().getFirstname()+" "+userResponse.getUser().getLastname());
		//Check shopping cart if the user is customer, and update the board price with company commission as SALE_PRICE
		if(adUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
		{
			model.addAttribute("hasInShoppingCart", cart.getCart().containsKey(response.getBoard().getBoardId()));
			//Compute the SALE_PRICE with company commission
			GetMembershipCommissionRequest getCommissionRequest = new GetMembershipCommissionRequest();
			getCommissionRequest.setUserId(adUser.getUserId());
			GetMembershipCommissionResponse getCommissionResponse =  membershipServiceSDK.getMembershipCommissiondetails(getCommissionRequest);
			BigDecimal commission = getCommissionResponse.getStPricingOptions().getCommission();
			BigDecimal salePrice = domain.getTotalPrice().multiply(commission.add(new BigDecimal(100))).divide(new BigDecimal(100));
			domain.setTotalPrice(salePrice.setScale(2, RoundingMode.HALF_UP));
			model.addAttribute("designerName", UserNameUtil.getDesignerName(userResponse.getUser()));
		}
		//Convert board price to FFG credit
		this.convertPriceToCredit(domain, this.creditConversionToUsd);
		//disable the shopping cart function and image if the board has been sold.
		switch(domain.getPublishToMP())
		{
		case 0: //unpublished
			//the board is being sold or ready to download (handle MP=0, Board is SOLD or READY)
			if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId()
				|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId()
				|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeId())
			{
				//if user is original user or current user of board, show the thumb image.
				if(adUser.getUserId()==domain.getOriginalUserId() || adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getLastupdateby())
				{
					model.addAttribute("canShow", true);
					model.addAttribute("canShop", false);
					model.addAttribute("shopTypeCode", "board.isOwnerOrDesigner");
				}
				else
				{
					model.addAttribute("canShow", false);	//if it's sold and the user is not current user or original user, don't show the image.
					model.addAttribute("typeCode", "board.sold");
					model.addAttribute("canShop", false);
					model.addAttribute("shopTypeCode", "board.sold");
				}
				//If board is sold and the user is the owner, show the SAL_PRICE from tr_sales_transaction table
				if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() && adUser.getUserId()==domain.getCurrentUerId())
				{
					//show SALE_PRICE instead of total price
					logger.debug("Show sale price => $"+domain.getSalePrice());
					domain.setTotalPrice(domain.getSalePrice());
				}
				
				//If board is sold and the user is the original designer, show the board status as sold
				if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() && adUser.getUserId()==domain.getOriginalUserId())
					domain.setBoardStatus("Sold");
			}
			else //handle MP=0, the board is processing or available
			{
				//if the user is designer, he can see the image, and others cannot.
				if(adUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && (adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getOriginalUserId()))
				{
					model.addAttribute("canShow", true);
					model.addAttribute("canShop", false);
					model.addAttribute("shopTypeCode", "board.unpublished.unrelatedusers");
				}
				else
				{
					model.addAttribute("canShow", false);
					model.addAttribute("typeCode", "board.unpublished");
					model.addAttribute("canShop", false);
					model.addAttribute("typeCode", "board.unpublished");
				}
			}
			break;
		case 1: //published
			if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId()) //Everybody can see the image.
			{
				model.addAttribute("canShow", true);
				model.addAttribute("canShop", true);
			}
			else if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() 
					|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId()
					|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeId())
			{
				//if user is original user or current user of board, show the thumb image.
				if(adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getOriginalUserId() || adUser.getUserId()==domain.getLastupdateby())
				{
					model.addAttribute("canShow", true);
					model.addAttribute("canShop", false);
					model.addAttribute("shopTypeCode", "board.isOwnerOrDesigner");
				}
				else
				{
					model.addAttribute("canShow", false);	//if it's sold and the user is not current user or original user, don't show the image.
					model.addAttribute("typeCode", "board.sold");
					model.addAttribute("canShop", false);
					model.addAttribute("shopTypeCode", "board.sold");
				}
			}
			else
			{
				model.addAttribute("canShow", true);
				model.addAttribute("canShop", true);
			}
			//If board is sold and the user is the owner, show the SAL_PRICE from tr_sales_transaction table
			if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() && adUser.getUserId()==domain.getCurrentUerId())
			{
				//show SALE_PRICE instead of total price
				logger.debug("Show sale price => $"+domain.getSalePrice());
				domain.setTotalPrice(domain.getSalePrice());
			}
			break;
		case 2: //processing
			//Only the user who is original user can see the image
			if(adUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && (adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getOriginalUserId()))
			{
				model.addAttribute("canShow", true);
				model.addAttribute("canShop", false);
				model.addAttribute("shopTypeCode", "board.processing");
			}
			else
			{
				model.addAttribute("canShow", false);
				model.addAttribute("typeCode", "board.processing");
				model.addAttribute("canShop", false);
				model.addAttribute("shopTypeCode", "board.processing");
			}
			break;
		default:
			model.addAttribute("canShow", false);
			model.addAttribute("typeCode", "board.unknownstates");
			model.addAttribute("canShop", false);
			model.addAttribute("shopTypeCode", "board.unknownstates");
			break;
		}
		
		model.addAttribute("designerLogo",userResponse.getUser().getLogoimageurl());
		model.addAttribute("userName", adUser.getFirstname()+" "+adUser.getLastname());
		model.addAttribute("userLogo", adUser.getLogoimageurl());
		model.addAttribute("imageurl", domain.getBoardImages().get(0).getFileName()); //get 400x400 images
		//check the file exists or not, if the file is not exist send the empty string
		File originalImageFile=new File(profileLocation_bigimage+"/"+domain.getBoardImages().get(0).getMainImageUrl());
		if(originalImageFile.exists())
		{
			model.addAttribute("imageurl_original", domain.getBoardImages().get(0).getMainImageUrl()); //get original size of pictures
			//get width and height from original size
			BufferedImage bimg;
			try 
			{
				bimg = ImageIO.read(originalImageFile);
				double width = bimg.getWidth();
				double height = bimg.getHeight();
				double ratioOfWidth=width/400.0;
				double ratioOfHeight=height/400.0;
				if(ratioOfWidth<=1.0 || ratioOfHeight<=1.0)
					model.addAttribute("hasSimiliarSize", true);
				else
					model.addAttribute("hasSimiliarSize", false);
				//passing the value of width and height
				model.addAttribute("imageWidth", width);
				model.addAttribute("imageHeight", height);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			model.addAttribute("imageurl_original", null); //get original size of pictures
		//check portfolio images size
		for(TrPortfolioImagesDomain item : response.getBoard().getPortfolioImages())
		{
			//get width and height from original size
			BufferedImage bimg;
			try 
			{
				File portfolioImageFile=new File(profileLocation_bigimage+"/"+item.getMainImageUrl());
				bimg = ImageIO.read(portfolioImageFile);
				double width = bimg.getWidth();
				double height = bimg.getHeight();
				double ratioOfWidth=width/400.0;
				double ratioOfHeight=height/400.0;
				if(ratioOfWidth<=1.0 || ratioOfHeight<=1.0)
					item.setIsActualSize(true);
				else
					item.setIsActualSize(false);
				//passing the value of width and height
				item.setImageWidth(width);
				item.setImageHeight(height);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				// Set default size
				item.setIsActualSize(true);
				item.setImageWidth(400);
				item.setImageHeight(400);
			}
		}
		//comment form
		model.addAttribute("messageForm", new MessageForm());
		//get board suggestion data
		GetBoardsSuggestionRequest boardsSuggestionRequest=new GetBoardsSuggestionRequest();
		boardsSuggestionRequest.setNumberOfBoards(4);
		boardsSuggestionRequest.setMemPricingOptionId(adUser.getUserMembership().get(0).getMembershipPricingId());
		GetBoardsSuggestionResponse boardsSuggestionResponse=boardServiceSDK.getBoardsSuggestion(boardsSuggestionRequest);
		model.addAttribute("boardsSuggestion", boardsSuggestionResponse.getBoards());
		//Get related boards (in same portfolio)
		GetBoardsByPortfolioResponse boardsByPortfolio=boardServiceSDK.getBoardsbyPortfolioId(response.getBoard().getPortfolioId());
		List<TrBoardDomain> boardsByPortfolioDomain=boardsByPortfolio.getBoards();
		boardsFilter(boardsByPortfolioDomain,adUser.getUserType()); //filtered out the board.
		model.addAttribute("boardsByPortfolio", boardsByPortfolioDomain);
		
		/*//get recent 12 boards
		boardsSuggestionRequest.setNumberOfBoards(12);
		GetBoardsSuggestionResponse boardsSuggestionResponse=boardServiceSDK.getBoardsSuggestion(boardsSuggestionRequest);
		List<TrBoardSearchDomain> suggestBoards = boardsSuggestionResponse.getBoards();
		//shuffle the board list
		Collections.shuffle(suggestBoards);
		model.addAttribute("boardsSuggestion", suggestBoards);*/
		return ViewNames.BOARD_DETAIL;
	}
	
	@RequestMapping(value=ViewPaths.BOARD_DETAIL_JSON+"/{id}",method=RequestMethod.GET)
	public @ResponseBody ModelMap getBoardDetailInJSON(@PathVariable(value="id") Integer id, @ModelAttribute(value="user") AdUsersDomain adUser, @ModelAttribute(value="cart") Cart cart, @ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model) throws DatatypeConfigurationException
	{
		logger.trace("BOARD DETAIL=>"+id);
		ModelMap map = new ModelMap();
		GetBoardByIdResponse response=boardServiceSDK.getBoardbyId(id);
		TrBoardDomain domain=response.getBoard();
		
		if(domain.getHasSellablePortfolio()==ActiveStatusEnum.ACTIVE.value()) //only push board which under sellable portfolio
		{
			AddRecentlyViewedBoardRequest request = new AddRecentlyViewedBoardRequest();
			TrRecentlyViewedDomain trRecentlyViewedDomain = new TrRecentlyViewedDomain();
			trRecentlyViewedDomain.setBoardId(id);
	//		trRecentlyViewedDomain.setClickId(value);
			trRecentlyViewedDomain.setCreatedby(adUser.getUserId());
			trRecentlyViewedDomain.setEventTime(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
			trRecentlyViewedDomain.setLastupdateby(adUser.getUserId());
			trRecentlyViewedDomain.setUserId(adUser.getUserId());
			request.setLogBoard(trRecentlyViewedDomain);
			if(adUser.getUserId()!=domain.getOriginalUserId())
				dataCaptureServiceSDK.addRecentlyViewBoard(request);
		}
		map.addAttribute("detail", domain); //add board detail
		//format the date
		Calendar postDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getLastUpdateDate()); //convert to Calendar
		postDate=TimeConvertUtil.convertToLocalTime(postDate, timezoneOffset); //convert to local time
		map.addAttribute("postDate", postDate.getTime()); //convert to Date
		//get designer's name
		ViewUserResponse userResponse=registrationServiceSDK.viewUser(domain.getOriginalUserId());
		map.addAttribute("userType", adUser.getUserType());
		//Check shopping cart if the user is customer, and update the board price with company commission as SALE_PRICE
		if(adUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
		{
			map.addAttribute("hasInShoppingCart", cart.getCart().containsKey(response.getBoard().getBoardId()));
			//Compute the SALE_PRICE with company commission
			GetMembershipCommissionRequest getCommissionRequest = new GetMembershipCommissionRequest();
			getCommissionRequest.setUserId(adUser.getUserId());
			GetMembershipCommissionResponse getCommissionResponse =  membershipServiceSDK.getMembershipCommissiondetails(getCommissionRequest);
			BigDecimal commission = getCommissionResponse.getStPricingOptions().getCommission();
			BigDecimal salePrice = domain.getTotalPrice().multiply(commission.add(new BigDecimal(100))).divide(new BigDecimal(100));
			domain.setTotalPrice(salePrice.setScale(2, RoundingMode.HALF_UP));
		}
		//Convert board price to FFG credit
		this.convertPriceToCredit(domain, this.creditConversionToUsd);
		//disable the shopping cart function and image if the board has been sold.
		switch(domain.getPublishToMP())
		{
		case 0: //unpublished
			//the board is being sold or ready to download (handle MP=0, Board is SOLD or READY)
			if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId()
				|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId()
				|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeId())
			{
				//if user is original user or current user of board, show the thumb image.
				if(adUser.getUserId()==domain.getOriginalUserId() || adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getLastupdateby())
				{
					map.addAttribute("canShow", true);
					map.addAttribute("canShop", false);
					map.addAttribute("shopTypeCode", "board.isOwnerOrDesigner");
				}
				else
				{
					map.addAttribute("canShow", false);	//if it's sold and the user is not current user or original user, don't show the image.
					map.addAttribute("typeCode", "board.sold");
					map.addAttribute("canShop", false);
					map.addAttribute("shopTypeCode", "board.sold");
				}
				//If board is sold and the user is the owner, show the SAL_PRICE from tr_sales_transaction table
				if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() && adUser.getUserId()==domain.getCurrentUerId())
				{
					//show SALE_PRICE instead of total price
					logger.debug("Show sale price => $"+domain.getSalePrice());
					domain.setTotalPrice(domain.getSalePrice());
				}
				
				//If board is sold and the user is the original designer, show the board status as sold
				if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() && adUser.getUserId()==domain.getOriginalUserId())
					domain.setBoardStatus("Sold");
			}
			else //handle MP=0, the board is processing or available
			{
				//if the user is designer, he can see the image, and others cannot.
				if(adUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && (adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getOriginalUserId()))
				{
					map.addAttribute("canShow", true);
					map.addAttribute("canShop", false);
					map.addAttribute("shopTypeCode", "board.unpublished.unrelatedusers");
				}
				else
				{
					map.addAttribute("canShow", false);
					map.addAttribute("typeCode", "board.unpublished");
					map.addAttribute("canShop", false);
					map.addAttribute("typeCode", "board.unpublished");
				}
			}
			break;
		case 1: //published
			if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId()) //Everybody can see the image.
			{
				map.addAttribute("canShow", true);
				map.addAttribute("canShop", true);
			}
			else if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() 
					|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_READY.getTypeId()
					|| domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeId())
			{
				//if user is original user or current user of board, show the thumb image.
				if(adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getOriginalUserId() || adUser.getUserId()==domain.getLastupdateby())
				{
					map.addAttribute("canShow", true);
					map.addAttribute("canShop", false);
					map.addAttribute("shopTypeCode", "board.isOwnerOrDesigner");
				}
				else
				{
					map.addAttribute("canShow", false);	//if it's sold and the user is not current user or original user, don't show the image.
					map.addAttribute("typeCode", "board.sold");
					map.addAttribute("canShop", false);
					map.addAttribute("shopTypeCode", "board.sold");
				}
			}
			else
			{
				map.addAttribute("canShow", true);
				map.addAttribute("canShop", true);
			}
			//If board is sold and the user is the owner, show the SAL_PRICE from tr_sales_transaction table
			if(domain.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeId() && adUser.getUserId()==domain.getCurrentUerId())
			{
				//show SALE_PRICE instead of total price
				logger.debug("Show sale price => $"+domain.getSalePrice());
				domain.setTotalPrice(domain.getSalePrice());
			}
			break;
		case 2: //processing
			//Only the user who is original user can see the image
			if(adUser.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) && (adUser.getUserId()==domain.getCurrentUerId() || adUser.getUserId()==domain.getOriginalUserId()))
			{
				map.addAttribute("canShow", true);
				map.addAttribute("canShop", false);
				map.addAttribute("shopTypeCode", "board.processing");
			}
			else
			{
				map.addAttribute("canShow", false);
				map.addAttribute("typeCode", "board.processing");
				map.addAttribute("canShop", false);
				map.addAttribute("shopTypeCode", "board.processing");
			}
			break;
		default:
			map.addAttribute("canShow", false);
			map.addAttribute("typeCode", "board.unknownstates");
			map.addAttribute("canShop", false);
			map.addAttribute("shopTypeCode", "board.unknownstates");
			break;
		}
		
		map.addAttribute("designerName", userResponse.getUser().getFirstname()+" "+userResponse.getUser().getLastname());
		map.addAttribute("designerLogo",userResponse.getUser().getLogoimageurl());
		map.addAttribute("userName", adUser.getFirstname()+" "+adUser.getLastname());
		map.addAttribute("userLogo", adUser.getLogoimageurl());
		map.addAttribute("imageurl", domain.getBoardImages().get(0).getFileName()); //get 400x400 images
		//check the file exists or not, if the file is not exist send the empty string
		File originalImageFile=new File(profileLocation_bigimage+"/"+domain.getBoardImages().get(0).getMainImageUrl());
		if(originalImageFile.exists())
		{
			map.addAttribute("imageurl_original", domain.getBoardImages().get(0).getMainImageUrl()); //get original size of pictures
			//get width and height from original size
			BufferedImage bimg;
			try 
			{
				bimg = ImageIO.read(originalImageFile);
				double width = bimg.getWidth();
				double height = bimg.getHeight();
				double ratioOfWidth=width/400.0;
				double ratioOfHeight=height/400.0;
				if(ratioOfWidth<=1.0 || ratioOfHeight<=1.0)
					map.addAttribute("hasSimiliarSize", true);
				else
					map.addAttribute("hasSimiliarSize", false);
				//passing the value of width and height
				map.addAttribute("imageWidth", width);
				map.addAttribute("imageHeight", height);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			map.addAttribute("imageurl_original", null); //get original size of pictures
		//check portfolio images size
		for(TrPortfolioImagesDomain item : response.getBoard().getPortfolioImages())
		{
			//get width and height from original size
			BufferedImage bimg;
			try 
			{
				File portfolioImageFile=new File(profileLocation_bigimage+"/"+item.getMainImageUrl());
				bimg = ImageIO.read(portfolioImageFile);
				double width = bimg.getWidth();
				double height = bimg.getHeight();
				double ratioOfWidth=width/400.0;
				double ratioOfHeight=height/400.0;
				if(ratioOfWidth<=1.0 || ratioOfHeight<=1.0)
					item.setIsActualSize(true);
				else
					item.setIsActualSize(false);
				//passing the value of width and height
				item.setImageWidth(width);
				item.setImageHeight(height);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				// Set default size
				item.setIsActualSize(true);
				item.setImageWidth(400);
				item.setImageHeight(400);
			}
		}
		//comment form
		map.addAttribute("messageForm", new MessageForm());
		//get board suggestion data
		GetBoardsSuggestionRequest boardsSuggestionRequest=new GetBoardsSuggestionRequest();
		boardsSuggestionRequest.setNumberOfBoards(4);
		boardsSuggestionRequest.setMemPricingOptionId(adUser.getUserMembership().get(0).getMembershipPricingId());
		GetBoardsSuggestionResponse boardsSuggestionResponse=boardServiceSDK.getBoardsSuggestion(boardsSuggestionRequest);
		map.addAttribute("boardsSuggestion", boardsSuggestionResponse.getBoards());
		//Get related boards (in same portfolio)
		GetBoardsByPortfolioResponse boardsByPortfolio=boardServiceSDK.getBoardsbyPortfolioId(response.getBoard().getPortfolioId());
		List<TrBoardDomain> boardsByPortfolioDomain=boardsByPortfolio.getBoards();
		boardsFilter(boardsByPortfolioDomain,adUser.getUserType()); //filtered out the board.
		map.addAttribute("boardsByPortfolio", boardsByPortfolioDomain);
		
		/*//get recent 12 boards
		boardsSuggestionRequest.setNumberOfBoards(12);
		GetBoardsSuggestionResponse boardsSuggestionResponse=boardServiceSDK.getBoardsSuggestion(boardsSuggestionRequest);
		List<TrBoardSearchDomain> suggestBoards = boardsSuggestionResponse.getBoards();
		//shuffle the board list
		Collections.shuffle(suggestBoards);
		model.addAttribute("boardsSuggestion", suggestBoards);*/
		return map;
	}
	
	private void boardsFilter(List<TrBoardDomain> domain, String userType)
	{
		if(userType.equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
		{
			Predicate<TrBoardDomain> filter = new Predicate<TrBoardDomain>()
			{ 
				public boolean apply(TrBoardDomain item)
				{
					//if the board is not available, inactive, not expired, unpublished or reviewing boards. Filtered out the array.
					if(item.getActiveStatus()==ActiveStatusEnum.ACTIVE.value() 
							&& item.getPublishToMP() == Constants.PUBLISH_TO_MARKET_YES
							&& item.getStatusId()==LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId()
							&& item.getOriginalUserId()==item.getCurrentUerId()
							&& XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(item.getExperiationDate()).after(Calendar.getInstance()))
					{
						return false; //leave in the collection
					}
					else
						return true; //filtered out from the collection
				}
			};
			Collection<TrBoardDomain> collection = Collections2.filter(domain, filter);
			collection.clear();
		}
		else
		{
			Predicate<TrBoardDomain> filter = new Predicate<TrBoardDomain>()
			{ 
				public boolean apply(TrBoardDomain item)
				{
					//if the board is not available, inactive or unpublished boards. Filtered out the array.
					if(item.getActiveStatus()==ActiveStatusEnum.INACTIVE.value() 
							|| (item.getStatusId()!=LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId() && item.getStatusId()!=LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeId()) 
							|| item.getOriginalUserId()!=item.getCurrentUerId())
						return true;
					else
						return false;
				}
			};
			Collection<TrBoardDomain> collection = Collections2.filter(domain, filter);
			collection.clear();
		}
	}
	
	@RequestMapping(value=ViewPaths.DELETE_BOARD,method=RequestMethod.POST)
	public @ResponseBody ModelMap deleteBoard(DeleteItemsForm formBean,ModelMap model)
	{
		boolean hasError=false;
		ModelMap map=new ModelMap();
		logger.trace("DELETE BOARD FORM=>"+formBean.toString());
		for(Integer i=0;i<formBean.getSelectedItems().length;i++)
		{
			GetBoardByIdResponse boardResponse = boardServiceSDK.getBoardbyId(formBean.getSelectedItems()[i]);
			//check the board is not locked. If it's locked(the status is not available), set the error status back to the user.
			if(boardResponse.getBoard().getStatusId() != LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId())
			{
				map.addAttribute("hasError", true);
				map.addAttribute("errorCode", StatusCodesEnum.STATUS_BOARD_UNDER_PROCESSED.getCode());
				map.addAttribute("errorDescription", "Board is being processed");
				return map;
			}
			DeleteBoardByIdResponse deleteResponse = boardServiceSDK.deleteBoardById(formBean.getSelectedItems()[i]);
			if(deleteResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				hasError=false;
			else
				hasError=true;
		}
		if(hasError)
			map.addAttribute("hasError", true);
		else
			map.addAttribute("hasError", false);
		return map;
	}
	
	@RequestMapping(value=ViewPaths.DELETE_BOARD+"/{boardId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap deleteBoard(@PathVariable(value="boardId") Integer boardId)
	{
		ModelMap map=new ModelMap();
		GetBoardByIdResponse boardResponse = boardServiceSDK.getBoardbyId(boardId);
		//check the board is not locked. If it's locked(the status is not available), set the error status back to the user.
		if(boardResponse.getBoard().getStatusId() != LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId())
		{
			map.addAttribute("hasError", true);
			map.addAttribute("errorCode", StatusCodesEnum.STATUS_BOARD_UNDER_PROCESSED.getCode());
			map.addAttribute("errorDescription", "Board is being processed");
			return map;
		}
		DeleteBoardByIdResponse deleteResponse = boardServiceSDK.deleteBoardById(boardId);
		if(deleteResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			map.addAttribute("hasError", false);
		else
			map.addAttribute("hasError", true);		
		
		return map;
	}
	
	@RequestMapping(value=ViewPaths.TOGGLE_STATUS_BOARD+"/{boardId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap toggleStatusBoard(@ModelAttribute("user") AdUsersDomain user,@PathVariable(value="boardId") Integer boardId)
	{
		ModelMap map=new ModelMap();
		List<TrBoardDomain> vals = new ArrayList<TrBoardDomain>();
		TrBoardDomain item=new TrBoardDomain();
		item.setBoardId(boardId);
		item.setLastupdateby(user.getUserId());
		vals.add(item);
		UpdatePublishBoardStatusRequest request = new UpdatePublishBoardStatusRequest(vals);
		
		GetBoardByIdResponse boardResponse = boardServiceSDK.getBoardbyId(boardId);
		//check the board is not locked. If it's locked(the status is not available), set the error status back to the user.
		if(boardResponse.getBoard().getStatusId() != LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId())
		{
			map.addAttribute("hasError", true);
			map.addAttribute("errorCode", StatusCodesEnum.STATUS_BOARD_UNDER_PROCESSED.getCode());
			map.addAttribute("errorDescription", "Board is being processed");
			return map;
		}
		UpdatePublishBoardStatusResponse response = boardServiceSDK.updatePublishBoardStatus(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			map.addAttribute("hasError", false);
		else
			map.addAttribute("hasError", true);		
		
		return map;
	}
	
	@RequestMapping(value=ViewPaths.PRICE_GUIDELINE,method=RequestMethod.GET)
	public String getPriceGuideline(ModelMap model)
	{	
		return ViewNames.PRICE_GUIDELINE;
	}
	
	@RequestMapping(value=ViewPaths.IMAGE_VIEWER,method=RequestMethod.GET)
	public String viewImage(ModelMap model,@RequestParam(value="img") String imageFileName)
	{	
		model.addAttribute("imageUrl", "/bigimage/"+imageFileName);
		return ViewNames.IMAGE_VIEWER;
	}
	
	@RequestMapping(value=ViewPaths.IMAGE_SIZE_RETRIEVER,method=RequestMethod.GET)
	public @ResponseBody ModelMap retrieveImageSize(@RequestParam(value="img") String imageFileName)
	{	
		ModelMap model = new ModelMap();
		//check the file exists or not, if the file is not exist send the empty string
		File originalImageFile=new File(profileLocation_bigimage+"/"+imageFileName);
		if(originalImageFile.exists())
		{
			//get width and height from original size
			BufferedImage bimg;
			try 
			{
				bimg = ImageIO.read(originalImageFile);
				double width = bimg.getWidth();
				double height = bimg.getHeight();
				model.addAttribute("imageWidth", width); //get original size of pictures
				model.addAttribute("imageHeight", height);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				model.addAttribute("imageWidth", null); //get original size of pictures
				model.addAttribute("imageHeight", null);
			}
		}
		else
		{
			model.addAttribute("imageWidth", null); //get original size of pictures
			model.addAttribute("imageHeight", null); 
		}
		return model;
	}
	
	@RequestMapping(value=ViewPaths.COMPUTE_BOARD_EXP_DATE,method=RequestMethod.GET)
	public @ResponseBody ModelMap computeBoardExpDate(@RequestParam(value="days") int days,@ModelAttribute("timezoneOffset") Integer timezoneOffset,ModelMap model)
	{
		ModelMap result=new ModelMap();
		Calendar day=Calendar.getInstance();
		day.add(Calendar.DAY_OF_MONTH, +days);
		
		//compute the estimate expiration date
		Calendar estimateExpDate=Calendar.getInstance();
		estimateExpDate.add(Calendar.DAY_OF_MONTH, +days);
		//Convert to local time
		estimateExpDate=TimeConvertUtil.convertToLocalTime(estimateExpDate, timezoneOffset);
		SimpleDateFormat dateFormater = new SimpleDateFormat("MMM dd,yyyy");
		result.addAttribute("expirationDate", dateFormater.format(estimateExpDate.getTime()));
		return result;
	}
	
	@RequestMapping(value=ViewPaths.IS_BOARD_LOCKED,method=RequestMethod.GET)
	public @ResponseBody ModelMap isBoardLocked(@RequestParam(value="boardId") int boardId,ModelMap model)
	{
		ModelMap map=new ModelMap();
		GetBoardByIdResponse response=boardServiceSDK.getBoardbyId(boardId);
		if(response.getBoard().getStatusId()!=LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId())
		{
			map.addAttribute("hasLocked", true);
		}
		else
		{
			map.addAttribute("hasLocked", false);
		}
		return map;
	}
	
	private boolean convertPriceToCredit(List<TrBoardDomain> boards,int conversionRate)
	{
		boolean hasError=false;
		try
		{
			for(TrBoardDomain item : boards)
			{
				//covert board price to FFG credits
				hasError = convertPriceToCredit(item, conversionRate);
			}
		}
		catch(Exception e)
		{
			hasError = true;
		}
		return hasError;
	}
	
	private boolean convertPriceToCredit(TrBoardDomain board,int conversionRate)
	{
		boolean hasError=false;
		try
		{
			//covert board price to FFG credits
		    BigDecimal ffgCredit = board.getBoardPrice().divide(new BigDecimal(conversionRate));
		    BigDecimal ffgCreditOnTotalPrice = board.getTotalPrice().divide(new BigDecimal(conversionRate));
		    board.setBoardPrice(ffgCredit.setScale(0,BigDecimal.ROUND_CEILING));
		    board.setTotalPrice(ffgCreditOnTotalPrice.setScale(0,BigDecimal.ROUND_CEILING));
		}
		catch(Exception e)
		{
			hasError = true;
		}
		return hasError;
	}
}
