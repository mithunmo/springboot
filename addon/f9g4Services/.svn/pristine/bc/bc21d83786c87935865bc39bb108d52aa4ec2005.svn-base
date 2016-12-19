package com.f9g4.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.f9g4.common.util.Constants;
import com.f9g4.domain.StCategoryMaster;

import static  junit.framework.Assert.*;
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
*/
		})
public class StCategoryMasterDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private StCategoryMasterDAO dataStore;

	/**
	 * Instantiates a new StCategoryMasterDAOTest.
	 *
	 */
	public StCategoryMasterDAOTest() {
	}

	/**
	 * Method to test StCategoryMaster domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void StCategoryMaster() {
		StCategoryMaster instance = new StCategoryMaster();

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
	public void setDataStore(StCategoryMasterDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	
	@Test
	public void testFindStCategoryMasterByParentId(){
		int parentid = 0;
		Set<StCategoryMaster> stCategoryMastersSet = dataStore.findStCategoryMasterByParentId(parentid);
		assertNotNull(stCategoryMastersSet);
		assertNotNull(stCategoryMastersSet.size() > 0);
	}
	
	
	@Test
	public void testFindStCategoryMasterByLevel(){
		
		Set<StCategoryMaster> stCategoryMastersSet = dataStore.findStCategoryMasterByLevel(Constants.CATEGORY_LAVEL_1);
		assertNotNull(stCategoryMastersSet);
		assertNotNull(stCategoryMastersSet.size() > 0);
	}
	
	
	@Test
	public void testFindStCategoryMasterByLevelAndParentId(){
		Set<StCategoryMaster> stCategoryMastersSet = dataStore.findStCategoryMasterByLevelAndParentId(Constants.CATEGORY_LAVEL_1, Constants.PARENT_ID_0);
		assertNotNull(stCategoryMastersSet);
		assertNotNull(stCategoryMastersSet.size() > 0);
	}
	
	@Test
	public void testFindStCategoryMasterByLevelAndParentId_2(){
		Set<StCategoryMaster> stCategoryMastersSet = dataStore.findStCategoryMasterByLevelAndParentId(Constants.CATEGORY_LAVEL_2, 2);
		assertNotNull(stCategoryMastersSet);
		assertNotNull(stCategoryMastersSet.size() > 0);
	}
	
	@Test
	public void testFindStCategoryMastersForLevel3() {
		Set<StCategoryMaster> stCategoryMastersSet = dataStore.findStCategoryMastersForLevel3(1,13, -1, -1);
		System.out.println(stCategoryMastersSet.size());
		for(StCategoryMaster item : stCategoryMastersSet)
			System.out.println(item.getName());
	}
	
	@Test
	public void testFindStCategoryMastersForLevel4() {
		List<String> nameOnLevel3 = new ArrayList<String>();
		nameOnLevel3.add("Capes");
		nameOnLevel3.add("Bottoms");
		nameOnLevel3.add("Dresses");
		Set<StCategoryMaster> stCategoryMastersSet = dataStore.findStCategoryMastersForLevel4(1,13,nameOnLevel3, -1, -1);
		System.out.println(stCategoryMastersSet.size());
		for(StCategoryMaster item : stCategoryMastersSet)
			System.out.println(item.getName());
	}
}
