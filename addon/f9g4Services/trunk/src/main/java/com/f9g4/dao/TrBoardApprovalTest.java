package com.f9g4.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Set;

import com.f9g4.domain.TrBoardApproval;

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
public class TrBoardApprovalTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrBoardApprovalDAO dataStore;

	/**
	 * Instantiates a new TrPortfolioDAOTest.
	 *
	 */
	public TrBoardApprovalTest() {
	}

	@Test
	public void testFindRecords(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		Set<TrBoardApproval> searchResults = dataStore.findTrBoardApprovalById(30);
		System.out.println(searchResults.toString());
	}
	
	@Test
	public void testFindAllRecords(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		Set<TrBoardApproval> searchResults = dataStore.findAllTrBoardApproval();
		System.out.println(searchResults.size());
		assertNotNull(searchResults.toString());
	}
	
	@Test
	public void testFindRecordsByMainImageUrl() {
		Set<TrBoardApproval> searchResults = dataStore.findTrBoardApprovalByMainImageUrl("baa7e72c-33ed-4d81-a751-c3a9ce663638.jpg");
		System.out.println(searchResults.size());
		assertNotNull(searchResults.toString());
	}
	
	@Test 
	public void testInsert(){
		TrBoardApproval record=new TrBoardApproval();
		record.setMainImageUrl("test.jpg");
		record.setApprovalStatus(1);
		record.setComments("Test");
		record.setApproverName("Admin");
		record.setProcessStatus("Processing");
		record.setErrorMessage("Test");
		record.setCreationDate(Calendar.getInstance());
		record.setCreatedBy(2);
		record.setLastUpdateDate(Calendar.getInstance());
		record.setLastUpdatedBy(2);
		dataStore.merge(record);
	}
	
	@Autowired
	public void setDataStore(TrBoardApprovalDAO dataStore) {
		this.dataStore = dataStore;
	}
}
