package utils;

import org.openqa.selenium.WebDriver;

import utils.DriverManager;

public class DriverManager {
	private static DriverManager instance;
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

	public WebDriver getDriver(String browser) {
		WebDriver driver = webDriver.get();
		if (driver == null) {
			driver = WebDriverFactory.createDriver(browser);
			webDriver.set(driver);
		}
		return driver;
	}

	public WebDriver getDriver() {
		return getDriver(ConfigReader.getProperty("browserType"));  
	}
	
	public static void quitDriver() {
		WebDriver driver = webDriver.get();
		if (driver != null) {
			driver.quit();
			webDriver.remove();
		}
	}
}