package com.f9g4.dao;

import static org.junit.Assert.assertNotNull;

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

import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.domain.StMemPricingOptions;

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
		"file:./src/main/resources/f9g4-web-context.xml"*/ 
		})
public class StMemPricingOptionsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private StMemPricingOptionsDAO dataStore;

	/**
	 * Instantiates a new StMemPricingOptionsDAOTest.
	 *
	 */
	public StMemPricingOptionsDAOTest() {
	}

	/**
	 * Method to test StMemPricingOptions domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void StMemPricingOptions() {
		StMemPricingOptions instance = new StMemPricingOptions();

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
	public void setDataStore(StMemPricingOptionsDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindStMemPricingOptionsByUserTypeAndMembershipType(){
		
		StMemPricingOptions stMemPricingOptions = dataStore.findStMemPricingOptionsByUserTypeAndMembershipType(LookupTypeValueEnum.USER_TYPE_DESIGNER.getTypeCode(), LookupTypeValueEnum.MEMEBERSHIP_TYPE_STANDARD.getTypeCode());
		
		assertNotNull(stMemPricingOptions);
		
		
		
	}
}
