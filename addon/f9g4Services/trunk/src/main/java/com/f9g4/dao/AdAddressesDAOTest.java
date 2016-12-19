package com.f9g4.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

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

import com.f9g4.domain.AdAddresses;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUsers;

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
public class AdAddressesDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdAddressesDAO dataStore;

	@Autowired
	private AdUsersDAO adUsersDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;
	/**
	 * Instantiates a new AdAddressesDAOTest.
	 *
	 */
	public AdAddressesDAOTest() {
	}

	/**
	 * Method to test AdAddresses domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void AdAddresses() {
		
		AdUsers adUsers = adUsersDAO.findAdUsersByPrimaryKey(1);
		assertNotNull(adUsers);
		assertNotNull(adUsers.getUserId());

		
		AdAddresses instance = new AdAddresses();
		instance.setActiveStatus(1);
		instance.setAddressLine1("111 address line");
		instance.setAddressLine2("address line 2");

		//set country value
		AdLookupValues adLookupValues = adLookupValuesDAO.findAdLookupValuesByPrimaryKey(238);
		assertNotNull(adLookupValues);
		
		instance.setAdLookupValues(adLookupValues);
		instance.setAdUsers(adUsers);
		instance.setCity("New York");
		instance.setCounty("NY");
		instance.setCreatedBy(-1);
		instance.setCreationDate(Calendar.getInstance());
		instance.setLangCode("US-en");
		instance.setLastUpdateDate(Calendar.getInstance());
		instance.setLastUpdatedBy(-1);
		instance.setPostalCode("10001");
		instance.setState("NY");
		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				
		// store the object
		AdAddresses tempInstance = dataStore.store(instance);
	    assertNotNull(tempInstance.getAddressId());
		
		// Test update
		tempInstance.setCounty("NY1");
		// update the object
		dataStore.store(tempInstance);
		AdAddresses newInstance = dataStore.findAdAddressesByPrimaryKey(tempInstance.getAddressId());
		assertEquals("NY1" , newInstance.getCounty());
	
		// Test delete
		dataStore.remove(tempInstance);
		newInstance = dataStore.findAdAddressesByPrimaryKey(tempInstance.getAddressId());
		assertNull(newInstance);
	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AdAddressesDAO dataStore) {
		this.dataStore = dataStore;
	}
}
