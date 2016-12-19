package com.f9g4.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f9g4.businessobjects.common.Status;
import com.f9g4.businessobjects.domain.TrRatingsDomain;
import com.f9g4.businessobjects.services.AddRatingRequest;
import com.f9g4.businessobjects.services.AddRatingResponse;
import com.f9g4.businessobjects.services.GetBoardRatingsResponse;
import com.f9g4.businessobjects.services.GetUserRatingRequest;
import com.f9g4.businessobjects.services.GetUserRatingResponse;
import com.f9g4.businessobjects.services.Rating;
import com.f9g4.businessobjects.services.Rating1;
import com.f9g4.common.errors.StatusCodesEnum;
import com.f9g4.common.util.LanguageCodesEnum;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.dao.AdLookupValuesDAO;
import com.f9g4.dao.AdUsersDAO;
import com.f9g4.dao.TrBoardDAO;
import com.f9g4.dao.TrRatingsDAO;
import com.f9g4.domain.TrRatings;
import com.f9g4.services.rest.IRatingService;

@Service("ratingService")
public class RatingService implements IRatingService {
	
	private static final Logger logger = LoggerFactory.getLogger(RatingService.class);
	
	@Autowired
	private TrRatingsDAO ratingDao;
	
	@Autowired
	private AdUsersDAO adUserDao;
	
	@Autowired
	private AdLookupValuesDAO adLookupValuesDao;
	
	@Autowired
	private TrBoardDAO trBoardDao;
	
	public AddRatingResponse addRating(AddRatingRequest request) {
		AddRatingResponse response= new AddRatingResponse();
		Status status = new Status();
		response.setStatus(status);
		try
		{
			TrRatings entity=this.convertDomainToEntity(request.getBoardrating());
			ratingDao.merge(entity);
			status.setDescription("Success");
			status.setStatuscode("0");	
		}
		catch(Exception e)
		{
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Error occured");
		}
		return response;
	}

//	public GetBoardRatingsResponse getRatingforBoard(int boardid) {
//		GetBoardRatingsResponse response=new GetBoardRatingsResponse();
//		TrRatingsDomain domain= new TrRatingsDomain();
//		
////		ratingDao.findTrRatingsByBoardid(boardId);
//		domain=convertEntityToDomain(ratingDao.findTrRatingsByBoardid(boardid));
//		response.setBoardrating(domain);
//		return response;
//	}

	
	public GetBoardRatingsResponse getRatingforBoardbyUser(int userid ,int boardid) {
		// TODO Auto-generated method stub
		GetBoardRatingsResponse response=new GetBoardRatingsResponse();
		TrRatingsDomain domain= new TrRatingsDomain();
		TrRatings entity = new TrRatings();
		Status status=new Status();;
		try
		{
			entity = ratingDao.findTrRatingsByUserforBoard(userid, boardid);
			domain=convertEntityToDomain(entity);
			response.setBoardrating(domain);
			status.setStatuscode(StatusCodesEnum.STATUS_SUCCESS.getCode());
		}
		catch(Exception e)
		{
			logger.error("Exception Occurred", e);
			status.setStatuscode(StatusCodesEnum.STATUS_ERR_UNKNOWN.getCode());
			status.setDescription("Unknown Error");
		}
		response.setStatus(status);
		return response;
	}

