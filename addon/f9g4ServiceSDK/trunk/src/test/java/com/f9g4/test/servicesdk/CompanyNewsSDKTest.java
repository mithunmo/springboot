package com.f9g4.test.servicesdk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdRequest;
import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdResponse;
import com.f9g4.businessobjects.services.GetCompanyNewsResponse;
import com.f9g4.services.rest.IBoardService;
import com.f9g4.services.rest.ICompanyNews;
import com.f9g4.servicesdk.CompanyNewsSDK;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class CompanyNewsSDKTest {
	
	@Autowired
	private CompanyNewsSDK companynews;

	@Test
	public void testGetAllCompanyNews(){
		GetCompanyNewsResponse response= new GetCompanyNewsResponse();
		response=companynews.getCompanyNews();
		System.out.println(response.getNews().size());
	}	
	
	@Test
	public void testGetCompanyNewsDetail(){
//	GetCompanyNewsDetailbyIdRequest request=new GetCompanyNewsDetailbyIdRequest();
//	request.setCompanynewsid(2);
	GetCompanyNewsDetailbyIdResponse response=new GetCompanyNewsDetailbyIdResponse();
	response=companynews.getCompanyNewsDetail(2);
	System.out.println(response.getNewsDetail().getCompanyNewsId());
	}
}
