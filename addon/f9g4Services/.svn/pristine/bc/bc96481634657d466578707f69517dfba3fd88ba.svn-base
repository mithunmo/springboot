package com.f9g4.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import com.f9g4.domain.TrReferrals;

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
		/*		"file:./src/main/resources/f9g4-security-context.xml",
		"file:./src/main/resources/f9g4-service-context.xml",
		"file:./src/main/resources/f9g4-dao-context.xml",
		"file:./src/main/resources/f9g4-web-context.xml" 
*/		})
public class TrReferralsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrReferralsDAO dataStore;

	/**
	 * Instantiates a new TrReferralsDAOTest.
	 *
	 */
	public TrReferralsDAOTest() {
	}

	/**
	 * Method to test TrReferrals domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrReferrals() {
		TrReferrals instance = new TrReferrals();

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
	public void setDataStore(TrReferralsDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindTrReferralsByUser(){
		Set<TrReferrals> trReferralsSet = this.dataStore.findTrReferralsByUser(1);
		assertNotNull(trReferralsSet);
		assertTrue(trReferralsSet.size() > 0 );
	}
}
