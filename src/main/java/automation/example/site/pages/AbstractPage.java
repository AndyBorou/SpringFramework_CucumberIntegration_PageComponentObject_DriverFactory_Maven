package automation.example.site.pages;

import automation.example.site.AbstractLoadable;
import org.openqa.selenium.WebDriver;

//import static automation.example.site.pages.home.impl.DefaultHomePage.getUrl;

//DONE
public abstract class AbstractPage extends AbstractLoadable implements Page {

    public void openPage(){
        driverProvider.getInstance().get(getUrl());
    }
}


//public abstract class AbstractPage extends AbstractLoadable implements Page {
//
////    DONE
//
//    public AbstractPage(WebDriver driver){
//        super(driver);
//    }
//
//    @Override
//    public void openPage(){
//        driver.get(getUrl());
//    }
//}