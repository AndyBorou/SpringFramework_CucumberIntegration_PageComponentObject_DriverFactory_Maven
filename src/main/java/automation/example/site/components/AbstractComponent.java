package automation.example.site.components;

import automation.example.site.AbstractLoadable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//done
public abstract class AbstractComponent extends AbstractLoadable implements Component {

}


//public abstract class AbstractComponent extends AbstractLoadable implements Component {
//
//    public AbstractComponent(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//
//    }
//
//}