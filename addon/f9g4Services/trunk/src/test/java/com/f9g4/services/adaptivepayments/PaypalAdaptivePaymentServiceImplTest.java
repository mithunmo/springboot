package com.f9g4.services.adaptivepayments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

import com.f9g4.businessobjects.services.CompletePaymentRequest;
import com.f9g4.businessobjects.services.CompletePaymentResponse;
import com.f9g4.businessobjects.services.GetPaymentInfoResponse;
import com.f9g4.businessobjects.services.OrderItem;
import com.f9g4.businessobjects.services.SetupPaymentRequest;
import com.f9g4.businessobjects.services.SetupPaymentResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.services.rest.IPaypalPaymentService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class PaypalAdaptivePaymentServiceImplTest {
	
	@Autowired
	@Qualifier("paypalAdaptivePayService")
	IPaypalPaymentService  service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPaymentInfo() {

		SetupPaymentRequest request = new SetupPaymentRequest();
		request.setCancelUrl("http://98.234.125.133/f94g/pay/cancel");
		request.setReturnUrl("http://98.234.125.133/f94g/pay/return");
		List<OrderItem> orderItems = request.getOrderItem();
		OrderItem orderItem = new OrderItem();
		orderItem.setDescription("Board 1");
		orderItem.setName("Board 1");
		orderItem.setPrice(new BigDecimal("1.00"));
		orderItem.setQuantity(1);
		orderItems.add(orderItem);
		
		SetupPaymentResponse response  = service.setupPayment(request);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertNotNull(response.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), response.getStatus().getStatuscode());
		assertNotNull(response.getPaymentToken());
		assertTrue(response.getPaymentToken().trim().length() > 0);
		System.out.println(response.getPaymentToken());

		GetPaymentInfoResponse getPaymentInfoResponse = service.getPaymentInfo(response.getPaymentToken());
//		GetPaymentInfoResponse getPaymentInfoResponse = service.getPaymentInfo("AP-26W87005H6130704P");
		assertNotNull(getPaymentInfoResponse);
		assertNotNull(getPaymentInfoResponse.getStatus());
		assertNotNull(getPaymentInfoResponse.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), getPaymentInfoResponse.getStatus().getStatuscode());

		
	}

	@Test
	public void testSetupPayment() {

		SetupPaymentRequest request = new SetupPaymentRequest();
		request.setCancelUrl("http://98.234.125.133/f94g/pay/cancel");
		request.setReturnUrl("http://98.234.125.133/f94g/pay/return?test=abc");
		List<OrderItem> orderItems = request.getOrderItem();
		OrderItem orderItem = new OrderItem();
		orderItem.setDescription("Board 1");
		orderItem.setName("Board 1");
		orderItem.setPrice(new BigDecimal("1.00"));
		orderItem.setQuantity(1);
		orderItems.add(orderItem);
		
		SetupPaymentResponse response  = service.setupPayment(request);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertNotNull(response.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), response.getStatus().getStatuscode());
		assertNotNull(response.getPaymentToken());
		assertTrue(response.getPaymentToken().trim().length() > 0);
		System.out.println(response.getPaymentToken());
	}

	@Test
	public void testCompletePayment() {
		
		SetupPaymentRequest request = new SetupPaymentRequest();
		request.setCancelUrl("http://98.234.125.133/f94g/pay/cancel");
		request.setReturnUrl("http://98.234.125.133/f94g/pay/return");
		List<OrderItem> orderItems = request.getOrderItem();
		OrderItem orderItem = new OrderItem();
		orderItem.setDescription("Board 1");
		orderItem.setName("Board 1");
		orderItem.setPrice(new BigDecimal("1.00"));
		orderItem.setQuantity(1);
		orderItems.add(orderItem);
		
		SetupPaymentResponse response  = service.setupPayment(request);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertNotNull(response.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), response.getStatus().getStatuscode());
		assertNotNull(response.getPaymentToken());
		assertTrue(response.getPaymentToken().trim().length() > 0);
		System.out.println(response.getPaymentToken());
		
		CompletePaymentRequest completePaymentRequest = new CompletePaymentRequest();
		completePaymentRequest.setPaymentToken(response.getPaymentToken());
		CompletePaymentResponse completePaymentResponse = service.completePayment(completePaymentRequest);
		
		assertNotNull(completePaymentResponse);
		assertNotNull(completePaymentResponse.getStatus());
		assertNotNull(completePaymentResponse.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), completePaymentResponse.getStatus().getStatuscode());

	}

}
