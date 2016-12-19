package com.f9g4.dao;

import static org.junit.Assert.*;

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

import com.f9g4.common.util.ActiveStatusEnum;
import com.f9g4.domain.AdLookupValues;
import com.f9g4.domain.AdUsers;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrMessages;

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
		//"file:./src/main/resources/f9g4-security-context.xml",
		//"file:./src/main/resources/f9g4-service-context.xml",
		//"file:./src/main/resources/f9g4-dao-context.xml",
		//"file:./src/main/resources/f9g4-web-context.xml" 
		})
public class TrMessagesDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	@Autowired
	private TrMessagesDAO dataStore;

	@Autowired
	private AdUsersDAO adUsersDAO = null;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDAO = null;

	/**
	 * Instantiates a new TrMessagesDAOTest.
	 *
	 */
	public TrMessagesDAOTest() {
	}

	
	/**
	 * Method to test TrMessages domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrMessages() {
		
		AdUsers adUser = adUsersDAO.findAdUsersByPrimaryKey(2);
		AdLookupValues adLookupValues =  adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult("UD"); //		450
		Calendar date = Calendar.getInstance();
		TrMessages instance = new TrMessages();

		instance.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
		//message status id - unread - UD - 450 
		instance.setAdLookupValues(adLookupValues);
		
		instance.setAdUsersByFromUserId(adUser);
		instance.setAdUsersByToUserId(adUser);
		instance.setCreatedBy(adUser.getUserId());
		instance.setCreationDate(date);
		instance.setLangCode("en-US");
		instance.setLastUpdateDate(date);
		instance.setLastUpdatedBy(adUser.getUserId());
		instance.setMessageBody("Test messageBody" );
		//instance.setMessageId(messageId);
		instance.setMessageType("INBOX");
		//instance.setReadOn(readOn);
		instance.setSubject("Test subject");
		TrBoard trBoard = new TrBoard();
		trBoard.setBoardId(27);
		instance.setTrBoard(trBoard);
//		instance.set;
		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				

		// store the object
		dataStore.store(instance);

		// Test update
		// TODO: Modify non-key domain object values for update

		// update the object
		//dataStore.store(instance);

		// Test delete
		//dataStore.remove(instance);

	}

	@Test
	public void testFindTrMessagesByUserMessageTypeAndMessageStatus(){
		AdUsers adUser = adUsersDAO.findAdUsersByPrimaryKey(2);
		AdLookupValues adLookupValues =  adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult("UD"); //		450
		Calendar date = Calendar.getInstance();
		TrMessages instance = new TrMessages();

		instance.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
		//message status id - unread - UD - 450 
		instance.setAdLookupValues(adLookupValues);
		
		instance.setAdUsersByFromUserId(adUser);
		instance.setAdUsersByToUserId(adUser);
		instance.setCreatedBy(adUser.getUserId());
		instance.setCreationDate(date);
		instance.setLangCode("en-US");
		instance.setLastUpdateDate(date);
		instance.setLastUpdatedBy(adUser.getUserId());
		instance.setMessageBody("Test messageBody" );
		//instance.setMessageId(messageId);
		instance.setMessageType("ALERT");
		//instance.setReadOn(readOn);
		instance.setSubject("Test subject");
		TrBoard trBoard = new TrBoard();
		trBoard.setBoardId(27);
		instance.setTrBoard(trBoard);
		// store the object
		dataStore.store(instance);
		dataStore.flush();
		
		Set<TrMessages>  messageSet = dataStore.findTrMessagesByUserMessageTypeAndMessageStatus(adUser.getUserId(), "ALERT", adLookupValues.getLangCode());	
		assertNotNull(messageSet);
	}
	
	
	@Test
	public void testFindTrMessagesCountByUserMessageTypeAndMessageStatus(){
		AdUsers adUser = adUsersDAO.findAdUsersByPrimaryKey(2);
		AdLookupValues adLookupValues =  adLookupValuesDAO.findAdLookupValuesByLookupCodeSingleResult("UD"); //		450
		Calendar date = Calendar.getInstance();
		TrMessages instance = new TrMessages();

		instance.setActiveStatus(ActiveStatusEnum.ACTIVE.value());
		//message status id - unread - UD - 450 
		instance.setAdLookupValues(adLookupValues);
		
		instance.setAdUsersByFromUserId(adUser);
		instance.setAdUsersByToUserId(adUser);
		instance.setCreatedBy(adUser.getUserId());
		instance.setCreationDate(date);
		instance.setLangCode("en-US");
		instance.setLastUpdateDate(date);
		instance.setLastUpdatedBy(adUser.getUserId());
		instance.setMessageBody("Test messageBody" );
		//instance.setMessageId(messageId);
		instance.setMessageType("ALERT");
		//instance.setReadOn(readOn);
		instance.setSubject("Test subject");
		TrBoard trBoard = new TrBoard();
		trBoard.setBoardId(27);
		instance.setTrBoard(trBoard);
		// store the object
		dataStore.store(instance);
		dataStore.flush();
		
		Long count = dataStore.findTrMessagesCountByUserMessageTypeAndMessageStatus(adUser.getUserId(), "ALERT", adLookupValues.getLookupCode());	
		assertNotNull(count);
		assertTrue(count > 0);
	}
	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(TrMessagesDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testGetAllMessagesbyBoardandUser(){
//		System.out.println(dataStore.findTrMessagesByBoardUserMessageTypeAndMessageStatus(26, 17, "INBOX").size());
		for (TrMessages messages : dataStore.findTrMessagesByBoardUserMessageTypeAndMessageStatus(26, 17,16, "INBOX")) {
			System.out.println(messages);
		}
	}
	
	@Test
	public void testLatestMessagesbyUser(){
//		System.out.println(dataStore.findTrMessagesByBoardUserMessageTypeAndMessageStatus(26, 17, "INBOX").size());
	
	}
}
