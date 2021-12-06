package com.floridapublicnotices.commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static String getValue(String path) throws IOException {
		
		 FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
		 
		 Properties prop = new Properties();
		 prop.load(fis);
		 
		 return prop.getProperty(path);
	 }

}
