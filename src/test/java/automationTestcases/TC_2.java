package automationTestcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import pageObjects.*;
import utilities.*;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Appender;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TC_2 {
	public static WebDriver driver=null ;
	public static Select sel=null;
	
	
  
	
	
  @Test
  public void TC_mobile_page() throws InterruptedException {
	  
	  WebElement webe=HomePage.lnk_mobile(driver);
	  HomePage home_page=new HomePage(driver);
	  home_page.link_mobile.click();
	  //webe.click();
	  Thread.sleep(2000);
	  
	  if(driver.getTitle().equals(Constants.title_mobile_pg)) {
		  
		Logg.info("Title Confirmed equal to Mobile");
		Reporter.log("Mobile Webpage Title has matched");
		Assert.assertTrue(true);
	  }
	  else {
		 
		  Logg.error("Title check of  Mobile page failed: "+Constants.title_mobile_pg);
		  Reporter.log("Mobile Webpage Title has not matched ");
		  Assert.assertTrue(false);
		  
	  }
	  
	  
  }		  
		
  @Test
  public void TC_price_comp() throws InterruptedException {
		
	  
	  
	  String price= "" ; 
	  
	  price=driver.findElement(By.cssSelector("#product-price-2 > span.price")).getText();

	  driver.findElement(By.cssSelector("#product-collection-image-1")).click();
		Logg.info("Xperia link Clicked");

	  Thread.sleep(2000);
		

	  
		
			
		if(driver.findElement(By.cssSelector("#product-price-1 > .price")).getText().equals(price))
		{
		
			Logg.info("Price  Confirmed equal");

				Assert.assertTrue(true, "we have a match");
		}
  }
  
  

  @AfterTest
  public void afterMethod() {
  driver.close();
  Logg.EndTestCase("TC_2");

  }

}
