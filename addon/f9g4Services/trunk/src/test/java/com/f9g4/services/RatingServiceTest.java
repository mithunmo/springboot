package com.f9g4.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.f9g4.businessobjects.domain.TrRatingsDomain;
import com.f9g4.businessobjects.services.AddRatingRequest;
import com.f9g4.businessobjects.services.GetBoardRatingsResponse;
import com.f9g4.businessobjects.services.GetUserRatingRequest;
import com.f9g4.businessobjects.services.GetUserRatingResponse;
import com.f9g4.domain.TrRatings;
import com.f9g4.services.rest.IRatingService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"classpath:com/f9g4/f9g4serviceswebapp/config/applicationContext.xml"
		})
@Transactional
public class RatingServiceTest {

	@Autowired
	private IRatingService ratingService;
	
	@Test
	public void getRatingsByBoardId(){
		
		GetBoardRatingsResponse trrating= ratingService.getRatingforBoardbyUser(16, 26);
		assertNotNull(trrating);
	}
	
	@Test
	public void testAddRatings(){
		TrRatingsDomain domain= new TrRatingsDomain();
		AddRatingRequest request=new AddRatingRequest();
		domain.setBoardId(26);
		domain.setUserId(16);
		domain.setRatingUserId(17);
		domain.setRating1(4);
		domain.setRating2(3);
		domain.setRating3(4);
		domain.setRating4(3);
		domain.setRatingQuestion1Id(459);
		domain.setRatingQuestion1Id(460);
		domain.setRatingQuestion1Id(461);
		domain.setRatingQuestion1Id(462);
		domain.setComment("testing by Kamlesh");
		domain.setLangCode("US_EN");
		domain.setRateTransactionId(458);
		request.setBoardrating(domain);
		ratingService.addRating(request);
		
	}
	
	@Test
	public void testgetRatingforUser()
	{
		GetUserRatingRequest req = new GetUserRatingRequest();
		req.setUserId(17);
		GetUserRatingResponse res = ratingService.getRatingforUser(req);
		assertNotNull(res);
	}
	
	@Test
	public void testGetRatingforBoardbyUser()
	{
		GetBoardRatingsResponse response = ratingService.getRatingforBoardbyUser(17, 26);
		System.out.println(response.getStatus().getStatuscode());
	}
	
	
}
