package com.f9g4.dao;

import java.util.Calendar;

import com.f9g4.domain.AdLookupTypes;

import static org.junit.Assert.*;

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
//		"file:./src/main/resources/f9g4-security-context.xml",
//		"file:./src/main/resources/f9g4-service-context.xml",
//		"file:./src/main/resources/f9g4-dao-context.xml",
//		"file:./src/main/resources/f9g4-web-context.xml" 
		})
public class AdLookupTypesDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdLookupTypesDAO dataStore;

	/**
	 * Instantiates a new AdLookupTypesDAOTest.
	 *
	 */
	public AdLookupTypesDAOTest() {
	}

	/**
	 * Method to test AdLookupTypes domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void AdLookupTypes() {
		
		AdLookupTypes instance = new AdLookupTypes();

		instance.setActiveStatus(1);
		//instance.setAdLookupValueses(adLookupValueses);
		instance.setCreatedBy(1);
		instance.setCreationDate(Calendar.getInstance());
		instance.setLastUpdateDate(Calendar.getInstance());
		instance.setLastUpdatedBy(1);
		instance.setLangCode("en-US");
		instance.setLookupDescription("Test Description");
		instance.setLookupType("USER_SKILLS");
//		instance.setLookupTypeId(123141);			

		// store the object
		AdLookupTypes tempInstance = dataStore.store(instance);
//		dataStore.flush();
		assertNotNull(tempInstance.getLookupTypeId());
		
		
		// Test update
		tempInstance.setLookupType("USER_SKILLS_1");
		// update the object
		dataStore.store(tempInstance);

		AdLookupTypes newInstance = dataStore.findAdLookupTypesByLookupTypeId(tempInstance.getLookupTypeId());
		assertEquals("USER_SKILLS_1", newInstance.getLookupType());
	
		// Test delete
		dataStore.remove(tempInstance);

		newInstance = dataStore.findAdLookupTypesByLookupTypeId(tempInstance.getLookupTypeId());
		assertNull(newInstance);


	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AdLookupTypesDAO dataStore) {
		this.dataStore = dataStore;
	}
}
