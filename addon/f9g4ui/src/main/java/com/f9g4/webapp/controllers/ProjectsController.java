package com.f9g4.webapp.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StCategoryMasterDomain;
import com.f9g4.businessobjects.domain.StSeasonYearDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrPortfolioContestDomain;
import com.f9g4.businessobjects.services.AddBoardRequest;
import com.f9g4.businessobjects.services.AddBoardResponse;
import com.f9g4.businessobjects.services.CreateBoardImageRequest;
import com.f9g4.businessobjects.services.CreateBoardImageResponse;
import com.f9g4.businessobjects.services.GetAllContestsResponse;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.GetContestBoardsResponse;
import com.f9g4.businessobjects.services.GetContestByUserIdResponse;
import com.f9g4.businessobjects.services.GetContestDetailsResponse;
import com.f9g4.businessobjects.services.UpdateBoardRequest;
import com.f9g4.businessobjects.services.UpdateBoardResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.ContestStatusEnum;
import com.f9g4.common.util.ContestTypeEnum;
import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.PortfolioServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.utils.DomainToFormConverter;
import com.f9g4.web.utils.TimeConvertUtil;
import com.f9g4.web.utils.ViewAccess;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;
import com.f9g4.web.Helper.KeywordXmlHelper;
import com.f9g4.web.forms.ContestBean;
import com.f9g4.web.forms.CreateBoardForm;
import com.googlecode.ehcache.annotations.Cacheable;

