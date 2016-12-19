package com.f9g4.servicesdk;

import java.util.Properties;

import com.f9g4.businessobjects.services.CompletePaymentRequest;
import com.f9g4.businessobjects.services.CompletePaymentResponse;
import com.f9g4.businessobjects.services.GetPaymentInfoResponse;
import com.f9g4.businessobjects.services.GetReceiverEmail;
import com.f9g4.businessobjects.services.LogPaypalTransactionRequest;
import com.f9g4.businessobjects.services.LogPaypalTransactionResponse;
import com.f9g4.businessobjects.services.SetupPaymentRequest;
import com.f9g4.businessobjects.services.SetupPaymentResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IPaypalPaymentService;

public class PaypalPaymentServiceSDK extends AbstractRestSDK<IPaypalPaymentService> implements IPaypalPaymentService {
	
	private static final long serialVersionUID = 1L;

	private Properties paypalPaymentServiceProperties;

	private String paypalPaymentServiceConfigFile;

	private ServiceType callType;
	
	private IPaypalPaymentService paypalPaymentService;
	
	
	public Properties getPaypalPaymentServiceProperties() {
		return paypalPaymentServiceProperties;
	}

	public void setPaypalPaymentServiceProperties(
			Properties paypalPaymentServiceProperties) {
		this.paypalPaymentServiceProperties = paypalPaymentServiceProperties;
	}

	public String getPaypalPaymentServiceConfigFile() {
		return paypalPaymentServiceConfigFile;
	}

	public void setPaypalPaymentServiceConfigFile(
			String paypalPaymentServiceConfigFile) {
		this.paypalPaymentServiceConfigFile = paypalPaymentServiceConfigFile;
	}

	public IPaypalPaymentService getPaypalPaymentService() {
		return paypalPaymentService;
	}

	public void setPaypalPaymentService(IPaypalPaymentService paypalPaymentService) {
		this.paypalPaymentService = paypalPaymentService;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	@Override
	protected String getClientConfigFile() {
		return this.paypalPaymentServiceConfigFile;
	}

	@Override
	protected Properties getProperties() {
		return this.paypalPaymentServiceProperties;
	}

	@Override
	protected ServiceType getCallType() {
		return this.callType;
	}

	@Override
	protected IPaypalPaymentService getLocalService() {
		return this.paypalPaymentService;
	}

	@Override
	protected IPaypalPaymentService getMockService() {
		return null;
	}

	public GetPaymentInfoResponse getPaymentInfo(String paymentToken) {
		return this.getService().getPaymentInfo(paymentToken);
	}

	public SetupPaymentResponse setupPayment(SetupPaymentRequest request) {
		return this.getService().setupPayment(request);
	}

	public CompletePaymentResponse completePayment(CompletePaymentRequest request) {
		return this.getService().completePayment(request);
	}

	public GetReceiverEmail getReceiverEmail() {
		return this.getService().getReceiverEmail();
	}

	public LogPaypalTransactionResponse logPaypalMessage(
			LogPaypalTransactionRequest request) {
		// TODO Auto-generated method stub
		return this.getService().logPaypalMessage(request);
	}
	
}