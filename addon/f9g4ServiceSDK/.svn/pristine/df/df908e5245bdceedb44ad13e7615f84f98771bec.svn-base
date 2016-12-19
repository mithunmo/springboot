package com.f9g4.servicesdk;

import java.util.Properties;

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
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IReferralsService;

public class ReferralsServiceSDK extends AbstractRestSDK<IReferralsService> implements IReferralsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Properties referralsServiceProperties;

	private String referralsServiceConfigFile;

	private ServiceType callType;
	

//	@Autowired
	private IReferralsService refrralsService;

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	public Properties getReferralsServiceProperties() {
		return referralsServiceProperties;
	}

	public void setReferralsServiceProperties(
			Properties referralsServiceProperties) {
		this.referralsServiceProperties = referralsServiceProperties;
	}

	public String getReferralsServiceConfigFile() {
		return referralsServiceConfigFile;
	}

	public void setReferralsServiceConfigFile(String referralsServiceConfigFile) {
		this.referralsServiceConfigFile = referralsServiceConfigFile;
	}

	public IReferralsService getrefrralsService() {
		return refrralsService;
	}

	public void setrefrralsService(IReferralsService refrralsService) {
		this.refrralsService = refrralsService;
	}

	@Override
	protected String getClientConfigFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Properties getProperties() {
		// TODO Auto-generated method stub
		return this.referralsServiceProperties;
	}

	@Override
	protected ServiceType getCallType() {
		// TODO Auto-generated method stub
		return this.callType;
	}

	@Override
	protected IReferralsService getLocalService() {
		// TODO Auto-generated method stub
		return this.refrralsService;
	}

	@Override
	protected IReferralsService getMockService() {
		// TODO Add STUB implementation

		return null;
	}

	public AddReferralsResponse addReferrals(AddReferralsRequest request) {

		return getService().addReferrals(request);
	}

	public GetReferralsByIdResponse getReferralsbyId(
			int request) {
		
		return getService().getReferralsbyId(request);
	}


	public DeleteReferralsByIdResponse deleteReferralsById(int referralsid) {
		// TODO Auto-generated method stub
		return getService().deleteReferralsById(referralsid);
	}

	public GetReferralsForUserResponse getReferralsForUser(int userId) {
		return getService().getReferralsForUser(userId);	
	}

	public UpdateReferralResponse updateReferral(UpdateReferralRequest request) {
		return getService().updateReferral(request);
	}

	public ResendReferralMessageResponse resendReferralMessage(int referralId) {
		return getService().resendReferralMessage(referralId);
	}

	public UpdateReferralAndResendMessageResponse updateReferralAndResendMessage(UpdateReferralAndResendMessageRequest request) {
		return getService().updateReferralAndResendMessage(request);
	}

	public GetReferralByAuthCodeResponse getReferralByAuthCode(String authCode) {
		return getService().getReferralByAuthCode(authCode);
	}

	public GetReferralsResponse getReferrals() {
		return getService().getReferrals();
	}
}
