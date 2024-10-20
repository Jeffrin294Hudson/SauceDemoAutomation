package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickCheckoutButton() {
		driver.findElement(By.id("checkout")).click();
	}

	public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("postal-code")).sendKeys(postalCode);
	}

	public void clickContinueButton() {
		driver.findElement(By.id("continue")).click();
	}

	public void clickFinishButton() {
		driver.findElement(By.id("finish")).click();
	}

	public void navigateToProductsPage() {

		boolean isPresent = waitUtils.isElementPresent(By.xpath("//button[@id='continue-shopping']"));

		if (isPresent) {
			driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		}
	}

	public List<String> getCartProductNames() {
		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		return cartItems.stream().map(item -> item.findElement(By.className("inventory_item_name")).getText())
				.collect(Collectors.toList());
	}

	public boolean verifyProductsInCart(List<String> expectedProducts) {
		List<String> actualProducts = getCartProductNames();
		return actualProducts.containsAll(expectedProducts) && actualProducts.size() == expectedProducts.size();
	}

	public boolean verifyErrorTextVisible(String errorText) {
		boolean isPresent = waitUtils.isElementPresent(By.xpath("//h3[text()='" + errorText + "']"));
		return isPresent;
	}

	public boolean verifySuccessTextVisible(String successText) {
		boolean isPresent = waitUtils.isElementPresent(By.xpath("//h2[text()='" + successText + "']"));
		return isPresent;
	}
}
