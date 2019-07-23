package com.webdriver.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties implements IReader {

	private Properties properties;
	
	private void initPropertiesFile(String fileName)
	{
		if(isDefaultPropertiesFile(fileName))
		{
			properties=getDataFromProperties("config.properties");   //Read from default properties file 
		}
		else {
			properties=getDataFromProperties(fileName); //Read from file provided by user
			
		}
			
	}
	
	public ReadConfigProperties()
	{
		initPropertiesFile("");
	}
	
	public ReadConfigProperties(String fileName )
	{
		initPropertiesFile(fileName);
	}
	
	private Properties getDataFromProperties(String fileName )
	{
		String path=ResourceUtils.getResourcePath(fileName);
		Properties prop=new Properties();
		
		try {
			InputStream stream=new FileInputStream(new File(path));
			prop.load(stream);
			
		}
		catch(IOException e){
			throw new RuntimeException(e.getMessage());			
		}
		return prop;
	}
	
	private boolean isDefaultPropertiesFile(String fileName)
	{
		if("".equalsIgnoreCase(fileName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public String getApplicationUrl() {
		return properties.getProperty("ApplicationUrl");
		
	}

	public String getUserName() {
		return properties.getProperty("Username");
	}

	public String getPassword() {
		return properties.getProperty("Password");
		
	}

	public int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("ExplicitWait"));
		
	}

	public String getBrowserType() {
		return properties.getProperty("BrowserName");
	}

}
