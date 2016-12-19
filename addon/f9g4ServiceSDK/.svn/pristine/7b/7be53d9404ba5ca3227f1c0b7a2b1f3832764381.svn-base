package com.f9g4.test.servicesdk;



import com.f9g4.businessobjects.services.GetReferralByAuthCodeResponse;
import com.f9g4.businessobjects.services.GetReferralsByIdResponse;
import com.f9g4.businessobjects.services.GetReferralsResponse;
import com.f9g4.servicesdk.ReferralsServiceSDK;

import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@Ignore
//@TestExecutionListeners
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class ReferralsServiceSDKIntegrationTest {

 
   @Autowired
	private ReferralsServiceSDK referralsServiceSDK;

    @Test
    public void testGetReferralsById() throws Exception {
    	
//    	GetReferralsByIdRequest request=new GetReferralsByIdRequest();
//    	request.setReferralsid(2);
    	GetReferralsByIdResponse response=referralsServiceSDK.getReferralsbyId(3);
    	System.out.println(response.getStatus().getStatuscode());
        Assert.assertNotNull(response.getReferrals());
        //Assert.assertNotNull(response.getUser().getEmailaddress());
        //System.out.println(response.getUser().getEmailaddress());
    }

	public ReferralsServiceSDK getReferralsServiceSDK() {
		return referralsServiceSDK;
	}

	public void setReferralsServiceSDK(ReferralsServiceSDK referralsServiceSDK) {
		this.referralsServiceSDK = referralsServiceSDK;
	}

	@Test
	public void testGetReferralByAuthCode()
	{
		GetReferralByAuthCodeResponse response = referralsServiceSDK.getReferralByAuthCode("aa046c7c-1bbc-4add-a89e-0213965de0ea");
		Assert.assertNotNull(response.getReferral());
	}

	@Test
	public void testGetReferrals() {
		GetReferralsResponse response = referralsServiceSDK.getReferrals();
		System.out.println(response.getReferrals().size());
		System.out.println(response.getStatus().getStatuscode());
	}
}
