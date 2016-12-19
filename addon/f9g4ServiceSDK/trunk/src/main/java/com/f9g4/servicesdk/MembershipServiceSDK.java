package com.f9g4.servicesdk;

import java.util.Properties;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.services.AddCreditRequest;
import com.f9g4.businessobjects.services.AddCreditResponse;
import com.f9g4.businessobjects.services.CheckPayKeyProcessedResponse;
import com.f9g4.businessobjects.services.CreateMembershipAuthSbmitRequest;
import com.f9g4.businessobjects.services.CreateMembershipAuthSbmitResponse;
import com.f9g4.businessobjects.services.CreateMembershipRequest;
import com.f9g4.businessobjects.services.CreateMembershipResponse;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsRequest;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsResponse;
import com.f9g4.businessobjects.services.GetMemPricingOptionsResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.GetMembershipdetailsResponse;
import com.f9g4.businessobjects.services.RedeemUserCreditResponse;
import com.f9g4.businessobjects.services.UpdateMembershipPaymentStatusRequest;
import com.f9g4.businessobjects.services.UpdateMembershipPaymentStatusResponse;
import com.f9g4.businessobjects.services.UpdateMembershipRequest;
import com.f9g4.businessobjects.services.UpdateMembershipResponse;
import com.f9g4.businessobjects.services.UpdateUserMembershipRequest;
import com.f9g4.businessobjects.services.UpdateUserMembershipResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IMembershipService;

public class MembershipServiceSDK extends AbstractRestSDK<IMembershipService> implements IMembershipService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Properties membershipSvcProperties;

	private String membershipSvcConfigFile;

	private ServiceType callType;

//	@Autowired
	private IMembershipService membershipService;

	
	public Properties getMembershipSvcProperties() {
		return membershipSvcProperties;
	}



	public void setMembershipSvcProperties(Properties membershipSvcProperties) {
		this.membershipSvcProperties = membershipSvcProperties;
	}



	public String getMembershipSvcConfigFile() {
		return membershipSvcConfigFile;
	}



	public void setMembershipSvcConfigFile(String membershipSvcConfigFile) {
		this.membershipSvcConfigFile = membershipSvcConfigFile;
	}



	public IMembershipService getMembershipService() {
		return membershipService;
	}



	public void setMembershipService(IMembershipService membershipService) {
		this.membershipService = membershipService;
	}
	

	@Override
	protected String getClientConfigFile() {
		return this.membershipSvcConfigFile;
	}



	@Override
	protected Properties getProperties() {
		return this.membershipSvcProperties;
	}



	@Override
	protected ServiceType getCallType() {
		return this.callType;
	}


	@Override
	protected IMembershipService getLocalService() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected IMembershipService getMockService() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	public UpdateMembershipResponse updateMembership(UpdateMembershipRequest request) {
		return getService().updateMembership(request);
	}

	public CreateMembershipResponse createMembership(CreateMembershipRequest request) {
		return getService().createMembership(request);
	}

	public CreateMembershipAuthSbmitResponse createMembershipAuthSbmit(CreateMembershipAuthSbmitRequest request) {
		return getService().createMembershipAuthSbmit(request);
	}

	public UpdateMembershipPaymentStatusResponse updateMembershipPaymentStatus(UpdateMembershipPaymentStatusRequest request) {
		return getService().updateMembershipPaymentStatus(request);
	}

	public GetMembershipdetailsResponse getMembershipdetails(int userId) {
		return getService().getMembershipdetails(userId);
	}

	public CreateReceiveMembershipPaymentsResponse createReceiveMembershipPayments(CreateReceiveMembershipPaymentsRequest request) {
		return getService().createReceiveMembershipPayments(request);
	}

	public GetMembershipCommissionResponse getMembershipCommissiondetails(GetMembershipCommissionRequest request) {
		return getService().getMembershipCommissiondetails(request);
	}

	public GetMemPricingOptionsResponse getMemPricingOptions() {
		return getService().getMemPricingOptions();
	}


	public CheckPayKeyProcessedResponse checkPayKeyProcessed(String paykey) {
		// TODO Auto-generated method stub
		return getService().checkPayKeyProcessed(paykey);
	}

	public UpdateUserMembershipResponse updateUserMembership(UpdateUserMembershipRequest request) {
		return getService().updateUserMembership(request);
	}



	public AddCreditResponse addCredit(AddCreditRequest request) {		
		return getService().addCredit(request);
	}



	public RedeemUserCreditResponse redeemCredit(int userId, int credits) {
		return getService().redeemCredit(userId, credits);
	}
	
}
