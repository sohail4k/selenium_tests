package automationTestcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.CommonMenusPage;
import pageObjects.HomePage;
import pageObjects.LogonPage;
import pageObjects.MyAccountPage;
import pageObjects.OrderPage;
import pageObjects.SuccessPage;
import utilities.Logg;


public class TestC_7 extends TestBase  {
	
	@Test(description="Pick order from cart and verify ifs its successfully made")
	static void verifyOrderPDF() throws InterruptedException, IOException {
		
	CommonMenusPage common_menus= new CommonMenusPage(driver);
	
	HomePage home= new HomePage(driver);
	Assert.assertTrue(home.is_opened(),"HomePage Not Opened");
	common_menus.clickAccount();
	Thread.sleep(2000);
	common_menus.clickSubmenuLogin();
	LogonPage logon= new LogonPage(driver);
	Assert.assertTrue(logon.isOpened(), "click on Logon submenu failed");
	logon.loginUser("smk2-2@yahoo.com", "kirkat99");
	MyAccountPage my_account= new MyAccountPage(driver);
	
	Assert.assertTrue(my_account.isOpened(), "Logon Failed, invalid Credentials");
	
	my_account.clickMyOrders();
	String order_status="Pending", status="";
	String order_id="'100011022'";
	
	status=driver.findElement(By.xpath("//td[text()="+order_id+"]/parent::tr/td[@class='status']")).getText();
	
	System.out.println("Foundorder_status is: "+status);
	Assert.assertTrue(status.equalsIgnoreCase(order_status));
	
	driver.findElement(By.xpath("//td[text()=100011022]/parent::tr/td[6]//a[1]")).click();
	
	OrderPage order_pg=new OrderPage(driver);

	String winHandleBefore = driver.getWindowHandle();

	order_pg.clickPrintOrder();
	
	Thread.sleep(2000);
	

	// Perform the click operation that opens new window

	// Switch to new window opened
	
	
	Runtime.getRuntime().exec("C:\\Users\\sohai\\Downloads\\Chrome\\savetopdf.exe");
	
	Thread.sleep(10000);
	//((JavascriptExecutor) driver).executeScript("window.focus();");
	
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	
	driver.close();
	
	// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		driver.get("https://www.w3schools.com/xml/xpath_syntax.asp");
		Thread.sleep(3000);
	
	

	

	
	}
	

}
