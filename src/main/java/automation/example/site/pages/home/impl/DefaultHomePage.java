package automation.example.site.pages.home.impl;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import automation.example.site.components.search.SearchBar;
//import automation.example.site.components.search.impl.DefaultSearchBar;
import automation.example.site.pages.AbstractPage;
import automation.example.site.pages.home.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//DOne
@Component
public class DefaultHomePage extends AbstractPage implements HomePage {

    @FindBy(id="home-page-tabs")
    private WebElement homePageTabs;

    @Autowired
    private SearchBar searchBar;

    @Override
    public WebElement getLoadableComponent (){
        return homePageTabs;
    }

    @Override
    public String getUrl(){
        return "http://automationpractice.com/index.php";
    }

    public SearchBar getSearchBar() {
        this.waitForLoad();
        return searchBar;
    }
}


//public class DefaultHomePage extends AbstractPage implements HomePage {
//
//    @FindBy(id="home-page-tabs")
//    private WebElement homePageTabs;
//
//
//    private SearchBar searchBar;
//
//    public DefaultHomePage(WebDriver driver) {
//        super(driver);
//        searchBar = new DefaultSearchBar(driver);
//    }
//
//    @Override
//    public WebElement getLoadableComponent (){
//        return homePageTabs;
//    }
//
//    public String getUrl(){
//        return "http://automationpractice.com/index.php";
//    }
//
//    public SearchBar getSearchBar() {
//        this.waitForLoad();
//        return searchBar;
//    }
//}