package automation.example.framework.driver.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;


//DONE
public class DriverFactory {

    public static WebDriver getDriver(DesiredCapabilities capabilities){

        switch (capabilities.getBrowserName().toUpperCase()){
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                return new FirefoxDriver(capabilities);

            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
 //               return new ChromeDriver(capabilities);
           return new ChromeDriver();

//            ChromeOptions options = new ChromeOptions();
//            options.setCapability("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//            return new ChromeDriver(options);

            default:
                throw new IllegalArgumentException("Invalid browser name: " + capabilities.getBrowserName());

        }

    }
}
