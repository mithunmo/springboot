package com.f9g4.webapp.paypal.IPNMessage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.services.CheckPayKeyProcessedResponse;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsRequest;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsResponse;
import com.f9g4.common.util.PaypalConstants;
import com.f9g4.servicesdk.MembershipServiceSDK;

@Component
public class PaypalMembershipMessageProcessor implements
		IPaypalMessageProcessor {

	@Autowired
	private MembershipServiceSDK membershipServiceSDK;
	
	public void processPaypalMessage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String payKey = request.getParameter("pay_key");
		CheckPayKeyProcessedResponse chkresponse = membershipServiceSDK.checkPayKeyProcessed(payKey);
		//igonoring if record is already processed.
		if(chkresponse.getStatus().getStatuscode().equalsIgnoreCase("0")){
			CreateReceiveMembershipPaymentsRequest createMrequest = new CreateReceiveMembershipPaymentsRequest();
			createMrequest.setPayCommand(PaypalConstants.COMMAND_RETURN);
			createMrequest.setSecureToken(payKey);
			CreateReceiveMembershipPaymentsResponse response =  membershipServiceSDK.createReceiveMembershipPayments(createMrequest);
		}

	}

}
