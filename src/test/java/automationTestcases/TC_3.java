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

public class TC_3 {
	public static WebDriver driver=null ;
	public static Select sel=null;
	
	
  @BeforeTest
  public void b() throws Exception {
	  
		
		DOMConfigurator.configure("log4j.xml");
		
		Logg.StartTestCase("TC_3");

		Logg.info("Initiating the browser ");
		
	  driver=CommonUtilities.OpenBrowser("Mozilla");
	  
	  }

	
	
  @Test (priority= 1)
  public void TC_mobile_page() throws InterruptedException {
	  
	  
	  WebElement webe=HomePage.lnk_mobile(driver);  
	  webe.click();
	  Thread.sleep(2000);
	  
	  if(driver.getTitle().equals(Constants.title_mobile_pg)) {
		  Assert.assertTrue(true);
		Logg.info("Title Confirmed equal to Mobile");
		Reporter.log("Mobile Webpage Title has matched");
	  }
	  else {
		 
		  Logg.error("Title check of  Mobile page failed: "+Constants.title_mobile_pg);
		  Reporter.log("Mobile Webpage Title has not matched ");
		  Assert.assertTrue(false);
		  
	  }
	  
	  
	  
	  
  }		  
		
  @Test (priority=2)
  public void TC_max_orders() throws InterruptedException {
		
	  
	  
	  String error_t= "Some of the products cannot be ordered in requested quantity." ; 
	  String  mess="Shopping Cart is Empty";
	  
	 // Thread.sleep(2000);

	//  driver.findElement(By.cssSelector("#product-collection-image-1")).click();
	//	Logg.info("Xperia link Clicked");

	 

	 Thread.sleep(2000);
		
	  
	  driver.findElement(By.cssSelector(".products-grid button:nth-child(1)")).click();
	  driver.findElement(By.cssSelector(".product-cart-actions > input:nth-child(1)")).sendKeys("1000");
		Logg.info("Order valuse of 1000 set");

		
	  driver.findElement(By.cssSelector("button.btn-update:nth-child(2)")).click();
		Logg.info("Update Button presssed");

	  
		if(driver.findElement(By.cssSelector(".error-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)")).getText().equals(error_t)) 
		{
			Logg.info("Price  Confirmed equal");
			Assert.assertTrue(true, "we have a match");
		}
		
		
		driver.findElement(By.cssSelector("#empty_cart_button")).click();
		Logg.info("Empty Cart Button Clicked ");
		
		//Thread.sleep(1000);
		//String s= driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)")).getText();
		
		if(driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)")).getText().equalsIgnoreCase(mess)) {
		Logg.info("Programm successfully completed");
		Assert.assertTrue(true);
		}
		else {
			Logg.error("Programm was not completed successfully");
			Assert.assertTrue(false,"---------");	
		
		}
  
			
  }
  

  @AfterTest
  public void afterMethod() {
  driver.close();
  Logg.EndTestCase("TC_3");
  
  
  }

}
