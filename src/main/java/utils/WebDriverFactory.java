package utils;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {
	
	public enum BrowserType {
	    CHROME,
	    FIREFOX,
	    EDGE;

	    public static BrowserType fromString(String browser) {
	        try {
	            return BrowserType.valueOf(browser.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.", e);
	        }
	    }
	}

	
	public static WebDriver createDriver(String browser) {
	    BrowserType browserType = BrowserType.fromString(browser);
	    
	    // Checking a configuration setting to decide local or remote execution
	    boolean useRemote = Boolean.parseBoolean(ConfigReader.getProperty("useRemoteWebDriver"));
	    
	    if (useRemote) {
	        try {
	            URI gridUri = new URI(ConfigReader.getProperty("seleniumGridURL")); // "http://<SELENIUM_GRID_HUB_IP>:4444/wd/hub"
	            URL gridHubUrl = gridUri.toURL();
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("browserName", browser.toLowerCase());
	            return new RemoteWebDriver(gridHubUrl, capabilities);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to connect to Selenium Grid hub", e);
	        }
	    } else {
	        // Local driver instantiation
	        switch (browserType) {
	            case CHROME:
	                ChromeOptions chromeOptions = new ChromeOptions();
	                return new ChromeDriver(chromeOptions);
	            case FIREFOX:
	                FirefoxOptions firefoxOptions = new FirefoxOptions();
	                return new FirefoxDriver(firefoxOptions);
	            case EDGE:
	                EdgeOptions edgeOptions = new EdgeOptions();
	                return new EdgeDriver(edgeOptions);
	            default:
	                throw new IllegalStateException("Unexpected browser type: " + browserType);
	        }
	    }
	}


}
