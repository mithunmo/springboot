package com.f9g4.service.sdk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSPasswordCallback;
import org.apache.ws.security.handler.WSHandlerConstants;

/**
 * This factory is an abstraction for creating a port (client) object within a concrete web service
 * SDK. Each concrete subclass uses the facilities provided here to configure the port (client)
 * object to add WS Security headers to each outgoing SOAP request.
 * 
 * @author rglove5
 *
 * @param <P> "Port" type. The instance class should be a wsdl2java-generated interface
 * 				representing the web service itself. This is the return type of the
 * 				{@link #getPort()} method and of the abstract {@link #buildPort(URL)} method.
 * 				The port (client) object acts as a complete client interface to the web service.
 */
public abstract class AbstractSecureServiceFactory <P> {

	private final String username;
	private final String password;
	private P port;
	
	// Configure this in your Spring applicationConfig.xml
	// If true, then the appropriate service stub is used
	// Default == false (uses Soap call to get remote interface).
	private boolean mockPort;
	
	// Configure this in your Spring applicationConfig.xml
	// If true, then security is turned on
	// Default == true
	private boolean securityEnabled = true;

	/**
	 * No-argument constructor assumes "no security enabled".
	 */
	public AbstractSecureServiceFactory() {
		this.username = "";
		this.password = "";
		this.securityEnabled = false;
	}

	/**
	 * Username/password constructor sets username and password values and assumes "security enabled".
	 * @param username username for security check
	 * @param password password for security check
	 */
	public AbstractSecureServiceFactory(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Port constructor sets up a mock/stub port to use instead of building a port from WSDL.
	 * @param port the mock/stub port to use
	 */
	public AbstractSecureServiceFactory(P port) {
		this.username = "";
		this.password = "";
		this.port = port;
	}

	private void addUserNameToken(Object port) {
		
		Client client = ClientProxy.getClient(port);
		
		configurePolicy(client);
		
    	if (isSecurityEnabled()) {
			configureSecurity(client);
		}
	}

	/**
	 * @param client
	 */
	private void configureSecurity(Client client) {
		Endpoint cxfEndpoint = client.getEndpoint();

    	Map<String, Object> props = new HashMap<String,Object>();
    	WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
    	
    	cxfEndpoint.getOutInterceptors().add(wssOut);
    	cxfEndpoint.getOutInterceptors().add(new SAAJOutInterceptor());

    	props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
    	props.put(WSHandlerConstants.USER, username);
    	props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
    	
    	
    	props.put(WSHandlerConstants.PW_CALLBACK_REF, 
    				new CallbackHandler() {
						public void handle(Callback[] callbacks) throws IOException,
								UnsupportedCallbackException {
							WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
							pc.setPassword(password);
					}
		});
	}

	/**
	 * This method returns the configured port (client) object. It creates the port if the port does
	 * not already exist.
	 * 
	 * @return the WS-security-configured port (client) object
	 * @throws MalformedURLException if the WSDL URL given is ill-formed.
	 */
	public P getPort() throws MalformedURLException {
		
		if (port == null) {
			URL wsdlURL = getWsdlURL();
			port = buildPort(wsdlURL);
			
			if(!isMockPort()) {
				this.addUserNameToken(port);
			}
		}
		
		return port;
	}
 
	/**
	 * @param client
	 */
	private void configurePolicy(Client client) {
		Conduit c = client.getConduit();
		if (c instanceof HTTPConduit) {
			HTTPConduit conduit = (HTTPConduit) c;
			HTTPClientPolicy clientPolicy = new HTTPClientPolicy();
			//clientPolicy.setConnectionTimeout(0);
			clientPolicy.setMaxRetransmits(1);
			clientPolicy.setAllowChunking(false);
			clientPolicy.setConnection(ConnectionType.CLOSE);
			conduit.setClient(clientPolicy);
		}
	}

	/**
	 * Gets the WSDL URL from the concrete factory.
	 * @return the WSDL URL for the web service
	 * @throws MalformedURLException if the WSDL URL given is ill-formed.
	 */
	protected abstract URL getWsdlURL() throws MalformedURLException;
	
	/**
	 * Gets the raw (not yet configured for security) port (client) object from the concrete
	 * factory.
	 * 
	 * @param wsdlURL the WSDL URL for the web service
	 * @return the raw port (client) object
	 */
	protected abstract P buildPort(URL wsdlURL);

	public boolean isMockPort() {
		return mockPort;
	}

	/**
	 * Configure this in your Spring applicationConfig.xml .
	 * @param mockPort If true, then the appropriate service stub is used. Default == false
	 * (uses Soap call to get remote interface).
	 */
	public void setMockPort(boolean mockPort) {
		this.mockPort = mockPort;
	}

	/**
	 * Configure this in your Spring applicationConfig.xml . 
	 * @param securityEnabled If true, then security is turned on. Default == true
	 */
	public void setSecurityEnabled(boolean securityEnabled) {
		this.securityEnabled = securityEnabled;
	}

	public boolean isSecurityEnabled() {
		return securityEnabled;
	}
}
