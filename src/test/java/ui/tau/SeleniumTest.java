package ui.tau;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class SeleniumTest {

    @BeforeTest
    public void setUp() {
        open("https://www.google.com");
        $(byXpath("//button[@id='L2AGLb']")).click();
    }

    @Test
    public void openGoogleAndSearch() {
        @SuppressWarnings("SpellCheckingInspection") String expectedTitle = "Selenide - Buscar con Google";
        SelenideElement searchInput = $(byXpath("//input[@name='q']"));
        searchInput.sendKeys("Selenide");
        searchInput.pressEnter();
        assertEquals(expectedTitle, title(), "Title is not correct current " + title() + " expected " + expectedTitle);
    }

    @AfterTest
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
