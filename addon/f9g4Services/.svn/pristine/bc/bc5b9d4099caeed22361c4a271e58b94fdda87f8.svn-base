package com.f9g4.services.adaptivepayments;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import adaptivepayments.AdaptivePayments;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.services.CompletePaymentRequest;
import com.f9g4.businessobjects.services.CompletePaymentResponse;
import com.f9g4.businessobjects.services.GetPaymentInfoResponse;
import com.f9g4.businessobjects.services.GetReceiverEmail;
import com.f9g4.businessobjects.services.LogPaypalTransactionRequest;
import com.f9g4.businessobjects.services.LogPaypalTransactionResponse;
import com.f9g4.businessobjects.services.OrderItem;
import com.f9g4.businessobjects.services.SetupPaymentRequest;
import com.f9g4.businessobjects.services.SetupPaymentResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.PaypalConstants;
import com.f9g4.dao.TrPayGatewayAuditLogDAO;
import com.f9g4.domain.TrPayGatewayAuditLog;
import com.f9g4.services.rest.IPaypalPaymentService;
import com.paypal.svcs.services.PPFaultMessage;
import com.paypal.svcs.types.ap.ExecutePaymentRequest;
import com.paypal.svcs.types.ap.ExecutePaymentResponse;
import com.paypal.svcs.types.ap.FundingConstraint;
import com.paypal.svcs.types.ap.FundingTypeInfo;
import com.paypal.svcs.types.ap.FundingTypeList;
import com.paypal.svcs.types.ap.PayRequest;
import com.paypal.svcs.types.ap.PayResponse;
import com.paypal.svcs.types.ap.PaymentDetailsRequest;
import com.paypal.svcs.types.ap.PaymentDetailsResponse;
import com.paypal.svcs.types.ap.PaymentInfo;
import com.paypal.svcs.types.ap.PaymentInfoList;
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.common.ResponseEnvelope;
import common.com.paypal.platform.sdk.exceptions.FatalException;
import common.com.paypal.platform.sdk.exceptions.SSLConnectionException;

@Service("paypalAdaptivePayService")
public class PaypalAdaptivePaymentServiceImpl implements IPaypalPaymentService{

	private static final Logger logger = LoggerFactory.getLogger(PaypalAdaptivePaymentServiceImpl.class);
	
	@Autowired
	@Qualifier("paypalProps")
	private Properties paypalProps;
	
