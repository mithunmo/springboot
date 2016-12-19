package com.f9g4.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.services.AddCreditRequest;
import com.f9g4.businessobjects.services.AddCreditResponse;
import com.f9g4.businessobjects.services.CheckPayKeyProcessedResponse;
import com.f9g4.businessobjects.services.CreateMembershipAuthSbmitRequest;
import com.f9g4.businessobjects.services.CreateMembershipAuthSbmitResponse;
import com.f9g4.businessobjects.services.CreateMembershipRequest;
import com.f9g4.businessobjects.services.CreateMembershipResponse;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsRequest;
import com.f9g4.businessobjects.services.CreateReceiveMembershipPaymentsResponse;
import com.f9g4.businessobjects.services.GetMemPricingOptionsResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.GetMembershipdetailsRequest;
import com.f9g4.businessobjects.services.GetMembershipdetailsResponse;
import com.f9g4.businessobjects.services.RedeemUserCreditResponse;
import com.f9g4.businessobjects.services.UpdateMembershipPaymentStatusRequest;
import com.f9g4.businessobjects.services.UpdateMembershipPaymentStatusResponse;
import com.f9g4.businessobjects.services.UpdateMembershipRequest;
import com.f9g4.businessobjects.services.UpdateMembershipResponse;
import com.f9g4.businessobjects.services.UpdateUserMembershipRequest;
import com.f9g4.businessobjects.services.UpdateUserMembershipResponse;


@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface IMembershipService {

	@PUT
	@Path("/user/membership")
	public CreateMembershipResponse createMembership(CreateMembershipRequest request);
	
	/**
	 * Updates the member ship expiration date 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/user/membership/")
	public UpdateMembershipResponse updateMembership(UpdateMembershipRequest request);		

	@POST
	@Path("/user/membership/pamentstatus")
	public UpdateMembershipPaymentStatusResponse updateMembershipPaymentStatus(UpdateMembershipPaymentStatusRequest request);		

	
	@POST
	@Path("/user/membership/payment/auth")
	public CreateMembershipAuthSbmitResponse createMembershipAuthSbmit(CreateMembershipAuthSbmitRequest request);

	@POST
	@Path("/user/membership/payment")
	public CreateReceiveMembershipPaymentsResponse createReceiveMembershipPayments(CreateReceiveMembershipPaymentsRequest request);
	
	
	@GET
	@Path("/user/membership/{userId}")
	public GetMembershipdetailsResponse getMembershipdetails(@PathParam("userId") int userId);
	
	@POST
	@Path("/user/membership/commission/")
	public GetMembershipCommissionResponse getMembershipCommissiondetails(GetMembershipCommissionRequest request);
	
	
	@GET
	@Path("/user/membership/paykey/{paykey}")
	public CheckPayKeyProcessedResponse checkPayKeyProcessed(@PathParam("paykey") String paykey);
	
	@GET
	@Path("/user/membership/mempricingoptions")
	public GetMemPricingOptionsResponse getMemPricingOptions();
	
	@PUT
	@Path("/user/membership/update")
	public UpdateUserMembershipResponse updateUserMembership(UpdateUserMembershipRequest request);
	
	@PUT
	@Path("/user/credit")
	public AddCreditResponse addCredit(AddCreditRequest request);
	
	@PUT
	@Path("/user/redeem/credit")
	public RedeemUserCreditResponse redeemCredit(int userId, int credits);
	
}