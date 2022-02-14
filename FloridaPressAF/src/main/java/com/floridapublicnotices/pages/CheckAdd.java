package com.floridapublicnotices.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.floridapublicnotices.commonUtils.*;
 
public class CheckAdd {
	
	
	public void SearchByDate() throws IOException, InterruptedException{
		
		BrowserFactory.LaunchBrowser().manage().timeouts().implicitlyWait(Long.parseLong(ReadConfig.getValue("implicitwait")), TimeUnit.SECONDS);	
		
		Date currentdate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(currentdate);
		//String fname = currentdate.toString().replace(" ","_").replace(":","-");
		DataWriter.write(" "+"\n");
		DataWriter.write(" "+"\n");
		DataWriter.write("============================================================="+"\n");
		DataWriter.write("=============== || Reported on: "+strDate+" || ==============="+"\n");
		DataWriter.write("============================================================="+"\n");
		
		WebElement Date_1 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/div/div/input");
		WebElement Date_2 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[2]/div/div/div/div/div/div/div/input");
		
		String data_date = DataFile.CellData(1, 0);
		
		Actions build = new Actions(BrowserFactory.LaunchBrowser());
		
		try {
			Date_1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Date_1.sendKeys(Keys.DELETE);
			Thread.sleep(500);
			Date_1.sendKeys(data_date);
			Thread.sleep(200);
			Date_2.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Date_2.sendKeys(Keys.DELETE);
			Thread.sleep(500);
			Date_2.sendKeys(data_date);
			Thread.sleep(300);
			
			build.sendKeys(Keys.END).build().perform();
			Thread.sleep(500);
			BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[2]/button").click();
			Thread.sleep(3000);		
		}
		catch (Exception e) {
			System.out.println("Operation failed"+e.getMessage());
		}
		
		WebElement count = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[1]");
		String AddCount = count.getText();
		
		DataWriter.write(" "+"\n");
		DataWriter.write("For date "+data_date+" : "+AddCount+"\n");
		
		Screenshot.takeScreenShot("SearchByDate");
		
	}
	
	public void SearchByPublication() throws IOException, InterruptedException{
		
		BrowserFactory.LaunchBrowser().manage().timeouts().implicitlyWait(Long.parseLong(ReadConfig.getValue("implicitwait")), TimeUnit.SECONDS);
		
		Actions build = new Actions(BrowserFactory.LaunchBrowser());
		
		build.sendKeys(Keys.END).build().perform();
		Thread.sleep(400);
		BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[1]/button").click();
		Thread.sleep(1000);
		build.sendKeys(Keys.HOME).build().perform();
		
		WebElement Date_1 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/div/div/input");
		WebElement Date_2 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[2]/div/div/div/div/div/div/div/input");
		WebElement pub = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div/input");
		
		String data_date = DataFile.CellData(1, 0);
		String[] data_publication = {DataFile.CellData(1, 1), DataFile.CellData(2, 1), DataFile.CellData(3, 1)};
		
		DataWriter.write(" "+"\n");
		DataWriter.write("Data for publication: "+"\n");
		DataWriter.write(" "+"\n");
		for(int i = 0; i<data_publication.length; i++) {
			
			try {
				Date_1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_1.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_1.sendKeys(data_date);
				Thread.sleep(200);
				Date_2.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_2.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_2.sendKeys(data_date);
				Thread.sleep(300);
				
				build.sendKeys(Keys.END).build().perform();
				
				Thread.sleep(400);
				pub.click();
				Thread.sleep(500);
				pub.sendKeys(Keys.DELETE);
				Thread.sleep(1000);
				pub.sendKeys(data_publication[i]);
				Thread.sleep(1300);
				build.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(700);
				BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[1]/div").click();
				Thread.sleep(300);
				build.sendKeys(Keys.END).build().perform();
				Thread.sleep(500);
				WebElement button =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[2]/button");
				JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.LaunchBrowser();
				executor.executeScript("arguments[0].click();", button);
				Thread.sleep(3000);
			}
			catch (Exception e) {
				System.out.println("Operation failed"+e.getMessage()+data_publication[i]);
			}
			
			WebElement count = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[1]");	
			String AddCount = count.getText();
			
			DataWriter.write("   "+data_publication[i]+" : "+AddCount+"\n");
			
			Screenshot.takeScreenShot("SearchByPublication");
		}
		
	}
	
