package com.f9g4.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.StCategoryDenormDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.domain.TrBoardSearchDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.domain.TrPortfolioImagesDomain;
import com.f9g4.businessobjects.services.AddBoardApprovalRequest;
import com.f9g4.businessobjects.services.AddBoardApprovalResponse;
import com.f9g4.businessobjects.services.AddBoardRequest;
import com.f9g4.businessobjects.services.AddBoardResponse;
import com.f9g4.businessobjects.services.BoardSet;
import com.f9g4.businessobjects.services.BoardsViewed;
import com.f9g4.businessobjects.services.CreateBoardImageRequest;
import com.f9g4.businessobjects.services.CreateBoardImageResponse;
import com.f9g4.businessobjects.services.DeleteBoardByIdResponse;
import com.f9g4.businessobjects.services.DrawerInfoResponse;
import com.f9g4.businessobjects.services.GetAllSamplesResponse;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.GetBoardsByPMRequest;
import com.f9g4.businessobjects.services.GetBoardsByPMResponse;
import com.f9g4.businessobjects.services.GetBoardsByPortfolioResponse;
import com.f9g4.businessobjects.services.GetBoardsSuggestionRequest;
import com.f9g4.businessobjects.services.GetBoardsSuggestionResponse;
import com.f9g4.businessobjects.services.GetContestBoardsResponse;
import com.f9g4.businessobjects.services.GetRecentlyViewedBoardsResponse;
import com.f9g4.businessobjects.services.GetSamplesByUserIdRequest;
import com.f9g4.businessobjects.services.GetSamplesByUserIdResponse;
import com.f9g4.businessobjects.services.ResubmitSamplesRequest;
import com.f9g4.businessobjects.services.ResubmitSamplesResponse;
import com.f9g4.businessobjects.services.ReturnSubmissionsRequest;
import com.f9g4.businessobjects.services.ReturnSubmissionsResponse;
import com.f9g4.businessobjects.services.SearchBoardsRequest;
import com.f9g4.businessobjects.services.SearchBoardsResponse;
import com.f9g4.businessobjects.services.SearchExampleBoardsRequest;
import com.f9g4.businessobjects.services.SearchExampleBoardsResponse;
import com.f9g4.businessobjects.services.Stats;
import com.f9g4.businessobjects.services.SubmitSamplesRequest;
import com.f9g4.businessobjects.services.SubmitSamplesResponse;
import com.f9g4.businessobjects.services.TrActivityDomain;
import com.f9g4.businessobjects.services.UpdateBoardByAdminRequest;
import com.f9g4.businessobjects.services.UpdateBoardByAdminResponse;
import com.f9g4.businessobjects.services.UpdateBoardRequest;
import com.f9g4.businessobjects.services.UpdateBoardResponse;
import com.f9g4.businessobjects.services.UpdateBoardStatusRequest;
import com.f9g4.businessobjects.services.UpdateBoardStatusResponse;
import com.f9g4.businessobjects.services.UpdatePublishBoardStatusRequest;
import com.f9g4.businessobjects.services.UpdatePublishBoardStatusResponse;
import com.f9g4.businessobjects.services.ValidateBoardsRequest;
import com.f9g4.businessobjects.services.ValidateBoardsResponse;
import com.f9g4.businessobjects.services.YourMessages;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.DateConverter;
import com.f9g4.common.util.LanguageCodesEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.MessageTypes;
import com.f9g4.common.util.ProjectFormatter;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.dao.AdEmailTemplatesDAO;
import com.f9g4.dao.AdLookupValuesDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.StCategoryMasterDAO;
import com.f9g4.dao.TrBoardApprovalDAO;
import com.f9g4.dao.TrBoardDAO;
import com.f9g4.dao.TrBoardImagesDAO;
import com.f9g4.dao.TrMessagesDAO;
import com.f9g4.dao.TrNotificationsQDAO;
import com.f9g4.dao.TrPortfolioContestDAO;
import com.f9g4.dao.TrPortfolioDAO;
import com.f9g4.dao.TrRecentlyViewedDAO;
import com.f9g4.domain.AdEmailTemplates;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUserMemberships;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.StCategoryMaster;
import com.f9g4.domain.StSeasonYear;
import com.f9g4.domain.TrActivityScreenCompanyGrid;
import com.f9g4.domain.TrActivityScreenDesignerGrid;
import com.f9g4.domain.TrActivityScreenGraph;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrBoardApproval;
import com.f9g4.domain.TrBoardImages;
import com.f9g4.domain.TrBoardSearch;
import com.f9g4.domain.TrMessages;
import com.f9g4.domain.TrNotificationsQ;
import com.f9g4.domain.TrPortfolio;
import com.f9g4.domain.TrPortfolioContest;
import com.f9g4.domain.TrPortfolioImages;
import com.f9g4.domain.TrSalesTransactionDetails;
import com.f9g4.services.rest.IBoardService;
import com.f9g4.util.DateUtil;
import com.f9g4.util.ModelConverter;

