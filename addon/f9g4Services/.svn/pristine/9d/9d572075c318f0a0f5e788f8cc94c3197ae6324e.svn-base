package com.f9g4.services;

import java.util.Calendar;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdActiveUserDomain;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardRequest;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardResponse;
import com.f9g4.businessobjects.services.AddUserLogRequest;
import com.f9g4.businessobjects.services.AddUserLogResponse;
import com.f9g4.businessobjects.services.GetActiveuserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.dao.AdActiveUsersDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.TrBoardDAO;
import com.f9g4.dao.TrRecentlyViewedDAO;
import com.f9g4.domain.AdActiveUsers;
import com.f9g4.domain.TrRecentlyViewed;
import com.f9g4.services.rest.IDataCaptureService;
import com.f9g4.util.DateUtil;

@Service("dataCaptureService")
public class DataCaptureServiceImpl implements IDataCaptureService {

	@Autowired
	private TrRecentlyViewedDAO recentlyViewdDao;
	
	@Autowired
	private AdActiveUsersDAO activeUserDao;
	
	@Autowired
	private AdUsersDAO userDao;
	
	@Autowired
	private TrBoardDAO trboardDao;
	public AddRecentlyViewedBoardResponse addRecentlyViewBoard(AddRecentlyViewedBoardRequest request) {

		AddRecentlyViewedBoardResponse response= new AddRecentlyViewedBoardResponse();
		Status status=new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		status.setDescription("Success");
		response.setStatus(status);

		TrRecentlyViewed entity=new TrRecentlyViewed();
		entity.setAdUsers(userDao.findAdUsersByUserId(request.getLogBoard().getUserId()));
		entity.setCreatedBy(request.getLogBoard().getUserId());
		try {
			if(request.getLogBoard().getEventTime()!=null)
				entity.setEventTimestamp(DateUtil.fromXMLGregorianCalendar(request.getLogBoard().getEventTime()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setTrBoard(trboardDao.findTrBoardByBoardId(request.getLogBoard().getBoardId()));
		entity.setCreatedBy(request.getLogBoard().getCreatedby());
		try {
			recentlyViewdDao.merge(entity);
		} catch (Exception e) {
			// TODO: handle exception
			status.setDescription("failed");
			status.setStatuscode("1");
		}
		
		return response;
	}

	public AddUserLogResponse logUserData(AddUserLogRequest request) {
		
		AddUserLogResponse response = new AddUserLogResponse();
		Status status=new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		status.setDescription("Success");
		response.setStatus(status);
		try{
			
			AdActiveUserDomain adActiveUserDomain = request.getUserLogger();
			if(Constants.ADD_USER_LOG_ACTION_CREATE.equals(request.getAction())){
				//create a new record
				activeUserDao.merge(convertDomaintoEntity(adActiveUserDomain));	
			}else{
				//find and update update record
				AdActiveUsers adActiveUsers =  activeUserDao.findAdActiveUsersSingleResultBySessionId(request.getUserLogger().getSessionId());
				if(null !=adActiveUsers){
					adActiveUsers.setLastUpdatedBy(request.getUserLogger().getLastupdateby());
					adActiveUsers.setLastUpdateDate(Calendar.getInstance());
					adActiveUsers.setLogoutDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(adActiveUserDomain.getLogoutDate()));
					activeUserDao.merge(adActiveUsers);
				}
			}			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			status.setDescription("failed");
			status.setStatuscode("1");
		}
		return response;
	}

	public GetActiveuserResponse getActiveUserLoggedRecord(String sessionid) {
		GetActiveuserResponse serviceResponse =new GetActiveuserResponse();
		AdActiveUserDomain response= new AdActiveUserDomain();
		Status status=new Status();
		try{
			
			Set<AdActiveUsers> responseSet=activeUserDao.findAdActiveUsersBySessionId(new Integer(sessionid));
			for (AdActiveUsers adActiveUsers : responseSet) {
				response=convertEntitytoDomain(adActiveUsers);
				
			}
			
	}catch (Exception e) {
		// TODO: handle exception
		status.setDescription("failed");
		status.setStatuscode("1");
	}
	
	
		serviceResponse.setUserinfo(response);
		return serviceResponse;
	}

/*	private void convertDomaintoEntity(AdActiveUsers adUsersEntity, AdActiveUserDomain adUsersDomain, boolean isUpdate){
//		AdActiveUsers entity = new AdActiveUsers();
		if(isUpdate){			
//			entity.setActiveUserId(domain.getActiveUserId());
			entity.setCreatedBy(adUsersDomain.getCreatedby());
			adUsersEntity.setLastUpdatedBy(domain.getLastupdateby());
		}else{
			
		}
		try {
			if(domain.getLoginDate()!=null)
				entity.setLoginDate(DateUtil.fromXMLGregorianCalendar(domain.getLoginDate()));
			
			if(domain.getLogoutDate()!=null)
			entity.setLogoutDate(DateUtil.fromXMLGregorianCalendar(domain.getLogoutDate()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setSessionId(domain.getSessionId());
		entity.setAdUsers(userDao.findAdUsersByPrimaryKey(domain.getUserId()));
		
		return entity;
		
	}*/

	
	
	private AdActiveUsers convertDomaintoEntity(AdActiveUserDomain domain){
		AdActiveUsers entity = new AdActiveUsers();
		entity.setActiveUserId(domain.getActiveUserId());
		entity.setCreatedBy(domain.getCreatedby());
		entity.setLastUpdatedBy(domain.getLastupdateby());
		try {
			if(domain.getLoginDate()!=null)
				entity.setLoginDate(DateUtil.fromXMLGregorianCalendar(domain.getLoginDate()));
			
			if(domain.getLogoutDate()!=null)
			entity.setLogoutDate(DateUtil.fromXMLGregorianCalendar(domain.getLogoutDate()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setSessionId(domain.getSessionId());
		entity.setAdUsers(userDao.findAdUsersByPrimaryKey(domain.getUserId()));
		
		return entity;
		
	}
	
	private AdActiveUserDomain convertEntitytoDomain(AdActiveUsers entity){
		AdActiveUserDomain domain = new AdActiveUserDomain();
		domain.setActiveUserId(entity.getActiveUserId());
		domain.setSessionId(entity.getSessionId());
		domain.setCreatedby(entity.getCreatedBy());
		try {
			domain.setLoginDate(DateUtil.toXMLGregorianCalendar(entity.getLoginDate()));
			domain.setLogoutDate(DateUtil.toXMLGregorianCalendar(entity.getLogoutDate()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		domain.setUserId(entity.getActiveUserId());
		return domain;
	}

}
