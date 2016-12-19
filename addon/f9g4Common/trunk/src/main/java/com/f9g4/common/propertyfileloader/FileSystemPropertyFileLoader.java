package com.f9g4.common.propertyfileloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class FileSystemPropertyFileLoader {

	/**
	 * This value is defined in the jvm for each environment.  It will be part of the setup steps for the environment.
	 */
    public final static String F4G_HOSTNAME_DIR_ENV_KEY = "f4g.properties.dir";
    
    /**
     * This value is defined in the Web App's web.xml file. The value will need to match the folder created in CTExternalProperties 
     * project's resources folder.  All the properties files for the web app will be loaded in that project and referenced.
     */
    public final static String F4G_APPNAME_KEY = "f4g.properties.app.name";
	
	private static final int STRING_BUFF_SIZE = 256;
	private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemPropertyFileLoader.class);

	/**
	 * Searches for a properties file first by hostname, second by username, and
	 * defaulting to default.properties if not found.
	 * 
	 * @param propFile -The ServletContext of the application.
	 * 
	 */
	public Properties readProperties(File propFile)
	{
		Properties properties = new Properties();
		LOGGER.info("Loading properties from " + propFile.toString());
		FileInputStream in = null;
		try {
			in = new FileInputStream(propFile);
			properties.load(in);
			if ( LOGGER.isInfoEnabled())
			{
				for (Enumeration<Object> enumeration = properties.keys(); enumeration
				.hasMoreElements();) {
					String key = (String) enumeration.nextElement();
					String value = properties.getProperty(key);
					LOGGER.info("Reading property: " + key + "=" + value);
				}
			}
		} catch (FileNotFoundException e) {
			throw new PropertiesLoaderException(propFile.toString() + " was not found", e);
		} catch (IOException e) {
			throw new PropertiesLoaderException("Can't load " + propFile.toString()
					+ " from filesystem", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return properties;
	}

	public Properties mergeProperties(Properties props1, Properties props2)
	{
		for (Object key : props2.keySet()) {
			String value = props2.getProperty(key.toString());
			String lookupValue = props1.getProperty(key.toString());
			if ( lookupValue == null )
			{
				LOGGER.info("Adding key: " + key + "=" + value);
			}
			else
			{
				LOGGER.warn("Replacing value for key: " + key + " new: " + value + " old: " + lookupValue); 
			}
			props1.put(key, value);
		}
		return props1;
	}
	
	public Properties mergeCtJvmProperties(Properties props1, Properties props2)
	{
		for (Object key : props2.keySet()) {
			if(StringUtils.startsWith(key.toString(), "ct.jvm")){
				String value = props2.getProperty(key.toString());
				String lookupValue = props1.getProperty(key.toString());
				if ( lookupValue == null )
				{
					LOGGER.info("Adding key: " + key + "=" + value);
				}
				else
				{
					LOGGER.warn("Replacing value for key: " + key + " new: " + value + " old: " + lookupValue); 
				}
				props1.put(key, value);
			}
		}
		return props1;
	}
	
	

	public void configureSystemProperties(Properties properties) {
		properties = new PropertyValueInterpolater(properties).interpolate();

		for (Object key : properties.keySet()) {
			Object value = properties.get(key);
			String SystemValue = System.getProperty(key.toString());
			if (SystemValue == null) {
				LOGGER.info("Setting system property: " + key + "=" + value);
			} else {
				LOGGER.warn("Replacing system value for property: " + key + " new:" + value + " old: " + SystemValue.toString());
			}
			System.setProperty((String) key, (String) value);
		}
	}

	public void configureSystemPropertiesUI(Properties properties) {
		properties = new PropertyValueInterpolater(properties).interpolate();

		for (Object key : properties.keySet()) {
			Object value = properties.get(key);
			String SystemValue = System.getProperty(key.toString());
			if (SystemValue == null) {
				LOGGER.info("Setting system property: " + key + "=" + value);
				System.setProperty((String) key, (String) value);
			} else {
				LOGGER.warn("Keeping system property value: " + key + " current:" + SystemValue.toString() + " not replaced value: " + value );
			}
		}
	}
	
	
	public File getPropRootAppFolder(String appName)
	{
		File propRootFolder = null;
		StringBuffer hostPropertiesBuff = new StringBuffer(STRING_BUFF_SIZE);
		
		try {
			InetAddress host = InetAddress.getLocalHost();
			if (host != null) {
				String directory = System.getProperty(F4G_HOSTNAME_DIR_ENV_KEY);
				if ( StringUtils.isBlank(directory) )
				{
					throw new PropertiesLoaderException("System property: " + F4G_HOSTNAME_DIR_ENV_KEY + " is not set.  Please correct and try again.");	
				}

				hostPropertiesBuff.append(directory);
				hostPropertiesBuff.append("/");
				hostPropertiesBuff.append(appName);
				String appPropFolder = hostPropertiesBuff.toString();
				propRootFolder = new File(appPropFolder);
				if ( !propRootFolder.exists() )
				{
					throw new PropertiesLoaderException("Application (" + appName + ") property folder: " + appPropFolder + " does not exist.  Please correct and try again."); 
				}
			}
		} catch (UnknownHostException e) {
			LOGGER.error("HostnamePropertyConfigListener.getPropRootAppFolder()- Application: " + appName , e);
			throw new PropertiesLoaderException(new StringBuffer("HostnamePropertyConfigListener.getPropRootAppFolder() Problem ").append(e).toString());
		}
		return propRootFolder;
		
	}
	
	
}
