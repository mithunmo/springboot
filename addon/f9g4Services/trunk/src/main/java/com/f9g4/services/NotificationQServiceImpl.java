package com.f9g4.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdEmailTemplatesDomain;
import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.services.AddNotificationQRequest;
import com.f9g4.businessobjects.services.AddNotificationQResponse;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersRequest;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersResponse;
import com.f9g4.businessobjects.services.DeleteNotificationQByIdResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeContainingResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeResponse;
import com.f9g4.businessobjects.services.GetNotificationQByIdResponse;
import com.f9g4.businessobjects.services.GetNotificationQForStatusResponse;
import com.f9g4.businessobjects.services.GetNotificationQForUserResponse;
import com.f9g4.businessobjects.services.UpdateNotificationQRequest;
import com.f9g4.businessobjects.services.UpdateNotificationQResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.dao.AdEmailTemplatesDAO;
import com.f9g4.dao.AdLookupValuesDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.TrNotificationsQDAO;
import com.f9g4.domain.AdEmailTemplates;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.TrNotificationsQ;
import com.f9g4.services.rest.INotificationQService;
import com.f9g4.util.ModelConverter;


@Service("notificationQService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
public class NotificationQServiceImpl implements INotificationQService {

	private static Logger logger = LoggerFactory.getLogger(NotificationQServiceImpl.class);
	
	@Autowired
	private TrNotificationsQDAO notificationsQDAO;
	
	@Autowired 
	private AdEmailTemplatesDAO adEmailTemplatesDAO;
	
	@Autowired
	private AdUsersDAO adUsersDAO;
	
	@Autowired
	private ModelConverter modelConverter;
	
	//handle errors..Return error message back to client
	public AddNotificationQResponse addNotificationQ(AddNotificationQRequest request) {
		AddNotificationQResponse response = new AddNotificationQResponse();
		Status responseStatus = new Status();
		if (null == request.getNotificationQ()) {
			responseStatus.setStatuscode("21001");
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				TrNotificationsQ notificationQEntity = new TrNotificationsQ();
				this.convertDomaintoEnity(request.getNotificationQ(), notificationQEntity, false);
				TrNotificationsQ responseObj = notificationsQDAO.merge(notificationQEntity);
				notificationsQDAO.flush();
				response.setNotificationQ(this.convertEntityToDomain(responseObj));
				responseStatus.setStatuscode("0");
			} catch (Exception e) {
				logger.error("EXCEPTION IN AddNotificationQ="+e);
				responseStatus.setStatuscode("22002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}
	
	public AddNotificationQWithMultiUsersResponse addNotificationQWithMultiUsers(AddNotificationQWithMultiUsersRequest request)
	{
		AddNotificationQWithMultiUsersResponse response = new AddNotificationQWithMultiUsersResponse();
		List<TrNotificationQDomain> domainList=new ArrayList<TrNotificationQDomain>();
		Status responseStatus = new Status();
		if (null == request.getNotificationQ()) {
			responseStatus.setStatuscode("21001");
			responseStatus.setDescription("Valid ID required");
		} 
		else 
		{
			try 
			{
				for(Integer userId : request.getUsers())
				{
					TrNotificationQDomain domain=new TrNotificationQDomain();
					TrNotificationsQ notificationQEntity = new TrNotificationsQ();
					//setup user data
					//retrieve user email
					AdUsers user = adUsersDAO.findAdUsersByPrimaryKey(userId);
					request.getNotificationQ().setToUserId(userId); //set to userId
					request.getNotificationQ().setToEmail(user.getUserName());//set to user email address
					this.convertDomaintoEnity(request.getNotificationQ(), notificationQEntity, false);
					TrNotificationsQ responseObj = notificationsQDAO.merge(notificationQEntity);
					notificationsQDAO.flush();
					domain=this.convertEntityToDomain(responseObj);
					domainList.add(domain);
				}
				response.getNotificationQ().addAll(domainList);
				responseStatus.setStatuscode("0");
			} 
			catch (Exception e) 
			{
				logger.error("EXCEPTION IN AddNotificationQ="+e);
				responseStatus.setStatuscode("22002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}

	public GetNotificationQByIdResponse getNotificationQbyId(int notificationQid) {

		GetNotificationQByIdResponse response = new GetNotificationQByIdResponse();
		Status responseStatus = new Status();
		if (notificationQid <= 0) {
			responseStatus.setStatuscode("22001");
			responseStatus.setDescription("Valid ID required");

		} else {
			try {

				TrNotificationsQ notificationQ = notificationsQDAO
						.findTrNotificationsQByPrimaryKey(notificationQid);

				response.setNotificationQ(this.convertEntityToDomain(notificationQ));
				responseStatus.setStatuscode("0");
			} catch (Exception e) {
				responseStatus.setStatuscode("22002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}

    public DeleteNotificationQByIdResponse deleteNotificationQById(int notificationQid) {
		DeleteNotificationQByIdResponse response = new DeleteNotificationQByIdResponse();
		Status responseStatus = new Status();
		if (notificationQid <= 0) {
			responseStatus.setStatuscode("24001");
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				TrNotificationsQ notificationQ = notificationsQDAO
						.findTrNotificationsQByNotificationId(notificationQid);
				notificationsQDAO.remove(notificationQ);
				responseStatus.setStatuscode("0");
			} catch (Exception e) {
				responseStatus.setStatuscode("24002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		return response;
	}

	private TrNotificationQDomain convertEntityToDomain(TrNotificationsQ notificationQ) throws DatatypeConfigurationException {
		TrNotificationQDomain notificationQdomain = new TrNotificationQDomain();
		notificationQdomain.setFromUserId(notificationQ.getFromUserId());
		notificationQdomain.setToUserId(notificationQ.getToUserId());
		notificationQdomain.setFromEmail(notificationQ.getFromEmail());
		notificationQdomain.setToEmail(notificationQ.getToEmail());
		notificationQdomain.setSubject(notificationQ.getSubject());
		notificationQdomain.setBodyText(notificationQ.getBodyText());
		notificationQdomain.setNotificationId(notificationQ.getNotificationId());
		notificationQdomain.setEmailStatusId(notificationQ.getAdLookupValues().getLookupValueId());
		notificationQdomain.setLastupdateby(notificationQ.getLastUpdatedBy());
		
		//notificationQdomain.setDeliveryDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(notificationQ.getDeliveryDate()));
		
		return notificationQdomain;
	}

	
		
	private void convertDomaintoEnity(TrNotificationQDomain domain, TrNotificationsQ notificationQ, boolean isForUpdate) {

		Calendar cal = Calendar.getInstance();
		if(!isForUpdate){
			//create
			/*notificationQ.setWhyRefer(domain.getWhyRefer());
			notificationQ.setMessage(domain.getMessage());
			notificationQ.setAuthCode(domain.getAuthCode());
			AdUsers users = adusersdao.findAdUsersByUserId(domain.getSentUserId());	
			notificationQ.setAdUsers(users);
			//TODO - remove hard code...
			notificationQ.setLangCode("en_EN");
			notificationQ.setDateSent(cal);
			*/
			//TODO get from context
			notificationQ.setCreatedBy(2);
			notificationQ.setLastUpdatedBy(2);
		 				
		}else{
			//TODO remove hardcoding
			notificationQ.setLastUpdatedBy(2);
			notificationQ.setNotificationId(domain.getNotificationId());
			notificationQ.setDeliveryDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getDeliveryDate()));			
			}
		
		notificationQ.setFromUserId(domain.getFromUserId());
		notificationQ.setToUserId(domain.getToUserId());
		notificationQ.setFromEmail(domain.getFromEmail());
		notificationQ.setToEmail(domain.getToEmail());
		notificationQ.setSubject(domain.getSubject());
		notificationQ.setBodyText(domain.getBodyText());
		
		
		AdLookupValues emailstatusid = adLookupValuesDAO.findAdLookupValuesByLookupValueId(domain.getEmailStatusId());
		notificationQ.setAdLookupValues(emailstatusid);
		
		
		//TODO - remove hard code...
		notificationQ.setLastUpdatedBy(1);
		notificationQ.setLastUpdateDate(cal);
	}

	public UpdateNotificationQResponse updateNotificationQ(UpdateNotificationQRequest request) {
		UpdateNotificationQResponse response = new UpdateNotificationQResponse();
		Status responseStatus = new Status();
		response.setStatus(responseStatus);
		try{
			logger.info("not id "+request.getNotificationQ().getNotificationId());
			TrNotificationsQ trNotificationQEntity = notificationsQDAO.findTrNotificationsQByNotificationId(request.getNotificationQ().getNotificationId());
			this.convertDomaintoEnity(request.getNotificationQ(),trNotificationQEntity, true);
			TrNotificationsQ responseObj = notificationsQDAO.merge(trNotificationQEntity);
			notificationsQDAO.flush();
			//response.setNotificationQ(this.convertEntityToDomain(responseObj));
		
			responseStatus.setStatuscode("526");
			response.setStatus(responseStatus);
		
		} 
		
		catch(Throwable th){
			//TODO - Handle Error handling..
			//Error = 527
			responseStatus.setStatuscode("527");
			response.setStatus(responseStatus);
			logger.error("Error :"+th.toString());
			
		}
	
		return response;
	}


	public GetNotificationQForUserResponse getNotificationQForUser(int userId) {
		GetNotificationQForUserResponse response = new GetNotificationQForUserResponse();
		Status responseStatus = new Status();
		response.setStatus(responseStatus);
		logger.info("USER ID="+userId);
		try{
			Set<TrNotificationsQ> trNotificationQSet = notificationsQDAO.findTrNotificationsQByToUserId(userId);
			List<TrNotificationQDomain> trNotificationQDomainsList = response.getNotificationQ();
			logger.info("SET SIZE="+trNotificationQSet.size());
			for(TrNotificationsQ trNotificationQ : trNotificationQSet){
				trNotificationQDomainsList.add(this.convertEntityToDomain(trNotificationQ));	
			}			
			logger.info("DOMAIN SIZE="+trNotificationQDomainsList.size());
		}catch(Throwable th){
			//TODO - eception handling..
			logger.error("Error:"+th.toString());
		}
		return response;
	}

	public GetNotificationQForStatusResponse getNotificationQForStatus(int statusId) {
		GetNotificationQForStatusResponse response = new GetNotificationQForStatusResponse();
		Status responseStatus = new Status();
		response.setStatus(responseStatus);
		logger.info("STATUS ID="+statusId);
		try{
			Set<TrNotificationsQ> trNotificationQSet = notificationsQDAO.findTrNotificationsQByStatusId(statusId);
			List<TrNotificationQDomain> trNotificationQDomainsList = response.getNotificationQ();
			logger.info("SET SIZE="+trNotificationQSet.size());
			for(TrNotificationsQ trNotificationQ : trNotificationQSet){
				response.getNotificationQ().add(this.convertEntityToDomain(trNotificationQ));	
			}			
			logger.info("DOMAIN SIZE="+trNotificationQDomainsList.size());
		}catch(Throwable th){
			//TODO - eception handling..
			logger.error("Error:"+th.toString());
		}
		return response;
	}

	@Autowired
	private TrNotificationsQDAO trNotificationsQDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;
	
	//TODO - remove... hadcoding..
	private String bodyText = "Body Text";
	private String subject = "Subject...";
	private Calendar today = Calendar.getInstance();
	
			
	private TrNotificationsQ populateTrNotificationsQEntity(TrNotificationsQ trNotificationQ){
		TrNotificationsQ trNotificationsQ = null;
		if(null != trNotificationQ){
			trNotificationsQ = new TrNotificationsQ();
			//EMAIL_STATUS_SAVED_TO_DRAFT - SD
			trNotificationsQ.setFromUserId(trNotificationQ.getFromUserId());
			trNotificationsQ.setFromEmail(trNotificationQ.getFromEmail());
			trNotificationsQ.setToUserId(trNotificationQ.getToUserId());
			trNotificationsQ.setToEmail(trNotificationQ.getToEmail());
			trNotificationsQ.setSubject(trNotificationQ.getSubject());
			trNotificationsQ.setBodyText(trNotificationQ.getBodyText());
		//	trNotificationsQ.setMsgStatus(msgStatus);
			trNotificationsQ.setDeliveryDate(trNotificationQ.getDeliveryDate());
		//	trNotificationsQ.setAdLookupValues(adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.EMAIL_STATUS_SAVED_TO_DRAFT.getTypeCode()));
			trNotificationsQ.setCreatedBy(2);
			trNotificationsQ.setCreationDate(today);
			trNotificationsQ.setLastUpdatedBy(2);
	}	
		return trNotificationsQ;
	}
	
	public GetEmailTemplateByCodeResponse getEmailTemplateByCode(String templateCode)
	{
		GetEmailTemplateByCodeResponse response = new GetEmailTemplateByCodeResponse();
		Status status = new Status();
		response.setStatus(status);
		try {
			AdEmailTemplates emailTemplate = adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCode(templateCode);
			response.setTemplateCode(emailTemplate.getEmailTemplateCode());
			response.setSubject(emailTemplate.getSubject());
			response.setBody(emailTemplate.getBody());
			response.setSupportEmail(emailTemplate.getSupportEmail());
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		}
		catch(Exception e) {
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
	
	public GetEmailTemplateByCodeContainingResponse getEmailTemplateByCodeContaining(String templateCode)
	{
		GetEmailTemplateByCodeContainingResponse response = new GetEmailTemplateByCodeContainingResponse();
		Status status = new Status();
		response.setStatus(status);
		try {
			Set<AdEmailTemplates> emailTemplate = adEmailTemplatesDAO.findAdEmailTemplatesByTemplateCodeContaining(templateCode);
			List<AdEmailTemplatesDomain> domain = response.getTemplates();
			domain.addAll(modelConverter.convertEntityToDomain(emailTemplate));
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		}
		catch(Exception e) {
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
		}
		return response;
	}
}