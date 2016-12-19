package com.f9g4.dao;

import java.util.Set;

import com.f9g4.domain.TrPortfolio;
import com.f9g4.domain.TrPortfolioImages;

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
		"file:./src/main/resources/f9g4-web-context.xml" */})
public class TrPortfolioDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrPortfolioDAO dataStore;

	/**
	 * Instantiates a new TrPortfolioDAOTest.
	 *
	 */
	public TrPortfolioDAOTest() {
	}

	/**
	 * Method to test TrPortfolio domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrPortfolio() {
		TrPortfolio instance = new TrPortfolio();

		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				
		
		instance.setActiveStatus(1);
		instance.setName("dadsad");
		instance.setDescription("sdasdas");
		//instance.setAdUsers(3);
		
		// store the object
		dataStore.store(instance);

		// Test update
		// TODO: Modify non-key domain object values for update

		// update the object
		dataStore.store(instance);

		// Test delete
		//dataStore.remove(instance);

	}

	@Test
	public void testCheckBoardStatus()
	{
		Long result=dataStore.checkBoardStatusByPortfolioId(27);
		System.out.println(result);
	}
	
	@Test
	public void testGetPortfolioById()
	{
		TrPortfolio portfolio = dataStore.findTrPortfolioByPortfolioId(255);
		System.out.println("Size=> "+portfolio.getTrPortfolioImages().size());
		for(TrPortfolioImages item : portfolio.getTrPortfolioImages())
		{
			System.out.println(item.getPortfolioImageId()+" ; "+item.getFileName());
		}
	}
	
	@Test
	public void testGetUnsellablePortfolio()
	{
		Set<TrPortfolio> portfolio = dataStore.findUnsellableTrPortfolioByUserId(16);
		System.out.println(portfolio.size());
		for(TrPortfolio item : portfolio)
		{
			System.out.println(item.getPortfolioId());
		}
	}
	
	@Test
	public void testFindTrPortfolioByUserIdAndSellable()
	{
		Set<TrPortfolio> portfolio = dataStore.findTrPortfolioByUserIdAndSellable(16,0);
		System.out.println(portfolio.size());
		for(TrPortfolio item : portfolio)
		{
			System.out.println(item.getPortfolioId());
		}
	}
	
	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(TrPortfolioDAO dataStore) {
		this.dataStore = dataStore;
	}
}
