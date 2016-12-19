package com.f9g4.services;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsItemType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

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
import com.f9g4.services.rest.IPaypalPaymentService;

@Service("paypalPaymentService")
public class PaypalPaymentServiceImpl implements IPaypalPaymentService  {

	private static final Logger logger = LoggerFactory.getLogger(PaypalPaymentServiceImpl.class);

	public GetPaymentInfoResponse getPaymentInfo(String paymentToken) {
		GetPaymentInfoResponse response = new GetPaymentInfoResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		try{
			InputStream in = PaypalPaymentServiceImpl.class.getResourceAsStream("/sdk_config.properties");//TODO remove hardcoding..and make it one time read..
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(in);
			
			GetExpressCheckoutDetailsReq req = new GetExpressCheckoutDetailsReq();
			GetExpressCheckoutDetailsRequestType reqType = new GetExpressCheckoutDetailsRequestType();
			reqType.setToken(paymentToken);
			req.setGetExpressCheckoutDetailsRequest(reqType);
			GetExpressCheckoutDetailsResponseType resp = service.getExpressCheckoutDetails(req);
			logger.debug("lastReq", service.getLastRequest());
			logger.debug("lastResp", service.getLastResponse());
			
			if (resp != null && resp.getAck().toString().equalsIgnoreCase("SUCCESS")) {
					//response.setPayerID(resp.getGetExpressCheckoutDetailsResponseDetails().getPayerInfo().getPayerID());
					logger.debug("Checkout Status :" + resp.getGetExpressCheckoutDetailsResponseDetails().getCheckoutStatus());
					logger.debug("getPaymentDetails() :" + resp.getGetExpressCheckoutDetailsResponseDetails().getPaymentDetails());
					resp.getGetExpressCheckoutDetailsResponseDetails().getToken();
			} else {
				//TODO error handling
				status.setStatuscode(StatusCodesEnum.STATUS_PAYPAL_ERR_RESPONSE.getCode());
			}
			
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}
	
	public SetupPaymentResponse setupPayment(SetupPaymentRequest request) {

		SetupPaymentResponse response = new SetupPaymentResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			InputStream in = PaypalPaymentServiceImpl.class.getResourceAsStream("/sdk_config.properties");//TODO remove hardcoding..and make it one time read..
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(in);

			SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
			SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();
			details.setReturnURL(request.getReturnUrl());
			details.setCancelURL(request.getCancelUrl());
			
			BigDecimal orderTotal = new BigDecimal("0.00");
			List<PaymentDetailsItemType> lineItems = new ArrayList<PaymentDetailsItemType>();
			List<OrderItem> orderItems = request.getOrderItem();
			for(OrderItem orderItem : orderItems){
				PaymentDetailsItemType item = new PaymentDetailsItemType();
				BasicAmountType amt = new BasicAmountType();
				amt.setCurrencyID(CurrencyCodeType.USD);//TODO get from input ????
				BigDecimal curPrice = orderItem.getPrice().setScale(2, RoundingMode.UNNECESSARY); 
				amt.setValue(curPrice.toString());
				item.setAmount(amt); 
				item.setQuantity(orderItem.getQuantity());
				item.setName(orderItem.getName());
				item.setDescription(orderItem.getDescription());
				orderTotal =  orderTotal.add(curPrice);
				lineItems.add(item);		
			}

			List<PaymentDetailsType> payDetails = new ArrayList<PaymentDetailsType>();
			PaymentDetailsType paydtl = new PaymentDetailsType();
			paydtl.setPaymentAction(PaymentActionCodeType.SALE);
			BasicAmountType itemsTotal = new BasicAmountType();
			itemsTotal.setValue(orderTotal.toString());
			itemsTotal.setCurrencyID(CurrencyCodeType.USD);
			paydtl.setItemTotal(itemsTotal);
			paydtl.setOrderTotal(new BasicAmountType(CurrencyCodeType.USD, orderTotal.toString()));
			paydtl.setPaymentDetailsItem(lineItems);
			payDetails.add(paydtl);
			details.setPaymentDetails(payDetails);
			setExpressCheckoutReq.setSetExpressCheckoutRequestDetails(details);
			
			SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
			expressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutReq);

			//invoke paypal
			SetExpressCheckoutResponseType setExpressCheckoutResponse = service.setExpressCheckout(expressCheckoutReq);

			logger.debug("lastReq", service.getLastRequest());
			logger.debug("lastResp", service.getLastResponse());
			
			if(setExpressCheckoutResponse != null && setExpressCheckoutResponse.getAck().toString().equalsIgnoreCase("SUCCESS")) {
				response.setPaymentToken(setExpressCheckoutResponse.getToken());
			} else {
				//TODO error handling
				status.setStatuscode(StatusCodesEnum.STATUS_PAYPAL_ERR_RESPONSE.getCode());
			}
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}

