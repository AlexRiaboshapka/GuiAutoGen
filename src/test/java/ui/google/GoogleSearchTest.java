package ui.google;

import com.codeborne.selenide.Configuration;
import listener.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.common.AbstractBaseTest;

import static com.codeborne.selenide.Selenide.open;
@Listeners(CustomListener.class)
public class GoogleSearchTest extends AbstractBaseTest {
    private final String googleSearchUrl = "https://www.google.com/";
    private final String searchText = "Selenide";
    private final String googleSearchResultText = "Selenide: concise UI tests in Java";

    @Test
    public void checkGoogleSearchResult() {

        open(googleSearchUrl);
        googleSearchPage.clickAcceptCookies();
        googleSearchPage.setValueForInputSearch(searchText);
        googleSearchPage.clickSearchButton();
        googleSearchResultPage.countSearchResults();
        googleSearchResultPage.checkEachSearchResult(googleSearchResultText);
    }
}
