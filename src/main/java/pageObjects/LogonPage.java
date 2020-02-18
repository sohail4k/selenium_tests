package pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Constants;
import utilities.Logg;

public class LogonPage {
	
	private static WebElement webe=null;
	private   WebDriver driver=null;
	
	@FindBy(css=".col-1 > div:nth-child(2) > a:nth-child(1)") 
	private static  WebElement link_create_accnt; 
	
	@FindBy(css="#email")
	private static  WebElement input_username;
	
	@FindBy(css="#pass")
	private static  WebElement input_password;
	
	@FindBy(css="#send2")
	private static  WebElement button_submit;
	
	
	public LogonPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public static  WebElement createAccount(WebDriver driver) {
		//webe=driver.findElement(By.cssSelector(".col-1 > div:nth-child(2) > a:nth-child(1)"));
		Logg.info("Create Account link found");
		return link_create_accnt;
	}
	
	public boolean isOpened() {
		return driver.getTitle().equalsIgnoreCase(Constants.title_logon_pg);
	}
	public void clickCreateAccount() {
		link_create_accnt.click();
		Logg.info("Create Account link found and clicked");

	}
	
	public  void loginUser(String username, String password) {
		input_username.sendKeys(username);
		input_password.sendKeys(password);
		button_submit.click();
	}
}
