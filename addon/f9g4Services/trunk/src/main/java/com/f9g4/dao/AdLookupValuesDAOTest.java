package com.f9g4.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Set;

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

import com.f9g4.common.util.LookupTypeEnum;
import com.f9g4.domain.AdLookTypesEnum;
import com.f9g4.domain.AdLookupTypes;
import com.f9g4.domain.AdLookupValues;

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

public class AdLookupValuesDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AdLookupValuesDAO dataStore;

	@Autowired
	private AdLookupTypesDAO lookupTypesDAO;
	/**
	 * Instantiates a new AdLookupValuesDAOTest.
	 *
	 */
	public AdLookupValuesDAOTest() {
	}

	/**
	 * Method to test AdLookupValues domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void AdLookupValues() {
		AdLookupValues instance = new AdLookupValues();
		
		int activeStatus = 1;
		instance.setActiveStatus(activeStatus);
		
//		int activeStatus = 1;
//		instance.setAdAddresseses(adAddresseses);
		AdLookupTypes adLookupTypes = lookupTypesDAO.findAdLookupTypesByLookupTypeName(AdLookTypesEnum.USER_SKILLS.toString());
		assertNotNull(adLookupTypes);
//		AdLookupTypes adLookupTypes = lookTypes.get(0); 
//		AdLookupTypes adLookupTypes = new AdLookupTypes();
//		adLookupTypes.setActiveStatus(1);
//		adLookupTypes.setCreatedBy(1);
//		adLookupTypes.setCreationDate(Calendar.getInstance());
//		adLookupTypes.setLastUpdateDate(Calendar.getInstance());
//		adLookupTypes.setLastUpdatedBy(1);
//		adLookupTypes.setLangCode("en-US");
//		adLookupTypes.setLookupDescription("Test Description");
//		adLookupTypes.setLookupType("USER_SKILLS");

		
//		int activeStatus = 1;
//		instance.setAdUserLanguageses(adUserLanguageses);
//		int activeStatus = 1;
//		instance.setAdUserMembershipses(adUserMembershipses);
//		int activeStatus = 1;
//		instance.setAdUsersesForRegStatusId(adUsersesForRegStatusId);
		

		instance.setAdLookupTypes(adLookupTypes);
		instance.setCreatedBy(-1);
		instance.setCreationDate(Calendar.getInstance());
		instance.setDescription("test description");
		instance.setLangCode("en_us");
		instance.setLastUpdateBy(1);
		instance.setLastUpdateDate(Calendar.getInstance());
		instance.setLookupCode("TEST");
//		instance.set;

		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.
		// store the object
		AdLookupValues tempInstance = dataStore.store(instance);
		assertNotNull(tempInstance.getLookupValueId());
		
		// Test update
		tempInstance.setDescription("test_description_1");
		// update the object
		dataStore.store(tempInstance);
		AdLookupValues newInstance = dataStore.findAdLookupValuesByLookupValueId(tempInstance.getLookupValueId());
		assertEquals("test_description_1", newInstance.getDescription());
	
		// Test delete
		dataStore.remove(tempInstance);
		newInstance = dataStore.findAdLookupValuesByLookupValueId(tempInstance.getLookupValueId());
		assertNull(newInstance);
	}
	
	@Test
	public void testFindAdLookupValuesByLookupType(){
		Set<AdLookupValues> adLookupValuesSet =  dataStore.findAdLookupValuesByLookupType(LookupTypeEnum.USER_SEC_QUESTION1.getTypeName());
		assertNotNull(adLookupValuesSet);
		assertTrue(adLookupValuesSet.size() > 0);
/*		for (AdLookupValues adLookupValues : adLookupValuesSet) {
			System.out.println(adLookupValues.getDescription());
		}*/
		
	}
	
	@Test
	public void testFindAllAdLookupValuesByLookupType(){
		Set<AdLookupValues> adLookupValuesSet =  dataStore.findAllAdLookupValuesByLookupType(LookupTypeEnum.EDUCATION.getTypeName());
		assertNotNull(adLookupValuesSet);
		assertTrue(adLookupValuesSet.size() > 0);
/*		for (AdLookupValues adLookupValues : adLookupValuesSet) {
			System.out.println(adLookupValues.getDescription());
		}*/
		
	}


	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AdLookupValuesDAO dataStore) {
		this.dataStore = dataStore;
	}
}