	private TrRatings convertDomainToEntity(TrRatingsDomain domain)
	{
		TrRatings entity =new TrRatings();
		try
		{
			entity.setRating1(new BigDecimal(domain.getRating1()));
			entity.setRating2(new BigDecimal(domain.getRating2()));
			entity.setRating3(new BigDecimal(domain.getRating3()));
			entity.setRating4(new BigDecimal(domain.getRating4()));
	//		entity.setRating5(new BigDecimal(domain.getRating5()));
	//		entity.setRating6(new BigDecimal(domain.getRating6()));
			entity.setAdLookupValuesByRatingQuestion1Id(adLookupValuesDao.findAdLookupValuesByLookupValueId(domain.getRatingQuestion1Id()));
			entity.setAdLookupValuesByRatingQuestion2Id(adLookupValuesDao.findAdLookupValuesByLookupValueId(domain.getRatingQuestion2Id()));
			entity.setAdLookupValuesByRatingQuestion3Id(adLookupValuesDao.findAdLookupValuesByLookupValueId(domain.getRatingQuestion3Id()));
			entity.setAdLookupValuesByRatingQuestion4Id(adLookupValuesDao.findAdLookupValuesByLookupValueId(domain.getRatingQuestion4Id()));
	//		entity.setAdLookupValuesByRatingQuestion5Id(adLookupValuesDao.findAdLookupValuesByLookupValueId(domain.getRatingQuestion1Id()));
	//		entity.setAdLookupValuesByRatingQuestion6Id(adLookupValuesDao.findAdLookupValuesByLookupValueId(domain.getRatingQuestion1Id()));
			entity.setAdUsers(adUserDao.findAdUsersByPrimaryKey(domain.getUserId()));
			entity.setComment(domain.getComment());
			entity.setAdLookupValuesByRateTransactionId(adLookupValuesDao.findAdLookupValuesByLookupValueId(domain.getRateTransactionId()));
			entity.setTrBoard(trBoardDao.findTrBoardByBoardId(domain.getBoardId()));
			entity.setLangCode(domain.getLangCode());
			//Ratings are mandatory - No Null check required.
			float avgRating = ((domain.getRating1() +domain.getRating2()+domain.getRating3()+domain.getRating4())/4);
			entity.setAvgRating(new BigDecimal(avgRating));
			entity.setAdRatingUsers(adUserDao.findAdUsersByPrimaryKey(domain.getRatingUserId()));
			entity.setLangCode(LanguageCodesEnum.EN_US.getLangCode());
		}
		catch(Exception e)
		{
			logger.error("Exception Occurred", e);
		}
		return entity;			
	}
	
	
	private TrRatingsDomain convertEntityToDomain(TrRatings entity){
		TrRatingsDomain domain= new TrRatingsDomain();
		domain.setAvarageRating(entity.getAvgRating().floatValue());
		domain.setBoardId(entity.getTrBoard().getBoardId());
		domain.setComment(entity.getComment());
		domain.setRateTransactionId(entity.getAdLookupValuesByRateTransactionId().getLookupValueId());
		domain.setRating1(entity.getRating1().floatValue());
		domain.setRating2(entity.getRating2().floatValue());
		domain.setRating3(entity.getRating3().floatValue());
		domain.setRating4(entity.getRating4().floatValue());
//		domain.setRating5(entity.getRating5().floatValue());
		if(entity.getCreatedBy()!=null)
			domain.setCreatedby(entity.getCreatedBy());
		domain.setUserId(entity.getAdUsers().getUserId());
		domain.setRatingQuestion1Id(entity.getAdLookupValuesByRatingQuestion1Id().getLookupValueId());
		domain.setRatingQuestion2Id(entity.getAdLookupValuesByRatingQuestion2Id().getLookupValueId());
		domain.setRatingQuestion3Id(entity.getAdLookupValuesByRatingQuestion3Id().getLookupValueId());
		domain.setRatingQuestion4Id(entity.getAdLookupValuesByRatingQuestion4Id().getLookupValueId());
//		domain.setRatingQuestion5Id(entity.getAdLookupValuesByRatingQuestion5Id().getLookupValueId());
		return domain;
	}

