package com.f9g4.servicesdk;

import java.util.Properties;

import javax.ws.rs.PathParam;

import com.f9g4.businessobjects.services.AddMessageRequest;
import com.f9g4.businessobjects.services.AddMessageResponse;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesRequest;
import com.f9g4.businessobjects.services.CreateBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.DeleteMessageByIdResponse;
import com.f9g4.businessobjects.services.GetAllMessagesbyBoardAndUserRequest;
import com.f9g4.businessobjects.services.GetAllMessagesbyBoardAndUserResponse;
import com.f9g4.businessobjects.services.GetBroadcastMessagesResponse;
import com.f9g4.businessobjects.services.GetMessageByIdResponse;
import com.f9g4.businessobjects.services.GetlatestMessagesByBoardGroupByUserRequest;
import com.f9g4.businessobjects.services.GetlatestMessagesByBoardGroupByUserResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IBoardService;
import com.f9g4.services.rest.IMessageService;

public class MessageServiceSDK extends AbstractRestSDK<IMessageService> implements IMessageService{
	
	

	private static final long serialVersionUID = 1L;

	private Properties messageServiceProperties;

	private String messageServiceConfigFile;

	private ServiceType callType;
	
	private IMessageService messageService;

	public AddMessageResponse addMessages(AddMessageRequest request) {
		// TODO Auto-generated method stub
		return getService().addMessages(request);
	}

	public GetlatestMessagesByBoardGroupByUserResponse getLatestMessagesbyUserForBoard(
			int userid) {
		// TODO Auto-generated method stub
		return getService().getLatestMessagesbyUserForBoard(userid);
	}

	public GetAllMessagesbyBoardAndUserResponse getAllMessagesByUserandBoard(
			int userid,int duserid,int boardid) {
		// TODO Auto-generated method stub
		return getService().getAllMessagesByUserandBoard(userid,duserid,boardid);
	}

	@Override
	protected String getClientConfigFile() {
		// TODO Auto-generated method stub
		return this.messageServiceConfigFile;
	}

	@Override
	protected Properties getProperties() {
		// TODO Auto-generated method stub
		return this.messageServiceProperties;
	}

	@Override
	protected ServiceType getCallType() {
		// TODO Auto-generated method stub
		return this.callType;
	}

	@Override
	protected IMessageService getLocalService() {
		// TODO Auto-generated method stub
		return this.messageService;
	}

	@Override
	protected IMessageService getMockService() {
		// TODO Auto-generated method stub
		return null;
	}

	public Properties getMessageServiceProperties() {
		return messageServiceProperties;
	}

	public void setMessageServiceProperties(Properties messageServiceProperties) {
		this.messageServiceProperties = messageServiceProperties;
	}

	public String getMessageServiceConfigFile() {
		return messageServiceConfigFile;
	}

	public void setMessageServiceConfigFile(String messageServiceConfigFile) {
		this.messageServiceConfigFile = messageServiceConfigFile;
	}

	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}
	
	public DeleteMessageByIdResponse deleteMessageById(@PathParam("messageId")int messageId)
	{
		return this.getService().deleteMessageById(messageId);
	}
	
	public GetMessageByIdResponse getMessageById(@PathParam("messageId")int messageId)
	{
		return this.getService().getMessageById(messageId);
	}
	
	public CreateBroadcastMessagesResponse createBroadcastMessages(CreateBroadcastMessagesRequest request)
	{
		return this.getService().createBroadcastMessages(request);
	}
	
	public GetBroadcastMessagesResponse getBroadcastMessages()
	{
		return this.getService().getBroadcastMessages();
	}

}
