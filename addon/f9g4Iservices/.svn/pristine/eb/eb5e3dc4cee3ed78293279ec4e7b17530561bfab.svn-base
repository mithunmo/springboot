package com.f9g4.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;

import com.f9g4.businessobjects.services.CheckUsernameAvailabilityRequest;
import com.f9g4.businessobjects.services.CheckUsernameAvailabilityResponse;
import com.f9g4.businessobjects.services.DeleteUserResponse;
import com.f9g4.businessobjects.services.GetAlertsResponse;
import com.f9g4.businessobjects.services.GetCategoriesRequest;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetDesignWallBoardInfoResponse;
import com.f9g4.businessobjects.services.GetDesignerAccountResponse;
import com.f9g4.businessobjects.services.GetLatestTermsByUserResponse;
import com.f9g4.businessobjects.services.GetLookupTypeValuesForTypeResponse;
import com.f9g4.businessobjects.services.GetSeasonYearsResponse;
import com.f9g4.businessobjects.services.GetSecurityQuestionResponse;
import com.f9g4.businessobjects.services.GetTermsConditionsResponse;
import com.f9g4.businessobjects.services.GetUsersListRequest;
import com.f9g4.businessobjects.services.GetUsersListResponse;
import com.f9g4.businessobjects.services.RegisterUserRequest;
import com.f9g4.businessobjects.services.RegisterUserResponse;
import com.f9g4.businessobjects.services.ResetPasswordRequest;
import com.f9g4.businessobjects.services.ResetPasswordResponse;
import com.f9g4.businessobjects.services.SearchUsersRequest;
import com.f9g4.businessobjects.services.SearchUsersResponse;
import com.f9g4.businessobjects.services.UpdateAdminRatingRequest;
import com.f9g4.businessobjects.services.UpdateAdminRatingResponse;
import com.f9g4.businessobjects.services.UpdateApproverCommentRequest;
import com.f9g4.businessobjects.services.UpdateApproverCommentResponse;
import com.f9g4.businessobjects.services.UpdatePasswordRequest;
import com.f9g4.businessobjects.services.UpdatePasswordResponse;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsRequest;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsResponse;
import com.f9g4.businessobjects.services.UpdateUserNameRequest;
import com.f9g4.businessobjects.services.UpdateUserNameResponse;
import com.f9g4.businessobjects.services.UpdateUserRequest;
import com.f9g4.businessobjects.services.UpdateUserResponse;
import com.f9g4.businessobjects.services.ValidateSecurityQuestionsRequest;
import com.f9g4.businessobjects.services.ValidateSecurityQuestionsResponse;
import com.f9g4.businessobjects.services.ValidateUserRequest;
import com.f9g4.businessobjects.services.ValidateUserResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;


@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface IRegistrationService {

	@POST
	@Path("/user")
	public RegisterUserResponse registerUser(RegisterUserRequest request);

	@GET
	@Path("/user/{id}")
	public ViewUserResponse viewUser(@PathParam("id") int userId);
	@GET
	@Path("/user/username/{email}")
	public ViewUserResponse viewUserByUserName(@PathParam("email") String userName);
	
	@PUT
	@Path("/user")
	public UpdateUserResponse updateUser(UpdateUserRequest request);

	@DELETE
	@Path("/user/{id}")
	public DeleteUserResponse deleteUser(@PathParam("id") int userId);

	@PUT
	@Path("/user/username/")
	public UpdateUserNameResponse updateUserName(UpdateUserNameRequest request);

	@PUT
	@Path("/user/usepwd/")
	public UpdatePasswordResponse updatePassword(UpdatePasswordRequest request);

	@POST
	@Path("/user/validate/")
	public ValidateUserResponse validateUser(ValidateUserRequest request);

	@PUT
	@Path("/user/reset/")
	public ResetPasswordResponse resetPassword(ResetPasswordRequest request);

	@GET
	@Path("/user/question/{emailId}")
	public GetSecurityQuestionResponse getSecurityQuestions(@PathParam("emailId") String emailId);

	@POST
	@Path("/user/validate/question")
	public ValidateSecurityQuestionsResponse validateSecurityQuestions(ValidateSecurityQuestionsRequest request);

	@PUT
	@Path("/user/terms/")
	public UpdateTermsAndConditionsResponse updateTermsAndConditions(UpdateTermsAndConditionsRequest request);
	
	@GET
	@Path("/user/lookup/values/{lookupType}")
	public GetLookupTypeValuesForTypeResponse getLookupTypeValues(@PathParam("lookupType")String lookupType);
	
	@GET
	@Path("/terms/{termsId}")
	public GetTermsConditionsResponse getTermsConditions(@PathParam("termsId") int termsId);
	
	/**
	 * @param userType - designer, customer
	 * @param termsType - registration, sale
	 * @return
	 */	
	@GET
	@Path("/terms/type/{termsType}/{userType}")
	public GetTermsConditionsResponse getLatestTermsConditions(@PathParam("termsType") String termsType, @PathParam("userType") String userType);
	
	@GET
	@Path("/user/alerts/{id}/{setMessageStatus}")
	public GetAlertsResponse getAlerts(@PathParam("id") int userId,@PathParam("setMessageStatus") boolean setMessageStatus);


	@GET
	@Path("/user/wallinfo/{id}/start/{start}/noRec/{rec}/sort/{sort}/direction/{direction}")	
	public GetDesignWallBoardInfoResponse getDesignWallBoardInfo(@PathParam("id")int userId, @PathParam("start") int startingRecord, @PathParam("rec") int noOfRecords, @PathParam("sort") int sortColumn, @PathParam("direction") int sortDirection); 

	@GET
	@Path("/user/designeraccount/{id}/start/{start}/noRec/{rec}/sort/{sort}/direction/{direction}")	
	public GetDesignerAccountResponse getDesignerAccountInfo(@PathParam("id")int userId, @PathParam("start") int startingRecord, @PathParam("rec") int noOfRecords, @PathParam("sort") int sortColumn, @PathParam("direction") int sortDirection);
	
	@GET
	@Path("/catagories/{level}/parent/{parentId}")
	public GetCategoriesResponse getCategories(@PathParam("level") Integer level, @PathParam("parentId") Integer parentId);
	
	
	
	@GET
	@Path("/seasonyears")
	public GetSeasonYearsResponse getSeasonAllYears();
	
	@GET
	@Path("/validate/username/{userName}")
	public CheckUsernameAvailabilityResponse checkUserNameAvailability(@PathParam("userName") String userName);

	@PUT
	@Path("/user/list")
	public GetUsersListResponse getUsersList(GetUsersListRequest request);
	
	@GET
	@Path("/terms/latest/{userId}")
	public GetLatestTermsByUserResponse getLatestTermsByUser(@PathParam("userId") Integer userId);
	
	@POST
	@Path("/catagories/")
	public GetCategoriesResponse getCategoriesByLevel(GetCategoriesRequest request);
	
	@POST
	@Path("/user/approvercomment/update")
	public UpdateApproverCommentResponse updateApproverComment(UpdateApproverCommentRequest request);
	
	@POST
	@Path("/user/adminrating")
	public UpdateAdminRatingResponse updateApprovalRating(UpdateAdminRatingRequest request);
	
	@GET
	@Path("/user/search")
	public SearchUsersResponse searchUsers(SearchUsersRequest request);
}