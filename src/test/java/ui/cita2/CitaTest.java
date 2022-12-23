package ui.cita2;

import helper.GoogleSheetParserNew;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.common.AbstractBaseTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class CitaTest extends AbstractBaseTest {
    public final String url = "https://icp.administracionelectronica.gob.es/icpco/citar?p=3&locale=es";
    private final String sheetId = "1aVKQ3hIoOupx685h1NgunO4w_wMnVJofu4Mr5MKxYR0";
    private final String range = "Sheet1!A2:B5";

    @BeforeClass
    public void setUp() {
        open(url);
    }

    @DataProvider
    public Iterator<Object[]> testData() {
        ArrayList<Object[]> arrayList = new ArrayList<>();
        List<List<Object>> lists = GoogleSheetParserNew.getGoogleSheetValue(sheetId, range);
        for (List<Object> list :
                Objects.requireNonNull(lists)) {
            Object[] objects = list.toArray();
            arrayList.add(objects);
        }
        return arrayList.iterator();
    }

    @Test(dataProvider = "testData")
    public void testCitaIsAvailable(String nie, String name) {
        citaPrevia.selectCitaTypeAndAccept();
        citaPrevia.clickEnterButton();
        citaPrevia.inputNieAndClickAccept(nie, name);
        citaPrevia.clickEnterButton2();
        citaPrevia.getCitaInfo();
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}

