package com.f9g4.test.servicesdk;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.TrBroadcastMessagesDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.services.AddMessageRequest;
import com.f9g4.businessobjects.services.AddMessageResponse;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesRequest;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.GetAllMessagesbyBoardAndUserResponse;
import com.f9g4.businessobjects.services.GetBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeContainingResponse;
import com.f9g4.businessobjects.services.GetMessageByIdResponse;
import com.f9g4.businessobjects.services.GetlatestMessagesByBoardGroupByUserRequest;
import com.f9g4.businessobjects.services.GetlatestMessagesByBoardGroupByUserResponse;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.MessageServiceSDK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MessageServiceSDKTest {

	@Autowired
	private MessageServiceSDK messageServiceSDK;
	
	@Test
	public void testGetLatestMessagesforUser(){
//		GetlatestMessagesByBoardGroupByUserRequest request=new GetlatestMessagesByBoardGroupByUserRequest();
//		request.setTouserid(17);
		GetlatestMessagesByBoardGroupByUserResponse response= messageServiceSDK.getLatestMessagesbyUserForBoard(17);
		assertNotNull(response.getMessageList());
		assertEquals(3, response.getMessageList().size());
	}
	
	@Test
	public void testGetAllMessages(){
		GetAllMessagesbyBoardAndUserResponse response= messageServiceSDK.getAllMessagesByUserandBoard(17,16,26);
		assertNotNull(response);
		assertNotNull(response.getMessageList());
	}

	@Test
	public void testAddMessages(){
		AddMessageRequest request= new AddMessageRequest();
		TrMessagesDomain domain= new TrMessagesDomain();
		domain.setBoardId(26);
		domain.setFromUserId(1);
		domain.setToUserId(17);
		domain.setSubject("testing SDK");
		domain.setMessageBody("TESTING AGAIAN FROM SDK DONT KNOW WHAT WILL BE OUTPUT");
		domain.setMessageType("INBOX");
		domain.setMsgStatusId(459);
		request.setMessage(domain);
		AddMessageResponse response= messageServiceSDK.addMessages(request);
		Assert.assertNotNull(response.getStatus());
		System.out.println(response.getStatus().getDescription());
	}
	
	@Test
	public void testGetMessageById()
	{
		GetMessageByIdResponse response = messageServiceSDK.getMessageById(330);
		System.out.println(response.getMessage().toString());
	}
	
	@Test
	public void testCreateBroadcastMessage()
	{
		CreateBroadcastMessagesRequest request = new CreateBroadcastMessagesRequest();
		TrBroadcastMessagesDomain domain = new TrBroadcastMessagesDomain();
		request.setItem(domain);
		AdLookupValuesDomain scope = new AdLookupValuesDomain();
		scope.setLookupValueId(540);
		AdLookupValuesDomain status = new AdLookupValuesDomain();
		status.setLookupValueId(525);
		domain.setMsgScopeId(540);
		domain.setMsgStatusId(525);
		domain.setTemplateName("Test");
		domain.setMessageText("Test Text");
		domain.setAdLookupValuesByMsgScopeId(scope);
		domain.setAdLookupValuesByMsgStatusId(status);
		domain.setErrorMessage("Error");
		domain.setCreatedBy(2);
		domain.setLastUpdatedBy(2);
		try {
			domain.setProcessedDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
			domain.setCreationDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
			domain.setLastUpdateDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			CreateBroadcastMessagesResponse response = messageServiceSDK.createBroadcastMessages(request);
			System.out.println(response.getStatus().toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetBroadcastMessages()
	{
		GetBroadcastMessagesResponse response = messageServiceSDK.getBroadcastMessages();
		assertNotNull(response.getResult());
	}
}
