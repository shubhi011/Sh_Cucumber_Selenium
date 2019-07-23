package com.webdriver.classloader;

import java.net.URL;

//classloader is for getting the absolute path of resources like driver executables
public class AbsolutePath {

	public static void main(String[] args) {
		/*
		 * get the class using the class 
		 * get the class loader using class loader get the
		 * resource path
		 */
		Class cls = AbsolutePath.class; // These api are coming from java framework
		ClassLoader loader = cls.getClassLoader();
		URL url = loader.getResource("./chromedriver.exe");    //  ". " represents current working directory 
        System.out.println(url.toString());                    //chromeedriver gets automatically copied from source to target
	}

}
