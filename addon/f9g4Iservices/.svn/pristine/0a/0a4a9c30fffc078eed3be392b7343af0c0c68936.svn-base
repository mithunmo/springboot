package com.f9g4.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.f9g4.businessobjects.domain.AdActiveUserDomain;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardRequest;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardResponse;
import com.f9g4.businessobjects.services.AddUserLogRequest;
import com.f9g4.businessobjects.services.AddUserLogResponse;
import com.f9g4.businessobjects.services.GetActiveuserResponse;

@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface IDataCaptureService {

	@PUT
	@Path("/logBoardViewd/")
	public AddRecentlyViewedBoardResponse addRecentlyViewBoard(AddRecentlyViewedBoardRequest request);
	
	
	@PUT
	@Path("/logUserData/")
	public AddUserLogResponse logUserData(AddUserLogRequest request);
	
	@GET
	@Path("/getLoggedUserData/{sessionid}")
	public GetActiveuserResponse getActiveUserLoggedRecord(@PathParam("sessionid") String sessionid);

	
}
