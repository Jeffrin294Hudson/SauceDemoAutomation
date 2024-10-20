package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

	private WebDriverWait wait;

	public WaitUtils(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement waitForElement(By locator, String condition) {
		switch (condition.toLowerCase()) {
		case "clickable":
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		case "visible":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		case "present":
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		default:
			throw new IllegalArgumentException("Invalid wait condition: " + condition);
		}
	}

	public boolean isElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true; // Element is present
		} catch (Exception e) {
			return false; // Element is not present
		}
	}

	// Overloaded method to check by CSS selector
	public boolean isElementPresent(String cssSelector) {
		return isElementPresent(By.cssSelector(cssSelector));
	}

	// Overloaded method to check by XPath
	public boolean isElementPresentXPath(String xpath) {
		return isElementPresent(By.xpath(xpath));
	}
}
