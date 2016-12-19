package com.f9g4.common.propertyfileloader;

import java.io.File;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JVMPropertyConfigListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JVMPropertyConfigListener.class);

	private final static String DEFAULT_PROPS_FILENAME = "default.properties";

	private FileSystemPropertyFileLoader propertyLoader;

	public JVMPropertyConfigListener() {
		propertyLoader = new FileSystemPropertyFileLoader();
	}

	public void contextInitialized(ServletContextEvent event) {
		// confirm we have an app name set
		String appName = event.getServletContext().getInitParameter(
				FileSystemPropertyFileLoader.F4G_APPNAME_KEY);
		if (appName == null) {
			throw new PropertiesLoaderException(
					"context-param: "
							+ FileSystemPropertyFileLoader.F4G_APPNAME_KEY
							+ " representing application name is not set.  Please correct and try again.");
		}

		// get root directory for property files
		File propRootFolder = propertyLoader.getPropRootAppFolder(appName);

		// Get Default Properties
		Properties defaultProps = new Properties();
		File defaultPropsFile = new File(propRootFolder, DEFAULT_PROPS_FILENAME);
		if (defaultPropsFile.exists()) {
			defaultProps = propertyLoader.readProperties(defaultPropsFile);
			if (defaultProps.getProperty("ct.log4j.file.name") != null) {
				LOGGER.info("External Log4J file found. ");
				DOMConfigurator.configure(propRootFolder.getPath() + "/"
						+ defaultProps.getProperty("ct.log4j.file.name"));
			}
		}

		Properties mergedProps = propertyLoader.mergeCtJvmProperties(
				defaultProps, System.getProperties());
		propertyLoader.configureSystemProperties(mergedProps);
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

}
