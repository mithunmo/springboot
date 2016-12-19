package com.f9g4.common.propertyfileloader;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *     
 *  Steps to add new Hostname Property Loader
 *  
 *  1.	Checkout F4GExternalProperties project into your workspace
 *  
 *  2.	Make sure F4GCommon is in WebApp pom dependency (directly or transitively)
 *  If not, add the dependency:
 *  3.	Replace current property file listener in web.xml with:
 *  
 *  <context-param>		
 *    <param-name>f4g.properties.app.name</param-name>
 *    <param-value>CTUIWebApp</param-value>	
 *  </context-param>
 *  
 *  <listener>
 *    <listener-class>com.f4g.common.propertyfileloader.HostnamePropertyConfigListener</listener-class>
 *  </listener>
 *  
 *  4.  Create application folder name in F4GExternalProperties project
 *
 *        -	Create app folder in FRGExternalProperties\src\main\resources folder (named in property above- in this example OPServices)
 *        -	Copy existing property files from WebApp WEB-INF\properties folder into new folder in step above
 *        -	Remove properties folder from WebApp WEB-INF folder
 *  
 *  5.	Add log4j.xml file in webapp project
 *  
 *  <logger name="com.f4g.portal.propertyfileloader">
 *    <level value="info" />
 *    <appender-ref ref="default" />
 *  </logger>
 *  
 *  6.	Add java system property to jetty startup in the VM args area
 *  -Dct.portal.properties.dir=C:/data/eclipse/v3.5/workspaces/Test1/CTExternalProperties/src/main/resources
 *  
 *  7.	Start Web App in jetty to test
 *       
 *      
 * </pre>
 */

public class HostnamePropertyConfigListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(HostnamePropertyConfigListener.class);

    private final static String DEFAULT_HOSTNAME_PROPS_FILENAME = "default.properties";
	
    private FileSystemPropertyFileLoader propertyLoader;
    
    public HostnamePropertyConfigListener()
    {
    	propertyLoader = new FileSystemPropertyFileLoader();
    }
    
/*    private void dumpSystemProperties()
    {
    	LOGGER.info("---------------System Properties------------");
    	Properties props = System.getProperties();
		for (Object key : props.keySet()) 
    	{
    		String val = props.getProperty(key.toString());
			LOGGER.info("Initial system property: " + key + "=" + val);
    	}
    	LOGGER.info("-----------------------------------\n\n");
    }
*/    
	public void contextInitialized(ServletContextEvent event) {
		// confirm we have an app name set
		String appName = event.getServletContext().getInitParameter(FileSystemPropertyFileLoader.F4G_APPNAME_KEY);
		if ( appName == null )
		{
			throw new PropertiesLoaderException("context-param: " + FileSystemPropertyFileLoader.F4G_APPNAME_KEY + " representing application name is not set.  Please correct and try again.");	
		}
		
		// get root directory for property files
		File propRootFolder = propertyLoader.getPropRootAppFolder(appName);
		
		// Get Default Properties
		Properties defaultProps = new Properties();
		File defaultPropsFile = new File(propRootFolder, DEFAULT_HOSTNAME_PROPS_FILENAME);
		if ( defaultPropsFile.exists() )
		{
			defaultProps = propertyLoader.readProperties(defaultPropsFile);
		}
		
		// get hostname properties
		String propsFilename = findHostPropertiesFile();
		File propsFile = new File(propRootFolder, propsFilename);
		
		Properties hostProps = new Properties();
		if ( propsFile.exists() )
		{
			hostProps = propertyLoader.readProperties(propsFile);
		}
		
		Properties mergedProps = propertyLoader.mergeProperties(defaultProps, hostProps);
		propertyLoader.configureSystemProperties(mergedProps);
	}

	public void contextDestroyed(ServletContextEvent event) {
	}
	
	
	
	public String findHostPropertiesFile() {

		String hostPropFile = null;
		try {
			InetAddress host = InetAddress.getLocalHost();
			if (host != null) {
				hostPropFile = host.getHostName() + ".properties";
			}
		} catch (UnknownHostException e) {
			LOGGER.error("HostnamePropertyConfigListener.findHostPropertiesFile() problem" , e);
			throw new PropertiesLoaderException(new StringBuffer("HostnamePropertyConfigListener.findHostPropertiesFile() Problem ").append(e).toString());
		}
		return hostPropFile;
	}
	
}
