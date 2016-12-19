package com.f9g4.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface IMessageService {
	
	
	@PUT
	@Path("/messages/")
	public AddMessageResponse addMessages(AddMessageRequest request);
	
	@GET
	@Path("/messages/latest/{userid}")
	public GetlatestMessagesByBoardGroupByUserResponse getLatestMessagesbyUserForBoard(@PathParam("userid") int userid);
	
	@GET
	@Path("/messages/all/{userid}/{duserid}/{boardid}")
	public GetAllMessagesbyBoardAndUserResponse getAllMessagesByUserandBoard(@PathParam("userid") int userid, @PathParam("duserid") int duserid,@PathParam("boardid") int boardid);

	@GET
	@Path("/message/delete/{messageId}")
	public DeleteMessageByIdResponse deleteMessageById(@PathParam("messageId")int messageId);
	
	@GET
	@Path("/messages/get/{messageId}")
	public GetMessageByIdResponse getMessageById(@PathParam("messageId")int messageId);
	
	@GET
	@Path("/messages/broadcast")
	public GetBroadcastMessagesResponse getBroadcastMessages();
	
	@PUT
	@Path("/messages/broadcast")
	public CreateBroadcastMessagesResponse createBroadcastMessages(CreateBroadcastMessagesRequest request);
}
