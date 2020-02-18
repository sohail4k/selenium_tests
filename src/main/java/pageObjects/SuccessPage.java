package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;

public class SuccessPage {

	
	private static WebDriver driver;
	
	public SuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".buttons-set > button:nth-child(1)")
	public static WebElement link_continue_shop ;
	
	
	@FindBy(css=".page-title > h1:nth-child(1)")
	public static WebElement text_order ;
	
	/*@FindBy(css="")
	public static WebElement link_ ;
	*/
	
	public  void clickContinueShopping() {
		link_continue_shop.click();		  
	}
	
	public  boolean isOpened() {
		return text_order.getText().contains(Constants.text_order_success);
		  
	}
}
