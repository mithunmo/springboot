package com.f9g4.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.StTermsConditions;

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
public class StTermsConditionsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private StTermsConditionsDAO dataStore;

	@Autowired
	private AdAcceptTermsDAO adAcceptTermsDAO;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO; 
	/**
	 * Instantiates a new StTermsConditionsDAOTest.
	 *
	 */
	public StTermsConditionsDAOTest() {
	}

	/**
	 * Method to test StTermsConditions domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void StTermsConditions() {
		
		StTermsConditions instance = new StTermsConditions();
		
		AdLookupValues adLookupValuesByTermTypeId = adLookupValuesDAO.findAdLookupValuesByLookupValueId(439);
		AdLookupValues adLookupValuesByUserTypeId = adLookupValuesDAO.findAdLookupValuesByLookupValueId(438);
		
		instance.setAdLookupValuesByTermTypeId(adLookupValuesByTermTypeId);
		instance.setAdLookupValuesByUserTypeId(adLookupValuesByUserTypeId);
		instance.setCreatedBy(-1);
		instance.setCreationDate(Calendar.getInstance());
		String tAndC = "Test Dispalyed T&C";
		instance.setDisplayedTerms(tAndC.getBytes());
		instance.setEffectiveDate(Calendar.getInstance());
		instance.setExpirationDate(Calendar.getInstance());
		instance.setLangCode("en-US");
		instance.setLastUpdateDate(Calendar.getInstance());
		instance.setLastUpdatedBy(-1);
		instance.setReviewedByLegal(-1);
		// store the object
		StTermsConditions tempInstance = dataStore.store(instance);
		assertNotNull(tempInstance.getTermCondId());
		
		// Test update
		tempInstance.setDisplayedTerms((tAndC + "_1").getBytes());
		// update the object
		dataStore.store(tempInstance);
		StTermsConditions newInstance = dataStore.findStTermsConditionsByPrimaryKey(tempInstance.getTermCondId());
		assertEquals((tAndC + "_1"), new String(newInstance.getDisplayedTerms()));
	
		// Test delete
		dataStore.remove(tempInstance);
		newInstance = dataStore.findStTermsConditionsByPrimaryKey(tempInstance.getTermCondId());
		assertNull(newInstance);
	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(StTermsConditionsDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindStTermsConditionsByUserTypeAndTermType() throws DataAccessException {
		Set<StTermsConditions> stTermsConditions = dataStore.findActiveStTermsConditionsByUserTypeAndTermType(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode(),  
							LookupTypeValueEnum.MEMEBER_TERM_TYPE_REGISTRATION.getTypeCode());
		assertNotNull(stTermsConditions);
	}
	
	@Test
	public void testfindStTermsConditionsByTermCondId() throws DataAccessException {
		StTermsConditions stTermsConditions = dataStore.findStTermsConditionsByTermCondId(2);
		System.out.println("Term condn Id" + stTermsConditions.getTermCondId());
		assertNotNull(stTermsConditions);
		assertNull(stTermsConditions.getExpirationDate());
	}
	
	@Test
	public void testFindStTermsByUserIdAndTermType() {
		List<Integer> termTypes = new ArrayList();
		termTypes.add(464);
		Set<StTermsConditions> stTermsConditions = dataStore.findAllTermsConditionsByUserIdAndTermType(16, termTypes);
		System.out.println(stTermsConditions.size());
	}
}
