package com.floridapublicnotices.testcases;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.floridapublicnotices.commonUtils.*;
import com.floridapublicnotices.pages.CheckAdd;

@SuppressWarnings("unused")
public class SearchAdds {
	
	CheckAdd add = new CheckAdd();
	
	@Test (priority = 1)
	public void Check_Add_ByDate() throws IOException, InterruptedException {
		add.SearchByDate();
	}
	
	@Test (priority = 2)
	public void Check_Add_ByPublication() throws IOException, InterruptedException {
		add.SearchByPublication();
	}
	
	@Test (priority = 3)
	public void Check_Add_Miami() throws IOException, InterruptedException {
		add.SearchByAddNum_Miami();
	}
	
	@Test (priority = 4)
	public void Check_Add_Palm() throws IOException, InterruptedException {
		add.SearchByAddNum_Palm();
	}
	
	@Test (priority = 5)
	public void Check_Add_Broward() throws IOException, InterruptedException {
		add.SearchByAddNum_Broward();
	}

}
