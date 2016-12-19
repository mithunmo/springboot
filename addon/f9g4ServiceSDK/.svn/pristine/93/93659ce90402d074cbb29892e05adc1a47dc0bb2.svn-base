package com.f9g4.servicesdk;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.f9g4.businessobjects.services.GetUserbyEmailResponse;
import com.f9g4.businessobjects.services.GetUserbyUsernamePasswordResponse;
import com.f9g4.service.sdk.AbstractRestSDK;
import com.f9g4.service.sdk.common.ServiceType;
import com.f9g4.services.rest.ISecurityService;
import com.f9g4.servicesdk.stub.SecurityServiceStub;

@SuppressWarnings("serial")
public class SecurityServiceSDK extends AbstractRestSDK<ISecurityService> implements ISecurityService  {

    private Properties securityServiceProperties;
	
	private String securityServiceConfigFile;
	
	private ServiceType callType;

//	@Autowired
	private  ISecurityService securityService;

	
	
	
	/**
	 * This method will get a Service specific configuration file containing http conduit related details.
	 * @return String file path for the Client config file.
	 */
	@Override
	protected String getClientConfigFile() 
	{
		return this.securityServiceConfigFile;
	}
	
	/**
	 * This method will get a Service specific properties file containing connection properties.
	 * @return Properties properties file containing service specific connection details.
	 */
	@Override
	protected Properties getProperties() 
	{
        return securityServiceProperties;
	}
	
	/**
	 * This method will get a Service call type meaning whether its local, REST or Mock.
	 * @return ServiceType Enumeration containing the call type.
	 */
	@Override
	protected ServiceType getCallType() 
	{
		return this.callType;
	}
	
	/**
	 * This method will construct and return a local pojo service.
	 * @return T instance of service object
	 */
	@Override
	protected ISecurityService getLocalService()
	{
        return this.securityService;

	}
	
	/**
	 * This method will construct and return a mock service.
	 * @return T instance of service object
	 */
	@Override
	protected ISecurityService getMockService()
	{
		return new SecurityServiceStub();
	}

	public Properties getSecurityServiceProperties() {
		return securityServiceProperties;
	}

	public void setSecurityServiceProperties(Properties securityServiceProperties) {
		this.securityServiceProperties = securityServiceProperties;
	}

	public String getSecurityServiceConfigFile() {
		return securityServiceConfigFile;
	}

	public void setSecurityServiceConfigFile(String securityServiceConfigFile) {
		this.securityServiceConfigFile = securityServiceConfigFile;
	}

	public ISecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(ISecurityService securityService) {
		this.securityService = securityService;
	}

	public void setCallType(ServiceType callType) {
		this.callType = callType;
	}

	public GetUserbyUsernamePasswordResponse getUserbyUsernamePasword(String username, String password) {
		// TODO Auto-generated method stub
		return getService().getUserbyUsernamePasword(username, password);
	}

	public GetUserbyEmailResponse getUserbyEmailId(String emailid) {
		// TODO Auto-generated method stub
		return getService().getUserbyEmailId(emailid);
	}


}