	public GetPaymentInfoResponse getPaymentInfo(String paymentToken) {
		GetPaymentInfoResponse response = new GetPaymentInfoResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
//			String propertFile = "/paypal_sdk_client.properties";// TODO remove hardcoding
//			Properties prop = new Properties();
//			InputStream in  = PaypalAdaptivePaymentServiceImpl.class.getResourceAsStream(propertFile);
//			prop.load(in);
			AdaptivePayments payments;
			
			RequestEnvelope requestEnvelope = new RequestEnvelope();
			requestEnvelope.setErrorLanguage("en_US");
			
			PaymentDetailsRequest paramPaymentDetailsRequest = new PaymentDetailsRequest();
			paramPaymentDetailsRequest.setPayKey(paymentToken);
			paramPaymentDetailsRequest.setRequestEnvelope(requestEnvelope);

			PaymentDetailsResponse payResponse = null;
			try {
				payments = new AdaptivePayments(paypalProps);
				payResponse = payments.paymentDetails(paramPaymentDetailsRequest);
		
			} catch (FatalException e) {
				logger.error("Fatal Exception from Paypal API", e);
				status.setStatuscode(StatusCodesEnum.STATUS_PAYPAL_ERR_RESPONSE.getCode());
				status.setDescription("Exception occured - " + e.getMessage());
			} catch (PPFaultMessage e) {
				logger.error("PPFaultMessage Exception from Paypal API", e);
				status.setStatuscode(StatusCodesEnum.STATUS_PAYPAL_ERR_RESPONSE.getCode());
				status.setDescription("Exception occured - " + e.getMessage());				
			} catch (SSLConnectionException e) {
				logger.error("PPFaultMessage Exception from Paypal API", e);
				status.setStatuscode(StatusCodesEnum.STATUS_PAYPAL_ERR_RESPONSE.getCode());
				status.setDescription("Exception occured - " + e.getMessage());				
			}
			
			if(null != payResponse){
				
				ResponseEnvelope responseEnvelope = payResponse.getResponseEnvelope();			
				response.setAck(responseEnvelope.getAck().name());
				response.setTimestamp(responseEnvelope.getTimestamp().toString());
				response.setCorrelationId(responseEnvelope.getCorrelationId());
				response.setBuild(responseEnvelope.getBuild());
				
				response.setActionType(payResponse.getActionType());
				response.setCancelUrl(payResponse.getCancelUrl());
				response.setCurrencyCode(payResponse.getCurrencyCode());
				response.setFeesPayer(payResponse.getFeesPayer());
				response.setMemo(payResponse.getMemo());
				response.setPayStatus(payResponse.getStatus());
				response.setSenderEmail(payResponse.getSenderEmail());
				response.setReturnUrl(payResponse.getReturnUrl());
				response.setTrackingId(payResponse.getTrackingId());
				if(PaypalConstants.STATUS_COMPLETED.equals(payResponse.getStatus())){
					PaymentInfoList payInfoList = payResponse.getPaymentInfoList();
					if(null != payInfoList  && payInfoList.getPaymentInfo().size() > 0){
						PaymentInfo paymentInfo = payInfoList.getPaymentInfo().get(0);
						response.setSenderTransactionId(paymentInfo.getSenderTransactionId());
						response.setSenderTransactionStatus(paymentInfo.getSenderTransactionStatus());			
						response.setTransactionId(paymentInfo.getTransactionId());
						response.setTransactionStatus(paymentInfo.getTransactionStatus());	
					}
				}
				/*
				TrPayGatewayAuditLog trPayGatewayAuditLog = new TrPayGatewayAuditLog();
				trPayGatewayAuditLog.setAck(payResponse.getResponseEnvelope().getAck().value());
				trPayGatewayAuditLog.setActionType(payResponse.getActionType());
				trPayGatewayAuditLog.setBuils(payResponse.getResponseEnvelope().getBuild());
				trPayGatewayAuditLog.setCancelUrl(payResponse.getCancelUrl());
				trPayGatewayAuditLog.setCorrelationId(payResponse.getResponseEnvelope().getCorrelationId());
				trPayGatewayAuditLog.setCurrencyCode(payResponse.getCurrencyCode());
				trPayGatewayAuditLog.setFeesPayer(payResponse.getFeesPayer());
				trPayGatewayAuditLog.setMemo(payResponse.getMemo());
				trPayGatewayAuditLog.setPayStatus(payResponse.getStatus());
				
//				trPayGatewayAuditLog.setPendingReason(payResponse.getp);
				trPayGatewayAuditLog.setReturnUrl(payResponse.getReturnUrl());
				trPayGatewayAuditLog.setSecureToken(payResponse.getPayKey());
				trPayGatewayAuditLog.setSenderEmail(payResponse.getSenderEmail());
//				trPayGatewayAuditLog.setSenderTransactionId(senderTransactionId);
//				trPayGatewayAuditLog.setSnderTransactionStatus(snderTransactionStatus);
				trPayGatewayAuditLog.setTimestamp(payResponse.getResponseEnvelope().getTimestamp().toGregorianCalendar());
//				trPayGatewayAuditLog.setTransactionId(transactionId);
//				trPayGatewayAuditLog.setTransactionStatus(transactionStatus);
				this.createPaypalLog(trPayGatewayAuditLog);	
				*/
			}
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Exception occured");
		}
		return response;
	}

	public SetupPaymentResponse setupPayment(SetupPaymentRequest request) {
		SetupPaymentResponse response = new SetupPaymentResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			
//			String propertFile = "/paypal_sdk_client.properties";// TODO remove hardcoding
//			Properties prop = new Properties();
//			InputStream in  = PaypalAdaptivePaymentServiceImpl.class.getResourceAsStream(propertFile);
//			prop.load(in);
			AdaptivePayments payments = new AdaptivePayments(paypalProps);
			PayRequest paramPayRequest = new PayRequest();
			paramPayRequest.setActionType("CREATE");//
			// paramPayRequest.setClientDetails(value);
			paramPayRequest.setCurrencyCode("USD");
			paramPayRequest.setCancelUrl(request.getCancelUrl());
			paramPayRequest.setReturnUrl(request.getReturnUrl());
			paramPayRequest.setIpnNotificationUrl(request.getIpnUrl());
			BigDecimal totalAmt = new BigDecimal("0.00");			
			List<OrderItem> orderItemsList =  request.getOrderItem();
			for(OrderItem orderItem: orderItemsList){
				//double itemTotal = orderItem.getPrice() * orderItem.getQuantity();
				totalAmt = totalAmt.add(orderItem.getPrice());
			}
			
			ReceiverList receiverList = new ReceiverList();
			List<Receiver> receivers = receiverList.getReceiver(); 
			Receiver receiver = new Receiver();
			BigDecimal dbNowithdoublefraction = totalAmt.setScale(2,RoundingMode.UNNECESSARY); 
			receiver.setAmount(dbNowithdoublefraction);
//			receiver.setEmail("pardha_1345165264_biz@gmail.com");//TODO
			receiver.setEmail(paypalProps.getProperty("PAYPAL-RECEIVER-EMAIL-ID"));
			receivers.add(receiver);
			
			RequestEnvelope requestEnvelope = new RequestEnvelope();
			requestEnvelope.setErrorLanguage("en_US");
			
			paramPayRequest.setRequestEnvelope(requestEnvelope);
			paramPayRequest.setReceiverList(receiverList);


//			FundingTypeList fundingTypeList = new FundingTypeList();
//			List<FundingTypeInfo> fundingTypeInfoList= fundingTypeList.getFundingTypeInfo();
//			FundingTypeInfo fundingTypeInfo = new FundingTypeInfo();
//			fundingTypeInfo.setFundingType(PaypalConstants.FUNDING_TYPE_CREDITCARD);
//			fundingTypeInfoList.add(fundingTypeInfo); 
//			FundingConstraint fundingConstraint = new FundingConstraint();
//			fundingConstraint.setAllowedFundingType(fundingTypeList);
//			paramPayRequest.setFundingConstraint(fundingConstraint);
			
			
			PayResponse payResponse = payments.pay(paramPayRequest);
			response.setPaymentToken(payResponse.getPayKey());
			
			TrPayGatewayAuditLog trPayGatewayAuditLog = new TrPayGatewayAuditLog();
			trPayGatewayAuditLog.setAck(payResponse.getResponseEnvelope().getAck().value());
//			trPayGatewayAuditLog.setActionType(payResponse.getResponseEnvelope().get);
			trPayGatewayAuditLog.setBuils(payResponse.getResponseEnvelope().getBuild());
			trPayGatewayAuditLog.setCancelUrl(request.getCancelUrl());
			trPayGatewayAuditLog.setCorrelationId(payResponse.getResponseEnvelope().getCorrelationId());
//			trPayGatewayAuditLog.setCurrencyCode();
//			trPayGatewayAuditLog.setFeesPayer(feesPayer);
			trPayGatewayAuditLog.setMemo("New transaction created and Total amouunt requested:" + totalAmt);
			trPayGatewayAuditLog.setPayStatus("CREATED");
//			trPayGatewayAuditLog.setPendingReason(pendingReason);
			trPayGatewayAuditLog.setReturnUrl(request.getReturnUrl());
			trPayGatewayAuditLog.setSecureToken(payResponse.getPayKey());
//			trPayGatewayAuditLog.setSenderEmail(senderEmail);
//			trPayGatewayAuditLog.setSenderTransactionId(senderTransactionId);
//			trPayGatewayAuditLog.setSnderTransactionStatus(snderTransactionStatus);
			trPayGatewayAuditLog.setTimestamp(payResponse.getResponseEnvelope().getTimestamp().toGregorianCalendar());
//			trPayGatewayAuditLog.setTransactionId(transactionId);
			trPayGatewayAuditLog.setTransactionStatus("Sent to Paypal");
			this.createPaypalLog(trPayGatewayAuditLog);
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}

