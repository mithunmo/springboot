package com.f9g4.dao;

import java.util.Set;

import static org.junit.Assert.*;
import com.f9g4.domain.TrRatings;

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
		"file:./src/main/resources/f9g4-web-context.xml" */
		})
public class TrRatingsDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrRatingsDAO dataStore;

	/**
	 * Instantiates a new TrRatingsDAOTest.
	 *
	 */
	public TrRatingsDAOTest() {
	}

	/**
	 * Method to test TrRatings domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrRatings() {
		TrRatings instance = new TrRatings();

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
	public void setDataStore(TrRatingsDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindTrRatingsByUserId(){
//		findTrRatingsByUserId
		Set<TrRatings>  ratingsSet = dataStore.findTrRatingsByUserId(16);
		assertNotNull(ratingsSet);
		assertTrue(ratingsSet.size() >0);
	}
	
	@Test
	public void testFindTrRatingsByCreatedBy(){
//		findTrRatingsByUserId
		dataStore.findTrRatingsByCreatedBy(1);
	}
	
	@Test
	public void testGetRatingbyUserandboard(){
		dataStore.findTrRatingsByUserforBoard(16, 26);
	}
	
	@Test
	public void testGetRatingByRatingUserId()
	{
		Set<TrRatings> set = dataStore.findTrRatingsByRatingUserId(16);
	}
}
