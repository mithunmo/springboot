package com.f9g4.services;

import static org.junit.Assert.assertNotNull;

import javax.xml.datatype.DatatypeConfigurationException;

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

import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrCompanyCreditDomain;
import com.f9g4.businessobjects.services.AddCreditRequest;
import com.f9g4.businessobjects.services.GetMemPricingOptionsResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.GetMembershipdetailsRequest;
import com.f9g4.businessobjects.services.UpdateUserMembershipRequest;
import com.f9g4.businessobjects.services.UpdateUserMembershipResponse;
import com.f9g4.businessobjects.services.ViewUserRequest;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.services.rest.IMembershipService;
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
public class MembershipServiceImplTest {

	@Autowired
	private IMembershipService membershipService = null;
	
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
	@Rollback(false)
	public void testCreateMembershipPayments() throws DatatypeConfigurationException {

		/*CreateMembershipPaymentsRequest request = new CreateMembershipPaymentsRequest();
		request.setMembershipId(15);
		request.setUserId(33);

		TrMembershipAuthSubmitDomain domain = new TrMembershipAuthSubmitDomain();
		domain.setChargeAmount(new BigDecimal(50.00));
		domain.setCreatedby(1);
			domain.setInitialTimeStamp(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance()));
		domain.setLastupdateby(1);
		// domain.setMemAuthSubmitId(value); -- dont need it..
		domain.setMembershipId(15);
		
		TrReceiveMembershipPaymentsDomain receiveMembershipPaymentsDomain = new TrReceiveMembershipPaymentsDomain();
		receiveMembershipPaymentsDomain.setAuthCode("asdfasdfasfasdfsafsafsadfsa");
		//receiveMembershipPaymentsDomain.setAuthStatusId(value);
		receiveMembershipPaymentsDomain.setCreatedby(1);
		receiveMembershipPaymentsDomain.setLastupdateby(1);
		receiveMembershipPaymentsDomain.setPaymentAmount(new BigDecimal(50.00));
*/		//receiveMembershipPaymentsDomain.setPaymentError(value);//???
		//receiveMembershipPaymentsDomain.setPaymentTransmissionId(value);//???		
/*		List<TrReceiveMembershipPaymentsDomain>  receiveMembershipPaymentsList = domain.getReceiveMembershipPayments(); 
		receiveMembershipPaymentsList.add(receiveMembershipPaymentsDomain);
*/		

		
/*		GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
		gregorianCalendar.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
		XMLGregorianCalendar xmlGregorianCalendar;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			adAccepttermsDomain.setAcceptanceDate(xmlGregorianCalendar);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/	
		/*CreateMembershipPaymentsResponse response = membershipService.createMembershipPayments(request);
		assertNotNull(response);
		assertEquals(StatusCodesEnum.STATUS_SUCCESS.getCode(), response.getStatus().getStatuscode());*/
	}
	
	@Test
	public void testgetMembershipCommissiondetails()
	{
		GetMembershipCommissionRequest req = new GetMembershipCommissionRequest();
		req.setUserId(16);
		GetMembershipCommissionResponse resp = membershipService.getMembershipCommissiondetails(req);
		assertNotNull(resp);
		System.out.println("commission -> " + resp.getStPricingOptions().getCommission());
	}
	
	@Test
	public void testGetMemPricingOptions()
	{
		GetMemPricingOptionsResponse response = membershipService.getMemPricingOptions();
		System.out.println(response.getOptions().size());
	}
	
	@Test
	public void testUpdateUserMembership()
	{
		UpdateUserMembershipRequest request = new UpdateUserMembershipRequest();
		ViewUserResponse userResponse = registrationService.viewUser(294);
		AdUsersDomain user = userResponse.getUser();
		//Change info
		user.setRegisterStatusId(432);
		user.setActiveStatus(1);
		user.getUserMembership().get(0).setMembershipPricingId(4);
		user.getUserMembership().get(0).setPaymentStatusId(407);
		request.setUser(user);
		UpdateUserMembershipResponse updateUserMembershipResponse = membershipService.updateUserMembership(request);
		System.out.println(updateUserMembershipResponse.getStatus().getStatuscode());
	}
	
	@Test
	public void testAddCredit(){
		AddCreditRequest request = new AddCreditRequest();
		TrCompanyCreditDomain domain = new TrCompanyCreditDomain();
		domain.setCreatedby(2);
		domain.setLastupdateby(2);
		domain.setCreditVal(1000);
		domain.setTotalCreditAmount(33333);
		domain.setTotalCredits(70);
		domain.setUserId(10);
		request.setCompanyCredit(domain);
		membershipService.addCredit(request);
		
	}
	
	@Test 
	public void testRedeemCredit(){
		
		membershipService.redeemCredit(10, 400);

	}
	
}
