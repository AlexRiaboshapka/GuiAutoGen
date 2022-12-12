package ui.google_sheet;

import helper.GoogleSheetParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.common.AbstractBaseTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSheetTest extends AbstractBaseTest {
    private final String googleSearchUrl = "https://www.google.com/";
    private final String sheetId = "1aVKQ3hIoOupx685h1NgunO4w_wMnVJofu4Mr5MKxYR0";
    private final String range = "Sheet1!A2:B10";

    @BeforeMethod
    public void setUp() {
        open(googleSearchUrl);
        googleSearchPage.clickAcceptCookies();
    }

    @DataProvider
    public Iterator<Object[]> testData() {
        ArrayList<Object[]> arrayList = new ArrayList<>();
        List<List<Object>> lists = GoogleSheetParser.getGoogleSheetValue(sheetId, range);
        for (List<Object> list :
                Objects.requireNonNull(lists)) {
            Object[] objects = list.toArray();
            arrayList.add(objects);
        }
        return arrayList.iterator();
    }

    @Test(dataProvider = "testData")
    public void checkGoogleSearchResult(String searchText, String googleSearchResultText) {
        googleSearchPage.setValueForInputSearch(searchText);
        googleSearchPage.clickSearchButton();
        googleSearchResultPage.countSearchResults();
        googleSearchResultPage.checkEachSearchResult(googleSearchResultText);
    }

}
