package com.f9g4.webapp.paypal.IPNMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.f9g4.businessobjects.domain.TrPaypalAdaptiveMessage;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionResponse;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdRequest;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdResponse;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationRequest;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationResponse;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsRequest;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsResponse;
import com.f9g4.businessobjects.services.LogPaypalTransactionRequest;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.servicesdk.PaypalPaymentServiceSDK;
import com.f9g4.servicesdk.SalesTransactionServiceSDK;

@Component
public class PaypalMessageProcessorHelperService {
	private static final Logger logger = LoggerFactory
			.getLogger(PaypalMessageProcessorHelperService.class);

	@Autowired
	private SalesTransactionServiceSDK salesTransactionServiceSDK;
	
	@Autowired
	private PaypalPaymentServiceSDK paypalPaymentSDK;

	public boolean ProcessPayment(String payKey) {
		CreateTrSalesTransactionRequest request = new CreateTrSalesTransactionRequest();
		request.setPayKey(payKey);
		CreateTrSalesTransactionResponse response = salesTransactionServiceSDK
				.CreateTrSalesTransaction(request);
		if (response.getStatus().getStatuscode()
				.equals(StatusCodesEnum.STATUS_SUCCESS.getCode())) {
			return true;
		}else
			return false;
	}

	public boolean CheckReceiverEmail(String receiverEmail) {
		GetReceiverEmailVerificationRequest request = new GetReceiverEmailVerificationRequest();
		request.setReceiverEmail(receiverEmail);
		GetReceiverEmailVerificationResponse response = salesTransactionServiceSDK
				.GetReceiverEmailVerification(request);
		return response.isIsReceiverEmailVerified();
	}

	public boolean CheckTransactionProcessed(String payKey) {
		GetTrSalesTransactionHeaderExistsRequest request = new GetTrSalesTransactionHeaderExistsRequest();
		request.setTransactionId(payKey);
		GetTrSalesTransactionHeaderExistsResponse response = salesTransactionServiceSDK
				.getTrSalesTransactionHeaderExists(request);
		return response.isTrSalesTransactionHeaderExists();
	}

	@SuppressWarnings("unused")
	private boolean CheckPrice(String payKey, String paymentAmount) {
		GetGrossbyTransactionIdRequest requestPrice = new GetGrossbyTransactionIdRequest();
		requestPrice.setTransactionId(payKey);
		GetGrossbyTransactionIdResponse reponsePrice = salesTransactionServiceSDK
				.getGrossbyTransactionId(requestPrice);
		BigDecimal txnPrice = reponsePrice.getPrice().setScale(2,
				RoundingMode.UNNECESSARY);
		if (paymentAmount.equals(txnPrice.toString()))
		{
			return true;
		} else
			return false;

	}
	
	public boolean logPaypalMessgae(HttpServletRequest request){
	
		try {
			TrPaypalAdaptiveMessage paypalMessage=new TrPaypalAdaptiveMessage();
			paypalMessage.setAck("Success");
			paypalMessage.setActionType(request.getParameter("action_type"));
			paypalMessage.setCancelUrl(request.getParameter("cancel_url"));
			paypalMessage.setFeesPayer(request.getParameter("fees_payer"));
			paypalMessage.setMemo(request.getParameter("memo"));
			paypalMessage.setPaykey(request.getParameter("pay_key"));
			paypalMessage.setPayStatus(request.getParameter("status"));
			paypalMessage.setPendingReason(request.getParameter("reason_code"));
			paypalMessage.setReturnUrl(request.getParameter("return_url"));
			paypalMessage.setSenderEmail(request.getParameter("sender_email"));
			paypalMessage.setSenderTransactionId(request.getParameter("transaction[0].id"));
			paypalMessage.setTrackingId(request.getParameter("trackingId"));
			paypalMessage.setTransactionAmount(request.getParameter("transaction[0].amount"));
			paypalMessage.setTransactionStatus(request.getParameter("transaction[0].status"));
			paypalMessage.setTimestamp(request.getParameter("payment_request_date"));
			paypalMessage.setBuild("IPNMessage");
			
			LogPaypalTransactionRequest logrequest = new LogPaypalTransactionRequest();
			logrequest.setTrPaypalMessageDomain(paypalMessage);
			paypalPaymentSDK.logPaypalMessage(logrequest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			return false;
		}
	}

}
