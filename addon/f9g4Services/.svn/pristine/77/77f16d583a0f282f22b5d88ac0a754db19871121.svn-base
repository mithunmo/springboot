package com.f9g4.services;

import static org.junit.Assert.*;

import java.util.Calendar;

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

import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.TrBroadcastMessagesDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesRequest;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.DeleteMessageByIdResponse;
import com.f9g4.businessobjects.services.GetAllMessagesbyBoardAndUserRequest;
import com.f9g4.businessobjects.services.GetAllMessagesbyBoardAndUserResponse;
import com.f9g4.businessobjects.services.GetBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.GetMessageByIdResponse;
import com.f9g4.businessobjects.services.GetlatestMessagesByBoardGroupByUserRequest;
import com.f9g4.businessobjects.services.GetlatestMessagesByBoardGroupByUserResponse;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.domain.TrMessages;
import com.f9g4.services.rest.IMembershipService;
import com.f9g4.services.rest.IMessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class MessageServiceTest {

	@Autowired
	private IMessageService messageService;
	
	@Test
	public void testgetLatestforuser(){
//		GetlatestMessagesByBoardGroupByUserRequest request=new GetlatestMessagesByBoardGroupByUserRequest();
//		request.setTouserid(17);
		GetlatestMessagesByBoardGroupByUserResponse response= messageService.getLatestMessagesbyUserForBoard(17);
		
		for (TrMessagesDomain messages : response.getMessageList()) {
			System.out.println(messages);
		}
		
	}
	
	@Test
	public void testgetAllMessages(){
		GetAllMessagesbyBoardAndUserRequest request=new GetAllMessagesbyBoardAndUserRequest();
		request.setTouserid(17);
		request.setBoardid(26);
		GetAllMessagesbyBoardAndUserResponse response= messageService.getAllMessagesByUserandBoard(17,16,26);
		
		for (TrMessagesDomain messages : response.getMessageList()) {
			System.out.println(messages);
		}
		
	}
	
	@Test
	public void testDeleteMessageById()
	{
		DeleteMessageByIdResponse response = messageService.deleteMessageById(328);
		System.out.println(response.getStatus().getStatuscode());
	}

	@Test
	public void testGetMessageById()
	{
		GetMessageByIdResponse response = messageService.getMessageById(328);
		System.out.println(response.getMessage().toString());
	}
	
	@Test
	public void testCreateBroadcastMessage()
	{
		CreateBroadcastMessagesRequest request=new CreateBroadcastMessagesRequest();
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
		CreateBroadcastMessagesResponse response = messageService.createBroadcastMessages(request);
		assertEquals("0", response.getStatus().getStatuscode());
	}
	
	@Test
	public void testGetBroadcastMessages()
	{
		GetBroadcastMessagesResponse response = messageService.getBroadcastMessages();
		assertNotNull(response.getResult());
	}
}
