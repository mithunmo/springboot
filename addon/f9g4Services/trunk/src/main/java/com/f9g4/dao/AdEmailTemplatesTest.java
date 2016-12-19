package com.f9g4.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Set;

import com.f9g4.common.bo.SearchResults;
import com.f9g4.domain.AdEmailTemplates;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrBoardApproval;
import com.f9g4.domain.TrPortfolio;

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

/**
 * Class used to test the basic Data Store Functionality
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/f9g4-dao-context.xml"
/*		"file:./src/main/resources/f9g4-security-context.xml",
		"file:./src/main/resources/f9g4-service-context.xml",
		"file:./src/main/resources/f9g4-dao-context.xml",
		"file:./src/main/resources/f9g4-web-context.xml" */})
public class AdEmailTemplatesTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdEmailTemplatesDAO dataStore;

	/**
	 * Instantiates a new TrPortfolioDAOTest.
	 *
	 */
	public AdEmailTemplatesTest() {
	}

	@Test
	public void testFindRecords(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		AdEmailTemplates searchResults = dataStore.findAdEmailTemplatesById(1);
		System.out.println(searchResults.toString());
	}
	
	@Test
	public void testFindAllRecords(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		AdEmailTemplates searchResults = dataStore.findAdEmailTemplatesByTemplateCode("MEM_EXP_DESIGNER");
		assertNotNull(searchResults.toString());
	}
	
	@Test
	public void testFindRecordsContain(){
		Set<AdEmailTemplates> results = dataStore.findAdEmailTemplatesByTemplateCodeContaining("BROADCAST_%");
		assertNotNull(results);
	}
	
	@Autowired
	public void setDataStore(AdEmailTemplatesDAO dataStore) {
		this.dataStore = dataStore;
	}
}