/*
 * Kamlesh - Not sure this is used by Pardha - Using this service for logging any IPN messages received.	(non-Javadoc)
 * @see com.f9g4.services.rest.IPaypalPaymentService#completePayment(com.f9g4.businessobjects.services.CompletePaymentRequest)
 */
	public CompletePaymentResponse completePayment(CompletePaymentRequest request) {
		CompletePaymentResponse response = new CompletePaymentResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			
			/*String propertFile = "/paypal_sdk_client.properties";// TODO remove hardcoding
			Properties prop = new Properties();
			InputStream in  = PaypalAdaptivePaymentServiceImpl.class.getResourceAsStream(propertFile);
			prop.load(in);*/
			AdaptivePayments payments = new AdaptivePayments(paypalProps);
			
			ExecutePaymentRequest execRequest = new ExecutePaymentRequest();
			execRequest.setPayKey(request.getPaymentToken());
			RequestEnvelope requestEnvelope = new RequestEnvelope();
			requestEnvelope.setErrorLanguage("en_US");
			execRequest.setRequestEnvelope(requestEnvelope);
			ExecutePaymentResponse payResponse = payments.executePayment(execRequest);			
			String respStatus = payResponse.getPaymentExecStatus();
			logger.debug("respStatus :" + respStatus);
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}
	
	@Autowired
	private TrPayGatewayAuditLogDAO trPayGatewayAuditLogDAO;
	
	private void createPaypalLog(TrPayGatewayAuditLog trPayGatewayAuditLog){
		trPayGatewayAuditLogDAO.merge(trPayGatewayAuditLog);
	}

	public GetReceiverEmail getReceiverEmail() {
		GetReceiverEmail response = new GetReceiverEmail();
		response.setReceiverEmail(paypalProps.getProperty("PAYPAL-RECEIVER-EMAIL-ID"));
		return response;
	}

	public LogPaypalTransactionResponse logPaypalMessage(
			LogPaypalTransactionRequest request) {
		// TODO Auto-generated method stub
		LogPaypalTransactionResponse response= new LogPaypalTransactionResponse();
		Status status= new Status();
		
		try {
			TrPayGatewayAuditLog log=new TrPayGatewayAuditLog();
			log.setAck("Success");
			log.setActionType(request.getTrPaypalMessageDomain().getActionType());
			log.setCancelUrl(request.getTrPaypalMessageDomain().getCancelUrl());
			log.setCorrelationId(null);
			log.setCurrencyCode(null);
			log.setFeesPayer(request.getTrPaypalMessageDomain().getFeesPayer());
			log.setMemo(request.getTrPaypalMessageDomain().getMemo());
			log.setPayStatus(request.getTrPaypalMessageDomain().getPayStatus());
			log.setPendingReason(request.getTrPaypalMessageDomain().getPendingReason());
			log.setReturnUrl(request.getTrPaypalMessageDomain().getReturnUrl());
			log.setSecureToken(request.getTrPaypalMessageDomain().getPaykey());
			log.setSenderEmail(request.getTrPaypalMessageDomain().getSenderEmail());
			log.setSenderTransactionId(request.getTrPaypalMessageDomain().getSenderTransactionId());
			log.setSnderTransactionStatus(request.getTrPaypalMessageDomain().getSenderTransactionStatus());
			log.setTrackingId(request.getTrPaypalMessageDomain().getTrackingId());
			log.setTimestamp(Calendar.getInstance()); //Change the code to getit from paypal response.
			log.setTransactionStatus(request.getTrPaypalMessageDomain().getTransactionStatus());
			log.setBuils(request.getTrPaypalMessageDomain().getBuild());
			log.setCorrelationId(request.getTrPaypalMessageDomain().getSenderTransactionId());
			
			this.createPaypalLog(log);
			status.setStatuscode("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status.setStatuscode("0");
		}
		
		
		response.setStatus(status);
		return response;
	}
	
	
}