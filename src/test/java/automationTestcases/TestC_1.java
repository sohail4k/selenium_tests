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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TestC_1 {
	public static WebDriver driver=null ;
	public static Select sel=null;
	
	
  @BeforeTest
  public void b() throws Exception {
	  
		
		DOMConfigurator.configure("log4j.xml");
		//Logg.info("Initiating the browser ");
	  driver=CommonUtilities.OpenBrowser("Mozilla");
	  
	  }

	
	
  @Test
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
		
  @Test
  public void TC_prod_sort() throws InterruptedException {
	  
	  
	 // sel = new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul")));
	  
			 // driver.findElements(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul")));
	//Select sel= new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"))  
	  
	  List <WebElement> li_mob = MobilePage.li_mobiles(driver);
	  
	  List<String> original_list = new ArrayList();
		for (WebElement e : li_mob) {
			original_list.add(e.getAttribute("title"));
		}
	  
	  sel=MobilePage.sel_sort_by(driver);
	  sel.selectByVisibleText("Name");
	  Logg.info("Items sorted by Name");
	   
	  
		Thread.sleep(2000);
	
		li_mob=MobilePage.li_mobiles(driver);
	
	  List<String> sorted_list = new ArrayList();
		for (WebElement e : li_mob) {
			sorted_list.add(e.getAttribute("title"));
		}
		
		List<String> temp_list= original_list;
		Collections.sort(temp_list);
		AssertJUnit.assertEquals(sorted_list, temp_list);
		
	  
  }
  
  

  @AfterTest
  public void afterMethod() {
  driver.close();
  }

}
