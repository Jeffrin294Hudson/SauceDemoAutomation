package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DriverManager;

public class LogoutSteps  {

	DriverManager driverManager = DriverManager.getInstance();
	WebDriver driver = driverManager.getDriver();

	private LoginPage loginPage = new LoginPage(driver);

	@Given("I am logged in as {string}")
	public void i_am_logged_in_as(String string) {
		loginPage.loginSauceWebsite();

	}

	@When("I click the menu button")
	public void i_click_the_menu_button() {
		loginPage.clickMenuButton();
	}

	@And("Click the logout button")
	public void click_the_logout_button() {
		loginPage.clickLogoutButton();
	}

	@Then("It should be redirected to the login page")
	public void it_should_be_redirected_to_the_login_page() {
		Assert.assertTrue(loginPage.isLogoutSuccessful());
	}

}
