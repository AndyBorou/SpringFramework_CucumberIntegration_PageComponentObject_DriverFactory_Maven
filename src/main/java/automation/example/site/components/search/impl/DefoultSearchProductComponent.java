package automation.example.site.components.search.impl;

import automation.example.spring.SkipInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import automation.example.site.components.AbstractComponent;
import automation.example.site.components.search.SearchProductComponent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

//DONE
@Component
@Scope(SCOPE_PROTOTYPE) // - должно создаватся динмамически в зависимости от того что есть на пейдже что было найдено
@SkipInit // надо что бы по протоапе бинам не отрабатывали постпроцессоры (public class PageInitializationPBB implements BeanPostProcessor)
public class DefoultSearchProductComponent extends AbstractComponent implements SearchProductComponent {

    private static final By PRODUCT_NAME = By.className("product-name");

    private WebElement rootElement;

    // в конструктори принмает рутовый вебкомпоннет на страницу резултата
    public DefoultSearchProductComponent(WebElement element) {
        this.rootElement = element;
    }

    // пoиск нужнгого компонента будет идти с базового компонента need only found product name
    @Override
    public  String getName() {
        this.waitForLoad();
        return getLoadableComponent().findElement(PRODUCT_NAME).getText();
    }

    @Override
    public WebElement getLoadableComponent() {
        return rootElement;
    }
}

//public class DefoultSearchProductComponent extends AbstractComponent implements SearchProductComponent {
//
//    private static final By PRODUCT_NAME = By.className("product-name");
//
//    private WebElement rootElement;
//
//    // в конструктори принмает рутовый вебкомпоннет на страницу резултата
//    public DefoultSearchProductComponent(WebDriver driver, WebElement element) {
//        super(driver);
//        this.rootElement = element;
//    }
//
//    // пoиск нужнгого компонента будет идти с базового компонента need only found product name
//    public String getName() {
//        this.waitForLoad();
//        return getLoadableComponent().findElement(PRODUCT_NAME).getText();
//    }
//
//    @Override
//    public WebElement getLoadableComponent() {
//        return rootElement;
//    }
//}