	public void SearchByAddNum_Miami() throws IOException, InterruptedException{
		
		BrowserFactory.LaunchBrowser().manage().timeouts().implicitlyWait(Long.parseLong(ReadConfig.getValue("implicitwait")), TimeUnit.SECONDS);
		
		Actions build = new Actions(BrowserFactory.LaunchBrowser());
		
		build.sendKeys(Keys.END).build().perform();
		Thread.sleep(300);
		BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[1]/button").click();
		Thread.sleep(1000);
		build.sendKeys(Keys.HOME).build().perform();
		
		WebElement Date_1 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/div/div/input");
		WebElement Date_2 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[2]/div/div/div/div/div/div/div/input");
		WebElement pub = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div/input");
		WebElement sbar = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[2]/div[2]/input");
		
		String data_date = DataFile.CellData(1, 0);
		String data_publication_M = DataFile.CellData(1, 1);

		String[] data_addnumforM = {DataFile.CellData(11, 2), DataFile.CellData(12, 2), DataFile.CellData(13, 2), DataFile.CellData(14, 2)};
		
		DataWriter.write(" "+"\n");
		DataWriter.write("a. Miami DBR"+"\n");
		DataWriter.write(" "+"\n");
		
		for(int i = 0; i<data_addnumforM.length; i++) {
			try {
				Date_1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_1.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_1.sendKeys(data_date);
				Thread.sleep(200);
				Date_2.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_2.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_2.sendKeys(data_date);
				Thread.sleep(300);
				
				build.sendKeys(Keys.END).build().perform();
				
				Thread.sleep(300);
				pub.click();
				Thread.sleep(500);
				pub.sendKeys(Keys.DELETE);
				Thread.sleep(1000);
				pub.sendKeys(data_publication_M);
				Thread.sleep(500);
				build.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(500);
				BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[1]/div").click();
				Thread.sleep(300);
				
				build.sendKeys(Keys.HOME).build().perform();
				Thread.sleep(200);
				sbar.clear();
				sbar.sendKeys(data_addnumforM[i]);
				Thread.sleep(500);
				
				build.sendKeys(Keys.END).build().perform();
				Thread.sleep(500);
				BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[2]/button").click();
				Thread.sleep(3000);
				
				try {
					WebElement loadbutton = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[2]/div[3]/button");
					loadbutton.isDisplayed();
					Thread.sleep(1000);
					loadbutton.click();
					Thread.sleep(1000);
					WebElement count = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[1]");	
					String AddCount = count.getText();
					
					DataWriter.write("   "+data_addnumforM[i]+" : "+AddCount+"\n");	
					
					Screenshot.takeScreenShot("SearchByAddNum_Miami");
				}
				catch (Exception e) {					
					DataWriter.write("   "+data_addnumforM[i]+" : No Record Found"+"\n");
					
					Screenshot.takeScreenShot("SearchByAddNum_Miami");
				}
			}
			catch (Exception e) {
				System.out.println("Operation failed"+e.getMessage()+data_addnumforM[i]);
			}
		}
	}
	
	public void SearchByAddNum_Palm() throws IOException, InterruptedException{
		
		BrowserFactory.LaunchBrowser().manage().timeouts().implicitlyWait(Long.parseLong(ReadConfig.getValue("implicitwait")), TimeUnit.SECONDS);
		
		Actions build = new Actions(BrowserFactory.LaunchBrowser());
		
		build.sendKeys(Keys.END).build().perform();
		Thread.sleep(300);
		BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[1]/button").click();
		Thread.sleep(1000);
		build.sendKeys(Keys.HOME).build().perform();
		
		WebElement Date_1 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/div/div/input");
		WebElement Date_2 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[2]/div/div/div/div/div/div/div/input");
		WebElement pub = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div/input");
		WebElement sbar = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[2]/div[2]/input");
		
		String data_date = DataFile.CellData(1, 0);
		String data_publication_P = DataFile.CellData(2, 1);
		
		String[] data_addnumforP = {DataFile.CellData(1, 2), DataFile.CellData(2, 2), DataFile.CellData(3, 2)};
		
		DataWriter.write(" "+"\n");
		DataWriter.write("b. Palm Beach DBR"+"\n");
		DataWriter.write(" "+"\n");
		
		for(int i = 0; i<data_addnumforP.length; i++) {
			try {
				Date_1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_1.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_1.sendKeys(data_date);
				Thread.sleep(200);
				Date_2.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_2.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_2.sendKeys(data_date);
				Thread.sleep(300);
				
				build.sendKeys(Keys.END).build().perform();
				
				Thread.sleep(300);
				pub.click();
				Thread.sleep(500);
				pub.sendKeys(Keys.DELETE);
				Thread.sleep(1000);
				pub.sendKeys(data_publication_P);
				Thread.sleep(500);
				build.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(500);
				BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[1]/div").click();
				Thread.sleep(300);
				
				build.sendKeys(Keys.HOME).build().perform();
				Thread.sleep(200);
				sbar.clear();
				sbar.sendKeys(data_addnumforP[i]);
				Thread.sleep(500);
				
				build.sendKeys(Keys.END).build().perform();
				Thread.sleep(500);
				BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[2]/button").click();
				Thread.sleep(3000);
				
				try {
					WebElement loadbutton = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[2]/div[3]/button");
					loadbutton.isDisplayed();
					Thread.sleep(1000);
					loadbutton.click();
					Thread.sleep(1000);
					WebElement count = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[1]");	
					String AddCount = count.getText();
					
					DataWriter.write("   "+data_addnumforP[i]+" : "+AddCount+"\n");	
					
					Screenshot.takeScreenShot("SearchByAddNum_Palm");
				}
				catch (Exception e) {
					
					DataWriter.write("   "+data_addnumforP[i]+" : No Record Found"+"\n");
					
					Screenshot.takeScreenShot("SearchByAddNum_Palm");
				}
			}
			catch (Exception e) {
				System.out.println("Operation failed"+e.getMessage()+data_addnumforP[i]);
			}
		}
	}
	
