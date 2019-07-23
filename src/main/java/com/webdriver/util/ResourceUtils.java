package com.webdriver.util;

public class ResourceUtils {
	
	//path based on resource name
	public static String getResourcePath(String resourceName)
	{
		String path=getBasePath()+resourceName;
		return path;
	}
	
	public static String getBasePath()
	{
		String path=ResourceUtils.class.getClassLoader().getResource(".").getPath();		
		return path;
	}

}
