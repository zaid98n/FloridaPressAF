package com.floridapublicnotices.commonUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;

public class Screenshot {
	
	public static void capture(WebDriver driver,String screenshotName) {
	 
	try 
		{
			TakesScreenshot ts = (TakesScreenshot)BrowserFactory.LaunchBrowser();
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("D:\\Florida Press Report\\ScreenShots\\"+screenshotName+".png"));
			//System.out.println("Screenshot taken");
		} 
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
	}
	
	
	public static void takeScreenShot(String methodname) throws IOException, InterruptedException { 
		
		Date currentdate = new Date();
		String fname = currentdate.toString().replace(" ","_").replace(":","-");
		Actions build = new Actions(BrowserFactory.LaunchBrowser());
		
		capture(BrowserFactory.LaunchBrowser(), (methodname+"_"+"1"+fname));
		Thread.sleep(500);
		
		build.sendKeys(Keys.END).build().perform();
		Thread.sleep(500);
		capture(BrowserFactory.LaunchBrowser(), (methodname+"_"+"2"+fname));
		Thread.sleep(200);
		
		build.sendKeys(Keys.HOME).build().perform();
		Thread.sleep(500);
	}
}
