package com.f9g4.test.servicesdk;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.f9g4.businessobjects.domain.AdAccepttermsDomain;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.services.DeleteUserResponse;
import com.f9g4.businessobjects.services.GetAlertsResponse;
import com.f9g4.businessobjects.services.GetCategoriesRequest;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetDesignWallBoardInfoResponse;
import com.f9g4.businessobjects.services.GetDesignerAccountResponse;
import com.f9g4.businessobjects.services.GetLookupTypeValuesForTypeResponse;
import com.f9g4.businessobjects.services.GetSecurityQuestionRequest;
import com.f9g4.businessobjects.services.GetSecurityQuestionResponse;
import com.f9g4.businessobjects.services.GetUsersListRequest;
import com.f9g4.businessobjects.services.GetUsersListResponse;
import com.f9g4.businessobjects.services.RegisterUserRequest;
import com.f9g4.businessobjects.services.RegisterUserResponse;
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
import com.f9g4.businessobjects.services.ValidateUserRequest;
import com.f9g4.businessobjects.services.ValidateUserResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.servicesdk.RegistrationServiceSDK;


//@Ignore
//@TestExecutionListeners
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class RegistrationServiceSDKIntegrationTest {
 
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;

	@Test
	public void testRegisterUser() {
		JAXBContext jc = null;
		Unmarshaller u = null;
		RegisterUserRequest request = null;
		try {
			jc = JAXBContext.newInstance(RegisterUserRequest.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		try {
			u = jc.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		try {
//			 URL url = new URL( "http://bitrazor.com/content/tivo/hme/trafficcam/RegionMaster.xml" );
			 URL url = RegistrationServiceSDKIntegrationTest.class.getClassLoader().getResource("registration_data_1.xml");
			// regions = (Regions)u.unmarshal(new FileInputStream("RegionMaster.xml"));
			 request = (RegisterUserRequest)u.unmarshal(url);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		RegisterUserResponse response = registrationServiceSDK.registerUser(request);
		assertNotNull(response);
	
	}
	
	@Test
	public void testViewUser() {
		ViewUserResponse response = registrationServiceSDK.viewUser(3);
		assertNotNull(response);
	}

	@Test
	public void testUpdateUser() {
		
		JAXBContext jc = null;
		Unmarshaller u = null;
		RegisterUserRequest request = null;
		try {
			jc = JAXBContext.newInstance(RegisterUserRequest.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		try {
			u = jc.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		try {
//			 URL url = new URL( "http://bitrazor.com/content/tivo/hme/trafficcam/RegionMaster.xml" );
			 URL url = RegistrationServiceSDKIntegrationTest.class.getClassLoader().getResource("registration_data_1.xml");
			// regions = (Regions)u.unmarshal(new FileInputStream("RegionMaster.xml"));
			 request = (RegisterUserRequest)u.unmarshal(url);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		request.getUser().setUserName(UUID.randomUUID().toString()+"@gmail.com");
		RegisterUserResponse response = registrationServiceSDK.registerUser(request);
		assertNotNull(response);
		AdUsersDomain adUsersDomain =  response.getUser();
		
		assertNotNull(adUsersDomain.getUserId());
		adUsersDomain.setLastname("asdfs");
		UpdateUserRequest updateRequest = new UpdateUserRequest();
		updateRequest.setUser(adUsersDomain);
		UpdateUserResponse updateResponse = registrationServiceSDK.updateUser(updateRequest);
		assertNotNull(updateResponse);
	
	}
	
	@Test
	public void testValidateUser() {
		ValidateUserRequest request = new ValidateUserRequest();
		request.setPassword("NEVERALLOW");
		request.setUserName("F4GWEBAPP");
		ValidateUserResponse response = registrationServiceSDK.validateUser(request);
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
		
	}
	
	@Test
	public void testDeleteUser() {
//		DeleteUserRequest request = new DeleteUserRequest();
//		request.setUserId(3);
		DeleteUserResponse response =  registrationServiceSDK.deleteUser(3);
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
	}


	@Test
	public void testUpdateUserName() {
		UpdateUserNameRequest request = new UpdateUserNameRequest();
		request.setNewUserName("pardha");
		request.setUserId(3);
		UpdateUserNameResponse response =  registrationServiceSDK.updateUserName(request);
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
	}


	@Test
	public void testUpdatePassword() {
		UpdatePasswordRequest request = new UpdatePasswordRequest();
		request.setNewPassword("1234234");
		request.setUserId(3);
		UpdatePasswordResponse response = registrationServiceSDK.updatePassword(request);
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
	}
	
	
	@Test
	public void testUpdateTermsAndConditions() throws DatatypeConfigurationException{
		UpdateTermsAndConditionsRequest request = new UpdateTermsAndConditionsRequest();
		AdAccepttermsDomain adAccepttermsDomain = new AdAccepttermsDomain();
		
		GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
		gregorianCalendar.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		adAccepttermsDomain.setAcceptanceDate(xmlGregorianCalendar);
		//adAccepttermsDomain.setAcceptTermId(12312);
		adAccepttermsDomain.setTermConditionId(2);
		adAccepttermsDomain.setUserId(3);
		UpdateTermsAndConditionsResponse response = registrationServiceSDK.updateTermsAndConditions(request);
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
	}

	@Test
	public void testGetSecurityQuestion(){
		GetSecurityQuestionRequest request = new GetSecurityQuestionRequest();
		request.setUserId(3);
		GetSecurityQuestionResponse response = registrationServiceSDK.getSecurityQuestions("");
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
	}

	@Test
	public void testGetLookupTypeValues(){
		
		GetLookupTypeValuesForTypeResponse response = registrationServiceSDK.getLookupTypeValues("USER_SEC_QUESTION1");
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
		/*
		 * Set<AdLookupValues> adLookupValuesSet =  dataStore.findAdLookupValuesByLookupType(LookupTypeEnum.USER_SEC_QUESTION1.getTypeName());
		assertNotNull(adLookupValuesSet);
		assertTrue(adLookupValuesSet.size() > 0);
		 */
	}

//	@Test
//	public void test(){
//		
//	}	

	@Test
	public void testGetAlerts(){
		GetAlertsResponse response  = registrationServiceSDK.getAlerts(1,false);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertEquals(0, response.getStatus().getStatuscode());
		assertNotNull(response.getAlertMessages());
		assertTrue(response.getAlertMessages().size() > 0);
	}
	
	
	
	@Test
	public void testGetDesignWallBoardInfo(){
		GetDesignWallBoardInfoResponse response  = registrationServiceSDK.getDesignWallBoardInfo(1, 1, 10, 1, 1);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertEquals(0, response.getStatus().getStatuscode());

	}
	
	@Test
	public void testGetDesignerAccountInfo(){
		GetDesignerAccountResponse response  = registrationServiceSDK.getDesignerAccountInfo(16, 1, 10, 0, 0);

	}
	
	
	@Test
	public void testGetCategories_level_1_parent_0() {
		GetCategoriesResponse response =  registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_1, Constants.PARENT_ID_0) ;	
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertTrue(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()));
		assertNotNull(response.getStCategoryMasterDomain());
		assertTrue(response.getStCategoryMasterDomain().size() > 0);
	}
	
	@Test
	public void testGetCategories_level_2_parent_1() {
		GetCategoriesResponse response =  registrationServiceSDK.getCategories(Constants.CATEGORY_LAVEL_2, 1) ;
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertTrue(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()));
		assertNotNull(response.getStCategoryMasterDomain());
		assertTrue(response.getStCategoryMasterDomain().size() > 0);
	}
	
	@Test
	public void testGetUsersList() {
		GetUsersListRequest request = new GetUsersListRequest();
		List<AdLookupValuesDomain> regStatus = request.getRegStatus();
		List<AdLookupValuesDomain> userType = request.getUserType();
		AdLookupValuesDomain reg431 = new AdLookupValuesDomain();
		AdLookupValuesDomain reg433 = new AdLookupValuesDomain();
		AdLookupValuesDomain designer = new AdLookupValuesDomain();
		reg431.setLookupValueId(431);
		reg433.setLookupValueId(433);
		regStatus.add(reg431);
		regStatus.add(reg433);
		designer.setLookupValueId(437);
		userType.add(designer);
		request.setSortOption(3);
		request.setFirstResult(0);
		request.setMaxResult(10);
		GetUsersListResponse response = registrationServiceSDK.getUsersList(request);
		System.out.println(response.getUsers().size());
	}
	
	@Test
	public void testGetCategoriesByLevel3() {
		/*
		  	level 3 = product
		   	level 4 = product type
		*/
		GetCategoriesRequest request = new GetCategoriesRequest();
		request.setLevel(3);
		request.setPortfolioId(82);
		GetCategoriesResponse response = registrationServiceSDK.getCategoriesByLevel(request);
		assertTrue(response.getStCategoryMasterDomain().size() > 0);
	}
	
	@Test
	public void testGetCategoriesByLevel4() {
		/*
		  	level 3 = product
		   	level 4 = product type
		*/
		GetCategoriesRequest request = new GetCategoriesRequest();
		List<String> nameOnLevel3 = request.getNameForLevel3();
		request.setLevel(4);
		request.setPortfolioId(82);
		nameOnLevel3.add("Dresses");
		nameOnLevel3.add("Capes");
		nameOnLevel3.add("Bottoms");
		GetCategoriesResponse response = registrationServiceSDK.getCategoriesByLevel(request);
		assertTrue(response.getStCategoryMasterDomain().size() > 0);
	}
	
	@Test
	public void testUpdateApproverComment()
	{
		UpdateApproverCommentResponse response = new UpdateApproverCommentResponse();
		UpdateApproverCommentRequest request = new UpdateApproverCommentRequest();
		request.setUserId(605);
		request.setApproverComment("TEST SERVICE 605");
		response = registrationServiceSDK.updateApproverComment(request);
		assertTrue(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()));
	}
	
	@Test
	public void testAdminRating(){
		UpdateAdminRatingRequest request= new UpdateAdminRatingRequest();
		UpdateAdminRatingResponse response = new UpdateAdminRatingResponse();
		request.setRating(3.5f);
		request.setUserId(6);
		response=registrationServiceSDK.updateApprovalRating(request);
		assertTrue(response.getRating()==request.getRating());
		
	}
}


