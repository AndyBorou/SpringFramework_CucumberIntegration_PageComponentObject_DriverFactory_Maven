package automation.stepDefs;

//import automation.example.framework.driver.DriverProvider;
import automation.example.site.components.search.SearchProductComponent;
//import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.extractProperty;

import automation.example.site.pages.search.SearchPage;
//import automation.example.site.pages.search.impl.DefaultSearchPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

//import static org.assertj.core.api.Assertions.assertThat;


public class SearchResaltsPageStepDefs {

    @Autowired
    private SearchPage searchPage;

    @Then("^SearchResults page is opened$")
    public void searchResultsPageIsOpened() {
        assertThat(searchPage.isLoaded()).isTrue();
    }

    @Then("^Valid search results are displayed for query \"([^\"]*)\" on SearchResults page$")
    public void validSearchResultsAreDisplayedDorQueryOnSearchResultPage(String product){
        System.out.println("size: " + searchPage.getProducts());
        assertThat(searchPage.getProducts()).extracting(SearchProductComponent::getName)
                .anySatisfy(productName -> StringUtils.containsIgnoreCase(productName, product));
    }

    @Then("^No results are displayed on SearchResults page$")
    public void noResultsAreDisplayedOnSearchResultsPage(){
        assertThat(searchPage.getProducts().size()).isEqualTo(0);
    }
}


//public class SearchResaltsPageStepDefs {
//
//    private SearchPage searchPage = new DefaultSearchPage(DriverProvider.getInstance());
//
//    @Then("^SearchResults page is opened$")
//    public void searchResultsPageIsOpened() {
//        assertThat(searchPage.isLoaded()).isTrue();
//    }
//
//    @Then("^Valid search results are displayed for query \"([^\"]*)\" on SearchResults page$")
//    public void validSearchResultsAreDisplayedDorQueryOnSearchResultPage(String product){
//        searchPage.getProducts();
//        assertThat(searchPage.getProducts()).extracting(SearchProductComponent::getName)
//                .anySatisfy(productName -> StringUtils.containsIgnoreCase(productName, product));
//    }
//
//    @Then("^No results are displayed on SearchResults page$")
//    public void noResultsAreDisplayedOnSearchResultsPage(){
//        assertThat(searchPage.getProducts().size()).isEqualTo(0);
//    }
//}