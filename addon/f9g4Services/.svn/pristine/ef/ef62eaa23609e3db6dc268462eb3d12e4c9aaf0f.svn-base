package com.f9g4.services;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.ListIterator;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.services.GetNotificationQForStatusResponse;
import com.f9g4.businessobjects.services.UpdateNotificationQRequest;
import com.f9g4.businessobjects.services.UpdateNotificationQResponse;
import com.f9g4.services.SendMailSSLJob;
import com.f9g4.services.rest.INotificationQService;
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
public class SendEmailServiceImplTest {

	@Autowired
	private INotificationQService notificationQService = null;

	
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
	public void emailtest() throws DatatypeConfigurationException {
		//Get all Pending notification that are to be Sent
	/*	GetNotificationQForStatusResponse response  = notificationQService.getNotificationQForStatus(525);
		
		ListIterator<TrNotificationQDomain> itr = response.getNotificationQ().listIterator();
		while ( itr.hasNext()) {
			TrNotificationQDomain domain = response.getNotificationQ().get(itr.nextIndex());
			//Update status as Sending so that other process won't pickup
			domain.setEmailStatusId(526);
			domain.setDeliveryDate(DateUtil.toXMLGregorianCalendar(Calendar.getInstance()));
			UpdateNotificationQRequest request = new UpdateNotificationQRequest();			
			request.setNotificationQ(domain);
			
			System.out.println("email "+request.getNotificationQ().getEmailStatusId());
			UpdateNotificationQResponse response1 = notificationQService.updateNotificationQ(request);
		 	response1.getStatus();
			itr.next();
		}
		*/
		//Get all Notification with sending status
		GetNotificationQForStatusResponse response1  = notificationQService.getNotificationQForStatus(525);		
		ListIterator<TrNotificationQDomain> itr1 = response1.getNotificationQ().listIterator();
		while ( itr1.hasNext()) {
			TrNotificationQDomain domain1 = response1.getNotificationQ().get(itr1.nextIndex());
			
			SendMailSSLJob mail = new SendMailSSLJob();
			mail.sendemail(domain1);	
			//assertNotNull(mail);
			System.out.println("Notif "+domain1.getNotificationId()+" stta "+domain1.getEmailStatusId());
			UpdateNotificationQRequest request1 = new UpdateNotificationQRequest();
			//Set Staus to sent
			domain1.setEmailStatusId(454);
			domain1.setDeliveryDate(DateUtil.toXMLGregorianCalendar(Calendar.getInstance()));
			request1.setNotificationQ(domain1);
			System.out.println("email "+request1.getNotificationQ().getEmailStatusId());
		 	notificationQService.updateNotificationQ(request1);
		 	itr1.next();
		}
		
	}

	}
