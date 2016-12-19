package com.f9g4.webapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.PathParam;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StCategoryMasterDomain;
import com.f9g4.businessobjects.domain.StSeasonYearDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.domain.TrPortfolioImagesDomain;
import com.f9g4.businessobjects.services.AddPortfolioRequest;
import com.f9g4.businessobjects.services.AddPortfolioResponse;
import com.f9g4.businessobjects.services.DeletePortfolioByIdResponse;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.GetBoardsByPortfolioResponse;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetPortfolioByIdResponse;
import com.f9g4.businessobjects.services.GetPortfolioByUserResponse;
import com.f9g4.businessobjects.services.UpdatePortfolioRequest;
import com.f9g4.businessobjects.services.UpdatePortfolioResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.PortfolioServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
//import com.f9g4.webapp.domain.User;
import com.f9g4.web.forms.CreatePortfolioForm;
import com.f9g4.web.forms.DeleteItemsForm;
import com.f9g4.web.utils.ErrorsCodeEnum;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;
import com.f9g4.web.validator.CreatePortfolioFormValidator;

@Controller
@SessionAttributes({"user","isVisibleDesigner"})
public class PortfolioController {
	
	private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK=new RegistrationServiceSDK();
	
	@Autowired
	private PortfolioServiceSDK portfolioSDK=new PortfolioServiceSDK();
	
	@Autowired
	private BoardServiceSDK boardServiceSDK=new BoardServiceSDK();
	
	@Autowired
	private CreatePortfolioFormValidator createPortfolioFormValidator;
	
