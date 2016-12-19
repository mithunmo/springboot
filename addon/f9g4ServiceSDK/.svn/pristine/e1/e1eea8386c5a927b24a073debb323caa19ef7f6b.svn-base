package com.f9g4.test.servicesdk;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.services.GetMemPricingOptionsResponse;
import com.f9g4.businessobjects.services.GetMembershipCommissionRequest;
import com.f9g4.businessobjects.services.GetMembershipCommissionResponse;
import com.f9g4.businessobjects.services.UpdateMembershipRequest;
import com.f9g4.businessobjects.services.UpdateMembershipResponse;
import com.f9g4.businessobjects.services.UpdateUserMembershipRequest;
import com.f9g4.businessobjects.services.UpdateUserMembershipResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.servicesdk.MembershipServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;


//@Ignore
//@TestExecutionListeners
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MembershipServiceSDKIntegrationTest {

	@Autowired
	private MembershipServiceSDK membershipServiceSDK;
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;
	
	@Test
	public void testUpdateMembership(){
		UpdateMembershipRequest request = new UpdateMembershipRequest();
	//	request.setNewPassword("1234234");
		request.setUserId(3);
		UpdateMembershipResponse response = membershipServiceSDK.updateMembership(request);
		assertNotNull(response);
		assertEquals(0, response.getStatus().getStatuscode());
	}
	
	@Test
	public void testMembershipCommission(){
		GetMembershipCommissionRequest request = new GetMembershipCommissionRequest();
		request.setUserId(16);
		GetMembershipCommissionResponse response =  membershipServiceSDK.getMembershipCommissiondetails(request);
		assertNotNull(response);
		
	}

	@Test
	public void testGetMemPricingOptions(){
		GetMemPricingOptionsResponse response = membershipServiceSDK.getMemPricingOptions();
		assertNotNull(response);
	}
	
	@Test
	public void testUpdateUserMembership()
	{
		UpdateUserMembershipRequest request = new UpdateUserMembershipRequest();
		ViewUserResponse userResponse = registrationServiceSDK.viewUser(294);
		AdUsersDomain user = userResponse.getUser();
		user.setRegisterStatusId(432);
		user.setActiveStatus(1);
		user.getUserMembership().get(0).setMembershipPricingId(4);
		user.getUserMembership().get(0).setPaymentStatusId(408);
		request.setUser(user);
		UpdateUserMembershipResponse updateUserMembershipResponse = membershipServiceSDK.updateUserMembership(request);
		assertEquals("0",updateUserMembershipResponse.getStatus().getStatuscode());
	}
}