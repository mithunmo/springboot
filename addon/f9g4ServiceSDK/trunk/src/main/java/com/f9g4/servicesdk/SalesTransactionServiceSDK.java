package com.f9g4.servicesdk;

import java.util.Properties;

import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitHeaderRequest;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitHeaderResponse;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitRequest;
import com.f9g4.businessobjects.services.CreatePaymentAuthSubmitResponse;
import com.f9g4.businessobjects.services.CreateSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateSalesTransactionResponse;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionResponse;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdRequest;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdResponse;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationRequest;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationResponse;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsRequest;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.ISalesTransactionService;

public class SalesTransactionServiceSDK extends AbstractRestSDK<ISalesTransactionService> implements ISalesTransactionService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Properties salesTransactionSvcProperties;

	private String salesTransactionSvcConfigFile;

	private ServiceType callType;

	private ISalesTransactionService salesTransactionService;

	@Override
	protected String getClientConfigFile() {
		return salesTransactionSvcConfigFile;
	}

	@Override
	protected Properties getProperties() {
		return this.salesTransactionSvcProperties;
	}

	@Override
	protected ServiceType getCallType() {
		return this.callType;
	}

	@Override
	protected ISalesTransactionService getLocalService() {
		return null;
	}

	@Override
	protected ISalesTransactionService getMockService() {
		return null;
	}


	public Properties getSalesTransactionSvcProperties() {
		return salesTransactionSvcProperties;
	}

	public void setSalesTransactionSvcProperties(
			Properties salesTransactionSvcProperties) {
		this.salesTransactionSvcProperties = salesTransactionSvcProperties;
	}

	public String getSalesTransactionSvcConfigFile() {
		return salesTransactionSvcConfigFile;
	}

	public void setSalesTransactionSvcConfigFile(
			String salesTransactionSvcConfigFile) {
		this.salesTransactionSvcConfigFile = salesTransactionSvcConfigFile;
	}

	public ISalesTransactionService getSalesTransactionService() {
		return salesTransactionService;
	}

	public void setSalesTransactionService(
			ISalesTransactionService salesTransactionService) {
		this.salesTransactionService = salesTransactionService;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}
	
	public CreateSalesTransactionResponse createSalesTransaction(CreateSalesTransactionRequest request) {
		return getService().createSalesTransaction(request);
	}

	public CreatePaymentAuthSubmitHeaderResponse createPaymentAuthSubmitHeader(CreatePaymentAuthSubmitHeaderRequest request) {
		return getService().createPaymentAuthSubmitHeader(request);
	}

	public CreatePaymentAuthSubmitResponse createPaymentAuthSubmit(CreatePaymentAuthSubmitRequest request) {
		return getService().createPaymentAuthSubmit(request);
	}

	public GetGrossbyTransactionIdResponse getGrossbyTransactionId(
			GetGrossbyTransactionIdRequest request) {
		return getService().getGrossbyTransactionId(request);
	}

	public GetTrSalesTransactionHeaderExistsResponse getTrSalesTransactionHeaderExists(
			GetTrSalesTransactionHeaderExistsRequest request) {
		return getService().getTrSalesTransactionHeaderExists(request);
	}

	public GetReceiverEmailVerificationResponse GetReceiverEmailVerification(
			GetReceiverEmailVerificationRequest request) {
		return getService().GetReceiverEmailVerification(request);
	}

	public CreateTrSalesTransactionResponse CreateTrSalesTransaction(
			CreateTrSalesTransactionRequest request) {
		return getService().CreateTrSalesTransaction(request);
	}
}