package parallel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.ProductsPage;
import utils.DriverManager;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartManagementSteps {
	DriverManager driverManager = DriverManager.getInstance();
	WebDriver driver = driverManager.getDriver();

	private ProductsPage productsPage = new ProductsPage(driver);
	private CheckoutPage checkoutPage = new CheckoutPage(driver);

	@And("I have added the following products to the cart")
	public void i_have_added_the_following_products_to_the_cart(DataTable dataTable) {
		List<String> products = dataTable.asList(String.class);
		for (String product : products) {
			productsPage.addProductToCart(product);
		}

	}

	@When("I add the following products to the cart")
	public void i_add_the_following_products_to_the_cart(DataTable dataTable) {
		List<String> products = dataTable.asList(String.class);
		for (String product : products) {
			productsPage.addProductToCart(product);
		}
	}

	@When("I remove the products from the cart")
	public void i_remove_the_products_from_the_cart(DataTable dataTable) {
		checkoutPage.navigateToProductsPage();
		List<String> products = dataTable.asList(String.class);
		for (String product : products) {
			productsPage.removeProductFromCart(product);
		}

	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		productsPage.viewCart();
		checkoutPage.clickCheckoutButton();
	}

	@When("I enter the following information:")
	public void i_enter_the_following_information(DataTable dataTable) {
		List<List<String>> info = dataTable.asLists(String.class);
		String firstName = info.get(1).get(0);
		String lastName = info.get(1).get(1);
		String postalCode = info.get(1).get(2);

		if (firstName == null || firstName.trim().isEmpty()) {
			firstName = "";
		}

		checkoutPage.enterCheckoutInfo(firstName, lastName, postalCode);
	}

	@And("Click the {string} button")
	public void click_the_button(String buttonName) {
		if ("Continue".equals(buttonName)) {
			checkoutPage.clickContinueButton();
		}
	}

	@Then("the cart should contain {int} item")
	public void the_cart_should_contain_item(int itemCount) {
		int actualCount = productsPage.getCartItemCount();
		Assert.assertEquals("Cart item count does not match the expected count.", itemCount, actualCount);

	}

	@Then("It should display a confirmation message {string}")
	public void it_should_display_a_confirmation_message(String field) {
		Assert.assertTrue(checkoutPage.verifySuccessTextVisible(field));
	}

	@And("Complete the payment")
	public void complete_the_payment() {
		checkoutPage.clickFinishButton();
	}

	@Then("It should display an error message indicating that {string}")
	public void it_should_display_an_error_message(String field) {
		Assert.assertTrue(checkoutPage.verifyErrorTextVisible(field));
	}

}
