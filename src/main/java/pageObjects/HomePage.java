package pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Logg;

import org.openqa.selenium.JavascriptExecutor;

public class HomePage {
	
	
	private  WebDriver driver=null;
	private static WebElement webe=null;
	
	@FindBy(css="li.level0:nth-child(1) > a:nth-child(1)")
	public  static WebElement link_mobile;
	
	@FindBy(css="li.level0:nth-child(2) > a:nth-child(1)")
	public static WebElement link_tv;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement lnk_mobile(WebDriver driver) {
		//CommonUtilities
		webe=driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));  //linkText("Mobile"));
		Logg.info("Mobile link  element found");
		//webe=(WebElement) ((JavascriptExecutor)driver).executeScript("arguments[0];",driver.findElement(By.linkText("Change Password")));	
		return link_mobile;
		//return webe;
	}
	
	public static WebElement lnk_tv(WebDriver driver) {
		
		webe=driver.findElement(By.linkText("Log out"));
		Logg.info("Logout link  element found");

		return link_tv; 
		//return webe;

		
	}


public static WebElement lnk_my_accnt(WebDriver driver) {
		
		webe=driver.findElement(By.cssSelector("div.links:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
		Logg.info("My Account  link  element found");

		 
		return webe;

		
	}

public boolean is_opened() {
	return driver.getTitle().equalsIgnoreCase("Home page");
	

}
}

