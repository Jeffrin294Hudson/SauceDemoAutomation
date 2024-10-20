package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

	private static WebDriver driver;

	@Before
	public void setup() {

		DriverManager driverManager = DriverManager.getInstance();
		driver = driverManager.getDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
