package com.pageObjects;

import java.util.Iterator;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FiltersFunctionality {
	
	WebDriver driver;
	
	public FiltersFunctionality(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	//webelements and the action classes of the login page functionality
	
	@FindBy(xpath="//body/div[@id='mainContent']/div[1]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement electronic;
	
	@FindBy(xpath="//a[contains(text(),'Smartphones and accessories')]")
	@CacheLookup
	WebElement accessories;
	
	@FindBy(xpath="//a[contains(text(),'Cell Phones & Smartphones')]")
	@CacheLookup
	WebElement cellAndSmartPhone;
	
	@FindBy(xpath="//h2[contains(text(),'All Listings')]")
	@CacheLookup
	WebElement allListing;
	
	
	@FindBy(xpath="//button[contains(text(),'All Filters')]")
	@CacheLookup
	WebElement allFilters;
	
	
	@FindBy(xpath="//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[8]/span[1]")
	@CacheLookup
	WebElement screenSize;
	
	@FindBy(xpath="//div[@id='c3-mainPanel-price']")
	@CacheLookup
	WebElement price;
	
	@FindBy(xpath="//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[25]/span[1]\r\n")
	@CacheLookup
	WebElement itemLocation;
	
	
	@FindBy(xpath="	//button[@class='x-overlay-footer__apply-btn btn btn--primary']\r\n")
	@CacheLookup
	WebElement apply;
	
	
	@FindBy(xpath="//span[contains(text(),'3 filters applied')]")
	@CacheLookup
	WebElement filterapplied;
	
	@FindBy(xpath="//li[@class='brm__aspect-item brm__aspect-item--applied']")
	@CacheLookup
	List<WebElement> filterlist;
	
	
	
	//creating an action methods for the elements
	
	//act=new Actions(driver);
	public void mouseoverelectronic()
	{
		 Actions act=new Actions(driver);
		act.moveToElement(electronic).build().perform();
	}
	
	public void clickaccessoriest()
	{
		accessories.click();
	}
	
	
	public void clickcellAndSmartPhone()
	{
		cellAndSmartPhone.click();
	}
	
	
	public void clickallListing()
	{
		//allListing.click();
		 Actions act=new Actions(driver);
		act.moveToElement(allListing).build().perform();
	}
	
	public void clickallFilters()
	{
		allFilters.click();
	}
	
	public void clickscreenSize()
	{
		screenSize.click();
		driver.findElement(By.xpath("//span[contains(text(),'4.0 - 4.4 in')]")).click();

	}
	
	public void clickprice()
	{	Actions act=new Actions(driver);
		//driver.findElement(By.xpath("//div[@class='x-overlay__wrapper--left']")).click();
		act.scrollToElement(price).build().perform();
		price.click();
		//driver.findElement(By.xpath("//div[@class='x-overlay__wrapper--right']")).click();
		driver.findElement(By.xpath("//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("110");
		driver.findElement(By.xpath("//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/ul[1]/li[1]/div[2]/div[1]/div[2]/div[1]/input[1]")).sendKeys("230");

	}
	
	
	public void clickitemLocation()
	{ 
		Actions act=new Actions(driver);
		act.moveToElement(itemLocation).build().perform();
		itemLocation.click();
		driver.findElement(By.xpath("//input[@value='US Only']")).click();

	}
	
	public void clickapply()
	{
		apply.click();
	}
	
	
	public void clickfilterapplied()
	{
		filterapplied.click();
	}
	
	
	public void getfilterlist() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[contains(text(),'3 filters applied')]")).click();
		Thread.sleep(5000);
		Iterator<WebElement> it=filterlist.iterator();
		if(it.hasNext())
		{
			WebElement e1=it.next();
			String text1=e1.getText();
			
			if(text1.contains("Screen Size: 4.0 - 4.4 in")||text1.contains("Price: $110.00 to $230.00")||text1.contains("Item Location: US Only"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
