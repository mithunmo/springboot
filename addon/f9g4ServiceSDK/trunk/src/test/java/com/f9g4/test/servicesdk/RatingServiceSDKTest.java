package com.f9g4.test.servicesdk;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.f9g4.businessobjects.domain.TrRatingsDomain;
import com.f9g4.businessobjects.services.AddRatingRequest;
import com.f9g4.businessobjects.services.GetUserRatingRequest;
import com.f9g4.businessobjects.services.GetUserRatingResponse;
import com.f9g4.servicesdk.RatingServiceSDK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class RatingServiceSDKTest {

@Autowired
private RatingServiceSDK ratingSDK;

@Test
public void testAddRating(){
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
	domain.setRatingUserId(16);
	request.setBoardrating(domain);
	ratingSDK.addRating(request);
	
}

@Test
public void testGetRatingForBoardbyUserid(){
	ratingSDK.getRatingforBoardbyUser(16, 26);
}

@Test
public void testgetRatingforUser()
{
	GetUserRatingRequest req = new GetUserRatingRequest();
	req.setUserId(17);
	GetUserRatingResponse res = ratingSDK.getRatingforUser(req);
	assertNotNull(res);
}

}
