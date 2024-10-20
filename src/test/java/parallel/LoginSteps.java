package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps{
	
	DriverManager driverManager = DriverManager.getInstance();
	WebDriver driver = driverManager.getDriver();
	LoginPage loginPage = new LoginPage(driver);

	@Given("I am on the SauceDemo login page")
	public void i_am_on_the_SauceDemo_login_page() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("I enter {string} as username")
	public void i_enter_as_username(String username) {
		loginPage.enterUsername(username);
	}

	@When("I enter {string} as password")
	public void i_enter_as_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("Click the login button")
	public void click_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("It should display the products page")
	public void it_should_display_the_products_page() {
		Assert.assertTrue(loginPage.isLoginSuccessful());
	}

	@Then("It should give an error message")
	public void it_should_give_an_error_message() {
		Assert.assertTrue(loginPage.isErrorMessageVisible());

	}
}