package com.f9g4.services.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f9g4.businessobjects.services.AddReferralsRequest;
import com.f9g4.businessobjects.services.AddReferralsResponse;
import com.f9g4.businessobjects.services.DeleteReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralByAuthCodeResponse;
import com.f9g4.businessobjects.services.GetReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralsForUserResponse;
import com.f9g4.businessobjects.services.GetReferralsResponse;
import com.f9g4.businessobjects.services.ResendReferralMessageResponse;
import com.f9g4.businessobjects.services.UpdateReferralAndResendMessageRequest;
import com.f9g4.businessobjects.services.UpdateReferralAndResendMessageResponse;
import com.f9g4.businessobjects.services.UpdateReferralRequest;
import com.f9g4.businessobjects.services.UpdateReferralResponse;

@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface IReferralsService {
	
	@POST
	@Path("/referrals")
	public AddReferralsResponse addReferrals(AddReferralsRequest request);
	
	@GET
	@Path("/referrals/{referralsid}")
	public GetReferralsByIdResponse getReferralsbyId(@PathParam("referralsid") int referralsid);
		
	@DELETE
	@Path("/referrals/{referralsid}")
	public DeleteReferralsByIdResponse deleteReferralsById(@PathParam("referralsid") int referralsid);
	
	@GET
	@Path("/referrals/user/{userId}")
	public  GetReferralsForUserResponse getReferralsForUser(@PathParam("userId") int userId);
	
	@PUT
	@Path("/referrals")
	public UpdateReferralResponse updateReferral(UpdateReferralRequest request);
	
	@POST
	@Path("/referrals/{referralId}/message/")
	public ResendReferralMessageResponse resendReferralMessage(@PathParam("referralId") int referralId);
	
	@PUT
	@Path("/referrals/message")
	public UpdateReferralAndResendMessageResponse updateReferralAndResendMessage(UpdateReferralAndResendMessageRequest request);
	
	@PUT
	@Path("/referrals/authcode")
	public GetReferralByAuthCodeResponse getReferralByAuthCode(String authCode);

	@GET
	@Path("/referrals/list")
	public GetReferralsResponse getReferrals();
}
