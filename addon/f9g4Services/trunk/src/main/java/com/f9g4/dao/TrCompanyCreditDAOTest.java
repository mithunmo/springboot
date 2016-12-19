package com.f9g4.dao;

import java.util.Set;

import com.f9g4.domain.TrPortfolioContest;

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
		/* "file:./src/main/resources/f9g4-security-context.xml"
		"file:./src/main/resources/f9g4-service-context.xml",
		"file:./src/main/resources/f9g4-dao-context.xml",
		"file:./src/main/resources/f9g4-web-context.xml" */ })
public class TrCompanyCreditDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrPortfolioContestDAO dataStore;

	/**
	 * Instantiates a new TrCompanyCreditDAOTest.
	 *
	 */
	public TrCompanyCreditDAOTest() {
	}

	/**
	 * Method to test TrCompanyCrdit domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrPortfolioContest() {
		TrPortfolioContest instance = new TrPortfolioContest();

		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				
		instance.setContestId(3);
		instance.setCategory("Dasa");
		instance.setIntroduction("dss");
		//instance.setPortfolioId(3);
		instance.setProjectStatus(2);
		instance.setProjectType(3);
		instance.setCreatedBy(3);
		instance.setLastUpatedBy(3);
		instance.setLangCode("en");
		//instance.setC

		// store the object
		dataStore.store(instance);
		//dataStore.merge(instance);
		//dataStore.flush();

		// Test update
		// TODO: Modify non-key domain object values for update

		// update the object
		dataStore.store(instance);

		// Test delete
		//dataStore.remove(instance);

	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(TrPortfolioContestDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindTrPortfolioContestByPortfolioId()
	{
		TrPortfolioContest entity = dataStore.findTrPortfolioContestByPortfolioId(677, -1, -1);
		System.out.println(entity.getContestId());
	}
	
	@Test
	public void testFindAllTrPortfolioContests()
	{
		Set<TrPortfolioContest> set = dataStore.findAllTrPortfolioContests();
		System.out.println(set.size());
	}
}
