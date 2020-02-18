package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;

public class MyAccountPage {
	WebDriver driver;
	
	
	public MyAccountPage( WebDriver driver) {
		this.driver=driver;
	
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".current > a:nth-child(1)")
	private static WebElement link_account_dashboard;
	@FindBy(css=".block-account > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")
	private static WebElement link_account_info;
	@FindBy(css=".block-account > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")
	private static WebElement link_address_book;
	@FindBy(css=".block-account > div:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")
	private static WebElement link_my_orders;
		@FindBy(css=".block-account > div:nth-child(2) > ul:nth-child(1) > li:nth-child(8) > a:nth-child(1)")
	private static WebElement link_my_wishlist;
	

		/*@FindBy(css="")
	private static WebElement link_;
	@FindBy(css="")
	private static WebElement link_;
	@FindBy(css="")
	private static WebElement link_;
	@FindBy(css="")
	private static WebElement link_;

	*/
		
		

		public void clickAccountDashboard() {
			link_account_dashboard.click();
		}
		public void clickAccountInformation ( ) {
			link_account_info.click();
		}
		public void clickAddressBook ( ) {
			link_address_book.click();
		}
		public void clickMyOrders ( ) {
			link_my_orders.click();
		}
		public void clickMyWishlist ( ) {
			link_my_wishlist.click();
		}
		
		public boolean isOpened() {
			 return driver.getTitle().equalsIgnoreCase(Constants.title_my_account_pg);
			
		}
}
