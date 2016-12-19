package com.f9g4.dao;

import com.f9g4.domain.TrPortfolioContestMembers;

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
		/* "file:./src/main/resources/f9g4-security-context.xml"
		"file:./src/main/resources/f9g4-service-context.xml",
		"file:./src/main/resources/f9g4-dao-context.xml",
		"file:./src/main/resources/f9g4-web-context.xml" */ })
public class TrPortfolioContestMembersDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrPortfolioContestMembersDAO dataStore;

	/**
	 * Instantiates a new TrPortfolioContestDAOTest.
	 *
	 */
	public TrPortfolioContestMembersDAOTest() {
	}

	/**
	 * Method to test TrPortfolioContest domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrPortfolioContestMembers() {
		TrPortfolioContestMembers instance = new TrPortfolioContestMembers();

		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				

		// store the object
		dataStore.store(instance);
		//dataStore.merge(instance);
		//dataStore.flush();

		// Test update
		// TODO: Modify non-key domain object values for update

		// update the object
		dataStore.store(instance);

		// Test delete
		//dataStore.remove(instance);

	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(TrPortfolioContestMembersDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Autowired
	public void testPortFolio(){
		dataStore.findAllTrPortfolioByUserId(10, 0, 10);
	}
}
