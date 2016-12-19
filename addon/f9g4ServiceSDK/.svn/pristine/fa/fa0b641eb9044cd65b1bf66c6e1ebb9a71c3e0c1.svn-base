package com.f9g4.test.servicesdk;



import static org.junit.Assert.assertEquals;

import com.f9g4.businessobjects.domain.TrNotificationQDomain;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersRequest;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeContainingResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeResponse;
import com.f9g4.businessobjects.services.GetNotificationQByIdResponse;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.servicesdk.NotificationQServiceSDK;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;



//@Ignore
//@TestExecutionListeners
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class NotificationQServiceSDKIntegrationTest {

 
   @Autowired
	private NotificationQServiceSDK notificationQServiceSDK;

    @Test
    public void testGetNotificationQById() throws Exception {
    	
//    	GetNotificationQByIdRequest request=new GetNotificationQByIdRequest();
//    	request.setNotificationQid(2);
    	GetNotificationQByIdResponse response=notificationQServiceSDK.getNotificationQbyId(3);
    	System.out.println(response.getStatus().getStatuscode());
        Assert.assertNotNull(response.getNotificationQ());
        //Assert.assertNotNull(response.getUser().getEmailaddress());
        //System.out.println(response.getUser().getEmailaddress());
    }

	public NotificationQServiceSDK getNotificationQServiceSDK() {
		return notificationQServiceSDK;
	}

	public void setNotificationQServiceSDK(NotificationQServiceSDK notificationQServiceSDK) {
		this.notificationQServiceSDK = notificationQServiceSDK;
	}

	@Test
	public void testGetEmailTemplateByCode() {
		GetEmailTemplateByCodeResponse response = notificationQServiceSDK.getEmailTemplateByCode("MEM_APPROVAL");
		assertEquals("0",response.getStatus().getStatuscode());
	}
	
	@Test
	public void testGetEmailTemplateByCodeContaining() {
		GetEmailTemplateByCodeContainingResponse response = notificationQServiceSDK.getEmailTemplateByCodeContaining("BROADCAST_%");
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
		AddNotificationQWithMultiUsersResponse response = notificationQServiceSDK.addNotificationQWithMultiUsers(request);
		System.out.println("Sent: "+response.getNotificationQ().size());
		assertEquals("0", response.getStatus().getStatuscode());
	}
}
