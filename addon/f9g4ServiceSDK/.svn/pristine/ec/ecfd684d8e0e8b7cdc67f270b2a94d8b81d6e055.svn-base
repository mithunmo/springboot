package com.f9g4.servicesdk;

import java.util.List;
import java.util.Properties;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IRegistrationService;

public class RegistrationServiceSDK extends AbstractRestSDK<IRegistrationService> implements IRegistrationService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Properties registrationSvcProperties;

	private String registrationSvcConfigFile;

	private ServiceType callType;

//	@Autowired
	private IRegistrationService registrationService;

	
	public Properties getRegistrationSvcProperties() {
		return registrationSvcProperties;
	}


	public void setRegistrationSvcProperties(Properties registrationSvcProperties) {
		this.registrationSvcProperties = registrationSvcProperties;
	}



	public String getRegistrationSvcConfigFile() {
		return registrationSvcConfigFile;
	}



	public void setRegistrationSvcConfigFile(String registrationSvcConfigFile) {
		this.registrationSvcConfigFile = registrationSvcConfigFile;
	}



	public IRegistrationService getRegistrationService() {
		return registrationService;
	}



	public void setRegistrationService(IRegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	

	public RegisterUserResponse registerUser(RegisterUserRequest request) {
		return getService().registerUser(request);
	}



	public ViewUserResponse viewUser(int userid) {
		return getService().viewUser(userid);
	}


	public UpdateUserResponse updateUser(UpdateUserRequest request) {
		return getService().updateUser(request);
	}


	public DeleteUserResponse deleteUser(int userId) {
		return getService().deleteUser(userId);
	}


	public UpdateUserNameResponse updateUserName(UpdateUserNameRequest request) {
		return getService().updateUserName(request);
	}


	public UpdatePasswordResponse updatePassword(UpdatePasswordRequest request) {
		return getService().updatePassword(request);
	}


	public ValidateUserResponse validateUser(ValidateUserRequest request) {
		return getService().validateUser(request);
	}


	@Override
	protected String getClientConfigFile() {
		return this.registrationSvcConfigFile;
	}



	@Override
	protected Properties getProperties() {
		return this.registrationSvcProperties;
	}



	@Override
	protected ServiceType getCallType() {
		return this.callType;
	}



	@Override
	protected IRegistrationService getLocalService() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected IRegistrationService getMockService() {
		// TODO Auto-generated method stub
		return null;
	}



	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}



	public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
		return getService().resetPassword(request);
	}

	public GetSecurityQuestionResponse getSecurityQuestions(String emailId) {
		return getService().getSecurityQuestions(emailId);
	}



	public UpdateTermsAndConditionsResponse updateTermsAndConditions(UpdateTermsAndConditionsRequest request) {
		return getService().updateTermsAndConditions(request);
	}

	public ValidateSecurityQuestionsResponse validateSecurityQuestions(ValidateSecurityQuestionsRequest request) {
		return getService().validateSecurityQuestions(request);
	}



	public GetLookupTypeValuesForTypeResponse getLookupTypeValues(String lookupType) {
		return getService().getLookupTypeValues(lookupType);
	}


	public GetAlertsResponse getAlerts(int userId,boolean setMessageStatus) {
		return getService().getAlerts(userId,setMessageStatus);
	}


	public GetDesignWallBoardInfoResponse getDesignWallBoardInfo(int userId, int startingRecord, int noOfRecords, int sortColumn, int sortDirection) {
		return getService().getDesignWallBoardInfo(userId, startingRecord, noOfRecords, sortColumn, sortDirection);
	}

	public GetDesignerAccountResponse getDesignerAccountInfo(int userId, int startingRecord, int noOfRecords, int sortColumn, int sortDirection) {
		return getService().getDesignerAccountInfo(userId, startingRecord, noOfRecords, sortColumn, sortDirection);
	}
	
	public GetTermsConditionsResponse getTermsConditions(int termsId) {
		return getService().getTermsConditions(termsId);
	}


	public ViewUserResponse viewUserByUserName(String userName) {
		return getService().viewUserByUserName(userName);
	}

	/**
	 * 
	 * @param userType - designer, customer
	 * @param termsType - registration, sale
	 * @return
	 */
	public GetTermsConditionsResponse getLatestTermsConditions(String termsType, String userType) {
		return getService().getLatestTermsConditions(termsType, userType);
	}


	public GetCategoriesResponse getCategories(Integer level, Integer parentId) {
		return getService().getCategories(level, parentId);
	}


	public GetSeasonYearsResponse getSeasonAllYears() {
		return getService().getSeasonAllYears();
	}


	public CheckUsernameAvailabilityResponse checkUserNameAvailability(
			String userName) {
		return getService().checkUserNameAvailability(userName);
	}


	public GetUsersListResponse getUsersList(GetUsersListRequest request) {
		return getService().getUsersList(request);
	}
	
	public GetLatestTermsByUserResponse getLatestTermsByUser(Integer userId) {
		return getService().getLatestTermsByUser(userId);
	}
	
	
	public GetCategoriesResponse getCategoriesByLevel(GetCategoriesRequest request) {
		return getService().getCategoriesByLevel(request);
	}

	public UpdateApproverCommentResponse updateApproverComment(UpdateApproverCommentRequest request) {
		return getService().updateApproverComment(request);
	}


	public UpdateAdminRatingResponse updateApprovalRating(
			UpdateAdminRatingRequest request) {
		return getService().updateApprovalRating(request);
	}


	public SearchUsersResponse searchUsers(SearchUsersRequest request) {
		return getService().searchUsers(request);
	}
}