	public void SearchByAddNum_Broward() throws IOException, InterruptedException{
		
		BrowserFactory.LaunchBrowser().manage().timeouts().implicitlyWait(Long.parseLong(ReadConfig.getValue("implicitwait")), TimeUnit.SECONDS);
		
		Actions build = new Actions(BrowserFactory.LaunchBrowser());
		
		build.sendKeys(Keys.END).build().perform();
		Thread.sleep(300);
		BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[1]/button").click();
		Thread.sleep(1000);
		build.sendKeys(Keys.HOME).build().perform();
		
		WebElement Date_1 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/div/div/input");
		WebElement Date_2 =  BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div[2]/div/div/div/div/div/div/div/input");
		WebElement pub = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[2]/div/div/div/div[1]/div[2]/div/input");
		WebElement sbar = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[2]/div[2]/input");
		
		String data_date = DataFile.CellData(1, 0);
		String data_publication_B = DataFile.CellData(3, 1);

		String[] data_addnumforB = {DataFile.CellData(6, 2), DataFile.CellData(7, 2), DataFile.CellData(8, 2)};
		
		DataWriter.write(" "+"\n");
		DataWriter.write("c. Broward DBR"+"\n");
		DataWriter.write(" "+"\n");
		
		for(int i = 0; i<data_addnumforB.length; i++) {
			try {
				Date_1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_1.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_1.sendKeys(data_date);
				Thread.sleep(200);
				Date_2.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Date_2.sendKeys(Keys.DELETE);
				Thread.sleep(500);
				Date_2.sendKeys(data_date);
				Thread.sleep(300);
				
				build.sendKeys(Keys.END).build().perform();
				
				Thread.sleep(300);
				pub.click();
				Thread.sleep(500);
				pub.sendKeys(Keys.DELETE);
				Thread.sleep(1000);
				pub.sendKeys(data_publication_B);
				Thread.sleep(500);
				build.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(500);
				BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[5]/div[1]/div").click();
				Thread.sleep(300);
				
				build.sendKeys(Keys.HOME).build().perform();
				Thread.sleep(200);
				sbar.clear();
				sbar.sendKeys(data_addnumforB[i]);
				Thread.sleep(500);
				
				build.sendKeys(Keys.END).build().perform();
				Thread.sleep(500);
				BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[7]/span[2]/button").click();
				Thread.sleep(3000);
				
				try {
					WebElement loadbutton = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[2]/div[3]/button");
					loadbutton.isDisplayed();
					Thread.sleep(1000);
					loadbutton.click();
					Thread.sleep(1000);
					WebElement count = BrowserFactory.LaunchBrowser().findElementByXPath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div[4]/div[1]");	
					String AddCount = count.getText();
					
					DataWriter.write("   "+data_addnumforB[i]+" : "+AddCount+"\n");	
					
					Screenshot.takeScreenShot("SearchByAddNum_Broward");
				}
				catch (Exception e) {					
					DataWriter.write("   "+data_addnumforB[i]+" : No Record Found"+"\n");
					
					Screenshot.takeScreenShot("SearchByAddNum_Broward");
				}
			}
			catch (Exception e) {
				System.out.println("Operation failed"+e.getMessage()+data_addnumforB[i]);
			}
		}
	}
	
}
