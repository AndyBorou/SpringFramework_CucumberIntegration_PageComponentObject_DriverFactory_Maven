package automation.example.site.pages.search;

import automation.example.site.components.search.SearchProductComponent;
import automation.example.site.pages.Page;

import java.util.List;

public interface SearchPage  extends Page {

    List<SearchProductComponent> getProducts();
}
