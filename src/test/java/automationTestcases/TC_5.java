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

public class TC_5 {
	public static WebDriver driver=null ;
	public static Select sel=null;
	
	
  @BeforeTest
  public void b() throws Exception {
	  
		
		DOMConfigurator.configure("log4j.xml");
		
		Logg.StartTestCase("TC_5");

		Logg.info("Initiating the browser ");
		
	  driver=CommonUtilities.OpenBrowser("Mozilla");
	  
	  }

	
	
  @Test (priority= 1)
  public void TC_my_accnt_page() throws InterruptedException {
	  
	  
	  WebElement webe=HomePage.lnk_my_accnt(driver);
	  webe.click();
		Logg.info("My Account link clicked");

	  Thread.sleep(2000);
	  
	  if(driver.getTitle().equals(Constants.title_my_account_pg)) {
		  Assert.assertTrue(true);
		Logg.info("Title Confirmed equal to My Account");
		Reporter.log("My Account Webpage Title has matched");
	  }
	  else {
		 
		  Logg.error("Title check of  My Account page failed: "+ Constants.title_my_account_pg);
		  Reporter.log("My Account Webpage Title has not matched ");
		  Assert.assertTrue(false);
		  
	  }
	  
	  
	  
	  
  }		  
		
  @Test (priority=2)
  public void TC_create_accnt() throws InterruptedException {
		
	  
	  
	  String error_t= "Some of the products cannot be ordered in requested quantity." ; 
	  String  mess="Shopping Cart is Empty";
	  
	 // Thread.sleep(2000);

	//  driver.findElement(By.cssSelector("#product-collection-image-1")).click();
	//	Logg.info("Xperia link Clicked");

	

	 Thread.sleep(2000);
		
	  
	 LogonPage.createAccount(driver).click();
	 Logg.info("Create Account link clicked ");

	 if(driver.getTitle().equals(Constants.title_create_account_pg))
		  Assert.assertTrue(true);
	 else {
		 Assert.assertTrue(false, "Create account title did not match ");
	 }

	 driver.findElement(By.id("firstname")).sendKeys("Sohail");
	    
	    driver.findElement(By.id("middlename")).sendKeys("Mr");
	    
	    driver.findElement(By.id("lastname")).sendKeys("Malik");
	    
	    driver.findElement(By.id("email_address")).sendKeys("smk2-2@yahoo.com");;

	    
	    driver.findElement(By.id("password")).sendKeys("kirkat99");
	    driver.findElement(By.id("confirmation")).sendKeys("kirkat99");
	    driver.findElement(By.cssSelector(".button:nth-child(2) > span > span")).click();

	 
	   if( driver.findElement(By.cssSelector(".success-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)"))
	    .getText().equalsIgnoreCase("Thank you for registering with Main Website Store."))
		   Assert.assertTrue(true);
	   else 
		   Assert.assertTrue(false,"Account not created ");
	   
	   
	   driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("li.item:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.cssSelector(".btn-share")).click();;
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("#email_address")).sendKeys("sohail_mm@yahoo.com");
	   driver.findElement(By.cssSelector("#message")).sendKeys("Haan Ji ki haal je");
	   driver.findElement(By.cssSelector(".buttons-set > button:nth-child(3)")).click();
	   Thread.sleep(1000);
	   if(driver.findElement(By.cssSelector(
			   ".success-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)"))
			   .getText().equalsIgnoreCase("Your Wishlist has been shared.")) 
			Assert.assertTrue(true);
	   else 
			Assert.assertTrue(false,"Wish list not shared");	


	 
		/*if(driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)")).getText().equalsIgnoreCase(mess)) {
		Logg.info("Programm successfully completed");
		Assert.assertTrue(true);
		}
		else {
			Logg.error("Programm was not completed successfully");
			Assert.assertTrue(false,"---------");	
		
		}
  */
			
  }
  

  @AfterTest
  public void afterMethod() {
  //driver.close();
  Logg.EndTestCase("TC_3");
  
  
  }

}
