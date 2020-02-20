package automationTestcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utilities.CommonUtilities;
import utilities.Logg;

public class TestBase {
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	
	
	
	@BeforeSuite
	  public void openBrowser() throws Exception {
		  
			
			DOMConfigurator.configure("log4j2.xml");
			  Logg.EndTestCase("TC_2");

			
			Logg.info("Initiating the browser ");
			
		  driver=CommonUtilities.OpenBrowser("Mozilla");
		  //wait =new WebDriverWait(driver, 10);

		  }
	
		
	@AfterSuite
	public void teardown() {
		
		driver.close();
	}
	


}
