package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class CommonMenusPage {
	
	private static  WebDriver driver=null; 
	@FindBy(css=".skip-account")
	public static WebElement link_account;
	
	@FindBy(css=".skip-cart")
	public static WebElement link_cart;
	
	@FindBy(css="li.level0:nth-child(1) > a:nth-child(1)")
	public  static WebElement link_mobile;
	
	@FindBy(css="li.level0:nth-child(2) > a:nth-child(1)")
	public static WebElement link_tv;
	
	@FindBy(css="div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
	public static WebElement submenu_my_account;
	
	@FindBy(css="div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")
	public static WebElement submenu_my_wishlist;
	
	@FindBy(css=".top-link-cart")
	public static WebElement submenu_my_cart;
	
	@FindBy(css="div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")
	public static WebElement submenu_register;
	
	@FindBy(css=".checkout-button")
	public static WebElement submenu_checkout;
	
	@FindBy(css="li.last:nth-child(6) > a:nth-child(1)")
	public static WebElement submenu_login;

	@FindBy(css="li.last:nth-child(5) > a:nth-child(1)")
	public static WebElement submenu_logout;
	
	@FindBy(css="a.button")
	public static WebElement submenu_cart_checkout;
	

	public CommonMenusPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public static void  clickAccount() {
		link_account.click();
		
	}
	
public static void clickCart() {
		link_cart.click();
	}

public static  void clickSubmenuMyAccount() {
	submenu_my_account.click();
}

public static  void clickSubmenuMyWishlist() {
	submenu_my_wishlist.click();
}


public static  void clickSubmenuMyCart() {
	submenu_my_cart.click();
}
public static  void clickSubmenuCheckout() {
	submenu_checkout.click();
}
public static  void clickSubmenuLogin() {
	submenu_login.click();
	
}

public static  void clickSubmenuLogout() {
	submenu_logout.click();
}

public static void  clickCartCheckout() {
	submenu_cart_checkout.click();
	
}




}
