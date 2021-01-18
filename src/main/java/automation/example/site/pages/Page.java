package automation.example.site.pages;

import automation.example.site.Loadable;

//DOne
public interface Page extends Loadable {

    void openPage();

    String getUrl();

}
