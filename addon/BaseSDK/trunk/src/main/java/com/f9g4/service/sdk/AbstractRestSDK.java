package com.f9g4.service.sdk;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Properties;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;

import com.f9g4.service.sdk.common.ServiceType;
/**
 * Common Manager class which is used by the SDKs to provide specific implementation. This class contains common behavior for all
 * the SDKs.
 */
public abstract class AbstractRestSDK<T> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method will get a Service specific configuration file containing http conduit related details.
	 * @return String file path for the Client config file.
	 */
	protected abstract String getClientConfigFile();
	
	/**
	 * This method will get a Service specific properties file containing connection properties.
	 * @return Properties properties file containing service specific connection details.
	 */
	protected abstract Properties getProperties();
	
	/**
	 * This method will get a Service call type meaning whether its local REST or Mock.
	 * @return ServiceType Enumeration containing the call type.
	 */
	protected abstract ServiceType getCallType();
	
	/**
	 * This method will construct an appropriate Service meaning Local/Mock/REST.
	 * 
	 * @return T instance of service object
	 */
	protected final T getService()
	{
		if (this.getCallType().equals(ServiceType.REST))
		{
			return  this.getRESTService();
		}
		else if (this.getCallType().equals(ServiceType.Local))
		{
			return this.getLocalService();
		}
		else
		{
			return this.getMockService();
		}
	}
	
	/**
	 * This method will construct and return a local pojo service.
	 * 
	 * @return T instance of service object
	 */
	protected abstract T getLocalService();
	
	/**
	 * This method will construct and return a mock service.
	 * 
	 * @return T instance of service object
	 */
	protected abstract T getMockService();
	
	/**
	 * This method will construct a REST Service and return the proxy implementation to the REST service.
	 * 
	 * @return T instance of service object
	 */
	@SuppressWarnings("unchecked")
	private final T getRESTService()
	{
		Properties prop = getProperties();
		JAXRSClientFactoryBean sf = new JAXRSClientFactoryBean();
		// get the Type argument provided.
		Type typeT = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		sf.setResourceClass((Class<T>)typeT);
		sf.setAddress(prop.getProperty("restURL"));
		BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
		JAXRSBindingFactory factory = new JAXRSBindingFactory();
		factory.setBus(sf.getBus());
		manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
		return JAXRSClientFactory.create(sf.getAddress(), (Class<T>)typeT, this.getClientConfigFile());
	}
	
}
