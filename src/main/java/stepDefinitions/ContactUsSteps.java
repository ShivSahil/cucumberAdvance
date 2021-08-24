package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ContactUsSteps extends DriverFactory {
	
	@Given("^I access webdriveruniversity contact us form$")
	public void i_access_webdriveruniversity_contact_us_form() throws IOException {
		contactUsPage.getContactUsPage();
	}

	
	@When("^I enter a valid firstname as \"([^\"]*)\"$")
	public void i_enter_a_valid_firstname_as(String fname) throws Throwable {
		contactUsPage.enterFirstName(fname);
	}

	@When("^I enter a valid last name$")
	public void i_enter_a_valid_last_name(DataTable dataTable) throws Exception{
		contactUsPage.enterLasttName(dataTable, 0, 1);
	}

	
	@And("^i enter a valid email address as \"([^\"]*)\"$")
	public void i_enter_a_valid_email_address_as(String email) throws Throwable {
		contactUsPage.enterEmailAddress(email);
	}
	
	@And("^i enter comments$")
	public void i_enter_comments(DataTable dataTable) throws Exception {
		contactUsPage.enterComments(dataTable, 0, 1);
	}

	@When("^i click on the submit button$")
	public void i_click_on_the_submit_button() throws Exception {
		contactUsPage.clickOnSubmiButton();
	}

	@Then("^the information should successfully be submitted via the contact us form$")
	public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws Exception  {
		
		contactUsPage.confirmContactUsFormSubmissionWasSuccessful();
	}
}
