package com.f9g4.servicesdk;

import java.util.Properties;

import com.f9g4.businessobjects.services.AddRatingRequest;
import com.f9g4.businessobjects.services.AddRatingResponse;
import com.f9g4.businessobjects.services.GetBoardRatingsResponse;
import com.f9g4.businessobjects.services.GetUserRatingRequest;
import com.f9g4.businessobjects.services.GetUserRatingResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IRatingService;

public class RatingServiceSDK extends AbstractRestSDK<IRatingService> {

	private static final long serialVersionUID = 1L;

	private Properties ratingServiceProperties;

	private String ratingServiceConfigFile;

	private ServiceType callType;
	
	private IRatingService ratingservice;
	
	

	public Properties getRatingServiceProperties() {
		return ratingServiceProperties;
	}

	public void setRatingServiceProperties(Properties ratingServiceProperties) {
		this.ratingServiceProperties = ratingServiceProperties;
	}

	public String getRatingServiceConfigFile() {
		return ratingServiceConfigFile;
	}

	public void setRatingServiceConfigFile(String ratingServiceConfigFile) {
		this.ratingServiceConfigFile = ratingServiceConfigFile;
	}

	public IRatingService getRaingservice() {
		return ratingservice;
	}

	public void setRaingservice(IRatingService ratingservice) {
		this.ratingservice = ratingservice;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	
	@Override
	protected ServiceType getCallType() {
		// TODO Auto-generated method stub
		return this.callType;
	}

	@Override
	protected IRatingService getLocalService() {
		// TODO Auto-generated method stub
		return this.ratingservice;
	}

	@Override
	protected IRatingService getMockService() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public GetBoardRatingsResponse getRatingforBoardbyUser(int userid, int boardid){
		return getService().getRatingforBoardbyUser(userid, boardid);
		
	}
	
	public AddRatingResponse addRating(AddRatingRequest request){
		 return this.getService().addRating(request);
	}
	
	public GetUserRatingResponse getRatingforUser(GetUserRatingRequest request){
		return this.getService().getRatingforUser(request);
	}
	

	@Override
	protected String getClientConfigFile() {
		// TODO Auto-generated method stub
		return this.ratingServiceConfigFile;
	}

	@Override
	protected Properties getProperties() {
		// TODO Auto-generated method stub
		return this.ratingServiceProperties;
	}
	
}