@Service("boardService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
public class BoardServiceImpl implements IBoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private TrBoardDAO trBoardDAO;

	@Autowired
	private TrPortfolioDAO trPortfolioDao;

	@Autowired
	private StCategoryMasterDAO stCategoryDao;

	@Autowired
	private TrMessagesDAO trMessagesDAO;

	@Autowired
	private TrBoardImagesDAO trBoardImagesDAO; 
	
	@Autowired
	private TrRecentlyViewedDAO trRecentlyViewedDAO;
	
	@Autowired
	private ModelConverter modelConverter;
	
	@Autowired
	private AdUsersDAO adUsersDAO;
	
	@Autowired
	private TrBoardApprovalDAO trBoardApprovalDAO;
	
	@Autowired
	private AdEmailTemplatesDAO adEmailTemplatesDAO;
	
	@Autowired
	private TrNotificationsQDAO trNotificationsQDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;
	
	@Autowired
	private TrPortfolioContestDAO trPortfolioContestDAO;
	
	@Autowired @Value("${f9g4.service.administrator}")
	private String adminUserIdChain;
	
	@Autowired @Value("${f9g4.service.email}")
	private String adminMailAddress;
	
	@Autowired @Value("${f9g4.service.search.maxresults}")
	private Integer searchMaxResults;
	
	public AddBoardResponse addBoards(AddBoardRequest request) {
		AddBoardResponse response = new AddBoardResponse();
		Status status = new Status();
		if (null == request || request.getBoard() == null) {
			status.setStatuscode(StatusCodesEnum.STATUS_BRD_INVALID_INPUT.getCode());
//			status.setDescription();
		} else {

			try {
				TrBoard board = trBoardDAO.merge(this.convertDomaintoEntity(request.getBoard()));
				//trBoardDAO.flush(); - we dont have to do this. at the end of transaction hibernate will flush.
				response.setBoard(this.convertEntityToDomain(board));
				status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Throwable e) {
				logger.error("Exception Occurred", e);
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				status.setDescription("Error occured");
			}
		}
		response.setStatus(status);
		return response;
	}

	//update board -C
	public UpdateBoardResponse updateBoard(UpdateBoardRequest request)
	{
		UpdateBoardResponse response=new UpdateBoardResponse();
		Status status=new Status();
		
		try
		{
			TrBoardDomain board=request.getBoard();
			//System.out.println("ID=>"+board.getBoardId());
			TrBoard boardEntity=trBoardDAO.findTrBoardByBoardId(board.getBoardId());
			Integer oldMP = boardEntity.getPublishToMp();
			
			boardEntity.setName(board.getName());
			boardEntity.setBoardPrice(board.getBoardPrice());
			boardEntity.setTotalPrice(board.getTotalPrice());
			boardEntity.setDescription(board.getDescription());
			boardEntity.setKeyword(board.getKeyword());
			boardEntity.setPublishToMp(board.getPublishToMP());
			boardEntity.setEffectiveDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(board.getEffectiveDate()));
			boardEntity.setExpirationDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(board.getExperiationDate()));
			boardEntity.setActiveStatus(board.getActiveStatus());
			boardEntity.setLastUpdatedBy(board.getLastupdateby());
			
			//set portfolio id
			TrPortfolio portfolio=new TrPortfolio();
			portfolio.setPortfolioId(board.getPortfolioId());
			boardEntity.setTrPortfolio(portfolio);
			//set category
			StCategoryMaster level3Id=new StCategoryMaster();
			StCategoryMaster level4Id=new StCategoryMaster();
			level3Id.setCategoryId(board.getCategoryLevel3Id());
			boardEntity.setStCategoryMasterByCatLevel3Id(null); //set to null
			level4Id.setCategoryId(board.getCategoryLevel4Id());
			boardEntity.setStCategoryMasterByCatLevel4Id(null); //Set to null
			//set saletype
			AdLookupValues saletype=new AdLookupValues();
			saletype.setLookupValueId(board.getSaleTypeId());
			boardEntity.setAdLookupValues(saletype);
			
			AdLookupValues adLookupValuesStatusId = new AdLookupValues();
			adLookupValuesStatusId.setLookupValueId(board.getStatusId());
			boardEntity.setAdLookupValuesStatusId(adLookupValuesStatusId);
			
			//update images
			Set<TrBoardImages> imageSet = boardEntity.getTrBoardImageses();
			Iterator<TrBoardImages> boardImageIterator=imageSet.iterator();
			TrBoardImages images=boardImageIterator.next();
			//TrBoardImages images = new TrBoardImages();
			//TrBoard trBoard=new TrBoard();
			List<TrBoardImagesDomain> imagesDomain=board.getBoardImages();
			for(TrBoardImagesDomain item: imagesDomain)
			{
				//trBoard.setBoardId(board.getBoardId());
				//images.setTrBoard(trBoard);
				images.setFileName(item.getFileName());
				images.setFileType(item.getFileType());
				images.setMainImageUrl(item.getMainImageUrl());
				images.setSourceFileUrl(item.getSourceFileURL());
				images.setThumbnailUrl(item.getThumbnailUrl());
				images.setCreatedBy(item.getCreatedby()); // add the createdby -C
				images.setLastUpatedBy(item.getLastupdateby()); //set lastupdateby -C
				//images.setCreationDate(Calendar.getInstance()); //set creation date -C
				//images.setLastUpdateDate(Calendar.getInstance()); // -C
				imageSet.add(images);
			}
			boardEntity.setTrBoardImageses(imageSet);
			
			TrBoard newEntity=trBoardDAO.merge(boardEntity);
			trBoardDAO.flush(); //run the query immediately
			trBoardDAO.refresh(newEntity); //refresh the object to get the updated entity
			TrBoardDomain newDomain=convertEntityToDomain(newEntity);
			
			response.setBoard(newDomain);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			//send the email to support team if the old MP and new MP status = 1
			if(oldMP==Constants.PUBLISH_TO_MARKET_YES && board.getPublishToMP()==Constants.PUBLISH_TO_MARKET_YES)
			{
				//get the email templates
				AdEmailTemplates emailTemp = adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.DESIGNER_UPDATED_PUBLISHED_BOARD);
				//replace the variables
				String mailSubject;
				String mailBody;
				mailSubject = emailTemp.getSubject().replace("$$3", boardEntity.getName());
				mailBody = emailTemp.getBody().replace("$$3", boardEntity.getName());
				mailBody = mailBody.replace("$$2", boardEntity.getAdUsersByOriginalUserId().getFirstname()+" "+boardEntity.getAdUsersByOriginalUserId().getLastname());
				mailBody = mailBody.replace("$$1", boardEntity.getAdUsersByOriginalUserId().getUserName());
				//insert record
				TrNotificationsQ trNotificationsQ=new TrNotificationsQ();
				trNotificationsQ.setFromUserId(2); //system user
				trNotificationsQ.setToUserId(2); //system user
				trNotificationsQ.setFromEmail(this.adminMailAddress);
				trNotificationsQ.setToEmail(emailTemp.getSupportEmail());
				trNotificationsQ.setSubject(mailSubject);
				trNotificationsQ.setBodyText(mailBody);
				trNotificationsQ.setCreatedBy(2); //system user
				trNotificationsQ.setLastUpdatedBy(2); //system user
				//set email status to ready to send
				AdLookupValues readyToSend=adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.EMAIL_STATUS_READY_TO_SEND.getTypeCode());
				trNotificationsQ.setAdLookupValues(readyToSend);
				//insert record to tr_notifications-q table
				trNotificationsQDAO.merge(trNotificationsQ);
			}
		}
		catch(Throwable th)
		{
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		//set the status
		response.setStatus(status);
		return response;
	}
	
	//update board by admin -C
	public UpdateBoardByAdminResponse updateBoardByAdmin(UpdateBoardByAdminRequest request)
	{
		boolean hasInconsistentData=false;
		UpdateBoardByAdminResponse response=new UpdateBoardByAdminResponse();
		Status status=new Status();
		response.setStatus(status);
		
		//Check the data consistency
		TrBoardDomain oldBoard=request.getOldBoard();
		TrBoard boardEntity=trBoardDAO.findTrBoardByBoardId(oldBoard.getBoardId());
		if(!oldBoard.getKeyword().equals(boardEntity.getKeyword()) || !oldBoard.getTotalPrice().equals(boardEntity.getTotalPrice()))
			hasInconsistentData=true;
		
		if(!hasInconsistentData)
		{
			try
			{
				TrBoardDomain board=request.getNewBoard();
				if(board.getBoardPrice()==null || board.getTotalPrice()==null || board.getKeyword()==null)
				{
					status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				}
				else
				{
					boardEntity.setBoardPrice(board.getBoardPrice());
					boardEntity.setTotalPrice(board.getTotalPrice());
					boardEntity.setKeyword(board.getKeyword());
					//boardEntity.setPublishToMp(board.getPublishToMP());
					boardEntity.setLastUpdatedBy(board.getLastupdateby());
					
					//set category (Move to keywords)
					/*StCategoryMaster level3Id=new StCategoryMaster();
					level3Id.setCategoryId(board.getCategoryLevel3Id());
					boardEntity.setStCategoryMasterByCatLevel3Id(level3Id);*/
										
					TrBoard newEntity=trBoardDAO.merge(boardEntity);
					trBoardDAO.flush(); //run the query immediately
					trBoardDAO.refresh(newEntity); //refresh the object to get the updated entity
					TrBoardDomain newDomain=convertEntityToDomain(newEntity);
						
					response.setBoard(newDomain);
					status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
					//send email to the user
					AdEmailTemplates emailTemp = adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.ADMIN_UPDATED_BOARD);
					//replace the variables from emailTemp
					String mailSubject;
					String mailBody;
					mailSubject=emailTemp.getSubject().replace("$$3", boardEntity.getName());
					mailBody=emailTemp.getBody().replace("$$3", boardEntity.getName());
					mailBody=mailBody.replace("$$2", boardEntity.getAdUsersByOriginalUserId().getFirstname()+" "+boardEntity.getAdUsersByOriginalUserId().getLastname());
					//insert record to Tr_notification_q table.
					TrNotificationsQ trNotificationsQ=new TrNotificationsQ();
					trNotificationsQ.setFromUserId(2); //system user
					trNotificationsQ.setToUserId(boardEntity.getAdUsersByOriginalUserId().getUserId());
					trNotificationsQ.setFromEmail(this.adminMailAddress);
					trNotificationsQ.setToEmail(boardEntity.getAdUsersByOriginalUserId().getUserName());
					trNotificationsQ.setSubject(mailSubject);
					trNotificationsQ.setBodyText(mailBody);
					trNotificationsQ.setCreatedBy(2); //system user
					trNotificationsQ.setLastUpdatedBy(2); //system user
					//set email status to ready to send
					AdLookupValues readyToSend=adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.EMAIL_STATUS_READY_TO_SEND.getTypeCode());
					trNotificationsQ.setAdLookupValues(readyToSend);
					//insert record to tr_notifications-q table
					trNotificationsQDAO.merge(trNotificationsQ);
				}
			}
			catch(Throwable th)
			{
				logger.error("Exception Occurred", th);
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			}
		}
		else
		{
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public GetBoardByIdResponse getBoardbyId(int boardid) {
		GetBoardByIdResponse response = new GetBoardByIdResponse();
		Status responseStatus = new Status();
		if (boardid <= 0) {
			responseStatus.setStatuscode("32001");
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				TrBoard board = trBoardDAO.findTrBoardByBoardId(boardid);
//				trBoardDAO.flush();
				response.setBoard(this.convertEntityToDomain(board));
				responseStatus.setStatuscode("0");
			} catch (Exception e) {
				responseStatus.setStatuscode("32002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}

		response.setStatus(responseStatus);
		return response;
	}

	public GetContestBoardsResponse getContestBoards(int portfolioid, int userid){
		GetContestBoardsResponse response = new GetContestBoardsResponse();
		Status responseStatus = new Status();
		AdUsers user = adUsersDAO.findAdUsersByUserId(userid);
		
		if ( user.getAdLookupValuesByUserTypeId().getLookupCode().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) ){
			if (portfolioid <= 0 || userid <=0 ) 
			{
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_BRD_INVALID_INPUT.getCode());
				responseStatus.setDescription("Valid ID required");
	
			} else {
				try {
					Set<TrBoard> boards = trBoardDAO.findTrBoardByPortfolioIdforUser(portfolioid, userid);
					for (TrBoard trBoard : boards) {
						response.getBoards().add(this.convertEntityToDomain(trBoard));
					}
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
				} catch (Exception e) {
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
					responseStatus.setDescription("Unknown Error Occured");
				}
			}
		
		} else if ( user.getAdLookupValuesByUserTypeId().getLookupCode().equals(LookupTypeValueEnum.USER_TYPE_CUSTOMER.getTypeCode())) {	
			if (portfolioid <= 0) 
			{
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_BRD_INVALID_INPUT.getCode());
				responseStatus.setDescription("Valid ID required");
	
			} else {
				
				try {
					
					TrPortfolio portfolio = trPortfolioDao.findTrPortfolioByPortfolioId(portfolioid);
					
					if ( portfolio.getAdUsers().getUserId() == userid) {
						Set<TrBoard> boards = trBoardDAO.findTrBoardByPortfolioIdforBuyer(portfolioid);
						for (TrBoard trBoard : boards) {
							response.getBoards().add(this.convertEntityToDomain(trBoard));
						}
						responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
						
					} else {
						responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
						responseStatus.setDescription("Unauthorized buyer");
						
					}
						
						

				} catch (Exception e) {
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
					responseStatus.setDescription("Unknown Error Occured");
				}
			}
		}
		response.setStatus(responseStatus);
		return response;
		
	}
	
	public GetBoardsByPortfolioResponse getBoardsbyPortfolioId(int portfolioid) {
		GetBoardsByPortfolioResponse response = new GetBoardsByPortfolioResponse();
		Status responseStatus = new Status();
		if (portfolioid <= 0) 
		{
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_BRD_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				Set<TrBoard> boards = trBoardDAO.findTrBoardByPortfolioId(portfolioid);
				for (TrBoard trBoard : boards) {
					response.getBoards().add(this.convertEntityToDomain(trBoard));
				}
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Exception e) {
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.f9g4.services.rest.IBoardService#deleteBoardById(int) Method #4
	 * - Code start with 34XXX
	 */

	public DeleteBoardByIdResponse deleteBoardById(int boardid) {
		DeleteBoardByIdResponse response = new DeleteBoardByIdResponse();
		Status responseStatus = new Status();
		if (boardid <= 0) {
			responseStatus.setStatuscode("34001");
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				TrBoard board = trBoardDAO.findTrBoardByBoardId(boardid);
				board.setActiveStatus(0);
				board.setPublishToMp(0);
				trBoardDAO.merge(board);
				responseStatus.setStatuscode("0");
			} catch (Exception e) {
				responseStatus.setStatuscode("34002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}

	private TrBoard convertDomaintoEntity(TrBoardDomain domain) {
		TrBoard board = new TrBoard();
		board.setActiveStatus(domain.getActiveStatus());
		board.setName(domain.getName());
		board.setBoardId(domain.getBoardId());
		board.setDescription(domain.getDescription());
		board.setBoardPrice(domain.getBoardPrice());
		board.setExpirationDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(
					domain.getExperiationDate()));

		board.setEffectiveDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(
				domain.getEffectiveDate()));

		/*} catch (DatatypeConfigurationException e) {
			// TODO Do we need to default or throw error?
			board.setExpirationDate(Calendar.getInstance());
		}
		 */
		board.setKeyword(domain.getKeyword());
		board.setLangCode(domain.getLangCode());
		board.setPublishToMp(domain.getPublishToMP());
		board.setTotalPrice(domain.getTotalPrice());
		TrPortfolio portfolio = trPortfolioDao.findTrPortfolioByPortfolioId(domain.getPortfolioId());
		board.setTrPortfolio(portfolio);
		if(domain.getCurrentUerId()!=0)
		{
			AdUsers currentUser=new AdUsers();
			currentUser.setUserId(domain.getCurrentUerId());
			board.setAdUsersByCurrentUserId(currentUser);
		}
		else
			board.setAdUsersByCurrentUserId(portfolio.getAdUsers());
		if(domain.getOriginalUserId()!=0)
		{
			AdUsers originalUser=new AdUsers();
			originalUser.setUserId(domain.getOriginalUserId());
			board.setAdUsersByOriginalUserId(originalUser);
		}
		else
			board.setAdUsersByOriginalUserId(portfolio.getAdUsers());
		board.setCreatedBy(domain.getCreatedby());
		board.setLastUpdatedBy(domain.getLastupdateby());
		board.setCreationDate(Calendar.getInstance());
		board.setLastUpdateDate(Calendar.getInstance());
		//
		AdLookupValues value=new AdLookupValues();
		value.setLookupValueId(domain.getSaleTypeId());
		board.setAdLookupValues(value);
		
		AdLookupValues adLookupValuesStatusId=new AdLookupValues();
		adLookupValuesStatusId.setLookupValueId(domain.getStatusId());
		board.setAdLookupValuesStatusId(adLookupValuesStatusId);
		//
		
		board.setStCategoryMasterByCatLevel3Id(stCategoryDao
				.findStCategoryMasterByCategoryId(domain.getCategoryLevel3Id()));
		board.setStCategoryMasterByCatLevel4Id(stCategoryDao
				.findStCategoryMasterByCategoryId(domain.getCategoryLevel4Id()));
		board.setStCategoryMasterByCatLevel5Id(stCategoryDao
				.findStCategoryMasterByCategoryId(domain.getCategoryLevel5Id()));
		
		Set<TrBoardImages> imageSet = new HashSet<TrBoardImages>();
		for (TrBoardImagesDomain imagesdomain : domain.getBoardImages()) 
		{
			TrBoardImages images = new TrBoardImages();
			images.setFileName(imagesdomain.getFileName());
			images.setFileType(imagesdomain.getFileType());
			images.setMainImageUrl(imagesdomain.getMainImageUrl());
			images.setSourceFileUrl(imagesdomain.getSourceFileURL());
			images.setThumbnailUrl(imagesdomain.getThumbnailUrl());
			images.setCreatedBy(imagesdomain.getCreatedby()); // add the createdby -C
			images.setCreationDate(Calendar.getInstance()); //set creation date -C
			images.setLastUpatedBy(imagesdomain.getLastupdateby()); //set lastupdateby -C
			images.setLastUpdateDate(Calendar.getInstance()); // -C
			imageSet.add(images);
		}
		board.setTrBoardImageses(imageSet);
		return board;
	}

	private TrBoardDomain convertEntityToDomain(TrBoard board) throws DatatypeConfigurationException {
		TrBoardDomain domain = new TrBoardDomain();
		domain.setActiveStatus(board.getActiveStatus());
		domain.setPublishToMP(board.getPublishToMp());
		domain.setBoardId(board.getBoardId());
		domain.setName(board.getName());
		domain.setDescription(board.getDescription());
		domain.setKeyword(board.getKeyword());
		domain.setLangCode(board.getLangCode());
		domain.setBoardPrice(board.getBoardPrice());
		domain.setTotalPrice(board.getTotalPrice());
		domain.setPortfolioId(board.getTrPortfolio().getPortfolioId());
		if(board.getStCategoryMasterByCatLevel3Id()!=null)
			domain.setCategoryLevel3Id(board.getStCategoryMasterByCatLevel3Id().getCategoryId());
		if(board.getStCategoryMasterByCatLevel4Id()!=null)
			domain.setCategoryLevel4Id(board.getStCategoryMasterByCatLevel4Id().getCategoryId());
		domain.setEffectiveDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(board.getEffectiveDate()));
		/*domain.setCategoryLevel5Id(board.getStCategoryMasterByCatLevel5Id().getCategoryId());*/
		domain.setCurrentUerId(board.getAdUsersByCurrentUserId().getUserId());
		domain.setOriginalUserId(board.getAdUsersByOriginalUserId().getUserId());
		AdUsersDomain currentUser=new AdUsersDomain();
		modelConverter.convertAdUsersEntityToDomain(board.getAdUsersByCurrentUserId(), currentUser);
		domain.setCurrentUser(currentUser);
		AdUsersDomain originalUser=new AdUsersDomain();
		modelConverter.convertAdUsersEntityToDomain(board.getAdUsersByOriginalUserId(), originalUser);
		domain.setOriginalUser(originalUser);
		//set category denorm
		StCategoryDenormDomain stDenorm=new StCategoryDenormDomain();
		if(board.getTrPortfolio().getStCategoryMasterByCatLevel1Id()!=null)
		{
			stDenorm.setCategoryLevel1(board.getTrPortfolio().getStCategoryMasterByCatLevel1Id().getCategoryId());
			stDenorm.setCategoryLevel1Value(board.getTrPortfolio().getStCategoryMasterByCatLevel1Id().getName());
		}
		if(board.getTrPortfolio().getStCategoryMasterByCatLevel2Id()!=null)
		{
			stDenorm.setCategoryLevel2(board.getTrPortfolio().getStCategoryMasterByCatLevel2Id().getCategoryId());
			stDenorm.setCategoryLevel2Value(board.getTrPortfolio().getStCategoryMasterByCatLevel2Id().getName());
		}
		if(board.getStCategoryMasterByCatLevel3Id()!=null)
		{
			stDenorm.setCategoryLevel3(board.getStCategoryMasterByCatLevel3Id().getCategoryId());
			stDenorm.setCategoryLevel3Value(board.getStCategoryMasterByCatLevel3Id().getName());
		}
		if(board.getStCategoryMasterByCatLevel4Id()!=null)
		{
			stDenorm.setCategoryLevel4(board.getStCategoryMasterByCatLevel4Id().getCategoryId());
			stDenorm.setCategoryLevel4Value(board.getStCategoryMasterByCatLevel4Id().getName());
		}
		domain.setCategory(stDenorm);
		domain.setSaleTypeId(board.getAdLookupValues().getLookupValueId()); //set sale type ID -C
		domain.setStatusId(board.getAdLookupValuesStatusId().getLookupValueId());
		//set last update date
		domain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(board.getLastUpdateDate()));
		domain.setLastupdateby(board.getLastUpdatedBy());
		//set expiration date -C
		domain.setExperiationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(board.getExpirationDate()));
		domain.setEffectiveDate((XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(board.getEffectiveDate())));
		//Compute the sale price if the tr_sales_transactions is not null
		if(!board.getTrSalesTransactionDetailses().isEmpty())
		{
			//Board should only have one record 
			TrSalesTransactionDetails detail = board.getTrSalesTransactionDetailses().iterator().next();
			BigDecimal salePrice = detail.getSellerShare().add(detail.getCommission());
			domain.setSalePrice(salePrice);
		}
		
		if(board.getExpirationDate().after(Calendar.getInstance()))
		{
			switch(board.getPublishToMp())
			{
			case 0:
				domain.setBoardStatus("Unpublished");
				break;
			case 1:
				domain.setBoardStatus("Published");
				break;
			case 2:
				domain.setBoardStatus("Reviewing");
				break;
			default:
				domain.setBoardStatus("Unpublished");
				break;
			}
		}
		else
			domain.setBoardStatus("Expired");
		
		List<TrBoardImagesDomain> boardImagesDomainsList = domain.getBoardImages();
		for (TrBoardImages imageEntity :  board.getTrBoardImageses()) {
			TrBoardImagesDomain imageDomain = new TrBoardImagesDomain();
			imageDomain.setBoardImageId(imageEntity.getBoardImageId());
			imageDomain.setFileName(imageEntity.getFileName());
			imageDomain.setFileType(imageEntity.getFileType());
			imageDomain.setMainImageUrl(imageEntity.getMainImageUrl());
			imageDomain.setSourceFileURL(imageEntity.getSourceFileUrl());
			imageDomain.setThumbnailUrl(imageEntity.getThumbnailUrl());
			imageDomain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(imageEntity.getCreationDate()));
			imageDomain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(imageEntity.getLastUpdateDate()));
			boardImagesDomainsList.add(imageDomain);
		}
		
		//convert portfolio images domain
		if(board.getTrPortfolio() != null)
		{
			List<TrPortfolioImagesDomain> portfolioImagesDomain = domain.getPortfolioImages();
			portfolioImagesDomain.addAll(modelConverter.convertTrPortfolioImagesEntityToDomain(board.getTrPortfolio().getTrPortfolioImages()));
			
			if(board.getTrPortfolio().getSellable()!=null)
				domain.setHasSellablePortfolio(board.getTrPortfolio().getSellable()); //carry hasSellablePortfolio value
		}
		
		return domain;
	}
	
	public GetRecentlyViewedBoardsResponse getRecentlyViewedBoards(int userId, int numberOfdays,String userType) {
		
		GetRecentlyViewedBoardsResponse response = new GetRecentlyViewedBoardsResponse();
		Status responseStatus = new Status();
		logger.debug("userId:{} , days : {}",userId, numberOfdays);
		response.setStatus(responseStatus);
		try{
			Calendar eventTimestamp = Calendar.getInstance();
			eventTimestamp.add(Calendar.DATE, -1*numberOfdays);
			eventTimestamp.set(Calendar.HOUR, 0);
			eventTimestamp.set(Calendar.MINUTE, 0);
			eventTimestamp.set(Calendar.SECOND, 0);
			eventTimestamp.set(Calendar.MILLISECOND, 0);
			List<TrActivityDomain> activity = response.getGrid();
			List<TrActivityScreenGraph> activityGraph = null;
			
			if(userType.equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode())){
				List<TrActivityScreenDesignerGrid> designerGrid = trRecentlyViewedDAO.GetDesignerGridInfo(userId, eventTimestamp);
				ConvertDesignerGraphInfotoActivityDomain(activity,designerGrid);
				activityGraph = trRecentlyViewedDAO.GetDesignerGraphInfo(userId, eventTimestamp);
				
			}
			else{
				//Retrieve the membership pricing option
				AdUsers adUser = adUsersDAO.findAdUsersByUserId(userId); //TODO Parse user id
				Integer memPricingOption = adUser.getAdUserMembershipset().iterator().next().getStMemPricingOptions().getMemPricingId();
				
				List<TrActivityScreenCompanyGrid> companyGrid = trRecentlyViewedDAO.GetCompanyGridInfo(userId, memPricingOption, eventTimestamp);
				activityGraph = trRecentlyViewedDAO.GetCompanyGraphInfo(userId, eventTimestamp);
				ConvertCompanyGraphInfotoActivityDomain(activity,companyGrid);
			}
			
			Map<XMLGregorianCalendar,BoardsViewed> boardsViewedMap = new LinkedHashMap<XMLGregorianCalendar,BoardsViewed>();
			if(activityGraph!=null && activityGraph.size()>0)
			{
				for (TrActivityScreenGraph trActivityScreenGraph : activityGraph) {
					XMLGregorianCalendar dateOfViewed = DateUtil.toXMLGregorianCalendar(trActivityScreenGraph.getEventTimestamp());
					BoardsViewed bv = new BoardsViewed(dateOfViewed, trActivityScreenGraph.getHits());
					boardsViewedMap.put(dateOfViewed, bv);
				}
			}
				
			List<BoardsViewed> boardsViewedList = response.getBoardsViewedByDate();
			boardsViewedList.addAll(boardsViewedMap.values());
			
		
			
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			responseStatus.setDescription("Error occured");		
		}
		return response;
	}
	
	private void ConvertDesignerGraphInfotoActivityDomain(
			List<TrActivityDomain> activity,
			List<TrActivityScreenDesignerGrid> designerGrid) throws DatatypeConfigurationException {
		for (TrActivityScreenDesignerGrid trActivityScreenDesignerGrid : designerGrid) {
			TrActivityDomain activityDomain = new TrActivityDomain();
			activityDomain.setBoardId(trActivityScreenDesignerGrid.getBoardId());
			activityDomain.setBoardName(trActivityScreenDesignerGrid.getName());
			activityDomain.setDateViewed(DateConverter.toXMLCalendar(trActivityScreenDesignerGrid.getEventTimestamp()));
			activityDomain.setBoardImageUrl(trActivityScreenDesignerGrid.getThumbnailUrl());
			activityDomain.setBoard(modelConverter.convertTrBoardEntityToDomain(trActivityScreenDesignerGrid.getBoard()));

			activityDomain.setClickId(trActivityScreenDesignerGrid.getClickId());
			activityDomain.setPortfolioname(trActivityScreenDesignerGrid.getPortfolioName());
			activityDomain.setPrice(trActivityScreenDesignerGrid.getBoardPrice().toString());
			/*activityDomain.setSeason(trActivityScreenDesignerGrid.getSeason()+" "+trActivityScreenDesignerGrid.getYear());*/
			activityDomain.setSeason(trActivityScreenDesignerGrid.getSeason());
			
			activity.add(activityDomain);
		}
		
	}

	private void ConvertCompanyGraphInfotoActivityDomain(
			List<TrActivityDomain> activity,
			List<TrActivityScreenCompanyGrid> companyGrid) throws DatatypeConfigurationException {

		for (TrActivityScreenCompanyGrid trActivityScreenCompanyGrid : companyGrid) {
			TrActivityDomain activityDomain = new TrActivityDomain();
			activityDomain.setBoardId(trActivityScreenCompanyGrid.getBoardId());
			activityDomain.setBoardName(trActivityScreenCompanyGrid.getName());
			activityDomain.setDateViewed(DateConverter.toXMLCalendar(trActivityScreenCompanyGrid.getEventTimestamp()));
			activityDomain.setBoardImageUrl(trActivityScreenCompanyGrid.getThumbnailUrl());
			activityDomain.setBoard(modelConverter.convertTrBoardEntityToDomain(trActivityScreenCompanyGrid.getBoard()));
	
			activityDomain.setDesignerId(trActivityScreenCompanyGrid.getUserId());
			activityDomain.setDesignerName(trActivityScreenCompanyGrid.getFirstname()+" "+trActivityScreenCompanyGrid.getLastname());
			activityDomain.setClickId(trActivityScreenCompanyGrid.getClickId());
			//activityDomain.setPrice(trActivityScreenCompanyGrid.getTotalPrice().toString());
			activityDomain.setPrice(trActivityScreenCompanyGrid.getSalePrice().setScale(2, RoundingMode.HALF_UP).toString()); //show SALE_PRICE instead of total_price
			/*activityDomain.setSeason(trActivityScreenCompanyGrid.getSeason()+" "+trActivityScreenCompanyGrid.getYear());*/
			activityDomain.setSeason(trActivityScreenCompanyGrid.getSeason());
			activityDomain.setProfilename(trActivityScreenCompanyGrid.getProfilename());
			activityDomain.setUseProfilename(trActivityScreenCompanyGrid.getUseProfilename());
			activity.add(activityDomain);
		}
	}

	public CreateBoardImageResponse createBoardImage(CreateBoardImageRequest request) {
		CreateBoardImageResponse response = new CreateBoardImageResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			TrBoardImagesDomain trBoardImagesDomain = request.getTrBoardImagesDomain();
			TrBoard trBoard = trBoardDAO.findTrBoardByBoardId(trBoardImagesDomain.getBoardId());
			TrBoardImages trBoardImagesEnitty = new TrBoardImages();
			Calendar today = Calendar.getInstance();
			trBoardImagesEnitty.setCreatedBy(trBoardImagesDomain.getCreatedby());
			trBoardImagesEnitty.setCreationDate(today);
			trBoardImagesEnitty.setFileName(trBoardImagesDomain.getFileName());
			trBoardImagesEnitty.setFileType(trBoardImagesDomain.getFileType());
			trBoardImagesEnitty.setLastUpatedBy(trBoardImagesDomain.getLastupdateby());
			trBoardImagesEnitty.setLastUpdateDate(today);
			trBoardImagesEnitty.setMainImageUrl(trBoardImagesDomain.getMainImageUrl());
			trBoardImagesEnitty.setSourceFileUrl(trBoardImagesDomain.getSourceFileURL());
			trBoardImagesEnitty.setThumbnailUrl(trBoardImagesDomain.getThumbnailUrl());
			trBoardImagesEnitty.setTrBoard(trBoard);
			trBoardImagesDAO.merge(trBoardImagesEnitty);
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}


	public SearchExampleBoardsResponse searchExampleBoards(SearchExampleBoardsRequest request) {
		SearchExampleBoardsResponse response = new SearchExampleBoardsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			
			int limit = searchMaxResults;

			Integer [] countryIds = null;
			if(null != request.getCountryIds() && request.getCountryIds().size() > 0){
				countryIds = request.getCountryIds().toArray(new Integer[0]);
			}

			Integer [] langIds = null;
			if(null != request.getLanguageIds() && request.getLanguageIds().size() > 0){
				langIds = request.getLanguageIds().toArray(new Integer[0]);
			}

			
			Integer [] skillIds = null;
			if(null != request.getSkillIds() && request.getSkillIds().size() > 0){
				skillIds = request.getSkillIds().toArray(new Integer[0]);
			}
			
			//08012014 Fred - Add expertise, specialty, education===========================
			Integer [] expertiseIds = null;
			if(null != request.getExpertiseIds() && request.getExpertiseIds().size() > 0) {
				expertiseIds = request.getExpertiseIds().toArray(new Integer[0]);
			}
			
			Integer [] specialtyIds = null;
			if(null != request.getSpecialtyIds() && request.getSpecialtyIds().size() > 0) {
				specialtyIds = request.getSpecialtyIds().toArray(new Integer[0]);
			}
			
			Integer [] educationIds = null;
			if(null != request.getEducationIds() && request.getEducationIds().size() > 0) {
				educationIds = request.getEducationIds().toArray(new Integer[0]);
			}

			AdUsers adUser = adUsersDAO.findAdUsersByUserId(request.getUserId()); //TODO Parse user id
			//Integer memPricingOption = adUser.getAdUserMembershipset().iterator().next().getStMemPricingOptions().getMemPricingId();
			
			Date portfolioSearchStartDate = new Date();
			Date portfolioSearchEndDate = new Date();
			if(request.getPortfoliosearchstartdate()!=null)
				portfolioSearchStartDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(request.getPortfoliosearchstartdate()).getTime();
			if(request.getPortfoliosearchenddate()!=null)
			{
				Calendar temp = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(request.getPortfoliosearchenddate());
				temp.add(Calendar.DATE, 1);
				portfolioSearchEndDate = temp.getTime();
			}
			
			Set<TrBoardSearch> trBoardSet = trBoardDAO.findTrBoardsOfExamplesBySearchCriteria(
					request.getDesignerName(), countryIds, langIds, skillIds, request.getSchoolAwards(), 
					limit+1, request.isIsPortfolioSearch(),portfolioSearchStartDate,portfolioSearchEndDate, 
					expertiseIds, specialtyIds, educationIds,
					request.getMinAdminRating(), request.getMaxAdminRating());
					
			List<TrBoardSearchDomain> trBoardDomainsList = response.getTrBoardSearchDomains();
			if(trBoardSet.size()>limit)
			{
				status.setStatuscode(StatusCodesEnum.MAXIMUM_RECORDS_REACHED.getCode());
				status.setDescription("Maximum records reached.");
			}
			else
				modelConverter.convertTrBoardSearchEntitysToDomains(trBoardSet, trBoardDomainsList);
								
		}
		catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;		
	}	
	
	public SearchBoardsResponse searchBoards(SearchBoardsRequest request) {
		SearchBoardsResponse response = new SearchBoardsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		
		try{
			
			int limit = searchMaxResults;
			Integer ratingStart = 0;//TODO - remove hard coding and get from properties
			Integer ratingEnd = 5;//TODO - remove hard coding and get from properties

			if(null != request.getRatingOption()){
				switch(request.getRatingOption()){
					case Constants.SEARCH_OPTION_RATING_1_TO_4:
						ratingStart = 1;
						ratingEnd = 4;						
					break;
					case Constants.SEARCH_OPTION_RATING_5:
						ratingStart = 5;
						ratingEnd = 5;					
					break;
					case Constants.SEARCH_OPTION_RATING_ALL:
						ratingStart = 0;
						ratingEnd = 5;				
					break;					
				}
			}
			else
			{
				//parse the buyer rating range if RatingOption does not specified.
				ratingStart = request.getMinBuyerRating();
				ratingEnd = request.getMaxBuyerRating();
			}
				
			Integer [] countryIds = null;
			if(null != request.getCountryIds() && request.getCountryIds().size() > 0){
				countryIds = request.getCountryIds().toArray(new Integer[0]);
			}

			Integer [] langIds = null;
			if(null != request.getLanguageIds() && request.getLanguageIds().size() > 0){
				langIds = request.getLanguageIds().toArray(new Integer[0]);
			}

			
			Integer [] skillIds = null;
			if(null != request.getSkillIds() && request.getSkillIds().size() > 0){
				skillIds = request.getSkillIds().toArray(new Integer[0]);
			}
			
			//08012014 Fred - Add expertise, specialty, education===========================
			Integer [] expertiseIds = null;
			if(null != request.getExpertiseIds() && request.getExpertiseIds().size() > 0) {
				expertiseIds = request.getExpertiseIds().toArray(new Integer[0]);
			}
			
			Integer [] specialtyIds = null;
			if(null != request.getSpecialtyIds() && request.getSpecialtyIds().size() > 0) {
				specialtyIds = request.getSpecialtyIds().toArray(new Integer[0]);
			}
			
			Integer [] educationIds = null;
			if(null != request.getEducationIds() && request.getEducationIds().size() > 0) {
				educationIds = request.getEducationIds().toArray(new Integer[0]);
			}
			//=================================================================================

			Integer [] seasonYearIds = null;
			if(null != request.getSeasonYearIds() && request.getSeasonYearIds().size() > 0){
				seasonYearIds = request.getSeasonYearIds().toArray(new Integer[0]);
			}

			Integer [] saleTypeIds = null;
			if(null != request.getSaleTypeIds() && request.getSaleTypeIds().size() > 0){
				saleTypeIds = request.getSaleTypeIds().toArray(new Integer[0]); //fix the issue of using seasonYearIds, noe change to saleTypeIds -C
			}
			
			String [] productType = null;
			if(null != request.getProductType() && request.getProductType().size() > 0){
				productType = request.getProductType().toArray(new String[0]);
			}

			BigDecimal priceLow = null;
			BigDecimal priceHigh = null;	
			if(null != request.getPriceOption()){
				switch(request.getPriceOption()){
					case Constants.SEARCH_OPTION_PRICE_ALL :
						priceLow = new BigDecimal(0);
						priceHigh = null;				    	
				    	break;
				    case Constants.SEARCH_OPTION_PRICE_0_TO_499 :
						priceLow = new BigDecimal(0);
						priceHigh = new BigDecimal(499);				    	
				    	break;
				    case Constants.SEARCH_OPTION_PRICE_500_TO_999 :
						priceLow = new BigDecimal(500);
						priceHigh = new BigDecimal(999);
				    	break;
				    case Constants.SEARCH_OPTION_PRICE_1000_TO_2999 : 
						priceLow = new BigDecimal(1000);
						priceHigh = new BigDecimal(2999);
				    	break;
				    case Constants.SEARCH_OPTION_PRICE_3000_OR_ABOVE :
						priceLow = new BigDecimal(3000);
						priceHigh = null;
					break;				
				}
			}
			else
			{
				//parse the price range if PriceOption does not specified.
				priceLow=request.getMinPrice();
				priceHigh=request.getMaxPrice();
			}
			
			//Retrieve the membership pricing option
			AdUsers adUser = adUsersDAO.findAdUsersByUserId(request.getUserId()); //TODO Parse user id
			Integer memPricingOption = adUser.getAdUserMembershipset().iterator().next().getStMemPricingOptions().getMemPricingId();
			
			Date portfolioSearchStartDate = new Date();
			Date portfolioSearchEndDate = new Date();
			if(request.getPortfoliosearchstartdate()!=null)
				portfolioSearchStartDate = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(request.getPortfoliosearchstartdate()).getTime();
			if(request.getPortfoliosearchenddate()!=null)
			{
				Calendar temp = XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(request.getPortfoliosearchenddate());
				temp.add(Calendar.DATE, 1);
				portfolioSearchEndDate = temp.getTime();
			}
			Set<TrBoardSearch> trBoardSet = trBoardDAO.findTrBoardsBySearchCriteria(
					request.getDesignerName(), ratingStart, ratingEnd, countryIds, langIds, skillIds, "%"+request.getSchoolAwards()+"%", 
					request.getDivision(), request.getCategory(), request.getProduct(), productType, 
					seasonYearIds, saleTypeIds, priceLow, priceHigh, request.getKeywords(),limit+1,memPricingOption,request.isIsPortfolioSearch(),portfolioSearchStartDate,portfolioSearchEndDate, 
					expertiseIds, specialtyIds, educationIds,
					request.getMinAdminRating(), request.getMaxAdminRating());
					
			List<TrBoardSearchDomain> trBoardDomainsList = response.getTrBoardSearchDomains();
			if(trBoardSet.size()>limit)
			{
				status.setStatuscode(StatusCodesEnum.MAXIMUM_RECORDS_REACHED.getCode());
				status.setDescription("Maximum records reached.");
			}
			else
				modelConverter.convertTrBoardSearchEntitysToDomains(trBoardSet, trBoardDomainsList);
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}
	
	public DrawerInfoResponse drawerInfo(Integer userId) {
		DrawerInfoResponse response = new DrawerInfoResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			
			Stats stats = new Stats();
			response.setStats(stats);
			//0) Your Messages
					//a) Alerts
					//b) Messages
//			AdLookupValues adLookupValues =  adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MESSAGE_STATUS_UNREAD.getTypeCode());
			Long inboxCount = trMessagesDAO.findTrMessagesCountByUserMessageTypeAndMessageStatus(userId, MessageTypes.INBOX, LookupTypeValueEnum.MESSAGE_STATUS_UNREAD.getTypeCode());
			Long alertCount = trMessagesDAO.findTrMessagesCountByUserMessageTypeAndMessageStatus(userId, MessageTypes.ALERT, LookupTypeValueEnum.MESSAGE_STATUS_UNREAD.getTypeCode());
			//get latest timestamp
			Set<TrMessages> messagesSet=trMessagesDAO.findTrMessagesByUserMessageTypeAndMessageStatus(userId, MessageTypes.INBOX, LookupTypeValueEnum.MESSAGE_STATUS_UNREAD.getTypeCode());
			Set<TrMessages> alertsSet=trMessagesDAO.findTrMessagesByUserMessageTypeAndMessageStatus(userId, MessageTypes.ALERT, LookupTypeValueEnum.MESSAGE_STATUS_UNREAD.getTypeCode());
			YourMessages msgs = new YourMessages();
			msgs.setAlerts(alertCount);
			msgs.setMessages(inboxCount);
			//retrieve the latest timestamp if the size > 0
			TrMessages latestMessage=new TrMessages();
			TrMessages latestAlert=new TrMessages();
			if(!messagesSet.isEmpty())
			{
				latestMessage=messagesSet.iterator().next();
				msgs.setLatestMessagesTS(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(latestMessage.getLastUpdateDate()));
			}
			if(!alertsSet.isEmpty())
			{
				latestAlert=alertsSet.iterator().next();
				msgs.setLatestAlertsTS(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(latestAlert.getLastUpdateDate()));
			}
			response.setYourMessages(msgs);
			
			//1) Boards Purchased
			//     a) 15 Boards  and Total amount
			List<Object> boardsTotalAndAMount = trBoardDAO.findTrBoardsCountAndTotalPurchasedByUser(userId);
			if(null != boardsTotalAndAMount && boardsTotalAndAMount.size() > 0 
					&& boardsTotalAndAMount.get(0) != null ){
				
				Object[] boardsTotalAndAMountArr = (Object[]) boardsTotalAndAMount.get(0);
				
				if(boardsTotalAndAMountArr.length >0 && null != boardsTotalAndAMountArr[0]){
					stats.setBoardsPurchasedCount(((BigInteger) boardsTotalAndAMountArr[0]).intValue());	
				}else{
					stats.setBoardsPurchasedCount(0);
				}
				
				if(boardsTotalAndAMountArr.length >=1 &&  null != boardsTotalAndAMountArr[1]){
					stats.setBoardsPurchasedTotal((((BigDecimal) boardsTotalAndAMountArr[1]).doubleValue()));	
				}else{
					stats.setBoardsPurchasedTotal(0.0);
				}				
			}else{
				stats.setBoardsPurchasedCount(0);
				stats.setBoardsPurchasedTotal(0.0);
			}
			//2) Boards Viewed
//			        a) Today
//			        b) Week 
//			        c) Month
			
			Calendar todayStart = Calendar.getInstance();
			todayStart.add(Calendar.DATE, -1);
			todayStart.set(Calendar.HOUR, 0);
			todayStart.set(Calendar.MINUTE, 0);
			todayStart.set(Calendar.SECOND, 0);
			todayStart.set(Calendar.MILLISECOND, 0);
			
			Calendar todayEnd = Calendar.getInstance();
			todayEnd.set(Calendar.HOUR, 23);
			todayEnd.set(Calendar.MINUTE, 59);
			todayEnd.set(Calendar.SECOND, 59);
			//todayEnd.set(Calendar.MILLISECOND, 0);
			//oneday
			AdUsers user = adUsersDAO.findAdUsersByPrimaryKey(userId);
			Long count1,count7,count30;
			AdLookupValues userTypeLookup = user.getAdLookupValuesByUserTypeId();
			if(userTypeLookup.getLookupCode().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()))
			{
				count1 = trRecentlyViewedDAO.GetDesignerCount(userId, todayStart).getCount();
				todayStart.add(Calendar.DATE, -6);
				count7 = trRecentlyViewedDAO.GetDesignerCount(userId, todayStart).getCount();
				todayStart.add(Calendar.DATE, -23);
				count30= trRecentlyViewedDAO.GetDesignerCount(userId, todayStart).getCount();
				
			}
			else
			{
				count1 = trRecentlyViewedDAO.GetCompanyCount(userId, todayStart).getCount();
				todayStart.add(Calendar.DATE, -6);
				count7 = trRecentlyViewedDAO.GetCompanyCount(userId, todayStart).getCount();
				todayStart.add(Calendar.DATE, -23);
				count30= trRecentlyViewedDAO.GetCompanyCount(userId, todayStart).getCount();
			}
			
			//1day
			if(null != count1)
				stats.setBoardsViewedToday(count1.intValue());
			else
				stats.setBoardsViewedToday(0);
			//7 days
			if(null != count7)
				stats.setBoardsViewedWeek(count7.intValue());
			else
				stats.setBoardsViewedWeek(0);

			//30 days	 
			if(null != count30)
				stats.setBoardsViewedMonth(count30.intValue());
			else
				stats.setBoardsViewedMonth(0);

//			3) Average Ratings
			//Call RatingService to get the overall rating value instead.
			/*AdUsers adUsers =  adUsersDAO.findAdUsersByPrimaryKey(userId);
			if(null != adUsers.getOverallRating())
				response.setAveragRating(adUsers.getOverallRating().doubleValue());
			else
				response.setAveragRating(0.0);*/
			//Should be based on the information from tr_rating
			
			
			
//			4) Recent Activity
			//	a ) Boards
//	        		board name 20412 amount Amt 350.00$
//					board name 20412 amount Amt 350.00$
			//Retrieve membership pricing option id
			AdUsers adUsers = adUsersDAO.findAdUsersByUserId(userId);
			AdUserMemberships userMembership = adUsers.getAdUserMembershipset().iterator().next();
			
			Set<TrBoardSearch> recentlyViewedSet = trBoardDAO.findTrBoardsFromRecentlyViewedBoards(userId, userMembership.getStMemPricingOptions().getMemPricingId(), 6);
			List<TrBoardSearchDomain> recentBoardSearchDomains = response.getRecentActivity();
			modelConverter.convertTrBoardSearchEntitysToDomains(recentlyViewedSet, recentBoardSearchDomains);
//	        5) May We Suggest
			Set<TrBoardSearch> mayWeSuggestSet =trBoardDAO.findTrBoardsForMayWeSuggest(userMembership.getStMemPricingOptions().getMemPricingId(), 12);
			List<TrBoardSearchDomain> mayWeSuggestList = response.getMayWeSuggest();
			//shuffle the list
			modelConverter.convertTrBoardSearchEntitysToDomains(mayWeSuggestSet, mayWeSuggestList);
			Collections.shuffle(mayWeSuggestList);
			
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}

	public ValidateBoardsResponse validateBoards(ValidateBoardsRequest request) {
		ValidateBoardsResponse response = new ValidateBoardsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			List<Integer> invalidBoardIds = response.getInvalidBoardIds();
			List<Integer> inconsistentBoardIds = response.getInconsistentBoardIds();
			
			List<BoardSet> boards = request.getBoards();
			if(null != boards && boards.size() > 0 ){
				for(BoardSet set:boards)
				{
					TrBoard trBoard=trBoardDAO.findTrBoardByBoardId(set.getBoardIds());
					Calendar setLastUpdateDate=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(set.getLastUpdateDate());
					if(LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeCode().equals(trBoard.getAdLookupValuesStatusId().getLookupCode()) 
							||  LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeCode().equals(trBoard.getAdLookupValuesStatusId().getLookupCode())
							|| trBoard.getActiveStatus() == 0
							|| setLastUpdateDate.equals(trBoard.getLastUpdateDate()) == false
							|| trBoard.getPublishToMp() != 1)
					{
						if(request.getUserId()!=trBoard.getLastUpdatedBy() || trBoard.getPublishToMp() != 1)
							invalidBoardIds.add(trBoard.getBoardId());
						else
						{
							if(setLastUpdateDate.equals(trBoard.getLastUpdateDate()) == false)
								inconsistentBoardIds.add(trBoard.getBoardId());
						}
					}
				}
				/*Set<TrBoard> trBoardSet = trBoardDAO.findTrBoardByBoardIds(boardIds);
				for(TrBoard trBoard : trBoardSet){
					if(LookupTypeValueEnum.BOARD_SALE_STATUS_PROCESSING.getTypeCode().equals(trBoard.getAdLookupValuesStatusId().getLookupCode()) 
							||  LookupTypeValueEnum.BOARD_SALE_STATUS_SOLD.getTypeCode().equals(trBoard.getAdLookupValuesStatusId().getLookupCode())
							|| trBoard.getActiveStatus() == 0){
						if(request.getUserId()!=trBoard.getLastUpdatedBy())
							invalidBoardIds.add(trBoard.getBoardId());
					}
				}*/
			}
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}
	
	public UpdateBoardStatusResponse updateBoardStatus(UpdateBoardStatusRequest request) {
		UpdateBoardStatusResponse response = new UpdateBoardStatusResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			List<TrBoardDomain> trBoardDomains  = request.getBoards();
			if(null != trBoardDomains && trBoardDomains.size() > 0 ){
				for(TrBoardDomain trBoardDomain : trBoardDomains){
					TrBoard trBoard = trBoardDAO.findTrBoardByBoardId(trBoardDomain.getBoardId());
					AdLookupValues adLookupValuesStatusId = new AdLookupValues();
					adLookupValuesStatusId.setLookupValueId(trBoardDomain.getStatusId());
					trBoard.setAdLookupValuesStatusId(adLookupValuesStatusId);
					trBoardDAO.merge(trBoard);
				}				
			}
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}
	
	public UpdatePublishBoardStatusResponse updatePublishBoardStatus(UpdatePublishBoardStatusRequest request)
	{
		UpdatePublishBoardStatusResponse response = new UpdatePublishBoardStatusResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
				List<TrBoardDomain> Boards = request.getBoards(); 
				//work around not sure why have to check! last record is not getting saved
				if(Boards!=null){
					for (TrBoardDomain item : Boards) {
						
						TrBoard board = trBoardDAO.findTrBoardByBoardId(item.getBoardId());
						//update lastupdatedby tp the user
						board.setLastUpdatedBy(item.getLastupdateby());
						
						if(board!=null)
						{
							switch(board.getPublishToMp())
							{
							case 0:
								board.setPublishToMp(new Integer(1));
								break;
							case 1:
								board.setPublishToMp(new Integer(0));
								break;
							case 2:
								board.setPublishToMp(new Integer(0));
								break;
							default:
								board.setPublishToMp(new Integer(0));
								break;
							}
							trBoardDAO.merge(board);
						}
						trBoardDAO.flush();
				}
			}
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}
	
	public GetBoardsSuggestionResponse getBoardsSuggestion(GetBoardsSuggestionRequest request)
	{
		GetBoardsSuggestionResponse response=new GetBoardsSuggestionResponse();
		Set<TrBoardSearch> mayWeSuggestSet =trBoardDAO.findTrBoardsForMayWeSuggest(request.getMemPricingOptionId(), request.getNumberOfBoards());
		List<TrBoardSearchDomain> mayWeSuggestList = response.getBoards();
		try 
		{
			modelConverter.convertTrBoardSearchEntitysToDomains(mayWeSuggestSet, mayWeSuggestList);
		} 
		catch (DatatypeConfigurationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	public GetBoardsByPMResponse fetchBoardsByPMStatus(GetBoardsByPMRequest request) {
		GetBoardsByPMResponse response = new GetBoardsByPMResponse();
		Status responseStatus = new Status();
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(request.getUserId()))) //check user has privilege of admin
		{
			try {
				Set<TrBoard> boards = trBoardDAO.findTrBoardByContainingPublishToMP(request.getPublishToMP(), request.getPortfolioTypes(), -1, -1);
				for (TrBoard trBoard : boards) {
					response.getBoards().add(this.convertEntityToDomain(trBoard));
				}
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			}
			catch (Exception e) {
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		else
		{
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_UNAUTHORIZED_USER.getCode());
			responseStatus.setDescription("Unauthorized user, only administrator can access");
		}
		response.setStatus(responseStatus);
		return response;
	}
	
	public AddBoardApprovalResponse addBoardApproval(AddBoardApprovalRequest request) {
		AddBoardApprovalResponse response = new AddBoardApprovalResponse();
		boolean hasError=false;
		Status status = new Status();
		AdUsers systemUser=new AdUsers();
		systemUser.setUserId(2); //System user
		response.setStatus(status);
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(request.getUserId()))) //check user has privilege of admin
		{
			//If the record is already existed in the table, do not enter again
			Set<TrBoardApproval> boards = trBoardApprovalDAO.findTrBoardApprovalByMainImageUrl(request.getInstance().getMainImageUrl());
			if(boards.size()>0)
			{
				//already have record in tr_board_approval
				status.setStatuscode(StatusCodesEnum.STATUS_RECORD_EXISTED.getCode());
				status.setDescription("Record Existed");
			}
			else
			{
				TrBoardApproval instance=modelConverter.convertTrBoardApprovalDomainToEntity(request.getInstance());
				//set board id
				TrBoard board=new TrBoard();
				board.setBoardId(request.getBoardId());
				instance.setTrBoard(board);
				//retrieve the TrBoard entity
				TrBoard trBoard=trBoardDAO.findTrBoardByBoardId(request.getBoardId());
				//check the image we approved is the same image on tr_board record
				Set<TrBoardImages> trBoardImages=trBoardImagesDAO.findTrBoardImagesByMainImageUrl(request.getInstance().getMainImageUrl());
				boolean isConsistent=true;
				if(trBoardImages.size()>0)
				{
					for(TrBoardImages item:trBoardImages)
					{
						if(item.getTrBoard().getBoardId()!=request.getBoardId())
							isConsistent=false;
					}
				}
				else
				{
					isConsistent=false; //The main image url can't find record in tr_board_images table.
				}
				if(trBoard.getPublishToMp()!=Constants.PUBLISH_TO_MARKET_REVIEWING) //if the board is not under reviewing, can't approve/reject the board.
					isConsistent=false;
				if(isConsistent) //The images has the same board id we get
				{
					String mailSubject;
					String mailBody;
					String supportEmail;
					//TrMessages alert=new TrMessages(); //Do not need to send alerts, it will insert record to tr_message when insert into tr_notification_q
					if(instance.getApprovalStatus()==0) //reject
					{
						instance.setProcessStatus("REJECTED"); //set process status on tr_board_approval
						trBoard.setPublishToMp(Constants.PUBLISH_TO_MARKET_NO); //change MP column to 0(Rejected) on tr_board table
						//retrieve email template from ad_email_tamplates by code BOARD_APPROVED
						//04292014 Fred - check the porfolio is sellable or not to determined the email template
						AdEmailTemplates templates = new AdEmailTemplates();
						if(trBoard.getTrPortfolio().getSellable() == ActiveStatusEnum.ACTIVE.value()) //sellable portfolio
							templates=adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.TEMPLATE_CODE_BOARD_REJECTED);
						else //unsellable portfolio
							templates=adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.TEMPLATE_CODE_PAGE_REJECTED);
						//Replace the variable on email template into appropriate content
						mailSubject=templates.getSubject().replace("$3", trBoard.getName());
						mailBody=templates.getBody().replace("$2", trBoard.getAdUsersByOriginalUserId().getFirstname()+" "+trBoard.getAdUsersByOriginalUserId().getLastname());
						mailBody=mailBody.replace("$3", trBoard.getName());
						mailBody=mailBody.replace("$8", request.getInstance().getComments());
						//mailBody=mailBody.replace("$$5", "1234567890"); //TODO phone number (We could place the phone number in ad_email_templates)
						//mailBody=mailBody.replace("$$6", "admin@plmtechnology.com"); //TODO email (We could place the email in ad_email_templates)
						supportEmail=templates.getSupportEmail();
					}
					else //approve
					{
						instance.setProcessStatus("APPROVED");
						trBoard.setPublishToMp(Constants.PUBLISH_TO_MARKET_YES); //change MP column to 1(Approved) on tr_board table
						//retrieve email template from ad_email_tamplates by code BOARD_REJECTED
						//04292014 Fred - check the porfolio is sellable or not to determined the email template
						AdEmailTemplates templates = new AdEmailTemplates();
						if(trBoard.getTrPortfolio().getSellable() == ActiveStatusEnum.ACTIVE.value()) //sellable portfolio
							templates=adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.TEMPLATE_CODE_BOARD_APPROVED);
						else //unsellable portfolio
							templates=adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.TEMPLATE_CODE_PAGE_APPROVED);
						//Replace the variable on email template into appropriate content
						mailSubject=templates.getSubject().replace("$3", trBoard.getName());
						mailBody=templates.getBody().replace("$2", trBoard.getAdUsersByOriginalUserId().getFirstname()+" "+trBoard.getAdUsersByOriginalUserId().getLastname());
						mailBody=mailBody.replace("$3", trBoard.getName());
						supportEmail=templates.getSupportEmail();
					}
					//create tr_messages entity (alert)
					//Do not need to send alerts, it will insert record to tr_message when insert into tr_notification_q
					/*alert.setSubject(mailSubject);
					alert.setMessageBody(mailBody);
					AdLookupValues msgStatus=adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.MESSAGE_STATUS_UNREAD.getTypeCode());
					alert.setTrBoard(trBoard);
					alert.setAdLookupValues(msgStatus); //message status
					alert.setAdUsersByFromUserId(systemUser);
					alert.setAdUsersByToUserId(trBoard.getAdUsersByOriginalUserId());
					alert.setMessageType(MessageTypes.ALERT);
					alert.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
					alert.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
					alert.setLastUpdatedBy(2); //System user
					alert.setCreatedBy(2); //System user
					trMessagesDAO.merge(alert);*/
					//create tr_notifications_q entity
					TrNotificationsQ trNotificationsQ=new TrNotificationsQ();
					trNotificationsQ.setFromUserId(2); //system user
					trNotificationsQ.setToUserId(trBoard.getAdUsersByOriginalUserId().getUserId());
					trNotificationsQ.setFromEmail(this.adminMailAddress);
					trNotificationsQ.setToEmail(trBoard.getAdUsersByOriginalUserId().getUserName());
					trNotificationsQ.setSubject(mailSubject);
					trNotificationsQ.setBodyText(mailBody);
					trNotificationsQ.setCreatedBy(2); //system user
					trNotificationsQ.setLastUpdatedBy(2); //system user
					//set email status to ready to send
					AdLookupValues readyToSend=adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.EMAIL_STATUS_READY_TO_SEND.getTypeCode());
					trNotificationsQ.setAdLookupValues(readyToSend);
					//insert record to tr_notifications-q table
					trNotificationsQDAO.merge(trNotificationsQ);
					//send a email copy to support team
					trNotificationsQ.setToUserId(2); //support team user
					trNotificationsQ.setToEmail(supportEmail); //admin email address
					//insert record to tr_notifications-q table
					trNotificationsQDAO.merge(trNotificationsQ);
					
					//update tr_board record
					trBoard.setLastUpdatedBy(2); //change the last_updated_by on tr_board table into system user "2"
					TrBoard trBoardEntity=trBoardDAO.merge(trBoard); //flush the changes to tr_board table
					//PUT the current board data on the comment for tracking history
					String comments="<comments>"+instance.getComments()+"</comments><current-data>"
							+"BoardName="+trBoard.getName()+";"
							+"Designer="+trBoard.getAdUsersByOriginalUserId().getFirstname()+" "+trBoard.getAdUsersByOriginalUserId().getLastname()+";"
							+"TotalPrice="+trBoard.getTotalPrice()+";"
							+"KeyWord="+trBoard.getKeyword()+";"
							+"Description="+trBoard.getDescription()+";"
							+"CAT1="+trBoard.getTrPortfolio().getStCategoryMasterByCatLevel1Id().getName()+";"
							+"CAT2="+trBoard.getTrPortfolio().getStCategoryMasterByCatLevel2Id().getName()+";";
							//+"CAT3="+trBoard.getStCategoryMasterByCatLevel3Id().getName()+";";
					if(trBoard.getStCategoryMasterByCatLevel4Id()!=null)
						comments+="CAT4="+trBoard.getStCategoryMasterByCatLevel4Id().getName();
					comments+="</current-data>";
					instance.setComments(comments);
					//cut string if it's too long
					int trimLength=0;
					if(instance.getComments().length()>=1980)
						trimLength=1980;
					else
						trimLength=instance.getComments().length();
					instance.setComments(instance.getComments().substring(0, trimLength)); //trim the string if the string is too long.
					//insert record to the tr_board_approval
					TrBoardApproval entity=trBoardApprovalDAO.merge(instance);
					if(entity!=null)
						status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
					else
					{
						status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
						status.setDescription("Service unavailable.");
					}
				}
				else
				{
					//put error message on tr_board_approval table
					instance.setProcessStatus("ERROR");
					instance.setErrorMessage("Can't find board with this image/different board id/board is already processed");
					TrBoardApproval entity=trBoardApprovalDAO.merge(instance);
					status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
					status.setDescription("Can't find board with this image or different board id. Please refresh your page to update the content. Thank you.");
				}
			}
		}
		else
		{
			status.setStatuscode(StatusCodesEnum.STATUS_UNAUTHORIZED_USER.getCode());
			status.setDescription("Unauthorized user, only administrator can access");
		}
		
		return response;
	}
	
	//Samples related services
	public SubmitSamplesResponse submitSamples(SubmitSamplesRequest request)
	{
		Status status = new Status();
		SubmitSamplesResponse response = new SubmitSamplesResponse();
		List<TrBoardDomain> samples = request.getSamples();
		response.setStatus(status);
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		boolean incomplete = false;
		//get adUser entity
		AdUsers adUsers = adUsersDAO.findAdUsersByUserId(request.getUserId());
		TrPortfolio portfolio = new TrPortfolio();
		Integer portfolioId=0;
		//get portfolio id from samples and check the board id belongs to the user
		for(TrBoardDomain item : samples)
		{
			if(item.getBoardId()!=0)
			{
				TrBoard temp = trBoardDAO.findTrBoardByBoardId(item.getBoardId()); //get portfolio id
				portfolioId = temp.getTrPortfolio().getPortfolioId();
				//Check the board belongs to the user. Or throw the error (unauthrized user)
				if(temp.getAdUsersByOriginalUserId().getUserId() != request.getUserId())
				{
					status.setStatuscode(StatusCodesEnum.STATUS_UNAUTHORIZED_USER.getCode());
					return response;
				}
					
			}
		}
		//if the portfolioId is 0, create a new one with inactive status and some hardcoded information. Or use the portfolioId found in the samples to create the new one
		if(portfolioId == 0 )
		{
			portfolio.setAdUsers(adUsers);
			portfolio.setActiveStatus(0);
			portfolio.setName("Samples Portfolio for "+adUsers.getFirstname()+" "+adUsers.getLastname()); //Hardcoded
			portfolio.setDescription("Samples Portfolio for "+adUsers.getFirstname()+" "+adUsers.getLastname());
			portfolio.setLangCode("en-US");
			portfolio.setLastUpdatedBy(2); //System user
			portfolio.setCreatedBy(2); //System user
			StSeasonYear season = new StSeasonYear();
			season.setSeasonYearId(5); //Hardcoded
			portfolio.setStSeasonYear(season);
			StCategoryMaster level1 = new StCategoryMaster();
			StCategoryMaster level2 = new StCategoryMaster();
			//find the record which is existed in the database
			Set<StCategoryMaster> categoriesLevel1=stCategoryDao.findStCategoryMasterByLevel(1);
			StCategoryMaster catLevel1 = categoriesLevel1.iterator().next();
			Set<StCategoryMaster> categoriesLevel2=stCategoryDao.findStCategoryMasterByLevelAndParentId(2, catLevel1.getCategoryId());
			StCategoryMaster catLavel2 = categoriesLevel2.iterator().next();
			level1.setCategoryId(catLevel1.getCategoryId()); //Hardcoded
			level2.setCategoryId(catLavel2.getCategoryId()); //Hardcoded
			portfolio.setStCategoryMasterByCatLevel1Id(level1);
			portfolio.setStCategoryMasterByCatLevel2Id(level2);
			portfolio.setSellable(0); //04232014 Fred - setup sellable to 0.
			portfolio = trPortfolioDao.merge(portfolio);
		}
		else
		{
			portfolio=trPortfolioDao.findTrPortfolioByPortfolioId(portfolioId);
		}
		int i=0;
		//Update or insert the record to TrBoard
		for(TrBoardDomain item : samples)
		{
			TrBoard board = new TrBoard();
			Set<TrBoardImages> imageSet = new HashSet<TrBoardImages>();
			TrBoardImages images = new TrBoardImages();
			//if board id is 0, update the portfolioId above.
			if(item.getBoardId() == 0)
			{
				//create the new board
				board.setBoardId(0);
				board.setTrPortfolio(portfolio);
				board.setActiveStatus(ActiveStatusEnum.INACTIVE.value()); //inactive
				board.setPublishToMp(Constants.PUBLISH_TO_MARKET_REVIEWING); //Reviewing
				board.setName(item.getName()); //hardcoded
				board.setDescription(item.getDescription()); //hardcoded
				board.setBoardPrice(new BigDecimal(1)); //hardcoded
				board.setTotalPrice(new BigDecimal(1)); //hardcoded
				board.setExpirationDate(Calendar.getInstance());
				board.setEffectiveDate(Calendar.getInstance());
				board.setKeyword(Constants.KEYWORD_TEMPLATE); // use template
				board.setLangCode("en-US");
				board.setAdUsersByCurrentUserId(adUsers);
				board.setAdUsersByOriginalUserId(adUsers);
				board.setCreatedBy(2); //System user
				board.setLastUpdatedBy(2); //System user
				board.setCreationDate(Calendar.getInstance());
				board.setLastUpdateDate(Calendar.getInstance());
				
				AdLookupValues value=new AdLookupValues();
				value.setLookupValueId(441); //jpg hardcoded
				board.setAdLookupValues(value);
				
				AdLookupValues adLookupValuesStatusId=new AdLookupValues();
				adLookupValuesStatusId.setLookupValueId(470); //available
				board.setAdLookupValuesStatusId(adLookupValuesStatusId);
				board=trBoardDAO.merge(board); //get board id
				trBoardDAO.flush();
			}
			else
			{
				//use the board is to retrieve the board data
				board = trBoardDAO.findTrBoardByBoardId(item.getBoardId());
				//check image is being updated or not
				if(board.getDescription().equals("rejected") && !board.getTrBoardImageses().iterator().next().getMainImageUrl().equals(item.getBoardImages().get(0).getMainImageUrl()))
					board.setDescription("");
				else if(board.getDescription().equals("rejected") && board.getTrBoardImageses().iterator().next().getMainImageUrl().equals(item.getBoardImages().get(0).getMainImageUrl()))
					incomplete = true;
				
				board=trBoardDAO.merge(board); //get board id
				trBoardDAO.flush();
				imageSet = board.getTrBoardImageses();
				images = imageSet.iterator().next();
				imageSet = board.getTrBoardImageses();
			}
			//update images
			for (TrBoardImagesDomain imagesdomain : item.getBoardImages()) 
			{
				images.setTrBoard(board);
				images.setFileName(imagesdomain.getFileName());
				images.setFileType(imagesdomain.getFileType());
				images.setMainImageUrl(imagesdomain.getMainImageUrl());
				images.setSourceFileUrl(imagesdomain.getSourceFileURL());
				images.setThumbnailUrl(imagesdomain.getThumbnailUrl());
				images.setCreatedBy(2); //System user
				images.setCreationDate(Calendar.getInstance()); //set creation date -C
				images.setLastUpatedBy(2); //System user
				images.setLastUpdateDate(Calendar.getInstance()); // -C
				imageSet.add(images);
			}
			board.setTrBoardImageses(imageSet);
			trBoardDAO.merge(board);
			trBoardDAO.flush();
			i++;
		}
		//if i >=3, it means the user have updated 3 samples, change the reg status to samples submission complete.
		if(i>=3 && !incomplete)
		{
			AdLookupValues submitCompleted = adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.SAMPLES_SUBMIT_COMPLETED.getTypeCode());
			adUsers.setAdLookupValuesByRegStatusId(submitCompleted);
			adUsers = adUsersDAO.merge(adUsers);
		}
		AdUsersDomain user = new AdUsersDomain();
		try {
			modelConverter.convertAdUsersEntityToDomain(adUsers, user);
			modelConverter.convertAdUsersEntityAssociationsToDomain(adUsers, user);
		} catch (DatatypeConfigurationException e) {
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			return response;
		}
		response.setUser(user);
		//setup response status
		response.setSamplesCount(i);
		if(incomplete) //if one of board is still rejected, do not set samples count larger than 3.
			response.setSamplesCount(2);
		return response;
	}
	
	public GetAllSamplesResponse getAllSamples()
	{
		GetAllSamplesResponse response = new GetAllSamplesResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		List<TrBoardDomain> samples = response.getSamples();
		Set<TrBoard> samplesSet = trBoardDAO.findTrBoardForSample(-1);
		for(TrBoard item : samplesSet)
		{
			try 
			{
				TrBoardDomain board = new TrBoardDomain();
				board = this.convertEntityToDomain(item);
				samples.add(board);
			}
			catch (DatatypeConfigurationException e) 
			{
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				status.setDescription("Board convertion failed.");
				return response;
			}
		}
		return response;
	}
	
	public GetSamplesByUserIdResponse getSamplesByUserId(GetSamplesByUserIdRequest request)
	{
		GetSamplesByUserIdResponse response = new GetSamplesByUserIdResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		List<TrBoardDomain> samples = response.getSamples();
		Set<TrBoard> samplesSet = trBoardDAO.findTrBoardForSampleByUserId(request.getUserId(), -1);
		for(TrBoard item : samplesSet)
		{
			try 
			{
				TrBoardDomain board = new TrBoardDomain();
				board = this.convertEntityToDomain(item);
				samples.add(board);
			}
			catch (DatatypeConfigurationException e) 
			{
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				status.setDescription("Board convertion failed.");
				return response;
			}
		}
		return response;
	}
	
	public ResubmitSamplesResponse resubmitSamples(ResubmitSamplesRequest request)
	{
		ResubmitSamplesResponse response = new ResubmitSamplesResponse();
		Status status = new Status();
		response.setStatus(status);
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		List<String> items = Arrays.asList(adminUserIdChain.split(","));
		if(items.contains(Integer.toString(request.getUserId()))) //check user has privilege of admin
		{
			
			//get the board detail
			TrBoard sample = trBoardDAO.findTrBoardByBoardId(request.getBoardId());
			//change the description
			sample.setDescription("rejected");
			trBoardDAO.merge(sample);
			trBoardDAO.flush();
			//change the user reg status to 431 (CF)
			AdUsers user = adUsersDAO.findAdUsersByUserId(sample.getAdUsersByOriginalUserId().getUserId());
			//if the user is already the approved the user, do not allow the admin to ask for resubmission.
			if(user.getAdLookupValuesByRegStatusId().getLookupCode().equals(LookupTypeValueEnum.REG_STATUS_CONFIRMED.getTypeCode()))
			{
				//Do not allow to ask for resubmission
				status.setStatuscode(StatusCodesEnum.STATUS_REQUEST_REJECTED.getCode());
				status.setDescription("Cannot ask for resubmission from approved user");
			}
			else
			{
				Set<AdLookupValues> regStatus = adLookupValuesDAO.findAdLookupValuesByLookupCode(LookupTypeValueEnum.REG_STATUS_COMPLETED_FORM.getTypeCode());
				user.setAdLookupValuesByRegStatusId(regStatus.iterator().next());
				adUsersDAO.merge(user);
				adUsersDAO.flush();
				//send the email to the user
				String mailSubject;
				String mailBody;
				
				//retrieve email template from ad_email_tamplates by code BOARD_APPROVED
				AdEmailTemplates templates=adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.TEMPLATE_CODE_RESUBMIT_SAMPLES);
				//Replace the variable on email template into appropriate content
				mailSubject=templates.getSubject().replace("$$3", sample.getName());
				mailBody=templates.getBody().replace("$$2", sample.getAdUsersByOriginalUserId().getFirstname()+" "+sample.getAdUsersByOriginalUserId().getLastname());
				mailBody=mailBody.replace("$$3", sample.getName());
				mailBody=mailBody.replace("$$4", request.getInstance().getComments());
				
				TrNotificationsQ trNotificationsQ=new TrNotificationsQ();
				trNotificationsQ.setFromUserId(2); //system user
				trNotificationsQ.setToUserId(sample.getAdUsersByOriginalUserId().getUserId());
				trNotificationsQ.setFromEmail(this.adminMailAddress);
				trNotificationsQ.setToEmail(sample.getAdUsersByOriginalUserId().getUserName());
				trNotificationsQ.setSubject(mailSubject);
				trNotificationsQ.setBodyText(mailBody);
				trNotificationsQ.setCreatedBy(2); //system user
				trNotificationsQ.setLastUpdatedBy(2); //system user
				//set email status to ready to send
				AdLookupValues readyToSend=adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.EMAIL_STATUS_READY_TO_SEND.getTypeCode());
				trNotificationsQ.setAdLookupValues(readyToSend);
				//insert record to tr_notifications-q table
				trNotificationsQDAO.merge(trNotificationsQ);
			}
		}
		else
		{
			status.setStatuscode(StatusCodesEnum.STATUS_UNAUTHORIZED_USER.getCode());
			status.setDescription("Unauthorized user, only administrator can access");
		}
		return response;
	}
	
	public ReturnSubmissionsResponse returnSubmissions(ReturnSubmissionsRequest request)
	{
		ReturnSubmissionsResponse response = new ReturnSubmissionsResponse();
		Status status = new Status();
		response.setStatus(status);
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		//get contest information by portfolioId
		TrPortfolioContest contest=trPortfolioContestDAO.findTrPortfolioContestByPortfolioId(request.getTargetPortfolioId(), -1, -1);
		//get all board related to the portfolio
		Set<TrBoard> boards=trBoardDAO.findTrBoardByPortfolioId(request.getTargetPortfolioId());
		//key: designerUserId; value: portfolioId will be created to return their submissions.
		HashMap<Integer,TrPortfolio> newPortfolioHM=new LinkedHashMap<Integer, TrPortfolio>();
		for(TrBoard board:boards)
		{
			//check the returnPortfolioIdHM key by designer userId, if the key is not existed, create the new portfolio for this designer	
			if(!newPortfolioHM.containsKey(board.getAdUsersByOriginalUserId().getUserId()))
			{
				//create the new portfolio
				TrPortfolio newPortfolio=new TrPortfolio();
				newPortfolio.setAdUsers(board.getAdUsersByOriginalUserId()); //owner is the designer
				newPortfolio.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
				newPortfolio.setCreatedBy(2); //system user
				newPortfolio.setLastUpdatedBy(2); //system user
				newPortfolio.setName(request.getNewPortfolio().getName()); //from request newPortfolio domain
				newPortfolio.setDescription(request.getNewPortfolio().getDescription()); //from request newPortfolio domain
				newPortfolio.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
				newPortfolio.setCreationDate(Calendar.getInstance());
				newPortfolio.setLastUpdateDate(Calendar.getInstance());
				newPortfolio.setSellable(Constants.PORTFOLIO_SELLABLE); //back to sellable portfolio (Marketplace collection)
				newPortfolio.setStCategoryMasterByCatLevel1Id(contest.getTrPortfolio().getStCategoryMasterByCatLevel1Id());
				newPortfolio.setStCategoryMasterByCatLevel2Id(contest.getTrPortfolio().getStCategoryMasterByCatLevel2Id());
				newPortfolio.setStSeasonYear(contest.getTrPortfolio().getStSeasonYear());
				newPortfolio=trPortfolioDao.merge(newPortfolio);
				//enter portfolioId to the hashmap
				newPortfolioHM.put(board.getAdUsersByOriginalUserId().getUserId(), newPortfolio);
				//add portfolio to the response
				TrPortfolioDomain portfolioDomain=new TrPortfolioDomain();
				portfolioDomain=modelConverter.convertEntityToDomain(newPortfolio);
				response.getPortfolio().add(portfolioDomain);
				//send notification to the designer by sendNotification flag
				if(request.isSendNotification())
				{
					//send email to the user
					AdEmailTemplates emailTemp = adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(Constants.TEMPLATE_CODE_RETURN_SUBMISSIONS);
					//replace the variables from emailTemp
					String mailSubject;
					String mailBody;
					String projectId=ProjectFormatter.projectIdFormatter(contest.getProjectType(), contest.getTrPortfolio().getPortfolioId(), contest.getContestId());
					mailSubject=emailTemp.getSubject().replace("$$1", projectId); //project id
					mailBody=emailTemp.getBody().replace("$$1", projectId); //project name
					mailBody=mailBody.replace("$$2", board.getAdUsersByOriginalUserId().getFirstname()+" "+board.getAdUsersByOriginalUserId().getLastname()); //designer name
					//mailBody=mailBody.replace("$$3", newPortfolio.getName()); //targetPortfolio name
					//insert record to Tr_notification_q table.
					TrNotificationsQ trNotificationsQ=new TrNotificationsQ();
					trNotificationsQ.setFromUserId(2); //system user
					trNotificationsQ.setToUserId(board.getAdUsersByOriginalUserId().getUserId());
					trNotificationsQ.setFromEmail(this.adminMailAddress);
					trNotificationsQ.setToEmail(board.getAdUsersByOriginalUserId().getUserName());
					trNotificationsQ.setSubject(mailSubject);
					trNotificationsQ.setBodyText(mailBody);
					trNotificationsQ.setCreatedBy(2); //system user
					trNotificationsQ.setLastUpdatedBy(2); //system user
					//set email status to ready to send
					AdLookupValues readyToSend=adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.EMAIL_STATUS_READY_TO_SEND.getTypeCode());
					trNotificationsQ.setAdLookupValues(readyToSend);
					//insert record to tr_notifications-q table
					trNotificationsQDAO.merge(trNotificationsQ);
				}
			}
			//retrieve the newPortfolioId from the hashmap to store the boards.
			board.setTrPortfolio(newPortfolioHM.get(board.getAdUsersByOriginalUserId().getUserId())); //update portfolio to the new portfolio
			board.setKeyword(contest.getCategory());
			board.setBoardPrice(new BigDecimal(request.getTargetBoardPrice()));
			board.setTotalPrice(new BigDecimal(request.getTargetBoardPrice()));
			//board.setPublishToMp(Constants.PUBLISH_TO_MARKET_YES); //Has to keep in the same status.
			board.setLastUpdatedBy(2); //change to system user so that we can update PublishToMP flag
			board=trBoardDAO.merge(board);
		}
		trBoardDAO.flush();
		return response;
	}
}