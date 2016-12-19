package com.f9g4.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.naming.directory.SearchResult;

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

import com.f9g4.common.bo.DesignWall;
import com.f9g4.common.bo.SearchResults;
import com.f9g4.domain.TrBoard;
import com.f9g4.domain.TrBoardSearch;

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
public class TrBoardDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrBoardDAO dataStore;

	/**
	 * Instantiates a new TrBoardDAOTest.
	 *
	 */
	public TrBoardDAOTest() {
	}

	/**
	 * Method to test TrBoard domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrBoard() {
		TrBoard instance = new TrBoard();

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
	public void setDataStore(TrBoardDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	/**
	 * sorcolumn , 1- userName, 2 - totalPrice, 3 - sellerPayDate, 4 - paymentStatusId
	 * sortdirection, 1- Asc, any other number descending oreder.. 
	 * 
	 */

	@Test
	public void testFindDesingwallBoards_userName_ASC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(1, 1, 1, 10, new Integer(1));
		//List<DesignWall> list
		assertNotNull(searchResults);
	}

	@Test
	public void testFindDesingwallBoards_userName_DESC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(1, 0, 1, 10, new Integer(1));
		assertNotNull(searchResults);
	}


	@Test
	public void testFindDesingwallBoards_totalPrice_ASC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(2, 1, 1, 10, new Integer(1));
		assertNotNull(searchResults);
	}

	@Test
	public void testFindDesingwallBoards_totalPrice_DESC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(2, 0, 1, 10, new Integer(1));
		assertNotNull(searchResults);
	}

	@Test
	public void testFindDesingwallBoards_sellerPayDate_ASC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(3, 1, 1, 10, new Integer(1));
		assertNotNull(searchResults);
	}

	@Test
	public void testFindDesingwallBoards_sellerPayDate_DESC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(3, 0, 1, 10, new Integer(1));
		assertNotNull(searchResults);
	}

	@Test
	public void testFindDesingwallBoards_paymentStatusId_ASC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(4, 1, 1, 10, new Integer(1));
		assertNotNull(searchResults);

	}

	@Test
	public void testFindDesingwallBoards_paymentStatusId_DESC(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(4, 0, 1, 10, new Integer(1));
		assertNotNull(searchResults);
	}
	

	@Test
	public void testFindDesingwallBoards_totalPrice(){
//		dataStore.findDesingwallBoards(sortColumn, sortOrder, firstResult, maxResults, parameters)
		SearchResults searchResults = dataStore.findDesingwallBoards(4, 0, 1, 10, new Integer(17));
		assertNotNull(searchResults);
		assertTrue(searchResults.getTotalAmount().compareTo(new BigDecimal(0)) == 1);
		System.out.println(searchResults.getTotalAmount());
	}
	//trBoardDAO.findDesingwallBoards(sortColumn, sortDirection, startingRecord, noOfRecords, userId)
	@Test
	public void testFindDesingwallBoards_Pravin(){
		SearchResults searchResults = dataStore.findDesingwallBoards(2, 0, 1, 10, 17);
		assertNotNull(searchResults);
		System.out.println("total amount ppaid -> " + searchResults.getTotalAmount());
		System.out.println("no of rows ->"+ searchResults.getTotalRows());
		System.out.println("page1 count ->"+searchResults.getResults().size());
		for(Object item:searchResults.getResults())
		{
			DesignWall wallItem = (DesignWall) item;
			System.out.println(wallItem.getBoardId()+" => "+wallItem.getSalePrice());
		}
		//System.out.println("Board name ->"+SearchResults.get);
	}
	
	@Test
	public void testFindTrBoardByCurrentUserId(){
		Set<TrBoard> set = dataStore.findTrBoardByCurrentUserId(1);
		assertNotNull(set);
	}

	@Test
	public void testFindTrBoardByBoardIds(){
		List<Integer> boardIds = new ArrayList<Integer>();
		boardIds.add(26);
		boardIds.add(27);
		boardIds.add(28);
		boardIds.add(29);
		Set<TrBoard> set = dataStore.findTrBoardByBoardIds(boardIds);
		assertNotNull(set);
		assertTrue(set.size() > 0);
	}
	
	@Test
	public void testfindTrBoardsOfExamplesBySearchCriteria(){
		String designerName = null;
		//Integer ratingStart = 0;
		//Integer ratingEnd = 5;
		Integer[] countryIds = null;
		//Integer[] langIds  = new Integer[] {277}; //English as default 
		Integer[] langIds  = null; 

		Integer[] skillIds = null; 
		String schoolAwards = null;

		//Integer division = null; 
		//Integer category = null; 
		Integer level3 = null;
//		String level3Name = "Dresses";
//		String [] level4 = {"Test","Test1"}; 
		String level3Name = null;
		String [] level4 = null;
		//String [] level4 = new String[] {"test"}; 
		//Integer[] seasonYearIds = null;
		//Integer[] saleTypeIds = null;  
		//BigDecimal priceLow = null;
		//BigDecimal priceHigh = null; 
		Integer limt =500;
		//String keywords = null;
		//Integer memPricingOption = 2;
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = null;
		Date endDate= null;
		Integer[] expertiseIds = new Integer[] {};
		Integer[] specialtyIds = new Integer[] {};
		Integer[] educationIds = new Integer[] {};
		try {
			startDate = formatter.parse("01/01/2000");
			endDate = formatter.parse("08/25/2014");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Marketplace submission:");
		  Set<TrBoardSearch> set = dataStore.findTrBoardsOfExamplesBySearchCriteria(designerName, countryIds, langIds, skillIds, schoolAwards, limt, true, startDate, endDate, expertiseIds, specialtyIds, educationIds, -1, 5);
		System.out.println(set.size());
		for (TrBoardSearch trBoardSearch : set) {
			System.out.println(trBoardSearch.getBoardId() +":" + trBoardSearch.getName() +":" +  trBoardSearch.getActiveStatus() +":" +  trBoardSearch.getDesigner().getFirstname()+":"+ trBoardSearch.getDesigner().getUserId());
		}
		
	
		System.out.println("===============================================");
		System.out.println("Portfolio page:");
		  Set<TrBoardSearch> set1 = dataStore.findTrBoardsOfExamplesBySearchCriteria(designerName, countryIds, langIds, skillIds, schoolAwards, limt, true, startDate, endDate, expertiseIds, specialtyIds, educationIds, -1, 5);
		System.out.println(set1.size());
		for (TrBoardSearch trBoardSearch : set1) {
			System.out.println(trBoardSearch.getBoardId() +":" + trBoardSearch.getName() +":" +  trBoardSearch.getActiveStatus() +":" +  trBoardSearch.getDesigner().getFirstname()+":"+ trBoardSearch.getDesigner().getUserId());
		}
		
	}
	
	@Test
	public void testFindTrBoardsBySearchCriteria(){
		//Set<TrBoardSearch> set = dataStore.findTrBoardsBySearchCriteria(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 100);
		
		String designerName = null;
		Integer ratingStart = 0;
		Integer ratingEnd = 5;
		Integer[] countryIds = null;
		Integer[] langIds  = new Integer[] {277}; //English as default 
		Integer[] skillIds = null; 
		String schoolAwards = null;
		Integer division = null; 
		Integer category = null; 
		Integer level3 = null;
//		String level3Name = "Dresses";
//		String [] level4 = {"Test","Test1"}; 
		String level3Name = null;
		String [] level4 = null;
		//String [] level4 = new String[] {"test"}; 
		Integer[] seasonYearIds = null;
		Integer[] saleTypeIds = null;  
		BigDecimal priceLow = null;
		BigDecimal priceHigh = null; 
		Integer limt =100;
		String keywords = null;
		Integer memPricingOption = 2;
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = null;
		Date endDate= null;
		Integer[] expertiseIds = new Integer[] {};
		Integer[] specialtyIds = new Integer[] {};
		Integer[] educationIds = new Integer[] {};
		try {
			startDate = formatter.parse("01/01/2013");
			endDate = formatter.parse("08/25/2014");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Marketplace submission:");
		Set<TrBoardSearch> set = dataStore.findTrBoardsBySearchCriteria(designerName, ratingStart, ratingEnd, countryIds, langIds, skillIds, schoolAwards, division, category, level3Name, level4, seasonYearIds, saleTypeIds, priceLow, priceHigh, keywords,limt,2,false, null,null, expertiseIds, specialtyIds, educationIds,0,5);
		System.out.println(set.size());
		for (TrBoardSearch trBoardSearch : set) {
			System.out.println(trBoardSearch.getBoardId() +":" + trBoardSearch.getName() +":" +  trBoardSearch.getActiveStatus() +":" +  trBoardSearch.getDesigner().getFirstname()+":"+ trBoardSearch.getDesigner().getUserId());
		}
		
		//assertNotNull(set);
		//assertTrue(set.size() > 0);
		
		System.out.println("===============================================");
		System.out.println("Portfolio page:");
		Set<TrBoardSearch> set1 = dataStore.findTrBoardsBySearchCriteria(designerName, ratingStart, ratingEnd, countryIds, langIds, skillIds, schoolAwards, division, category, level3Name, level4, seasonYearIds, saleTypeIds, priceLow, priceHigh, keywords,limt,2,true, startDate,endDate, expertiseIds, specialtyIds, educationIds,0,5);
		System.out.println(set1.size());
		for (TrBoardSearch trBoardSearch : set1) {
			System.out.println(trBoardSearch.getBoardId() +":" + trBoardSearch.getName() +":" +  trBoardSearch.getActiveStatus() +":" +  trBoardSearch.getDesigner().getFirstname()+":"+ trBoardSearch.getDesigner().getUserId());
		}
	}
	
	@Test
	public void testFindTrBoardsCountAndTotalPurchasedByUser(){
		dataStore.findTrBoardsCountAndTotalPurchasedByUser(17);
/*		assertNotNull(set);
		assertTrue(set.size() > 0); */
	}

	@Test
	public void testFindTrBoardsFromRecentlyViewedBoards(){

		Set<TrBoardSearch> set = dataStore.findTrBoardsFromRecentlyViewedBoards(17, 2, 6);
		
		assertNotNull(set);
		assertTrue(set.size() >= 0);
		assertTrue(set.size() <=6);

	}
	
	@Test
	public void testFindTrBoardsForMayWeSuggst(){

		Set<TrBoardSearch> set = dataStore.findTrBoardsForMayWeSuggest(2,6);
		for(TrBoardSearch item : set)
		{
			System.out.println(item.getBoardId());
		}
		assertNotNull(set);
		assertTrue(set.size() >= 0);
		assertTrue(set.size() <=6);
	}
	
	@Test
	public void testGetDesignerAccount()
	{
		SearchResults searchResults = dataStore.findDesignerAccount(0, 0, 0, 0, 81);
		assertNotNull(searchResults);
		//System.out.println("total amount ppaid -> " + searchResults.getTotalAmount());
		//System.out.println("no of rows ->"+ searchResults.getTotalRows());
		System.out.println("Result=>"+searchResults.getResults());
		System.out.println("page1 count ->"+searchResults.getResults().size());
	}
	
	@Test
	public void testFindTrBoardByContainingPublishToMP()
	{
		List<Integer> publishToMp = new ArrayList<Integer>();
		//publishToMp.add(1);
		publishToMp.add(2);
		List<Integer> portfolioTypes = new ArrayList<Integer>();
		//publishToMp.add(1);
		portfolioTypes.add(1);
		Set<TrBoard> set = dataStore.findTrBoardByContainingPublishToMP(publishToMp, portfolioTypes, -1, -1);
		assertNotNull(set);
	}
	
	@Test
	public void testFindTrBoardForSample()
	{
		Set<TrBoard> set = dataStore.findTrBoardForSample(-1);
		System.out.println(set.size());
	}
	
	@Test
	public void testFindTrBoardForSampleByUserId()
	{
		List<Integer> userIds = new ArrayList<Integer>();
		userIds.add(17);
		Set<TrBoard> set = dataStore.findTrBoardForSampleByUserId(userIds, -1);
		System.out.println(set.size());
	}

}
