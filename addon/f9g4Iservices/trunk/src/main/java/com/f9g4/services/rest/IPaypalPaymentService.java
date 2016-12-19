package com.f9g4.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f9g4.businessobjects.services.CompletePaymentRequest;
import com.f9g4.businessobjects.services.CompletePaymentResponse;
import com.f9g4.businessobjects.services.GetPaymentInfoResponse;
import com.f9g4.businessobjects.services.GetReceiverEmail;
import com.f9g4.businessobjects.services.LogPaypalTransactionRequest;
import com.f9g4.businessobjects.services.LogPaypalTransactionResponse;
import com.f9g4.businessobjects.services.SetupPaymentRequest;
import com.f9g4.businessobjects.services.SetupPaymentResponse;

@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface IPaypalPaymentService {
	
	@GET
	@Path("/payInfo/{token}")
	public GetPaymentInfoResponse getPaymentInfo(@PathParam(value="token") String paymentToken);
	
	@POST
	@Path("/setup")
	public SetupPaymentResponse setupPayment(SetupPaymentRequest request);
	
	@POST
	@Path("/complete")
	public CompletePaymentResponse completePayment(CompletePaymentRequest request);
	
	@POST
	@Path("/PaypalInfo/ReceiverEmail")
	public GetReceiverEmail getReceiverEmail();
	
	@PUT
	@Path("/Paypal/transaction/log")
	public LogPaypalTransactionResponse logPaypalMessage(LogPaypalTransactionRequest request);
	
}
