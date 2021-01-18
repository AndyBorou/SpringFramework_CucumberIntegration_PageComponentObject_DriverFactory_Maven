package automation.stepDefs;

import automation.example.framework.driver.DriverProvider;
import automation.example.spring.ApplicationConfig;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import automation.example.site.pages.home.HomePage;
import automation.example.site.pages.home.impl.DefaultHomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

//DONE

@ContextConfiguration(classes = ApplicationConfig.class)
public class HomePageStepDefs {

    @Autowired
    private DriverProvider driverProvider;

    @Autowired
    private HomePage homePage;

    @Given("^Customer opens Home page$")
    public void customerOpensHomePage() {
        homePage.openPage();
    }

    @When("^Customer searches for \"([^\"]*)\" item$")
    public void customerSearchForItem(String searchQuery) {
        homePage.getSearchBar().searchFor(searchQuery);
    }

//    @After()
//    public void closeBrowser() {
//        driverProvider.getInstance().quit();
//    }

}

//public class HomePageStepDefs {
//    private HomePage homePage = new DefaultHomePage(DriverProvider.getInstance());
//
//    @Given("^Customer opens Home page$")
//    public void customerOpensHomePage(){
//        homePage.openPage();
//    }
//
//    @When("^Customer searches for \"([^\"]*)\" item$")
//    public void customerSearchForItem (String searchQuery) {
//        homePage.getSearchBar().searchFor(searchQuery);
//    }
//}