	//division
	@ModelAttribute("divisionList")
	public List<StCategoryMasterDomain> getDivisionList() 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_1, Constants.PARENT_ID_0).getStCategoryMasterDomain();
		//return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_2, 4).getStCategoryMasterDomain();
	}
	
	//Category
	@ModelAttribute("seasonYear")
	public List<StSeasonYearDomain> getSeasonYear() 
	{
		return registrationServiceSDK.getSeasonAllYears().getStSeasonYearDomains();
	}
	
	//Check the designer visibility
	private boolean isVisibleDesigner(AdUsersDomain user) 
	{
		//get unsellable portfolio id
		boolean isVisible=false;
		if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
		{
			GetPortfolioByUserResponse response=portfolioSDK.getUnsellablePortfoliobyUser(user.getUserId());
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
	
	@RequestMapping(value=ViewPaths.COLLECTIONS,method=RequestMethod.GET)
	public String getCollections(@ModelAttribute(value="user") AdUsersDomain adUser,Locale locale, ModelMap model)
	{
		/*model.addAttribute("locale" ,locale.getDisplayName());
//		PortfolioServiceSDK portfolioSdk=new PortfolioServiceSDK();
		GetPortfolioByUserResponse response=new GetPortfolioByUserResponse();
		response=portfolioSDK.getPortfoliobyUser(1);
		model.addAttribute("portfoliolist",response.getPortfolio());*/
		GetPortfolioByUserResponse response=portfolioSDK.getPortfoliobyUser(adUser.getUserId());
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			model.addAttribute("hasError", false);
			List<TrPortfolioDomain> domain=response.getPortfolio();
			model.addAttribute("results",domain);
			model.addAttribute("resultsCount",domain.size());
			//model.addAttribute("imagesList", imagesList);
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode",response.getStatus().getStatuscode());
			model.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		return ViewNames.COLLECTIONS;
	}
	
	//Get portfolio which is unsellable
	@RequestMapping(value=ViewPaths.NEW_PORTFOLIO,method=RequestMethod.GET)
	public String getPortfolio(@ModelAttribute(value="user") AdUsersDomain adUser,Locale locale, ModelMap model)
	{
		GetPortfolioByUserResponse response=portfolioSDK.getUnsellablePortfoliobyUser(adUser.getUserId());
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			model.addAttribute("hasError", false);
			List<TrPortfolioDomain> domain=response.getPortfolio();
			model.addAttribute("results",domain);
			model.addAttribute("resultsCount",domain.size());
			//model.addAttribute("imagesList", imagesList);
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode",response.getStatus().getStatuscode());
			model.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		return ViewNames.NEW_PORTFOLIO;
	}
	
	@RequestMapping(value=ViewPaths.GET_COLLECTION_ITEMS,method=RequestMethod.GET)
	public @ResponseBody ModelMap getCollectionItems(@ModelAttribute(value="user") AdUsersDomain adUser)
	{
		ModelMap model=new ModelMap();
		GetPortfolioByUserResponse response=portfolioSDK.getPortfoliobyUser(adUser.getUserId());
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			model.addAttribute("hasError", false);
			List<TrPortfolioDomain> domain=response.getPortfolio();
			/*//get boards by portfolio id to get board images=======================================================================
			ArrayList<ArrayList<String>> imagesList=new ArrayList<ArrayList<String>>();
			for(TrPortfolioDomain portfolioDomain:domain)
			{
				logger.trace("LOOPS=>"+portfolioDomain.getPortfolioId());
				GetBoardsByPortfolioResponse boardResponse=boardServiceSDK.getBoardsbyPortfolioId(portfolioDomain.getPortfolioId());
				List<TrBoardDomain> boardDomain=boardResponse.getBoards();
				logger.trace("BOARDS SIZE=>"+boardDomain.size());
				ArrayList<String> imageList=new ArrayList<String>();
				for(TrBoardDomain item:boardDomain)
				{
					if(item.getBoardImages().size()>0)
						imageList.add(item.getBoardImages().get(0).getThumbnailUrl());
				}
				imagesList.add(imageList);
			}*/
			//retrieve the images from trPortfolioDomain instead of call a service again.
			
			model.addAttribute("results",domain);
			model.addAttribute("isVisibleDesigner",isVisibleDesigner(adUser));
			
			//model.addAttribute("imagesList", imagesList);
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode",response.getStatus().getStatuscode());
			model.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		
		return model;
	}
	
	@RequestMapping(value=ViewPaths.GET_NEW_PORTFOLIO_ITEMS,method=RequestMethod.GET)
	public @ResponseBody ModelMap getPortfolioItems(@ModelAttribute(value="user") AdUsersDomain adUser)
	{
		ModelMap model=new ModelMap();
		GetPortfolioByUserResponse response=portfolioSDK.getUnsellablePortfoliobyUser(adUser.getUserId());
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			model.addAttribute("hasError", false);
			List<TrPortfolioDomain> domain=response.getPortfolio();
			model.addAttribute("results",domain);
			model.addAttribute("isVisibleDesigner",isVisibleDesigner(adUser));
		}
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode",response.getStatus().getStatuscode());
			model.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		
		return model;
	}
	
	@RequestMapping(value=ViewPaths.CREATE_COLLECTION,method=RequestMethod.GET)
	public String createCollection(@ModelAttribute(value="user") AdUsersDomain adUser,Locale locale, ModelMap model)
	{
		model.addAttribute("createPortfolioForm", new CreatePortfolioForm());
		/*model.addAttribute("locale" ,locale.getDisplayName());
//		PortfolioServiceSDK portfolioSdk=new PortfolioServiceSDK();
		GetPortfolioByUserResponse response=new GetPortfolioByUserResponse();
		response=portfolioSDK.getPortfoliobyUser(1);
		model.addAttribute("portfoliolist",response.getPortfolio());*/
		model.addAttribute("editMode", false);
		return ViewNames.CREATE_COLLECTION;
	}
	
	@RequestMapping(value=ViewPaths.CREATE_NEW_PORTFOLIO,method=RequestMethod.GET)
	public String createPortfolio(@ModelAttribute(value="user") AdUsersDomain adUser,Locale locale, ModelMap model)
	{
		model.addAttribute("createPortfolioForm", new CreatePortfolioForm());
		model.addAttribute("editMode", false);
		return ViewNames.CREATE_NEW_PORTFOLIO;
	}
	
	@RequestMapping(value=ViewPaths.CREATE_COLLECTION+"/{portfolioId}",method=RequestMethod.GET)
	public String editCollectionView(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable(value="portfolioId") Integer portfolioId, Locale locale, ModelMap model)
	{
		CreatePortfolioForm form = new CreatePortfolioForm();
		GetPortfolioByIdResponse response = portfolioSDK.getPortfoliobyId(portfolioId);
		form.setPortfolioName(response.getPortfolio().getName());
		form.setPortfolioDescription(response.getPortfolio().getDescription());
		form.setDivision(response.getPortfolio().getCategoryLevel1Id());
		form.setCategory(response.getPortfolio().getCategoryLevel2Id());
		GetCategoriesResponse cat=registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_2, response.getPortfolio().getCategoryLevel1Id());
		model.addAttribute("portfolio", response.getPortfolio());
		model.addAttribute("categoryList", cat.getStCategoryMasterDomain());
		model.addAttribute("editMode", true);
		model.addAttribute("portfolioId", portfolioId);
		model.addAttribute("seasonId", response.getPortfolio().getSeasonYearId());
		model.addAttribute("createPortfolioForm", form);
		return ViewNames.CREATE_COLLECTION;
	}
	
	@RequestMapping(value=ViewPaths.CREATE_NEW_PORTFOLIO+"/{portfolioId}",method=RequestMethod.GET)
	public String editPortfolioView(@ModelAttribute(value="user") AdUsersDomain adUser,@PathVariable(value="portfolioId") Integer portfolioId, Locale locale, ModelMap model)
	{
		CreatePortfolioForm form = new CreatePortfolioForm();
		GetPortfolioByIdResponse response = portfolioSDK.getPortfoliobyId(portfolioId);
		form.setPortfolioName(response.getPortfolio().getName());
		form.setPortfolioDescription(response.getPortfolio().getDescription());
		form.setDivision(response.getPortfolio().getCategoryLevel1Id());
		form.setCategory(response.getPortfolio().getCategoryLevel2Id());
		GetCategoriesResponse cat=registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_2, response.getPortfolio().getCategoryLevel1Id());
		model.addAttribute("portfolio", response.getPortfolio());
		model.addAttribute("categoryList", cat.getStCategoryMasterDomain());
		model.addAttribute("editMode", true);
		model.addAttribute("portfolioId", portfolioId);
		model.addAttribute("seasonId", response.getPortfolio().getSeasonYearId());
		model.addAttribute("createPortfolioForm", form);
		return ViewNames.CREATE_NEW_PORTFOLIO;
	}
	
	@RequestMapping(value=ViewPaths.CREATE_COLLECTION,method=RequestMethod.POST)
	public @ResponseBody ModelMap createCollectionResult(@ModelAttribute(value="user") AdUsersDomain adUser, CreatePortfolioForm formBean,BindingResult result, Locale locale, ModelMap model)
	{
		ModelMap map=new ModelMap();
		createPortfolioFormValidator.validate(formBean, result);
		if(result.hasErrors()==false)
		{
			logger.trace("CREATE PORTFOLIO=>"+formBean.toString());
			AddPortfolioRequest request=new AddPortfolioRequest();
			TrPortfolioDomain trPortfolioDomain=new TrPortfolioDomain();
			//setting data
			trPortfolioDomain.setUserId(adUser.getUserId());
			trPortfolioDomain.setName(formBean.getPortfolioName());
			trPortfolioDomain.setDescription(formBean.getPortfolioDescription());
			trPortfolioDomain.setCategoryLevel1Id(formBean.getDivision());
			trPortfolioDomain.setCategoryLevel2Id(formBean.getCategory());
			trPortfolioDomain.setSeasonYearId(formBean.getSeason());
			trPortfolioDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
			trPortfolioDomain.setLastupdateby(adUser.getUserId());
			trPortfolioDomain.setCreatedby(2);
			trPortfolioDomain.setLangCode(adUser.getLangCode());
			trPortfolioDomain.setSellable(ActiveStatusEnum.ACTIVE.value()); //04242014 Fred - Setup the portfolio as sellable.
			
			List<TrPortfolioImagesDomain> images = trPortfolioDomain.getPortfolioImages();
			//setup portfolio images
			for(int index=0;index<formBean.getPortfolio_image_id().length;index++)
			{
				if(formBean.getPortfolio_image_id()[index]!=null)
				{
					//check all images url are existed
					if(formBean.getFilename()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_ext()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_400()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_100()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_original()[index].replaceAll(" ", "").length()>0)
					{
						TrPortfolioImagesDomain item = new TrPortfolioImagesDomain(); 
						//setup the image url
						item.setFileName(formBean.getFilename_400()[index].replaceAll(" ", ""));
						item.setFileType(formBean.getFilename_ext()[index].replaceAll(" ", ""));
						item.setMainImageUrl(formBean.getFilename_original()[index].replaceAll(" ", ""));
						item.setSourceFileURL(formBean.getFilename()[index].replaceAll(" ", ""));
						item.setThumbnailUrl(formBean.getFilename_100()[index].replaceAll(" ", ""));
						item.setCreatedby(adUser.getUserId());
						item.setLastupdateby(adUser.getUserId());
						item.setActiveStatus(formBean.getActive_status()[index]);
						images.add(item);
					}
					else
					{
						map.addAttribute("hasError", true);
						map.addAttribute("errorCode", ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getCode());
						map.addAttribute("errorDescription", ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getDefaultMessage());
						return map;
					}
				}
			}
			
			request.setPortfolio(trPortfolioDomain);
			AddPortfolioResponse response=portfolioSDK.addPortfolio(request);
			logger.trace("ADD PORTFOLIO REPONSE=>"+response.getStatus().getStatuscode()+":"+response.getStatus().getDescription());
			
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				logger.trace("SUCCESS");
				map.addAttribute("portfolioId", response.getPortfolio().getPortfolioId());
				map.addAttribute("hasError", false);
				map.addAttribute("errorCode", response.getStatus().getStatuscode());
				map.addAttribute("errorDescription", response.getStatus().getDescription());
			}
			else
			{
				logger.trace("FAILED");
				map.addAttribute("hasError", true);
				map.addAttribute("errorCode", response.getStatus().getStatuscode());
				map.addAttribute("errorDescription", response.getStatus().getDescription());
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
	
	@RequestMapping(value=ViewPaths.CREATE_NEW_PORTFOLIO,method=RequestMethod.POST)
	public @ResponseBody ModelMap createPortfolioResult(@ModelAttribute(value="user") AdUsersDomain adUser, CreatePortfolioForm formBean,BindingResult result, Locale locale, ModelMap model)
	{
		ModelMap map=new ModelMap();
		createPortfolioFormValidator.validate(formBean, result);
		if(result.hasErrors()==false)
		{
			logger.trace("CREATE PORTFOLIO=>"+formBean.toString());
			AddPortfolioRequest request=new AddPortfolioRequest();
			TrPortfolioDomain trPortfolioDomain=new TrPortfolioDomain();
			//setting data
			trPortfolioDomain.setUserId(adUser.getUserId());
			trPortfolioDomain.setName(formBean.getPortfolioName());
			trPortfolioDomain.setDescription(formBean.getPortfolioDescription());
			trPortfolioDomain.setCategoryLevel1Id(formBean.getDivision());
			trPortfolioDomain.setCategoryLevel2Id(formBean.getCategory());
			trPortfolioDomain.setSeasonYearId(formBean.getSeason());
			trPortfolioDomain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
			trPortfolioDomain.setLastupdateby(adUser.getUserId());
			trPortfolioDomain.setCreatedby(2);
			trPortfolioDomain.setLangCode(adUser.getLangCode());
			trPortfolioDomain.setSellable(ActiveStatusEnum.INACTIVE.value()); //04242014 Fred - Setup the portfolio as unsellable.
			
			List<TrPortfolioImagesDomain> images = trPortfolioDomain.getPortfolioImages();
			//setup portfolio images
			for(int index=0;index<formBean.getPortfolio_image_id().length;index++)
			{
				if(formBean.getPortfolio_image_id()[index]!=null)
				{
					//check all images url are existed
					if(formBean.getFilename()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_ext()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_400()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_100()[index].replaceAll(" ", "").length()>0 
						&& formBean.getFilename_original()[index].replaceAll(" ", "").length()>0)
					{
						TrPortfolioImagesDomain item = new TrPortfolioImagesDomain(); 
						//setup the image url
						item.setFileName(formBean.getFilename_400()[index].replaceAll(" ", ""));
						item.setFileType(formBean.getFilename_ext()[index].replaceAll(" ", ""));
						item.setMainImageUrl(formBean.getFilename_original()[index].replaceAll(" ", ""));
						item.setSourceFileURL(formBean.getFilename()[index].replaceAll(" ", ""));
						item.setThumbnailUrl(formBean.getFilename_100()[index].replaceAll(" ", ""));
						item.setCreatedby(adUser.getUserId());
						item.setLastupdateby(adUser.getUserId());
						item.setActiveStatus(formBean.getActive_status()[index]);
						images.add(item);
					}
					else
					{
						map.addAttribute("hasError", true);
						map.addAttribute("errorCode", ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getCode());
						map.addAttribute("errorDescription", ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getDefaultMessage());
						return map;
					}
				}
			}
			
			request.setPortfolio(trPortfolioDomain);
			AddPortfolioResponse response=portfolioSDK.addPortfolio(request);
			logger.trace("ADD PORTFOLIO REPONSE=>"+response.getStatus().getStatuscode()+":"+response.getStatus().getDescription());
			
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				logger.trace("SUCCESS");
				map.addAttribute("hasError", false);
				map.addAttribute("errorCode", response.getStatus().getStatuscode());
				map.addAttribute("errorDescription", response.getStatus().getDescription());
			}
			else
			{
				logger.trace("FAILED");
				map.addAttribute("hasError", true);
				map.addAttribute("errorCode", response.getStatus().getStatuscode());
				map.addAttribute("errorDescription", response.getStatus().getDescription());
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
	
	@RequestMapping(value=ViewPaths.EDIT_COLLECTION,method=RequestMethod.POST)
	public @ResponseBody ModelMap editPortfolioResult(@ModelAttribute(value="user") AdUsersDomain adUser, CreatePortfolioForm formBean, ModelMap model)
	{
		ModelMap map=new ModelMap();
		
		logger.trace("EDIT PORTFOLIO=>"+formBean.toString());
		UpdatePortfolioRequest request=new UpdatePortfolioRequest();
		TrPortfolioDomain trPortfolioDomain=new TrPortfolioDomain();
		request.setPortfolio(trPortfolioDomain);
		//setting data
		trPortfolioDomain.setPortfolioId(formBean.getPortfolioId());
			
		List<TrPortfolioImagesDomain> images = trPortfolioDomain.getPortfolioImages();
		List<ObjectError> errors = new ArrayList<ObjectError>();
		//setup portfolio images
		for(int index=0;index<formBean.getPortfolio_image_id().length;index++)
		{
			if(formBean.getPortfolio_image_id()[index]!=null)
			{
				//check all images url are existed
				if(formBean.getFilename()[index].replaceAll(" ", "").length()>0 
					&& formBean.getFilename_ext()[index].replaceAll(" ", "").length()>0 
					&& formBean.getFilename_400()[index].replaceAll(" ", "").length()>0 
					&& formBean.getFilename_100()[index].replaceAll(" ", "").length()>0 
					&& formBean.getFilename_original()[index].replaceAll(" ", "").length()>0)
				{
					TrPortfolioImagesDomain item = new TrPortfolioImagesDomain(); 
					//setup the image url
					item.setPortfolioImageId(formBean.getPortfolio_image_id()[index]);
					item.setFileName(formBean.getFilename_400()[index].replaceAll(" ", ""));
					item.setFileType(formBean.getFilename_ext()[index].replaceAll(" ", ""));
					item.setMainImageUrl(formBean.getFilename_original()[index].replaceAll(" ", ""));
					item.setSourceFileURL(formBean.getFilename()[index].replaceAll(" ", ""));
					item.setThumbnailUrl(formBean.getFilename_100()[index].replaceAll(" ", ""));
					item.setCreatedby(adUser.getUserId());
					item.setLastupdateby(adUser.getUserId());
					item.setActiveStatus(formBean.getActive_status()[index]);
					images.add(item);
				}
				else
				{
					map.addAttribute("hasError", true);
					errors.add(new ObjectError(ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getCode(),ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getDefaultMessage()));
					map.addAttribute("errorCode", ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getCode());
					map.addAttribute("errorDescription", ErrorsCodeEnum.PORTFOLIO_IMAGES_SUBMIT_FAILED.getDefaultMessage());
					return map;
				}
			}
		}
		UpdatePortfolioResponse response=portfolioSDK.updatePortfolio(request);
		logger.trace("ADD PORTFOLIO REPONSE=>"+response.getStatus().getStatuscode()+":"+response.getStatus().getDescription());
		
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			logger.trace("SUCCESS");
			map.addAttribute("hasError", false);
			errors.add(new ObjectError(response.getStatus().getStatuscode(),response.getStatus().getDescription()));
			map.addAttribute("errorCode", response.getStatus().getStatuscode());
			map.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		else
		{
			logger.trace("FAILED");
			map.addAttribute("hasError", true);
			errors.add(new ObjectError(response.getStatus().getStatuscode(),response.getStatus().getDescription()));
			map.addAttribute("errorCode", response.getStatus().getStatuscode());
			map.addAttribute("errorDescription", response.getStatus().getDescription());
		}
		map.addAttribute("errors", errors);
		return map;
	}
	
	@RequestMapping(value=ViewPaths.DELETE_COLLECTION,method=RequestMethod.POST)
	public @ResponseBody ModelMap deletePortfolio(@ModelAttribute(value="user") AdUsersDomain adUser, DeleteItemsForm formBean , ModelMap map)
	{
		boolean hasError=false;
		logger.trace("DELETE PORTFOLIO FORMBEAN=>"+formBean.toString());
		for(Integer i=0;i<formBean.getSelectedItems().length;i++)
		{
			logger.trace("DELETE ID=>"+formBean.getSelectedItems()[i].intValue());		
			//I feel that alll boards have to be sent at one time so that the no of calls made are less
			DeletePortfolioByIdResponse deleteResponse = portfolioSDK.deletePortfolioById(formBean.getSelectedItems()[i].intValue());
			if(deleteResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
				hasError=false;
			else
				hasError=true;
		}
		ModelMap model=new ModelMap();
		if(hasError)
			model.addAttribute("hasError", true);
		else
			model.addAttribute("hasError", false);
		return model;
	}
	
	@RequestMapping(value=ViewPaths.DELETE_COLLECTION+"/{portfolioId}",method=RequestMethod.GET)
	public @ResponseBody ModelMap deletePortfolio(@PathVariable(value="portfolioId") Integer portfolioId)
	{
		ModelMap model=new ModelMap();
		
		DeletePortfolioByIdResponse deleteResponse = portfolioSDK.deletePortfolioById(portfolioId);
		
		if(deleteResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			model.addAttribute("hasError", false);
		else
		{
			model.addAttribute("hasError", true);
			model.addAttribute("errorCode", deleteResponse.getStatus().getStatuscode());
			model.addAttribute("errorDescription",deleteResponse.getStatus().getDescription());
		}

		return model;
	}
	
}
