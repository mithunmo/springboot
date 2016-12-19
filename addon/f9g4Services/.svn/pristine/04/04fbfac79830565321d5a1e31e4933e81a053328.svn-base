package com.f9g4.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.wstx.util.DataUtil;
import com.f9g4.businessobjects.domain.AdActiveUserDomain;
import com.f9g4.businessobjects.domain.TrRecentlyViewedDomain;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardRequest;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardResponse;
import com.f9g4.businessobjects.services.AddUserLogRequest;
import com.f9g4.businessobjects.services.GetActiveuserResponse;
import com.f9g4.services.rest.IDataCaptureService;
import com.f9g4.util.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class DataCaptureServiceTest {

@Autowired
private IDataCaptureService dataCaptureService;

@Test
public void testaddRecentlyViewBoard(){

	TrRecentlyViewedDomain domain = new TrRecentlyViewedDomain();
	AddRecentlyViewedBoardRequest request= new AddRecentlyViewedBoardRequest();
	domain.setBoardId(26);
	domain.setCreatedby(17);
	domain.setUserId(17);
	try {
		domain.setEventTime(DateUtil.toXMLGregorianCalendar(Calendar.getInstance()));
	} catch (DatatypeConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setLogBoard(domain);
	AddRecentlyViewedBoardResponse response= dataCaptureService.addRecentlyViewBoard(request);
	assertNotNull(response);
	assertEquals("Matched", response.getStatus().getStatuscode(), "1");
}

@Test
public void  testLogger()	{
	AdActiveUserDomain domain = new AdActiveUserDomain();
	domain.setUserId(17);
	domain.setCreatedby(17);
	try {
		domain.setLoginDate(DateUtil.toXMLGregorianCalendar(Calendar.getInstance()));
	} catch (DatatypeConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	domain.setSessionId(UUID.randomUUID().toString());
	AddUserLogRequest request= new AddUserLogRequest();
	request.setUserLogger(domain);
	
	dataCaptureService.logUserData(request);
}

@Test
public void testgetActiveUserLoggedRecord(){
	GetActiveuserResponse domain=dataCaptureService.getActiveUserLoggedRecord("45f68a59-cecf-4714-a255-f1b1504c4557");
	assertNotNull(domain);
	assertNotNull(domain.getUserinfo());
	
}
}
