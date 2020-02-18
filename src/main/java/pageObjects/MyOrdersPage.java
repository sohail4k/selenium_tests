package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage {
	
WebDriver driver;
	
	
	public MyOrdersPage( WebDriver driver) {
		this.driver=driver;
	
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".current > a:nth-child(1)")
	private static WebElement link_view_orders;	

	public void clickViewOrders( ) {
		link_view_orders.click();
	}
	

}
