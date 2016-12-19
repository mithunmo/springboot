package com.f9g4.services;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.services.CreateSalesTransactionResponse;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionRequest;
import com.f9g4.businessobjects.services.CreateTrSalesTransactionResponse;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationRequest;
import com.f9g4.businessobjects.services.GetReceiverEmailVerificationResponse;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsRequest;
import com.f9g4.businessobjects.services.GetTrSalesTransactionHeaderExistsResponse;
import com.f9g4.services.rest.ISalesTransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class SalesTransactionServiceImplTest {
	
	@Autowired
	private ISalesTransactionService salesTransactionService = null;
	
	@Autowired
	@Qualifier("paypalProps")
	private Properties paypalProps;
	
	@Test
	public void TestReceiverEmail()
	{
		System.out.println(paypalProps.getProperty("PAYPAL-RECEIVER-EMAIL-ID"));
	}
	
	@Test
	public void getTrSalesTransactionHeaderExists()
	{
		GetTrSalesTransactionHeaderExistsRequest request = new GetTrSalesTransactionHeaderExistsRequest();
		request.setTransactionId("AP-79B46172VR396205V");
		GetTrSalesTransactionHeaderExistsResponse response = salesTransactionService.getTrSalesTransactionHeaderExists(request);
		System.out.println(response.isTrSalesTransactionHeaderExists());
	}
	
	@Test
	public void getReceiverEmailVerification()
	{
		GetReceiverEmailVerificationRequest request = new GetReceiverEmailVerificationRequest();
		request.setReceiverEmail("test3company1_1354652677_biz@gmail.com1");
		GetReceiverEmailVerificationResponse response = salesTransactionService.GetReceiverEmailVerification(request);
		System.out.println(response.isIsReceiverEmailVerified());
	}
	
	@Test
	public void testCreateTrSalesTransaction(){
		CreateTrSalesTransactionRequest request = new CreateTrSalesTransactionRequest();
		request.setPayKey("AP-21P30504H7883505X");
		CreateTrSalesTransactionResponse response = salesTransactionService.CreateTrSalesTransaction(request);
		System.out.println("Description -> "+response.getStatus().getStatuscode());
	}
	

}
