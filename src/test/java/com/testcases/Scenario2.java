package com.testcases;
import com.utilities.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.SearchFunctionality;

@Listeners(CustumListners.class)
public class Scenario2 extends Base {
	
	@Test
	public static void productSearch() throws InterruptedException
	{
		
		SearchFunctionality sf=new SearchFunctionality(driver);
		Thread.sleep(5000);
		sf.clicksearchCatagory();
		
		sf.clicksearch();
		Thread.sleep(5000);
		
		sf.verifypageLoad();
		Thread.sleep(5000);
		
		sf.checkProduct();
		Thread.sleep(5000);
	}

}
