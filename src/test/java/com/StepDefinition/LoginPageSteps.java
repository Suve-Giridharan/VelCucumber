package com.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Utilities.FunctionalLibrary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginPageSteps extends FunctionalLibrary {

	WebDriver driver;

	@Given("User hitting the {string} landing  on the facebook loging page")
	public void user_hitting_the_landing_on_the_facebook_loging_page(String url) {
		driver = getDriver();
		loadUrl(url);
		Maximize();
		implicitWait();
	}

	@When("User enter the valid {string} and {string}")
	public void user_enter_the_valid_and(String Name, String Pass) {
		WebElement userName = driver.findElement(By.id("email"));
		type(userName, Name);

		WebElement passWord = driver.findElement(By.id("pass"));
		type(passWord, Pass);

		Assert.assertEquals("Verifying the userName", Name, getArrtribute(userName));
        
		Assert.assertEquals("Verifying the passWord", Pass, getArrtribute(passWord));
	}

	@Then("User click on the Login button and enter into the home page")
	public void user_click_on_the_Login_button_and_enter_into_the_home_page() {
		WebElement button = driver.findElement(By.xpath("//button[starts-with(@id,'u_0')]"));
		click(button);
	}

	@Then("User verifying the Url in the Home Page")
	public void user_verifying_the_Url_in_the_Home_Page() {
		/*
		 * String currentUrl = driver.getCurrentUrl(); boolean contains =
		 * currentUrl.contains("book"); Assert.assertTrue("Verifying the url",contains);
		 */

		Assert.assertTrue("Verifying the url", getUrl().contains("book"));
		quit();
	}
}
