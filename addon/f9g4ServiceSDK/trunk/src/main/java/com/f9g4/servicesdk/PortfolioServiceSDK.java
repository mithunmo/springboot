package com.f9g4.servicesdk;

import java.util.Properties;

import com.f9g4.businessobjects.services.AddPortfolioRequest;
import com.f9g4.businessobjects.services.AddPortfolioResponse;
import com.f9g4.businessobjects.services.AssignMembersToContestRequest;
import com.f9g4.businessobjects.services.AssignMembersToContestResponse;
import com.f9g4.businessobjects.services.CreateContestRequest;
import com.f9g4.businessobjects.services.CreateContestResponse;
import com.f9g4.businessobjects.services.DeletePortfolioByIdResponse;
import com.f9g4.businessobjects.services.EditContestRequest;
import com.f9g4.businessobjects.services.EditContestResponse;
import com.f9g4.businessobjects.services.GetAllContestsResponse;
import com.f9g4.businessobjects.services.GetContestByUserIdResponse;
import com.f9g4.businessobjects.services.GetContestDetailsResponse;
import com.f9g4.businessobjects.services.GetContestMembersResponse;
import com.f9g4.businessobjects.services.GetPortfolioByIdResponse;
import com.f9g4.businessobjects.services.GetPortfolioByUserResponse;
import com.f9g4.businessobjects.services.UpdatePortfolioRequest;
import com.f9g4.businessobjects.services.UpdatePortfolioResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.IPortfolioService;

public class PortfolioServiceSDK extends AbstractRestSDK<IPortfolioService> implements IPortfolioService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Properties portfolioServiceProperties;

	private String portfolioServiceConfigFile;

	private ServiceType callType;

//	@Autowired
	private IPortfolioService porfolioService;

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	public Properties getPortfolioServiceProperties() {
		return portfolioServiceProperties;
	}

	public void setPortfolioServiceProperties(
			Properties portfolioServiceProperties) {
		this.portfolioServiceProperties = portfolioServiceProperties;
	}

	public String getPortfolioServiceConfigFile() {
		return portfolioServiceConfigFile;
	}

	public void setPortfolioServiceConfigFile(String portfolioServiceConfigFile) {
		this.portfolioServiceConfigFile = portfolioServiceConfigFile;
	}

	public IPortfolioService getPorfolioService() {
		return porfolioService;
	}

	public void setPorfolioService(IPortfolioService porfolioService) {
		this.porfolioService = porfolioService;
	}

	@Override
	protected String getClientConfigFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Properties getProperties() {
		// TODO Auto-generated method stub
		return this.portfolioServiceProperties;
	}

	@Override
	protected ServiceType getCallType() {
		// TODO Auto-generated method stub
		return this.callType;
	}

	@Override
	protected IPortfolioService getLocalService() {
		// TODO Auto-generated method stub
		return this.porfolioService;
	}

	@Override
	protected IPortfolioService getMockService() {
		// TODO Add STUB implementation

		return null;
	}

	public AddPortfolioResponse addPortfolio(AddPortfolioRequest request) {

		return getService().addPortfolio(request);
	}

	public GetPortfolioByIdResponse getPortfoliobyId(
			int request) {
		
		return getService().getPortfoliobyId(request);
	}

	public GetPortfolioByUserResponse getPortfoliobyUser(int request) {
		return getService().getPortfoliobyUser(request);
	}

	public DeletePortfolioByIdResponse deletePortfolioById(int portfolioid) {
		return getService().deletePortfolioById(portfolioid);
	}

	public UpdatePortfolioResponse updatePortfolio(UpdatePortfolioRequest request) {
		return getService().updatePortfolio(request);
		}
	
	public GetPortfolioByUserResponse getUnsellablePortfoliobyUser(int userid) {
		return getService().getUnsellablePortfoliobyUser(userid);
	}

	public CreateContestResponse createContest(CreateContestRequest request) {
		
		return getService().createContest(request);
	}

	public EditContestResponse editContest(EditContestRequest request) {
		return getService().editContest(request);
	}

	public GetContestByUserIdResponse getContestByUserId(int userid) {
		return getService().getContestByUserId(userid);
	}

	public GetAllContestsResponse getAllContests() {
		return getService().getAllContests();
	}

	public AssignMembersToContestResponse assignMembersToContest(
			AssignMembersToContestRequest request) {
		return getService().assignMembersToContest(request);
	}

	public GetContestMembersResponse getContestMembers(int portfolioid) {
		return getService().getContestMembers(portfolioid);
	}

	public GetContestDetailsResponse getContestDetails(int portfolioid,
			int contestid) {		
		return getService().getContestDetails(portfolioid, contestid);
	}
}
