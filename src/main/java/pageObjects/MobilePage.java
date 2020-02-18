package pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Constants;
import utilities.Logg;

public class MobilePage{

	private  WebDriver driver;
	private static WebElement webe=null;
	private static Select sel=null;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	private static Select  select_sort;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul")
	private static List <WebElement> list_mobiles;
	
	public static  Select sel_sort_by(WebDriver driver) {
		
		sel= new Select (driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		Logg.info("Sort select element found");
		return sel;
		
	}
	
	public  MobilePage(WebDriver driver) {
		this.driver=driver;
	       PageFactory.initElements(driver, this);

	}
	
	
public static  List <WebElement> li_mobiles(WebDriver driver) {
		
		List <WebElement> l_mobiles= driver.findElements(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul"));
		Logg.info("Moble list element found");

		
		return l_mobiles;
	
	
}
public boolean is_opened(WebDriver driver) {
	return driver.getTitle().equalsIgnoreCase(Constants.title_mobile_pg);
}
}