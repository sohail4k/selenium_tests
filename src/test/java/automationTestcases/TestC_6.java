package automationTestcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.CommonMenusPage;
import pageObjects.HomePage;
import pageObjects.LogonPage;
import pageObjects.MyAccountPage;
import pageObjects.SuccessPage;

public class TestC_6 extends TestBase {
	
	@Test
	static void orderCartItem() throws InterruptedException {
		
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
		
		common_menus.clickCart();
		
		common_menus.clickSubmenuCheckout();
		CheckoutPage checkout= new CheckoutPage(driver);
		Assert.assertTrue(checkout.isOpened(), "checkout page is not opened");
		Thread.sleep(2000);
		checkout.clickCloseAdvert();
		
		checkout.clickShipThisAddress();
		checkout.clickContinue1();
		Thread.sleep(2000);
		checkout.clickContinue3();
		checkout.clickCheckRMoneyOrder();
		Thread.sleep(2000);
		checkout.clickContinue4();
		Thread.sleep(2000);
		checkout.clickPlaceOrder();
		SuccessPage order_status= new SuccessPage(driver);
		Thread.sleep(2000);
		Assert.assertTrue(order_status.isOpened(), "Order Failed");
		
		
	}
	
	

}
