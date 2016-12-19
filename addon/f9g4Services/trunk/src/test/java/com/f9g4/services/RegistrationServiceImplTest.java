package com.f9g4.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.imageio.spi.RegisterableService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.domain.AdAccepttermsDomain;
import com.f9g4.businessobjects.domain.AdLookupValuesDomain;
import com.f9g4.businessobjects.domain.AdUserMembershipDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrBoardDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.domain.TrPortfolioDomain;
import com.f9g4.businessobjects.services.CheckUsernameAvailabilityResponse;
import com.f9g4.businessobjects.services.DesignWallBoardInfoDomain;
import com.f9g4.businessobjects.services.GetAlertsResponse;
import com.f9g4.businessobjects.services.GetCategoriesRequest;
import com.f9g4.businessobjects.services.GetCategoriesResponse;
import com.f9g4.businessobjects.services.GetDesignWallBoardInfoResponse;
import com.f9g4.businessobjects.services.GetDesignerAccountResponse;
import com.f9g4.businessobjects.services.GetLatestTermsByUserResponse;
import com.f9g4.businessobjects.services.GetSecurityQuestionResponse;
import com.f9g4.businessobjects.services.GetUsersListRequest;
import com.f9g4.businessobjects.services.GetUsersListResponse;
import com.f9g4.businessobjects.services.RegisterUserRequest;
import com.f9g4.businessobjects.services.RegisterUserResponse;
import com.f9g4.businessobjects.services.SearchExampleBoardsRequest;
import com.f9g4.businessobjects.services.SearchUsersRequest;
import com.f9g4.businessobjects.services.SearchUsersResponse;
import com.f9g4.businessobjects.services.UpdateApproverCommentRequest;
import com.f9g4.businessobjects.services.UpdateApproverCommentResponse;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsRequest;
import com.f9g4.businessobjects.services.UpdateTermsAndConditionsResponse;
import com.f9g4.businessobjects.services.UpdateUserRequest;
import com.f9g4.businessobjects.services.UpdateUserResponse;
import com.f9g4.businessobjects.services.UserInfoDomain;
import com.f9g4.businessobjects.services.ValidateUserRequest;
import com.f9g4.businessobjects.services.ValidateUserResponse;
import com.f9g4.businessobjects.services.ViewUserRequest;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.common.bo.SearchResults;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.Constants;
import com.f9g4.dao.TrBoardDAO;
import com.f9g4.services.rest.IRegistrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class RegistrationServiceImplTest {
	
//	@Autowired
	//private TrBoardDAO trBoardDAO;

	@Autowired
	private IRegistrationService registrationService = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegisterUser() {
//		String userId = ;
//		registerStatusId, 
//		userName, 
//		password, 
//		firstname, 
//		lastname, 
//		companyname, 
//		aboutYou, 
//		companywebsite, 
//		logoimage, 
//		schoolawards, 
//		activeStatus, 
//		securityQuestion1, 
//		securityAnswer1, 
//		securityQuestion2, 
//		securityAnswer2, 
//		securityquestion3, 
//		securityAnswer3, 
//		taxid, 
//		overallRating, 
//		langCode, 
//		acceptedTermsCondition, 
//		activeUser, 
//		address, 
//		contacts, 
//		userLangs, 
//		userMembership, 
//		useSkills, 
//		boards, 
//		messages, 
//		paymentAuthSubmit, 
//		portfolio, 
//		ratings, 
//		recentlyViewed, 
//		referrals, 
//		salesTransactionDetails
		
//	    int userId = 1;
//	    int registerStatusId =0; //Active = 1 
//	    String userName = "pardha@plmtech.com";
//	    String password ="plmtech1234"; 
//	    String firstname = "Pardha";
//	    String lastname = "N";
//
//	    JAXBElement<String> companyname = new JAXBElement<String>(name, declaredType, value);
//
//	    JAXBElement<String> aboutYou;
//
//	    JAXBElement<String> companywebsite;
//
//	    JAXBElement<byte[]> logoimage;
//
//	    JAXBElement<String> schoolawards;
//
//	    int activeStatus;
//	    int securityQuestion1;
//
//	    String securityAnswer1;
//	    int securityQuestion2;
//	    
//	    String securityAnswer2;
//	    JAXBElement<Integer> securityquestion3;
//	    JAXBElement<String> securityAnswer3;
//	    JAXBElement<String> taxid;
//	    JAXBElement<Float> overallRating;
////	    @XmlElement(required = true, defaultValue = "en-US")
//	    String langCode;
//	    List<AdAccepttermsDomain> acceptedTermsCondition;
//	    List<AdActiveUserDomain> activeUser;
//	    List<AdAddressDomain> address;
//	    List<AdContactsDomain> contacts;
//	    
//	    List<AdUserLanguagesDomain> userLangs;
//	    List<AdUserMembershipDomain> userMembership;
//	    List<AdUserSkillsDomain> useSkills;
//	    List<TrBoardDomain> boards;
//	    List<TrMessagesDomain> messages;
//	    List<TrPaymentAuthSubmitDomain> paymentAuthSubmit;
//	    List<TrPortfolioDomain> portfolio;
//	    List<TrRatingsDomain> ratings;
//	    List<TrRecentlyViewedDomain> recentlyViewed;
//	    List<TrReferralsDomain> referrals;
//	    List<TrSalesTransactionDetailsDomain> salesTransactionDetails;
//
//		AdUsersDomain user = new AdUsersDomain(userId, registerStatusId, userName, password, firstname, lastname, companyname, aboutYou, companywebsite, logoimage, schoolawards, activeStatus, securityQuestion1, securityAnswer1, securityQuestion2, securityAnswer2, securityquestion3, securityAnswer3, taxid, overallRating, langCode, acceptedTermsCondition, activeUser, address, contacts, userLangs, userMembership, useSkills, boards, messages, paymentAuthSubmit, portfolio, ratings, recentlyViewed, referrals, salesTransactionDetails) ;
//		
//		user.setAboutYou(value);
//		user.setActiveStatus(value);
//		user.setCompanyname(value);
//		user.setCompanywebsite(value);
//		user.setFirstname(value);
//		user.setLangCode(value);
//		user.setLastname(value);
//		user.setLogoimage(value);
//		user.setOverallRating(value);
//		user.setPassword(value);
//		user.setRegisterStatusId(value);
//		user.setSchoolawards(value);
//		user.setSecurityAnswer1(value);
//		user.setSecurityAnswer2(value);
//		user.setSecurityAnswer3(value);
//		user.setSecurityQuestion1(value);
//		user.setSecurityQuestion2(value);
//		user.setSecurityquestion3(value);
//		user.setTaxid(value);
//		user.setUserId(value);
//		user.setUserName(value);
		
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
			 URL url = RegistrationServiceImplTest.class.getClassLoader().getResource("registration_data_1.xml");
			// regions = (Regions)u.unmarshal(new FileInputStream("RegionMaster.xml"));
			 request = (RegisterUserRequest)u.unmarshal(url);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		RegisterUserResponse response = registrationService.registerUser(request);
		assertNotNull(response);
		
	}


	@Test
	public void testViewUser() {
		ViewUserResponse response = registrationService.viewUser(16);
		System.out.println(response);
		assertNotNull(response);
	}


	@Test
	public void testValidateUser() {
		ValidateUserRequest request = new ValidateUserRequest();
		request.setUserName("pardha@fashion4globe.com");
		request.setPassword("plmtech123");
		
		ValidateUserResponse response = registrationService.validateUser(request);
		assertNotNull(response);
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode() , response.getStatus().getStatuscode());
		
	}

	@Test
	public void testValidateUser_invalid_pwd() {
		ValidateUserRequest request = new ValidateUserRequest();
		request.setUserName("pardha@fashion4globe.com");
		request.setPassword("******");
		
		ValidateUserResponse response = registrationService.validateUser(request);
		assertNotNull(response);
		assertEquals(StatusCodesEnum.STATUS_ERR_AUTH_FAILED.getCode() , response.getStatus().getStatuscode());
		
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePassword() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testGetMembershipdetails() {
		fail("Not yet implemented");
	}



	@Test
	public void testGetSecurityQuestions(){
		
		GetSecurityQuestionResponse response  = registrationService.getSecurityQuestions("pardha");
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertEquals(0, response.getStatus().getStatuscode());
	}
	
	
	@Test
	public void testGetAlerts(){
		GetAlertsResponse response  = registrationService.getAlerts(16,false);
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertEquals(0, response.getStatus().getStatuscode());
		List<TrMessagesDomain> list = response.getAlertMessages();
		assertNotNull(list);
		assertTrue(list.size() >0);
	}
	
	@Test
	@Rollback(false)
	public void testUpdateTermsAndConditions_1() {
		UpdateTermsAndConditionsRequest request = new UpdateTermsAndConditionsRequest();
		request.setUserId(10);
		AdAccepttermsDomain adAccepttermsDomain = new AdAccepttermsDomain();
		
		GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
		gregorianCalendar.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
		XMLGregorianCalendar xmlGregorianCalendar;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			adAccepttermsDomain.setAcceptanceDate(xmlGregorianCalendar);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//adAccepttermsDomain.setAcceptTermId(12312);
		adAccepttermsDomain.setTermConditionId(2);
		adAccepttermsDomain.setUserId(10);
		request.setAdAccepttermsDomain(adAccepttermsDomain);
		UpdateTermsAndConditionsResponse response = registrationService.updateTermsAndConditions(request);
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
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
			 URL url = RegistrationServiceImplTest.class.getClassLoader().getResource("registration_data_1.xml");
			// regions = (Regions)u.unmarshal(new FileInputStream("RegionMaster.xml"));
			 request = (RegisterUserRequest)u.unmarshal(url);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		request.getUser().setUserName(UUID.randomUUID().toString()+"@gmail.com");
		RegisterUserResponse response = registrationService.registerUser(request);
		assertNotNull(response);
		AdUsersDomain adUsersDomain =  response.getUser();
		
		assertNotNull(adUsersDomain.getUserId());
		adUsersDomain.setLastname("asdfs");
		UpdateUserRequest updateRequest = new UpdateUserRequest();
		updateRequest.setUser(adUsersDomain);
		UpdateUserResponse updateResponse = registrationService.updateUser(updateRequest);
		assertNotNull(updateResponse);
	
	}

	@Test
	public void testGetCategories_level_1_parent_0() {
		GetCategoriesResponse response =  registrationService.getCategories(Constants.CATEGORY_LAVEL_1, Constants.PARENT_ID_0) ;	
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertTrue(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()));
		assertNotNull(response.getStCategoryMasterDomain());
		assertTrue(response.getStCategoryMasterDomain().size() > 0);
	}
	
	@Test
	public void testGetCategories_level_2_parent_1() {
		GetCategoriesResponse response =  registrationService.getCategories(Constants.CATEGORY_LAVEL_2, 1) ;
		assertNotNull(response);
		assertNotNull(response.getStatus());
		assertTrue(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()));
		assertNotNull(response.getStCategoryMasterDomain());
		assertTrue(response.getStCategoryMasterDomain().size() > 0);
	}
	
	@Test
	public void testCheckUsernameAvailabilityResponse(){
		CheckUsernameAvailabilityResponse response = registrationService.checkUserNameAvailability("1@plmtechnology.com");
		System.out.println("Availability of 1@plmtechnology.com -> " + response.isIsAvailable());
		assertNotNull(response);
		response = registrationService.checkUserNameAvailability("blahblahblah@plmtechnology.com");
		System.out.println("Availability of blahblahblah@plmtechnology.com" + response.isIsAvailable());
		assertNotNull(response);
	}
	
	@Test
	public void testgetDesignWallBoardInfo(){
		GetDesignWallBoardInfoResponse designWall =  registrationService.getDesignWallBoardInfo(17, 0, 10, 4, 0);
		System.out.println("Total Amount for user 17 ->" + designWall.getTotalAmount());
		System.out.println("Total count of rows ->" + designWall.getTotalRows());
		System.out.println("Total count in : page 1 ->" + designWall.getBoards().size());
		int iter = 0;
		for ( DesignWallBoardInfoDomain Dom : designWall.getBoards()) {
			System.out.println(iter++ +"->"+ Dom.getTotalPrice()+"-"+Dom.getFileType());
		}
		designWall =  registrationService.getDesignWallBoardInfo(17, 10, 20, 4, 0);
		System.out.println("Total count in : page 2 ->" + designWall.getBoards().size());
		for ( DesignWallBoardInfoDomain Dom : designWall.getBoards()) {
			System.out.println(iter++ +"->"+ Dom.getTotalPrice()+"-"+Dom.getFileType());
		}
		//SearchResults searchResults = trBoardDAO.findDesingwallBoards(2, 0, 2, 10, 17);
		//assertNotNull(searchResults);
		//System.out.prntln("Total Rows -> " +  searchResults.getTotalRows());
		//System.out.println("Total Amount -> "+ searchResults.getTotalAmount());
		//System.out.println("Row Count in full ->"+searchResults.getResults().size());
	}
	
	@Test
	public void testgetDesignerAccount()
	{
		GetDesignerAccountResponse account = registrationService.getDesignerAccountInfo(17, 0, 10, 0, 0);
		System.out.println("Total amount =>"+account.getTotalAmount());
		System.out.println("Total count of rows =>"+account.getTotalRows());
		System.out.println("count=>"+account.getBoards().size());
	}
	
	@Test
	public void testUsersList()
	{
		GetUsersListRequest request=new GetUsersListRequest();
		//
		List<AdLookupValuesDomain> regStatus=request.getRegStatus();
		AdLookupValuesDomain reg431=new AdLookupValuesDomain();
		AdLookupValuesDomain reg432=new AdLookupValuesDomain();
		AdLookupValuesDomain reg433=new AdLookupValuesDomain();
		AdLookupValuesDomain regSBSC = new AdLookupValuesDomain();
		//reg431.setLookupValueId(431);
		//reg433.setLookupValueId(433);
		reg431.setLookupCode("CF");
		reg432.setLookupCode("CD");
		reg433.setLookupCode("WC");
		regSBSC.setLookupCode("SBSC");
		//regStatus.add(reg431);
		//regStatus.add(reg433);
		regStatus.add(reg432);
		//regStatus.add(regSBSC);
		List<AdLookupValuesDomain> userType=request.getUserType();
		AdLookupValuesDomain designer=new AdLookupValuesDomain();
		//designer.setLookupValueId(437);
		designer.setLookupCode("DG");
		userType.add(designer);
		request.setSortOption(4);
		request.setFirstResult(0);
		request.setMaxResult(200);
		GetUsersListResponse response = registrationService.getUsersList(request);
		System.out.println(response.getTotal());
		System.out.println(response.getUsers().size());
		//System.out.println(response.getUsers());
		for(UserInfoDomain item : response.getUsers())
		{
			for(TrPortfolioDomain pitem : item.getPortfolio())
			{
				for(TrBoardDomain bitem : pitem.getBoards())
				{
					//System.out.println(bitem.getBoardId()+" "+bitem.getBoardImages().get(0).getThumbnailUrl());
				}
			}
		}
	}
	
	@Test
	public void testUpdateUsermembership() {
		ViewUserRequest viewUserRequest = new ViewUserRequest();
		ViewUserResponse viewUserResponse = registrationService.viewUser(17);
		AdUsersDomain user = viewUserResponse.getUser();
		//change registration status
		user.setRegisterStatusId(432);
		user.setActiveStatus(1);
		//change data
		AdUserMembershipDomain membership = user.getUserMembership().get(0);
		membership.setPaymentStatusId(408);
		membership.setMembershipPricingId(11);
		UpdateUserRequest updateUserRequest = new UpdateUserRequest();
		updateUserRequest.setUser(user);
		UpdateUserResponse updateUserResponse = registrationService.updateUser(updateUserRequest);
		System.out.println(updateUserResponse.getStatus().getStatuscode());
	}
	
	@Test
	public void testGetLatestTermsByUser() {
		GetLatestTermsByUserResponse response = registrationService.getLatestTermsByUser(17);
		System.out.println(response.getTerm().toString());
		System.out.println(response.getStatus().getStatuscode());
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
		GetCategoriesResponse response = registrationService.getCategoriesByLevel(request);
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
		GetCategoriesResponse response = registrationService.getCategoriesByLevel(request);
		assertTrue(response.getStCategoryMasterDomain().size() > 0);
	}
	
	@Test
	public void testUpdateApproverComment()
	{
		UpdateApproverCommentResponse response = new UpdateApproverCommentResponse();
		UpdateApproverCommentRequest request = new UpdateApproverCommentRequest();
		request.setUserId(602);
		request.setApproverComment("TEST SERVICE");
		response = registrationService.updateApproverComment(request);
		assertTrue(response.getStatus().getStatuscode().equals(StatusCodesEnum.STATUS_SUCCESS.getCode()));
	}
	
	@Test
	public void testUserSearch(){
		
		SearchUsersRequest request = new SearchUsersRequest();

		SearchUsersResponse response = new SearchUsersResponse();
		request.setDesignerName(null);
		request.setMinAdminRating(-1);
		request.setMaxAdminRating(5);
		request.getCountryIds().add(238);
		
		response = registrationService.searchUsers(request);
		
		for( AdUsersDomain domain : response.getUsers()){
			System.out.println(domain.getFirstname());
			System.out.println(domain.getUserId());
		}
		
	}
	
}