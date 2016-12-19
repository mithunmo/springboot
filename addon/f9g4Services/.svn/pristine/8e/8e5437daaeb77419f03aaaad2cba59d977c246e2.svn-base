package com.f9g4.services;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.TrReferralsDomain;
import com.f9g4.businessobjects.services.AddReferralsRequest;
import com.f9g4.businessobjects.services.AddReferralsResponse;
import com.f9g4.businessobjects.services.DeleteReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralByAuthCodeResponse;
import com.f9g4.businessobjects.services.GetReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralsForUserResponse;
import com.f9g4.businessobjects.services.GetReferralsResponse;
import com.f9g4.businessobjects.services.ResendReferralMessageResponse;
import com.f9g4.businessobjects.services.UpdateReferralAndResendMessageRequest;
import com.f9g4.businessobjects.services.UpdateReferralAndResendMessageResponse;
import com.f9g4.businessobjects.services.UpdateReferralRequest;
import com.f9g4.businessobjects.services.UpdateReferralResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.LanguageCodesEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.dao.AdLookupValuesDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.TrNotificationsQDAO;
import com.f9g4.dao.TrReferralsDAO;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.TrNotificationsQ;
import com.f9g4.domain.TrReferrals;
import com.f9g4.services.rest.IReferralsService;


