package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import utils.DriverFactory;

public class BasePage extends DriverFactory {
	private WebDriverWait wait;
	private static String screenshotName;

	public BasePage() throws IOException {
		this.wait = new WebDriverWait(driver, 15);
	}

	
	
	/**********************************************************************************
	 **CLICK METHODS
	 **********************************************************************************/
	
	

	public void waitAndClickElement(WebElement element) throws InterruptedException, IOException {
		
			try {
				this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				Reporter.addStepLog("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
			
			} catch (Exception e) {
				Reporter.addStepLog("Unable to wait and click on WebElement, Exception: " + e.getMessage());
				Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
			}
		}
	

	

	/**********************************************************************************
	 **SEND KEYS METHODS /
	 **********************************************************************************/
	
	
	
	public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
		try {
			this.WaitUntilWebElementIsVisible(element);
			element.clear();
			element.sendKeys(textToSend);
			Reporter.addStepLog("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
		} catch (Exception e) {
			Reporter.addStepLog("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
			Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
		}
	}

	


	/**********************************************************************************
	 **WAIT METHODS
	 **********************************************************************************/
	
	
	public boolean WaitUntilWebElementIsVisible(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.addStepLog("WebElement is visible using locator: " + "<" + element.toString() + ">");
			return true;
		} catch (Exception e) {
			Reporter.addStepLog("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}

	

	
	/*****EXTENT REPORT****************************************************************/
	public static String returnDateStamp(String fileExtension) {
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_") + fileExtension;
		return date;
	}
	
	
	
	
	
	// this is used for screenshot capturing
	public static void captureScreenshot() throws IOException, InterruptedException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshotName = returnDateStamp(".jpg");
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName));
		Reporter.addStepLog("Taking a screenshot!");
		
		
		Reporter.addScreenCaptureFromPath(returnScreenshotName());  

		// this also works
		//Reporter.addStepLog("<a target=\"_blank\", href="+ returnScreenshotName() + "><img src="+ returnScreenshotName()+ " height=200 width=300></img></a>");
	}
	

	public static String returnScreenshotName() {
		return (System.getProperty("user.dir") + "\\output\\imgs\\" + screenshotName).toString();
	}
	
	
	
	
	
	
	// this is used in updating the name of the extent report
	public static void copyLatestExtentReport() throws IOException {
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_");
		File source = new File(System.getProperty("user.dir") + "\\output\\report.html");
		File dest = new File(System.getProperty("user.dir") + "\\output\\" + date.toString() + ".html");
		copyFileUsingStream(source, dest);
	}
	
	
	
	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			
			while((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			
		} finally {
			is.close();
			os.close();
		}
	}
}
