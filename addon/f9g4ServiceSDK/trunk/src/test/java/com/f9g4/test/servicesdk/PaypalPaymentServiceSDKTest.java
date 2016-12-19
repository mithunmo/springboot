package com.f9g4.test.servicesdk;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.f9g4.businessobjects.services.GetPaymentInfoResponse;
import com.f9g4.businessobjects.services.OrderItem;
import com.f9g4.businessobjects.services.SetupPaymentRequest;
import com.f9g4.businessobjects.services.SetupPaymentResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.servicesdk.PaypalPaymentServiceSDK;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class PaypalPaymentServiceSDKTest {

	@Autowired
	private PaypalPaymentServiceSDK paymentsdk;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetPymentInfo(){
		SetupPaymentRequest request = new SetupPaymentRequest();
		request.setCancelUrl("http://98.234.125.133/f94g/pay/cancel");
		request.setReturnUrl("http://98.234.125.133/f94g/pay/return");
		List<OrderItem> orderItems = request.getOrderItem();
		OrderItem orderItem = new OrderItem();
		orderItem.setDescription("Board 1");
		orderItem.setName("Board 1");
		orderItem.setPrice(new BigDecimal("0.00"));
		orderItem.setQuantity(1);
		orderItems.add(orderItem);
		
		SetupPaymentResponse response  = paymentsdk.setupPayment(request);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertNotNull(response.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), response.getStatus().getStatuscode());
		assertNotNull(response.getPaymentToken());
		assertTrue(response.getPaymentToken().trim().length() > 0);
		System.out.println(response.getPaymentToken());
		
		GetPaymentInfoResponse getPaymentInfoResponse = paymentsdk.getPaymentInfo(response.getPaymentToken());
		assertNotNull(getPaymentInfoResponse);
		assertNotNull(getPaymentInfoResponse.getStatus());
		assertNotNull(getPaymentInfoResponse.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), getPaymentInfoResponse.getStatus().getStatuscode());


		
	}
	
	@Test
	public void testSetPaymentInfo(){
		
		SetupPaymentRequest request = new SetupPaymentRequest();
		request.setCancelUrl("http://98.234.125.133/f94g/pay/cancel");
		request.setReturnUrl("http://98.234.125.133/f94g/pay/return");
		List<OrderItem> orderItems = request.getOrderItem();
		OrderItem orderItem = new OrderItem();
		orderItem.setDescription("Board 1");
		orderItem.setName("Board 1");
		orderItem.setPrice(new BigDecimal("1.0"));
		orderItem.setQuantity(1);
		orderItems.add(orderItem);
		
		SetupPaymentResponse response  = paymentsdk.setupPayment(request);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertNotNull(response.getStatus().getStatuscode());
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), response.getStatus().getStatuscode());
		assertNotNull(response.getPaymentToken());
		assertTrue(response.getPaymentToken().trim().length() > 0);
		System.out.println(response.getPaymentToken());
		
	}
	

}
