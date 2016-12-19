package com.f9g4.test.servicesdk;



import com.f9g4.businessobjects.services.GetPortfolioByIdRequest;
import com.f9g4.businessobjects.services.GetPortfolioByIdResponse;
import com.f9g4.businessobjects.services.GetPortfolioByUserResponse;
import com.f9g4.servicesdk.PortfolioServiceSDK;

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
public class PortfolioServiceSDKIntegrationTest {

 
   @Autowired
	private PortfolioServiceSDK portfolioServiceSDK;

    @Test
    public void testGetPortfolioById() throws Exception {
    	
//    	GetPortfolioByIdRequest request=new GetPortfolioByIdRequest();
//    	request.setPortfolioid(2);
    	GetPortfolioByIdResponse response=portfolioServiceSDK.getPortfoliobyId(3);
    	System.out.println(response.getStatus().getStatuscode());
        Assert.assertNotNull(response.getPortfolio());
        //Assert.assertNotNull(response.getUser().getEmailaddress());
        //System.out.println(response.getUser().getEmailaddress());
    }

	public PortfolioServiceSDK getPortfolioServiceSDK() {
		return portfolioServiceSDK;
	}

	public void setPortfolioServiceSDK(PortfolioServiceSDK portfolioServiceSDK) {
		this.portfolioServiceSDK = portfolioServiceSDK;
	}
	
	@Test
	public void getUnsellablePortfolioByUserId()
	{
		GetPortfolioByUserResponse response= portfolioServiceSDK.getUnsellablePortfoliobyUser(16);
		System.out.println(response.getPortfolio().size());
	}
	
}
