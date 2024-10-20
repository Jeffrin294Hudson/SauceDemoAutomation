package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.DriverManager;
import utils.WaitUtils;

public class BasePage {

	DriverManager driverManager = DriverManager.getInstance();
	protected WebDriver driver = driverManager.getDriver();
	public WaitUtils waitUtils = new WaitUtils(driver);

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void loginSauceWebsite() {
		driver.get(ConfigReader.getProperty("Url"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(ConfigReader.getProperty("Username"));
		loginPage.enterPassword(ConfigReader.getProperty("Password"));
		loginPage.clickLoginButton();
		loginPage.isLoginSuccessful();
	}

	public void clickMenuButton() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
	}

	public void clickLogoutButton() {
		waitUtils.waitForElement(By.id("logout_sidebar_link"), "clickable");
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
