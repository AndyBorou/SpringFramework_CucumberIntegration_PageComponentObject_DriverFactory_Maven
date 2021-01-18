package automation.example.site;

import automation.example.framework.driver.DriverProvider;
import io.vavr.control.Try;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractLoadable implements Loadable {
    //done
    @Autowired
    protected DriverProvider driverProvider;

    private static final long DEFAULT_TIMEOUT = 10;
    private static final long SHORT_TIMEOUT = 2;

    public boolean isLoaded() {
        return Try.of(() -> getDriverWait(SHORT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getLoadableComponent()))).isSuccess();
    }

    public void waitForLoad() {
        getDriverWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getLoadableComponent()));
    }

    public void waitForLoad(WebElement element) throws TimeoutException {
        getDriverWait(SHORT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForDisappear() {
        getDriverWait(DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOf(getLoadableComponent()));
    }


    private FluentWait<WebDriver> getDriverWait(long timeout) {
        return new WebDriverWait(driverProvider.getInstance(), timeout);
    }
}

//public abstract class AbstractLoadable implements Loadable {
//
//    private static final long DEFAULT_TIMEOUT = 10;
//    private static final long SHORT_TIMEOUT = 2;
//
//    public static WebDriver driver;
//
//    public AbstractLoadable(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//    }
//
//    public boolean isLoaded() {
//        return Try.of(() -> getDriverWait(SHORT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getLoadableComponent()))).isSuccess();
//    }
//
//    public void waitForLoad() {
//        getDriverWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(getLoadableComponent()));
//    }
//
//    public void waitForDisappear() {
//        getDriverWait(DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOf(getLoadableComponent()));
//    }
//
//
//    private FluentWait<WebDriver> getDriverWait(long timeout) {
//        return new WebDriverWait(driver, timeout).pollingEvery(500, TimeUnit.MILLISECONDS);
//    }
//}
