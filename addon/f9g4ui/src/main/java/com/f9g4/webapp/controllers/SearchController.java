package com.f9g4.webapp.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StCategoryMasterDomain;
import com.f9g4.businessobjects.domain.StSeasonYearDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrBoardSearchDomain;
import com.f9g4.businessobjects.services.SearchBoardsRequest;
import com.f9g4.businessobjects.services.SearchBoardsResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.forms.Cart;
import com.f9g4.web.forms.SearchCriteriaForm;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;
import com.googlecode.ehcache.annotations.Cacheable;

@Controller
@SessionAttributes(value={"user","searchResults","timezoneOffset","cart"})
public class SearchController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;
	
	@Autowired @Value("${f9g4.webapp.search.admin_rating.min}")
	private Double searchMinAdminRating;
	
	@Autowired @Value("${f9g4.webapp.credit.conversion.usd}")
	private int creditConversionToUsd;
	
	//Countries
	@ModelAttribute("countryList")
	public List<AdLookupValuesDomain> getCountryList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.ISO_COUNTRY.getTypeName()).getLookupTypeValues();
	}
	
	//Languages 
	@ModelAttribute("languagesList")
	public List<AdLookupValuesDomain> getLanguagesList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.ISO_LANGUAGES.getTypeName()).getLookupTypeValues();
	}
	
	//Skills 
	@ModelAttribute("skillsList")
	public List<AdLookupValuesDomain> getSkillsList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.USER_SKILLS.getTypeName()).getLookupTypeValues();
	}
	
	@ModelAttribute("saleTypeList")
	public List<AdLookupValuesDomain> getSaleTypeList() {
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.SALE_TYPE.getTypeName()).getLookupTypeValues();
	}

	/*//Product
	@ModelAttribute("productList")
	public List<StCategoryMasterDomain> getProductList() 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_1, Constants.PARENT_ID_0).getStCategoryMasterDomain();
	}
	
	//Product Type
	@ModelAttribute("productTypeList")
	public List<StCategoryMasterDomain> getProductTypeList() 
	{
		//TODO - remove this methos
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_2, 1).getStCategoryMasterDomain();
	}*/
	
	/*//Category
	@ModelAttribute("categoryList")
	public List<StCategoryMasterDomain> getCategoryList() 
	{
		//TODO - remove this methos
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_3, 12).getStCategoryMasterDomain();
	}*/
	
	//Division
	@Cacheable(cacheName="divisionList")
	@ModelAttribute("divisionList")
	public List<StCategoryMasterDomain> getCategoryList() 
	{
		//TODO - remove this methods
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_1, 0).getStCategoryMasterDomain();
	}

	//season
	@Cacheable(cacheName="seasonYear")
	@ModelAttribute("seasonYear")
	public List<StSeasonYearDomain> getSeasonYear() 
	{
		return registrationServiceSDK.getSeasonAllYears().getStSeasonYearDomains();
	}
	
	//Specialty 
	@ModelAttribute("specialtyList")
	public List<AdLookupValuesDomain> getSpecialtyList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.AREA_OF_SPECIALTY.getTypeName()).getLookupTypeValues();
	}
	
	//Expertise
	@ModelAttribute("expertiseList")
	public List<AdLookupValuesDomain> getExpertiseList() 
	{
		return registrationServiceSDK.getLookupTypeValues(LookupTypeEnum.AREA_OF_EXPERTISE.getTypeName()).getLookupTypeValues();
	}
	
	@RequestMapping(value=ViewPaths.SEARCH_CRITERIA,method=RequestMethod.GET)
	public String showSearchCriteria(ModelMap model)
	{
		model.addAttribute("searchCriteriaForm", new SearchCriteriaForm());
		model.addAttribute("default_country_code",LookupTypeValueEnum.COUNTRY_US.getTypeCode());
		model.addAttribute("default_language_code", LookupTypeValueEnum.LANGUAGE_US.getTypeCode());
		return ViewNames.SEARCH_CRITERIA;
	}
	
	@RequestMapping(value=ViewPaths.SEARCH_CRITERIA,method=RequestMethod.POST)
	public @ResponseBody ModelMap syncSearch(SearchCriteriaForm formBean,ModelMap map)
	{
		return this.syncResult(map);
	}
	
	@Autowired
	private BoardServiceSDK boardServiceSDK ;
	
	@RequestMapping(value=ViewPaths.SEARCH_RESULT,method=RequestMethod.POST)
	//public String searchResult(SearchCriteriaForm formBean, ModelMap model)
	public @ResponseBody ModelMap syncSearchResult(@ModelAttribute(value="searchResults") List<TrBoardSearchDomain> domain,ModelMap map)
	{
		return this.syncResult(map);
	}
	
	@RequestMapping(value=ViewPaths.SEARCH_RESULT,method=RequestMethod.GET)
	//public String searchResult(SearchCriteriaForm formBean, ModelMap model)
	public @ResponseBody ModelMap searchResult(SearchCriteriaForm formBean,@ModelAttribute(value="user") AdUsersDomain adUser, ModelMap model)
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
		List<Integer> seasonYearIds = request.getSeasonYearIds();;
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
		
		request.setDivision(formBean.getDivision());
		request.setCategory(formBean.getCategory());
		request.setProduct(formBean.getProduct()); 
		request.setPriceOption(null);
		request.setMinPrice(new BigDecimal(formBean.getMinPrice()));
		request.setMaxPrice(new BigDecimal(formBean.getMaxPrice()));

		request.setRatingOption(null);
		request.setMinBuyerRating(formBean.getMinBuyerRating());
		request.setMaxBuyerRating(formBean.getMaxBuyerRating());
		//======================================================
		request.setSchoolAwards(formBean.getMisc());
		request.setKeywords(StringEscapeUtils.escapeXml(formBean.getKeywords()));
		
		//set portfolio search params
		request.setIsPortfolioSearch(false);
		
		//assign user id
		request.setUserId(adUser.getUserId());
		
		//setup admin rating range
		request.setMinAdminRating(this.searchMinAdminRating.intValue());
		request.setMaxAdminRating(5);

		//setup marketplace search mode
		request.setIsPortfolioSearch(false);
		
		//Expertise
		List<Integer> expertiseIds = request.getExpertiseIds();
		if(null != formBean.getExpId()){
			for(Integer id: formBean.getExpId()){
				expertiseIds.add(id);
			}
		}
		
		//Specialty
		List<Integer> specialtyIds = request.getSpecialtyIds();
		if(null != formBean.getSplId()){
			for(Integer id: formBean.getSplId()){
				specialtyIds.add(id);
			}
		}
		
		ModelMap modelMap = new ModelMap();
		SearchBoardsResponse response = boardServiceSDK.searchBoards(request);
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			modelMap.addAttribute("hasError", false);
		}else
		{
			modelMap.addAttribute("hasError", true);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.MAXIMUM_RECORDS_REACHED.getCode()))
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
		logger.trace("SEARCH RESULT SIZE=>"+response.getTrBoardSearchDomains().size());
		modelMap.addAttribute("results", response.getTrBoardSearchDomains());
		//prepare JSON object
		ModelMap allResult = new ModelMap();
		ModelMap portfolioPagesResult = new ModelMap();
		ModelMap marketplaceSubmissionResult = new ModelMap();
		ModelMap examplesResult = new ModelMap();
		ModelMap profilesResult = new ModelMap();
		//Search data
		//portfolioPagesResult.addAttribute("data", portfolioPageResponse.getTrBoardSearchDomains());
		marketplaceSubmissionResult.addAttribute("data", response.getTrBoardSearchDomains());
		//profilesResult.addAttribute("data", profiles);
		//examplesResult.addAttribute("data", searchExamplesResponse.getTrBoardSearchDomains());
		//Bind all data to response object
		allResult.addAttribute("portfolioPages", portfolioPagesResult);
		allResult.addAttribute("marketplaceSubmission", marketplaceSubmissionResult);
		allResult.addAttribute("profiles", profilesResult);
		allResult.addAttribute("examples", examplesResult);
		allResult.addAttribute("form", formBean);
		modelMap.addAttribute("result", allResult);
		//
		model.addAttribute("searchResults", allResult); //put search result into session
		return modelMap;
		//return ViewNames.SEARCH_RESULT;
	}
	
	@RequestMapping(value=ViewPaths.SAVE_SEARCH_CRITERIA,method=RequestMethod.GET)
	public String saveSearchCriteria(ModelMap model)
	{
		List<StSeasonYearDomain> list=getSeasonYear();
		logger.trace("seasonList=>"+list.toString());
		return ViewNames.SAVE_SEARCH_CRITERIA;
	}
	
	@RequestMapping(value=ViewPaths.SEASON_YEAR_LIST+"/{mode}",method=RequestMethod.GET)
	public String getSeasonYearList(@PathVariable(value="mode") String mode,ModelMap model)
	{
		List<StSeasonYearDomain> list=getSeasonYear();
		ArrayList<String> year=new ArrayList<String>();
		// create an arraylist which there is no duplicate year.
		for(StSeasonYearDomain item : list)
		{
			if(!year.contains(item.getYear()))
				year.add(item.getYear());
		}
		model.addAttribute("year", year);
		model.addAttribute("season",list);
		model.addAttribute("mode",mode);
		return ViewNames.SEASON_YEAR_LIST;
	}
	
	@RequestMapping(value = ViewPaths.SEARCH_VIEWER, method = RequestMethod.GET)
	public String showSearchViewer(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) 
	{
		return ViewNames.SEARCH_VIEWER;
	}
	
	@RequestMapping(value = ViewPaths.SEARCH_VIEWER, method = RequestMethod.POST)
	public @ResponseBody ModelMap syncSearchResult(@ModelAttribute("user") AdUsersDomain user,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap map) 
	{
		return this.syncResult(map);
	}
	
	private ModelMap syncResult(ModelMap source)
	{
		ModelMap model = new ModelMap();
		if(source.containsKey("searchResults"))
		{
			ModelMap searchResult = (ModelMap) source.get("searchResults");
			model.addAttribute("finalSearchResult", searchResult);
		}
		else
		{
			model.addAttribute("finalSearchResult", 0);
		}
		return model;
	}
}
