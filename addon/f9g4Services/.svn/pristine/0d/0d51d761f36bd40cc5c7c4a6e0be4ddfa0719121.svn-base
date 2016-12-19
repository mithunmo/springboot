package com.f9g4.services;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrPortfolioContestDomain;
import com.f9g4.businessobjects.domain.TrPortfolioContestMembersDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.domain.TrPortfolioImagesDomain;
import com.f9g4.businessobjects.services.AddPortfolioRequest;
import com.f9g4.businessobjects.services.AddPortfolioResponse;
import com.f9g4.businessobjects.services.AssignMembersToContestRequest;
import com.f9g4.businessobjects.services.AssignMembersToContestResponse;
import com.f9g4.businessobjects.services.CreateContestRequest;
import com.f9g4.businessobjects.services.CreateContestResponse;
import com.f9g4.businessobjects.services.DeletePortfolioByIdResponse;
import com.f9g4.businessobjects.services.EditContestRequest;
import com.f9g4.businessobjects.services.EditContestResponse;
import com.f9g4.businessobjects.services.GetAllContestsResponse;
import com.f9g4.businessobjects.services.GetContestByUserIdResponse;
import com.f9g4.businessobjects.services.GetContestDetailsResponse;
import com.f9g4.businessobjects.services.GetContestMembersResponse;
import com.f9g4.businessobjects.services.GetPortfolioByIdResponse;
import com.f9g4.businessobjects.services.GetPortfolioByUserResponse;
import com.f9g4.businessobjects.services.UpdatePortfolioRequest;
import com.f9g4.businessobjects.services.UpdatePortfolioResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.dao.AdLookupValuesDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.TrBoardDAO;
import com.f9g4.dao.TrPortfolioContestDAO;
import com.f9g4.dao.TrPortfolioContestMembersDAO;
import com.f9g4.dao.TrPortfolioDAO;
import com.f9g4.dao.TrPortfolioImagesDAO;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.StCategoryMaster;
import com.f9g4.domain.StSeasonYear;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrPortfolio;
import com.f9g4.domain.TrPortfolioContest;
import com.f9g4.domain.TrPortfolioContestMembers;
import com.f9g4.domain.TrPortfolioImages;
import com.f9g4.services.rest.IPortfolioService;
import com.f9g4.util.ModelConverter;

@Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
public class PortfolioServiceImpl implements IPortfolioService {

	private static final Logger logger = LoggerFactory.getLogger(PortfolioServiceImpl.class);
	@Autowired
	private TrPortfolioDAO portfolioDAO;
	
	@Autowired
	private TrPortfolioContestDAO contestDAO;
	
	@Autowired
	private TrPortfolioContestMembersDAO memberDAO;
	@Autowired
	private AdUsersDAO adUsersDAO;
	
	@Autowired
	private TrPortfolioImagesDAO portfolioImagesDAO;
	
	@Autowired
	private TrBoardDAO trBoardDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;
	
	@Autowired
	private ModelConverter modelConverter;

