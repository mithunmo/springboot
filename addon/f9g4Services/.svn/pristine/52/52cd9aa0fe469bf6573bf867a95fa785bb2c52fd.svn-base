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

import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUserSkills;
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
public class AdUserSkillsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdUserSkillsDAO dataStore;
	
	@Autowired
	private AdUsersDAO adUsersDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO;

	/**
	 * Instantiates a new AdUserSkillsDAOTest.
	 *
	 */
	public AdUserSkillsDAOTest() {
	}

	/**
	 * Method to test AdUserSkills domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void AdUserSkills() {
		
		AdUsers adUsers = adUsersDAO.findAdUsersByPrimaryKey(1);
		assertNotNull(adUsers);
		assertNotNull(adUsers.getUserId());
		
		AdUserSkills instance = new AdUserSkills();
		instance.setActiveStatus(1);		

		//Skill ids from lookup tables.
		AdLookupValues adLookupValues = adLookupValuesDAO.findAdLookupValuesByPrimaryKey(392);
		instance.setAdLookupValues(adLookupValues);
		instance.setAdUsers(adUsers);
		instance.setCreatedBy(-1);
		instance.setCreationDate(Calendar.getInstance());
		instance.setLastUpdateDate(Calendar.getInstance());
		instance.setLastUpdatedBy(-1);
		instance.setUserSkillId(12345);
		
		// Test create				
		// store the object
		AdUserSkills tempInstance = dataStore.store(instance);
		assertNotNull(tempInstance.getUserSkillId());
		
		// Test update
		tempInstance.setActiveStatus(0);
		// update the object
		dataStore.store(tempInstance);

		AdUserSkills newInstance = dataStore.findAdUserSkillsByUserSkillId(tempInstance.getUserSkillId());
		assertEquals(new Integer(0), newInstance.getActiveStatus());
	
		// Test delete
		dataStore.remove(tempInstance);

		newInstance = dataStore.findAdUserSkillsByUserSkillId(tempInstance.getUserSkillId());
		assertNull(newInstance);
	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AdUserSkillsDAO dataStore) {
		this.dataStore = dataStore;
	}
}