@Service("referralsService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
public class ReferralsServiceImpl implements IReferralsService
{
	private static final Logger logger = LoggerFactory.getLogger(ReferralsServiceImpl.class);
	
	@Autowired
	private TrReferralsDAO referralsDAO;

	@Autowired
	private AdUsersDAO adusersdao;
	
	public AddReferralsResponse addReferrals(AddReferralsRequest request) {
		AddReferralsResponse response = new AddReferralsResponse();
		Status responseStatus = new Status();
		if (null == request.getReferrals()) 
		{
			responseStatus.setStatuscode("21001");
			responseStatus.setDescription("Valid ID required");

		} 
		else 
		{
			logger.trace("Outside add referrals");
			//try 
			//{
				TrReferrals referralsEntity = new TrReferrals();
				//set expiration date to 60 days from now -C
				Calendar day=Calendar.getInstance();
				day.add(Calendar.DAY_OF_MONTH, +60);
				try {
					request.getReferrals().setExpirationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(day));
				}
				catch (DatatypeConfigurationException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.getReferrals().setAuthCode(UUID.randomUUID().toString());
				this.convertDomaintoEntity(request.getReferrals(), referralsEntity, false);
				logger.trace("Inside add referral");
				TrReferrals responseObj = referralsDAO.merge(referralsEntity);
				//referralsDAO.flush();
				
				try {
					response.setReferrals(this.convertEntityToDomain(responseObj));
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
				}
				responseStatus.setStatuscode("0");
			//} 
			/*catch (Exception e) {
				System.out.println("EXCEPTION IN AddReferral="+e);
				responseStatus.setStatuscode("22002");
				responseStatus.setDescription("Unknown Error Occured");
			}*/
		}
		response.setStatus(responseStatus);
		return response;
	}

	public GetReferralsByIdResponse getReferralsbyId(int referralsid) {

		GetReferralsByIdResponse response = new GetReferralsByIdResponse();
		Status responseStatus = new Status();
		if (referralsid <= 0) {
			responseStatus.setStatuscode("22001");
			responseStatus.setDescription("Valid ID required");

		} else {
			try {

				TrReferrals referrals = referralsDAO
						.findTrReferralsByPrimaryKey(referralsid);

				response.setReferrals(this.convertEntityToDomain(referrals));
				responseStatus.setStatuscode("0");
			} catch (Exception e) {
				responseStatus.setStatuscode("22002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		response.setStatus(responseStatus);
		return response;
	}

    public DeleteReferralsByIdResponse deleteReferralsById(int referralsid) {
		DeleteReferralsByIdResponse response = new DeleteReferralsByIdResponse();
		Status responseStatus = new Status();
		if (referralsid <= 0) {
			responseStatus.setStatuscode("24001");
			responseStatus.setDescription("Valid ID required");

		} else {
			try {
				TrReferrals referrals = referralsDAO
						.findTrReferralsByReferralId(referralsid);
				referralsDAO.remove(referrals);
				responseStatus.setStatuscode("0");
			} catch (Exception e) {
				responseStatus.setStatuscode("24002");
				responseStatus.setDescription("Unknown Error Occured");
			}
		}
		return response;
	}

	private TrReferralsDomain convertEntityToDomain(TrReferrals referrals) throws DatatypeConfigurationException {
		TrReferralsDomain referralsdomain = new TrReferralsDomain();
		referralsdomain.setAuthCode(referrals.getAuthCode());
		//referralsdomain.setDateSent(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
		referralsdomain.setDateSent(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(referrals.getDateSent()));
		referralsdomain.setEmail(referrals.getEmailAddress());
		if(referrals.getExpirationDate()!=null)
			referralsdomain.setExpirationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(referrals.getExpirationDate()));
		
		referralsdomain.setFirstName(referrals.getFirstName());
		referralsdomain.setLangCode(referrals.getLangCode());
		referralsdomain.setLastName(referrals.getLastName());
		referralsdomain.setPhone(referrals.getPhone());
		referralsdomain.setMessage(referrals.getMessage());
		referralsdomain.setReferalId(referrals.getReferralId());
		referralsdomain.setSentUserId(referrals.getAdUsers().getUserId());
		referralsdomain.setSignedupUserid(referrals.getSignedupUserId());
		if(referrals.getSignedupOn() != null)
			referralsdomain.setSignupOn(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(referrals.getSignedupOn()));
		referralsdomain.setWhyRefer(referrals.getWhyRefer());
		return referralsdomain;
	}

	
		
	private void convertDomaintoEntity(TrReferralsDomain domain, TrReferrals referrals, boolean isForUpdate) {

		Calendar cal = Calendar.getInstance();
		if(!isForUpdate)
		{
			//create
			referrals.setWhyRefer(domain.getWhyRefer());
			referrals.setMessage(domain.getMessage());
			referrals.setAuthCode(domain.getAuthCode());
			AdUsers users = adusersdao.findAdUsersByUserId(domain.getSentUserId());	
			referrals.setAdUsers(users);
			referrals.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
		}
		else
		{
			//update
			referrals.setReferralId(domain.getReferalId());
		}
		
		referrals.setDateSent(cal);
		referrals.setFirstName(domain.getFirstName());
		referrals.setLastName(domain.getLastName());
		referrals.setEmailAddress(domain.getEmail());
		referrals.setPhone(domain.getPhone());
		referrals.setExpirationDate(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getExpirationDate()));
		
		referrals.setSignedupUserId(domain.getSignedupUserid());
		if(null != domain.getSignupOn())
		{
			referrals.setSignedupOn(XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(domain.getSignupOn()));	
		}
		referrals.setLastUpdatedBy(domain.getLastupdateby());
		referrals.setLastUpdateDate(cal);
	}

	public UpdateReferralResponse updateReferral(UpdateReferralRequest request) {
		UpdateReferralResponse response = new UpdateReferralResponse();
		Status responseStatus = new Status();
		response.setStatus(responseStatus);
		try{
			TrReferralsDomain trReferralsDomain = request.getReferrals();
			TrReferrals trReferralEntity = referralsDAO.findTrReferralsByPrimaryKey(trReferralsDomain.getReferalId());
			this.convertDomaintoEntity(trReferralsDomain,trReferralEntity, true);
			referralsDAO.merge(trReferralEntity);
			responseStatus.setStatuscode("0");
		}catch(Throwable th){
			//TODO - eception handling..
			responseStatus.setStatuscode("1");
		}
		return response;
	}


	public GetReferralsForUserResponse getReferralsForUser(int userId) {
		GetReferralsForUserResponse response = new GetReferralsForUserResponse();
		Status responseStatus = new Status();
		response.setStatus(responseStatus);
		//System.out.println("USER ID="+userId);
		try{
			Set<TrReferrals> trReferralsSet = referralsDAO.findTrReferralsByUser(userId);
			List<TrReferralsDomain> trReferralsDomainsList = response.getReferrals();
			//System.out.println("SET SIZE="+trReferralsSet.size());
			for(TrReferrals trReferrals : trReferralsSet){
				trReferralsDomainsList.add(this.convertEntityToDomain(trReferrals));	
			}			
			//System.out.println("DOMAIN SIZE="+trReferralsDomainsList.size());
		}catch(Throwable th){
			//TODO - eception handling..
			logger.error("Exception Occurred", th);
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
	
	public ResendReferralMessageResponse resendReferralMessage(int referralId) {
		
		ResendReferralMessageResponse response = new ResendReferralMessageResponse();
		Status status = new Status();
		status.setStatuscode("0");
		try{

			TrReferrals trReferrals = referralsDAO.findTrReferralsByReferralId(referralId);
			TrNotificationsQ trNotificationsQ =this.populateTrNotificationsQEntity(trReferrals);
			if(null != trNotificationsQ){
				trNotificationsQDAO.merge(trNotificationsQ);
			}
		}catch(Throwable th){
			status.setStatuscode("22002");
		}
		return response;
	}

	public UpdateReferralAndResendMessageResponse updateReferralAndResendMessage(UpdateReferralAndResendMessageRequest request) {
		
		TrReferralsDomain trReferralsDomain = request.getReferrals();
		UpdateReferralAndResendMessageResponse response = new UpdateReferralAndResendMessageResponse();
		Status status = new Status();
		status.setStatuscode("0");
		try{
			
			TrReferrals trReferrals = referralsDAO.findTrReferralsByReferralId(trReferralsDomain.getReferalId());
			this.convertDomaintoEntity(trReferralsDomain, trReferrals, true);
			
			referralsDAO.merge(trReferrals);
			
			TrNotificationsQ trNotificationsQ =this.populateTrNotificationsQEntity(trReferrals);
			if(null != trNotificationsQ){
				trNotificationsQDAO.merge(trNotificationsQ);
			}
		}catch(Throwable th){
			//TODO - hardcode
			status.setStatuscode("1");
		}
		return response;
	}
	
	private TrNotificationsQ populateTrNotificationsQEntity(TrReferrals trReferrals){
		TrNotificationsQ trNotificationsQ = null;
		if(null != trReferrals){
			trNotificationsQ = new TrNotificationsQ();
			//EMAIL_STATUS_SAVED_TO_DRAFT - SD
			trNotificationsQ.setAdLookupValues(adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult(LookupTypeValueEnum.EMAIL_STATUS_SAVED_TO_DRAFT.getTypeCode()));
			trNotificationsQ.setBodyText(bodyText);
			//TODO - remove hardcode
			trNotificationsQ.setCreatedBy(1);
			trNotificationsQ.setCreationDate(today);
			//TODO - check with Girish...
			trNotificationsQ.setDeliveryDate(today);
			trNotificationsQ.setFromEmail(trReferrals.getAdUsers().getUserName());
			trNotificationsQ.setFromUserId(trReferrals.getAdUsers().getUserId());
			trNotificationsQ.setLastUpdateDate(today);
			//TODO - remove hardcode
			trNotificationsQ.setLastUpdatedBy(1);
			//TODO- need to add msg status..?????
//			trNotificationsQ.setMsgStatus(msgStatus);
//			trNotificationsQ.setNotificationId(notificationId);
			trNotificationsQ.setSubject(subject);
			trNotificationsQ.setToEmail(trReferrals.getEmailAddress());
			//trNotificationsQ.setToUserId(toUserId);			
		}	
		return trNotificationsQ;
	}
	
	public GetReferralByAuthCodeResponse getReferralByAuthCode(String authCode)
	{
		GetReferralByAuthCodeResponse response = new GetReferralByAuthCodeResponse();
		Status status = new Status();
		response.setStatus(status);
		List<TrReferralsDomain> domainList = response.getReferral();
		Set<TrReferrals> referralsSet = referralsDAO.findTrReferralsByAuthCode(authCode);
		if(referralsSet.size()<=0)
		{
			status.setStatuscode(StatusCodesEnum.STATUS_RECORD_NOT_EXISTED.getCode());
		}
		else
		{
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
			//It should be one record for one auth code.
			try {
				domainList.add(this.convertEntityToDomain(referralsSet.iterator().next()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			}	
		}
		return response;
	}
	
	public GetReferralsResponse getReferrals()
	{
		GetReferralsResponse response = new GetReferralsResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		List<TrReferralsDomain> domainList = response.getReferrals();
		Set<TrReferrals> referralSet = referralsDAO.findAllTrReferralss();
		for(TrReferrals item : referralSet)
		{
			try {
				domainList.add(this.convertEntityToDomain(item));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
				e.printStackTrace();
				break;
			}
		}
		return response;
	}
}