	public CompletePaymentResponse completePayment(CompletePaymentRequest request) {
		CompletePaymentResponse response = new CompletePaymentResponse();
		Status status = new Status();
		status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		response.setStatus(status);
		try{
			InputStream in = PaypalPaymentServiceImpl.class.getResourceAsStream("/sdk_config.properties");//TODO remove hardcoding..and make it one time read..
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(in);
			String payerId = request.getPayerID();
			if(StringUtils.isEmpty(payerId)){
				GetPaymentInfoResponse payInfoRes = this.getPaymentInfo(request.getPaymentToken());
				if(StatusCodesEnum.STATUS_SUCCESS.getCode().equals(payInfoRes.getStatus().getStatuscode())){
					//payerId = payInfoRes.getPayerID();
				}else{
					//error
					status.setStatuscode(payInfoRes.getStatus().getStatuscode());
					return response;
				}
			}else{
				
			}
			
			DoExpressCheckoutPaymentRequestType doCheckoutPaymentRequestType = new DoExpressCheckoutPaymentRequestType();
			DoExpressCheckoutPaymentRequestDetailsType details = new DoExpressCheckoutPaymentRequestDetailsType();
			details.setToken(request.getPaymentToken());
			details.setPayerID(payerId);
			//details.setPaymentAction(PaymentActionCodeType.SALE); - depricated
			
			
			BigDecimal orderTotal = new BigDecimal("0.00");
			List<PaymentDetailsItemType> lineItems = new ArrayList<PaymentDetailsItemType>();
			List<OrderItem> orderItems = request.getOrderItem();
			for(OrderItem orderItem : orderItems){
				PaymentDetailsItemType item = new PaymentDetailsItemType();
				BasicAmountType amt = new BasicAmountType();
				amt.setCurrencyID(CurrencyCodeType.USD);//TODO get from input ????
				BigDecimal curVal = orderItem.getPrice().setScale(2,RoundingMode.UNNECESSARY); 
				amt.setValue(curVal.toString());
				item.setAmount(amt); 
				item.setQuantity(orderItem.getQuantity());
				item.setName(orderItem.getName());
				item.setDescription(orderItem.getDescription());
				orderTotal.add(orderItem.getPrice());
				lineItems.add(item);		
			}

			
			List<PaymentDetailsType> payDetails = new ArrayList<PaymentDetailsType>();
			PaymentDetailsType paydtl = new PaymentDetailsType();
			paydtl.setPaymentAction(PaymentActionCodeType.SALE);
			BasicAmountType itemsTotal = new BasicAmountType();
			itemsTotal.setValue(orderTotal.toString());
			itemsTotal.setCurrencyID(CurrencyCodeType.USD);
			paydtl.setItemTotal(itemsTotal);
			paydtl.setOrderTotal(new BasicAmountType(CurrencyCodeType.USD, orderTotal.toString()));
			paydtl.setPaymentDetailsItem(lineItems);
			payDetails.add(paydtl);
			details.setPaymentDetails(payDetails);

			doCheckoutPaymentRequestType.setDoExpressCheckoutPaymentRequestDetails(details);
			DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq = new DoExpressCheckoutPaymentReq();
			doExpressCheckoutPaymentReq.setDoExpressCheckoutPaymentRequest(doCheckoutPaymentRequestType);

			DoExpressCheckoutPaymentResponseType doCheckoutPaymentResponseType = service.doExpressCheckoutPayment(doExpressCheckoutPaymentReq);

			logger.debug("lastReq", service.getLastRequest());
			logger.debug("lastResp", service.getLastResponse());
			
			response.setPayerID(payerId);
			
			if (doCheckoutPaymentResponseType != null && doCheckoutPaymentResponseType.getAck().toString().equalsIgnoreCase("SUCCESS")) {
				
				Iterator<PaymentInfoType> iterator = doCheckoutPaymentResponseType.getDoExpressCheckoutPaymentResponseDetails()
													.getPaymentInfo().iterator();
				int index = 1;
				while (iterator.hasNext()) {
					PaymentInfoType result = (PaymentInfoType) iterator.next();
					logger.debug("Transaction ID" + index +":" + result.getTransactionID());
					response.setTransactionID(result.getTransactionID()); //Assuming we will have only one transaction id 
					index++;
				} 
			}
		
		}catch(Throwable th){
			logger.error("Exception Occurred", th);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}

	public GetReceiverEmail getReceiverEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public LogPaypalTransactionResponse logPaypalMessage(
			LogPaypalTransactionRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
}