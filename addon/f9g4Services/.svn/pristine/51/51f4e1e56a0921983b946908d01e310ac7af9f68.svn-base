package com.f9g4.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Set;
import java.util.List;

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

import com.f9g4.domain.SingleResultLong;
import com.f9g4.domain.TrActivityScreenCompanyGrid;
import com.f9g4.domain.TrActivityScreenDesignerGrid;
import com.f9g4.domain.TrActivityScreenGraph;
import com.f9g4.domain.TrRecentlyViewed;

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
public class TrRecentlyViewedDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private TrRecentlyViewedDAO dataStore;

	/**
	 * Instantiates a new TrRecentlyViewedDAOTest.
	 *
	 */
	public TrRecentlyViewedDAOTest() {
	}

	/**
	 * Method to test TrRecentlyViewed domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void TrRecentlyViewed() {
		TrRecentlyViewed instance = new TrRecentlyViewed();

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
	public void setDataStore(TrRecentlyViewedDAO dataStore) {
		this.dataStore = dataStore;
	}
	
	@Test
	public void testFindTrRecentlyViewedByUserAndEventTimestamp(){
		Calendar eventTimestamp = Calendar.getInstance();
		eventTimestamp.add(Calendar.DATE, -1000);
		eventTimestamp.set(Calendar.HOUR, 0);
		eventTimestamp.set(Calendar.MINUTE, 0);
		eventTimestamp.set(Calendar.SECOND, 0);
		eventTimestamp.set(Calendar.MILLISECOND, 0);
		
		Set<TrRecentlyViewed> set = dataStore.findTrRecentlyViewedByUserAndEventTimestamp(17, eventTimestamp);
		//assertNotNull(set);
		//assertTrue(set.size() > 0) ;		
		System.out.println(set.size());
	}

	@Test
	public void testfindTrRecentlyViewedCountByUserAndBetweenEventTimestamp(){
		
		Calendar eventTimestampStart = Calendar.getInstance();
		Calendar eventTimestampEnd = Calendar.getInstance();
		
		System.out.println(eventTimestampEnd.get(Calendar.DATE));
		
		eventTimestampStart.set(Calendar.HOUR, 0);
		eventTimestampStart.set(Calendar.MINUTE, 0);
		eventTimestampStart.set(Calendar.SECOND, 0);
		eventTimestampStart.set(Calendar.MILLISECOND, 0);
		
		//eventTimestampStart.add(Calendar.DATE, -1);
		
		eventTimestampEnd.set(Calendar.HOUR, 23);
		eventTimestampEnd.set(Calendar.MINUTE, 59);
		eventTimestampEnd.set(Calendar.SECOND, 59);
		//eventTimestampEnd.set(Calendar.MILLISECOND, 999);
		
		System.out.println("1 day");
		Long count = dataStore.findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(17, eventTimestampStart, eventTimestampEnd);
		System.out.println("17 count ->"+count.intValue());
		count = dataStore.findTrRecentlyViewedCountByOriginalUserIdAndEventTimestamp(16, eventTimestampStart, eventTimestampEnd);
		System.out.println("16 count ->"+count.intValue());
		//assertNotNull(count);
		//assertTrue(count >= 0) ;	
		System.out.println("7 days");
		eventTimestampStart.add(Calendar.DATE, -6);
		count = dataStore.findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(17, eventTimestampStart, eventTimestampEnd);
		System.out.println("17 count ->"+count.intValue());
		count = dataStore.findTrRecentlyViewedCountByOriginalUserIdAndEventTimestamp(16, eventTimestampStart, eventTimestampEnd);
		System.out.println("16 count ->"+count.intValue());
		System.out.println("30 days");
		eventTimestampStart.add(Calendar.DATE, -23);
		count = dataStore.findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(17, eventTimestampStart, eventTimestampEnd);
		System.out.println("17 count ->"+count.intValue());
		count = dataStore.findTrRecentlyViewedCountByOriginalUserIdAndEventTimestamp(16, eventTimestampStart, eventTimestampEnd);
		System.out.println("16 count ->"+count.intValue());
	}
	

	@Test
	public void testfindTrRecentlyViewedCountByUserAndBetweenEventTimestamp_last7days(){
		
		Calendar eventTimestampStart = Calendar.getInstance();
		Calendar eventTimestampEnd = Calendar.getInstance();
		
		System.out.println(eventTimestampEnd.get(Calendar.DATE));
		
		eventTimestampStart.set(Calendar.HOUR, 0);
		eventTimestampStart.set(Calendar.MINUTE, 0);
		eventTimestampStart.set(Calendar.SECOND, 0);
		eventTimestampStart.set(Calendar.MILLISECOND, 0);
		
		eventTimestampStart.add(Calendar.DATE, -1);
		
		eventTimestampStart.set(Calendar.HOUR, 0);
		eventTimestampStart.set(Calendar.MINUTE, 0);
		eventTimestampStart.set(Calendar.SECOND, 0);
		eventTimestampStart.set(Calendar.MILLISECOND, 0);
		
		Long count = dataStore.findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(17, eventTimestampStart, eventTimestampEnd);
		System.out.println("count->"+count);
		System.out.println(eventTimestampEnd.get(Calendar.DATE));
		
		//eventTimestampStart.add(Calendar.DATE, -1);
		//count = dataStore.findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(17, eventTimestampStart, eventTimestampEnd);
		//System.out.println("count->"+count+"date->"+eventTimestampStart.get(Calendar.DATE));
		//System.out.println(eventTimestampEnd.get(Calendar.DATE));
		
		eventTimestampStart.add(Calendar.DATE, -6);
		count = dataStore.findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(17, eventTimestampStart, eventTimestampEnd);
		System.out.println("count->"+count+"date->"+eventTimestampStart.get(Calendar.DATE));
		
		eventTimestampStart.add(Calendar.DATE, -23);
		System.out.println(eventTimestampEnd.get(Calendar.DATE));
		count = dataStore.findTrRecentlyViewedCountByUserAndBetweenEventTimestamp(17, eventTimestampStart, eventTimestampEnd);
		System.out.println("count->"+count+"date->"+eventTimestampStart.get(Calendar.DATE));
		
				
	}
	
	//findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp

	@Test
	public void testfindTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp_last7days(){
		
		Calendar eventTimestamp = Calendar.getInstance();
		eventTimestamp.add(Calendar.DATE, -1*30);
		eventTimestamp.set(Calendar.HOUR, 0);
		eventTimestamp.set(Calendar.MINUTE, 0);
		eventTimestamp.set(Calendar.SECOND, 0);
		eventTimestamp.set(Calendar.MILLISECOND, 0);
		
		Set<TrRecentlyViewed> rset = dataStore.findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp(16, eventTimestamp);
		Set<TrRecentlyViewed> set = dataStore.findTrRecentlyViewedByUserAndEventTimestamp(17, eventTimestamp);
		System.out.println("size -> "+ set.size() +" rset ->" + rset.size());

	}
	
	//findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestampandGroupbyBoard
	@Test
	public void testfindTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestampandGroupbyBoard(){
		
		Calendar eventTimestamp = Calendar.getInstance();
		eventTimestamp.add(Calendar.DATE, -1*30);
		eventTimestamp.set(Calendar.HOUR, 0);
		eventTimestamp.set(Calendar.MINUTE, 0);
		eventTimestamp.set(Calendar.SECOND, 0);
		eventTimestamp.set(Calendar.MILLISECOND, 0);
		
		Set<TrRecentlyViewed> rset = dataStore.findTrRecentlyViewedBytrBoardOriginalUserIdAndEventTimestamp(16, eventTimestamp);
		Set<TrRecentlyViewed> set = dataStore.findTrRecentlyViewedByUserAndEventTimestamp(17, eventTimestamp);
		System.out.println("size -> "+ set.size() +" rset ->" + rset.size());

	}
	
	@Test
	public void testfindTrRecentlyViewedByUserIdtopn()
	{
		Set<TrRecentlyViewed> set = dataStore.findTrRecentlyViewedByUserIdtopn(17,6);
		System.out.println(set.size());
	}
	
	@Test
	public void testfindCompanyGridInfo()
	{
		Calendar eventTimestamp = Calendar.getInstance();
		eventTimestamp.add(Calendar.DATE, -1*1);
		eventTimestamp.set(Calendar.HOUR, 0);
		eventTimestamp.set(Calendar.MINUTE, 0);
		eventTimestamp.set(Calendar.SECOND, 0);
		eventTimestamp.set(Calendar.MILLISECOND, 0);
		
		List<TrActivityScreenCompanyGrid> objs = dataStore.GetCompanyGridInfo(17,2,eventTimestamp);
		SingleResultLong count = dataStore.GetCompanyCount(17,eventTimestamp);
		System.out.println("Record Count -> "+ objs.size() +"count -> "+ count.getCount());
		
		eventTimestamp.add(Calendar.DATE, -1*6);
		objs = dataStore.GetCompanyGridInfo(17,2,eventTimestamp);
		count = dataStore.GetCompanyCount(17,eventTimestamp);
		System.out.println("Record Count -> "+ objs.size() +"count -> "+ count.getCount());
		
		eventTimestamp.add(Calendar.DATE, -1*24);
		objs = dataStore.GetCompanyGridInfo(17,2,eventTimestamp);
		count = dataStore.GetCompanyCount(17,eventTimestamp);
		System.out.println("Record Count -> "+ objs.size() +"count -> "+ count.getCount());
	}
	
	@Test
	public void testfindDesignerGridInfo()
	{
		Calendar eventTimestamp = Calendar.getInstance();
		eventTimestamp.add(Calendar.DATE, -1);
		eventTimestamp.set(Calendar.HOUR, 0);
		eventTimestamp.set(Calendar.MINUTE, 0);
		eventTimestamp.set(Calendar.SECOND, 0);
		eventTimestamp.set(Calendar.MILLISECOND, 0);
		
		
		
		List<TrActivityScreenDesignerGrid> objs = dataStore.GetDesignerGridInfo(16,eventTimestamp);
		SingleResultLong count = dataStore.GetDesignerCount(16,eventTimestamp);
		System.out.println("Record Count -> "+ objs.size() +"count -> "+ count.getCount());
		
		eventTimestamp.add(Calendar.DATE, -1*6);
		objs = dataStore.GetDesignerGridInfo(16,eventTimestamp);
		count = dataStore.GetDesignerCount(16,eventTimestamp);
		System.out.println("Record Count -> "+ objs.size() +"count -> "+ count.getCount());
		
		eventTimestamp.add(Calendar.DATE, -1*23);
		objs = dataStore.GetDesignerGridInfo(16,eventTimestamp);
		count = dataStore.GetDesignerCount(16,eventTimestamp);
		System.out.println("Record Count -> "+ objs.size() +"count -> "+ count.getCount());
	}
	
	@Test
	public void testTrActivityScreenCompanyGraph()
	{
		Calendar eventTimestamp = Calendar.getInstance();
		eventTimestamp.add(Calendar.DATE, -1*30);
		eventTimestamp.set(Calendar.HOUR, 0);
		eventTimestamp.set(Calendar.MINUTE, 0);
		eventTimestamp.set(Calendar.SECOND, 0);
		eventTimestamp.set(Calendar.MILLISECOND, 0);
		
		List<TrActivityScreenGraph> objs = dataStore.GetCompanyGraphInfo(17, eventTimestamp);
		
		assertNotNull(objs);
		
		System.out.println("Record Count -> "+ objs.size());
	}
	
	@Test
	public void testTrActivityScreenDesignerGraph()
	{
		Calendar eventTimestamp = Calendar.getInstance();
		eventTimestamp.add(Calendar.DATE, -1*30);
		eventTimestamp.set(Calendar.HOUR, 0);
		eventTimestamp.set(Calendar.MINUTE, 0);
		eventTimestamp.set(Calendar.SECOND, 0);
		eventTimestamp.set(Calendar.MILLISECOND, 0);
		
		List<TrActivityScreenGraph> objs = dataStore.GetDesignerGraphInfo(16, eventTimestamp);
		
		assertNotNull(objs);
		
		System.out.println("Record Count -> "+ objs.size());
	}
	
}