@Controller
@SessionAttributes({"user", "userId","timezoneOffset"})
public class ProjectsController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectsController.class);
	
	@Autowired
	private PortfolioServiceSDK portfolioServiceSDK = new PortfolioServiceSDK();
	
	@Autowired
	private BoardServiceSDK boardServiceSDK = new BoardServiceSDK();
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK = new RegistrationServiceSDK();
	
	@Autowired @Value("${f9g4.webapp.boards.exp}")
	private int boardExpiratonDate;
	
	//Category
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
	
	
	//Division
	@Cacheable(cacheName="divisionList")
	@ModelAttribute("divisionList")
	public List<StCategoryMasterDomain> getCategoryList() 
	{
		return registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_1, 0).getStCategoryMasterDomain();
	}
	
	//Listener to load basic layout. Remember to add the new path here when create a new route in angularjs.
	//If the new route is not defined here, it will go back to index page when user hit referesh button.
	@RequestMapping(value = {ViewPaths.USER_PROJECTS,
			ViewPaths.USER_PROJECTS_VIEW_PROJECTS,
			ViewPaths.BUYER_PROJECTS_CREATE_PROJECT,
			ViewPaths.BUYER_PROJECTS_MANAGE_PROJECTS,
			ViewPaths.USER_PROJECTS_PORTFOLIO,
			ViewPaths.USER_PROJECTS_PORTFOLIO+"/{portfolioId}",
			ViewPaths.USER_PROJECTS_PORTFOLIO+"/{portfolioId}/{contestId}",
			ViewPaths.USER_PROJECTS_CREATIVE_VIEW_BRIEF+"/{portfolioId}/{contestId}",
			ViewPaths.USER_PROJECTS_CREATE_BOARD,
			ViewPaths.USER_PROJECTS_CREATE_BOARD+"/{portfolioId}",
			ViewPaths.USER_PROJECTS_CREATE_BOARD+"/{portfolioId}/{contestId}",
			ViewPaths.USER_PROJECTS_EDIT_BOARD,
			ViewPaths.USER_PROJECTS_EDIT_BOARD+"/{boardId}"}, method=RequestMethod.GET)
	public String showProjectsViewer(@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
			return ViewNames.BUYER_PROJECTS;
		else if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
			return ViewNames.DESIGNER_PROJECTS;
		else
			return ViewNames.BUYER_PROJECTS;
	}
	
	@RequestMapping(value = ViewPaths.BUYER_PROJECTS_CREATE_PROJECT_CONTENT, method=RequestMethod.GET)
	public String showBuyerCreateProjectViewer(@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		
		return ViewNames.BUYER_PROJECTS_CREATE_PROJECT;
	}
	
	@RequestMapping(value = ViewPaths.BUYER_PROJECTS_MANAGE_PROJECTS_CONTENT, method=RequestMethod.GET)
	public String showBuyerManageProjectsViewer(@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		
		return ViewNames.BUYER_PROJECTS_MANAGE_PROJECTS;
	}
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_VIEW_PROJECTS_CONTENT, method=RequestMethod.GET)
	public String showBuyerViewProjectsViewer(@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
			return ViewNames.BUYER_PROJECTS_VIEW_PROJECTS;
		else if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
			return ViewNames.DESIGNER_PROJECTS_VIEW_PROJECTS;
		else
			return ViewNames.BUYER_PROJECTS_VIEW_PROJECTS;
	}
	
	//retrieve contest data
	@RequestMapping(value = ViewPaths.USER_PROJECTS_VIEW_PROJECTS_DATA, method=RequestMethod.GET)
	public @ResponseBody ModelMap getUserProjectsData(@ModelAttribute(value="user") AdUsersDomain user,@ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM ,@ModelAttribute("timezoneOffset") Integer timezoneOffset, ModelMap model)
	{
		ModelMap map = new ModelMap();
		//call service to get projects
		GetContestByUserIdResponse response = portfolioServiceSDK.getContestByUserId(user.getUserId());
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			map.addAttribute("hasError", false);
			//convert to bean array
			List<ContestBean> beans = new ArrayList<ContestBean>();
			for(TrPortfolioContestDomain item : response.getContest())
			{
				//filter out the record if projectStatus is in PENDING or DELETED
				if(item.getProjectStatus()!=ContestStatusEnum.STATUS_PENDING.getId())
				{
					ContestBean bean = new ContestBean();
					bean.setOriginalData(item);
					Date startDate = TimeConvertUtil.convertXMLDateToLocalTime(item.getStartDate(), timezoneOffset);
					Date endDate = TimeConvertUtil.convertXMLDateToLocalTime(item.getEndDate(), timezoneOffset);
					bean.setStartDate(startDate); //convert to local time
					bean.setEndDate(endDate); //convert to local time
					bean.setSeasonYear(seasonYearHM.get(item.getContestPortfolioDomain().getSeasonYearId()));
					beans.add(bean);
				}
			}
			map.addAttribute("contests", beans);
		}
		else
		{
			map.addAttribute("hasError", true);
			map.addAttribute("error", response.getStatus().getStatuscode());
		}
		
		return map;
	}
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_PORTFOLIO_CONTENT, method=RequestMethod.GET)
	public String showDesignerViewProjectsViewer(@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		
		return ViewNames.USER_PROJECTS_PORTFOLIO;
	}

	@RequestMapping(value = ViewPaths.USER_PROJECTS_CREATIVE_VIEW_BRIEF_CONTENT, method=RequestMethod.GET)
	public String showDesignerCreativeBrief(@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		
		return ViewNames.USER_CREATIVE_BRIEF;
	}
	
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_CREATIVE_VIEW_BRIEF_DATA, method=RequestMethod.GET)
	public @ResponseBody ModelMap getCreativeBriefView(@RequestParam(value="portfolioId", required=false, defaultValue="-1") Integer portfolioId, @RequestParam(value="contestId", required=false, defaultValue="-1") Integer contestId, @ModelAttribute(value="user") AdUsersDomain user, @ModelAttribute(value="timezoneOffset") Integer timezoneOffset, @ModelAttribute("seasonYearMap") HashMap<Integer, StSeasonYearDomain> seasonYearHM, ModelMap model)
	{
		ModelMap map = new ModelMap();
		//Boolean hasError=false;		
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
			map.addAttribute("targetContest", bean);
			map.addAttribute("hasError", false);

		} else {
			//hasError=true;
			map.addAttribute("hasError", true);

		}
		return map;
	}
	

	@RequestMapping(value = ViewPaths.USER_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL, method=RequestMethod.GET)
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
		return ViewNames.USER_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL;
	}
		
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_BOARDS_CONTENT, method=RequestMethod.GET)
	public String showSubmissionsViewer(@RequestParam(value="portfolioId", required=false, defaultValue="-1") Integer portfolioId, @RequestParam(value="contestId", required=false, defaultValue="-1") Integer contestId, @ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ViewAccess viewAccess=new ViewAccess();
		//Get project information
		if(portfolioId != -1 && contestId != -1)
		{
			GetContestDetailsResponse response = portfolioServiceSDK.getContestDetails(portfolioId, contestId);
			if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
			{
				//If project is still running and not pass due
				Calendar today=Calendar.getInstance();
				Calendar dueDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(response.getContest().getEndDate());
				String contestStatus="UNKNOWN";
				for(ContestStatusEnum item : ContestStatusEnum.values())
				{
					if(response.getContest().getProjectStatus()==item.getId())
						contestStatus=item.getCode().toLowerCase();
				}
				//if the status is running but pass due date, show pass due status
				if(response.getContest().getProjectStatus()==ContestStatusEnum.STATUS_RUNNING.getId() && today.after(dueDate))
					contestStatus="pass due";
				model.addAttribute("contestStatus", contestStatus);
				if(response.getContest().getProjectStatus()==ContestStatusEnum.STATUS_RUNNING.getId() && today.before(dueDate))
					model.addAttribute("allowNewSubmission", true);
				else
					model.addAttribute("allowNewSubmission", false);
			}
			else
			{
				//disable New Submissions button
				model.addAttribute("allowNewSubmission", false);
			}
		}
		//assign access for each section in boards viewer
		if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
		{
			viewAccess.assignBoardViewerAccess(model,true,false,true,true,true,true,false,false,false);
			return ViewNames.DESIGNER_PROJECTS_BOARDS_VIEWER;
		}
		else if(user.getUserType().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode()))
		{
			viewAccess.assignBoardViewerAccess(model,false,false,true,false,true,false,false,false,false);
			return ViewNames.BUYER_PROJECTS_BOARDS_VIEWER;
		}
		else
		{
			viewAccess.assignBoardViewerAccess(model,true,false,true,true,true,true,false,false,false);
			return ViewNames.DESIGNER_PROJECTS_BOARDS_VIEWER;
		}
	}
	
	@RequestMapping(value = {ViewPaths.USER_PROJECTS_BOARDS_DATA,ViewPaths.USER_PROJECTS_BOARDS}, method=RequestMethod.GET)
	public @ResponseBody ModelMap getContestBoards(@RequestParam(value="portfolioId") Integer portfolioId, @ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		Boolean hasError=false;
		GetContestBoardsResponse response = boardServiceSDK.getContestBoards(portfolioId, user.getUserId());
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			//Add to the collection only if the active board(active_status == 0)
			List<TrBoardDomain> boards=new ArrayList<TrBoardDomain>();
			for(TrBoardDomain item: response.getBoards())
			{
				if(item.getActiveStatus()==ActiveStatusEnum.ACTIVE.value())
					boards.add(item);
			}
			map.addAttribute("boards", boards);
		}
		else
			hasError=true;
		map.addAttribute("hasError", hasError);
		return map;
	}
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_CREATE_BOARD_CONTENT, method=RequestMethod.GET)
	public String showCreateBoardEditor(@ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		return ViewNames.USER_PROJECTS_CREATE_BOARD;
	}
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_CREATE_BOARD_CONTENT+"/{portfolioId}/{contestId}", method=RequestMethod.GET)
	public String showCreateBoardEditorWithPortfolioId(@PathVariable(value="portfolioId") Integer portfolioId,@PathVariable(value="contestId") Integer contestId, @ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		model.addAttribute("portfolioId", portfolioId);
		model.addAttribute("contestId", contestId);
		return ViewNames.USER_PROJECTS_CREATE_BOARD;
	}
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_EDIT_BOARD_CONTENT+"/{boardId}", method=RequestMethod.GET)
	public String showEditBoardEditorWithPortfolioId(@PathVariable(value="boardId") Integer boardId, @ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		model.addAttribute("boardId", boardId);
		return ViewNames.USER_PROJECTS_CREATE_BOARD;
	}
	
	@RequestMapping(value = ViewPaths.USER_PROJECTS_SAVE_BOARD, method=RequestMethod.POST)
	public @ResponseBody ModelMap manageProjectBoard(CreateBoardForm form, @ModelAttribute(value="user") AdUsersDomain user, ModelMap model)
	{
		ModelMap map = new ModelMap();
		Boolean hasError=false;
		//retirve contest information
		GetContestByUserIdResponse response = portfolioServiceSDK.getContestByUserId(user.getUserId());
		//get the portfolio
		TrPortfolioContestDomain contestDomain=null;
		if(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
		{
			for(TrPortfolioContestDomain item: response.getContest())
			{
				if(item.getContestPortfolioDomain().getPortfolioId() == form.getPortfolioId())
					contestDomain=item;
			}
			//prepare data
			if(contestDomain!=null)
			{
				if(form.getBoardId()==null)
				{
					//add board service call
					AddBoardRequest addBoardrequest =new AddBoardRequest();
					TrBoardDomain boardDomain=new TrBoardDomain();
					addBoardrequest.setBoard(boardDomain);
					setBoardDomain(form, user, contestDomain, boardDomain);
					AddBoardResponse addBoardResponse = boardServiceSDK.addBoards(addBoardrequest);
					if(addBoardResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
					{
						//add board image service call
						CreateBoardImageRequest imageRequest=new CreateBoardImageRequest();
						TrBoardImagesDomain imageDomain=new TrBoardImagesDomain();
						imageDomain.setBoardId(addBoardResponse.getBoard().getBoardId());
						imageDomain.setFileName(form.getBoardImageUrl_file());
						imageDomain.setCreatedby(user.getUserId());
						imageDomain.setLastupdateby(user.getUserId());
						imageDomain.setFileType(form.getBoardImageType());
						imageDomain.setMainImageUrl(form.getBoardImageUrl_main());
						imageDomain.setSourceFileURL(form.getBoardImageUrl());
						imageDomain.setThumbnailUrl(form.getBoardImageUrl_thumb());
						imageRequest.setTrBoardImagesDomain(imageDomain);
						CreateBoardImageResponse imageResponse = boardServiceSDK.createBoardImage(imageRequest);
						if(imageResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
						{
							hasError=false;
							addBoardResponse.getBoard().getBoardImages().add(imageDomain);
							map.addAttribute("board", addBoardResponse.getBoard());
						}
						else
							hasError=true;
					}
					else
						hasError=true;
				}
				else
				{
					//update board service call
					//get the board original data from database.
					GetBoardByIdResponse boardResponse=boardServiceSDK.getBoardbyId(form.getBoardId());
					if(boardResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
					{
						UpdateBoardRequest updateBoardRequest=new UpdateBoardRequest();
						TrBoardDomain boardDomain=boardResponse.getBoard();
						updateBoardRequest.setBoard(boardDomain);
						setBoardDomain(form, user, contestDomain, boardDomain);
						//update images
						TrBoardImagesDomain imageDomain=boardDomain.getBoardImages().get(0);
						imageDomain.setFileName(form.getBoardImageUrl_file());
						imageDomain.setCreatedby(user.getUserId());
						imageDomain.setLastupdateby(user.getUserId());
						imageDomain.setFileType(form.getBoardImageType());
						imageDomain.setMainImageUrl(form.getBoardImageUrl_main());
						imageDomain.setSourceFileURL(form.getBoardImageUrl());
						imageDomain.setThumbnailUrl(form.getBoardImageUrl_thumb());
						UpdateBoardResponse updateBoardResponse = boardServiceSDK.updateBoard(updateBoardRequest);
						if(updateBoardResponse.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()))
						{
							hasError=false;
							map.addAttribute("board", updateBoardResponse.getBoard());
						}
						else
							hasError=true;
					}
					else
						hasError=true;
				}
			}
			else
				hasError=true;
		}
		else
		{
			hasError=false;
		}
		map.addAttribute("hasError", hasError);
		return map;
	}
	
	private void setBoardDomain(CreateBoardForm form, AdUsersDomain user, TrPortfolioContestDomain contest, TrBoardDomain domain)
	{
		domain.setName(form.getBoardName());
		domain.setDescription(form.getBoardDescription());
		domain.setPortfolioId(form.getPortfolioId());
		domain.setSaleTypeId(441); //TODO remove hardcoded
		domain.setOriginalUserId(user.getUserId());
		domain.setCurrentUerId(user.getUserId());
		domain.setBoardPrice(new BigDecimal(3)); //TODO remove hardcoded
		domain.setTotalPrice(new BigDecimal(3)); //TODO remove hardcoded
		try
		{
			domain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
			Calendar day=Calendar.getInstance();
			day.add(Calendar.DAY_OF_MONTH, +this.boardExpiratonDate); //Set expiration date from property file.
			domain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(day));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		domain.setPublishToMP(form.getPublishToMp());
		domain.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
		//setup each sub-keyword
		/*
		if(form.getSubKeywords_1()==null)
			form.setSubKeywords_1("");
		if(form.getSubKeywords_2()==null)
			form.setSubKeywords_2("");
		if(form.getSubKeywords_3()==null)
			form.setSubKeywords_3("");
		if(form.getSubKeywords_4()==null)
			form.setSubKeywords_4("");
		*/
		//String keyword = KeywordXmlHelper.assignSubkeywords(contest.getCategory(), StringEscapeUtils.escapeXml(form.getSubKeywords_1()), StringEscapeUtils.escapeXml(form.getSubKeywords_2()), StringEscapeUtils.escapeXml(form.getSubKeywords_3()), StringEscapeUtils.escapeXml(form.getSubKeywords_4()));
		domain.setKeyword(contest.getCategory()); //set keyword from pre-defined value in contest domain and populate the user's subkeywords
		domain.setStatusId(LookupTypeValueEnum.BOARD_SALE_STATUS_AVAILABLE.getTypeId());
		domain.setCreatedby(user.getUserId());
		domain.setLastupdateby(user.getUserId());
		domain.setLangCode(user.getLangCode());
	}
}
