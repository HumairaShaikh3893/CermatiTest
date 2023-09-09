package com.pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SearchFunctionality {
	
WebDriver driver;
	
	public SearchFunctionality(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@id='gh-cat']")
	@CacheLookup
	WebElement searchCatagory;
	
	@FindBy(xpath="//input[@id='gh-ac']")
	@CacheLookup
	WebElement search;
	
	
	@FindBy(xpath="//ul[@class='srp-results srp-list clearfix']/li[2]")
	@CacheLookup
	WebElement productlist1;
	
	

	public void clicksearchCatagory()
	{
		Select select=new Select(searchCatagory);
		select.selectByVisibleText("Computers/Tablets & Networking");
		
	}
	
	public void clicksearch()
	{
		Actions act=new Actions(driver);
		search.sendKeys("Macbook");
		act.keyDown(Keys.ENTER).build().perform();
		
	}
	
	public void verifypageLoad()
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String producturl="https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=Macbook&_sacat=58058";
		JavascriptExecutor j = (JavascriptExecutor) driver;
	      if(j.executeScript("return document.readyState").toString().equals("complete"))
	      {
	      
	      // get the current URL
	      String s = driver.getCurrentUrl();
	      System.out.println(s);
	      System.out.println("page is loaded");
	      
	      //// checking condition if the URL is loaded
	      if (s.equals(producturl)) 
	      {
	         System.out.println("Page Loaded");
	         System.out.println("Current Url: " + s);
	      
	      }
	      else 
	      {
	         System.out.println("Page did not load");
	      }
	      }
	}
	
	
	public void checkProduct()
	{
		Actions act=new Actions(driver);
		act.scrollToElement(productlist1).build().perform();
		productlist1.click();
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());
		}
		}
		
		
	}
	
	
	
	
	
	
}
