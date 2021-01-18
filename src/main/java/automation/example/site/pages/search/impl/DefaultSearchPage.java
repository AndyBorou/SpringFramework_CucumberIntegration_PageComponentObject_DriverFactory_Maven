package automation.example.site.pages.search.impl;

import automation.example.site.components.search.SearchProductComponent;
import automation.example.site.components.search.impl.DefoultSearchProductComponent;
import automation.example.site.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import automation.example.site.pages.search.SearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;
import java.util.stream.Collectors;

// DONE
@Component
public class DefaultSearchPage extends AbstractPage implements SearchPage {

    @FindBy(id = "search")
    private WebElement rootElement;

    @FindBy(xpath = ".//*[contains(@class, 'product_list')]//*[@class='product-container']")
    private List<WebElement> products;

    @FindBy(xpath = ".//*[contains(@class, 'product_list')]//*[@class='product-container']")
    private WebElement product;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public WebElement getLoadableComponent() {
        return rootElement;
    }


    @Override
    public List<SearchProductComponent> getProducts() {
        this.waitForLoad();
        try {
            waitForLoad(product);
        } catch (TimeoutException e) {

        }
        return products.stream().map(this::mapToComponent).collect(Collectors.toList());
    }

    private SearchProductComponent mapToComponent(WebElement componentRoot) {
        return applicationContext.getBean(SearchProductComponent.class, componentRoot);
    }

    //    "http://automationpractice.com/index.php?"
    public String getUrl() {
        return "http://automationpractice.com/index.php?controller=search";
    }
}

//public class DefaultSearchPage extends AbstractPage implements SearchPage {
//
//    @FindBy(id = "search")
//    private WebElement rootElement;
//
//    @FindBy(xpath = ".//*[contains(@class, 'product_list')]//*[@class='product-container']")
//    private List <WebElement> products;
//
//    public DefaultSearchPage(WebDriver instance) {
//        super(instance);
//    }
//
//    @Override
//    public WebElement getLoadableComponent() {
//        return rootElement;
//    }
//
//    @Override
//    public List<SearchProductComponent> getProducts() {
//        this.waitForLoad();
//        List<SearchProductComponent> productComponents = new ArrayList<>();
//
//        for (WebElement product: products) {
//            productComponents.add(new DefoultSearchProductComponent(driver, product));
//        }
//
//        return productComponents;
//    }
//
//    public String getUrl(){return "http://automationpractice.com/index.php?";}
//}