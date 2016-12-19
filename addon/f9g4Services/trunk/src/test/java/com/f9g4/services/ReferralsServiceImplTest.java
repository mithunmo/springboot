package com.f9g4.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import com.f9g4.businessobjects.domain.TrReferralsDomain;
import com.f9g4.businessobjects.services.AddReferralsRequest;
import com.f9g4.businessobjects.services.AddReferralsResponse;
import com.f9g4.businessobjects.services.GetReferralByAuthCodeResponse;
import com.f9g4.businessobjects.services.GetReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralsForUserResponse;
import com.f9g4.businessobjects.services.GetReferralsResponse;
import com.f9g4.businessobjects.services.UpdateReferralRequest;
import com.f9g4.businessobjects.services.UpdateReferralResponse;
import com.f9g4.services.rest.IReferralsService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class ReferralsServiceImplTest {

	
	@Autowired
	private IReferralsService referralsService = null;
	
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
	//@Rollback(false)
	public void testAddReferrals() {
		AddReferralsRequest request=new AddReferralsRequest();
		TrReferralsDomain referrals=new TrReferralsDomain();
		referrals.setSentUserId(2);
		referrals.setFirstName("Ashok");
		referrals.setLastName("Jain");
		referrals.setEmail("ajain@plm.com");
		referrals.setMessage("First Message");
		referrals.setWhyRefer("Good Site");
		referrals.setAuthCode("1231243131");
		request.setReferrals(referrals);
		AddReferralsResponse response=referralsService.addReferrals(request);
		assertNotNull(response.getReferrals());
		
		/*AddReferralsRequest update=new AddReferralsRequest();
		TrReferralsDomain responseDomain = new TrReferralsDomain();
		responseDomain= response.getReferrals();
		responseDomain.setFirstName("Ashok1");
		responseDomain.setLastName("Jain1");
		responseDomain.setEmail("ajain@plm.com");
		responseDomain.setSentUserId(2);
		responseDomain.setMessage("First Message");
		responseDomain.setWhyRefer("Good Site");
		
		update.setReferrals(responseDomain);
		AddReferralsResponse updateresponse=referralsService.addReferrals(update);
		assertEquals(updateresponse.getReferrals().getReferalId(), response.getReferrals().getReferalId());*/
	}

	@Test
	public void testGetReferralsById(){
//		GetReferralsByIdRequest request=new GetReferralsByIdRequest();
//		request.setReferralsid(3);
		GetReferralsByIdResponse response= referralsService.getReferralsbyId(1);
		assertNotNull(response.getReferrals());
		assertEquals("Ashok",response.getReferrals().getFirstName());
		
	}

	@Test
	public void tetGetReferralsForUser(){
		GetReferralsForUserResponse response  = referralsService.getReferralsForUser(1);
		assertNotNull(response);
	}
	
	@Test
	public void testUpdateReferral(){
		GetReferralsByIdResponse response= referralsService.getReferralsbyId(1);
		UpdateReferralRequest request = new UpdateReferralRequest();
		request.setReferrals(response.getReferrals());
		UpdateReferralResponse  response1  = referralsService.updateReferral(request);
		assertNotNull(response1);
	}
	
	@Test
	public void testGetReferralByAuthCode() {
		GetReferralByAuthCodeResponse response = referralsService.getReferralByAuthCode("3190b409-2af0-45b1-8b61-a23787e1b571");
		System.out.println(response.getStatus().getStatuscode());
		System.out.println(response.getReferral().get(0).toString());
	}
	
	@Test
	public void testGetReferrals() {
		GetReferralsResponse response = referralsService.getReferrals();
		System.out.println(response.getReferrals().size());
		System.out.println(response.getStatus().getStatuscode());
	}
}
