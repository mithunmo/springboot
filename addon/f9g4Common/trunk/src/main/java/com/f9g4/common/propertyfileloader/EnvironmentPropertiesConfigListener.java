package com.f9g4.common.propertyfileloader;

import java.io.File;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.xml.DOMConfigurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This listener is used to read in an environment specific properties file and
 * set system variables from it.
 * 
 * The value of the system property "f4g.env" must be
 * defined on the server
 * 
 */
public class EnvironmentPropertiesConfigListener implements
		ServletContextListener {

	private static final  Logger LOGGER = LoggerFactory.getLogger(EnvironmentPropertiesConfigListener.class);

	private final static String F4G_ENVIRONMENT = "f4g.env";

	private final static String DEFAULT_ENVIRONMENT_PROPS_FILENAME = "default.properties";

	private FileSystemPropertyFileLoader propertyLoader;

	public EnvironmentPropertiesConfigListener() {
		propertyLoader = new FileSystemPropertyFileLoader();
	}

	public void contextInitialized(ServletContextEvent event) {

		// confirm we have an app name set and that it is not an empty string
		String appName = event.getServletContext().getInitParameter(
				FileSystemPropertyFileLoader.F4G_APPNAME_KEY);
		if (StringUtils.isBlank(appName)) {
			throw new PropertiesLoaderException(
					"context-param: "
							+ FileSystemPropertyFileLoader.F4G_APPNAME_KEY
							+ " representing application name is not set.  Please correct and try again.");
		}

		// get root directory for property files
		File propRootFolder = propertyLoader.getPropRootAppFolder(appName);

		// Get Default Properties
		Properties defaultProps = new Properties();
		File defaultPropsFile = new File(propRootFolder,
				DEFAULT_ENVIRONMENT_PROPS_FILENAME);
		if (defaultPropsFile.exists()) {
			defaultProps = propertyLoader.readProperties(defaultPropsFile);
			if (defaultProps.getProperty("ct.log4j.file.name") != null) {
				LOGGER.info("External Log4J file found. ");
				DOMConfigurator.configure(propRootFolder.getPath() + "/"
						+ defaultProps.getProperty("ct.log4j.file.name"));
			}
		}
		
		// get hostname properties
		String propsFilename = findEnvironmentPropertiesFile();
		Properties hostProps = new Properties();
		if (propsFilename != null) {
			File propsFile = new File(propRootFolder, propsFilename);
			if (propsFile.exists()) {
				hostProps = propertyLoader.readProperties(propsFile);
				if (hostProps.getProperty("ct.log4j.file.name") != null) {
					LOGGER.info("External Log4J file found for env. ");
					DOMConfigurator.configure(propRootFolder.getPath() + "/"
							+ hostProps.getProperty("ct.log4j.file.name"));
				}
			} else {
				LOGGER.warn("Environment property file not found...");
			}
		}

		Properties mergedProps = propertyLoader.mergeProperties(defaultProps,
				hostProps);
		propertyLoader.configureSystemPropertiesUI(mergedProps);
	}

	public void contextDestroyed(ServletContextEvent event) {
		// Do nothing
	}

	public String findEnvironmentPropertiesFile() {

		String envPropFile = null;
		String env = System.getProperty(F4G_ENVIRONMENT);
		if (env != null) {
			envPropFile = env + ".properties";
		}
		return envPropFile;
	}

}
