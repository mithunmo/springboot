package com.f9g4.webapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.StCategoryMasterDomain;
import com.f9g4.businessobjects.services.GetCategoriesRequest;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetPortfolioByIdResponse;
import com.f9g4.common.util.Constants;
import com.f9g4.servicesdk.PortfolioServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.forms.Cart;
import com.f9g4.web.forms.CartItem;
import com.f9g4.web.utils.ViewPaths;
import com.google.common.collect.Collections2;
import com.googlecode.ehcache.annotations.Cacheable;

@Controller
@SessionAttributes(value={"cart" })
public class BoardLevelController 
{
	@Autowired
	RegistrationServiceSDK registrationServiceSDK=new RegistrationServiceSDK();
	
	@Autowired
	PortfolioServiceSDK portfolioServiceSDK=new PortfolioServiceSDK();
	
	@Cacheable(cacheName="categoryList")
	public List<StCategoryMasterDomain> getCategoryList(Integer parentId) 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_2, parentId).getStCategoryMasterDomain();
	}
	
	@Cacheable(cacheName="productList")
	public List<StCategoryMasterDomain> getProductList(Integer parentId) 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_3, parentId).getStCategoryMasterDomain();
	}
	
	@Cacheable(cacheName="productTypeList")
	public List<StCategoryMasterDomain> getProductTypeList(Integer parentId) 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_4, parentId).getStCategoryMasterDomain();
	}
	
	@RequestMapping(value=ViewPaths.GET_CATEGORY_LIST+"/{parentId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap getCategoryListByParentId(@PathVariable(value="parentId") int parentId)
	{
		ModelMap map=new ModelMap();
		List<StCategoryMasterDomain> list=getCategoryList(parentId);
		map.addAttribute("list", list);
		return map;
	}
	
	
	@RequestMapping(value=ViewPaths.GET_PRODUCT_LIST+"/{parentId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap getProductListByParentId(@PathVariable(value="parentId") int parentId)
	{
		ModelMap map=new ModelMap();
		List<StCategoryMasterDomain> list=getProductList(parentId);
		map.addAttribute("list", list);
		return map;
	}
	
	@RequestMapping(value=ViewPaths.GET_PRODUCT_LIST_BY_PORTFOLIO+"/{portfolioId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap getProductListByPortfolioId(@PathVariable(value="portfolioId") int id)
	{
		ModelMap map=new ModelMap();
		GetPortfolioByIdResponse response=portfolioServiceSDK.getPortfoliobyId(id);
		int level2Id=response.getPortfolio().getCategoryLevel2Id();
		List<StCategoryMasterDomain> list=getProductList(level2Id);
		map.addAttribute("list", list);
		return map;
	}
	
	@RequestMapping(value=ViewPaths.GET_PRODUCT_TYPE_LIST+"/{parentId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap getProductTypeListByParentId(@PathVariable(value="parentId") int parentId)
	{
		ModelMap map=new ModelMap();
		List<StCategoryMasterDomain> list=getProductTypeList(parentId);
		map.addAttribute("list", list);
		return map;
	}
	
	@RequestMapping(value=ViewPaths.GET_PRODUCT_TYPE_LIST,method=RequestMethod.GET)
	public @ResponseBody ModelMap getProductTypeListByParentIds(@RequestParam(value="portfolioId",required=false) Integer portfolioId,@RequestParam(value="level1",required=false) Integer level1,@RequestParam(value="level2",required=false) Integer level2, @RequestParam(value="productTags",required=false,defaultValue="") String[] parentNames)
	{
		ModelMap map=new ModelMap();
		GetCategoriesRequest request = new GetCategoriesRequest();
		request.setLevel(4);
		if(portfolioId!=null)
			request.setPortfolioId(portfolioId);
		if(level1!=null)
			request.setLevel1(level1);
		if(level2!=null)
			request.setLevel2(level2);
		List<String> nameForLevel3 = request.getNameForLevel3();
		nameForLevel3.addAll(Arrays.asList(parentNames));
		GetCategoriesResponse response = registrationServiceSDK.getCategoriesByLevel(request);
		map.addAttribute("list", response.getStCategoryMasterDomain());
		return map;
	}
	
	@RequestMapping(value=ViewPaths.GET_LEVEL_LIST+"/{level}/{parentId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap getLevelList(@PathVariable(value="level") int level,@PathVariable(value="parentId") Integer parentId, ModelMap model)
	{
		List<StCategoryMasterDomain> list=new ArrayList<StCategoryMasterDomain>();
		ModelMap map=new ModelMap();
		if(level==2)
		{
			list=getCategoryList(parentId);
		}
		map.addAttribute("list", list);
		return map;
	}
	
}