package utilities;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.Constants;

//import utility.Constants;
//import utility.ExcelUtils;
//import utility.Log;

public class CommonUtilities {
	
	private static WebDriver driver =null;
	
	
public static WebDriver OpenBrowser(String  browser ) throws Exception  {
		
		try {
		//String browser=ExcelUtils.GetCellData(tc_row,Constants.col_browser);
			
		
		switch (browser) {
		
		case "Mozilla":
		driver= new FirefoxDriver();
		Logg.info("Firefox web driver initiated");
		break;
		case "Edge":
		driver= new EdgeDriver();
		Logg.info("Edge web driver initiated");
		break;
		case "Chrome":
		driver=new ChromeDriver();
		Logg.info("Chrome web driver initiated");
		break;
		
		default:
		Logg.error("browser name invalid");
		//throw new Exception("Browser Name invalid");
		break;	
		}
		
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//    WebDriverWait wait =new WebDriverWait(driver, 10);

	Logg.info("Web Driver implicit wait set to 10 sec");
    driver.manage().window().maximize();


	driver.get(Constants.url);
	Logg.info("Web application launched to the test url");

		
		}
		catch (Exception e) {
			throw e;
		}
		
		return driver; 
	}

	public static String  ConvertToTC( String tc_class_name ) throws Exception {
		String row_res=tc_class_name;
		
		try {
			int i=row_res.indexOf('@');
			row_res=row_res.substring(row_res.lastIndexOf('.')+1, row_res.indexOf('@'));
			
		}
		 
		catch (Exception e ) {
			Logg.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw e;
			
		}
		 
		return row_res;
				
		
	}
	
	
		
		
		
	
		
	//	return 
		
//	}

}
