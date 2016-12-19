package com.f9g4.test.servicesdk;


import com.f9g4.businessobjects.services.GetUserbyEmailResponse;
import com.f9g4.servicesdk.SecurityServiceSDK;

import org.junit.Assert;
import org.junit.Ignore;
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
public class SecurityServiceSDKIntegrationTest {

 
   @Autowired
	private SecurityServiceSDK f9g4SecurityServiceSDK;

    @Test
    public void testGetUserbyEmailid() throws Exception {
    	GetUserbyEmailResponse response=f9g4SecurityServiceSDK.getUserbyEmailId("kamlesh@plmtechnology.com");
        Assert.assertNotNull(response);
        //Assert.assertNotNull(response.getUser().getEmailaddress());
        //System.out.println(response.getUser().getEmailaddress());
    }

	public SecurityServiceSDK getSecurityServiceSDK() {
		return f9g4SecurityServiceSDK;
	}

	public void setSecurityServiceSDK(SecurityServiceSDK securityServiceSDK) {
		this.f9g4SecurityServiceSDK = securityServiceSDK;
	}

   
}