	public AddPortfolioResponse addPortfolio(AddPortfolioRequest request) {
		AddPortfolioResponse response = new AddPortfolioResponse();
		Status responseStatus = new Status();
		if (null == request.getPortfolio()) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");
		} else {
			try {
				TrPortfolio trPortfolio = new TrPortfolio();
				this.convertDomaintoEnity(request.getPortfolio(),trPortfolio, false);
				TrPortfolio responseObj = portfolioDAO.merge(trPortfolio);
				portfolioDAO.flush();
				//add images to tr_portfolio_images table
				for(TrPortfolioImagesDomain item : request.getPortfolio().getPortfolioImages())
				{
					TrPortfolioImages entity = modelConverter.convertTrPortfolioImagesDomainToEntity(item);
					entity.setTrPortfolio(responseObj);
					portfolioImagesDAO.merge(entity);
				}
				portfolioDAO.refresh(responseObj); //refresh the object to retrieve the images.
				response.setPortfolio(this.convertEntityToDomain(responseObj));
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Exception e) {
				logger.error("Exception occurred" ,e);
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}
	
	public GetContestMembersResponse getContestMembers(int portfolioid){
		GetContestMembersResponse response = new GetContestMembersResponse();
		Status responseStatus = new Status();
		if ( portfolioid <= 0 ) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");
		
		} else {
			
			Set<TrPortfolioContestMembers> memberList = memberDAO.findAllActiveContestMembersByPortfolioId(portfolioid, -1, -1);
			List<TrPortfolioContestMembersDomain> memberDomain = response.getMember();
			
			for (TrPortfolioContestMembers item : memberList ){
				TrPortfolioContestMembersDomain memberDomainItem = new TrPortfolioContestMembersDomain();
				memberDomainItem.setActiveStatus(item.getActiveStatus());
				memberDomainItem.setPortfolioId(item.getTrPortfolio().getPortfolioId());
				memberDomainItem.setUserId(item.getAdUser().getUserId());
				AdUsersDomain userDomain=new AdUsersDomain();
				try {
					modelConverter.convertAdUsersEntityToDomain(item.getAdUser(), userDomain);
				} catch (Exception e) {
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
					responseStatus.setDescription("Fail to convert");
					break;
				}
				memberDomainItem.setUserDomain(userDomain);
				memberDomainItem.setContestMembersId(item.getContesMembersId());
				memberDomainItem.setCreatedby(item.getCreatedBy());
				memberDomainItem.setLastupdateby(item.getLastUpatedBy());
				memberDomain.add(memberDomainItem);
			}
			
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());

		}	
		response.setStatus(responseStatus);
		return response;
	}
	
	public AssignMembersToContestResponse assignMembersToContest(AssignMembersToContestRequest request){
		AssignMembersToContestResponse response = new AssignMembersToContestResponse();
		Status responseStatus = new Status();
		if (null == request.getMember() || request.getPortfolioid() <= 0 ) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");
		
		} else {
		
			try{
				
				Set<Integer> contestMemberList = memberDAO.findAllContestMembersByPortfolioId(request.getPortfolioid(), -1, -1); 
				for (TrPortfolioContestMembersDomain item : request.getMember()){				
						if (contestMemberList.contains(item.getUserId()) ) {						
								TrPortfolioContestMembers memberUpdate = memberDAO.findContestMembersByPortfolioIdAndUserId(item.getPortfolioId(), item.getUserId(), -1, -1);
								contestMemberList.remove(item.getUserId());
								memberUpdate.setActiveStatus(item.getActiveStatus());
								memberUpdate.setTrPortfolio(portfolioDAO.findTrPortfolioByPortfolioId(item.getPortfolioId()));
								memberUpdate.setAdUser( adUsersDAO.findAdUsersByUserId(item.getUserId()));
								memberUpdate.setLastUpatedBy(item.getLastupdateby());
								memberUpdate.setLastUpdateDate(Calendar.getInstance());				
								memberDAO.merge(memberUpdate);
								memberDAO.flush();
								memberDAO.refresh(memberUpdate);
						} else {
							
							TrPortfolioContestMembers memberItem = new TrPortfolioContestMembers();
							memberItem.setActiveStatus(item.getActiveStatus());
							memberItem.setTrPortfolio(portfolioDAO.findTrPortfolioByPortfolioId(item.getPortfolioId()));
							memberItem.setAdUser( adUsersDAO.findAdUsersByUserId(item.getUserId()));
							memberItem.setCreatedBy(item.getCreatedby());
							memberItem.setLastUpatedBy(item.getLastupdateby());
							memberItem.setCreationDate(Calendar.getInstance());
							memberItem.setLastUpdateDate(Calendar.getInstance());
							memberDAO.merge(memberItem);
						}		
				}
				
				for (Integer userDelete : contestMemberList ) {
					TrPortfolioContestMembers memberDelete = memberDAO.findContestMembersByPortfolioIdAndUserId(request.getPortfolioid(), userDelete, -1, -1);
					memberDelete.setActiveStatus(0);
					memberDelete.setLastUpdateDate(Calendar.getInstance());				
					memberDAO.merge(memberDelete);
					memberDAO.flush();
					memberDAO.refresh(memberDelete);
				}
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());	
			} catch(Exception e){
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				
			}
		}
		response.setStatus(responseStatus);
		return response;
	}
	
	public EditContestResponse editContest(EditContestRequest request) {
		EditContestResponse response = new EditContestResponse();
		Status responseStatus = new Status();
		if (null == request.getContest()) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");
		} else {
			try {
			
				TrPortfolio trPortfolio = portfolioDAO.findTrPortfolioByPortfolioId(request.getContest().getContestPortfolioDomain().getPortfolioId());
				TrPortfolioContest trPortfolioContest = contestDAO.findTrPortfolioContestByPortfolioId(request.getContest().getContestPortfolioDomain().getPortfolioId(), 0, 1);
							
				this.convertDomaintoEnity(request.getContest().getContestPortfolioDomain(), trPortfolio, true);
				portfolioDAO.merge(trPortfolio);
				portfolioDAO.flush();
				portfolioDAO.refresh(trPortfolio);
				
				//update portfolio images
				//add images to tr_portfolio_images table
				for(TrPortfolioImagesDomain item : request.getContest().getContestPortfolioDomain().getPortfolioImages())
				{
					TrPortfolioImages imgEntity = modelConverter.convertTrPortfolioImagesDomainToEntity(item);
					imgEntity.getTrPortfolio().setLangCode(trPortfolio.getLangCode());
					imgEntity.setTrPortfolio(trPortfolio);
					portfolioImagesDAO.merge(imgEntity);
					portfolioImagesDAO.flush();
				}
				
				this.convertContestDomaintoEntity(request.getContest(), trPortfolioContest, true);
				contestDAO.merge(trPortfolioContest);
				contestDAO.flush();
				contestDAO.refresh(trPortfolioContest);
				
				TrPortfolioContestDomain contestDomain= request.getContest();
				this.convertContestEntityToDomain(contestDomain, trPortfolio, trPortfolioContest);
				response.setContest(contestDomain);
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Exception e){
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			}
			
		}
		response.setStatus(responseStatus);
		return response;

	}	
	
	public GetAllContestsResponse getAllContests(){
		GetAllContestsResponse response = new GetAllContestsResponse();
		Status responseStatus = new Status();
		
		Set<TrPortfolioContest> contestList = contestDAO.findAllTrPortfolioContests();
		
		List<TrPortfolioContestDomain> contests  = response.getContest();
		try {
			for ( TrPortfolioContest item : contestList){
				
				TrPortfolio portfolioItem = portfolioDAO.findTrPortfolioByPortfolioId(item.getTrPortfolio().getPortfolioId());
				TrPortfolioContestDomain contestDomain = new TrPortfolioContestDomain();
				this.convertContestEntityToDomain(contestDomain, portfolioItem, item);
				contests.add(contestDomain);
				
			}
			
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		} catch (Exception e){
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		response.setStatus(responseStatus);
		return response;
	}
	
	public CreateContestResponse createContest(CreateContestRequest request) {
		
		CreateContestResponse response = new CreateContestResponse();
		Status responseStatus = new Status();
		if (null == request.getContest()) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("No Contest Details");
		} else {
			
			try {
				TrPortfolio trPortfolio = new TrPortfolio();
				this.convertDomaintoEnity(request.getContest().getContestPortfolioDomain(),trPortfolio, false);
				TrPortfolio responseObj = portfolioDAO.merge(trPortfolio);
				portfolioDAO.flush();
							
				TrPortfolioContest contest = new TrPortfolioContest();
				this.convertContestDomaintoEntity(request.getContest(),contest, false);
				contest.setTrPortfolio(responseObj);
				TrPortfolioContest rr = contestDAO.merge(contest);
				contestDAO.flush();
				
				TrPortfolioContestDomain contestDomain = new  TrPortfolioContestDomain();
				this.convertContestEntityToDomain(contestDomain, responseObj, rr);
				response.setContest(contestDomain);			
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch ( Exception e){
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());				
			}
			
		}	
		response.setStatus(responseStatus);
		return response;
		
	}
	
	public GetContestDetailsResponse getContestDetails(int portfolioId,int contestId){
		GetContestDetailsResponse response = new GetContestDetailsResponse();
		Status responseStatus = new Status();
		response.setStatus(responseStatus);
		
		try{		
			if ( portfolioId <= 0 || contestId <= 0 ){
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
				responseStatus.setDescription("Valid ID required");
				
			} else {
				TrPortfolioContestDomain contestDomain = new TrPortfolioContestDomain();
				TrPortfolioContest contest = contestDAO.findTrPortfolioByContestIdAndPortfolioId(portfolioId, contestId, -1, -1);
				TrPortfolio portfolioItem = portfolioDAO.findTrPortfolioByPortfolioId(contest.getTrPortfolio().getPortfolioId());						
				this.convertContestEntityToDomain(contestDomain, portfolioItem, contest);
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
				response.setContest(contestDomain);
				
			}
		} catch ( Exception e){
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());				
		}

		return response;
	}
	
	public GetContestByUserIdResponse getContestByUserId(int userId){
		GetContestByUserIdResponse response = new GetContestByUserIdResponse();
		Status responseStatus = new Status();

		if (userId <= 0) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");

		} else {
		
			try {
				
				AdUsers user = adUsersDAO.findAdUsersByUserId(userId);
				List<TrPortfolioContestDomain> contestList  = response.getContest();		
				if ( user.getAdLookupValuesByUserTypeId().getLookupCode().equals(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode()) ){
		
					Set<TrPortfolioContestMembers> memberlist = memberDAO.findAllTrPortfolioByUserId(userId, -1, -1);
					for ( TrPortfolioContestMembers item :  memberlist ){
										
						TrPortfolioContestMembersDomain memberContestDomain = new TrPortfolioContestMembersDomain();
						
						memberContestDomain.setUserId(item.getAdUser().getUserId());
						memberContestDomain.setPortfolioId(item.getTrPortfolio().getPortfolioId());
						memberContestDomain.setActiveStatus(item.getActiveStatus());
						
						TrPortfolioContestDomain contestDomain = new TrPortfolioContestDomain();
		
						TrPortfolio portfolioItem = portfolioDAO.findTrPortfolioByPortfolioId(item.getTrPortfolio().getPortfolioId());
						
						TrPortfolioContest contest = contestDAO.findTrPortfolioContestByPortfolioId(item.getTrPortfolio().getPortfolioId(), -1, -1);
						
						this.convertContestEntityToDomain(contestDomain, portfolioItem, contest);
						contestDomain.setContestMemberDomain(memberContestDomain);
						//Fred 11/11/2014 - convert adUsers entity to domain
						AdUsers portfolioUser = adUsersDAO.findAdUsersByUserId(portfolioItem.getAdUsers().getUserId());
						AdUsersDomain portfolioUserDomain = new AdUsersDomain();
						contestDomain.getContestPortfolioDomain().setUser(portfolioUserDomain);;
						modelConverter.convertAdUsersEntityToDomain(portfolioUser, portfolioUserDomain);
						contestList.add(contestDomain);
					}
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
				} else {
					
					Set<TrPortfolio> portfolioList =  portfolioDAO.findTrPortfolioByUserIdAndSellable(userId,0);			
					for ( TrPortfolio item :  portfolioList ){
						TrPortfolioContestDomain contestDomain = new TrPortfolioContestDomain();
						TrPortfolioContest contest = contestDAO.findTrPortfolioContestByPortfolioId(item.getPortfolioId(), -1, -1);				
						this.convertContestEntityToDomain(contestDomain, item, contest);								
						contestList.add(contestDomain);
						
					}
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
				}
		} catch (Exception e) {
			logger.error("Exception occurred" ,e);
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			responseStatus.setDescription("Unknown Error Occured");
		}
	
			
		}	
		response.setStatus(responseStatus);	
		return response; 
	}
	
	public UpdatePortfolioResponse updatePortfolio(UpdatePortfolioRequest request){
		UpdatePortfolioResponse response = new UpdatePortfolioResponse();
		Status responseStatus = new Status();
		if (null == request.getPortfolio()) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");
		} else {
			try {
				
				TrPortfolio trPortfolio = portfolioDAO.findTrPortfolioByPortfolioId(request.getPortfolio().getPortfolioId());
				//TODO now we don't allow the user change the info on portfolio level.
				//this.convertDomaintoEnity(request.getPortfolio(),trPortfolio, true);
				//TrPortfolio responseObj = portfolioDAO.merge(trPortfolio);
				
				//update portfolio images
				//add images to tr_portfolio_images table
				for(TrPortfolioImagesDomain item : request.getPortfolio().getPortfolioImages())
				{
					TrPortfolioImages entity = modelConverter.convertTrPortfolioImagesDomainToEntity(item);
					entity.getTrPortfolio().setLangCode(trPortfolio.getLangCode());
					entity.setTrPortfolio(trPortfolio);
					portfolioImagesDAO.merge(entity);
					portfolioImagesDAO.flush();
				}
				portfolioDAO.refresh(trPortfolio); //refresh the object to retrieve the images.
				response.setPortfolio(this.convertEntityToDomain(trPortfolio));
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Exception e) {
				logger.error("Exception occurred" ,e);
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}
	public GetPortfolioByIdResponse getPortfoliobyId(int portfolioid) {
		GetPortfolioByIdResponse response = new GetPortfolioByIdResponse();
		Status responseStatus = new Status();
		if (portfolioid <= 0) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				TrPortfolio portfolio = portfolioDAO.findTrPortfolioByPrimaryKey(portfolioid);
				response.setPortfolio(this.convertEntityToDomain(portfolio));
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Exception e) {
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}

	public GetPortfolioByUserResponse getPortfoliobyUser(int userid) {
		GetPortfolioByUserResponse responselist = new GetPortfolioByUserResponse();
		Status responseStatus = new Status();

		if (userid <= 0) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				Set<TrPortfolio> usersPortfolio = portfolioDAO.findTrPortfolioByUserId(userid);

				for (TrPortfolio trPortfolio : usersPortfolio) {
					//update boards under portfolio using query (filter out the board is being sold)
					Set<TrBoard> boards=trBoardDAO.findTrBoardByPortfolioId(trPortfolio.getPortfolioId());
					trPortfolio.setTrBoards(boards);
					responselist.getPortfolio().add(this.convertEntityToDomain(trPortfolio));
				}
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Exception e) {
				logger.error("Exception occurred" ,e);
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}

		//set the status into GetPortfolioByUserResponse object
		responselist.setStatus(responseStatus);
		return responselist;

	}
	
	public GetPortfolioByUserResponse getUnsellablePortfoliobyUser(int userid) {
		GetPortfolioByUserResponse responselist = new GetPortfolioByUserResponse();
		Status responseStatus = new Status();

		if (userid <= 0) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				Set<TrPortfolio> usersPortfolio = portfolioDAO.findUnsellableTrPortfolioByUserId(userid);

				for (TrPortfolio trPortfolio : usersPortfolio) {
					//update boards under portfolio using query (filter out the board is being sold)
					Set<TrBoard> boards=trBoardDAO.findTrBoardByPortfolioId(trPortfolio.getPortfolioId());
					trPortfolio.setTrBoards(boards);
					responselist.getPortfolio().add(this.convertEntityToDomain(trPortfolio));
				}
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			} catch (Exception e) {
				logger.error("Exception occurred" ,e);
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}

		//set the status into GetPortfolioByUserResponse object
		responselist.setStatus(responseStatus);
		return responselist;

	}

	public DeletePortfolioByIdResponse deletePortfolioById(int portfolioid) {
		DeletePortfolioByIdResponse response = new DeletePortfolioByIdResponse();
		Status responseStatus = new Status();
		if (portfolioid <= 0) {
			responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_INVALID_INPUT.getCode());
			responseStatus.setDescription("Valid ID required");
		} else {
			try {
				//check all board is in the status 470
				Long boardStatusCount=portfolioDAO.checkBoardStatusByPortfolioId(portfolioid);
				if(boardStatusCount>0)
				{
					//means one of board is being processed, stop user to delete it
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_BOARD_UNDER_PROCESSED.getCode());
					responseStatus.setDescription("One of board is being processed");
				}
				else
				{
					TrPortfolio portfolio = portfolioDAO.findTrPortfolioByPortfolioId(portfolioid);
					Set<TrBoard> boardsinPortfolio = trBoardDAO.findTrBoardByPortfolioId(portfolioid);
					for (TrBoard trBoard : boardsinPortfolio) {
						trBoard.setActiveStatus(0);
						trBoard.setPublishToMp(0);
						trBoardDAO.merge(trBoard);
					}
					portfolio.setActiveStatus(0);
					portfolioDAO.merge(portfolio);
					responseStatus.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
				}
			} catch (Exception e) {
				logger.error("Exception occurred" ,e);
				responseStatus.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}
	
	private TrPortfolioDomain convertEntityToDomain(TrPortfolio portfolio) {
		TrPortfolioDomain portfoliodomain = new TrPortfolioDomain();
		portfoliodomain.setActiveStatus(portfolio.getActiveStatus());
		portfoliodomain.setUserId(portfolio.getAdUsers().getUserId());
		portfoliodomain.setCreatedby(portfolio.getCreatedBy());
		portfoliodomain.setDescription(portfolio.getDescription());
		portfoliodomain.setLangCode(portfolio.getLangCode());
		portfoliodomain.setLastupdateby(portfolio.getLastUpdatedBy());
		portfoliodomain.setName(portfolio.getName());
		portfoliodomain.setPortfolioId(portfolio.getPortfolioId());
		portfoliodomain.setCategoryLevel1Id(portfolio.getStCategoryMasterByCatLevel1Id().getCategoryId());
		portfoliodomain.setCategoryLevel2Id(portfolio.getStCategoryMasterByCatLevel2Id().getCategoryId());
		portfoliodomain.setCategoryLevel1(portfolio.getStCategoryMasterByCatLevel1Id().getName());
		portfoliodomain.setCategoryLevel2(portfolio.getStCategoryMasterByCatLevel2Id().getName());
		portfoliodomain.setSeasonYearId(portfolio.getStSeasonYear().getSeasonYearId());
		AdUsersDomain adUsersDomain = new AdUsersDomain();
		try {
			modelConverter.convertAdUsersEntityToDomain(portfolio.getAdUsers(), adUsersDomain);
			portfoliodomain.setUser(adUsersDomain);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
		}
		List<TrBoardDomain> boards=portfoliodomain.getBoards();
		try
		{
			modelConverter.convertTrBoardEntityToDomain(portfolio.getTrBoards(), boards);
		}
		catch(Exception e)
		{
			logger.error("Exception occurred" ,e);
		}
		// convert trPortfolioImages
		List<TrPortfolioImagesDomain> portfolioImages=portfoliodomain.getPortfolioImages();
		try
		{
			portfolioImages.addAll(modelConverter.convertTrPortfolioImagesEntityToDomain(portfolio.getTrPortfolioImages()));
		}
		catch(Exception e)
		{
			logger.error("Exception occurred" ,e);
		}
		//set boards to domain  -C==================================================================
		/*List<TrBoardDomain> domain=portfoliodomain.getBoards();
		Set<TrBoard> boards=portfolio.getTrBoards();
		
		while(boards.iterator().hasNext())
		{
			logger.trace("IN LOOP");
			TrBoardDomain boardDomain=convertEntityToDomain(boards.iterator().next());
			domain.add(boardDomain);
		}*/
		portfoliodomain.setSellable(portfolio.getSellable()); //04222014 Fred - convert sellable value
		return portfoliodomain;
	}
	
	private void convertContestEntityToDomain(TrPortfolioContestDomain contestDomain, TrPortfolio portfolio, TrPortfolioContest contest){
		
		contestDomain.setContestId(contest.getContestId());
		contestDomain.setPortfolioId(contest.getTrPortfolio().getPortfolioId());
		contestDomain.setCategory(contest.getCategory());
		contestDomain.setIntroduction(contest.getIntroduction());
		contestDomain.setProjectStatus(contest.getProjectStatus());
		contestDomain.setProjectType(contest.getProjectType());
		contestDomain.setAssociatedBrandsHangWith(contest.getAssociatedBrandsHangWith());
		contestDomain.setAssociatedBrandsInfluence(contest.getAssociatedBrandsInfluence());
		contestDomain.setNumberOfWinners(contest.getNumberOfWinners());
		contestDomain.setOtherInformation(contest.getOtherInformation());
		contestDomain.setDeliverable(contest.getDeliverable());
		if(contest.getAdLookupValuesDimension()!=null)
		{
			contestDomain.setBoardDimension(contest.getAdLookupValuesDimension().getLookupValueId());
			AdLookupValuesDomain boardDimensionDomain=new AdLookupValuesDomain();
			contestDomain.setBoardDimensionDomain(boardDimensionDomain);
			modelConverter.convertAdLookupValuesEntityToDomain(contest.getAdLookupValuesDimension(), boardDimensionDomain);
		}
		if(contest.getAdLookupValuesFormat()!=null)
		{
			contestDomain.setBoardFormat(contest.getAdLookupValuesFormat().getLookupValueId());
			AdLookupValuesDomain boardFormatDomain=new AdLookupValuesDomain();
			contestDomain.setBoardFormatDomain(boardFormatDomain);
			modelConverter.convertAdLookupValuesEntityToDomain(contest.getAdLookupValuesFormat(), boardFormatDomain);
		}
		try {
		contestDomain.setStartDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(contest.getStartDate()));
		contestDomain.setEndDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(contest.getEndDate()));
		}
		catch(Exception e){
			
		}
		contestDomain.setContestPortfolioDomain(this.convertEntityToDomain(portfolio));
		contestDomain.setLangCode(contest.getLangCode());
	}
	
	
	private void convertDomaintoEnity(TrPortfolioDomain domain, TrPortfolio portfolio, boolean forUpdate) {
		
		Calendar today = Calendar.getInstance();
		if(forUpdate){
			portfolio.setPortfolioId(domain.getPortfolioId());
		}else{
			portfolio.setCreatedBy(domain.getCreatedby());
			portfolio.setCreationDate(today);			
		}
		
		portfolio.setActiveStatus(domain.getActiveStatus());
		AdUsers users = new AdUsers();
		users.setUserId(domain.getUserId());
		portfolio.setAdUsers(users);
		
		portfolio.setDescription(domain.getDescription());
		portfolio.setLangCode(domain.getLangCode());
		portfolio.setLastUpdateDate(today);
		portfolio.setLastUpdatedBy(domain.getLastupdateby());
		portfolio.setName(domain.getName());
		portfolio.setLangCode(domain.getLangCode());
		
		StCategoryMaster cat1 = new StCategoryMaster();
		cat1.setCategoryId(domain.getCategoryLevel1Id());
		portfolio.setStCategoryMasterByCatLevel1Id(cat1);
		
		StCategoryMaster cat2 = new StCategoryMaster();
		cat2.setCategoryId(domain.getCategoryLevel2Id());
		portfolio.setStCategoryMasterByCatLevel2Id(cat2);

		StSeasonYear season = new StSeasonYear();
		season.setSeasonYearId(domain.getSeasonYearId());
		portfolio.setStSeasonYear(season);
		
		portfolio.setSellable(domain.getSellable()); //04222014 Fred - convert sellable value
		
	}

	private void convertContestDomaintoEntity(TrPortfolioContestDomain domain, TrPortfolioContest contest, boolean forUpdate ){

		Calendar today = Calendar.getInstance();
		if(forUpdate){
			contest.setContestId(domain.getContestId());
		}else{
			contest.setCreatedBy(domain.getCreatedby());
			contest.setCreationDate(today);			
		}
		contest.setCategory(domain.getCategory());
		contest.setIntroduction(domain.getIntroduction());
		contest.setProjectStatus(domain.getProjectStatus());
		contest.setProjectType(domain.getProjectType());
		contest.setStartDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getStartDate()));
		contest.setEndDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getEndDate()));
		contest.setLangCode(domain.getLangCode());
		contest.setLastUpatedBy(domain.getLastupdateby());
		contest.setLastUpdateDate(today);
		contest.setAssociatedBrandsHangWith(domain.getAssociatedBrandsHangWith());
		contest.setAssociatedBrandsInfluence(domain.getAssociatedBrandsInfluence());
		contest.setOtherInformation(domain.getOtherInformation());
		contest.setDeliverable(domain.getDeliverable());
		contest.setAdLookupValuesDimension(adLookupValuesDAO.findAdLookupValuesByLookupValueId(domain.getBoardDimension()));
		contest.setAdLookupValuesFormat(adLookupValuesDAO.findAdLookupValuesByLookupValueId(domain.getBoardFormat()));
		contest.setNumberOfWinners(domain.getNumberOfWinners());
		
		
	}

	
}