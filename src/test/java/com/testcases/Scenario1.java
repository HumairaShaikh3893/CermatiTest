package com.testcases;



import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.FiltersFunctionality;
import com.utilities.CustumListners;
@Listeners(CustumListners.class)
public class Scenario1 extends Base{
	
	
@Test

public static void filterSenario() throws InterruptedException
{
	FiltersFunctionality ff=new FiltersFunctionality(driver);
	ff.mouseoverelectronic();
	//Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	ff.clickaccessoriest();
	ff.clickcellAndSmartPhone();
	ff.clickallListing();
	Thread.sleep(5000);
	ff.clickallFilters();
	Thread.sleep(5000);
	ff.clickscreenSize();
	Thread.sleep(5000);
	ff.clickprice();
	Thread.sleep(5000);
	ff.clickitemLocation();
	Thread.sleep(5000);
	ff.clickapply();
	Thread.sleep(5000);
	ff.getfilterlist();
	
}

}
