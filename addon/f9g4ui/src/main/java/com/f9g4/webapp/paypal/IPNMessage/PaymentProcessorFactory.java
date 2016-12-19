package com.f9g4.webapp.paypal.IPNMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.f9g4.services.rest.IPaypalPaymentService;

@Component
public class PaymentProcessorFactory {
	
	@Autowired
	private AdaptivePaymentMessageProcessor adaptivePaymentProcessor;
	
	@Autowired
	private PaypalMembershipMessageProcessor membershipPaymentProcessor;
	
	public IPaypalMessageProcessor getProcessor(String messageType){
//TODO - Add code to choose one of the Paypal Message processor of type IPaypalMessageProcessor		
		if(messageType.equalsIgnoreCase("Adaptive Payment PAY")){
			return adaptivePaymentProcessor;
		}else if(messageType.equalsIgnoreCase("adaptiveMembershipProceesor")){
			return membershipPaymentProcessor;
		}else
			return null;
	}

}
