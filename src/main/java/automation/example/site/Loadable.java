package automation.example.site;

import org.openqa.selenium.WebElement;

public interface Loadable {
//done
    WebElement getLoadableComponent();

    boolean isLoaded();

    void waitForLoad();

    //do not use
    void waitForDisappear();
}
