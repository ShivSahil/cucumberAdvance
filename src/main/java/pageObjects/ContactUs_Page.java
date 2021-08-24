package pageObjects;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class ContactUs_Page extends BasePage{
	public @FindBy(xpath = "//input[@name='first_name']") WebElement textfield_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textfield_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textfield_EmailAddress;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textfield_Message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;
	public @FindBy(xpath = ".//*[@id='contact_reply']/h1") WebElement thanksContactUsPage;

	/* when instance of ContactUs_Page class is created in 
	 * DriverFactory then  call is made to Base class. 
	 * go to base class and see that WebdriverWait is being initialized there
	 */
	public ContactUs_Page() throws IOException {
		super();
	}
	
	
	public ContactUs_Page getContactUsPage() throws IOException {
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		Reporter.addStepLog("hitting webdriveruniversity website");
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterFirstName(String firstName) throws Exception {
		sendKeysToWebElement(textfield_FirstName, firstName);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterLasttName(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_LastName, data.get(row).get(column));
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterEmailAddress(String emailAddress) throws Exception {
		sendKeysToWebElement(textfield_EmailAddress, emailAddress);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterComments(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_Message, data.get(row).get(column));
		return new ContactUs_Page();
	}
	
	public ContactUs_Page clickOnSubmiButton() throws Exception {
		
		
		
		waitAndClickElement(button_Submit);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page confirmContactUsFormSubmissionWasSuccessful() throws Exception {
		

		Assert.assertEquals("Thank You for your Message!", thanksContactUsPage.getText()  );	
		return new ContactUs_Page();
	}

}
