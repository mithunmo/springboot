package com.f9g4.servicesdk;

import java.util.Properties;

import com.f9g4.businessobjects.services.AddRecentlyViewedBoardRequest;
import com.f9g4.businessobjects.services.AddRecentlyViewedBoardResponse;
import com.f9g4.businessobjects.services.AddUserLogRequest;
import com.f9g4.businessobjects.services.AddUserLogResponse;
import com.f9g4.businessobjects.services.GetActiveuserResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IDataCaptureService;

public class DataCaptureServiceSDK extends AbstractRestSDK<IDataCaptureService> implements IDataCaptureService {
	
	private Properties dataCaptureServiceProperties;
	
	private String dataCaptureServiceConfigFile;

	private ServiceType callType;
	
//	@Autowired
	private IDataCaptureService dataCaptureService;
	

	public Properties getDataCaptureServiceProperties() {
		return dataCaptureServiceProperties;
	}

	public void setDataCaptureServiceProperties(
			Properties dataCaptureServiceProperties) {
		this.dataCaptureServiceProperties = dataCaptureServiceProperties;
	}

	public String getDataCaptureServiceConfigFile() {
		return dataCaptureServiceConfigFile;
	}

	public void setDataCaptureServiceConfigFile(String dataCaptureServiceConfigFile) {
		this.dataCaptureServiceConfigFile = dataCaptureServiceConfigFile;
	}

	public IDataCaptureService getDataCaptureService() {
		return dataCaptureService;
	}

	public void setDataCaptureService(IDataCaptureService dataCaptureService) {
		this.dataCaptureService = dataCaptureService;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	public AddRecentlyViewedBoardResponse addRecentlyViewBoard(
			AddRecentlyViewedBoardRequest request) {
		
		return getService().addRecentlyViewBoard(request);
	}

	public AddUserLogResponse logUserData(AddUserLogRequest request) {
		
		return getService().logUserData(request);
	}

	public GetActiveuserResponse getActiveUserLoggedRecord(String sessionid) {
		
		return getService().getActiveUserLoggedRecord(sessionid);
	}

	@Override
	protected String getClientConfigFile() {
		
		return this.dataCaptureServiceConfigFile;
	}

	@Override
	protected Properties getProperties() {
		
		return this.dataCaptureServiceProperties;
	}

	@Override
	protected ServiceType getCallType() {
		
		return this.callType;
	}

	@Override
	protected IDataCaptureService getLocalService() {
		
		return this.dataCaptureService;
	}

	@Override
	protected  IDataCaptureService getMockService() {
		
		return null;
	}

}
