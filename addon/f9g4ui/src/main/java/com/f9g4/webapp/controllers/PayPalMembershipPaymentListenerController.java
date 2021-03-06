package com.f9g4.webapp.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

//import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.f9g4.businessobjects.domain.TrSalesTransactionDetailsDomain;
import com.f9g4.businessobjects.domain.TrSalesTransactionHeaderDomain;
import com.f9g4.businessobjects.services.CreateSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionResponse;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdRequest;
import com.f9g4.businessobjects.services.GetGrossbyTransactionIdResponse;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationRequest;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationResponse;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsRequest;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.PaypalConstants;
import com.f9g4.servicesdk.SalesTransactionServiceSDK;
import com.f9g4.web.utils.ViewPaths;
import com.f9g4.webapp.paypal.IPNMessage.IPaypalMessageProcessor;
import com.f9g4.webapp.paypal.IPNMessage.PaymentProcessorFactory;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;
import com.sun.xml.internal.ws.api.PropertySet.Property;


@Controller
public class PayPalMembershipPaymentListenerController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayPalMembershipPaymentListenerController.class);
	

	
	@Autowired @Value("${paypalIPNUrl}")
	private String paypalIPNUrl;
	
	
	@Autowired
	private PaymentProcessorFactory paypalFactory;
	
	
	


	public PaymentProcessorFactory getPaypalFacory() {
		return paypalFactory;
	}

	public void setPaypalFacory(PaymentProcessorFactory paypalFacory) {
		this.paypalFactory = paypalFacory;
	}

	public String getPaypalIPNUrl() {
		return paypalIPNUrl;
	}

	public void setPaypalIPNUrl(String paypalIPNUrl) {
		this.paypalIPNUrl = paypalIPNUrl;
	}

	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@RequestMapping(value=ViewPaths.PAYMENT_MEMBERSHIP_LISTENER, method=RequestMethod.POST)
	public void paymentListenerGet(HttpServletRequest request)
	{
		Enumeration en = request.getParameterNames();
		StringBuffer strBuffer = new StringBuffer("cmd=_notify-validate");
		String paramValue;
		while (en.hasMoreElements()) {
			String paramName;
			paramName = (String) en.nextElement();
			paramValue = request.getParameter(paramName);
			strBuffer.append("&").append(paramName).append("=")
					.append(URLEncoder.encode(paramValue));
				logger.error("**********************************************************************************");
				logger.error(paramName +"=" + paramValue);
				logger.error("**********************************************************************************");
			
			
		}
	 
		// post back to PayPal system to validate
		// NOTE: change http: to https: in the following URL to verify using SSL (for increased security).
		// using HTTPS requires either Java 1.4 or greater, or Java Secure Socket Extension (JSSE)
		// and configured for older versions.
		String res ="";
		try{
		//URL u = new URL("https://www.paypal.com/cgi-bin/webscr");
		URL u = new URL(this.paypalIPNUrl);
		HttpsURLConnection uc = (HttpsURLConnection) u.openConnection();
		uc.setDoOutput(true);
		uc.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		uc.setRequestProperty("Host", "www.paypal.com");
		PrintWriter pw = new PrintWriter(uc.getOutputStream());
		pw.println(strBuffer.toString());
		pw.close();
	 
		BufferedReader in = new BufferedReader(new InputStreamReader(
				uc.getInputStream()));
		res = in.readLine();
		in.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		try{
		// check notification validation 
			if (res.equals("VERIFIED")) {

				IPaypalMessageProcessor processor= paypalFactory.getProcessor("adaptiveMembershipProceesor");
				if(null== processor){
					logger.error("Error creating Paypal payment processor for transaction type " + request.getParameter("transaction_type"));
				}else{
					processor.processPaypalMessage(request);
				}
				
			} else if (res.equals("INVALID")) {
				logger.error("********* Review this ******** PAYPAL RESPONSE SAYS THIS RESPONSE IS INVLAID - SOME ONE IS TRYING TO HACK*******************");
			} else {
				// error
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
}
