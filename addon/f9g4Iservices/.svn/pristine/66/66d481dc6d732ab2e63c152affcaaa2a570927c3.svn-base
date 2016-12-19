package com.f9g4.services.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

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

public interface ISalesTransactionService {

	@POST
	@Path("/sale")
	public CreateSalesTransactionResponse createSalesTransaction(CreateSalesTransactionRequest request);

	@POST
	@Path("/auth/header")
	public CreatePaymentAuthSubmitHeaderResponse createPaymentAuthSubmitHeader(CreatePaymentAuthSubmitHeaderRequest request);

	@POST
	@Path("/auth")
	public CreatePaymentAuthSubmitResponse createPaymentAuthSubmit(CreatePaymentAuthSubmitRequest request);
	
	@POST
	@Path("/auth/gross")
	public GetGrossbyTransactionIdResponse getGrossbyTransactionId(GetGrossbyTransactionIdRequest request);
	
	@POST
	@Path("/auth/checkTransactionProcessed")
	public GetTrSalesTransactionHeaderExistsResponse getTrSalesTransactionHeaderExists(GetTrSalesTransactionHeaderExistsRequest request);
	
	@POST
	@Path("/auth/receiverEmailVerification")
	public GetReceiverEmailVerificationResponse GetReceiverEmailVerification(GetReceiverEmailVerificationRequest request);
	
	@POST
	@Path("/auth/createSalesTransaction")
	public CreateTrSalesTransactionResponse CreateTrSalesTransaction(CreateTrSalesTransactionRequest request);
}
