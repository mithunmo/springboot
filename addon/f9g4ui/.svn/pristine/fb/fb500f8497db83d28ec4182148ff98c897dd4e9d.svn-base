package com.f9g4.webapp.paypal.IPNMessage;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdaptivePaymentMessageProcessor implements IPaypalMessageProcessor {
	private static final Logger logger = LoggerFactory
			.getLogger(AdaptivePaymentMessageProcessor.class);

	@Autowired
	private PaypalMessageProcessorHelperService helper;

	public void processPaypalMessage(HttpServletRequest request) {
		String paymentStatus = request.getParameter("transaction[0].status");
		String paymentAmount = request.getParameter("transaction[0].amount");
		// String paymentCurrency = request.getParameter("mc_currency");
		String receiverEmail = request.getParameter("transaction[0].receiver");
		// gotta check whether he is getting the correct pay key if not gotta
		// make sure to get the correct pay key!!
		String payKey = request.getParameter("pay_key");
		
		

		if (paymentStatus.equals("Completed")) {
			
			
			// check whether payKey has not been processed
			if (!helper.CheckTransactionProcessed(payKey)) {
				if(helper.logPaypalMessgae(request)){
					logger.debug("Transaction log saved ");
				}else
					logger.error("Error Saving transaction log");
				// check whether this the same price as the one specified
				// got to check the currency too
				// Price brings data with the currency got to parse it before
				// checking
				// if(CheckPrice(payKey,paymentAmount))
				{
					// check receiver Email Id
					if (helper.CheckReceiverEmail(receiverEmail)) {
							if(helper.ProcessPayment(payKey)){
								logger.debug("Process completed");
							}else
								logger.error("***************Error occured processing Payment**************");
					} else {
						logger.error("****PAYPAL RECEIVER DO NOT MATCH ********** PLEASE VALIDATE ******");
					}

				}
			} else {
				logger.debug("Transaction already Processed - No action needed");
			}
		}

	}

}
