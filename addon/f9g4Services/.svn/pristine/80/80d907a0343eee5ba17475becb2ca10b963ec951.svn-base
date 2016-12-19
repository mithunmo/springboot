package com.f9g4.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Set;

import com.f9g4.domain.AdLookupValues;
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
import com.f9g4.domain.TrBroadcastMessages;

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
public class TrBroadcastMessagesDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrBroadcastMessagesDAO dataStore;

	/**
	 * Instantiates a new TrReferralsDAOTest.
	 *
	 */
	public TrBroadcastMessagesDAOTest() {
	}

	/**
	 * Method to test TrReferrals domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrBroadcastMessages() {
		TrBroadcastMessages instance = new TrBroadcastMessages();

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
	public void setDataStore(TrBroadcastMessagesDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindAllTrBroadcastMessages(){
		Set<TrBroadcastMessages> trBroadcastMessagesSet = this.dataStore.findAllTrBroadcastMessages();
		assertNotNull(trBroadcastMessagesSet);
		assertTrue(trBroadcastMessagesSet.size() > 0 );
		for (TrBroadcastMessages item : trBroadcastMessagesSet) {
			//System.out.println("Phone :" +item.getMessageText());
			System.out.println(item.toString());
		}
		
	}
	
	@Test
	public void testFindTrBroadcastMessagesByBroadcastId(){
		Set<TrBroadcastMessages> trBroadcastMessagesSet = this.dataStore.findTrBroadcastMessagesByBroadcastId(1);
		assertNotNull(trBroadcastMessagesSet);
		assertTrue(trBroadcastMessagesSet.size() > 0 );
		for (TrBroadcastMessages item : trBroadcastMessagesSet) {
			//System.out.println("Phone :" +item.getMessageText());
			System.out.println(item.toString());
		}
		
	}
	
	@Test
	public void testFindTrBroadcastMessagesByMsgScopeId(){
		Set<TrBroadcastMessages> trBroadcastMessagesSet = this.dataStore.findTrBroadcastMessagesByMsgScopeId(540);
		assertNotNull(trBroadcastMessagesSet);
		assertTrue(trBroadcastMessagesSet.size() > 0 );
		for (TrBroadcastMessages item : trBroadcastMessagesSet) {
			//System.out.println("Phone :" +item.getMessageText());
			System.out.println(item.toString());
		}
		
	}
	
	@Test
	public void testFindTrBroadcastMessagesByMsgStatusId(){
		Set<TrBroadcastMessages> trBroadcastMessagesSet = this.dataStore.findTrBroadcastMessagesByMsgStatusId(525);
		assertNotNull(trBroadcastMessagesSet);
		assertTrue(trBroadcastMessagesSet.size() > 0 );
		for (TrBroadcastMessages item : trBroadcastMessagesSet) {
			//System.out.println("Phone :" +item.getMessageText());
			System.out.println(item.toString());
		}
		
	}
	
	@Test
	public void testInsert(){
		TrBroadcastMessages item = new TrBroadcastMessages();
		AdLookupValues scope=new AdLookupValues();
		AdLookupValues status=new AdLookupValues();
		scope.setLookupValueId(540);
		status.setLookupValueId(525);
		item.setMessageText("Test 1");
		item.setAdLookupValuesByMsgScopeId(scope);
		item.setAdLookupValuesByMsgStatusId(status);
		item.setLastUpdatedBy(2);
		item.setCreatedBy(2);
		item.setLastUpdateDate(Calendar.getInstance());
		item.setCreationDate(Calendar.getInstance());
		dataStore.merge(item);
	}
}
