package com.floridapublicnotices.commonUtils;

import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static ChromeDriver driver;
	
	
	public static ChromeDriver LaunchBrowser() throws IOException, InterruptedException {
		
		if(BrowserFactory.driver==null) {
			System.setProperty("webdriver.chrome.driver", ReadConfig.getValue("driverPath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(ReadConfig.getValue("url"));
		}
		return driver;
	}

}
