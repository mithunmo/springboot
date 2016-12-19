package com.f9g4.dao;

import java.util.Calendar;

import com.f9g4.domain.AdAcceptTerms;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.StTermsConditions;

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
		//"file:./src/main/resources/f9g4-security-context.xml",
		//"file:./src/main/resources/f9g4-service-context.xml",
		"classpath:com/f9g4/f9g4serviceswebapp/config/f9g4-dao-context.xml"
		//,
		//"file:./src/main/resources/f9g4-web-context.xml" 
		})
public class AdAcceptTermsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdAcceptTermsDAO dataStore;
	
	@Autowired
	private AdUsersDAO adUsersDAO;
	
	@Autowired
	private StTermsConditionsDAO stTermsConditionsDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;
	
	/**
	 * Instantiates a new AdAcceptTermsDAOTest.
	 *
	 */
	public AdAcceptTermsDAOTest() {
	}

	/**
	 * Method to test AdAcceptTerms domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void AdAcceptTerms() {
		AdUsers adUsers = adUsersDAO.findAdUsersByPrimaryKey(1);
		assertNotNull(adUsers);
		assertNotNull(adUsers.getUserId());
		
		StTermsConditions stTermsConditions = new StTermsConditions();
		
		AdLookupValues adLookupValuesByTermTypeId = adLookupValuesDAO.findAdLookupValuesByLookupValueId(439);
		AdLookupValues adLookupValuesByUserTypeId = adLookupValuesDAO.findAdLookupValuesByLookupValueId(438);
		
		stTermsConditions.setAdLookupValuesByTermTypeId(adLookupValuesByTermTypeId);
		stTermsConditions.setAdLookupValuesByUserTypeId(adLookupValuesByUserTypeId);
		stTermsConditions.setCreatedBy(-1);
		stTermsConditions.setCreationDate(Calendar.getInstance());
		String tAndC = "Test Dispalyed T&C";
		stTermsConditions.setDisplayedTerms(tAndC.getBytes());
		stTermsConditions.setEffectiveDate(Calendar.getInstance());
		stTermsConditions.setExpirationDate(Calendar.getInstance());
		stTermsConditions.setLangCode("en-US");
		stTermsConditions.setLastUpdateDate(Calendar.getInstance());
		stTermsConditions.setLastUpdatedBy(-1);
		stTermsConditions.setReviewedByLegal(-1);
		// store the object
		StTermsConditions tempStTermsConditions = stTermsConditionsDAO.store(stTermsConditions);
		assertNotNull(tempStTermsConditions.getTermCondId());

		
		AdAcceptTerms instance = new AdAcceptTerms();
		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				
		instance.setAcceptanceDate(Calendar.getInstance());
		instance.setAdUsers(adUsers);
		instance.setCreatedBy(-1);
		instance.setCreationDate(Calendar.getInstance());
		instance.setLastUpdateDate(Calendar.getInstance());
		instance.setLastUpdatedBy(-1);
		instance.setStTermsConditions(tempStTermsConditions);
		// store the object
		AdAcceptTerms tempInstance = dataStore.store(instance);
		assertNotNull(tempInstance.getAcceptTermId());
		
		// Test update
		tempInstance.setLastUpdatedBy(1);
		// update the object
		dataStore.store(tempInstance);
		AdAcceptTerms newInstance = dataStore.findAdAcceptTermsByPrimaryKey(tempInstance.getAcceptTermId());
		assertEquals(new Integer(1), newInstance.getLastUpdatedBy());
	
		// Test delete
		dataStore.remove(tempInstance);
		newInstance = dataStore.findAdAcceptTermsByPrimaryKey(tempInstance.getAcceptTermId());
		assertNull(newInstance);
	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AdAcceptTermsDAO dataStore) {
		this.dataStore = dataStore;
	}
}
