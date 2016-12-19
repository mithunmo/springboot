package com.f9g4.dao;

import java.util.Set;

import com.f9g4.domain.AdUserDocuments;

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
})
public class AdUserDocumentsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdUserDocumentsDAO dataStore;

	/**
	 * Instantiates a new TrPortfolioImagesDAOTest.
	 *
	 */
	public AdUserDocumentsDAOTest() {
	}

	/**
	 * Method to test TrPortfolioImages domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void AdUserDocuments() {
		AdUserDocuments instance = new AdUserDocuments();

		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				

		// store the object
		dataStore.store(instance);

		// Test update
		// TODO: Modify non-key domain object values for update

		// update the object
		dataStore.store(instance);

		// Test delete
		dataStore.remove(instance);

	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AdUserDocumentsDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindAllAdUserDocuments()
	{
		Set<AdUserDocuments> result = dataStore.findAllAdUserDocuments();
		System.out.println(result.size());
	}
}
