package com.f9g4.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.services.AddNotificationQRequest;
import com.f9g4.businessobjects.services.AddNotificationQResponse;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersRequest;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeContainingResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeResponse;
import com.f9g4.businessobjects.services.GetNotificationQByIdResponse;
import com.f9g4.businessobjects.services.GetNotificationQForStatusResponse;
import com.f9g4.businessobjects.services.GetNotificationQForUserResponse;
import com.f9g4.businessobjects.services.UpdateNotificationQRequest;
import com.f9g4.businessobjects.services.UpdateNotificationQResponse;
import com.f9g4.common.util.LookupTypeValueEnum;
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
public class NotificationQServiceImplTest {

	
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
	//@Rollback(false)
	public void testAddNotificationQ() throws Exception {
		AddNotificationQRequest request=new AddNotificationQRequest();
		TrNotificationQDomain notificationQ=new TrNotificationQDomain();
		notificationQ.setFromUserId(1);
		notificationQ.setToUserId(2);
		notificationQ.setFromEmail("ashok@plmtechnology.com");
		notificationQ.setToEmail("ashok@plmtechnology.com");
		notificationQ.setSubject("Test Email");
		notificationQ.setBodyText("Body of the Message");
		notificationQ.setEmailStatusId(454);
		
		request.setNotificationQ(notificationQ);
		
		AddNotificationQResponse response=notificationQService.addNotificationQ(request);
		assertNotNull(response.getNotificationQ());
		
		/*AddNotificationQRequest update=new AddNotificationQsRequest();
		TrNotificationQsDomain responseDomain = new TrReferralsDomain();
		responseDomain= response.getReferrals();
		responseDomain.setFirstName("Ashok1");
		responseDomain.setLastName("Jain1");
		responseDomain.setEmail("ajain@plm.com");
		responseDomain.setSentUserId(2);
		responseDomain.setMessage("First Message");
		responseDomain.setWhyRefer("Good Site");
		
		update.setReferrals(responseDomain);
		AddReferralsResponse updateresponse=notificationQService.addReferrals(update);
		assertEquals(updateresponse.getReferrals().getReferalId(), response.getReferrals().getReferalId());*/
	}

	@Test
	public void testGetNotificationQById(){
//		GetNotificationQByIdRequest request=new GetReferralsByIdRequest();
//		request.setReferralsid(3);
		GetNotificationQByIdResponse response= notificationQService.getNotificationQbyId(3);
		assertNotNull(response.getNotificationQ());
		assertEquals("ashok@plmtechnology.com",response.getNotificationQ().getToEmail());
		
	}

	@Test
	public void tetGetNotificationQForUser(){
		GetNotificationQForUserResponse response  = notificationQService.getNotificationQForUser(1);
		assertNotNull(response);
	}
	
	@Test
	public void testGetNotificationQForStatus(){
		GetNotificationQForStatusResponse response  = notificationQService.getNotificationQForStatus(454);
	
		ListIterator<TrNotificationQDomain> itr = response.getNotificationQ().listIterator();
		while ( itr.hasNext()) {
			TrNotificationQDomain domain = response.getNotificationQ().get(itr.nextIndex());
			
			System.out.println("Notif "+domain.getFromEmail());
			itr.next();
		}
	}
	
	@Test
	public void testUpdateNotificationQ() throws Throwable{
		GetNotificationQByIdResponse response= notificationQService.getNotificationQbyId(6);
		assertEquals("ashok@plmtechnology.com",response.getNotificationQ().getFromEmail());
		//response.getNotificationQ().setFromEmail("test");
	   UpdateNotificationQRequest request = new UpdateNotificationQRequest();
		
		request.setNotificationQ(response.getNotificationQ());
		   request.getNotificationQ().setNotificationId(6);
		   request.getNotificationQ().setBodyText("New Body");
    	   request.getNotificationQ().setDeliveryDate(DateUtil.toXMLGregorianCalendar(Calendar.getInstance()));

		System.out.println("Test"+request.getNotificationQ().getNotificationId());
		assertEquals("ashok@plmtechnology.com",request.getNotificationQ().getFromEmail());
		
	 	UpdateNotificationQResponse  response1  = notificationQService.updateNotificationQ(request);
		assertEquals("0", response1.getStatus().getStatuscode());
		//assertNotNull(response1);
	}
	
	@Test
	public void testGetEmailTemplateByCode() {
		GetEmailTemplateByCodeResponse response = notificationQService.getEmailTemplateByCode("MEM_APPROVAL");
		assertEquals("0", response.getStatus().getStatuscode());
	}
	
	@Test
	public void testGetEmailTemplateByCodeContaining() {
		GetEmailTemplateByCodeContainingResponse response = notificationQService.getEmailTemplateByCodeContaining("BROADCAST_%");
		assertEquals("0", response.getStatus().getStatuscode());
	}
	
	@Test
	public void testAddNotificationQWithMultiUsers()
	{
		AddNotificationQWithMultiUsersRequest request=new AddNotificationQWithMultiUsersRequest();
		TrNotificationQDomain qDomain=new TrNotificationQDomain();
		request.setNotificationQ(qDomain);
		qDomain.setFromEmail("2@fashionforglobe.com");
		qDomain.setFromUserId(2);
		qDomain.setSubject("Subject");
		qDomain.setBodyText("Body");
		qDomain.setEmailStatusId(LookupTypeValueEnum.EMAIL_STATUS_ID_READY_TO_SEND.getTypeId());
		qDomain.setCreatedby(2);
		qDomain.setLastupdateby(2);
		request.getUsers().add(16);
		request.getUsers().add(18);
		request.getUsers().add(19);
		AddNotificationQWithMultiUsersResponse response = notificationQService.addNotificationQWithMultiUsers(request);
		System.out.println("Sent: "+response.getNotificationQ().size());
		assertEquals("0", response.getStatus().getStatuscode());
	}
}
