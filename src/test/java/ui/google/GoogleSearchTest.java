package ui.google;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import ui.common.AbstractBaseTest;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest extends AbstractBaseTest {
    private final String googleSearchUrl = "https://www.google.com/";
    private final String searchText = "Selenide";

    @Test
    public void checkGoogleSearchResult() {
        Configuration.timeout = 60000;

        open(googleSearchUrl);
        googleSearchPage.clickAcceptCookies();
        googleSearchPage.setValueForInputSearch(searchText);
        googleSearchPage.clickSearchButton();

    }
}
