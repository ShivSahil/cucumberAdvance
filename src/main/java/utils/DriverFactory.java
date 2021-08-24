package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.ContactUs_Page;


public class DriverFactory {
	public static WebDriver driver;
	public static ContactUs_Page contactUsPage;
	private Properties p;
	private FileInputStream fi;

	
	
	public WebDriver getDriver() throws IOException {
		
		
		p = new Properties();
		// we are giving location of config.properties
		fi = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY);  
		p.load(fi);
		
	try {
			
		String browserName = p.getProperty("browser");

		switch (browserName) {

			
			case "firefox":
				
				// "checking for null". It mean we are checking if driver is not already initialized
				if (null == driver) {   
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					driver = new FirefoxDriver();
				}
				break;

				
			case "chrome":
			
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					driver = new ChromeDriver();
				}
				break;

			
			}
		
		} 
		
		
		catch (Exception e) {
			System.out.println("Unable to invoke the browser. Error message is " + e.getMessage());
		} 
		
		
		finally {
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(p.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(p.getProperty("implicitlyTimeOut")), TimeUnit.SECONDS);
			
			// ** WHAT THE FUCK IS THIS??? WE ARE USING PAGEFACTORY
			contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
		}
		return driver;
	}
}
