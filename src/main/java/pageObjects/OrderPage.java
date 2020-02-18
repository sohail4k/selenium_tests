package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
private static WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(css=".link-print")
	public static WebElement link_print_order ;
	
	@FindBy(css=".link-reorder")
	public static WebElement link_reorder ;
	
	
	
	public  void clickPrintOrder() {
		  link_print_order.click();
	}
	
	public  void clickReorder() {
		link_reorder.click();
	}
		  
	
	
}
