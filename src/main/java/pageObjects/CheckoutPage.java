package pageObjects;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class CheckoutPage {
	
	private WebDriver driver;
	//private static WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		//this.wait=wait;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(css="ul.form-list:nth-child(2) > li:nth-child(3) > label:nth-child(2)")
	public static WebElement chkbox_ship_add_already ;
	@FindBy(css="#billing-buttons-container > button:nth-child(1)")
	public static WebElement btn_continue_1 ;
	@FindBy(css="#shipping-method-buttons-container > button:nth-child(2)")
	public static WebElement btn_continue_3 ;
	
	
	@FindBy(css="#dt_method_checkmo > label:nth-child(2)")
	public static WebElement chkbox_money_order;
	@FindBy(css="#payment-buttons-container > button:nth-child(2)")
	public static WebElement btn_continue_4 ;
	@FindBy(css=".btn-checkout")
	public static WebElement btn_place_order ;
	
	/*@FindBy(css="")
	public static WebElement link_ ;
	*/

	public  void clickContinue1() {
		  btn_continue_1.click();
	}
	public  void clickContinue3() {
		
		//wait.until(presenceOfElementLocated(btn_continue_3));
		btn_continue_3.click();
		
	}
	public  void clickContinue4() {
	btn_continue_4.click();	
	}
	public  void clickPlaceOrder() {
		  btn_place_order.click();
	}
	public  void clickShipThisAddress() {
		chkbox_ship_add_already.click();

	}
	public  void clickCheckRMoneyOrder() {
		chkbox_money_order.click();		  
	}
	public boolean isOpened( ) {
		return driver.getTitle().equalsIgnoreCase(Constants.title_checkout_pg);
	}
	
	public  void clickCloseAdvert() {
		driver.switchTo().frame(1);
		//driver.findElement(By.cssSelector("#closeBtn")).click();
		driver.findElement(By.cssSelector("html body div div#closeBtn")).click();
		driver.switchTo().defaultContent();
	}
	
	/*public  void click() {
		  
	}
*/
}
