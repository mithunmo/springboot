package com.f9g4.servicesdk;

import java.util.Properties;

import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdResponse;
import com.f9g4.businessobjects.services.GetCompanyNewsResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.ICompanyNews;

public class CompanyNewsSDK extends AbstractRestSDK<ICompanyNews> implements ICompanyNews {
	
	private Properties companyNewsServiceProperties;
	
	private String companyNewsServiceConfigFile;

	private ServiceType callType;
	
//	@Autowired
	private ICompanyNews companyNews;

	public GetCompanyNewsResponse getCompanyNews() {
		return getService().getCompanyNews();
	}

	public GetCompanyNewsDetailbyIdResponse getCompanyNewsDetail(int newsdetailid) {
		return getService().getCompanyNewsDetail(newsdetailid);
	}

	public Properties getCompanyNewsServiceProperties() {
		return companyNewsServiceProperties;
	}

	public void setCompanyNewsServiceProperties(
			Properties companyNewsServiceProperties) {
		this.companyNewsServiceProperties = companyNewsServiceProperties;
	}

	public String getCompanyNewsServiceConfigFile() {
		return companyNewsServiceConfigFile;
	}

	public void setCompanyNewsServiceConfigFile(String companyNewsServiceConfigFile) {
		this.companyNewsServiceConfigFile = companyNewsServiceConfigFile;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	@Override
	protected String getClientConfigFile() {
		return companyNewsServiceConfigFile;
	}

	@Override
	protected Properties getProperties() {
		return companyNewsServiceProperties;
	}

	@Override
	protected ServiceType getCallType() {
		return this.callType;
	}

	@Override
	protected ICompanyNews getLocalService() {
		return this.companyNews;
	}

	@Override
	protected ICompanyNews getMockService() {
		return null;
	}

}
