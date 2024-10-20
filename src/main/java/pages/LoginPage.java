package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(By.id("login-button")).click();
	}

	public boolean isLoginSuccessful() {
		WebElement inventoryPage = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div"));
		return inventoryPage.isDisplayed();
	}

	public boolean isLogoutSuccessful() {
		waitUtils.waitForElement(By.id("login-button"), "clickable");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		return loginButton.isDisplayed();
	}

	public boolean isErrorMessageVisible() {
		WebElement errorElement = driver.findElement(By.xpath("//button[@class='error-button']"));
		return errorElement.isDisplayed();

	}

}
