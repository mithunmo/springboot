package com.f9g4.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdRequest;
import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdResponse;
import com.f9g4.businessobjects.services.GetCompanyNewsResponse;
import com.f9g4.services.rest.ICompanyNews;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class CompanyNewsServiceTest {

@Autowired
private ICompanyNews companyNews;


@Test 
public void testGetAllCompanyNews(){
	GetCompanyNewsResponse response= new GetCompanyNewsResponse();
	response=companyNews.getCompanyNews();
	assertNotNull(response);
	assertNotNull(response.getNews());
	System.out.println(response.getNews());
	
}
@Test
public void testGetNewsDetailbyId(){
//	GetCompanyNewsDetailbyIdRequest request=new GetCompanyNewsDetailbyIdRequest();
//	request.setCompanynewsid(2);
	GetCompanyNewsDetailbyIdResponse response= new GetCompanyNewsDetailbyIdResponse();
	response=companyNews.getCompanyNewsDetail(2);
	assertNotNull(response);
	assertNotNull(response.getNewsDetail());
	assertNotNull(response.getNewsDetail().getContentDetail());
	System.out.println(response.getNewsDetail().getContentDetail());
}
}
