package automation.example.site.components.search.impl;

import automation.example.site.components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import automation.example.site.components.search.SearchBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

//done
@Component
public class DefaultSearchBar extends AbstractComponent implements SearchBar {

    @FindBy(id="searchbox")
    private WebElement searchBoxRoot;

    @FindBy(id="search_query_top")
    private WebElement searchInput;

    @FindBy(name="submit_search")
    private WebElement submitSearchButton;

    @Override
    public void searchFor(String query){
        this.waitForLoad();
        searchInput.sendKeys(query);
        submitSearchButton.click();
    }

    @Override
    public WebElement getLoadableComponent() {
        return searchBoxRoot;
    }
}


//public class DefaultSearchBar extends AbstractComponent implements SearchBar {
//
//    @FindBy(id="searchbox")
//    private WebElement searchBoxRoot;
//
//    @FindBy(id="search_query_top")
//    private WebElement searchInput;
//
//    @FindBy(name="submit_search")
//    private WebElement submitSearchButton;
//
//    public DefaultSearchBar(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public void searchFor(String query){
//        this.waitForLoad();
//        searchInput.sendKeys(query);
//        submitSearchButton.click();
//    }
//
//    @Override
//    public WebElement getLoadableComponent() {
//        return searchBoxRoot;
//    }
//}