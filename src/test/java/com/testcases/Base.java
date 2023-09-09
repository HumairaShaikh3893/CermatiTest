package com.testcases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class Base {
	
	
	public static WebDriver driver;;
	
	@BeforeTest
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\habib\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		driver=(WebDriver) new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		
	}
	
	
	
	@AfterTest
	public static void teardown()
	{
		driver.close();
		
	}
	
	public static void failed(String Testmethodname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./Screenshots/"+Testmethodname+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
