package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageObjects.BasePage;
import utils.DriverFactory;




public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() throws IOException {
		driver = getDriver();
	}
	
	@After
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		try {
			
			// we are checking driver with Null to see if driver is in use of not
			if(driver != null && scenario.isFailed()) {  
			
				
			System.out.println("failed scenario name is " + scenario.getName());
				
			// scenario.embed() adds the screenshot in index.html
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				
			// BasePage.captureScreenshot() is used to add screenshot to extent report.html
			BasePage.captureScreenshot();
			driver.manage().deleteAllCookies();
			driver.quit();
			driver = null;  // i added this for more stability while execution  
			}
			
			
			if(driver != null) {    // there is no such thing as scenario.isPassed()
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("tearDownAndScreenshotOnFailure method failed with Exception: " + e.getMessage());
		}
}
}