	public GetUserRatingResponse getRatingforUser(GetUserRatingRequest request) {
		// TODO Auto-generated method stub
		GetUserRatingResponse response = new GetUserRatingResponse();
		
		Set<TrRatings> trRatingsSet = ratingDao.findTrRatingsByRatingUserId(request.getUserId());
		//System.out.println("count at 1 place:" + trRatingsSet.size());
		
		BigDecimal ratingQ1 = new BigDecimal(0);
		BigDecimal ratingQ2 = new BigDecimal(0);
		BigDecimal ratingQ3 = new BigDecimal(0);
		BigDecimal ratingQ4 = new BigDecimal(0);
		BigDecimal ratingAverage = new BigDecimal(0);
		
		BigDecimal count =	new BigDecimal(trRatingsSet.size());
		//System.out.println("count at 2 place:" + count);
			
		for (TrRatings trRatings : trRatingsSet) {

			//rating question 1 RD11 or RQ11
			if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_CUSTOMIZATION.getTypeCode())){
				ratingQ1 = ratingQ1.add(trRatings.getRating1());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PRICING.getTypeCode())){
				ratingQ1 = ratingQ1.add(trRatings.getRating1());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_WORK.getTypeCode())){
				ratingQ1 = ratingQ1.add(trRatings.getRating1());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_RELIABILITY.getTypeCode())){
				ratingQ1 = ratingQ1.add(trRatings.getRating1());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_COMMUNICATION.getTypeCode())) {
				ratingQ1 = ratingQ1.add(trRatings.getRating1());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_DENPENDABILITY.getTypeCode())) {
				ratingQ1 = ratingQ1.add(trRatings.getRating1());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_EXPECTATIONS_FROM_YOU.getTypeCode())) {
				ratingQ1 = ratingQ1.add(trRatings.getRating1());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PAYMENT_TERMS.getTypeCode())) {
				ratingQ1 = ratingQ1.add(trRatings.getRating1());
			}

			//rating question 2 RD21 or RQ21
			if(trRatings.getAdLookupValuesByRatingQuestion2Id().getLookupCode().equals(LookupTypeValueEnum.RATING_CUSTOMIZATION.getTypeCode())){
				ratingQ2 = ratingQ2.add(trRatings.getRating2());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion2Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PRICING.getTypeCode())){
				ratingQ2 = ratingQ2.add(trRatings.getRating2());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion2Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_WORK.getTypeCode())){
				ratingQ2 = ratingQ2.add(trRatings.getRating2());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion2Id().getLookupCode().equals(LookupTypeValueEnum.RATING_RELIABILITY.getTypeCode())){
				ratingQ2 = ratingQ2.add(trRatings.getRating2());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_COMMUNICATION.getTypeCode())) {
				ratingQ2 = ratingQ2.add(trRatings.getRating2());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_DENPENDABILITY.getTypeCode())) {
				ratingQ2 = ratingQ2.add(trRatings.getRating2());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_EXPECTATIONS_FROM_YOU.getTypeCode())) {
				ratingQ2 = ratingQ2.add(trRatings.getRating2());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PAYMENT_TERMS.getTypeCode())) {
				ratingQ2 = ratingQ2.add(trRatings.getRating2());
			}
			

			//rating question 3 RD31 or RQ31
			if(trRatings.getAdLookupValuesByRatingQuestion3Id().getLookupCode().equals(LookupTypeValueEnum.RATING_CUSTOMIZATION.getTypeCode())){
				ratingQ3 = ratingQ3.add(trRatings.getRating3());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion3Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PRICING.getTypeCode())){
				ratingQ3 = ratingQ3.add(trRatings.getRating3());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion3Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_WORK.getTypeCode())){
				ratingQ3 = ratingQ3.add(trRatings.getRating3());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion3Id().getLookupCode().equals(LookupTypeValueEnum.RATING_RELIABILITY.getTypeCode())){
				ratingQ3 = ratingQ3.add(trRatings.getRating3());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_COMMUNICATION.getTypeCode())) {
				ratingQ3 = ratingQ3.add(trRatings.getRating3());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_DENPENDABILITY.getTypeCode())) {
				ratingQ3 = ratingQ3.add(trRatings.getRating3());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_EXPECTATIONS_FROM_YOU.getTypeCode())) {
				ratingQ3 = ratingQ3.add(trRatings.getRating3());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PAYMENT_TERMS.getTypeCode())) {
				ratingQ3 = ratingQ3.add(trRatings.getRating3());
			}			

			
			//rating question 4 RD41 or RQ41
			if(trRatings.getAdLookupValuesByRatingQuestion4Id().getLookupCode().equals(LookupTypeValueEnum.RATING_CUSTOMIZATION.getTypeCode())){
				ratingQ4 = ratingQ4.add(trRatings.getRating4());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion4Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PRICING.getTypeCode())){
				ratingQ4 = ratingQ4.add(trRatings.getRating4());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion4Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_WORK.getTypeCode())){
				ratingQ4 = ratingQ4.add(trRatings.getRating4());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion4Id().getLookupCode().equals(LookupTypeValueEnum.RATING_RELIABILITY.getTypeCode())){
				ratingQ4 = ratingQ4.add(trRatings.getRating4());				
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_QUALITY_OF_COMMUNICATION.getTypeCode())) {
				ratingQ4 = ratingQ4.add(trRatings.getRating4());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_DENPENDABILITY.getTypeCode())) {
				ratingQ4 = ratingQ4.add(trRatings.getRating4());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_EXPECTATIONS_FROM_YOU.getTypeCode())) {
				ratingQ4 = ratingQ4.add(trRatings.getRating4());
			}else if(trRatings.getAdLookupValuesByRatingQuestion1Id().getLookupCode().equals(LookupTypeValueEnum.RATING_PAYMENT_TERMS.getTypeCode())) {
				ratingQ4 = ratingQ4.add(trRatings.getRating4());
			}
			
			//average rating
			ratingAverage = ratingAverage.add(trRatings.getAvgRating());
		}
		//System.out.println("DIVISION="+count);
		if(!BigDecimal.ZERO.equals(count)){
			ratingQ1 = ratingQ1.divide(count,2, RoundingMode.HALF_EVEN);
			response.setQualityRating(new Rating1(ratingQ1, count.intValue()));
			
			ratingQ2 = ratingQ2.divide(count,2, RoundingMode.HALF_EVEN);
			response.setPriceRating(new Rating1(ratingQ2, count.intValue()));
			
			ratingQ3 = ratingQ3.divide(count,2, RoundingMode.HALF_EVEN);
			response.setReliabilityRating(new Rating1(ratingQ3, count.intValue()));
			
			ratingQ4 = ratingQ4.divide(count,2, RoundingMode.HALF_EVEN);
			response.setCustomizationRating(new Rating1(ratingQ4, count.intValue()));
			
			ratingAverage = ratingAverage.divide(count,2, RoundingMode.HALF_EVEN);
			response.setAverageRating(new Rating1(ratingAverage, count.intValue()));
		}
		else
		{
			Rating1 zeroRating = new Rating1(BigDecimal.ZERO,0); 
			response.setCustomizationRating(zeroRating);
			response.setPriceRating(zeroRating);
			response.setQualityRating(zeroRating);
			response.setReliabilityRating(zeroRating);
			response.setAverageRating(zeroRating);
		}
		
		return response;
	}
}
