package automation.example.site.pages.home;

import automation.example.site.components.search.SearchBar;
import automation.example.site.pages.Page;

public interface HomePage extends Page {

    void openPage();

    SearchBar getSearchBar();
}
