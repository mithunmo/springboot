package com.f9g4.common.propertyfileloader;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;

public class PropertiesUtils {

	private static final String PER_ENVIRONMENT_CONFIG_DIRECTORY_SERVLET_INIT_PARAM_KEY = 
		"PerEnvironmentConfigDirectory";

	public static final String PROPERTIES_FILE_KEY = "user.name";

	public static final String DEFAULT_PROPERTIES_DIRECTORY = "/WEB-INF/properties";
	
	private static final int STRING_BUFF_SIZE = 100;


	/**
	 * Searches for a properties file first by hostname, second by username, and
	 * defaulting to default.properties if not found.
	 * 
	 * @param context -
	 *            The ServletContext of the application.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void loadUserProperties(ServletContext context)
	{

		File propertiesFile = findHostPropertiesFile(context);
		if (propertiesFile == null || propertiesFile.length() == 0) {
			propertiesFile = findUserPropertiesFile(context);
		}

		if (propertiesFile != null) {
		//PropertiesUtils - pulling properties from the properties file
			try{
				setSystemProperties(propertiesFile);
			}catch(FileNotFoundException fnfe){
				throw new PropertiesLoaderException(fnfe);
			}catch(IOException ioe){
				throw new PropertiesLoaderException(ioe);
			}
		}
	}

	public static File findHostPropertiesFile(ServletContext context) {

		File result = null;
		StringBuffer hostPropertiesBuff = new StringBuffer(STRING_BUFF_SIZE);
		
		try {
			InetAddress host = InetAddress.getLocalHost();
			if (host != null) {
								
				String directory = context.getInitParameter(
						PER_ENVIRONMENT_CONFIG_DIRECTORY_SERVLET_INIT_PARAM_KEY);
				
				if ((directory == null) || (directory.trim().length() == 0))
				{
					directory = DEFAULT_PROPERTIES_DIRECTORY;
				}

								
				hostPropertiesBuff.append(directory);
				hostPropertiesBuff.append("/");
				hostPropertiesBuff.append(host.getHostName());
				hostPropertiesBuff.append(".properties");
				
				String hostProperties = context
						.getRealPath(hostPropertiesBuff.toString());

				result = getFile(hostProperties);
			}
		} catch (UnknownHostException e) {
			throw new PropertiesLoaderException(new StringBuffer("PropertiesUtils.findHostPropertiesFile() Problem ").append(e).toString());
		}
		return result;
	}

	/**
	 * @param result
	 * @param filePath
	 * @return
	 */
	private static File getFile(String filePath) {
		File result = new File(filePath);
		
		if (!result.exists()) {
			result = null;
		}
		
		return result;
	}

	public static File findUserPropertiesFile(ServletContext context) {

		String userName = System.getProperty(PROPERTIES_FILE_KEY);
		
		StringBuffer userPropertiesBuff = new StringBuffer(STRING_BUFF_SIZE);
		
		userPropertiesBuff.append(DEFAULT_PROPERTIES_DIRECTORY);
		userPropertiesBuff.append("/");
		userPropertiesBuff.append(userName);
		userPropertiesBuff.append(".properties");
		
		String userProperties = context.getRealPath(userPropertiesBuff.toString());

		File result = getFile(userProperties);
		
		if (result == null)
		{
			StringBuffer defaultPropertiesBuff = new StringBuffer(STRING_BUFF_SIZE);
			
			defaultPropertiesBuff.append(DEFAULT_PROPERTIES_DIRECTORY);
			defaultPropertiesBuff.append("/default.properties");
			
			String defaultProperties = context.getRealPath(defaultPropertiesBuff.toString());
			
			result = getFile(defaultProperties);
		}

		return result;
	}

	public static void setSystemProperties(File propertiesFile)
			throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		FileInputStream fis = new FileInputStream(propertiesFile);
		try
		{
			properties.load(fis);

			for (Enumeration<?> enumeration = properties.keys(); enumeration
					.hasMoreElements();) {
				String key = (String) enumeration.nextElement();
				String val = properties.getProperty(key);
									
				System.setProperty(key, val);
				
			}			
		}
		finally
		{
			if (fis != null)
			{
				fis.close();
			}
		}

	}
}
