package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void addProductToCart(String productName) {
		String addToCartButtonXpath = String.format(
				"//div[contains(@data-test, 'inventory-item-name')][text()='%s']/ancestor::div[contains(@class, 'inventory_item')]//button[contains(@data-test, 'add-to-cart')]",
				productName);
		driver.findElement(By.xpath(addToCartButtonXpath)).click();
	}

	public void removeProductFromCart(String productName) {
		String removeButtonXpath = String.format(
				"//div[contains(@data-test, 'inventory-item-name')][text()='%s']/ancestor::div[contains(@class, 'inventory_item')]//button[text()='Remove']",
				productName);
		driver.findElement(By.xpath(removeButtonXpath)).click();
	}

	public int getCartItemCount() {
		String countText = driver.findElement(By.className("shopping_cart_badge")).getText();
		return Integer.parseInt(countText);
	}

	public void viewCart() {
		driver.findElement(By.id("shopping_cart_container")).click();
	}

}
