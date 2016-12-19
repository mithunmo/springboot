package com.f9g4.services.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f9g4.businessobjects.services.AddNotificationQRequest;
import com.f9g4.businessobjects.services.AddNotificationQResponse;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersRequest;
import com.f9g4.businessobjects.services.AddNotificationQWithMultiUsersResponse;
import com.f9g4.businessobjects.services.DeleteNotificationQByIdResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeContainingResponse;
import com.f9g4.businessobjects.services.GetEmailTemplateByCodeResponse;
import com.f9g4.businessobjects.services.GetNotificationQByIdResponse;
import com.f9g4.businessobjects.services.GetNotificationQForStatusResponse;
import com.f9g4.businessobjects.services.GetNotificationQForUserResponse;
import com.f9g4.businessobjects.services.UpdateNotificationQRequest;
import com.f9g4.businessobjects.services.UpdateNotificationQResponse;

@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface INotificationQService {
	
	@POST
	@Path("/add")
	public AddNotificationQResponse addNotificationQ(AddNotificationQRequest request);
	
	@GET
	@Path("/id/{notificationQid}")
	public GetNotificationQByIdResponse getNotificationQbyId(@PathParam("notificationQid") int notificationQid);
		
	@DELETE
	@Path("/del/{notificationQid}")
	public DeleteNotificationQByIdResponse deleteNotificationQById(@PathParam("notificationQid") int notificationQid);
	
	@GET
	@Path("/user/{userId}")
	public GetNotificationQForUserResponse getNotificationQForUser(@PathParam("userId") int userId);
	
	@GET
	@Path("/status/{statusId}")
	public GetNotificationQForStatusResponse getNotificationQForStatus(@PathParam("statusId") int statusId);
	
	
	@PUT
	@Path("/notificationQ")
	public UpdateNotificationQResponse updateNotificationQ(UpdateNotificationQRequest request);
	
	@PUT
	@Path("/emailtemplate/{templateCode}")
	public GetEmailTemplateByCodeResponse getEmailTemplateByCode(@PathParam("templateCode") String templateCode);
	
	@PUT
	@Path("/emailtemplate/contain/{templateCode}")
	public GetEmailTemplateByCodeContainingResponse getEmailTemplateByCodeContaining(@PathParam("templateCode") String templateCode);
	
	@PUT
	@Path("/add/multi")
	public AddNotificationQWithMultiUsersResponse addNotificationQWithMultiUsers(AddNotificationQWithMultiUsersRequest request);
}
