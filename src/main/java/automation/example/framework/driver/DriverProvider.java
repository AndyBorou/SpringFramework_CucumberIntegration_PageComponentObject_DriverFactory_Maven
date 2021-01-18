package automation.example.framework.driver;


import automation.example.framework.driver.impl.DriverFactory;
import automation.example.framework.properties.PropertyResolver;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//DONE
@Component

//@Scope - что бы обект был prototipe

@Configuration
public class DriverProvider {

    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    public WebDriver getInstance() {

        if (driverInstance.get() == null) {
            // get browser name from property file
            final String browserName = PropertyResolver.getProperty(PropertyResolver.BROWSER_NAME);
            // create need capability
//            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities(browserName, "81", Platform.WIN10);
            // set driver in ThreadLocal
            driverInstance.set(DriverFactory.getDriver(desiredCapabilities));
        }
        return driverInstance.get();
    }
}

//old stile
//public class DriverProvider {
//
//    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();
//
//    public static WebDriver getInstance() {
//        if (driverInstance.get() == null) {
//            // get browser name from property file
//            final String browserName = PropertyResolver.getProperty(PropertyResolver.BROWSER_NAME);
//            // create need capability
////            DesiredCapabilities desiredCapabilities = //new DesiredCapabilities();
//            DesiredCapabilities desiredCapabilities =   new DesiredCapabilities(browserName, "79", Platform.WIN10);
//
//            // set driver in ThreadLocal
//            driverInstance.set(DriverFactory.getDriver(desiredCapabilities));
//        }
//        return driverInstance.get();
//    }
//}