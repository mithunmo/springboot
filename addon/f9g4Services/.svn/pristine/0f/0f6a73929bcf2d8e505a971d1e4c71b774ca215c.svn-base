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

import com.f9g4.domain.AdContacts;
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
public class AdContactsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdContactsDAO dataStore;
	
	@Autowired
	private AdUsersDAO adUsersDAO;

	/**
	 * Instantiates a new AdContactsDAOTest.
	 *
	 */
	public AdContactsDAOTest() {
	}

	/**
	 * Method to test AdContacts domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void AdContacts() {
		
		AdUsers adUsers = adUsersDAO.findAdUsersByPrimaryKey(1);
		assertNotNull(adUsers);
		assertNotNull(adUsers.getUserId());

		
		AdContacts instance = new AdContacts();
		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				
		instance.setAdUsers(adUsers);
		instance.setCellphone("480-400-4444");
		instance.setCreatedBy(-1);
		instance.setCreationDate(Calendar.getInstance());
		instance.setFax("480-400-5555");
		instance.setLangCode("en-US");
		instance.setLastUpdateBy(-1);
		instance.setLastUpdatedDate(Calendar.getInstance());
		instance.setWorkExtn("1234");
		instance.setWorkPhone("480-400-6666");
		// store the object
//		dataStore.store(instance);
		instance.setContactId(1);
		AdContacts tempInstance = dataStore.store(instance);
	    assertNotNull(tempInstance.getContactId());
		
		// Test update
		tempInstance.setCellphone("480-400-1111");
		// update the object
		dataStore.store(tempInstance);
		AdContacts newInstance = dataStore.findAdContactsByPrimaryKey(tempInstance.getContactId());
		assertEquals("480-400-1111", newInstance.getCellphone());
	
		// Test delete
		dataStore.remove(tempInstance);
		newInstance = dataStore.findAdContactsByPrimaryKey(tempInstance.getContactId());
		assertNull(newInstance);
	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AdContactsDAO dataStore) {
		this.dataStore = dataStore;
	}
}
