package runners;

import java.io.File;
import java.io.IOException;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import pageObjects.BasePage;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/java/resources/features/" }, 
	glue = {"stepDefinitions" }, 
	monochrome = true, 
	tags = {"@shivsahil"}, 	
	plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })


public class MainRunner extends AbstractTestNGCucumberTests {
	
	@AfterClass   // this is a testNG annotation
	public static void writeExtentReport() throws IOException {
		
		// we are loading the template ReportsConfig.xml
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
		
		BasePage.copyLatestExtentReport();   // creating new extent report [custom method] 
	}
}


